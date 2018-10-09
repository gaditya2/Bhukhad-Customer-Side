package com.itskshitizsh.bhukhad;

import android.provider.BaseColumns;

/**
 * Created by Ninaad on 5/16/2018.
 */

public final class Dbcontract {

    private Dbcontract() {
    }

    public static class Dbentry implements BaseColumns {

        public static final String COLUMN_PRODUCT_QUANTITY = "id";
        public static final String TABLE_NAME = SignInActivity.name;
        public static final String COLUMN_PRODUCT_NAME = "name";

        static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                COLUMN_PRODUCT_NAME + "TEXT ," +
                COLUMN_PRODUCT_QUANTITY + " INTEGER " +

                ")";
    }

}
