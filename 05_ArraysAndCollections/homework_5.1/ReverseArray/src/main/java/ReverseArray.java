
import java.util.Arrays;

public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.

    public static String[] reverse (String[] strings){

        int s = 0;
        String[] newArray = strings.clone();
        for ( int i = strings.length - 1; i >=0; i--) {

            System.out.println(newArray[i]);
            strings[s] = newArray[i];
            s++;
        }

        return strings;


    }
}
