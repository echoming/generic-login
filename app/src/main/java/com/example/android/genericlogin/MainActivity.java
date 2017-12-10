package com.example.android.genericlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView createNewAccount = findViewById(R.id.login_link_create_new_account);
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createNewAccountIntent = new Intent(MainActivity.this, NewUserActivity.class);
                startActivity(createNewAccountIntent);
            }
        });
    }

    /**
     * Disable going back to {@link NewUserActivity}
     */
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
