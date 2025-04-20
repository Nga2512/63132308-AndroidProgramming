package qn.edu.huynhtranquynhnga_63132308_thigk;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityCau2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cau2);

        ListView lvSongs = findViewById(R.id.lvSongs);
        String[] songs = {
                "Tiến về Sài Gòn",
                "Giải phóng miền Nam",
                "Đất nước trọn niềm vui",
                "Bài Ca thống nhất",
                "Mùa xuân trên thành phố Hồ Chí Minh",
                "...."
        };

        // Gán danh sách bài hát vào ListView bằng Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songs);
        lvSongs.setAdapter(adapter);

        // Xử lý khi click vào một bài hát
        lvSongs.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSong = songs[position];
            Toast.makeText(MainActivityCau2.this, "Bài hát: " + selectedSong, Toast.LENGTH_SHORT).show();
        });
    }
}
