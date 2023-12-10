public class CardAccount extends BankAccount {


//    Лебедев Павел @lebedev_pavel · 21 hours ago
//    лучше всего при переопределении стараться делать свою доп логику и вызывать родительскую через
//    super. Т.к. в родительском классе может быть важная бизнес-логика, которую мы сносим.
//    Это не очень хорошо. В вашем случае нужно посчитать сумму + процент и передать её в super.take(сумма)

    //// Полностью согласен! Спасибо.

    //// Переопределяем метод для расширения класса BankAccount (CardAccount)
    @Override
    public void take(double amountToTake) {
//        if (super.bankAccount > amountToTake) {
//            super.bankAccount = super.bankAccount - amountToTake - amountToTake * 0.01;
//        }

        amountToTake = amountToTake + amountToTake * 0.01;
        super.take(amountToTake);

    }
}
//    Лебедев Павел @lebedev_pavel · 21 hours ago
//    Maintainer
//    в таком методе смысла нет - если его удалите, то все будет верно все равно. Джава сама поймет, что нужно вызвать родительский

//    @Override
//    public double getAmount() {
//
//        return super.getAmount();
//
//    }

    //// Полностью согласен! Спасибо.

//}
