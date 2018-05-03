/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * Created by Nishant Patel in 02/05/18 9:25 PM
 *
 * Copyright (c) 2018.
 * Last modified  10/12/17 5:03 PM
 */

package com.example.android.genericlogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    /* TextInput Wrappers */
    private TextInputLayout mUserEmailWrapper;
    private TextInputLayout mUserPasswordWrapper;

    /* EditText fields */
    private EditText mUserEmail;
    private EditText mUserPassword;

    /* Login button */
    private Button mLoginButton;

    /* Coordinator layout to display snack bar */
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find all views with respective IDs
        mUserEmailWrapper = findViewById(R.id.login_email_edit_text_wrapper);
        mUserPasswordWrapper = findViewById(R.id.login_password_edit_text_wrapper);
        mUserEmail = findViewById(R.id.login_email_edit_text);
        mUserPassword = findViewById(R.id.login_password_edit_text);
        mCoordinatorLayout = findViewById(R.id.login_coordinator_layout);

        mLoginButton = findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        TextView createNewAccount = findViewById(R.id.login_link_create_new_account);
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createNewAccountIntent = new Intent(LoginActivity.this, NewUserActivity.class);
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

    /**
     * When user clicks the login button, get the inputs provided by user and validate them,
     * and login them
     */
    private void login() {
        // If data entered by user is not valid, exit the method
        if (!validateData()) {
            return;
        }

        mLoginButton.setEnabled(false);

        // Show progress dialog for better user experience
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
    }

    /**
     * This method is used to validate data provided by user
     *
     * @return true and false depending upon valid data
     */
    private boolean validateData() {
        boolean validData = true;

        String email = mUserEmail.getText().toString().trim();
        String password = mUserPassword.getText().toString();

        // If the email text field is empty or email address is not per EMAIL_ADDRESS pattern,
        // give user a error message
        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mUserEmailWrapper.setError("enter valid email address");
            validData = false;
        } else {
            mUserEmailWrapper.setErrorEnabled(false);
        }

        // If the password text field is emory or password is not between 5 and 8 digits,
        // give user a error message
        if (TextUtils.isEmpty(password) || password.length() < 5 || password.length() > 8) {
            mUserPasswordWrapper.setError("between 5 and 8 digits");
            validData = false;
        } else {
            mUserEmailWrapper.setErrorEnabled(false);
        }
        return validData;
    }
}
