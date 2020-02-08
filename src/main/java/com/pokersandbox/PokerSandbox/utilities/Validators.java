package com.pokersandbox.PokerSandbox.utilities;

import com.pokersandbox.PokerSandbox.models.dto.EmailValidatorAPI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Validators {

    //A password must pass the regex which include a lowercase uppercase number and a symbol
    public static Boolean validatePassword(String password){
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
    /*
        Check if emails valid
        calls getValidatorResponse() to get response from API and returns the response Object
     */
    public static Boolean validateEmail(String email)  {
        EmailValidatorAPI checkEmail = Validators.getValidatorReponse(email);
        Boolean checker = false;

        if(checkEmail.getFormat_valid().equals(true) &&
                checkEmail.getMx_found().equals(true) &&
                checkEmail.getRole().equals(false) &&
                checkEmail.getDisposable().equals(false))
            checker = true;

        return checker;
    }

    public static EmailValidatorAPI getValidatorReponse(String email){
        final String url = "http://apilayer.net/api/check";
        final String api_access_key = "569795e7bf983ba67cf50b1a6963da2a";

        RestTemplate template = new RestTemplate();

        return template.getForObject(url + "?access_key=" + api_access_key + "&email=" + email, EmailValidatorAPI.class);
    }

}
