package com.example.templateex1;

import com.example.templateex1.template.Implementation1;
import com.example.templateex1.template.Implementation2;
import com.example.templateex1.template.TemplateClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateEx1Application {

    public static void main(String[] args) {
        TemplateClass t1=new Implementation1();
        System.out.println(t1.operationTemplate());
        t1=new Implementation2();
        System.out.println(t1.operationTemplate());
    }

}
