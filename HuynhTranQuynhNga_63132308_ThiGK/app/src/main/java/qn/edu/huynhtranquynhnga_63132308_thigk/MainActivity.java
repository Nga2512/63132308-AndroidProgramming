package qn.edu.huynhtranquynhnga_63132308_thigk;


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

        Button btnCn1 = findViewById(R.id.btncn1);
        Button btnCn2 = findViewById(R.id.btncn2);
        Button btnCn3 = findViewById(R.id.btncn3);
        Button btnCn4 = findViewById(R.id.btncn4);

        btnCn1.setOnClickListener(v -> startActivity(new Intent(this, MainActivityCau1.class)));
        btnCn2.setOnClickListener(v -> startActivity(new Intent(this, MainActivityCau2.class)));
        btnCn3.setOnClickListener(v -> startActivity(new Intent(this, MainActivityCau3.class)));
        btnCn4.setOnClickListener(v -> startActivity(new Intent(this, MainActivityCau4.class)));
    }
}
