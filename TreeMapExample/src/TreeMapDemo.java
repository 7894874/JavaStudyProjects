

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(2, "Proselyte");
        treeMap.put(1, "AsyaSmile");
        treeMap.put(3, "Peter");
        treeMap.put(5, "Ivan");
        treeMap.put(4, "Konstantin");

        System.out.println("Initial TreeMap content:");

        Set set = treeMap.entrySet();
        for (Object element : set) {
            Map.Entry mapEntry = (Map.Entry) element;
            System.out.println("ID: " + mapEntry.getKey() + ", Name: " + mapEntry.getValue());
        }

        System.out.println("\n========================\n");

        System.out.println("Modifying Proselyte...");
        String name = treeMap.get(2);
        name += " Changed";

        treeMap.put(2, name);

        System.out.println("Final TreeMap content:");

        set = treeMap.entrySet();
        for (Object element : set) {
            Map.Entry mapEntry = (Map.Entry) element;
            System.out.println("ID: " + mapEntry.getKey() + ", Name: " + mapEntry.getValue());
        }

        System.out.println("\n========================\n");

    }
}






