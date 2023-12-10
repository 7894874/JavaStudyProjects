import java.util.List;

public class Calculator {

    public static Double sum(List<? extends Number> numbers)
    {

       /** reduce(T identity, BinaryOperator accumulator) — преобразовывает все элементы стрима
        в один объект(посчитать сумму всех элементов, либо найти минимальный элемент),
            cперва берётся объект identity и первый элемент стрима, применяется функция
        accumulator и identity становится её результатом. Затем всё продолжается для остальных элементов.
        **/
        return numbers.stream().map( n -> ((Number) n )
                .doubleValue()).reduce( (n1, n2)->n1 + n2 ).get();
    }

}
