import java.util.*;

public class EmailList {

    //private ArrayList<String> arrayList = new ArrayList<>();
    /// public Set<String> treeSet = new TreeSet<>();

    // а зачем вам здесь 2 коллекции? Мы можем здесь оставить одну. В методах add/getSortedEmails работать с
    // её значениями. Если надо вернуть List то мы можем преобразовать
    // Set в List https://www.baeldung.com/convert-list-to-set-and-set-to-list

    ///////////////////////////
    // мы создали emailList, у него есть специальный метод add,где есть валидация ввода.
    // Давайте использовать его? Иначе зачем тогда нам класс EmailList,
    //  если мы напрямую в коллекцию добавляем. Вообще коллекцию лучше сделать прайват, и оставить
    // 2 метода класса - это должны быть единственные способы редактирования коллекции
    /////////////////////

    ///// Павел, спасибо, кажется все понял! Отличные замечания!)
    //// Исправляю и Инкапсулирую трисет
    private Set<String> treeSet = new TreeSet<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется

        //// По поводу регулярок, в принципе то, что написал, считаю корректным,
        ///// самому хочется уметь профессионально писать регулярные выражения)
        if (email.split("[A-Z]").length > 0) {
            email = email.toLowerCase(Locale.ROOT);
        }
        if ((email.contains("@")) && (email.contains("."))) {
            treeSet.add(email);
        } else
            System.out.println(Main.WRONG_EMAIL_ANSWER);
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        ///// TreeSet по умолчанию сортирует в алфавитном порядке данные

        ///// Заменяем это на код ниже
        //          for (String stringWithE : treeSet) {
        //              System.out.println(stringWithE);
        //             //  arrayList.add(stringWithE);
        //          }
        ///// Павел, Конвертация, работает! Спасибо!
        //// Конвертируем трисет в ArrayList
        List<String> targetList = new ArrayList<>(treeSet);

        return targetList;
    }

    /// Устанавливаем данные трисет, возвращаем их для вызова из созданного объекта
    public Set<String> getTreeSet() {

        return treeSet;

    }
}