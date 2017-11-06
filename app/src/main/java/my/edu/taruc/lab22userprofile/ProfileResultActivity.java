package my.edu.taruc.lab22userprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static my.edu.taruc.lab22userprofile.ProfileActivity.REQUEST_PROFILE_UPDATE;

public class ProfileResultActivity extends AppCompatActivity {
    private EditText editTextID, editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_result);

        editTextID = (EditText)findViewById(R.id.editTextID);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);

    }

    public void saveProfile(View view){
        Intent intent = new Intent();

        String id = editTextID.getText().toString();
        String email = editTextEmail.getText().toString();

        intent.putExtra(ProfileActivity.USER_ID, id);
        intent.putExtra(ProfileActivity.EMAIL, email);

        setResult(REQUEST_PROFILE_UPDATE, intent);
        finish();

    }
}
