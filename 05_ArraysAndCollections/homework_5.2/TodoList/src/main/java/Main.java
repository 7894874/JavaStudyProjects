
import java.util.Scanner;

/**
 * Цель задания
 * <p>
 * Научиться работать со списком ArrayList.
 * <p>
 * Что нужно сделать
 * <p>
 * Задание выполняйте в проекте
 * <p>
 * 05_ArraysAndCollections/homework_5.2/TodoList.
 * <p>
 * Разработайте программу — список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
 * Для работы с данными списка дел в проекте находится класс TodoList,
 * который должен отвечать за хранение и работу со списком дел.
 * Реализуйте все методы и проверьте класс с помощью существующих тестов.
 * В классе Main напишите код для реализации взаимодействия с пользователем через ввод команд в консоль.
 * Принцип работы команд:
 * <p>
 * LIST — выводит дела с их порядковыми номерами;
 * ADD — добавляет дело в конец списка или дело на определённое место,
 * сдвигая остальные дела вперёд, если указать номер;
 * если указан несуществующий индекс - добавить в конец списка.
 * EDIT — заменяет дело с указанным номером; если указан несуществующий индекс - ничего не делать.
 * DELETE — удаляет; если указан несуществующий индекс - ничего не делать.
 * Команды вводятся пользователем в консоль одной строкой.
 * <p>
 * Примеры работы со списком дел (жирным шрифтом выделен ввод пользователя)
 * <p>
 * ADD buy milk
 * Добавлено дело "buy milk"
 * ADD learn java
 * Добавлено дело "learn java"
 * LIST
 * 0 - buy milk
 * 1 - learn java
 * EDIT 0 make a cup of tea
 * Дело "buy milk" заменено на "make a cup of tea"
 * DELETE 1
 * Дело "learn java" удалено
 * LIST
 * 0 - make a cup of tea
 * DELETE 100
 * Дело с таким номером не существует
 **/


public class Main {

    public static void main(String[] args)  {

        // TODO: написать консольное приложение для работы со списком дел todoList
        //// Создаем сам экземпляр TodoList (по схеме)
        //// Объект имяОбъекта = new классОбъекта();
        TodoList todoListCurrent = new TodoList();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String currentCommant = input.split(" ")[0];
            String[] currentCommandArray = input.split(" ");

            switch (currentCommant) {

                case "ADD":

                    int iAddIndex = input.indexOf(" ");
                    String currentTodo = input.substring(iAddIndex).trim();
                    todoListCurrent.add(currentTodo);

                    break;

                case "LIST":

                    for (String stringWithEmail : todoListCurrent.getTodos()) {
                        System.out.println(stringWithEmail);
                    }
                    if (!todoListCurrent.getTodos().isEmpty()) System.out.println("ToDoList is Empty!!!");

                    break;

                case "EDIT":

                    if (!todoListCurrent.getTodos().isEmpty()) {
                        int indexToEnter = Integer.parseInt(currentCommandArray[1]);
                        String currentTodo1 = input.substring(input.indexOf("T") + 2 + currentCommandArray[1].length()).trim();
                        todoListCurrent.edit(currentTodo1, indexToEnter);
                    } else System.out.println("The todoList is Empty!!!");

                    break;

                case "DELETE":

                    if (!todoListCurrent.getTodos().isEmpty()) {
                        int indexToEnter1 = Integer.parseInt(currentCommandArray[1]);

                        System.out.println("Дело с номером " + indexToEnter1 + " успешно удалено!");

                        todoListCurrent.delete(indexToEnter1 - 1);
                        break;

                    } else System.out.println("Not correct data!!! The set is Empty!!!");

                    break;

                case ("?HELP"):
                case ("?help"):
                case ("help"):
                case ("?"):

                    System.out.println("**************************************************************");
                    System.out.println("ADD <String case>");
                    System.out.println("LIST");
                    System.out.println("DELETE <index>, where index - some digit [0 or 1 or else]");
                    System.out.println("EDIT <Int index> <String case>");
                    System.out.println("**************************************************************");

                    break;

                default:

                    System.out.println("Wrong command! Try type ? or help for commands listing!");

            }
        }
    }
}

