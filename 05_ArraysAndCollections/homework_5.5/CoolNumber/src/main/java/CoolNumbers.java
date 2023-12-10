import java.util.*;
import java.util.stream.Stream;

public class CoolNumbers {

    public static final String LETTERS = "АВЕКМНОРСТУХ";
    //// Понравилось, добавил себе, не использую)
    public static final String CAR_NUMBER_REGEX = String.format("^[%s]\\d{3}[%s]{2}\\d{2,3}$", LETTERS, LETTERS);

    private final static TreeMap<Long, String> searchingSystemList = new TreeMap<>();

    private final static   List<Integer> timesArrayOfFunctions = new ArrayList<>();

    public static List<String> generateCoolNumbers() {

        ///У777HC64
        List<String> list = new ArrayList<>();

        for (int j = 1; j <= 9000000; j++) {
            Random r = new Random();
            StringBuilder currentXYZ = new StringBuilder();
            String code = "";
            code = code + LETTERS.charAt(r.nextInt(LETTERS.length()));

            int randomNBR = (int) (100 + 900. * Math.random());
            StringBuilder code3 = new StringBuilder();
            for (int i = 1; i <= 2; i++) {
                code3.append(LETTERS.charAt(r.nextInt(LETTERS.length())));
            }

            int region = (int) (100 + 100. * Math.random());
            currentXYZ.append(code + randomNBR + code3 + region);

            list.add(currentXYZ.toString());

        }

        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        Collections.sort(list);

        boolean foundMean = false;

        long startcurrentTime = System.nanoTime();

        for (String currentNumber : list) {
            if (currentNumber.equals(number)) {
                foundMean = true;
            }
        }

        long finishTime = System.nanoTime();
        long totalTime = finishTime - startcurrentTime;

        System.out.println(returnResultString(foundMean, number, totalTime, "binarySearchInList"));

        searchingSystemList.put(totalTime, "bruteForceSearchInList");

        return foundMean;

    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        boolean foundMean = false;

        long startcurrentTime = System.nanoTime();

        int foundedNumber = Collections.binarySearch(sortedList, number);

        if (foundedNumber >= 0) {
            foundMean = true;
        }

        long finishTime = System.nanoTime();
        long totalTime = finishTime - startcurrentTime;

        System.out.println(returnResultString(foundMean, number, totalTime, "binarySearchInList"));

        searchingSystemList.put(totalTime, "bruteForceSearchInList");

        return foundMean;

    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        boolean foundMean;

        long startcurrentTime = System.nanoTime();
        foundMean = hashSet.contains(number);

        long finishTime = System.nanoTime();
        long totalTime = finishTime - startcurrentTime;

        System.out.println(returnResultString(foundMean, number, totalTime, "searchInHashSet"));

        searchingSystemList.put(totalTime, "searchInHashSet");

        return foundMean;

    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        boolean foundMean;

        long startcurrentTime = System.nanoTime();
        foundMean = treeSet.contains(number);

        long finishTime = System.nanoTime();
        long totalTime = finishTime - startcurrentTime;

        System.out.println(returnResultString(foundMean, number, totalTime, "searchInTreeSet"));
        searchingSystemList.put(totalTime, "searchInTreeSet");

        typeAllMethodsWhithKeys();

        System.out.println(typeFastestSearchMethod());

        return foundMean;

    }

    public static String returnResultString(boolean isFound, String number, long totalTime, String mth) {

        return (isFound) ? ("Found number " + mth + " " + number + ", total time passed: " + totalTime + " нс") :
                ("Number " + number + " was not found. Total time passed: " + totalTime + "  нс");


    }

    public static void typeAllMethodsWhithKeys() {

        int currentKeyCount = 0;
        System.out.println("\nCurrent tests on performance SUMMARY:\n");
        for (Long key : searchingSystemList.keySet()) {
            currentKeyCount++;
            System.out.println(currentKeyCount + " " + key + " " + searchingSystemList.get(key));
        }
    }

    public static String typeFastestSearchMethod() {

        Object key = searchingSystemList.keySet().toArray()[0];
        String value = searchingSystemList.get(key);

        return "\nProcedure winner is " + value + " It has time " + key + " нс\n";

    }


}
