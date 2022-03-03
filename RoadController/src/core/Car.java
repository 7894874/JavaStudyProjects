package core;

public class Car
{
    private String number;
    private int height;
    private double weight;
    private boolean hasVehicle;
    private boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }

    public void toSetCarNumber(String  number) {
       this.number = number;
    }

    public String getCarNumber() { return this.number; }

    public void toSetCarHeight(int height) {
        if (height > 0) {
            this.height = height;
        } else  System.out.println("Wrong height!!!you should use digits > 0");
    }

    public int getCarHeight() { return this.height; }

    public void toSetCarWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else  System.out.println("Wrong weight!!!you should use digits > 0");
    }

    public double getCarWeight() { return this.weight; }

    public void toSetHasVehicle(boolean hasVehicle)
    {
        this.hasVehicle = hasVehicle;
    }

    public boolean getHasVehicle() { return this.hasVehicle; }

    public void toSetIsSpecial(boolean isSpecial)
    {
        this.isSpecial = isSpecial;
    }

    public boolean getIsSpecial() { return this.isSpecial; }

}