package com.pokersandbox.PokerSandbox.utilities;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("static-access")
public class ValidatorsTest {

    @Test
    public void validate_password_test(){
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
}
