public class LegalPerson extends PhysicalPerson {

    private double bankAccount;
////
   // @Override
   // public double getAmount() {
   //     return bankAccount;

   // }


    public void take(double amountToTake)
    {
      // this.setBankAccount(super.getAmount()  - amountToTake - amountToTake * 0.01);
        super.take(amountToTake + amountToTake * 0.01  );
    }

}
