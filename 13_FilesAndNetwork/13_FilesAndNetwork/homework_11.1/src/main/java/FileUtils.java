/**
 * // Чтобы работать с файлами, есть шикарный утилитный класс — java.nio.file.Files. У него есть методы просто на все случаи жизни. Все методы этого класса статические и работают с объектами типа Path. Методов очень много, поэтому мы рассмотрим только основные:
 * <p>
 * Метод	Описание
 * Path createFile(Path path)        Создает новый файл с путем path
 * Path createDirectory(Path path)         Создает новую директорию
 * Path createDirectories(Path path)        Создает несколько директорий
 * Path createTempFile(prefix, suffix)        Создает временный файл
 * Path createTempDirectory(prefix)        Создает временную директорию
 * void delete(Path path)        Удаляет файл или директорию, если она пуста
 * Path copy(Path src, Path dest)        Копирует файл
 * Path move(Path src, Path dest)        Перемещает файл
 * boolean isDirectory(Path path)        Проверяет, что путь — это директория, а не файл
 * boolean isRegularFile(Path path)        Проверяет, что путь — это файл, а не директория
 * boolean exists(Path path)        Проверяет, что объект по заданному пути существует
 * long size(Path path)        Возвращает размер файла
 * byte[] readAllBytes(Path path)        Возвращает все содержимое файла в виде массива байт
 * String readString(Path path)        Возвращает все содержимое файла в виде строки
 * List<String> readAllLines(Path path)        Возвращает все содержимое файла в виде списка строк
 * Path write(Path path, byte[])        Записывает в файл массив байт
 * Path writeString(Path path, String str)                   Записывает в файл строку
 * DirectoryStream<Path> newDirectoryStream(Path dir)        Возвращает коллекцию файлов (и поддиректорий) из заданной директории
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.LongStream;

/**
 * Напишите программу. Она должна:
 * <p>
 * получать через консоль путь от пользователя до папки;
 * получить размер всех файлов в указанной папке и ее подпапках,
 * реализация этого должна быть написана в методе calculateFolderSize() класса FileUtils;
 * выводить полученную сумму файлов в удобочитаемом виде — в байтах, килобайтах, мегабайтах или гигабайтах;
 * программа должна перехватывать все исключения, возникающие при ошибках чтения файлов и папок,
 * и выводить сообщение об ошибке с трассировкой стека (stack trace).
 **/


public class FileUtils {

    public static long calculateFolderSize(String path) {

        long totalFolderSize = 0;

        Path currentPathToFolder = Path.of( path );
        try {
            DirectoryStream<Path> files = Files.newDirectoryStream( currentPathToFolder );
            {
                long currentFileSize;
                for (Path currentPath : files) {
                    currentFileSize = Files.size( currentPath );
                    if (Files.isDirectory( currentPath )) {
                        currentFileSize = GetDirSize( currentPath.toFile() );
                    }

                    totalFolderSize += currentFileSize;
                    System.out.println( "File " + currentPath + " " + viewOfFile( currentFileSize ) );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( "\n*******************************************\n" +
                "Total folder size is: " + viewOfFile( totalFolderSize ) );

        return totalFolderSize;

    }

    private static long GetDirSize(File directories) {

        long size = 0;

        ///// Обращаемся к списку файлов
        File[] filesList = directories.listFiles();

        if (directories != null && filesList != null) {
            for (File file : filesList) {
                if (file.isFile())
                    size += file.length();
                else
                    size += GetDirSize( file );
            }
        }

        return size;

    }

    static String viewOfFile(long currentFolderSize) {

        String currentResultCountStr = "";
        if (currentFolderSize > 0) {


            if (currentFolderSize > 1024) {
                currentFolderSize = currentFolderSize / 1024;
                currentResultCountStr = currentFolderSize + " Kb";
            }
            if (currentFolderSize > 1024) {
                currentFolderSize = currentFolderSize / 1024;
                currentResultCountStr = currentFolderSize + " Mb";
            }
            if (currentFolderSize > 1024) {
                currentFolderSize = currentFolderSize / 1024;
                currentResultCountStr = currentFolderSize + " Gb";
            }

            return currentResultCountStr;
        } else {

            currentResultCountStr = "0";
            return currentResultCountStr;
        }

    }

    public void Study() {

        LongStream.of( 1, 2, 3, 4 )
                .filter( e -> e > 2 )
                .peek( e -> System.out.println( "Filtered value: " + e ) )
                .map( e -> e * e )
                .peek( e -> System.out.println( "Mapped value: " + e ) )
                .sum();
    }

}

