package com.jcore.gedichtengenerator;

import com.jcore.gedichtengenerator.service.RhymeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.FileNotFoundException;

@SpringBootApplication
public class GedichtenGeneratorApplication {

    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext ctx =SpringApplication.run(GedichtenGeneratorApplication.class, args);
        RhymeService rhymeService = (RhymeService) ctx.getBean("rhymeService");
        System.out.println(rhymeService.getRhymes());

    }

}
