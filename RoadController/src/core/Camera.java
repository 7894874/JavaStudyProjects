package core;

public class Camera
{
    public static Car getNextCar()
    {
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        int randomHeight = (int) (1000 + 3500. * Math.random());
        double randomWeight = 600 + 10000 * Math.random();

        Car car = new Car();
        car.toSetCarNumber(randomNumber);
        car.toSetCarHeight(randomHeight);
        car.toSetCarWeight(randomWeight);
        car.toSetHasVehicle(Math.random() > 0.5);
        car.toSetIsSpecial(Math.random() < 0.15);

        return car;
    }
}