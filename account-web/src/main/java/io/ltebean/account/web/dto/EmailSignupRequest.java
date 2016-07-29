package io.ltebean.account.web.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;



/**
 * Created by leo on 16/6/7.
 */
public class EmailSignupRequest {

    @NotEmpty
    @Email
    public String email;

    @NotEmpty
    @Length(min = 1, max = 20)
    public String password;

}
