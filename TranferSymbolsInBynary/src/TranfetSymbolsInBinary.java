import java.util.Scanner;

public class TranfetSymbolsInBinary {

        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            String MESSAGE = in.nextLine();

            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < MESSAGE.length(); i++) {
                char c = MESSAGE.charAt(i);

                answer.append(Integer.toBinaryString(c)).append(' ');
            }

//        Example
//        Let’s take a simple example with a message which consists of only one character:
//        Capital C. C in binary is represented as 1000011, so with Chuck Norris’ technique this gives:
//
//        0 0 (the first series consists of only a single 1)
//        00 0000 (the second series consists of four 0)
//        0 00 (the third consists of two 1)
//        So C is coded as: 0 0 00 0000 0 00

            System.out.println(answer.toString());
            String s1 = answer.toString().replaceFirst("1", "0 0 " );
            //  System.out.println(s1);
            String s2 = s1.replace("0000", "00 0000 " );
            //  System.out.println(s2);
            String s3 = s2.replace("11", "0 00" ).trim();
            String s4 = s3.replace(" 1", "0 ");
            System.out.println(s4);

            //   System.out.println(Integer.parseInt(MESSAGE)));

        }
    }




