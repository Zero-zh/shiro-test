package com.graduate.loyee.vo;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginUserVo {
    @NotBlank(message = "帐号不能为空")
    private String Account;

    @NotBlank(message = "密码不能为空")
    private String password;
}
