package treasurehunt.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import treasurehunt.mobile.database.Database;
import treasurehunt.mobile.database.Hunt;

public class CreateHuntActivity extends Activity implements View.OnClickListener {

    private Hunt h;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_hunt);

        Button createHuntButton = (Button) findViewById(R.id.createHuntButton);
        Button cancelHuntButton = (Button) findViewById(R.id.cancelHuntButton);
        ImageView paristhumbnail = (ImageView) findViewById(R.id.paristhumbnail);

        createHuntButton.setOnClickListener(this);
        cancelHuntButton.setOnClickListener(this);
        paristhumbnail.setOnClickListener(this);

        Hunt h = new Hunt("New Hunt");
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.createHuntButton:
                TextView title = (TextView) findViewById(R.id.createHuntTitle);
                h.setName(title.getText().toString());
                Database.addHunt(h);
                break;
            case R.id.cancelHuntButton:
                //here we return to the profile
                break;
            case R.id.paristhumbnail:
                //here we open a new activity with a map
                Intent createHunt = new Intent(this, MapsActivity.class);
                startActivity(createHunt);
                break;
        }
    }


}
