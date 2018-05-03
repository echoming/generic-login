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
 * Last modified  10/12/17 1:12 AM
 */

package com.example.android.genericlogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.genericlogin.databinding.ActivityNewUserBinding;

public class NewUserActivity extends AppCompatActivity {

    /* TextInput wrappers */
    private TextInputLayout mUserEmailWrapper;
    private TextInputLayout mUserNameWrapper;
    private TextInputLayout mUserPasswordWrapper;

    /* EditText fields for user information */
    private EditText mUserEmail;
    private EditText mUserName;
    private EditText mUserPassword;

    private Button mCreateAccountButton;
    ActivityNewUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_user);

        /* Find all the views with respective Ids */
        mUserEmailWrapper = findViewById(R.id.new_user_email_edit_text_wrapper);
        mUserNameWrapper = findViewById(R.id.new_user_name_edit_text_wrapper);
        mUserPasswordWrapper = findViewById(R.id.new_user_password_edit_text_wrapper);
        mUserEmail = findViewById(R.id.new_user_email_edit_text);
        mUserName = findViewById(R.id.new_user_name_edit_text);
        mUserPassword = findViewById(R.id.new_user_password_edit_text);

        mCreateAccountButton = findViewById(R.id.new_user_create_account_button);
        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When user clicks on 'CREATE ACCOUNT', take the input provided by user,
                // validate it and create a new account
                createNewAccount();
            }
        });

        TextView loginExistingAccount = findViewById(R.id.new_user_login_link_existing_user);
        loginExistingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginExistingAccountIntent = new Intent(NewUserActivity.this, LoginActivity.class);
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

    /**
     * Create new account when user clicks on `CREATE ACCOUNT` button
     */
    private void createNewAccount() {

        // if user has not provided valid data, do not create an account and return from method
        if (!validateData()) {
            return;
        }

        mCreateAccountButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(
                NewUserActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();
    }

    private boolean validateData() {
        boolean validData = true;

        String email = mUserEmail.getText().toString().trim();
        String name = mUserName.getText().toString().trim();
        String password = mUserPassword.getText().toString();

        // If the Name text field is empty or Name is less then 3 characters,
        // give user a error message
        if (TextUtils.isEmpty(name) || name.length() < 3) {
            mUserNameWrapper.setError("at least 3 letters");
            validData = false;
        } else {
            mUserNameWrapper.setErrorEnabled(false);
        }

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
