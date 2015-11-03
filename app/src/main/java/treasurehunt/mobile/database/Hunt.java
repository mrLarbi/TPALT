package treasurehunt.mobile.database;

/**
 * Created by mohameddd on 11/1/15.
 */
public class Hunt {
    private String mImage;
    private String mName;

    public Hunt(String image, String name) {
        mImage = image;
        mName = name;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
