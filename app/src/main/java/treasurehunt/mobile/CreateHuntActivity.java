package treasurehunt.mobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CreateHuntActivity extends Activity implements View.OnClickListener {

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
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.createHuntButton:
                //here we send the new hunt to the server
                break;
            case R.id.cancelHuntButton:
                //here we return to the profile
                break;
            case R.id.paristhumbnail:
                //here we open a new activity with a map
                break;
        }
    }


}
