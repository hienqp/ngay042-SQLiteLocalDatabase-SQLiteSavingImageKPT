# 1. Ứng Dụng Lưu Trữ Hình Ảnh Vào Database
____________________________________________________________________________________________________
- xây dựng ứng dụng quản lý đồ vật cho phép người dùng lưu trữ hình ảnh đồ vật từ
  - Camera
  - Bộ nhớ, Thư viện ảnh, ... (chọn nguồn ảnh)
    
- trong ứng dụng này quan trọng là lưu trữ và lấy ra hình ảnh từ database
    
## 1.1. activity_main.xml
____________________________________________________________________________________________________
- activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/btn_them"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:drawableLeft="@android:drawable/ic_input_add"
        android:text="Thêm Đồ Vật"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## 1.2. MainActivity.java
____________________________________________________________________________________________________
- Button Thêm Đồ Vật
  - khai báo ánh xạ
  - bắt sự kiện click Button sẽ start ThemDoVatActivity (xây dựng thêm 1 Activity - ThemDoVatActivity)

## 1.3. activity_them_do_vat.xml
____________________________________________________________________________________________________
- sau khi xây dựng UI và Logic ở MainActivity, click vào Button Thêm Đồ Vật chuyển sang ThemDoVatActivity
thành công
  
- ta tiến hành thiết kế UI cho ThemDoVatActivity

- activity_them_do_vat.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ThemDoVatActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="8dp"
        android:text="Thêm Đồ Vật"
        android:textColor="#D10707"
        android:textSize="34sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editTextTenDoVat"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="32dp"
        android:ems="10"
        android:hint="Nhập tên đồ vật"
        android:inputType="textPersonName"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.467"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <EditText
        android:id="@+id/editTextMoTa"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="32dp"
        android:ems="10"
        android:hint="Nhập mô tả"
        android:inputType="textPersonName"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editTextTenDoVat" />

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="0dp"
        android:layout_height="255dp"
        android:layout_marginStart="32dp"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="32dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.555"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editTextMoTa"
        app:srcCompat="@drawable/no_image" />

    <ImageButton
        android:id="@+id/imageButtonCamera"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:layout_marginTop="32dp"
        android:layout_marginBottom="149dp"
        android:background="@null"
        android:scaleType="fitXY"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView"
        app:srcCompat="@drawable/ic_camera48" />

    <ImageButton
        android:id="@+id/imageButtonFolder"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="32dp"
        android:layout_marginBottom="149dp"
        android:background="@null"
        android:scaleType="fitXY"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView"
        app:srcCompat="@drawable/ic_folder48" />

    <Button
        android:id="@+id/buttonAdd"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="102dp"
        android:layout_marginTop="32dp"
        android:layout_marginBottom="69dp"
        android:text="Thêm"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageButtonCamera" />

    <Button
        android:id="@+id/buttonHuy"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="102dp"
        android:layout_marginBottom="69dp"
        android:text="Hủy"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageButtonFolder" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## 1.4. ThemDoVatActivity.java
____________________________________________________________________________________________________
- sau khi thiết kế UI cho activity_them_do_vat.xml
- trong ThemDoVatActivity.java tiến hành khai báo ánh xạ các View đã thiết kế trong UI
- bắt sự kiện click vào ImageButton Camera 
  - sử dụng Implicit Intent với action ``MediaStore.ACTION_IMAGE_CAPTURE``
  - sử dụng ``startActivityForResult()`` để kích hoạt Intent sẽ trả về kết quả
  
> đối với API < 6, không cần thiết lập hỏi xin quyền sử dụng Camera từ người dùng
> từ API >= 6, cần cài đặt code xin quyền từ người dùng
  
- bắt sự kiện click vào ImageButton Folder
  - khai báo sử dụng quyền đọc bộ nhớ trong AndroidManifest.xml
    - ``<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>``
  - sử dụng Implicit Intent với action ``Intent.ACTION_PICK`` để sử action chọn file trong bộ nhớ
  - chỉ định loại file chọn chỉ là __image__ với ``intent.setType("image/*");`` 
  - sử dụng ``startActivityForResult()`` để kích hoạt Intent sẽ trả về kết quả
  
