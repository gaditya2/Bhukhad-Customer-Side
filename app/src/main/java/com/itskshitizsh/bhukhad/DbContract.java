package com.itskshitizsh.bhukhad;

import android.provider.BaseColumns;

public final class DbContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DbContract() {
    }

    /* Inner class that defines the table contents */
    public static class Dbentry implements BaseColumns {
        public static final String TABLE_NAME = "table33";
        public static final String COLUMN_NAME_PRODUCT = "product";
        public static final String COLUMN_NAME_CANTEEN = "canteen";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_QUANTITY = "quantity";

    }

}
