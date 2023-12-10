import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)  {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;


        String[] components = data.split( "\\s+" );
        // Выбрасываем исключение с описанием ошибки при попытке добавление некорректных данных в HashMap
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put( name, new Customer( name, components[INDEX_PHONE], components[INDEX_EMAIL] ) );
        if (components.length != 4) {
            throw new ArrayIndexOutOfBoundsException( "Передано более или менее 4 слов (параметров) в строке!" );
        }
        if (!components[INDEX_EMAIL].matches( "@" )) {

            try {
                throw new CustomerException( "This is not Email!!!",  "Not contains @ symbol");
            } catch (CustomerException e) {
                e.printStackTrace();
            }

        }
        if (!components[INDEX_PHONE].matches("[0-9]")) {
            try {
                throw new CustomerException( "This is not an Number!!!", "[0-9]" );
            } catch (CustomerException e) {
                e.printStackTrace();
            }
        }
    }

    public void listCustomers() {
        storage.values().forEach( System.out::println );
    }

    public void removeCustomer(String name) {
        storage.remove( name );
    }

    public Customer getCustomer(String name) {
        return storage.get( name );
    }

    public int getCount() {
        return storage.size();
    }
}