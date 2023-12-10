import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> currentToDoList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка

        //// Добавляет дело пометоду LIFO т.е в конец списка
        currentToDoList.add(todo);

    }

    public void add(int index, String todo) {

        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index > currentToDoList.size()) {
            currentToDoList.add(todo);
            System.out.println("Индекс вышел за пределы размера коллекции!");
        } else currentToDoList.add(index, todo);
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения

        if (index <= currentToDoList.size()) {
            currentToDoList.set(index, todo);
        } //else  System.out.println("Размер коллекции не соотвствует заявленному индексу");
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела

        if (index <= currentToDoList.size() - 1) {
            currentToDoList.remove(index);
        }
        //else
       //     System.out.println("Данного индекса, не существует в коллекции \n" +
      //                           "для корректного удаления элемента!!)");

    }

    //// Возвращаем список дел
    public ArrayList<String> getTodos() {

        return currentToDoList;

    }
}