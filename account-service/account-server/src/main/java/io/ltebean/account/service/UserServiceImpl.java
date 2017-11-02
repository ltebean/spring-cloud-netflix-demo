package io.ltebean.account.service;

import io.ltebean.account.api.UserService;
import io.ltebean.account.dto.UserDTO;
import io.ltebean.account.mapper.UserMapper;
import io.ltebean.account.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ltebean on 16/4/1.
 */

@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO getTestUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.id = 3000;
        try {
            userDTO.name = InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
        return userDTO;
    }

}
