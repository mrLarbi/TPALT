package treasurehunt.mobile.database;


public class Message {
    private String mAvatar;
    private String mUsername;
    private String mDate;
    private String mContent;

    public Message(String avatar, String username, String date, String content) {
        mAvatar = avatar;
        mUsername = username;
        mDate = date;
        mContent = content;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }
}
