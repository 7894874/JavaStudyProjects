import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;


//// Калькулятор сумм узлов

public class NodeValueSumCalculator extends RecursiveTask<Long>
{

    //// Необходимо реализовать метот compute которое высчитывает значение Long
    //// для все подзадач

    private Node node;

    public NodeValueSumCalculator(Node node) {
        this.node = node;
    }

    @Override
    protected Long compute() {

        long sum = node.getValue();

        /// Нужно просуммировать все значения с текущим значением
        /// как это сделать?

        //// Создадим список эти подзадач, который запустим для текущего узла по всем его детям
        List<NodeValueSumCalculator> taskList = new ArrayList<>();
        //// Далее берем всех его детей и создаем очередную задачу для каждого child и эту задачу ответвляем
        //// запускаем её асинхронно относительно текущего потока,
        for (Node child : node.getChildren())
        {
            /// Создаем задачу для каждого ребенка и затем её ответвляем
            NodeValueSumCalculator task = new NodeValueSumCalculator(child);
            //// и эту задачу ответвляем, запускаем асинхронно относительно текущего потока и
            task.fork();
            //// добавляем её в список ArrayList
            taskList.add(task);
        }

        //// после того, как она выполнилась,
        //// нужно результат выполнения записать в sum
        //// Поскольку все подзадачи мы сохранили, мы просто перебираем все эти задачи
        for (NodeValueSumCalculator task : taskList) {
            /// сюда добавляем с помощью метода join
            /// этот метод по сути дожидается выполнения каждой задачи и возвращает её обработно в этот поток
            /// пока все подзадачи не выполнились, этот метод будет ожидать выполнения
            sum += task.join();
        }

        return sum;
    }

}
