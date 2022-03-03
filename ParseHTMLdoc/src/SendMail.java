

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {



    public static void  SendMail(String currentText) {


        String to = "supervisor2004@gmail.com";

        // Необходимо указать адрес электронной почты отправителя
        String from = "supervisor2004@gmail.com";

        // Предполагая, что вы отправляете электронное письмо с localhost
        String host = "localhost";

        // Получить свойства системы
        Properties properties = System.getProperties();

        // Настроить почтовый сервер
        properties.setProperty( "smtp.gmail.com", host );

        // Получение объекта Session по умолчанию
        Session session = Session.getDefaultInstance( properties );

        try {
            // Создание объекта MimeMessage по умолчанию
            MimeMessage message = new MimeMessage( session );

            // Установить От: поле заголовка
            message.setFrom( new InternetAddress( from ) );

            // Установить Кому: поле заголовка
            message.addRecipient( Message.RecipientType.TO, new InternetAddress( to ) );

            // Установить тему: поле заголовка
            message.setSubject( "Это тема письма!" );

            // Теперь установите фактическое сообщение
            message.setText( currentText );

            // Отправить сообщение
            Transport.send( message );
            System.out.println( "Сообщение успешно отправлено...." );
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
