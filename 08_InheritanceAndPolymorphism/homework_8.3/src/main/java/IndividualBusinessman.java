public class IndividualBusinessman extends Client {

    /**
     * У IndividualBusinessman — все условия PhysicalPerson и дополнительно, пополнение
     * с комиссией 1%, если сумма меньше 1 000 рублей.
     * Пополнение с комиссией 0,5%, если сумма больше либо равна 1 000 рублей.
     */
    /// test
    private double bankAccount;

    private final double COMISSION1 = 0.01;
    private final double COMISSION2 = 0.005;


//    public double getAmount() {
//        return this.bankAccount;
//    }


    public void put(double amountToPut) {

        if (amountToPut > 0) {
            if (amountToPut < 1000) {
                // this.bankAccount += (amountToPut - amountToPut * COMISSION1);
                super.put( amountToPut - amountToPut * COMISSION1 );
            }
            //  } else this.bankAccount += (amountToPut - amountToPut * COMISSION2);
            else if (amountToPut >= 1000) {
                super.put( amountToPut - amountToPut * COMISSION2 );
            }
        }
    }


//    public void take(double amountToTake) {
//
//        //// Если нужно списать больше чем есть на счете, тогда просто не списываем
//        if (amountToTake < this.bankAccount) {
//            this.bankAccount -= (amountToTake + amountToTake * 0.01);
//        } else {
//            System.out.println("Недостаточно средств для снятия!!!");
//        }
//    }
}
