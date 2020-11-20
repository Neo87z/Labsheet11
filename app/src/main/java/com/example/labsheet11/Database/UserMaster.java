package com.example.labsheet11.Database;

import android.provider.BaseColumns;

public final class UserMaster {

    private UserMaster(){

    }

    public static final class User implements BaseColumns{
        public static final String TABLE_NAME="User";
        public static final String COLUMN_NAME_USER="Name";
        public static final String COLUMN_NAME_PASSWORD="Password";
        public static final String COLUMN_NAME_TYPE="Type";
    }
}
