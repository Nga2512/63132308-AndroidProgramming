package ntu.anh63133403.ttl3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView txtKetQua;
    Button btnChoiLai, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtKetQua = findViewById(R.id.tvResult);
        btnChoiLai = findViewById(R.id.btnRetry);
        btnThoat = findViewById(R.id.btnExit);

        int diem = getIntent().getIntExtra("score", 0);
        txtKetQua.setText("Bạn được: " + diem + "/10");

        btnChoiLai.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
            startActivity(intent);
            finish();
        });

        btnThoat.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
