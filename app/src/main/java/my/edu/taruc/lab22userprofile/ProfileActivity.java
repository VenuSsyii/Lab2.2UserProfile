package my.edu.taruc.lab22userprofile;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    public static final String USER_ID = "my.edu.tarc.lac22userprofile.ID";
    public static final String EMAIL = "my.edu.tarc.lac22userprofile.EMAIL";
    public static final int REQUEST_PROFILE_UPDATE = 1;
    private TextView textViewID, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewID = (TextView)findViewById(R.id.textViewID);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);

    }

    public void editProfile(View view){
        Intent intent = new Intent(this, ProfileResultActivity.class);
        startActivityForResult(intent, REQUEST_PROFILE_UPDATE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestCode = the unique that your activity sent with an intent
        //resultCode = store either OK or Cancel
        //data = the date returned from an intent
        super.onActivityResult(requestCode, resultCode, data);
        //if(requestCode == REQUEST_PROFILE_UPDATE && resultCode == RESULT_OK){}

        if(requestCode == REQUEST_PROFILE_UPDATE){
            String id, email;
            id = data.getStringExtra(USER_ID);
            email = data.getStringExtra(EMAIL);

            //Display data on UI
            textViewID.setText(getString(R.string.user_id) + id);
            textViewEmail.setText(getString(R.string.email) + email);

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ProfileActivity", "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ProfileActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ProfileActivity", "onResume");
    }
}