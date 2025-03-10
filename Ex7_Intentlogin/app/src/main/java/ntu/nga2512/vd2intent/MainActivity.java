package ntu.anh.vd2intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
    public  void DangNhap(View v){
        //tạo đói tượng tham số thứ 2 là màn hình ta muoons chuyển sang
        Intent iManHinhKhac = new Intent(this, MainDangNhap.class);
        //thực hiện chuyển
        startActivity(iManHinhKhac);
    }
}