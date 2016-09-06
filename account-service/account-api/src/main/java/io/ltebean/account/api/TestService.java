package io.ltebean.account.api;

import io.ltebean.account.dto.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by leo on 16/9/6.
 */

@FeignClient(name = "account-service")
public interface TestService {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String getTestString();

}
