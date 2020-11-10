package com.graduate.loyee.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RegisterUserVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotBlank(message = "手机号不能为空")
    private String tel;
//    @NotBlank(message = "密码不能为空")
//    private String password;

    private String sex;

    @Email(message = "邮箱格式不正确")
    private String email;
}