- override method ``onActivityResult()``
  - để nhận Bitmap từ Camera
    - kiểm tra requestCode, resultCode, data
    - nếu kiểm tra OK 3 điều kiện trên, nhận Bitmap từ data
  - để nhận Bitmap từ Folder
    - kiểm tra requestCode, resultCode, data
    - nếu kiểm tra OK 3 điều kiện trên
      - lấy Uri từ data
      - lấy InputStream từ Uri có được
      - nhận Bitmap từ BitmapFactory thông qua method ``decodeStream(InputStream)``
```java
package com.hienqp.sqlitesavingimagekpt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ThemDoVatActivity extends AppCompatActivity {
  Button btnAdd, btnCancel;
  EditText edtTen, edtMota;
  ImageButton ibtnCamera, ibtnFolder;
  ImageView imgHinh;
  private int REQUEST_CODE_CAMERA = 1;
  private int REQUEST_CODE_FOLDER = 2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_them_do_vat);

    AnhXa();

    ibtnCamera.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
      }
    });

    ibtnFolder.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*"); // tất cả kiểu dữ liệu là image
        startActivityForResult(intent, REQUEST_CODE_FOLDER);
      }
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
      Bitmap bitmap = (Bitmap) data.getExtras().get("data"); // key mặc định get dữ liệu là "data"

      imgHinh.setImageBitmap(bitmap);
    }

    if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null) {
      Uri uri = data.getData();
      try {
        InputStream inputStream = getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

        imgHinh.setImageBitmap(bitmap);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    super.onActivityResult(requestCode, resultCode, data);
  }

  private void AnhXa() {
    btnAdd      = (Button)      findViewById(R.id.buttonAdd);
    btnCancel   = (Button)      findViewById(R.id.buttonHuy);
    edtMota     = (EditText)    findViewById(R.id.editTextMoTa);
    edtTen      = (EditText)    findViewById(R.id.editTextTenDoVat);
    imgHinh     = (ImageView)   findViewById(R.id.imageViewHinh);
    ibtnCamera  = (ImageButton) findViewById(R.id.imageButtonCamera);
    ibtnFolder  = (ImageButton) findViewById(R.id.imageButtonFolder);
  }
}
```

## 1.5. Database.java - Class Tương Tác Với SQLite Để Lưu Trữ Hình Ảnh
____________________________________________________________________________________________________
- tạo class Database.java extends SQLiteOpenHelper
  - implements 2 method ``onCreate()`` và ``onUpgrade()``
  - override Constructor 4 tham số
  - tạo 2 method truy vấn không trả dữ liệu và truy vấn trả dữ liệu
- Database.java
```java
package com.hienqp.sqlitesavingimagekpt;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
```

## 1.6. MainActivity.java - Thao Tác Với Database
____________________________________________________________________________________________________
- trở lại MainActivity, sau khi khởi tạo ánh xạ các thành phần giao diện, trước khi bắt sự kiện click
vào Button Thêm Đồ Vật:
  - khởi tạo đối tượng Database từ Constructor với tên của Database là ``"QuanLy.sqlite"``
  - gọi phương thức QueryData từ Database để tạo Table với
    - DoVat: tên Table
    - Id: thiết lập tự động bởi hệ thống
    - Ten: tên đồ vật kiểu VARCHAR
    - Mota: mô tả đồ vật kiểu VARCHAR
    - Hinh: dữ liệu hình ảnh của đồ vật kiểu BLOB
  
```java
package com.hienqp.sqlitesavingimagekpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  Button btnThem;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnThem = (Button) findViewById(R.id.buttonThem);

    // khởi tạo database với các tham số của Constructor database
    Database database = new Database(MainActivity.this, "QuanLy.sqlite", null, 1);

    // truy vấn khởi tạo table với các column
    // lưu ý: đối với HinhAnh thì kiểu của nó là BLOB (Binary Large OBject - đối tượng nhị phân lớn) - BLOB là 1 kiểu chung chung
    // để ám chỉ việc lưu 1 đối tượng dữ liệu kích thước lớn
    // và hình ảnh trong SQLite có kiểu là mảng byte - byte[]
    // tron Database.java ta sẽ thêm 1 function truyền mảng byte vào SQLite
    database.QueryData("CREATE TABLE IF NOT EXISTS DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), MoTa VARCHAR(250), HinhAnh BLOB)");

    btnThem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, ThemDoVatActivity.class));
      }
    });
  }
}
```

