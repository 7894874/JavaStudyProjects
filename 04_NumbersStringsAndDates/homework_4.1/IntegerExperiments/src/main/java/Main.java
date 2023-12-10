public class Main {

    private static Integer totalcountSum;

    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;

        int sum = sumDigits(7843);

        System.out.println(sum);
    }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1;
=======
  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    int sum = sumDigits(7843);

    System.out.println(sum);
  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */


    public static int sumDigits(Integer number) {

        totalcountSum = 0;

        //// Реализуем логику указанного метода

        if (number != null) {
            //// Преобразуем число в строку для дальнейших издевательств на ней
            String stringNumber = number.toString(number);

            /// Проверяем строка пустая или нет
            if (stringNumber.isEmpty()) {
                System.out.println("Cтрока пустая");
            } else {
                for (int i = 0; i < stringNumber.length(); i++) {
                    //// Читаем значение символов через метод charAt попутно получаем значение из char
                    //// через строковое представление char и затем преобразуем строковый символ в числовой int

                    char currentSymbolChar = stringNumber.charAt(i);
                    boolean isDigit = Character.isDigit(currentSymbolChar);

                    if (isDigit) {

                        int currentlyDigit = Integer.parseInt(String.valueOf(stringNumber.charAt(i)));
                          //// Делаем тоже самое но с помощью метода класса Character getNumericValue()
                        char currentCharDigit = stringNumber.charAt(i);
                        currentlyDigit = Character.getNumericValue(currentCharDigit);

                        //// считаем сумму Итоги
                        totalcountSum = totalcountSum + currentlyDigit;

                    } else {
                        System.out.println("Не целочисленное числоне цифра!!!");
                    }

                }
            }

            System.out.println(info(totalcountSum));

        } else {
            totalcountSum = -1;
        }

        return totalcountSum;

    }

    public static String info(Integer totalcountSumCasual) {

        return  "\n*************** Итоги расчета ***************************"+
        "\nЧисло в обычном виде:"+totalcountSumCasual+ " "+
        "\nШестнадцатиричное представление числа: "+totalcountSumCasual.toHexString(totalcountSumCasual)+
        "\n****************************************************************";

    }
}

