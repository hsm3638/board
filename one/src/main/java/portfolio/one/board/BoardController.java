package portfolio.one.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import portfolio.one.board.service.BoardVO;
import portfolio.one.member.service.MemberVO;
import portfolio.one.config.session.SessionConst;
import portfolio.one.board.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boardList.do") // 게시판 리스트
    public ModelAndView boardList(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) MemberVO memberVO) throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardList");
        List<BoardVO> list = boardService.selectBoardList();
        mv.addObject("list", list);
        mv.addObject("member", memberVO);
        return mv;
    }

    @GetMapping("/boardWrite.do") // 게시글 작성 화면
    public String boardWrite(@ModelAttribute("board") BoardVO board) throws Exception {
        return "board/boardWrite";
    }

    @PostMapping("/insertBoard.do") // 게시글 작성
    public String insertBoard(@Validated @ModelAttribute BoardVO board, BindingResult bindingResult, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        MemberVO memberVO = (MemberVO) session.getAttribute(SessionConst.LOGIN_MEMBER);

        if (bindingResult.hasErrors()) {
            return "board/boardWrite";
        }
        // 세션에 저장된 사용자 이름을 등록자에 저장
        board.setCreatorId(memberVO.getName());
        boardService.insertBoard(board);
        return "redirect:/board/boardList.do";
    }

    @GetMapping("/boardDetail.do") // 상세화면
    public String boardDetail(@RequestParam("boardIdx") int boardIdx, @ModelAttribute BoardVO board, HttpServletRequest request, Model model) throws Exception {
        MemberVO memberVO = memberCall(request);
        // 조회수 증가
        boardService.updateHitCnt(boardIdx);

        // 상세 정보 찾기
        board = boardService.selectBoardDetail(boardIdx);

        if (!memberVO.getName().equals(board.getCreatorId())) {
            log.info("회원 정보 불일치");
            board.setUpdateYn(true);
        } else {
            log.info("회원 정보 일치");
            board.setUpdateYn(false);
        }

        model.addAttribute("list", board);

        return "/board/boardDetail";
    }

    @GetMapping("/updateBoard.do") // 게시글 수정
    public String updateBoard(@Validated @ModelAttribute BoardVO board, BindingResult bindingResult, HttpServletRequest request, Model model) {
        MemberVO memberVO = memberCall(request);
        int boardIdx = board.getBoardIdx();
        if (!memberVO.getName().equals(board.getCreatorId())) {
            log.info("회원 정보 불일치");
            bindingResult.addError(new FieldError("creatorId", "creatorId", "작성"));
        } else {
            log.info("회원 정보 일치");
            boardService.updateBoard(board);
        }

        if (bindingResult.hasErrors()) {
            log.info("수정 X - 회원 정보 불일치");
            return "redirect:/board/boardDetail.do?boardIdx=" + boardIdx;
        }
        log.info("수정 완료");
        return "redirect:/board/boardList.do";
    }

    @GetMapping("/deleteBoard.do") // 게시글 삭제
    public String deleteBoard(@ModelAttribute BoardVO board) {
        log.info("[delete] board = {}", board);
        int boardIdx = board.getBoardIdx();
        boardService.deleteBoard(boardIdx);
        return "redirect:/board/boardList.do";
    }

    // 로그인한 사용자 ID 호출
    private MemberVO memberCall(HttpServletRequest request) {

        HttpSession session = request.getSession();
        MemberVO memberVO = (MemberVO) session.getAttribute(SessionConst.LOGIN_MEMBER);
        return memberVO;
    }

}
