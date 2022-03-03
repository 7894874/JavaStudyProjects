import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {


    public static void main(String[] args) {


        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
            }
        };


        Runnable runnable = () -> System.out.println("hello");
        String s = "hello";
        ActionListener actionListener1 = (event) -> {
            System.out.println( s );
        };



    }


}
