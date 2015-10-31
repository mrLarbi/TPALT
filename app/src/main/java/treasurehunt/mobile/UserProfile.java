package treasurehunt.mobile;

public class UserProfile {
    private String mUsername;
    private String mEmail;
    private String mPhone;
    private String mZipcode;
    private String mSexe;

    public UserProfile(String username, String email, String phone, String zipcode, String sexe) {
        mUsername = username;
        mEmail = email;
        mPhone = phone;
        mZipcode = zipcode;
        mSexe = sexe;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getZipcode() {
        return mZipcode;
    }

    public void setZipcode(String zipcode) {
        mZipcode = zipcode;
    }

    public String getSexe() {
        return mSexe;
    }

    public void setSexe(String sexe) {
        mSexe = sexe;
    }
}
