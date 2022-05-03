package com.example.demobeancar.bean;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class StreetMap {
    private String route;
    private SecureRandom rand ;
    private String[] froms = {" 2 Hàng Bạc, Hoàn Kiếm","79 Mai Hắc Đế, Hai Bà Trưng","15 Đoàn Trần Nghiệp, Hai Bà Trưng","48 Tố Hữu, Nam Từ Liêm"};
    private String[] tos = {"Sân bay Nội Bài","Royal City","Sân Gold Tam Đảo","Hồ Đồng Đò"};

    public StreetMap() {
        try {
            this.rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        this.route = "From: <b>" + getRandomFromArrayString(froms) + "</b> -> To: <b>" + getRandomFromArrayString(tos)
                + "</b>";
    }

    // Hàm generic lấy kiểu đầu vào T bất kỳ
    private <T> T getRandomFromArrayString(T[] array) {
        int index = this.rand.nextInt(array.length);
        return array[index];
    }

    public String getRoute() {
        return route;
    }
}
