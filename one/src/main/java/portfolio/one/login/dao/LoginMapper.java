package portfolio.one.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import portfolio.one.login.service.LoginVO;
import portfolio.one.member.service.MemberVO;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {

    List<MemberVO> findAll();

}
