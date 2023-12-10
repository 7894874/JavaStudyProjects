

/**
 * Цель задания
 * <p>
 * Научиться работать со множеством TreeSet.
 * <p>
 * Что нужно сделать
 * <p>
 * Задание выполняйте в проекте
 * 05_ArraysAndCollections/homework_5.3/EmailList
 * <p>
 * Напишите программу, в которой будет храниться перечень адресов электронной почты.
 * Адреса можно добавлять через консоль командой ADD и печатать весь список командой LIST.
 * Программа должна проверять корректность вводимых email и печатать сообщение об ошибке при необходимости.
 * Для работы с данными списка дел в проекте находится класс EmailList,
 * который должен отвечать за хранение и работу с электронными адресами.
 * Реализуйте все методы и проверьте класс с помощью существующих тестов.
 * Вы можете добавлять дополнительные методы в класс.
 * Принцип работы команд
 * <p>
 * LIST — выводит список электронных адресов.
 * ADD — проверяет и, если формат адреса верный, добавляет в множество.
 * Примеры команд
 * <p>
 * LIST
 * ADD hello@skillbox.ru
 * Команды вводятся одной строкой пользователем в консоль.
 * <p>
 * Примеры работы со списком электронных адресов (жирным шрифтом выделен ввод пользователя)
 * ADD mail@mail.ru
 * <p>
 * ADD hello@skillbox.ru
 * ADD hello@skillbox
 * ADD hello@skillbox.ru
 * <p>
 * LIST
 * hello@skillbox.ru
 * mail@mail.ru
 **/


import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //TODO: write code here
        //// Создаем сам экземпляр TreeSet
        EmailList emailList = new EmailList();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            int iAddIndex = input.indexOf(" ");

            if (iAddIndex != -1) {
                String currentCommand = input.substring(0, iAddIndex);
                String currentEmail = input.substring(iAddIndex, input.length()).trim();

                if (currentCommand.equals("ADD")) {
                    //// Специально оставляю ошибки, чтобы их больше не повторять!!!
                    //// emailList.treeSet.add(currentEmail);
                    emailList.add(currentEmail);
                }

            } else if (!emailList.getTreeSet().isEmpty()) {
                if (input.equals("LIST")) {

                    //// Специально оставляю ошибки, чтобы их больше не повторять!!!
                    ////   for (String stringWithEmail : emailList.treeSet) {
                    for (String stringWithEmail : emailList.getTreeSet()) {
                        System.out.println(stringWithEmail);
                    }
                }
            } else System.out.println("Not correct data!!! The set is Empty!!!");
        }
    }
}
