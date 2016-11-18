package io.ltebean.account.web.controller;

import io.ltebean.account.api.TestService;
import io.ltebean.account.api.UserService;
import io.ltebean.account.dto.UserDTO;
import io.ltebean.account.web.constant.AttributeConstant;
import io.ltebean.account.web.dto.EmailSignupRequest;
import io.ltebean.account.web.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.ltebean.account.web.controller.base.BaseController;


@RestController
public class AccountController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    TestService testService;

    @RequestMapping("/v1/test")
    public Response test() {
        return new Response(testService.getTestString());
    }

    @RequestMapping("/v1/user/test")
    public Response getTestUser() {
        UserDTO user = userService.getTestUser();
        user.name = testService.getTestString();
        return new Response(user);
    }

    @RequestMapping("/v1/user")
    public Response getUser(@ModelAttribute(AttributeConstant.USER)UserDTO user) {
        return new Response(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/v1/user/email_signup")
    public Response emailSignup(@RequestBody @Validated EmailSignupRequest request) {
        return new Response("success");
    }

}