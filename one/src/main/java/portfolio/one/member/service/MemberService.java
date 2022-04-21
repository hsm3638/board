package portfolio.one.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portfolio.one.board.service.BoardRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public int checkMember(MemberVO memberVO) {
        return memberRepository.checkMember(memberVO);
    }

    public void save(MemberVO memberVO) {
        memberRepository.save(memberVO);
    }
}
