package portfolio.one.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardVO> selectBoardList() throws Exception {
        return boardRepository.selectBoardList();
    }

    public BoardVO selectBoardDetail(int boardIdx) throws Exception {
        return boardRepository.selectBoardDetail(boardIdx);
    }

    public void insertBoard(BoardVO board) {
        boardRepository.insertBoard(board);
    }

    public void updateBoard(BoardVO board) {
        boardRepository.updateBoard(board);
    }

    public void updateHitCnt(int boardIdx) {
        boardRepository.updateHitCnt(boardIdx);
    }

    public void deleteBoard(int boardIdx) {
        boardRepository.deleteBoard(boardIdx);
    }
}
