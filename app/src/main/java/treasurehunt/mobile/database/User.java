package treasurehunt.mobile.database;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private String mAvatar;
    private String mUsername;
    private String mPassword;
    private String mName;
    private String mEmail;
    private String mPhone;
    private String mZipcode;
    private String mGender;
    private ArrayList<Hunt> createdhunts;
    private ArrayList<Hunt> currenthunts;
    private ArrayList<User> friends;
    private ArrayList<Message> messagesReceived;

    public User(String avatar, String username, String password, String name, String email, String phone, String zipcode, String gender) {
        mAvatar = avatar;
        mUsername = username;
        mPassword = password;
        mEmail = email;
        mPhone = phone;
        mZipcode = zipcode;
        mGender = gender;
        mName = name;
        createdhunts = new ArrayList<Hunt>();
        currenthunts = new ArrayList<Hunt>();
        friends = new ArrayList<User>();
        messagesReceived = new ArrayList<Message>();
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

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
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

    public String getPassword() {
        return mPassword;
    }

    public ArrayList<Hunt> getCreatedhunts() {
        return createdhunts;
    }

    public ArrayList<Hunt> getCurrenthunts() {
        return currenthunts;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public ArrayList<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public void addCreated(Hunt h) {
        createdhunts.add(h);
    }

    public void removeCreated(Hunt h) {
        createdhunts.remove(h);
    }

    public void addCurrent(Hunt h) {
        currenthunts.add(h);
    }

    public void removeCurrent(Hunt h) {
        currenthunts.remove(h);
    }

    public void addFriend(User u) {
        friends.add(u);
    }

    public void removeFriend(User u) {
        friends.remove(u);
    }

    public void addMessage(Message m) {
        messagesReceived.add(m);
    }
}
