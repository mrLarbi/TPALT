package treasurehunt.mobile;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText mUsernameView;
    private EditText mPasswordView;
    private EditText mPasswordConfirmationView;
    private EditText mEmailView;
    private EditText mNameView;
    private EditText mPhoneView;
    private EditText mZipcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUsernameView = (EditText) findViewById(R.id.register_username);
        mPasswordView = (EditText) findViewById(R.id.register_password);
        mPasswordConfirmationView = (EditText) findViewById(R.id.register_password_confirmation);
        mEmailView = (EditText) findViewById(R.id.register_email);
        mNameView = (EditText) findViewById(R.id.register_name);
        mPhoneView = (EditText) findViewById(R.id.register_phone);
        mZipcodeView = (EditText) findViewById(R.id.register_zipcode);

    }

    public void attemptToRegister(View v) {

        // Reset errors.
        mUsernameView.setError(null);
        mPasswordView.setError(null);
        mPasswordConfirmationView.setError(null);
        mEmailView.setError(null);
        mNameView.setError(null);
        mPhoneView.setError(null);
        mZipcodeView.setError(null);

        boolean cancel = false;
        View focusView = null;

        // Store values at the time of the login attempt.
        String usernameText = mUsernameView.getText().toString();
        String passwordText = mPasswordView.getText().toString();
        String passwordConfirmationText = mPasswordConfirmationView.getText().toString();
        String emailText = mEmailView.getText().toString();
        String nameText = mNameView.getText().toString();
        String phoneText = mPhoneView.getText().toString().trim();
        String zipcodeText = mZipcodeView.getText().toString().trim();

        Log.i("Zip : ", zipcodeText);

        switch (Validator.isValidPostalCode(zipcodeText)) {
            case Validator.OK :
                break;
            case Validator.ZIPCODE_ERROR_EMPTY:
                break;
            case Validator.ZIPCODE_ERROR_MATCH:
                mZipcodeView.setError(getString(R.string.error_invalid_zipcode_regexp));
                focusView = mZipcodeView;
                cancel = true;
                break;
            default:
                break;
        }

        switch (Validator.isValidPhoneNumber(phoneText)) {
            case Validator.OK :
                break;
            case Validator.PHONE_ERROR_EMPTY:
                break;
            case Validator.PHONE_ERROR_MATCH:
                mPhoneView.setError(getString(R.string.error_invalid_phone_regexp));
                focusView = mPhoneView;
                cancel = true;
                break;
            default:
                break;
        }

        switch (Validator.isValidMail(emailText)) {
            case Validator.OK :
                break;
            case Validator.EMAIL_ERROR_MATCH:
                mEmailView.setError(getString(R.string.error_invalid_email_regexp));
                focusView = mEmailView;
                cancel = true;
                break;
            case Validator.EMAIL_ERROR_EMPTY:
                mEmailView.setError(getString(R.string.error_field_required));
                focusView = mEmailView;
                cancel = true;
                break;
            default:
                break;
        }

        switch(Validator.isValidPasswordConfirmation(passwordText, passwordConfirmationText)) {
            case Validator.OK :
                break;
            case Validator.CONFIRMATION_ERROR_EQUAL:
                mPasswordConfirmationView.setError(getString(R.string.error_invalid_password_confirmation_equal));
                focusView = mPasswordConfirmationView;
                cancel = true;
                break;
            default:
                break;
        }

        switch (Validator.isValidPassword(passwordText)) {
            case Validator.OK :
                break;
            case Validator.PASSWORD_ERROR_MATCH:
                mPasswordView.setError(getString(R.string.error_invalid_password_regexp));
                focusView = mPasswordView;
                cancel = true;
                break;
            case Validator.PASSWORD_ERROR_TOOLONG:
                mPasswordView.setError(getString(R.string.error_invalid_password_length_long));
                focusView = mPasswordView;
                cancel = true;
                break;
            case Validator.PASSWORD_ERROR_TOOSHORT:
                mPasswordView.setError(getString(R.string.error_invalid_password_length_short));
                focusView = mPasswordView;
                cancel = true;
                break;
            default:
                break;

        }

        switch (Validator.isValidUserName(usernameText)) {
            case Validator.OK :
                break;
            case Validator.USERNAME_ERROR_MATCH:
                mUsernameView.setError(getString(R.string.error_invalid_username_regexp));
                focusView = mUsernameView;
                cancel = true;
                break;
            case Validator.USERNAME_ERROR_TOOLONG:
                mUsernameView.setError(getString(R.string.error_invalid_username_length_long));
                focusView = mUsernameView;
                cancel = true;
                break;
            case Validator.USERNAME_ERROR_TOOSHORT:
                mUsernameView.setError(getString(R.string.error_invalid_username_length_short));
                focusView = mUsernameView;
                cancel = true;
                break;
            default:
                break;

        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }

        //HTTP request TODO here

    }

}
