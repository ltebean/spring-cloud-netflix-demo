package io.ltebean.account.mapper;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.ltebean.account.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by leo on 16/7/28.
 */
@Mapper
public interface UserMapper  {

    public User selectById(@Param("userId") long userId);

}
