import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*************************************************************
 ****** Копирование всех файлов из одного директория в другой
 **/

//// Наследуем (расширяем )MyFileCopyVisitor класс от класса SipleFileVisitor
class MyFileCopyVisitor extends SimpleFileVisitor<Path>  {

    private final Path source;
    private final Path destination;

    //// Через конструктор передаем параметры
    public MyFileCopyVisitor(Path sourcePath, Path destinationPath) {
        source = sourcePath;
        destination = destinationPath;
    }

    //// Отрабатываем каждый раз результат визита директория его содержимого
    public FileVisitResult visitFile(Path path,
                                     BasicFileAttributes fileAttributes) {
        Path newDirectory = destination.resolve(source.relativize(path));
        try {
            Files.copy(path, newDirectory, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    ///// Обходим с визитом все файлы и каталоги директория
    public FileVisitResult preVisitDirectory(Path path,
                                             BasicFileAttributes fileAttributes) {
        Path newDirectory = destination.resolve(source.relativize(path));
        try {
            Files.copy(path, newDirectory, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
         //   e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }
}
/**
  * Объявляется класс MyFileVisitor, унаследованный от SimpleFileVisitor, в котором переопределены
 * два метода: visitFile() (для вывода имени файла) и preVisitDirectory() (для вывода имени директории).
 * Вызывается walkFileTree() в который передаётся объект MyFileVisitor.
 * Метод walkFileTree() начинает выполнение с переданного в него каталога. При этом вызывается
 * метод visitFile() при каждом проходе файла, preVisitDirectory() — перед просмотром элементов директории,
 * postVisitDirectory() — после просмотра элементов директории,
 * visitFileFailed() — в случае отсутствия доступа к файлу/директории.
 * Из этих четырёх методов были переопределены только два для вывода имён каталогов и файлов.
 * Можно контролировать поток обхода с помощью возвращаемых этими методами значений (enum FileVisitResult). Их четыре:
 * CONTINUE: указывает на то, что обход дерева следует продолжить.
 * TERMINATE: указывает, что обход нужно немедленно прекратить.
 * SKIP_SUBTREE: указывает, что подкаталоги должны быть пропущены для обхода.
 * SKIP_SIBLINGS: указывает на то, что обход должен быть остановлен в текущем каталоге и каталогах одного уровня с ним.
 * Если это значение возвращается из preVisitDirectory(), то вложенные файлы/каталоги не обходятся
 * и postVisitDirectory() не срабатывает. Если это значение возвращается из visitFile (),
 * то остальные файлы каталога не обходятся. Если он возвращается из postVisitDirectory (), то остальные
 * каталоги того же уровня не будут обходиться.
  */


