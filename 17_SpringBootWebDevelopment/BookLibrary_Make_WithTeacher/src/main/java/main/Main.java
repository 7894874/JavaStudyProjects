package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
  Что нужно сделать, нужно сделать так, чтобы
  можно было добавить книгу методом POST и получить книгу методом GET
  Создадим контроллер для отдельных сущностей
*/

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}