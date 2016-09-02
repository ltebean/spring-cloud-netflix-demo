package io.ltebean.account.api;

/**
 * Created by ltebean on 16/4/1.
 */

import io.ltebean.account.dto.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "accountService")
public interface AccountService {

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public UserDTO getTestUser();

}
