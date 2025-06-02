package ntu.anh63133403.ttl3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class QuizActivity extends AppCompatActivity {

    TextView txtCauHoi, txtDiem;
    Button btnA, btnB, btnC;

    Random ngauNhien = new Random();
    int dapAnDung;
    int soThuTuCau = 0;
    int diem = 0;
    final int TONG_SO_CAU = 10;

    String[] cauHoiChu = {
            "Nếu bạn có 3 quả táo và mua thêm 4 quả nữa, bạn có bao nhiêu quả táo?",
            "Một lớp có 6 học sinh nam và 5 học sinh nữ. Tổng số học sinh là bao nhiêu?",
            "Bạn có 10 viên kẹo, chia đều cho 2 người. Mỗi người nhận được bao nhiêu viên?",
            "Một con mèo có 4 chân. 3 con mèo có tổng cộng bao nhiêu chân?",
            "Bạn có 15 cây bút, tặng bạn 5 cây. Bạn còn lại bao nhiêu cây bút?",
            "Tại một cửa hàng, bạn mua 7 chiếc bánh và ăn hết 3 chiếc. Còn lại bao nhiêu chiếc bánh?",
            "Một xe bus có 40 chỗ, hiện tại đã có 25 người lên xe. Còn lại bao nhiêu chỗ trống?",
            "Số 8 nhân với số 7 bằng bao nhiêu?",
            "Một người đi bộ 5 km, sau đó đi thêm 3 km nữa. Tổng quãng đường đi được là bao nhiêu km?",
            "Nếu bạn có 20 đồng và tiêu hết 13 đồng, bạn còn lại bao nhiêu đồng?",
            "Một cái bàn có 4 chân. Nếu có 5 cái bàn, tổng số chân là bao nhiêu?",
            "Bạn có 12 quyển sách, cho bạn 3 quyển. Bạn còn lại bao nhiêu quyển?",
            "Nếu một tuần có 7 ngày, thì 4 tuần có bao nhiêu ngày?",
            "Một bể nước có 30 lít, sử dụng 12 lít nước. Còn lại bao nhiêu lít nước?",
            "Nếu mua 9 cây kẹo và mỗi cây kẹo có giá 2 đồng, tổng số tiền phải trả là bao nhiêu?",
            "Bạn chạy bộ 3 km mỗi ngày, sau 7 ngày bạn chạy được bao nhiêu km?",
            "Một gia đình có 4 người, mỗi người ăn 2 quả táo. Tổng số quả táo ăn là bao nhiêu?",
            "Nếu bạn có 50 viên bi và chia đều cho 5 bạn, mỗi bạn được bao nhiêu viên?",
            "Một chiếc bánh có 8 miếng, bạn ăn mất 3 miếng. Còn lại bao nhiêu miếng bánh?",
            "Bạn có 100 đồng, mua 3 món đồ mỗi món 20 đồng. Bạn còn lại bao nhiêu tiền?"
    };

    int[] dapAnChu = {
            7, 11, 5, 12, 10, 4, 15, 56, 8, 7, 20, 9, 28, 18, 18, 21, 8, 10, 5, 40
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        txtCauHoi = findViewById(R.id.tvQuestion);
        txtDiem = findViewById(R.id.tvScore);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);

        View.OnClickListener xuLyClick = v -> {
            Button nutNhan = (Button) v;
            if (Integer.parseInt(nutNhan.getText().toString()) == dapAnDung) {
                diem++;
            }
            soThuTuCau++;
            if (soThuTuCau < TONG_SO_CAU) {
                taoCauHoi();
                txtDiem.setText("Điểm: " + diem);
            } else {
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("score", diem);
                startActivity(intent);
                finish();
            }
        };

        btnA.setOnClickListener(xuLyClick);
        btnB.setOnClickListener(xuLyClick);
        btnC.setOnClickListener(xuLyClick);

        taoCauHoi();
    }

    private void taoCauHoi() {
        boolean dungCauChu = ngauNhien.nextBoolean();

        if (dungCauChu) {
            int index = ngauNhien.nextInt(cauHoiChu.length);
            dapAnDung = dapAnChu[index];
            txtCauHoi.setText("Câu " + (soThuTuCau + 1) + ": " + cauHoiChu[index]);
        } else {
            int a = ngauNhien.nextInt(50) + 1;
            int b = ngauNhien.nextInt(49) + 1;
            int phepToan = ngauNhien.nextInt(4);
            String kyHieu;

            switch (phepToan) {
                case 0:
                    dapAnDung = a + b;
                    kyHieu = "+";
                    break;
                case 1:
                    if (a < b) { int temp = a; a = b; b = temp; }
                    dapAnDung = a - b;
                    kyHieu = "-";
                    break;
                case 2:
                    dapAnDung = a * b;
                    kyHieu = "×";
                    break;
                case 3:
                    dapAnDung = (a / b) * b;
                    a = dapAnDung;
                    dapAnDung = a / b;
                    kyHieu = "÷";
                    break;
                default:
                    dapAnDung = a + b;
                    kyHieu = "+";
            }

            txtCauHoi.setText("Câu " + (soThuTuCau + 1) + ": " + a + " " + kyHieu + " " + b + " = ?");
        }

        Set<Integer> boDapAn = new HashSet<>();
        boDapAn.add(dapAnDung);
        while (boDapAn.size() < 3) {
            int giaTriSai = dapAnDung + ngauNhien.nextInt(11) - 5;
            if (giaTriSai != dapAnDung && giaTriSai >= 0) boDapAn.add(giaTriSai);
        }

        List<Integer> danhSachDapAn = new ArrayList<>(boDapAn);
        Collections.shuffle(danhSachDapAn);

        btnA.setText(String.valueOf(danhSachDapAn.get(0)));
        btnB.setText(String.valueOf(danhSachDapAn.get(1)));
        btnC.setText(String.valueOf(danhSachDapAn.get(2)));
    }
}
