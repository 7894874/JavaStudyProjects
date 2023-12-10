import java.util.Random;

public class Main {
    public static void main(String[] args) {

    /** Теперь распечатаем элементы массива.
    Создаем объект с конструктором, используя класс TwoDimensionalArray
    После этого имеем возможность обращаться к его статическим методам и полноценно использвать их
    для получение данных печати. Размер зададим сами, произвольный для печати
     Получим интересную картинку с иксом! Будем считать, что это Mitsubishi Lancer symbol :-)
     **/
        char[][] currentArray = new TwoDimensionalArray().getTwoDimensionalArray(7);

        /** Ну тут все просто, распечатываем те данные в массиве, которые у нас получились **/
        System.out.print("************************* LANCER **********************************\n");
        System.out.print("");
        for (int i = 0; i < currentArray.length; i++) {
            System.out.print("              ");
            for (int j = 0; j < currentArray[0].length; j++) {

                System.out.print(""+ currentArray[i][j]);
            }
            System.out.println();
        }
        System.out.println("****************** IS THE BEST CAR!!! *************************");
    }
}
