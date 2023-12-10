public class Main {

    public static void main(String[] args) {

        /**
         *
         * здесь давайте сделаем демонстрацию создания объектов класса и выполнения методов с
         * выводом результата в консоль. Здесь не нужно описывать взаимодействие с пользователем
         * через консоль. Просто создаете объекты, передаете значения в методы и
         * выводите информацию о состоянии счета
         *
         */

        /// PhysicalPerson
        PhysicalPerson phP = new PhysicalPerson();
        phP.put( 9046723.45 );
        phP.take( 199777 );
        String currentphPAccountonditions = ("The Amount of Physical person account is "+phP.getAmount()+"$");

        System.out.println(currentphPAccountonditions);

        /// Legal Person
        PhysicalPerson lgP = new LegalPerson();
        lgP.put( 9046723.45 );
        lgP.take( 199777 );
        String currentLegalPersonAccountConditions = ("The Amount of Legal person account is "+lgP.getAmount()+"$");

        System.out.println(currentLegalPersonAccountConditions);

        /// Individual Businessman
        IndividualBusinessman individualBusinessman = new IndividualBusinessman();
        individualBusinessman.put( 9046723.45 );
        individualBusinessman.take( 199777 );
        String currentindividualBusinessmanAccountConditions = ("The Amount of individual businessman account is "+individualBusinessman.getAmount()+"$");

        System.out.println(currentindividualBusinessmanAccountConditions);



    }
}
