package io.ltebean.account.web.interceptor;

import io.ltebean.account.api.AccountService;
import io.ltebean.account.dto.User;
import io.ltebean.account.web.annotation.LoginRequired;
import io.ltebean.account.web.constant.AttributeConstant;
import io.ltebean.account.web.constant.HeaderConstant;
import io.ltebean.account.web.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Order(1)
public class UserInterceptor implements HandlerInterceptor {


    Logger logger = LoggerFactory.getLogger(UserInterceptor.class);


    @Autowired
    private AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // get user token from request header
        String token = request.getHeader(HeaderConstant.USER_TOKEN);

        User user = null;
        if (token != null) {
            // find user by token, put the user in request attribute
            user = new User();
            request.setAttribute(AttributeConstant.USER, new User());
        }

        // check whether the controller method is annotated with LoginRequired
        if (user == null) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.getMethod().isAnnotationPresent(LoginRequired.class) ||
                    handlerMethod.getMethod().getDeclaringClass().isAnnotationPresent(LoginRequired.class)) {
                throw new UnauthorizedException();
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
