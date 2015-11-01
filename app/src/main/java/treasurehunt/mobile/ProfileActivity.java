package treasurehunt.mobile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private TextView usernameView;
    private TextView emailView;
    private TextView nameView;
    private TextView phoneView;
    private TextView zipcodeView;
    private TextView sexeView;

    private UserProfile dummy_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showViewProfile();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.profile_menu_created_hunts) {
            showHunts(1); //
            return true;
        }
        if (id == R.id.profile_menu_current_hunts) {
            showHunts(0);
            return true;
        }
        if (id == R.id.profile_menu_view_profile) {
            showViewProfile();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showHunts(int deletable) {
        setContentView(R.layout.show_hunts);

        if(deletable == 1) {
            //HTTP request to get created hunts
        }
        else {
            //HTTP request to get current hunts
        }

        ArrayList<Hunt> dummyHunts = new ArrayList<>();
        dummyHunts.add(new Hunt("http://vignette2.wikia.nocookie.net/megaman/images/a/af/WilyCastle2.png/revision/latest?cb=20100315053827", "Wily castle 2"));
        dummyHunts.add(new Hunt("http://iamericm.com/wp-content/uploads/sites/2/2013/11/rock-man-4-minus-infinity-screen-cap10.png", "Cossack castle"));

        LinearLayout hunts = (LinearLayout) findViewById(R.id.show_hunts);

        for(int i = 0 ; i < dummyHunts.size() ; i++) {
            addHuntToView(hunts, dummyHunts.get(i), deletable);
        }
    }

    private void addHuntToView(LinearLayout huntsLayout, Hunt hunt, int deletable) {
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.hunt, null);

        ImageView huntImage = (ImageView) view.findViewById(R.id.hunt_image);
        TextView huntName = (TextView) view.findViewById(R.id.hunt_name);
        LinearLayout huntButtons = (LinearLayout) view.findViewById(R.id.hunt_buttons);

        Picasso.with(getBaseContext()).load(hunt.getImage()).into(huntImage);
        huntName.setText(hunt.getName());
        huntButtons.setVisibility(deletable);

        huntsLayout.addView(view);
    }

    private void showViewProfile() {
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO : HTTP request here

        //Dummy user

        String username = getString(R.string.dummy_username);
        String name = getString(R.string.dummy_name);
        String email = getString(R.string.dummy_email);
        String phone = getString(R.string.dummy_phone);
        String zipcode = getString(R.string.dummy_zipcode);
        String sexe = getString(R.string.male);


        dummy_user = new UserProfile(
                username,
                name,
                email,
                phone,
                zipcode,
                sexe);

        usernameView = (TextView) findViewById(R.id.profile_username);
        emailView = (TextView) findViewById(R.id.profile_email);
        nameView = (TextView) findViewById(R.id.profile_name);
        phoneView = (TextView) findViewById(R.id.profile_phone);
        zipcodeView = (TextView) findViewById(R.id.profile_zipcode);
        sexeView = (TextView) findViewById(R.id.profile_sexe);

        usernameView.setText(dummy_user.getUsername());
        emailView.setText(dummy_user.getEmail());
        nameView.setText(dummy_user.getName());
        phoneView.setText(dummy_user.getPhone());
        zipcodeView.setText(dummy_user.getZipcode());
        sexeView.setText(dummy_user.getSexe());
    }

}
