import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       //// Создаем экземпляр класса FileUtils
       FileUtils fileUtils = new FileUtils();

        while (true) {

            System.out.println("Введите директорий размер которого хотите определить:");
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            FileUtils.calculateFolderSize( input );

            fileUtils.Study();

        }
    }
}
