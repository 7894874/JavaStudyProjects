
public class Concatenation {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        //// Почему нужно накапливать вместо простой строки использовать StringBuilder
        //// Потому, что если мы просто берем строку и добавляем к ней текст к примеру 1000 раз тогда
        //// получается, что каждый раз когда мы его добавляем будет создаваться новая строка общей
        //// длинны равной сумме длинны строки на предыдущей итерации и текущей добавляемой строки
        //// т.е. туда будет копироваться строка которая получилась на предыдущей итерации и новая строка
        //// и соответственно время копирования этой строки будет увеличиваться и расти экспоненциально
        //// т.е. будет тратиться время еще и на копирование предыдущей увеличенной строки


        //// С использованием StringBuilder время конкатенации строк увеличивается в 1000 раз

        StringBuilder builder = new StringBuilder();

        // String str = "";
        for (int i = 0; i < 2000; i++) {

            // str += "some text some text some text";
            builder.append("some text some text");
        }
        System.out.println(builder.toString().length());

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
