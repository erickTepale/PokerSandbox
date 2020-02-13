package com.pokersandbox.PokerSandbox.utilities;

import com.pokersandbox.PokerSandbox.models.dao.EmailValidatorAPI;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("static-access")
public class ValidatorsTest {

    @Test
    public void validate_password_test(){
        /**
            password_1 contains only lowercase => fails
            password_2 contains uppercase and lowercase => fails
            password_3 contains uppercase, lowercase, and number => fails
            password_4 contains uppercase, lowercase, number, and symbol => passes
         */

        //given
        String password_1 = "chung";
        String password_2 = "Chung";
        String password_3 = "Chung01";
        String password_4 = "Chung001.";

        //then
        Assert.assertFalse(Validators.validatePassword(password_1));
        Assert.assertFalse(Validators.validatePassword(password_2));
        Assert.assertFalse(Validators.validatePassword(password_3));

        Assert.assertTrue(Validators.validatePassword(password_4));
    }

    @Test
    public void validate_email_API_response_test(){
        //checks if API returns a response

        String email = "arguello.chung@gmail.com";
        EmailValidatorAPI object = Validators.getValidatorReponse(email);

        Assert.assertNotNull(object);
    }

    @Test
    public void validate_email_test(){
        /**
            email_1 is a valid email passes
            email_2 is a valid email passes
            email_3 is not valid email fails
         */

        //given
        String email_1 = "arguello.chung@gmail.com";
        String email_2 = "arguello.chung.dev@gmail.com";
        String email_3 = "chucv342csdvhgssfk@i434fsdfsd.com";

        //then
        Assert.assertTrue(Validators.validateEmail(email_1));
        Assert.assertTrue(Validators.validateEmail(email_2));

        Assert.assertFalse(Validators.validateEmail(email_3));
    }
}
