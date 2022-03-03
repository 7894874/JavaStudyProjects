public class Tasl1Lambda {

    public static void main(String[] args) {

        BooleanInterface currentNumber = number -> number % 13 ==0;
        boolean itHasRemains = currentNumber.calculate( 39 );
        System.out.println(itHasRemains);


    }
}
