package io.ltebean.account.service;

import io.ltebean.account.api.TestService;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leo on 16/9/6.
 */

@RestController
public class TestServiceImpl implements TestService {
    @Override
    public String getTestString() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test";
    }
}
