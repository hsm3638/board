package portfolio.one;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import portfolio.one.member.service.MemberVO;
import portfolio.one.member.service.MemberRepository;
import portfolio.one.config.session.SessionConst;

@Slf4j
@Controller
@RequiredArgsConstructor
public class homeController {

    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) MemberVO memberVO, Model model) {
        if (memberVO == null) {
            return "home";
        }

        model.addAttribute("member", memberVO);
        return "login/loginHome";

    }

}
