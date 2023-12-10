//
//import java.util.Properties;
//
//public class SendEmail {
//
//
//
//        public static void main(String [] args) {
//            String to = "recipient@gmail.com";
//            String from = "sender@gmail.com";
//            String host = "localhost";
//
//            Properties properties = System.getProperties();
//            properties.setProperty("mail.smtp.host", host);
//            Session session = Session.getDefaultInstance(properties);
//
//            try{
//                MimeMessage message = new MimeMessage(session);
//                message.setFrom(new InternetAddress(from));
//
//                message.addRecipient( Message.RecipientType.TO,new InternetAddress(to));
//
//                message.setSubject("My Email Subject");
//                message.setText("My Message Body");
//                Transport.send(message);
//                System.out.println("Sent successfully!");
//            } catch (MessagingException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//    private static class Session {
//    }
//}
//
//
//
//
//
//
//
//*
//*
