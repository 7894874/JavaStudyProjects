import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeMap<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        map.put(new Person("John", "Smith", 17), 0);
        map.put(new Person("Ivan", "Petrenko", 65), 0);
        map.put(new Person("Pedro", "Escobar", 32), 0);
        map.put(new Person("Radion", "Pyatkin", 14), 0);
        map.put(new Person("Sergey", "Vashkevich", 19), 0);

        Person firstAdultPerson = map.navigableKeySet().stream().filter(person -> person.age > 18).findFirst().get();

        Map<Person, Integer> youngPeopleMap = map.headMap(firstAdultPerson, false);
        Map<Person, Integer> adultPeopleMap = map.tailMap(firstAdultPerson, true);

        showAdvertisementToYoung(youngPeopleMap);
        showAdvertisementToAdult(adultPeopleMap);

    }

    public static void showAdvertisementToYoung(Map map) {

        System.out.println("\nShow Advertisement To Young");
        Set set = map.entrySet();
        for (Object element : set) {
            Map.Entry mapEntry = (Map.Entry) element;
            System.out.println(((Person) mapEntry.getKey()).firstName + " " + ((Person) mapEntry.getKey()).lastName + " " + ((Person) mapEntry.getKey()).age);
        }
    }

    public static void showAdvertisementToAdult(Map map) {

        System.out.println("\nShow Advertisement To Adult");

        Set set = map.entrySet();
        for (Object element : set) {
            Map.Entry mapEntry = (Map.Entry) element;
            System.out.println(((Person) mapEntry.getKey()).firstName + " " + ((Person) mapEntry.getKey()).lastName + " " + ((Person) mapEntry.getKey()).age);
        }
    }
}

