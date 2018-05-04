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
 * Last modified  02/05/18 10:03 PM
 */

package com.example.android.genericlogin.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.genericlogin.R;
import com.example.android.genericlogin.databinding.ActivityLoginBinding;
import com.example.android.genericlogin.ui.model.User;
import com.example.android.genericlogin.ui.new_user.NewUserActivity;

public class LoginActivity extends AppCompatActivity
        implements LoginContract.View, LoginContract.View.LoginCallback {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        LoginPresenter presenter = new LoginPresenter();
        presenter.attachView(this);
        binding.setPresenter(presenter);
        binding.setCallBack(this);
        binding.setNewAccount(this);
        binding.setUser(new User());
    }

    /**
     * Disable going back to {@link NewUserActivity}
     */
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void loginSuccess() {
        binding.loginPasswordEditTextWrapper.setErrorEnabled(false);
        binding.loginEmailEditTextWrapper.setErrorEnabled(false);
        // Show progress dialog for better user experience
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
    }

    @Override
    public void createNewAccount() {
        startActivity(new Intent(LoginActivity.this, NewUserActivity.class));
    }

    @Override
    public void invalidUserName() {
        binding.loginEmailEditTextWrapper.setError("enter valid email address");
    }

    @Override
    public void invalidPassword() {
        binding.loginPasswordEditTextWrapper.setError("between 5 and 8 digits");
    }
}
