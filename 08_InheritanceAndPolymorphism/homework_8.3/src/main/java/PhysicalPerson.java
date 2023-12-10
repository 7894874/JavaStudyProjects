

/**
 * У PhysicalPerson пополнение и списание происходит без комиссии. Если передать в метод
 * пополнения отрицательное значение, сумма на счёте не должна измениться. При попытке снять
 * сумму больше, чем есть на счете, сумма не списывается со счёта, сумма на счёте не изменяется.
 **/

public class PhysicalPerson extends Client {

    private double bankAccount;
//
// public double getBankAccount() {
//  return bankAccount;
// }
//

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }
//
// public PhysicalPerson(double newBankAccount) {
//   setBankAccount(bankAccount);

    public double getBankAccount() {
        return this.bankAccount;
    }


//    public double getAmount() {
//       return this.bankAccount;
//    }

// @Override
//    public void take(double amountToTake) {
//        if (amountToTake < this.bankAccount) {
//            this.bankAccount -= (amountToTake + amountToTake * 0.01);
//        } else {
//            System.out.println( "Недостаточно средств для снятия!!!" );
//        }
// }

    //}
}



