public class Logicalfunctions {

    public static void makeSecondTaskAndThird() {

        boolean currenCatStatus;

        Cat pushistik = new Cat();
        System.out.println("Pushistic's was born and it weight is " + pushistik.getWeight());
        pushistik.checkCatisAliveOrNot();

        currenCatStatus = pushistik.getCatStatus();

        if (currenCatStatus == true) {
            System.out.println("Pushistik is alive and Now you can meow Pushistik!! " + pushistik.getWeight());
            Calculate.meowMyPoorCat(pushistik, "Pushistik");
        } else {
            System.out.println("Current status of cat is " + currenCatStatus + " You can't meow Pushistik!! It's dead!!!\n");
        }

        Cat milashka = new Cat();
        currenCatStatus = milashka.getCatStatus();
        System.out.println("Milashka's was born and it weight is " + milashka.getWeight());

        if (currenCatStatus == true) {
            System.out.println("Milashka is alive and Now you can feed Milashka!! " + milashka.getWeight());
            Calculate.feedOurCat(milashka, 1003.7, "Milashka");
        }

        currenCatStatus = milashka.getCatStatus();

        if (currenCatStatus == true) {
            System.out.println("Milashka is alive and Now you can meow Milashka!! " + milashka.getWeight());
            Calculate.meowMyPoorCat(milashka, "Milashka");
        } else {
            System.out.println("Current status of cat is " + currenCatStatus + " You can't meow Milashka!! It's dead!!!\n");
        }

        Cat murzik = new Cat();
        System.out.println("Murzik was born and it's weight is " + murzik.getWeight());

        currenCatStatus = murzik.getCatStatus();
        if (currenCatStatus == true) {
            murzik.feed(100.0);
            murzik.feed(150.00);
            double currentfeedsWeight = murzik.getTotalWeightOfFeed();

            System.out.println("Total Murzik's food Weight is: " + currentfeedsWeight + " grams\n");
        }
        currenCatStatus = murzik.getCatStatus();
        if (currenCatStatus == true) {
            System.out.println("Oh YES! Murzik is still alive after feeding!!! It wants to piss now!!!");
            murzik.pee("Murzik");
            murzik.pee("Murzik");
            murzik.pee("Murzik");
            System.out.println("After piss, Murzik's weight has become " + murzik.getWeight() + "\n");
        } else {
            System.out.println("Current status of cat is " + currenCatStatus + " You can't pee Murzik because It's dead!!!");
        }


        Cat roboCatInformer = new Cat();
        roboCatInformer.setCatsCollors(CatsCollors.WHITE);

        System.out.println("RoboCatInformer (RobyC) was made and it's weight is " + roboCatInformer.getWeight() + " " +
                "(without battarys) I have a " + roboCatInformer.getCatsCollors() + " collor! Joy me!))) " +
                "\n*************************************************************************************" +
                "\nROBYC: Hello, Master! I'm RoboCat(ROBYC) and i'll be your counter! :)" +
                "\nDo not forget! I'm the Cat too too!! :)" +
                "\nI do not need food! And i'm immortal!!!:) UUUha hah aha haa ha ha ha ha ha...beep" +
                "\n*************************************************************************************\n");
    }
}
