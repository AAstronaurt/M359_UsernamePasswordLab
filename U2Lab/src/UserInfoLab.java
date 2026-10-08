import java.util.Scanner;

public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        Scanner scan = new Scanner(System.in);
        // Ask the user to enter their first and last name and pass these
        System.out.println("Enter your first name");
        String userFirstName = scan.next();
        System.out.println("Enter your last name");
        String userLastName = scan.next();
        // values to the generateUsername method and save the returned result.
        System.out.println(generateUsername(userFirstName, userLastName));

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        System.out.println("Enter a password");
        String userPass = scan.next();
        // The validatePassword method will check if the password meets the criteria:
        System.out.println(validatePassword(userPass));

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        if(validatePassword(userPass) == true){
            System.out.println("Enter your credit card number");
        }
        String userCredit = scan.next();
        System.out.println(maskCreditCard(userCredit));
        // credit card number and pass this value to the maskCreditCard method.

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output

        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username
        String result = "";
        if(firstName.length() <= 2){
            result += firstName;
        }
        else{
            result += firstName.substring(0, 3);
        }

        if(lastName.length() <= 2){
            result += lastName;
        }
        else{
            result += lastName.substring(0, 3);
        }
        return result;
    }
    public static boolean validatePassword(String password) {
        // Fill in this method and return true/false if the password is valid
        // check if the length is greater than 8
        if(password.length() >= 8){
            String allUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for(int i = 0; i < password.length(); i++){
                // check if one of the letters is a capital letter
                if(password.substring(i).equals(allUpperCase.substring(i))){
                    // so um this probably dont work... but we want to check if the current letter is a capital letter
                    // oh and you can maybe have a variable that is equal to something that you check in contains digit if statement
                    // if(allUpperCaseLetter.indexOf(letter) > 0)
                }
                else{
                    System.out.println("Password doesn't contain a capital letter");
                    return false;
                }

                if(containsDigit(password)){
                    return true;
                }
            }
        }
        else{
            System.out.println("Password is less than 8 characters long");
            return false;
        }
        return true;
    }
    public static String maskCreditCard(String creditCardNumber) {
        // Fill in this method and if the credit card is valid, return a masked CC
        return "";
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
