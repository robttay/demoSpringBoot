package com.tiy.demoSpringBoot;

import com.tiy.demoSpringBoot.Grade;
import com.tiy.demoSpringBoot.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private String firstName;
    private Model model;

    @RequestMapping("/new_student")
    public String newStudent(Model model) {
        model.addAttribute("grades", Grade.values());
        return "new_student";

    }



    @RequestMapping("/create_student")
    public String createStudent(@RequestParam(value="first_name") String firstName,
                                @RequestParam(value="last_name") String lastName,
                                @RequestParam(value="grade") Grade grade, Model model) {

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGrade(grade);

        model.addAttribute("student", student);
        /* set student firstName, lastName and grade using the http request parameters */

        /* add the student to the model that will be used by the view_student html file */

        return "view_student";
    }
}
