package qn.edu.huynhtranquynhnga_63132308_thigk;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityCau1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cau1);

        EditText edtAnswer = findViewById(R.id.edtAnswer);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String answer = edtAnswer.getText().toString().trim();
            if (answer.equals("30/4/1975")) {
                Toast.makeText(MainActivityCau1.this, "Đúng!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityCau1.this, "Sai! Đáp án là 30/4/1975", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
