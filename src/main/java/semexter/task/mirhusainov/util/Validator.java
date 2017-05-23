package semexter.task.mirhusainov.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import semexter.task.mirhusainov.service.UserService;

/**
 * Created by Ruslan on 23.05.2017.
 */
@Component
public class Validator {

    @Autowired
    private UserService userService;
    private static final String SYMBOLS_REGEX = ".*[^а-яА-Яa-zA-Z\\S]+.*";

    private boolean isEmpty(String s){
        if (s == null || s.equals("")){
            return true;
        }
        return false;
    }

    private boolean containsSym(String s){
        if (!s.matches(SYMBOLS_REGEX)){
            return false;
        }
        return true;
    }

    public void isRegistrationValid(String login, String pass, String confirm) throws Exception {
        if (!pass.equals(confirm)){
            throw new Exception("passwords doesn't match");
        }
        if (isEmpty(login) || isEmpty(pass) || isEmpty(confirm)){
            throw new Exception("fields must be not empty");
        }
        if (containsSym(login) || pass.contains(" ")){
            throw new Exception("fields contains unacceptable symbols");
        }
        if (userService.getByLogin(login) != null){
            throw new Exception("user with that login is already exists");
        }
    }

    public void isAuthValid(String login, String pass) throws Exception {
        if (isEmpty(login) || isEmpty(pass)){
            throw new Exception("fields must be not empty");
        }
        if (userService.getByLogin(login) == null){
            throw new Exception("there are no login like that");
        }
        if (!userService.getByLogin(login).getPassword().equals(pass)){
            throw new Exception("incorrect password");
        }
    }

    public void isCarFormValid(String mark,String year,String mileage,String enginePower,String costPerHour){

    }

    public void isRentFormValid(String fullName, String number , String model , String deliveryDate, String returnDate){

    }

}
