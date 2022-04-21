package portfolio.one.member.service;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberVO {

    private int id;

    @NotEmpty
    private String loginId; // 로그인 ID

    @NotEmpty
    private String name; // 사용자 이름

    @NotEmpty
    private String password; // 패스워드

}
