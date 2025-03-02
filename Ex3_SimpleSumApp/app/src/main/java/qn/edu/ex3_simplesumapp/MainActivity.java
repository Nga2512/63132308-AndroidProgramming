package qn.edu.ex3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;  // Sử dụng TextView thay vì EditText để hiển thị kết quả
import android.widget.Toast;

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

        // Xử lý padding của các thanh hệ thống
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Khởi tạo các EditText và Button
        EditText editTextsoA = findViewById(R.id.edtA);
        EditText editTextsoB = findViewById(R.id.edtB);
        TextView textKetQua = findViewById(R.id.kq); // Sử dụng TextView thay vì EditText
        Button btnSum = findViewById(R.id.cong); // Giả sử bạn có một button với id "btnSum"

        // Đặt sự kiện click cho button để gọi phương thức XuLyCong
        btnSum.setOnClickListener(v -> XuLyCong(editTextsoA, editTextsoB, textKetQua));
    }

    // Phương thức xử lý cộng
    public void XuLyCong(EditText editTextsoA, EditText editTextsoB, TextView textKetQua) {
        try {
            // Lấy giá trị từ các EditText
            String strA = editTextsoA.getText().toString();
            String strB = editTextsoB.getText().toString();

            // Kiểm tra nếu người dùng chưa nhập đủ số
            if (strA.isEmpty() || strB.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập cả hai số", Toast.LENGTH_SHORT).show();
                return;
            }

            // Chuyển đổi giá trị nhập thành số nguyên
            int soA = Integer.parseInt(strA);
            int soB = Integer.parseInt(strB);

            // Tính tổng
            int result = soA + soB;

            // Hiển thị kết quả vào TextView kết quả
            textKetQua.setText("" + result);

        } catch (NumberFormatException e) {
            // Xử lý lỗi khi người dùng nhập không phải số
            Toast.makeText(this, "Vui lòng nhập giá trị là số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}
