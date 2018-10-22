package com.example.valkyrie.inventory_app.data;
import android.provider.BaseColumns;

public final class BooksContract {
    private BooksContract () {}
public static final class BooksEntry implements BaseColumns{
    public final static String TABLE_NAME ="entry";
    public final static String _ID = BaseColumns._ID;
    public final static String COLUMN_PRODUCT_CODE="code";
    public final static String COLUMN_PRODUCT_NAME ="name";
    public final static String COLUMN_PRICE ="price";
    public final static String COLUMN_QUANTITY ="quantity";
    public final static String COLUMN_SUPPLIER_NAME ="supplier_name";
    public final static String COLUMN_SUPPLIER_PHONE_NUMBER ="phone_number";
    public final static String COLUMN_IN_STOCK ="in_Stock";
    public static final int IN_STOCK = 1;
    public static final int NOT_IN_STOCK = 0;
}
}

