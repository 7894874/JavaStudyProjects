import java.util.ArrayList;
import java.util.List;

public class SortByMyMethod {

    private List<String[]> arrays = new ArrayList<>();

    public void SortByMyMethod() {

        String[] array1 = {"мама", "мыла", "раму"};
        String[] array2 = {"я", "очень", "люблю", "java"};
        String[] array3 = {"мир", "труд", "май"};


        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);

//        arrays.sort(new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return o2.length - o1.length;
//            }
//        });

        ///// Перепишем методы сортировки вот так
        arrays.sort( ((o1, o2) -> o2.length - o1.length));

//        Comparator<String[]> sortByWordsLength = new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return 0;
//            }
            //       @Override
//            public int compare(String[] o1, String[] o2) {
//                int length1 = 0;
//                int length2 = 0;
//                for (String s : o1) {
//                    length1 += s.length();
//                }
//                for (String s : o2) {
//                    length2 += s.length();
//                }
//                return length2 + length1;
//            }
        };




  //  }

    public void getArrayAfterSorting() {

        for (String[] curretStr : arrays) {

            StringBuffer result = new StringBuffer();
            for (int i = 0; i < curretStr.length; i++) {
                result.append( " " + curretStr[i] );
            }
            String mynewstring = result.toString();

            System.out.println( mynewstring );

        }
    }
}



