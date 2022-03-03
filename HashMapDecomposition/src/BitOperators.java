public class BitOperators {

    public static void main(String[] args) {

        bitOperationNot(10);
        bitOperationAND(10, 11);

        System.out.println(bitShiftToRight(10, 1));
        System.out.println(bitShiftToLeft(10, 1));
        System.out.println(bitOperationOR(10, 11));
        System.out.println(bitOperationNotOR(10, 11));

    }

    static void bitOperationNot(int someDigit) {

        /**
         * Данный оператор заменяет все нули на единицы, а единицы — на нули.
         * Предположим, у нас есть число 10 в десятичной системе исчисления.
         * В двоичной системе это число равно 1010. Если применить к данному
         * числу унарный побитовый оператор отрицания, мы получим примерно следующее:
         */

        System.out.println("Побитовый унарный оператор NOT ~ Примеры:");

        /**
         *
         * В первой строке мы получим значение в двоичной системе счисления без ведущих нулей.
         * Хоть мы их не видим, они есть. Об этом говорит вторая строка, в которой все биты трансформировались в обратные.
         * Именно поэтому мы видим так много ведущих единиц. Это бывшие ведущие нули,
         * которые игнорировались компилятором при выводе в первой строки.
         *
         */

        System.out.println(" bitOperanot = " + someDigit + "; binary string = " + Integer.toBinaryString(someDigit));

        /**
         * Данный оператор заменяет все нули на единицы, а единицы — на нули.
         * Предположим, у нас есть число 10 в десятичной системе исчисления.
         * В двоичной системе это число равно 1010. Если применить к данному
         * числу унарный побитовый оператор отрицания, мы получим примерно следующее:
         */

        System.out.println("~bitOperanotNot = " + ~someDigit + "; binary string = " + Integer.toBinaryString(~someDigit)+"\n");

    }

    static void bitOperationAND(int someDigit1, int someDigit2) {

        /**
         *
         * Данный оператор применим к двум числам. Он производит операцию AND между битами каждого числа.
         *
         */

        System.out.println("Побитовый оператор AND Пример: "+someDigit1+" & "+someDigit2);
        System.out.println("Побитовый оператор AND Пример в двоичном коде: "+Integer.toBinaryString(someDigit1)+" & "+Integer.toBinaryString(someDigit2));

        int result = someDigit1 & someDigit2;

        System.out.println("Результат в двоичном коде "+Integer.toBinaryString(result)+
                ", Результат в десятичном коде "+result + "\n");

    }


    static int bitShiftToRight(int h, int intShift) {

        /**
         При операции сдвига мы теряем правые биты. Они попросту исчезают.

         Крайний левый бит — показатель знака числа (0 — число положительное, 1 — отрицательное). Поэтому
         в итоговом значении он ставится таким же, как и в исходном числе. Пример с отрицательным числом:
         Крайний правый бит потерялся, а крайний левый бит скопирован из исходного числа,
         как почетный показатель знака числа.
         Теперь. Что можно сказать о числах, над которыми осуществляется сдвиг вправо?
         Они делятся на 2. Каждый раз, осуществляя сдвиг на один бит вправо мы делим исходное число на 2.
         Если число нацело на 2 не делится, результат будет округлен в сторону минус бесконечности (в меньшую сторону).

         Но это работает, только если мы сдвигаем биты ровно на 1.
         А если на 2 бита, делим на 4.
         На 3 бита — делим на 8.
         На 4 бита — на 16.
         **/

        System.out.println("Исходное h = "+h+" (h >> "+intShift+") - побитовый сдвиг вправо на "+intShift);

        return h >> intShift;

    }

    static int bitShiftToLeft(int h, int intShift) {

        /**
         Результатом операции будет число 20 в десятичной системе.
         Если intShift = 1, то
         Все биты сдвигаются влево на 1.
         При этой операции значение старшего бита (крайнего левого) теряется.
         А самый младший бит (крайний правый) заполняется нулем.
         Сдвигая биты числа X на N битов влево мы умножаем число X на 2N
         **/

        System.out.println("Исходное h = "+h+" (h << " +intShift+ ") - Побитовый сдвиг влево на "+intShift);
        return h << intShift;

    }


    static int bitOperationOR(int orShift1, int orShift2) {

        System.out.println("Побитовый оператор OR Пример: "+orShift1+" | "+orShift2);
        return orShift1 | orShift2;

    }

    static int bitOperationNotOR(int orShift1, int orShift2) {

        System.out.println("Побитовая операция, исключающее ИЛИ (XOR)  исходные значения Пример: "+orShift1+" ^ "+orShift2);

        return orShift1 ^ orShift2;

    }

    static int hash_final(int h) {

        System.out.println("Исходное "+h);
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);

    }

}
