package qn.edu.luyentap;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class Cau3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(items, item -> Toast.makeText(this, "Bạn chọn: " + item, Toast.LENGTH_SHORT).show()));
    }
}
