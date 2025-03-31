package qn.edu.luyentap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Cau1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);

        EditText edtSoA = findViewById(R.id.edtSoA);
        EditText edtSoB = findViewById(R.id.edtSoB);
        Button btnTinhTong = findViewById(R.id.btnTinhTong);
        TextView txtKetQua = findViewById(R.id.txtKetQua);

        btnTinhTong.setOnClickListener(view -> {
            int soA = Integer.parseInt(edtSoA.getText().toString());
            int soB = Integer.parseInt(edtSoB.getText().toString());
            txtKetQua.setText("Kết quả: " + (soA + soB));
        });
    }
}

