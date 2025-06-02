package ntu.anh63133403.ttl3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.*;
import java.util.*;

public class EnglishQuizActivity extends AppCompatActivity {
    TextView txtCauHoi, txtDiem;
    Button btnDapAnA, btnDapAnB, btnDapAnC;

    DatabaseReference duongDanDL;
    List<Question> danhSachCauHoi = new ArrayList<>();
    int chiSoCauHienTai = 0;
    int diem = 0;
    final int TONG_SO_CAU = 10;
    int dapAnDungIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_english_quiz);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets le = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(le.left, le.top, le.right, le.bottom);
            return insets;
        });

        txtCauHoi = findViewById(R.id.tvQuestion);
        txtDiem = findViewById(R.id.tvScore);
        btnDapAnA = findViewById(R.id.btnA);
        btnDapAnB = findViewById(R.id.btnB);
        btnDapAnC = findViewById(R.id.btnC);

        duongDanDL = FirebaseDatabase.getInstance().getReference("el_quiz");

        View.OnClickListener langNghe = v -> {
            Button nutDaChon = (Button) v;
            int viTriDaChon = Integer.parseInt(nutDaChon.getTag().toString());
            if (viTriDaChon == dapAnDungIndex) {
                diem++;
            }
            chiSoCauHienTai++;
            if (chiSoCauHienTai < TONG_SO_CAU && chiSoCauHienTai < danhSachCauHoi.size()) {
                hienThiCauHoi(chiSoCauHienTai);
                txtDiem.setText("Điểm: " + diem);
            } else {
                Intent intent = new Intent(EnglishQuizActivity.this, ResultActivity.class);
                intent.putExtra("score", diem);
                startActivity(intent);
                finish();
            }
        };

        btnDapAnA.setTag("0");
        btnDapAnB.setTag("1");
        btnDapAnC.setTag("2");

        btnDapAnA.setOnClickListener(langNghe);
        btnDapAnB.setOnClickListener(langNghe);
        btnDapAnC.setOnClickListener(langNghe);

        taiDanhSachCauHoi();
    }

    private void taiDanhSachCauHoi() {
        duongDanDL.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                danhSachCauHoi.clear();
                for (DataSnapshot item : snapshot.getChildren()) {
                    Question cauHoi = item.getValue(Question.class);
                    if (cauHoi != null) {
                        danhSachCauHoi.add(cauHoi);
                    }
                }
                Collections.shuffle(danhSachCauHoi);
                hienThiCauHoi(chiSoCauHienTai);
                txtDiem.setText("Điểm: " + diem);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xu ly loi neu can
            }
        });
    }

    private void hienThiCauHoi(int viTri) {
        Question cauHoi = danhSachCauHoi.get(viTri);
        txtCauHoi.setText("Câu " + (viTri + 1) + ": " + cauHoi.cauhoi);

        btnDapAnA.setText(cauHoi.phuongan.get(0));
        btnDapAnB.setText(cauHoi.phuongan.get(1));
        btnDapAnC.setText(cauHoi.phuongan.get(2));

        dapAnDungIndex = cauHoi.dapan_dung;
    }
}
