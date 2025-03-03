package ntu.anh63133403.ex4_addsubmuldiv_onclick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editso1;
    EditText editso2;
    EditText editkq;
    Button nutCong ,nutTru, nutNhan, nutChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Timdieukhien();
    }
    void Timdieukhien(){
         editso1 = (EditText) findViewById(R.id.edtSo1);
         editso2 = (EditText) findViewById(R.id.edtSo2);
         editkq = (EditText) findViewById(R.id.edtkq);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }
    public void XuliCong(View v){

        //lay du lieu
        String soThu1 = editso1.getText().toString();
        String soThu2 = editso2.getText().toString();
        //chuyen du lieu
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //tinh
        float tong = soA + soB;
        //hien kq

        //xuat kq
        String kq = String.valueOf(tong);
        //
        editkq.setText(kq);
    }
    public void XuliTru(View v){

        //lay du lieu
        String soThu1 = editso1.getText().toString();
        String soThu2 = editso2.getText().toString();
        //chuyen du lieu
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //tinh
        float Hieu = soA - soB;
        //hien kq

        //xuat kq
        String kq = String.valueOf(Hieu);
        //
        editkq.setText(kq);
    }
    public void XuliNhan(View v){

        //lay du lieu
        String soThu1 = editso1.getText().toString();
        String soThu2 = editso2.getText().toString();
        //chuyen du lieu
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //tinh
        float tich = soA * soB;
        //hien kq

        //xuat kq
        String kq = String.valueOf(tich);
        //
        editkq.setText(kq);
    }
    public void XuliChia(View v){

        //lay du lieu
        String soThu1 = editso1.getText().toString();
        String soThu2 = editso2.getText().toString();
        //chuyen du lieu
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //tinh
        float thuong = soA / soB;
        //hien kq

        //xuat kq
        String kq = String.valueOf(thuong);
        //
        editkq.setText(kq);
    }
}