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
 * Created by Nishant Patel in 02/05/18 10:12 PM
 *
 * Copyright (c) 2018.
 * Last modified  02/05/18 10:12 PM
 */

package com.example.android.genericlogin.ui.new_user;

import com.example.android.genericlogin.base.MvpView;
import com.example.android.genericlogin.ui.login.LoginContract;
import com.example.android.genericlogin.ui.model.User;

public interface NewUserContract {
    interface View extends MvpView {
        void createAccountSuccess();

        void loginToExistingAccount();

        interface LoginCallback {
            void invalidUserEmail();

            void invalidPassword();

            void invalidUserName();
        }
    }

    interface Presenter {
        void onCreateNewAccountButtonClick(String name,
                                           String userName,
                                           String pass,
                                           NewUserContract.View.LoginCallback callback);
    }
}
