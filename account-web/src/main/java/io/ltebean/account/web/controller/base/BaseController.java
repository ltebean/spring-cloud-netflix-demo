package io.ltebean.account.web.controller.base;

import io.ltebean.account.dto.UserDTO;
import io.ltebean.account.web.constant.AttributeConstant;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by leo on 16/6/13.
 */
@RequestMapping(value = "/api")
public class BaseController {

    @ModelAttribute(AttributeConstant.USER)
    protected UserDTO getUser(HttpServletRequest request) {
        return (UserDTO) request.getAttribute(AttributeConstant.USER);
    }
}
