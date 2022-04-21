package portfolio.one.login.service;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginVO {

    @NotEmpty
    private String loginId; // 로그인 ID

    @NotEmpty
    private String password; // 패스워드


}
