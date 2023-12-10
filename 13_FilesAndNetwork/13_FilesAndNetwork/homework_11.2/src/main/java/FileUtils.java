

import java.io.*;

public class FileUtils {

    public static boolean copyFolder(String sourceDirectory, String destinationDirectory) {

        boolean isSuccsess = false;

        try {
            FileUtils.copyDirectory( sourceDirectory, destinationDirectory );
            isSuccsess = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccsess;
    }

    public static void copyDirectoryCompatibityMode(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            copyDirectory( source, destination );
        } else {
            copyFile( source, destination );
        }
    }

    private static void copyDirectory(File sourceDirectory, File destinationDirectory) throws IOException {
        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdir();
        }

        for (String f : sourceDirectory.list()) {
            copyDirectoryCompatibityMode( new File( sourceDirectory, f ), new File( destinationDirectory, f ) );
        }

        //// Пытался задействовать лямбды не получилось )
        // sourceDirectory.list().forEach( f->  copyDirectoryCompatibityMode( new File( sourceDirectory, f ), new File( destinationDirectory, f ) );

    }

    //// Отправляем исходные файлы в буфер обмена через потоки...
    private static void copyFile(File sourceFile, File destinationFile)
            throws IOException {
        try (InputStream in = new FileInputStream( sourceFile );
             OutputStream out = new FileOutputStream( destinationFile )) {

            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read( buf )) > 0) {
                out.write( buf, 0, length );
            }
        }
    }

    public static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation) throws IOException {
        File sourceDirectory = new File( sourceDirectoryLocation );
        File destinationDirectory = new File( destinationDirectoryLocation );
        FileUtils.copyDirectory( sourceDirectory, destinationDirectory );
    }
}



