package com.hienqp.sqlitesavingimagekpt;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void QueryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor GetData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    // PHƯƠNG THỨC DÙNG ĐỂ INSERT 1 ITEM HÌNH ẢNH VÀO TABLE CỦA DATABASE
    // function này ta truyền vào 3 thuộc tính tên, mô tả, và hình của đồ vật
    // với kiểu của hình ảnh là mảng byte, vì bản chất của hình ảnh là mảng các byte dữ liệu
    public void INSERT_DOVAT(String ten, String mota, byte[] hinh) {
        SQLiteDatabase database = getWritableDatabase();

        // tạo câu lệnh sql INSERT đồ vật với các thuộc tính vào database
        // trừ thuộc tính id ta sẽ để null để SQLite tự động thêm
        // còn 3 thuộc tính ten, mota, hinh ta sẽ không truyền trực tiếp mà sẽ compile nó sau
        // với mỗi thuộc tính ta sẽ đại diện bằng 1 dấu ?
        String sql = "INSERT INTO DoVat VALUES(null, ?, ?, ?)";

        // khởi tạo đối tượng SQLiteStatement từ function compileStatement của SQLiteDatabase
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        // tiến hành bind từng thuộc tính vào đối tượng SQLiteStatement
        // với index là thứ tự của thuộc tính trong chuỗi lệnh sql dùng để compileStatement
        // null = 0, dấu ? thứ nhất là 1, tiếp đến là 2, cuối cùng là 3
        // truyền vào các giá trị tương ứng để bind dữ liệu vào statement
        statement.bindString(1, ten);
        statement.bindString(2, mota);
        statement.bindBlob(3, hinh);

        // sau khi bind tất cả dữ liệu cần thiết, gọi lệnh thực thi insert
        statement.executeInsert();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
