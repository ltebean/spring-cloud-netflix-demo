package io.ltebean.account.service;

import io.ltebean.account.api.AccountService;
import io.ltebean.account.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ltebean on 16/4/1.
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public User getTestUser() {
        return new User();
    }
}
