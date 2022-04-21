package portfolio.one.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import portfolio.one.member.service.MemberService;
import portfolio.one.member.service.MemberVO;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") MemberVO memberVO) {
        log.info("GET /add");
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute("member") MemberVO memberVO, BindingResult result) {
        log.info("Post /add");

        int chkId = 0;

        chkId = memberService.checkMember(memberVO);

        if (chkId == 1) {
            log.info("중복 O");
            result.addError(new FieldError("loginId", "loginId", "중복된 아이디입니다."));
        } else if(chkId == 0) {
            log.info("중복 X");
            memberService.save(memberVO);
        }

        if (result.hasErrors()) {
            log.info("result.hasErrors()");
            return "members/addMemberForm";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm() {
        return null;
    }
}
