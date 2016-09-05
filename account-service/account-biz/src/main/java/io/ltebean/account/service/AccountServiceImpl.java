package io.ltebean.account.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.ltebean.account.api.AccountService;
import io.ltebean.account.dto.UserDTO;
import io.ltebean.account.mapper.UserMapper;
import io.ltebean.account.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ltebean on 16/4/1.
 */

@RestController
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO getTestUser() {
        User user = userMapper.selectById(23);
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public UserDTO emptyUser() {
        return null;
    }
}
