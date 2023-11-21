package com.example.mobilele.web;

import com.example.mobilele.model.dto.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TestController {

    @ModelAttribute
    public Student addStudent(){
        return new Student().setUni("SoftUni");
    }

    @GetMapping("/test")
    public String test(@ModelAttribute Student student) {
        return "test";
    }

    //            int endNumber = 1900;
//
//            for (int i = 2023; i >= endNumber; i--) {
//                //System.out.println("<option value="2021">2021</option>");
//                System.out.println("<option value=\"" + i + "\">"+ i +"</option>");
//
//            }


}
