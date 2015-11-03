package treasurehunt.mobile;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private String currentHuntName = null;

    private ImageView avatarView;
    private TextView usernameView;
    private TextView emailView;
    private TextView nameView;
    private TextView phoneView;
    private TextView zipcodeView;
    private TextView sexeView;

    private UserProfile dummy_user;

    private LinearLayout mainLayout;
    private RelativeLayout showProfileLayout;
    private LinearLayout showHuntsLayout;
    private LinearLayout viewMessagesLayout;
    private LinearLayout deleteHuntLayout;
    private LinearLayout viewFriendsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainLayout = (LinearLayout) findViewById(R.id.profile_layout);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        showProfileLayout = (RelativeLayout) inflater.inflate(R.layout.content_profile, null);
        showHuntsLayout = (LinearLayout) inflater.inflate(R.layout.show_hunts, null);
        viewMessagesLayout = (LinearLayout) inflater.inflate(R.layout.view_messages, null);
        deleteHuntLayout = (LinearLayout) inflater.inflate(R.layout.delete_hunt, null);
        viewFriendsLayout = (LinearLayout) inflater.inflate(R.layout.view_friends, null);

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
            showHunts(true); //
            return true;
        }
        if (id == R.id.profile_menu_current_hunts) {
            showHunts(false);
            return true;
        }
        if (id == R.id.profile_menu_view_profile) {
            showViewProfile();
            return true;
        }
        if (id == R.id.profile_menu_view_friends) {
            showViewFriends();
            return true;
        }
        if (id == R.id.profile_menu_view_messages) {
            showViewMessages();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showHunts(boolean deletable) {
        showHuntsLayout.removeAllViews();
        updateMainLayout(showHuntsLayout);

        if(deletable) {
            //HTTP request to get created hunts
        }
        else {
            //HTTP request to get current hunts
        }

        ArrayList<Hunt> dummyHunts = new ArrayList<>();
        dummyHunts.add(new Hunt("http://vignette2.wikia.nocookie.net/megaman/images/a/af/WilyCastle2.png/revision/latest?cb=20100315053827", "Wily castle 2"));
        dummyHunts.add(new Hunt("http://iamericm.com/wp-content/uploads/sites/2/2013/11/rock-man-4-minus-infinity-screen-cap10.png", "Cossack castle"));

        for(int i = 0 ; i < dummyHunts.size() ; i++) {
            addHuntToView(showHuntsLayout, dummyHunts.get(i), deletable);
        }
    }

    private void showViewProfile() {
        updateMainLayout(showProfileLayout);
        //TODO : HTTP request here

        //Dummy friend

        String avatar = "http://socksmakepeoplesexy.net/images/robotmasters/Skull%20Man.PNG";
        String username = getString(R.string.dummy_username);
        String name = getString(R.string.dummy_name);
        String email = getString(R.string.dummy_email);
        String phone = getString(R.string.dummy_phone);
        String zipcode = getString(R.string.dummy_zipcode);
        String sexe = getString(R.string.male);


        dummy_user = new UserProfile(
                avatar,
                username,
                name,
                email,
                phone,
                zipcode,
                sexe);

        avatarView = (ImageView) findViewById(R.id.profile_avatar);
        usernameView = (TextView) findViewById(R.id.profile_username);
        emailView = (TextView) findViewById(R.id.profile_email);
        nameView = (TextView) findViewById(R.id.profile_name);
        phoneView = (TextView) findViewById(R.id.profile_phone);
        zipcodeView = (TextView) findViewById(R.id.profile_zipcode);
        sexeView = (TextView) findViewById(R.id.profile_sexe);

        Picasso.with(getBaseContext()).load(dummy_user.getAvatar()).into(avatarView);
        usernameView.setText(dummy_user.getUsername());
        emailView.setText(dummy_user.getEmail());
        nameView.setText(dummy_user.getName());
        phoneView.setText(dummy_user.getPhone());
        zipcodeView.setText(dummy_user.getZipcode());
        sexeView.setText(dummy_user.getSexe());
    }

    private void showViewFriends() {
        viewFriendsLayout.removeAllViews();
        updateMainLayout(viewFriendsLayout);

        //TODO HTTP request here

        ArrayList<UserProfile> dummy_friends = new ArrayList<>();
        dummy_friends.add(new UserProfile(
                "http://orig09.deviantart.net/5ede/f/2015/044/e/2/spyro_avatar_3_by_avatarw0rld-d8hubci.png",
                "Spyro",
                "Spyro",
                "spyro@gmail.com",
                "",
                "",
                ""));
        dummy_friends.add(new UserProfile(
                "http://orig09.deviantart.net/5ede/f/2015/044/e/2/spyro_avatar_3_by_avatarw0rld-d8hubci.png",
                "Sparx",
                "Sparx",
                "sparx@gmail.com",
                "",
                "",
                ""));

        for (int i = 0; i < dummy_friends.size() ; i++) {
            addFriendToView(viewFriendsLayout, dummy_friends.get(i));
        }
    }

    private void attemptToDeleteHunt() {
        updateMainLayout(deleteHuntLayout);
    }

    private void showViewMessages() {
        viewMessagesLayout.removeAllViews();
        updateMainLayout(viewMessagesLayout);

        //dummy messages

        ArrayList<Message> dummy_messages = new ArrayList<>();
        dummy_messages.add(new Message("http://socksmakepeoplesexy.net/images/robotmasters/Skull%20Man.PNG",
                "Skull Man",
                "02/01/2015",
                "Awesome hunt !"));


        for(int i = 0 ; i < dummy_messages.size() ; i++) {
            addCommentToView(viewMessagesLayout, dummy_messages.get(i));
        }

    }

    private void updateMainLayout(View layout) {
        mainLayout.removeAllViews();
        mainLayout.addView(layout);
    }

    private void updateCurrentHunt(View view) {
        View parent = (View) view.getParent().getParent();
        TextView huntNameView = (TextView) parent.findViewById(R.id.hunt_name);
        currentHuntName = huntNameView.getText().toString();
    }

    public void delete_hunt(View view) {
        updateCurrentHunt(view);
        attemptToDeleteHunt();
    }

    public void update_hunt(View view) {
        Toast.makeText(this, "Not implemented yet, go ahead !", Toast.LENGTH_SHORT).show();
    }

    public void delete_hunt_yes(View view) {
        showHunts(true);
        Toast.makeText(this, "Hunt deleted", Toast.LENGTH_SHORT).show();

        if(currentHuntName != null) {
            //TODO HTTP request to send delete
        }

        currentHuntName = null;
    }

    public void delete_hunt_no(View view) {
        showHunts(true);
        Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
    }

    private void addHuntToView(LinearLayout huntsLayout, Hunt hunt, boolean deletable) {
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.hunt, null);

        ImageView huntImage = (ImageView) view.findViewById(R.id.hunt_image);
        TextView huntName = (TextView) view.findViewById(R.id.hunt_name);
        LinearLayout huntButtons = (LinearLayout) view.findViewById(R.id.hunt_buttons);

        Picasso.with(getBaseContext()).load(hunt.getImage()).into(huntImage);
        huntName.setText(hunt.getName());
        if(!deletable) {
            huntButtons.setVisibility(LinearLayout.GONE);
        }

        huntsLayout.addView(view);
    }

    private void addCommentToView(LinearLayout commentsLayout, Message message) {
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.message, null);

        ImageView messageAvatar = (ImageView) view.findViewById(R.id.message_avatar);
        TextView messageUsername = (TextView) view.findViewById(R.id.message_username);
        TextView messageDate = (TextView) view.findViewById(R.id.message_date);
        TextView messageContent = (TextView) view.findViewById(R.id.message_content);

        Picasso.with(getBaseContext()).load(message.getAvatar()).into(messageAvatar);
        messageUsername.setText(message.getUsername());
        messageDate.setText(message.getDate());
        messageContent.setText(message.getContent());

        commentsLayout.addView(view);
    }

    private void addFriendToView(LinearLayout commentsLayout, UserProfile user) {
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.friend, null);

        ImageView friendAvatar = (ImageView) view.findViewById(R.id.friend_avatar);
        TextView friendUsername = (TextView) view.findViewById(R.id.friend_name);

        Picasso.with(getBaseContext()).load(user.getAvatar()).into(friendAvatar);
        friendUsername.setText(user.getUsername());

        commentsLayout.addView(view);
    }
}
