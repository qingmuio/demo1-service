package io.qingmu.demo1;

import io.gd.generator.annotation.Field;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCreateDto {

    @Field(label = "用户名")
    private String username;
    @Field(label = "密码")
    private String password;
}
