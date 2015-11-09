package treasurehunt.mobile.database;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mohameddd on 11/1/15.
 */
public class Hunt {
    private String mName;
    private ArrayList<Point> points;

    public Hunt(String name) {
        mName = name;
        points = new ArrayList<Point>();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public void removePoint(Point p) {
        points.remove(p);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
