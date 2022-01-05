package com.example.cafemenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    // static variable
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "CafeMenuDB";

    // table name
    private static final String TABLE_MENU = "menus";

    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_TITTLE = "tittle";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_PRICE = "price";

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_MENUS_TABLE = "CREATE TABLE " + TABLE_MENU + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITTLE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT," + KEY_PRICE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_MENUS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        onCreate(sqLiteDatabase);
    }

    public void tambahData(Food menu){
        SQLiteDatabase sqLiteDatabase  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITTLE, menu.title);
        values.put(KEY_DESCRIPTION, menu.description);
        values.put(KEY_PRICE, menu.price);

        sqLiteDatabase.insert(TABLE_MENU, null, values);
        sqLiteDatabase.close();
    }

    // get All Record
    public List<Food> getFoodList(Context context) {
        List<Food> contactList = new ArrayList<Food>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MENU;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        ArrayList<Integer> gambar = FoodData.getImage();

        int index = 0;
        if (cursor.moveToFirst()) {
            do {
                if(index%10==0) {
                    index = 0;
                }
                String title = cursor.getString(1);
                String description = cursor.getString(2);
                String price = cursor.getString(3);

                Food menu = new Food(title, description, price, context.getDrawable(gambar.get(index)));

                contactList.add(menu);
                index++;
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

}
