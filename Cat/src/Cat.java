///// test
public class Cat {
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double feedAmount;

    private static int count;
    private static int totalcount;
    private static int dedCatsCount;

    private boolean isAlive;  //// (true) - the cat is alive, (false) - the cat is dead

    public static final int EYES_AMOUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    private String name;

    private  CatsCollors catClr;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = MIN_WEIGHT;
        maxWeight = MAX_WEIGHT;
        this.isAlive = true;
        this.count++;
        this.totalcount++;
    }

    public Cat(String name, CatsCollors catsCollors, double weight) {
            this();
            this.weight = weight;
            this.name = name;
            this.catClr = catsCollors;
    }

    public String getName() {
        return name;
    }

    public void checkCatisAliveOrNot() {
        if (weight < minWeight || weight > maxWeight) {
            this.isAlive = false;
        } else {
            this.isAlive = true;
        }
    }

    public void toSetCatStatus(boolean catsStatus) {
        this.isAlive = catsStatus;

        if (this.isAlive == false) {
            this.count = this.count - 1;
            this.dedCatsCount = dedCatsCount + 1;
        }
    }

    public boolean getCatStatus() {
        return this.isAlive;
    }

    public void meow() {
        checkCatisAliveOrNot();
        if (this.isAlive == true) {
            weight = weight - 1000;
            System.out.println("Meow");
        }
    }

    /**
     * "Очень замороченно выглядит этот метод. Мы же можем просто делать count++ в конструкторе (конструктор - место,
     * которое вызывается при создании любого объекта).
     * А для убавления мы можем найти место, когда при изменении веса вес кошки выходит за рамки интервала МИН/МАКС.
     * <p>
     * + в текущем метода ошибка - если счетчик кошек равен 1, то мы прибавляем счетчик.
     * Если он равен 2+ , то мы каждый раз будем убавлять кошек? wtf?)"
     * <p>
     * Павел, да все правильно, но это не ошибка, а задумка, согласен немного странная реализация счетчика кошек, задумка такая
     * собственно она работает. Если передаем в параметре (1), тогда прибавляем кошку, если передаем любое
     * число отличное от 1 (независимо от числа, хоть 100000000) = тогда убавляем, попутно считаем мертвых кошек.
     * Согласен, это немного не верно, но отрабатывает как надо. Можно было бы сделать немного подругому, более понятно
     * для вас, согласен). Но это так сказать моё художество...). Не стисняйтесь, говорите как правильно такие вещи
     * надо писать, приводите код, очень хочется писать, так сказать по регламенту и со всеми признаками хоро-
     * шего тона)))
     * <p>
     * Все - переделаю... :-)
     * <p>
     */


    public int getCount() {
        return this.count;
    }

    public int showCatsWeLost() {
        return this.dedCatsCount;
    }

    public void feed(Double amount) {
        checkCatisAliveOrNot();
        if (this.isAlive == true) {
            weight = weight + amount;
            feedAmount = feedAmount + amount;
        }
    }

    public void drink(Double amount) {
        weight = weight + amount;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public double getTotalWeightOfFeed() {
        return feedAmount;
    }

    public void pee(String catName) {
        checkCatisAliveOrNot();
        if (this.isAlive == true) {
            weight = weight - 500;
            System.out.println(catName + " writes like a horse!!!");
        }
    }

    public static String info() {

        return "\n************* Reporting: ************ Master! We have total "+totalcount+" Cats!!!!!!!"+
                "\n************* Alive Cats: "+count+" meow ohh...sorry Now. (MB bugs or something:-)))********" +
                "\n************* Cats we lost: "+dedCatsCount+" i'm sorry meow bee beep...beep."+
                "\n============================================================================================================";

    }

    public CatsCollors getCatsCollors() {
        return catClr;
    }

    public void setCatsCollors(CatsCollors catsCollors) {
        this.catClr = catsCollors;
    }


    public Cat(String nameCopy, double weightCopy, CatsCollors catClrCopy, boolean isAlive, double originWeight) {

        this();
        this.isAlive = isAlive;
        this.name = nameCopy;
        this.weight = weightCopy;
        this.catClr = catClrCopy;
        this.originWeight = originWeight;

    }

    public Cat getCopyOfCat(Cat cp) {

        Cat cat = new Cat(cp.name, cp.weight, cp.catClr, cp.isAlive, cp.originWeight);

        return cat;

    }

}