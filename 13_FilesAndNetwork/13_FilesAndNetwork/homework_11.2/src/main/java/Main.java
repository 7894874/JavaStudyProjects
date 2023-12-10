/**
 * Напишите код, который копирует одну указанную папку в другую.
 * При копировании должны сохраниться файлы и структура папки.
 * Папки запрашивайте у пользователя в консоли.
 * Копирование реализуйте в методе copyFolder() класса FileUtils и проверьте работу метода с помощью тестов.
 * Программа должна перехватывать все исключения, возникающие при ошибках чтения файлов и папок,
 * и выводить сообщение об ошибке с трассировкой стека (stack trace).
 * Критерии оценки
 **/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );

        while (true) {

            //// Создаем ввод с консоли где указываем исходящую для копирования, папку в значение сканера Line
            System.out.println( "Введите директорий который хотите скопировать:" );
            String souceInput = scanner.nextLine();
            if (souceInput.equals( "" )) {
                break;
            }

            //// Cоздаем ввод с консоли где указываем папку, куда будем копировать все файлы Line со сканера
            System.out.println( "Введите путь куда хотите скопировать директорий с файлами:" );
            String destinationInput = scanner.nextLine();
            if (destinationInput.equals( "" )) {
                break;
            }

            ////################################## Метод 1 обход старым методом и копирования файлов и каталогов через метод Files
            //// Собственно задействуем сам статический метод в классе FileUtils
            boolean result = FileUtils.copyFolder( souceInput, destinationInput );

            if (result) {
                System.out.println( "Копирование документа выполнено успешно!" );
            } else {
                System.out.println( "При копировании директории файла возникли ошибки!" );
            }

            //// ################################################## Метод 2 с помощью walkFileTree обхода дерева
            ///// Конвертируем String в тип Path для корректной подстановки в параметры
            Path pathSource = Paths.get( (souceInput) );
            Path pathDestination = Paths.get( destinationInput );
            try {
                Files.walkFileTree( pathSource, new MyFileCopyVisitor( pathSource, pathDestination ) );
                System.out.println( "Files copied successfully!" );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
