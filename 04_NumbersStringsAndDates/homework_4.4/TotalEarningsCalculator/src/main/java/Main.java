
/**

 Напишите код, который считает сумму заработка всех друзей.
 Используйте методы indexOf(), lastIndexOf(), substring() и trim().
 Использование регулярных выражений в данном задании не допускается.

**/



public class Main {

  private static int totalEarnings = 0;

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    ///// Вася заработал
    int vasyaEarnings = Integer.parseInt(text.substring(text.indexOf("л")+ 2, text.indexOf("рублей") - 1));
    int petyaEarnings = Integer.parseInt(text.substring(text.lastIndexOf("Петя") + 7, text.indexOf("рубля") - 1).trim());
    int mashaEarnings = Integer.parseInt(text.substring(text.lastIndexOf("Маша") + 7, text.lastIndexOf("рублей") - 1).trim());

    totalEarnings = vasyaEarnings + petyaEarnings + mashaEarnings;

    System.out.println(totalEarnings);

  }

}