## 1.7. Database.java - Định Nghĩa Phương Thức Insert 1 Item Vào Table
____________________________________________________________________________________________________
- do ở SQLite này có lưu trữ 1 dữ liệu kiểu đặc biệt là hình ảnh, nên trong __Database.java__ ta thêm 1 method
chỉ dùng để lưu hình ảnh ngoài các phương thức QueryData và GetData
  
```java
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
```

- vẫn có thể xây dựng function như trên để INSERT những đối tượng có thuộc tính đơn giản.


## 1.7. ThemDoVatActivity.java - Thao Tác Với Database Từ ThemDoVatActivity
____________________________________________________________________________________________________

## 1.7.1. Xử Lý Sự Kiện Ở Button Add Trong ThemDoVatActivity
____________________________________________________________________________________________________
- trong class ThemDoVatActivity tiến hành xử lý sự kiện thêm đồ vật với các thuộc tính vào database 
với button Them.
  
- ở class MainActivity ta đã khởi tạo đối tượng Database, nếu muốn sử dụng đối tượng này ở class
ThemDoVatActivity mà không cần khởi tạo lại, trong class MainActivity ta thay đổi đối tượng Database sẽ là
  1 biến toàn cục ``public static Database database;``, từ đó ta có thể gọi đối tượng ``database`` từ
  class ThemDoVatActivity.
  
```java
public class MainActivity extends AppCompatActivity {
    Button btnThem;
    public static Database database; // THIẾT LẬP BIẾN Database TRỞ THÀNH BIẾN TOÀN CỤC public static

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThem = (Button) findViewById(R.id.buttonThem);

        database = new Database(MainActivity.this, "QuanLy.sqlite", null, 1);
        
        database.QueryData("CREATE TABLE IF NOT EXISTS DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), MoTa VARCHAR(250), HinhAnh BLOB)");

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThemDoVatActivity.class));
            }
        });
    }
}
```

- trong class ThemDoVatActivity, tiến hành bắt sự kiện cho btnAdd khi user nhấn vào button Add để add đồ vật vào database
- trong sự kiện của btnAdd, trước khi INSERT dữ liệu vào database, ta tiến hành chuyển resource Drawable về byte[]

```java
public class ThemDoVatActivity extends AppCompatActivity {
    Button btnAdd, btnCancel;
    EditText edtTen, edtMota;
    ImageButton ibtnCamera, ibtnFolder;
    ImageView imgHinh;
    private int REQUEST_CODE_CAMERA = 1;
    private int REQUEST_CODE_FOLDER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_do_vat);

        AnhXa();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyển ImageView -> byte[]
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgHinh.getDrawable(); // lấy resource Drawable cast về BitmapDrawable
                Bitmap bitmap = bitmapDrawable.getBitmap(); // chuyển resource BitmapDrawable về dạng Bitmap
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream(); // tạo đối tượng chứa dữ liệu đầu ra dạng mảng byte
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray); // nén (compress) đối tượng Bitmap với format, quality (100 là mặc định, muốn chất lượng cao < 100) vào ByteArrayOutputStream
                byte[] hinhAnh = byteArray.toByteArray(); // chuyển thành mảng byte[] có thể lưu vào database

                // tiến hành insert dữ liệu vào database
                MainActivity.database.INSERT_DOVAT(
                        edtTen.getText().toString().trim(),
                        edtMota.getText().toString().trim(),
                        hinhAnh
                );

                Toast.makeText(ThemDoVatActivity.this, "Đã Thêm", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ThemDoVatActivity.this, MainActivity.class));
            }
        });

        ibtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });

        ibtnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*"); // tất cả kiểu dữ liệu là image
                startActivityForResult(intent, REQUEST_CODE_FOLDER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data"); // key mặc định get dữ liệu là "data"

            imgHinh.setImageBitmap(bitmap);
        }

        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgHinh.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void AnhXa() {
        btnAdd      = (Button)      findViewById(R.id.buttonAdd);
        btnCancel   = (Button)      findViewById(R.id.buttonHuy);
        edtMota     = (EditText)    findViewById(R.id.editTextMoTa);
        edtTen      = (EditText)    findViewById(R.id.editTextTenDoVat);
        imgHinh     = (ImageView)   findViewById(R.id.imageViewHinh);
        ibtnCamera  = (ImageButton) findViewById(R.id.imageButtonCamera);
        ibtnFolder  = (ImageButton) findViewById(R.id.imageButtonFolder);
    }
}
```

