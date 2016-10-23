package com.acvrock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@SpringBootApplication
public class Ch72Application {

    @RequestMapping("/")
    public String index(Model model
    ) {
        Person single = new Person("aa", 11);

        ArrayList<Person> persons = new ArrayList<>();
        Person p1 = new Person("xx", 22);
        Person p2 = new Person("yy", 33);
        Person p3 = new Person("zz", 44);
        Person p4 = new Person("qq", 55);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        model.addAttribute("singlePerson",single);
        model.addAttribute("people",persons);
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch72Application.class, args);
    }
}
