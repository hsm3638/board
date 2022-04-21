package portfolio.one.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import portfolio.one.member.service.MemberVO;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {

    void save(MemberVO memberVO);

    MemberVO findById(Long id);

    List<MemberVO> findAll();

    int checkMember(MemberVO memberVO);
}
