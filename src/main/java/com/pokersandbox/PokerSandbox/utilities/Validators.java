package com.pokersandbox.PokerSandbox.utilities;

import com.pokersandbox.PokerSandbox.models.User;
import com.pokersandbox.PokerSandbox.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    // CHecks to see if its a valid email
    public static Boolean validateEmail(String email){
        String regex = " ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

}
