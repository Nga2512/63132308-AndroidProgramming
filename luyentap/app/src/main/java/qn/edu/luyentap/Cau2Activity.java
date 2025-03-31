package qn.edu.luyentap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Cau2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);

        ListView listView = findViewById(R.id.listView);
        String[] items = {"Bài hát yêu thích", "Môn học đã học", "Chủ đề khác"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Bạn chọn: " + items[position], Toast.LENGTH_SHORT).show();
        });
    }
}
