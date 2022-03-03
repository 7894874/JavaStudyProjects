import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Примеры Lambda-выражений
 * Лучший способ вникнуть в Lambda-выражения – это рассмотреть несколько примеров:
 * <p>
 * Поток Thread можно проинициализировать двумя способами:
 */

public class ExampleLambda {

    public static void main(String[] args) {

        // Старый способ:
        new Thread( new Runnable() {
            @Override
            public void run() {
                System.out.println( "Hello from thread" );
            }
        } ).start();


        // Новый способ:
        new Thread(
                () -> System.out.println( "Hello from thread" )
        ).start();


        /**
         *
         * Управление событиями в Java 8 также можно осуществлять через Lambda-выражения.
         * Далее представлены два способа добавления обработчика события ActionListener
         * в компонент пользовательского интерфейса:
         *


         // Старый способ:
         AbstractButton button = null;
         button.addActionListener( new
         ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
        System.out.println( "Кнопка нажата. Старый способ!" );
        }
        } );

         // Новый способ:
         button.addActionListener( (e) ->
         {
         System.out.println( "Кнопка нажата. Lambda!" );
         } );

         */

        /**
         *
         * Простой пример вывода всех элементов заданного массива. Заметьте, что есть более одного
         * способа использования lambda-выражения. Ниже мы создаем lambda-выражение обычным способом,
         * используя синтаксис стрелки, а также мы используем оператор двойного двоеточия (::),
         * который в Java 8 конвертирует обычный метод в lambda-выражение:
         *
         */

        // Старый способ:
        List<Integer> list = Arrays.asList( 1, 2, 3, 4, 5, 6, 7 );
        for (Integer n : list) {
            System.out.println( n );
        }
        // Новый способ:
        List<Integer> list2 = Arrays.asList( 1, 2, 3, 4, 5, 6, 7 );
        list2.forEach( n -> System.out.println( n ) );

        // Новый способ с использованием оператора двойного двоеточия ::
        list2.forEach( System.out::println );


        /**
         *
         *
         * В следующем примере мы используем функциональный интерфейс Predicate для создания теста и печати элементов,
         * прошедших этот тест. Таким способом вы можете помещать логику в lambda-выражения и делать что-либо на ее основе.
         *
         */

        List<Integer> list3 = Arrays.asList( 1, 2, 3, 4, 5, 6, 7 );

        System.out.print( "Выводит все числа: " );
        evaluate( list3, (n) -> true );

        System.out.print( "Не выводит ни одного числа: " );
        evaluate( list3, (n) -> false );

        System.out.print( "Вывод четных чисел: " );
        evaluate( list3, (n) -> n % 2 == 0 );

        System.out.print( "Вывод нечетных чисел: " );
        evaluate( list3, (n) -> n % 2 == 1 );

        System.out.print( "Вывод чисел больше 5: " );
        evaluate( list3, (n) -> n > 5 );


        /**
         *
         * Поколдовав над Lambda-выражениями можно вывести квадрат каждого элемента списка.
         * Заметьте, что мы используем метод stream(), чтобы преобразовать обычный список в поток.
         * Java 8 предоставляет шикарный класс Stream (java.util.stream.Stream).
         * Он содержит тонны полезных методов, с которыми можно использовать lambda-выражения.
         * Мы передаем lambda-выражение x -> x*x в метод map(), который применяет его ко всем элементам в потоке.
         * После чего мы используем forEach для печати всех элементов списка.
         *
         *
         *
         *
         */


        // Старый способ:
        List<Integer> list4 = Arrays.asList( 1, 2, 3, 4, 5, 6, 7 );
        for (Integer n : list4) {
            int x = n * n;
            System.out.println( x );
        }

        // Новый способ:
        List<Integer> list5 = Arrays.asList( 1, 2, 3, 4, 5, 6, 7 );
        list5.stream().map( (x) -> x * x ).forEach( System.out::println );

        /**
         *
         * Дан список, нужно вывести сумму квадратов всех элемента списка.
         * Lambda-выражения позволяет достигнуть этого написанием всего одной строки кода.
         * В этом примере применен метод свертки (редукции) reduce().
         * Мы используем метод map() для возведения в квадрат каждого элемента,
         * а потом применяем метод reduce() для свертки всех элементов в одно число.
         *
         *
         */

        // Старый способ:
        List<Integer> list6 = Arrays.asList(1,2,3,4,5,6,7);
        int sum = 0;
        for(Integer n : list6) {
            int x = n * n;
            sum = sum + x;
        }
        System.out.println(sum);

        // Новый способ:
        List<Integer> list7 = Arrays.asList(1,2,3,4,5,6,7);
        int sum7 = list7.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
        System.out.println(sum7);


        /**
        Отличие Lambda-выражений от анонимных класов
        Главное отличие состоит в использовании ключевого слова this. Для анонимных классов ключевое слово ‘this’
         обозначает объект анонимного класса, в то время как в lambda-выражении ‘this’ обозначает объект класса,
         в котором lambda-выражение используется.

            Другое их отличие заключается в способе компиляции. Java компилирует lambda-выражения с
        преобразованием их в private-методы класса. При этом используется инструкция invokedynamic,
        появившаяся в Java 7 для динамической привязки метода. Тал Вайс (Tal Weiss) описал в своем
         блоге как Java компилирует lambda-выражения в байт-код
        Заключение
        Марк Рейнхолд (Mark Reinhold - Oracle’s Chief Architect), назвал Lambda-выражения самым значительным
         изменением в модели программирования, которое когда-либо происходило — даже более значительным,
         чем дженерики (generics). Должно быть он прав, т.к. они дают Java программистам возможности
         функциональных языков программирования, которых так давно все ждали.
         Наряду с такими новшествами как методы виртуального расширения (Virtual extension methods),
         Lambda-выражения позволяют писать очень качественный код.
          Я надеюсь, что это статья позволила вам взглянуть под капот Java 8. Удачи :)
        */

    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test( n )) {
                System.out.print( n + " " );
            }
        }
        System.out.println();
    }
}
