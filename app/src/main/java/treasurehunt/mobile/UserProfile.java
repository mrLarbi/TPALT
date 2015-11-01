package treasurehunt.mobile;

public class UserProfile {
    private String mAvatar;
    private String mUsername;
    private String mName;
    private String mEmail;
    private String mPhone;
    private String mZipcode;
    private String mSexe;

    public UserProfile(String avatar, String username, String name, String email, String phone, String zipcode, String sexe) {
        mAvatar = avatar;
        mUsername = username;
        mEmail = email;
        mPhone = phone;
        mZipcode = zipcode;
        mSexe = sexe;
        mName = name;
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }
}
