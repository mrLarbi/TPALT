package treasurehunt.mobile.database;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Manu on 03-Nov-15.
 */
public class Point{

    private String name;
    LatLng mlatLng;

    public Point (String name, double lat, double lon) {
        this.name = name;
        mlatLng = new LatLng(lat, lon);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return mlatLng.longitude;
    }

    public double getLon() {
        return this.mlatLng.longitude;
    }

    @Override
    public boolean equals(Object latLong) {
        Point second = (Point)latLong;
        LatLng secondLatLang = second.mlatLng;
        return secondLatLang.equals(this.mlatLng);
    }

    @Override
    public int hashCode() {
        return mlatLng.hashCode();
    }
}
