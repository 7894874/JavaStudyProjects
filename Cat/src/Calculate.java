public class Calculate {
/// test
    private static double currentWeightOfPushistic;

    public static void feedOurCat(Cat cat, double Currentfeed, String Name) {

        currentWeightOfPushistic = cat.getWeight();
        String currentStatus = cat.getStatus();

        int currentcount = 0;
        while (currentStatus != "Exploded") {
            currentStatus = cat.getStatus();

            if (currentStatus == "Exploded") { break; }

                currentWeightOfPushistic = cat.getWeight();

                System.out.println("The weight of "+Name+" is "+currentWeightOfPushistic+ "and it's growing up! Be carefull it could be dangerous!!" +currentStatus);

                //// Continue to feed up our Cat
                cat.feed(Currentfeed);

                currentcount++;
                cat.toSetCatStatus(true);

        }
        System.out.println("BOOOM!!! Our "+Name+" is " + cat.getStatus()+" we were feed it for "+currentcount+ " times\n");
        cat.toSetCatStatus(false);
    }

    public static void meowMyPoorCat(Cat cat, String Name) {

        currentWeightOfPushistic = cat.getWeight();
        String currentStatus = cat.getStatus();

        int currentcount = 0;
        while (currentStatus != "Dead") {
            currentStatus = cat.getStatus();

                currentWeightOfPushistic = cat.getWeight();

                if (currentStatus == "Dead") { break; }
                System.out.println("The weight of "+Name+" is "+currentWeightOfPushistic+ "and it losts some weight! Be carefull it could be dangerous!!" +currentStatus);

                //// Continue to meow up our Cat
                cat.meow();

                currentcount++;
                cat.toSetCatStatus(true);

        }
        System.out.println("OOhh my gosh..!!! Ohh shit..."+Name+" is " + cat.getStatus()+" it has a weight deficit!!! Horror!!! Our CAT IS ANOREXIC after "+currentcount+ " meows!!!\n");
        cat.toSetCatStatus(false);/// И ошибку у себя нашел еще ;-)
    }


}
