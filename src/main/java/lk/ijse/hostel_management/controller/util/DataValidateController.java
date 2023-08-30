package lk.ijse.hostel_management.controller.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DataValidateController {
    public static boolean emailCheck(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean contactCheck(String contact) {
        String contactRegex = "^(?:7|0|(?:\\\\\\\\+94))[0-9]{9,10}$";
        Pattern pattern = Pattern.compile(contactRegex);
        Matcher matcher = pattern.matcher(contact);
        return matcher.matches();
    }

    public static boolean studentIdValidate(String id) {
        String customerRegex = "^(S)[0-9]{3}$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static boolean nameValidate(String custName) {
        String customerRegex = "^[A-z\\s]{4,15}$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(custName);
        return matcher.matches();
    }


    public static boolean addressValidate(String address) {
        String customerRegex = "[A-z @ 0-9]{4,20}";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }


    public static boolean roomIdValidate(String id) {
        String customerRegex = "^(R)[0-9]{3}$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static boolean quantityValidate(String quantity) {
        String customerRegex = "^[1-9][0-9]*$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(quantity);
        return matcher.matches();
    }

    public static boolean priceValidate(String price) {
        String customerRegex = "^[1-9][0-9]*(.[0-9]{2})?$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(price);
        return matcher.matches();
    }
    public static boolean salaryIdValidate(String custId) {
        String customerRegex = "^(S)[0-9]{3}$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(custId);
        return matcher.matches();
    }

    public static boolean empIdValidate(String custId) {
        String customerRegex = "^(E)[0-9]{3}$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(custId);
        return matcher.matches();
    }

    public static boolean nicValidate(String custId) {
        String customerRegex = "^([0-9]{9}[x|X|v|V]|[0-9]{12})$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(custId);
        return matcher.matches();
    }

    public static boolean eventIdValidate(String custId) {
        String customerRegex = "^(E)[0-9]{3}$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(custId);
        return matcher.matches();
    }

    public static boolean passwordValidate(String password) {
        String customerRegex = "^(?=.?[A-Z])(?=.?[a-z])(?=.?[0-9])(?=.?[#?!@$ %^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(customerRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


}
