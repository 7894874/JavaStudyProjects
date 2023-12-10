public class Main {


//        Алгоритм быстрой сортировки на Java
//        Быстрая сортировка, также известная как Quick Sort или сортировка Хоара,
//        является одним их самых эффективных алгоритмов. Она включает в себя три этапа:
//
//       1. Из массива выбирается опорный элемент, чаще всего посередине массива.
//       2. Другие элементы массива распределяются таким образом, чтобы меньшие размещались до него, а большие — после.
//       3. Далее первые шаги рекурсивно применяются к подмассивам, которые разделились
//           опорным элементом на две части — слева и справа от него.
//
//                Пример быстрой сортировки на языке Java:

//       Сложность алгоритма: O(n log n)


    public static void quickSort(int[] sortArr, int low, int high) {

        //// Завершить,если массив пуст или уже нечего делить

        if (sortArr.length == 0 || low >= high) return;

        //// Выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = sortArr[middle];

        //// Разделяем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border) i++;
            while (sortArr[j] > border) j--;
            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        // Рекурсия для сортировки левой и правой части
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }

    public static void main(String args[]) {

        int[] sortArr = {12, 6, 4, 1, 15, 10, 324, 100, 23, 985};
        quickSort(sortArr, 0, sortArr.length - 1);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + "\n");
        }
    }
}

