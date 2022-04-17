package vn.techmaster.project01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.project01.model.BMI;
import vn.techmaster.project01.model.Student;

@Controller
@RequestMapping("/")
public class HomeController {
    Random r = new Random();

    @GetMapping("/random")
    @ResponseBody
    public String random(){
        StringBuilder s = new StringBuilder();
        String collection = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 1; i <= 8; i++) {
            s.append(collection.charAt(r.nextInt(collection.length())));
        }
        return s.toString();
    }

    @GetMapping("/quote")
    @ResponseBody
    public String quote(){
        String[] quotes = {
            "Kiến tha lâu đầy tổ",
            "Có công mài sắt, có ngày nên kim",
            "Không thầy đố mày làm nên",
            "Học thầy không tày học bạn"
        };
        return quotes[r.nextInt(quotes.length)];
    }

    @PostMapping("/bmi")
    @ResponseBody
    public double bmi(@RequestBody BMI bmi){
        return bmi.getWeight() / (bmi.getHeight()  * bmi.getHeight());
    }

    private List<Student> students = new ArrayList<Student>();

    @GetMapping("/student")
    @ResponseBody
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("/student")
    @ResponseBody
    public List<Student> postStudents(@RequestBody Student student){
        students.add(student);
        return students;
    }
}
