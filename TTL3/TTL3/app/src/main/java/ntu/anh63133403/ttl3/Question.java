package ntu.anh63133403.ttl3;

import java.util.List;

public class Question {
    public String cauhoi;
    public List<String> phuongan;
    public int dapan_dung;

    // Constructor mặc định cần thiết cho Firebase
    public Question() {
    }

    // Constructor tiện lợi nếu bạn muốn tạo đối tượng thủ công
    public Question(String cauhoi, List<String> phuongan, int dapan_dung) {
        this.cauhoi = cauhoi;
        this.phuongan = phuongan;
        this.dapan_dung = dapan_dung;
    }
}