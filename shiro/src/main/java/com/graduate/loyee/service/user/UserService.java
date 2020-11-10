package com.graduate.loyee.service.user;


import com.graduate.loyee.entity.User;
import com.graduate.loyee.mapper.user.UserMapper;
import com.graduate.loyee.vo.RegisterUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean findUser(String tel) {

        if(userMapper.findUserByPhone(tel) > 0){
            return true;
        }
            return false;
    }

    public void register(RegisterUserVo vo) {
        userMapper.register(vo);
    }

    public User queryByName(String name){
        return userMapper.queryByName(name);
    }

}
