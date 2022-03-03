public class CatCopy {

    private boolean isAlive;
    private String name;
    private double weight;
    private  CatsCollors catClr;

    public CatCopy(String nameCopy, double weightCopy, CatsCollors catClrCopy) {

        this.name = nameCopy;
        this.catClr = catClrCopy;
        this.weight = weightCopy;

        this.isAlive = true;

        infoAbtCatCopy();

    }

    public Double getWeight() {
        return weight;
    }

    public String getName() { return  name; }

    public CatsCollors getCatsCollor() {
        return catClr;
    }

    public boolean getCatCopyAliveStatus() {
        return isAlive;
    }

    public void infoAbtCatCopy() {

        System.out.println("=========================================================================================");
        System.out.println("Full copy of Cat with name " +this.name+ " and collor " +catClr+ " was made successful!");
        System.out.println("=========================================================================================");
    }

    public void meow() {
        if (this.isAlive == true) {
            System.out.println("Meow");
        }
    }



}
