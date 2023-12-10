public class CustomerException extends Exception{

        public CustomerException(String message, String testParametr){
            super(message);
            System.out.println(testParametr);
        }
    }




