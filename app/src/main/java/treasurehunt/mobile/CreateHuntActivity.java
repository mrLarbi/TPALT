package treasurehunt.mobile;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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
