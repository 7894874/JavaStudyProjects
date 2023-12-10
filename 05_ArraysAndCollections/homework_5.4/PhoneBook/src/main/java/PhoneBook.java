import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    private final TreeMap<String, String> contactsList = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (findSymbolsFromPatternRx(name, "[0-1]") && findSymbolsFromPatternRx(phone, "[0-1]")) {
            return;
        }
        if (findSymbolsFromPatternRx(name, "[аА-яЯ]") && findSymbolsFromPatternRx(phone, "[аА-яЯ]")) {
            return;
        }
        if (findSymbolsFromPatternRx(name, "[aA-zZ]") && findSymbolsFromPatternRx(phone, "[aA-zZ]")) {
            return;
        }

        if (phone.isEmpty() || name.isEmpty()) {
            System.out.println("Передана пустая строка в поисковом запросе!");
        } else {

            String currentStrKeyToReplace = getNameKeyByPhone(phone);
            if (!currentStrKeyToReplace.isEmpty()) {
                replaceOwner(currentStrKeyToReplace, name, phone);
            } else {
                contactsList.put(name, phone);
            }

            if (contactsList.containsKey(name)) {

                printFoundedValue(name, contactsList.get(name));
            }
            // }
        }
    }

    public String getNameByPhone(String phone) {

        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

        /// Получаем Ключ по значению...
        for (Object entryObj : contactsList.entrySet()) {
            Map.Entry entry = (Entry) entryObj;

            Object valueFromTreSet = entry.getValue();

            if (valueFromTreSet.equals(phone)) {
                Object key = entry.getKey();
                return printFoundedValue(key.toString(), phone);

            }
        }
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

        if (contactsList.get(name) != null) {

            Set<String> currentTreeSet = new TreeSet<>();
            currentTreeSet.add(printFoundedValue(name, contactsList.get(name)));

            return currentTreeSet;

        } else return new TreeSet<>();
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        if (!contactsList.isEmpty()) {
            return returnContacts(contactsList);
        } else return new TreeSet<>();
    }

    public String printFoundedValue(String name, String phoneNbr) {
        return name + " - " + phoneNbr;
    }

    public Set<String> returnContacts(Map<String, String> map) {

        Set<String> currentTreeSet = new TreeSet<>();
        for (String key : map.keySet()) {
            
          //  System.out.println(printFoundedValue(key, map.get(key)));
            currentTreeSet.add(printFoundedValue(key, map.get(key)));

        }
        return currentTreeSet;
    }

    public void replaceOwner(String kerForRemove, String newKey, String newValue) {

        contactsList.remove(kerForRemove);
        contactsList.put(newKey, newValue);

    }

    public boolean findSymbolsFromPatternRx(String currentTextInput, String currentMask) {

        boolean symbolesExists = false;

        Pattern pattern = Pattern.compile(currentMask);
        Matcher matcher = pattern.matcher(currentTextInput);

        if (matcher.find()) {
            symbolesExists = true;
        }

        return symbolesExists;

    }


    /**
     * Интерфейс Map.Entry обозначает как раз пару “ключ-значение” внутри словаря.
     * Метод entrySet() возвращает список всех пар в нашей HashMap (поскольку наша мапа состоит как раз
     * из таких пар-Entry, то мы перебираем именно пары, а не отдельно ключи или значения).
     **/
    public String getNameKeyByPhone(String phone) {

        for (Map.Entry entry : contactsList.entrySet()) {

            Object currentValueFromEntryTreeSet = entry.getValue();
            if (currentValueFromEntryTreeSet.equals(phone)) {
                Object key = entry.getKey();

                return key.toString();

            }
        }
        return "";
    }


}


