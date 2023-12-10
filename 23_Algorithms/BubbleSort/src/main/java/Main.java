import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        /// Алгоритм пузырьковой сортировки очень простой

        /// Создадим новый массив:
        int[] currentArrayList = {3, 4, 6, 19, 45, 34, 53, 436, 4, 1, 234};

        //// Отсортируем новый массив с помощью новых процедур и задействуем пузырьковою сортировку
        new BubblrSortCurrent(currentArrayList);

        //// Временная сложность этого алгоритма равна O(n2)
        //// Выведем все элементы массива
        for (int currentDigit : currentArrayList) {
            System.out.println(currentDigit);
        }

    }

}
