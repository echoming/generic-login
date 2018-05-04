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
 * Created by Nishant Patel in 02/05/18 10:20 PM
 *
 * Copyright (c) 2018.
 * Last modified  02/05/18 10:20 PM
 */

package com.example.android.genericlogin.ui.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.android.databinding.library.baseAdapters.BR;

public class User extends BaseObservable {
    private String pass;
    private String user;

    @Bindable
    public String getPass() {
        return pass;
    }

    @Bindable
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }

    public void setPass(String pass) {
        this.pass = pass;
        notifyPropertyChanged(BR.pass);
    }

    /**
     * User name validation check
     *
     * @param user user email
     * @return true or false if email is valid or not
     */
    public static boolean isUserNameValid(String user) {
        return !(TextUtils.isEmpty(user)
                || android.util.Patterns.EMAIL_ADDRESS.matcher(user).matches());
    }

    /**
     * Password validation
     *
     * @param pass password
     * @return true or false if password is valid or not
     */
    public static boolean isPasswordValid(String pass) {
        return !(TextUtils.isEmpty(pass) || pass.length() < 5 || pass.length() > 8);
    }
}
