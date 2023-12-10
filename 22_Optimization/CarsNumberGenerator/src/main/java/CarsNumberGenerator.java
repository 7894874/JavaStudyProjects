//
//
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//
//// import jdk.internal.org.jline.utils.Log;
//
//
//public class  CarsNumberGenerator {
//
//    public CarsNumberGenerator process(int numberOfRegion, long startTime) throws Exception {
//
//        /** numberOfRegion - номер региона                    **/
//        /** qttOfNumbers - количество номеров для машин всего **/
//
//        try {
//
//            //  wait();
//
//            int qttOfNumbers = 1000;
//
//            char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
//
//            String regionCodeStr = Integer.toString(numberOfRegion);
//            String currentPathNumber = "src/result/numbers" + regionCodeStr + ".txt";
//
//            PrintWriter writer = null;
//            try {
//                writer = new PrintWriter(currentPathNumber);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            StringBuilder builder = new StringBuilder();
//
//            for (int number = 1; number < qttOfNumbers; number++) {
//                for (char firstLetter : letters) {
//                    for (char secondLetter : letters) {
//                        for (char thirdLetter : letters) {
//
//                            builder.append(firstLetter);
//                            builder.append(padNumber(number, 3));
//                            builder.append(secondLetter);
//                            builder.append(thirdLetter);
//                            builder.append(padNumber(numberOfRegion, 2));
//                            builder.append("\n");
//
//                            //  String carNumber = firstLetter + padNumber(number, 3) +
//                            //  secondLetter + thirdLetter + padNumber(regionCode, 2);
//                            //  writer.write(carNumber.getBytes());
//                            //  writer.write('\n');
//                        }
//                    }
//                }
//            }
//
//
//            writer.write(builder.toString());
//
//            writer.flush();
//            writer.close();
//
//            System.out.println("Finished after start:" + (System.currentTimeMillis() - startTime) + " ms");
//
//        } catch (Exception e) {
//
//            // String emrsg = "Fai
//            // led to generate car number";
//            e.printStackTrace();
//
//
//            Log.warn(
//                    "Failed to generate car number for "
//                            + numberOfRegion + ", skipping! Sorry! ("
//                            + "reason is:" + e.getMessage()
//                            + ")");
//
//
//        }
//
//        return null;
//
//
//    }
//
//    private static  String padNumber(int number, int numberLength) {
//
//        // StringBuilder builder2 = new StringBuilder();
//        String numberStr = Integer.toString(number);
//        int padSize = numberLength - numberStr.length();
//
//        for (int i = 0; i < padSize; i++) {
//            //// builder2.append(0);
//            //// builder2.append(numberStr);
//            numberStr = '0' + numberStr;
//            ////   numberStr = builder2.toString();
//        }
//        return numberStr;
//    }
//}
//