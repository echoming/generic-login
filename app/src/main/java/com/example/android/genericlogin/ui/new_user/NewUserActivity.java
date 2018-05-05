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
 * Created by Nishant Patel in 02/05/18 10:11 PM
 *
 * Copyright (c) 2018.
 * Last modified  02/05/18 10:07 PM
 */

package com.example.android.genericlogin.ui.new_user;

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

import com.example.android.genericlogin.MainActivity;
import com.example.android.genericlogin.R;
import com.example.android.genericlogin.databinding.ActivityNewUserBinding;
import com.example.android.genericlogin.ui.login.LoginActivity;
import com.example.android.genericlogin.ui.model.User;

public class NewUserActivity extends AppCompatActivity
        implements NewUserContract.View, NewUserContract.View.LoginCallback {

    ActivityNewUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_user);
        NewUserPresenter presenter = new NewUserPresenter();
        presenter.attachView(this);
        binding.setPresenter(presenter);
        binding.setCallback(this);
        binding.setLogin(this);
        binding.setUser(new User());
    }

    /**
     * Disable going back to {@link LoginActivity}
     */
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void createAccountSuccess() {
        binding.newUserNameEditTextWrapper.setErrorEnabled(false);
        binding.newUserEmailEditTextWrapper.setErrorEnabled(false);
        binding.newUserPasswordEditTextWrapper.setErrorEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(
                NewUserActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();
    }

    @Override
    public void loginToExistingAccount() {
        startActivity(new Intent(NewUserActivity.this, LoginActivity.class));
    }

    @Override
    public void invalidUserEmail() {
        binding.newUserEmailEditTextWrapper.setError("enter valid email address");
    }

    @Override
    public void invalidPassword() {
        binding.newUserPasswordEditTextWrapper.setError("between 5 and 8 digits");
    }

    @Override
    public void invalidUserName() {
        binding.newUserNameEditTextWrapper.setError("enter valid name");
    }
}
