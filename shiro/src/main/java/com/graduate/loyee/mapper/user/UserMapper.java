package com.graduate.loyee.mapper.user;

import com.graduate.loyee.entity.User;
import com.graduate.loyee.vo.RegisterUserVo;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    int findUserByPhone(String tel);
    void register(RegisterUserVo vo);

    User queryByName(String name);
}
