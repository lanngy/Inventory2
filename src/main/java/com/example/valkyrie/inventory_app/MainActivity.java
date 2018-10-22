package com.example.valkyrie.inventory_app;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.valkyrie.inventory_app.data.BooksDbHelper;import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.valkyrie.inventory_app.data.BooksContract.BooksEntry;
import com.example.valkyrie.inventory_app.data.BooksDbHelper;

public class MainActivity extends AppCompatActivity {
    private BooksDbHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new BooksDbHelper(this);
        getdata();
    }
    private void getdata() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + BooksEntry.TABLE_NAME, null);
        while(cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(BooksEntry.COLUMN_PRODUCT_NAME));
            // then you can display this name in logs or in the TextView
        }
        try {
            TextView displayView = (TextView) findViewById(R.id.text_view_books);
            displayView.setText("Number of rows in books database table: " + cursor.getCount());
        } finally {
            cursor.close();
        }
    }
    private void insertBooks() {
    SQLiteDatabase db = mDbHelper.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(BooksEntry.COLUMN_PRODUCT_CODE , 1);
    values.put(BooksEntry.COLUMN_PRODUCT_NAME, "Ritter");
    values.put(BooksEntry.COLUMN_PRICE, 1);
    values.put(BooksEntry.COLUMN_QUANTITY, 1);
    values.put(BooksEntry.COLUMN_SUPPLIER_NAME ,"Bau!");
    values.put(BooksEntry.COLUMN_SUPPLIER_PHONE_NUMBER , 1);
    values.put(BooksEntry.COLUMN_IN_STOCK,"in Stock");
    long newRowId = db.insert(BooksEntry.TABLE_NAME, null, values);
        }
    }