public class Main {

    public static void main(String[] args) {

        //// Добавляем нужные нам данные в массив
        /// Создаем сам массив данных
        // Integer[] nums = {};

        //// Добавляем данные чисел в массив
        Integer[] nums = new Integer[0];
        for (int i = 1; i <= 1000; i++)

            nums = append(nums, i);

        System.out.println(getMaxValue(nums));

        ///// Для примера проверяем рекурсию (перезагружаем стек вызова)
        //// Здесь будет вызвана ошибка (количество памяти задается параметром памяти -Xss (stack size) 2M)
        //// Run-->EditConfigurations--> -Xss2M )
        checkStack(1);

        //// Рекурсивные алгоритмы это такие алгоритмы которые вызывают сами себя

    }

    //// Вычисляем максимальное число в массиве данных
    public static Integer getMaxValue(Integer[] values) {

        int maxValue = Integer.MIN_VALUE;
        for (int value : values) {

            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    ///// Добавлем int данные в массив
    private static Integer[] append(Integer[] arr, int element) {

        Integer[] array = new Integer[arr.length + 1];
        System.arraycopy(arr, 0, array, 0, arr.length);
        array[arr.length] = element;

        return array;

    }

    public static void  checkStack(int i) {

        System.out.println(i);
        checkStack(i + 1);
    }

}