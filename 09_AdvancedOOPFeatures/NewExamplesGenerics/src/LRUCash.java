/// LRUCash - Кэш в котором храниться заданное количество элементов
// и при добавлении нового наиболее старый из них стирается
//// при добавлении в который


import java.util.ArrayList;
import java.util.List;

public class LRUCash<T>//// Параметр Т = тип элемента (параметризован)
{
    //// Добавляем переменную с типом ArrayList
    ArrayList<T> elements;
    int size;

    /// Создадим коснтруктор
    //// При создании мы задаем ему размер
    public LRUCash(int size) {
        this.size = size;
        elements = new ArrayList<>();
    }

    public void addElement(T element) {

        int currentSize = elements.size();
        if (currentSize >= size) {
            for (int i = 0; i < currentSize - size + 1; i++) {
                elements.remove( 0 );
            }
        }
        elements.add( element );
    }

    public T getElement(int i) {
        if (i >= elements.size()) {
            return null;
        }
        return elements.get(i);
    }
//
    public List<T> getAllElements()
    {
         return elements;
    }
}