## 1.7.2. Đổ Hình Ảnh Ra Custom Adapter Hiển Thị Thông Tin Đồ Vật Được Thêm Ở Màn Hình MainActivity
____________________________________________________________________________________________________
- thiết kế giao diện ở màn hình MainActivity 1 ListView là nơi sẽ chứa các View là mỗi item đồ vật

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/buttonThem"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:drawableLeft="@android:drawable/ic_input_add"
        android:text="Thêm Đồ Vật"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ListView
        android:id="@+id/listviewDoVat"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/buttonThem" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

- định nghĩa 1 class DoVat (là đối tượng View trên ListView)

```java
package com.hienqp.sqlitesavingimagekpt;

public class DoVat {
    private int Id;
    private String Ten;
    private String MoTa;
    private byte[] Hinh;

    public DoVat(int id, String ten, String moTa, byte[] hinh) {
        Id = id;
        Ten = ten;
        MoTa = moTa;
        Hinh = hinh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] hinh) {
        Hinh = hinh;
    }
}
```

- tạo 1 layout ``dong_do_vat.xml`` để hiển thị mỗi View trên ListView

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageHinhCustom"
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:padding="10dp"></ImageView>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:id="@+id/textviewTenCustom"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="Tên đồ vật"
            android:textColor="#009688"
            android:textSize="24sp"></TextView>

        <TextView
            android:id="@+id/textviewMoTaCustom"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="Mô tả đồ vật"
            android:textColor="#4CAF50"
            android:textSize="20sp"></TextView>
    </LinearLayout>

</LinearLayout>
```

- tạo 1 class Adapter

```java
package com.hienqp.sqlitesavingimagekpt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DoVatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DoVat> doVatList;

    public DoVatAdapter(Context context, int layout, List<DoVat> doVatList) {
        this.context = context;
        this.layout = layout;
        this.doVatList = doVatList;
    }

    @Override
    public int getCount() {
        return doVatList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtTen, txtMoTa;
        ImageView imgHinh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTen = convertView.findViewById(R.id.textviewMoTaCustom);
            holder.txtMoTa = convertView.findViewById(R.id.textviewMoTaCustom);
            holder.imgHinh = convertView.findViewById(R.id.imageHinhCustom);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DoVat doVat = doVatList.get(position);

        holder.txtTen.setText(doVat.getTen());
        holder.txtMoTa.setText(doVat.getMoTa());

        // ĐỂ CÓ THỂ LẤY DỮ LIỆU MẢNG BYTE GÁN LÊN 1 VIEW, CẦN CHUYỂN MẢNG BYTE VỀ DẠNG BITMAP
        byte[] hinhAnh = doVat.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0, hinhAnh.length);

        holder.imgHinh.setImageBitmap(bitmap);

        return convertView;
    }
}
```

- thực hiện đổ dữ liệu ra ListView, trong MainActivity.java ta thực hiện các bước sau
  - khai báo toàn cục: ListView, ArrayList<DoVat>, DoVatAdapter
  - ánh xạ ListView, khởi tạo ArrayList<DoVat> khi vừa vào onCreate()
  - khởi tạo Adapter và setAdapter cho ListView
  - SQL lấy dữ liệu sau câu lệnh tạo bảng cho database, kết quả trả về là Cursor
  - dùng Cursor có được duyệt từng phần tử trong bảng dữ liệu thêm dữ liệu và ArrayList<DoVat>
  - Adapter.notifyDataSetChanged() cho Adapter hiển thị dữ liệu mới nhất
  
```java
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
```

- Với các bước trên, ta đã thực hiện thêm và lấy hình ảnh ra từ SQLite.
- SQLite có đặc tính chỉ lưu cục bộ, database mỗi thiết bị sẽ không giống nhau