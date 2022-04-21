package portfolio.one.login.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import portfolio.one.login.dao.LoginMapper;
import portfolio.one.member.service.MemberVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LoginRepository {

    private final LoginMapper loginMapper;

    public Optional<MemberVO> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<MemberVO> findAll() {
        return new ArrayList<>(loginMapper.findAll());
    }



}
