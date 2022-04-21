package portfolio.one.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import portfolio.one.member.dao.MemberMapper;

import java.util.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberMapper memberMapper;
    private static long sequence = 0L;

    public MemberVO save(MemberVO memberVO) {
        log.info("save: member={}", memberVO);
        memberMapper.save(memberVO);
        return memberVO;
    }

    public int checkMember(MemberVO memberVO) {
        log.info("checkMember: member={}", memberVO);
        int chk = memberMapper.checkMember(memberVO);
        return chk;
    }

    public MemberVO findById(Long id) {
        return memberMapper.findById(id);
    }

    public Optional<MemberVO> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<MemberVO> findAll() {
        return new ArrayList<>(memberMapper.findAll());
    }



}
