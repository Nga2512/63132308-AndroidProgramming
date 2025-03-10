package ntu.anh.vd2intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainDangNhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangnhap);
    }
    public  void XacNhan(View v){
        //tạo đói tượng tham số thứ 2 là màn hình ta muoons chuyển sang
        Intent iManHinhKhac = new Intent(this, MainXacNhan.class);
        EditText U = findViewById(R.id.edtUser);
        EditText P = findViewById(R.id.editPass);
        EditText M = findViewById(R.id.editMail);

        String strA = U.getText().toString();
        String strB = P.getText().toString();
        String strC = M.getText().toString();
        if((strA.equals("TrongAnh"))&&(strB.equals("123"))){
            iManHinhKhac.putExtra("username", strA);
            startActivity(iManHinhKhac);
        }else{
            Toast.makeText(this, "Bạn nhập sai mk hoặc tên user. Hãy Nhập lại!!!", Toast.LENGTH_SHORT).show();
            U.setText(" ");
            P.setText(" ");
        }
    }
}