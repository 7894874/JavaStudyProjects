import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List somelist = new ArrayList();

    public static void main(String[] args) {

        //// Временная сложность обозначаеися O(n)
        /// где O временная сложность и n - количество элементов

        //// При бинарном поиске, каждый раз, когда мы не нашли какой либо элемент
        //// списке, то делим на 2 все время пока не найдем нужный элемент списка

        //// Если массив увеличивается на порядок, временная сложность будет расти не значительно
        //// логарифмически
        // O(log n)

        /// Если же н становиться большим, то более медленным будет поиск
        /// и поэтому придумали элементы бинарного поиска
        //// чтобы реализовать его, то его сначала отсортировывают по алфавиту
        //// алгоритм выглядит следующим образом

        //// Реализация метода бинарного поиска

        somelist.clear();
        for (int i = 0; i <= 10; i++) {
            somelist.add("element_" + i);
            System.out.println("Элементы добавлены!");
        }

        System.out.println("Вводим данные:");

        //   String somequeryStr = "";

        Scanner in = new Scanner(System.in);

        System.out.printf("Введите строку, которую нужно найти:\n");
        String somequeryStr = in.nextLine();
        in.close();

        if (!somequeryStr.isEmpty()) {

            int currentElement = 0;

            try {
                currentElement = search(somequeryStr, 0, 11);
            } catch (IOException e) {
                e.printStackTrace();

            }

            System.out.println(currentElement);

        }
    }

    private static int search(String query, int from, int to) throws IOException {

        int middle = (from + to) / 2;
        int comparsion = query.compareTo((String) somelist.get(middle));

        if (comparsion == 0) {
            return middle;
        }

        if (comparsion > 0) {
            return search(query, middle, to);
        }
        if (comparsion < 0) {
            return search(query, from, middle);
        }

        return middle;

        //return middle;

    }
}
