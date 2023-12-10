public class Main {

    public static void main(String[] args) {


        String alphabetRus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String alphabetEng = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < alphabetEng.length(); i++) {

            char someletter = alphabetEng.charAt(i);
            int somecode = (int) someletter;
            System.out.println("Letter "+someletter+" code: "+somecode);

        }

        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

        for (int i = 0; i < alphabetRus.length(); i++) {

            char someletter = alphabetRus.charAt(i);
            int somecode = (int) someletter;
            System.out.println("Letter "+someletter+" code: "+somecode);

        }




    }
}
