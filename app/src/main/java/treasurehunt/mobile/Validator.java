package treasurehunt.mobile;

/**
 * Created by mohameddd on 10/28/15.
 */
public class Validator {

    public static final String USER_NAME_PATTERN =  "^[0-9]*[a-zA-Z][a-zA-Z0-9]*$";

    public static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static final String ZIP_PATTERN = "^[0-9]{5}$";

    public static final String PHONE_PATTERN = "^[0-9]{10}$";

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$";

    public static final int OK = 0;

    public static final int ZIPCODE_ERROR_EMPTY = 1;
    public static final int ZIPCODE_ERROR_MATCH = 2;

    public static final int EMAIL_ERROR_EMPTY = 1;
    public static final int EMAIL_ERROR_MATCH = 2;

    public static final int PHONE_ERROR_EMPTY = 1;
    public static final int PHONE_ERROR_MATCH = 2;

    public static final int USERNAME_ERROR_MATCH = 1;
    public static final int USERNAME_ERROR_TOOSHORT = 2;
    public static final int USERNAME_ERROR_TOOLONG = 3;

    public static final int PASSWORD_ERROR_MATCH = 1;
    public static final int PASSWORD_ERROR_TOOSHORT = 2;
    public static final int PASSWORD_ERROR_TOOLONG = 3;

    public static final int CONFIRMATION_ERROR_EQUAL = 1;


    /**
     * Tells if a zip code is valid or not.
     * @param zip Zipcode text
     * @return OK if the postal code is valid,
     * ZIPCODE_ERROR_NULL if the postal code is null,
     * ZIPCODE_ERROR_EMPTY if it is empty,
     * ZIPCODE_ERROR_MATCH if it does not match the regular expression
     */
    public static int isValidPostalCode(String zip) {

        if(zip.isEmpty()) {
            return ZIPCODE_ERROR_EMPTY;
        }
        if(!zip.matches(Validator.ZIP_PATTERN)) {
            return ZIPCODE_ERROR_MATCH;
        }
        return OK;
    }

    /**
     * Tells if an email is valid or not.
     * @param email Email text
     * @return OK if the email is valid, EMAIL_ERROR_EMPTY if the email is empty, and EMAIL_ERROR_MATCH, if
     * the email does not match the regular expression
     */
    public static int isValidMail(String email) {

        if(email.isEmpty()) {
            return EMAIL_ERROR_EMPTY;
        }
        if(!email.matches(Validator.EMAIL_PATTERN)) {
            return EMAIL_ERROR_MATCH;
        }
        return OK;
    }

    /**
     * Tells if a phone is valid or not
     * @param phone Phone number text
     * @return OK if the phone number is valid, PHONE_ERROR_EMPTY if the it is empty, PHONE_ERROR_MATCH if
     * it does not match the regular expression
     */
    public static int isValidPhoneNumber(String phone) {
        if(phone.isEmpty()) {
            return PHONE_ERROR_EMPTY;
        }
        if(!phone.matches(Validator.PHONE_PATTERN)) {
            return PHONE_ERROR_MATCH;
        }
        return OK;
    }

    /**
     * Tells if a username if valid or not.
     * @param username Username text
     * @return OK if the username is valid, USERNAME_ERROR_TOOSHORT if the username's length is lower than 2,
     * USERNAME_ERROR_TOOLONG if it's length is greater than 15, USERNAME_ERROR_MATCH if it does not match
     * the regular expression
     */
    public static int isValidUserName(String username) {

        if(username.length() < 2) {
            return USERNAME_ERROR_TOOSHORT;
        }
        if(username.length() > 15) {
            return USERNAME_ERROR_TOOLONG;
        }
        if(!username.matches(Validator.USER_NAME_PATTERN)) {
            return USERNAME_ERROR_MATCH;
        }

        return OK;
    }

    /**
     * Tells if a password is valid or not.
     * @param password Password text
     * @return OK if the password is valid, PASSWORD_ERROR_TOOSHORT if the password's length is lower than 6,
     * PASSWORD_ERROR_TOOLONG if it's length is greater than 25, and PASSWORD_ERROR_MATCH if it does not match
     * the regular expression
     */
    public static int isValidPassword(String password) {

        if(password.length() < 6) {
            return PASSWORD_ERROR_TOOSHORT;
        }
        if(password.length() > 25) {
            return PASSWORD_ERROR_TOOLONG;
        }
        if(!password.matches(Validator.PASSWORD_PATTERN)) {
            return PASSWORD_ERROR_MATCH;
        }

        return OK;
    }

    /**
     * Tells if a confirmation password is equal to the password
     * @param password Password text
     * @param confirmation Password confirmation text
     * @return OK if the confirmation is equal to the password, CONFIRMATION_ERROR_EQUAL if it is not.
     */
    public static int isValidPasswordConfirmation(String password, String confirmation) {
        if(!password.equals(confirmation)) {
            return CONFIRMATION_ERROR_EQUAL;
        }
        return OK;
    }
}
