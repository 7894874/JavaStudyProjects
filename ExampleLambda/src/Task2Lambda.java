/**
 * 2)Написать функциональный интерфейс с методом, который принимает две строки
 * и возвращает тоже строку. Написать реализацию такого интерфейса в виде лямбды,
 * которая возвращает ту строку, которая длиннее.
 */


public class Task2Lambda {

    public static void main(String[] args) {

        StringInterface obj = ((Str1, Str2) -> {
            if (Str1.length() > Str2.length())
                return Str1;
            else
                return Str2;
        });
        String result = obj.compareStrings( "ThreeTowOneThreeTowOneImReadyForThe", "YouDontNeedAGun" );
        System.out.println( result );


    }
}