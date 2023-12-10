public class BubblrSortCurrent {

    public BubblrSortCurrent(int[] currentArrayList) {

            int nArrayLenth = currentArrayList.length;
            int temp;

            for (int i = 0; i < nArrayLenth; i++) {
                for (int j = 1; j < nArrayLenth - i; j++) {

                    if (currentArrayList[j - 1] > currentArrayList[j]) {

                        temp = currentArrayList[j - 1];
                        currentArrayList[j - 1] = currentArrayList[j];
                        currentArrayList[j] = temp;

                    }
                }
            }
        }
    }

