package com.finepointmobile.famouspeople;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by danielmalone on 10/28/17.
 */

public class CreateUser extends AppCompatActivity {

    private static final String TAG = "CreateUser";

    EditText firstName;
    EditText lastName;
    EditText email;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 10/28/17 Save to database
                Log.d(TAG, "onClick: firstName: " + firstName.getText().toString());

                for (int i = 0; i < 10; i++) {
                    User user = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString());
                    db.userDao().insertAll(user);
                }

                startActivity(new Intent(CreateUser.this, MainActivity.class));
            }
        });
    }
}
