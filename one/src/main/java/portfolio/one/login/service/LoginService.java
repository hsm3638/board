package portfolio.one.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portfolio.one.member.service.MemberRepository;
import portfolio.one.member.service.MemberVO;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;
    private final MemberRepository memberRepository;

    public MemberVO login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }

}
