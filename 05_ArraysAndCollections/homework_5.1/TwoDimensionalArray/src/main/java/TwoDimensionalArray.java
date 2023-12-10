
public class TwoDimensionalArray {

    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] towDimentionalArray = new char[size][size];

        if (size == 1) {
            towDimentionalArray[size - 1][size - 1] = symbol;
        } else {
            //// Добавляем в массив нужные нам значения
            ///// Перебираем строки массива
            for (int i = 0; i < towDimentionalArray.length; i++) {
                ////// Перебираем элементы массива в строке с массивом (т.е. массив внутри массива (колонки))
                for (int j = 0; j < towDimentionalArray[0].length; j++) {
                    // if ((i + j) % size == 0) { -- Остаток от деления в таком виде не работает
                    /////  применяем знания высшей математики проходимся по диагонали нашей матрицы
                    /////  т.е. когда номер строки массива совпадает с номером колонки вложенного массива с колонками
                    if (i == j) {
                        towDimentionalArray[i][j] = symbol;
                    } else towDimentionalArray[i][j] = ' ';

                    /////  в случае убывающих значений в матрице, все не так просто и гладко, используем остаток от деления
                    ///// для верной реализации выставления условий выполнения простановок символа по строкам в порядке убывания
                    ///// к началу убывания элементов массива в строке (колонок)
                    if ((j + i) % (size - 1) == 0) {
                        towDimentionalArray[i][j] = symbol;
                    }
                }
            }
        }

        return towDimentionalArray;

    }
}
