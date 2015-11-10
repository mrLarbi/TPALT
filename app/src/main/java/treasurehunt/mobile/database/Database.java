package treasurehunt.mobile.database;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Manu on 03-Nov-15.
 */
public class Database implements Serializable {

    private static ArrayList<User> users;
    private static ArrayList<Hunt> hunts;
    private static ArrayList<Message> messages;

    public static String CURRENT_USER = "";

    private static String names[] = {  "Boris", "Charles", "Hassan", "Mohamed", "Benjamin", "Nicolas", "Giorgi", "Maksym", "Juan Manuel", "Mohamed",
                                "Yacine", "Jerôme", "Mickael", "Kim", "Maxime", "Jhordan", "Rania", "Walid"};
    private static String lastnames[] = {  "Berger", "Chitimbo", "Kobrosli", "Amin", "Le Nestour", "Telera", "Shavgulidze", "Kulishev", "Calderon", "Larbi Youcef",
            "Zelmat", "Rahault", "Chaniot", "Nguyen", "Bonnet", "Leoture", "Flissate", "Zeghdaoui"};

    private static Point westest = new Point("West", 48.850543, 2.251849);
    private static Point eastest = new Point("East", 48.850543, 2.241849);
    private static Point northest = new Point("North", 48.840543, 2.245849);
    private static Point southest = new Point("South", 48.860543, 2.245849);

    private Database() {}

    public static void init() {
        File db = new File("treasurehunt.db");
        if(!db.exists()) {
            users = new ArrayList<>();
            hunts = new ArrayList<>();
            messages = new ArrayList<>();

            Random rg = new Random(System.currentTimeMillis());

            String avatar, username, password, name, email, phone, gender, zcode;

            for(int i = 0; i < 50; i++) {
                int namesize = names.length;

                avatar = "http://www.serebii.net/battletrozei/pokemon/" + String.format("%03d", rg.nextInt(721) + 1) + ".png";
                username = names[rg.nextInt(namesize)];
                password = "Password1234";
                name = names[rg.nextInt(namesize)] + " " + lastnames[rg.nextInt(namesize)];
                email = names[rg.nextInt(namesize)] + "@gmail.com";
                phone = String.format("%02d", rg.nextInt(100)) + String.format("%02d", rg.nextInt(100)) +
                        String.format("%02d", rg.nextInt(100)) + String.format("%02d", rg.nextInt(100)) +
                        String.format("%02d", rg.nextInt(100));
                if(rg.nextBoolean()) gender = "M"; else gender = "F";
                zcode = Integer.toString(rg.nextInt(100000));

                User u = new User(avatar, username, password, name, email, phone, zcode, gender);
                users.add(u);
            }

            for(int i = 0; i < 75; i++) {

                String hname = "Hunt " + i;
                Hunt h = new Hunt(hname);

                for(int j = 0; j < 10; j++) {
                    String pname = "Point " + j;
                    double lat =    rg.nextDouble() * (northest.getLat() - southest.getLat()) + southest.getLat();
                    double lon =    rg.nextDouble() * (eastest.getLat() - westest.getLat()) + westest.getLat();
                    Point p = new Point(pname, lat, lon);
                    h.addPoint(p);
                }
                hunts.add(h);
            }

            for(Hunt h : hunts) {
                users.get(rg.nextInt(users.size())).addCreated(h);
            }
        } else {
            // TODO Get db
        }
    }

    public static User getUserByUsername(String username) {
        for(User u : users) {
            if(u.getUsername().equals(username))
                return u;
        }

        return null;
    }
    public static User getUserByEmail(String email) {
        for(User u : users) {
            if(u.getEmail().equals(email))
                return u;
        }

        return null;
    }

    public static void addUser(User u) {
        users.add(u);
    }

    public static void addHunt(Hunt h) {
        hunts.add(h);
    }

    public static void removeHunt(Hunt h) {
        hunts.remove(h);
    }

    public static Hunt getHuntByName(String hname) {
        for(Hunt h : hunts) {
            if(h.getName().equals(hname))
                return h;
        }

        return null;
    }

    public static boolean isLogin(String username, String password) {
        User user = getUserByUsername(username);
        if(user != null) {
            if(user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
