package io.ltebean.account.service;

import io.ltebean.account.api.AccountService;
import io.ltebean.account.dto.UserDTO;
import io.ltebean.account.mapper.UserMapper;
import io.ltebean.account.model.User;
import io.ltebean.photo.api.PhotoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ltebean on 16/4/1.
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PhotoService photoService;

    @Override
    public UserDTO getTestUser() {
        User user = userMapper.selectById(23);
        System.out.println(photoService.getPhoto());
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
