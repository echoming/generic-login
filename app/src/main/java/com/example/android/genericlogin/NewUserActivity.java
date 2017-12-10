package com.example.android.genericlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        TextView loginExistingAccount = findViewById(R.id.new_user_login_link_existing_user);
        loginExistingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginExistingAccountIntent = new Intent(NewUserActivity.this, MainActivity.class);
                startActivity(loginExistingAccountIntent);
            }
        });
    }

    /**
     * Disable going back to {@link MainActivity}
     */
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
