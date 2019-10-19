package tab.de.bansky.lagerbs;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OverviewActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "OverviewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.save_button).setOnClickListener(this);
    }

    private void saveData() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        DatabaseReference myRef = database.getReference("message");

        String userId = mDatabase.push().getKey();
        User user = new User("Baum Tamada", "ravi@androidhive.info");

        Log.d(TAG, "userId is: " + userId);
        Log.d(TAG, "user is: " + user);

        myRef.setValue("Hello, Baum!");

        Task<Void> m = mDatabase.child(userId).setValue(user);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();

        Log.d(TAG, "Value is: " + i);
        if (i == R.id.save_button) {
            Log.d(TAG, "Value ist: " + i);
            saveData();
        }
    }
}
