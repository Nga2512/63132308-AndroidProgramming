package qn.edu.luyentap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCau1 = findViewById(R.id.btnCau1);
        Button btnCau2 = findViewById(R.id.btnCau2);
        Button btnCau3 = findViewById(R.id.btnCau3);
        Button btnCau4 = findViewById(R.id.btnCau4);

        btnCau1.setOnClickListener(v -> startActivity(new Intent(this, Cau1Activity.class)));
        btnCau2.setOnClickListener(v -> startActivity(new Intent(this, Cau2Activity.class)));
        btnCau3.setOnClickListener(v -> startActivity(new Intent(this, Cau3Activity.class)));
        btnCau4.setOnClickListener(v -> startActivity(new Intent(this, Cau4Activity.class)));
    }
}
