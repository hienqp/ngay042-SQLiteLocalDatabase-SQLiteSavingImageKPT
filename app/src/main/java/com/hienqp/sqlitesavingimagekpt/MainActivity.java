package com.hienqp.sqlitesavingimagekpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnThem;
    public static Database database;

    ListView lvDoVat;
    ArrayList<DoVat> arrayDoVat;
    DoVatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDoVat = findViewById(R.id.listviewDoVat);
        arrayDoVat = new ArrayList<>();

        adapter = new DoVatAdapter(this, R.layout.dong_do_vat, arrayDoVat);
        lvDoVat.setAdapter(adapter);

        btnThem = (Button) findViewById(R.id.buttonThem);

        // khởi tạo database với các tham số của Constructor database
        database = new Database(MainActivity.this, "QuanLy.sqlite", null, 1);

        // truy vấn khởi tạo table với các column
        // lưu ý: đối với HinhAnh thì kiểu của nó là BLOB (Binary Large OBject - đối tượng nhị phân lớn) - BLOB là 1 kiểu chung chung
        // để ám chỉ việc lưu 1 đối tượng dữ liệu kích thước lớn
        // và hình ảnh trong SQLite có kiểu là mảng byte - byte[]
        // tron Database.java ta sẽ thêm 1 function truyền mảng byte vào SQLite
        database.QueryData("CREATE TABLE IF NOT EXISTS DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(300), MoTa VARCHAR(500), HinhAnh BLOB)");

        // LẤY DỮ LIỆU TỪ DATABASE ĐỂ HIỂN THỊ LÊN LISTVIEW
        Cursor cursor = database.GetData("SELECT * FROM DoVat");
        while (cursor.moveToNext()) {
            arrayDoVat.add(new DoVat(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getBlob(3)
                    ));
        }

        adapter.notifyDataSetChanged();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThemDoVatActivity.class));
            }
        });
    }
}