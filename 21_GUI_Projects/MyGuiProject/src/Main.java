import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {


/**     Цель задания

 Научиться писать приложение с графическим интерфейсом Swing.

 Что нужно сделать

 Создайте приложение с формой, содержащей три поля — «Фамилия», «Имя», «Отчество», — и кнопку Collapse.

 Требования

 Кнопка должна запускать проверку полей «Фамилия» и «Имя» на заполнение.

 1) Если поля «Фамилия» и «Имя» не заполнены — появляется сообщение об ошибке и предложение ввести данные.
 Пользователь остаётся в этой же форме.
 2) Если поля заполнены, при нажатии на кнопку Collapse отображается текстовое поле «Ф.И.О.», в котором данные
 «Фамилия», «Имя», «Отчество» располагаются друг за другом через пробелы, и текст на кнопке заменяется на Expand.
 3) Кнопка Expand работает аналогично: проверяются введённые значения.
 Если в строке есть два слова, подходящие под «Фамилия», «Имя», —
 то показываются три отдельных поля с ФИО и текст кнопки Expand меняется на Collapse.
 **/

        JFrame frame = new JFrame();
        frame.setSize(600, 400);

        frame.add(new MainFormInput().getMainPanel());

        //  frame.getContentPane();
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);


        //   JButton button1 = new JButton("Top");
        //   frame.getContentPane().getLayout();

//        JButton button2 = new JButton("Center");
//        topPanel.add(button2);
//
//        JButton button3 = new JButton("Bottom");
//        topPanel.add(button3);

//        JFrame.setDefaultLookAndFeelDecorated(true);
//        //TestFrame frame = new TestFrame();
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);

    }
}
