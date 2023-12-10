import java.util.Scanner;


/**
 * Цель задания
 * Научиться работать с коллекцией Map.
 * <p>
 * Что нужно сделать
 * 1. Напишите программу, которая будет работать как телефонная книга:
 * <p>
 * Если вводим новое имя, программа просит ввести номер телефона и запоминает его.
 * Если новый номер телефона — просит ввести имя и также запоминает.
 * Если вводим существующее имя или номер телефона, программа выводит телефон(ы) или имя абонента соответственно.
 * При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.
 * <p>
 * 2. Определяйте имя и телефон с помощью регулярных выражений.
 * <p>
 * 3. Подумайте, что выбрать в качестве ключа и значения для Map, и выберите лучший,
 * по вашему мнению, вариант. Опишите, какие минусы и плюсы видите в своём выборе.
 * <p>
 * 4. Для работы с данными телефонной книги в проекте находится класс PhoneBook,
 * который должен отвечать за хранение и работу с абонентами.
 * Реализуйте все методы и проверьте класс с помощью существующих тестов.
 * Вы можете добавлять дополнительные методы в класс.
 * <p>
 * Команды вводятся пользователем в консоль одной строкой.
 * <p>
 * ************************************************************************************
 * <p>
 * Примеры работы с телефонной книгой (жирным шрифтом выделен ввод пользователя)
 * <p>
 * Введите номер, имя или команду:
 * Маша
 * Такого имени в телефонной книге нет.
 * <p>
 * Введите номер телефона для абонента “Маша”:
 * 79001234567
 * Контакт сохранен!
 * <p>
 * Введите номер, имя или команду:
 * 79007654321
 * Такого номера нет в телефонной книге.
 * <p>
 * Введите имя абонента для номера “79007654321”:
 * Маша
 * Контакт сохранен!
 * <p>
 * Введите номер, имя или команду:
 * /// Nfif@
 * Неверный формат ввода
 * <p>
 * Введите номер, имя или команду:
 * LIST
 * Маша - 79001234567, 79007654321
 */


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //TODO: write code here
        //// Создаем сам экземпляр TreeSet
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            /** Если вводим новое имя, программа просит ввести номер телефона и запоминает его.
             * Если новый номер телефона — просит ввести имя и также запоминает.
             * Если вводим существующее имя или номер телефона, программа выводит телефон(ы) или имя абонента соответственно.
             * При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.
             **/

            String currentCommant = input.split(" ")[0];

            if (!currentCommant.equals("LIST")) {

                if (phoneBook.findSymbolsFromPatternRx(input, "[0-1]")) {
                    String phoneNumber = input.trim();
                    if (phoneBook.getNameByPhone(phoneNumber) == null) {

                        {
                            System.out.println("Такого номера нет в телефонной книге...");
                            System.out.println("Введите имя для абонента с номером: " + phoneNumber + "");
                            String name = scanner.nextLine();

                            phoneBook.addContact(phoneNumber, name);
                        }
                    } else {
                        System.out.println(phoneBook.getNameByPhone(phoneNumber));
                    }
                }
                if (phoneBook.findSymbolsFromPatternRx(input, "[aA-zZ]")
                        || phoneBook.findSymbolsFromPatternRx(input, "[аА-яЯ]")) {

                    String name = input.trim();
                    if (phoneBook.getPhonesByName(name).isEmpty()) {
                        {
                            System.out.println("Такого имени нет в телефонной книге...");
                            System.out.println("Введите номер телефона для аббонента : " + name);
                            String phoneNumber = scanner.nextLine().trim();
                            phoneBook.addContact(phoneNumber, name);
                        }

                    } else {
                        System.out.println(phoneBook.printFoundedValue(name, phoneBook.getPhonesByName(name).toString()));
                    }
                }
            } else

                switch (currentCommant) {

                    case "LIST":

                        if (phoneBook.getAllContacts().isEmpty()) {
                            System.out.println("Your PhoneBook is empty! Please fill your phonebook first!");
                        } else {
                            System.out.println(phoneBook.getAllContacts());
                        }

                        break;

                    case ("?"):

                        System.out.println("Commands for operations with phonebook!");
                        System.out.println("LIST - for listing of all contacts from phonebook");
                        System.out.println("**************************************************************");

                    default:

                        System.out.println("Wrong command! Try type ? for commands listing!");

                }

        }

    }
}
