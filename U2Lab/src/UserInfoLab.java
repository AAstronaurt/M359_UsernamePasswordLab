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
        // If the user entered a valid password in step 2, then ask the user to enter their credit card
        if (validatePassword(userPass)) {
            System.out.println("Enter your credit card number");
            String userCredit = scan.next();
            String maskedCard = maskCreditCard(userCredit);
            System.out.println(maskedCard);
            
            // Part 4
            // Check if the credit card is valid (not "N/A")
            if (!maskedCard.equals("N/A")) {
                String username = generateUsername(userFirstName, userLastName);
                System.out.println("Final Details:");
                System.out.println("Username: " + username);
                System.out.println("Credit Card: " + maskedCard);
            }
        }

        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username
        String result = "";
        String newFirst = firstName.toLowerCase();
        String newLast = lastName.toLowerCase();
        if(firstName.length() < 3){
            result += newFirst;
        }
        else{
            result += newFirst.substring(0, 3);
        }

        if(lastName.length() < 3){
            result += newLast;
        }
        else{
            result += newLast.substring(0, 3);
        }
        return result;
    }

    public static boolean validatePassword(String password) {
        String allUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean hasUpperCase = false;
        if(password.length() < 8) {
            System.out.println("Password is less than 8 characters");
        }

            for (int i = 0; i < password.length(); i++) {
                for (int j = 0; j < allUpperCase.length(); j++) {
                    if (password.substring(i, i + 1).equals(allUpperCase.substring(j, j + 1))) {
                        hasUpperCase = true;
                    }
                }
            }

            if(hasUpperCase){
                System.out.println("Password contains a upper case letter");
            }
            else{
                System.out.println("Password doesn't contain an upper case letter");
            }

            if (containsDigit(password)) {
                System.out.println("Password contains a digit");
            }
            else{
                System.out.println("Password doesn't contain a digit");
            }

        if (password.length() < 8 || !hasUpperCase || !containsDigit(password)) {
            return false;
        }

        return true;
    }

    public static String maskCreditCard(String creditCardNumber) {
        String result = "";
        if(creditCardNumber.length() == 16){
            if(allDigits(creditCardNumber)){
                for(int i = 0; i < 3; i++){
                        result += "**** ";
                }
                result += creditCardNumber.substring(12, 16);
            }
            else{
                result = "N/A";
            }
        }
        else{
            result = "N/A";
        }
        return result;
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
