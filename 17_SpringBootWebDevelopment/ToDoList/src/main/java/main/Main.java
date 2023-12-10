package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    Написать бэкэнд составляющую списка дел
    Он должен уметь:
     - Выводить список дел
     - Выводить информацию об одном деле
     - Добавлять дело
     - Удалять дело

     Проверить с помощью Postman или RestL Client

     Создать страницу на которой будет виден список своих дел
     добавление либо удаление дел и редактирование если получиться
 */


@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }

}
