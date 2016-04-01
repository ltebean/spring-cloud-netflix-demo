package io.ltebean.account.server.service;

import io.ltebean.account.api.AccountService;
import io.ltebean.account.dto.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ltebean on 16/4/1.
 */

@RestController
public class AccountServiceImpl implements AccountService {

    @Override
    public User getTestUser() {
        return new User();
    }
}
