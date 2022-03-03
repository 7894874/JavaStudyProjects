public class LimitsOfSize {


    /**
     * Цель задания:
     * Научиться получать граничные значения числовых переменных.
     * <p>
     * Что нужно сделать:
     * Создайте новый проект и в методе main() напишите код, который распечатает в консоль минимальные отрицательные
     * и максимальные положительные значения всех типов чисел.
     * Отправьте в репозиторий Git коммит с выполненным заданием.
     **/
    public static void main(String[] args) {


        ////// Содержат целые числа
        System.out.println("******* byte *******");
        System.out.println("BYTES:" + Byte.BYTES);
        System.out.println("SIZE:" + Byte.SIZE);
        System.out.println("MIN_VALUE:" + Byte.MIN_VALUE);
        System.out.println("MAX_VALUE:" + Byte.MAX_VALUE);

        System.out.println("******* short *******");
        System.out.println("BYTES:" + Short.BYTES);
        System.out.println("SIZE:" + Short.SIZE);
        System.out.println("MIN_VALUE:" + Short.MIN_VALUE);
        System.out.println("MAX_VALUE:" + Short.MAX_VALUE);

        System.out.println("******* int *********");
        System.out.println("SIZE:" + Integer.SIZE);
        System.out.println("BYTES:" + Integer.BYTES);
        System.out.println("MIN_VALUE:" + Integer.MIN_VALUE);
        System.out.println("MAX_VALUE:" + Integer.MAX_VALUE);

        System.out.println("******* long *********");
        System.out.println("SIZE:" + Long.SIZE);
        System.out.println("BYTES:" + Long.BYTES);
        System.out.println("MIN_VALUE:" + Long.MIN_VALUE);
        System.out.println("MAX_VALUE:" + Long.MAX_VALUE);

        ////// Содержат дробные числа
        System.out.println("******* float *********");
        System.out.println("SIZE:" + Float.SIZE);
        System.out.println("BYTES:" + Float.BYTES);
        System.out.println("MIN_VALUE:" + Float.MIN_VALUE);
        System.out.println("MAX_VALUE:" + Float.MAX_VALUE);

        System.out.println("******* double *********");
        System.out.println("SIZE:" + Double.SIZE);
        System.out.println("MIN_VALUE:" + Double.MIN_VALUE);
        System.out.println("MAX_VALUE:" + Double.MAX_VALUE);
        System.out.println("MIN_EXPONENT:" + Double.MIN_EXPONENT);
        System.out.println("MAX_EXPONENT:" + Double.MAX_EXPONENT);

        System.out.println("******* char *********");
        System.out.println("SIZE:" + Character.SIZE);
        System.out.println("BYTES:" + Character.BYTES);
        System.out.println("MIN_VALUE:" + Character.MIN_VALUE);
        System.out.println("MAX_VALUE:" + Character.MAX_VALUE);

        double a = 2.0 - 1.1;
        System.out.println(a);
        System.out.println(Float.valueOf((float) a));

        double f = 0.0;
        for (int i = 1; i <= 10; i++) {
            f += 0.1;
        }
        System.out.println(f);
        System.out.println(Float.valueOf((float) f));

    }
}

