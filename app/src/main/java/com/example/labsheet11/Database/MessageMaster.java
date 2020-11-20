package com.example.labsheet11.Database;

import android.provider.BaseColumns;

public final class MessageMaster {
    private  MessageMaster(){

    }

    public static final class Message implements BaseColumns {
        public static final String TABLE_NAME="Message";
        public static final String COLUMN_NAME_USER="User";
        public static final String COLUMN_NAME_SUBJECT="Subject";
        public static final String COLUMN_NAME_MESSAGE="Message";
    }
}
