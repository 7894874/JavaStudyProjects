//import java.util.concurrent.RecursiveTask;
//
//public class CarsNumberGeneratorGbl extends RecursiveTask<Runnable> {
//
//    private int numberOfRegion;
//    private long startTime;
//
//    public CarsNumberGeneratorGbl(int numberOfRegion, long startTime) {
//        this.numberOfRegion = numberOfRegion;
//        this.startTime = startTime;
//    }
//
//
////    @Override
////    public Runnable compute() {
////
////        //// Создадим список эти подзадач, который запустим для текущего узла по всем его детям
////        List<CarsNumberGeneratorGbl> taskList = new ArrayList<>();
////
////        CarsNumberGenerator newCarNumberGenerator = new CarsNumberGenerator();
////
////        for (int regionCode = 1; regionCode < numberOfRegion; regionCode++) {
////
////            try {
////                /// Создаем задачу для каждого ребенка и затем её ответвляем
////           //     CarsNumberGeneratorGbl task = new CarsNumberGeneratorGbl(regionCode, startTime);
////             //   task.fork();
////
////                //// добавляем её в список ArrayList
////              //  taskList.add(task);
////                //   newCarNumberGenerator.process(regionCode, startTime);
////
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////
////        }
////
////        return null;
////
////    }
//
////    @Override
////    public void run() {
////
////
////
////        CarsNumberGenerator newCarNumberGenerator = new CarsNumberGenerator();
////
////        try {
////          //  newCarNumberGenerator.process(numberOfRegion, startTime);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    @Override
//    protected Runnable compute() {
//
//        CarsNumberGenerator newCarNumberGenerator = new CarsNumberGenerator();
//
//        try {
//           // newCarNumberGenerator.process(numberOfRegion, startTime);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//}
