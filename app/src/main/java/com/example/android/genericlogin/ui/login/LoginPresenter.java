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
 * Last modified  02/05/18 10:11 PM
 */

package com.example.android.genericlogin.ui.login;

import com.example.android.genericlogin.base.BasePresenter;
import com.example.android.genericlogin.ui.model.User;

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {

    LoginPresenter() {
    }

    @Override
    public void attachView(LoginContract.View view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void onLoginButtonClick(String user,
                                   String pass,
                                   LoginContract.View.LoginCallback callback) {

        // Check user name/pass is valid or not
        if (!User.isUserNameValid(user)) {
            callback.invalidUserName();
        } else if (!User.isPasswordValid(pass)) {
            callback.invalidPassword();
        } else {
            getView().loginSuccess();
        }
    }
}
