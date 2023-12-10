/**
 *
 * Что нужно сделать
 *
 * Выполните задание в проекте
 *
 * 08_InheritanceAndPolymorphism/homework_8.3
 *
 * В проекте найдите абстрактный класс Client и его наследников
 * IndividualBusinessman,
 * LegalPerson
 * PhysicalPerson
 *
 * Реализуйте методы классов, при необходимости переопределите
 * методы в наследниках так, чтобы выполнялись условия пополнения и снятия:
 *
 * У каждого клиента есть сумма денег на счету (число). Деньги можно положить на счёт,
 * снять и вернуть остаток на счёте. Каждый класс должен содержать метод, который выводит
 * информацию в консоль о счёте: условие пополнения, условие снятия и баланс.
 *
 * У PhysicalPerson пополнение и списание происходит без комиссии. Если передать в метод
 * пополнения отрицательное значение, сумма на счёте не должна измениться. При попытке снять
 * сумму больше, чем есть на счете, сумма не списывается со счёта, сумма на счёте не изменяется.
 *
 * У LegalPerson — все условия PhysicalPerson и дополнительно снятие с комиссией 1%.
 *
 * У IndividualBusinessman — все условия PhysicalPerson и дополнительно, пополнение
 * с комиссией 1%, если сумма меньше 1 000 рублей. И пополнение с комиссией 0,5%,
 * если сумма больше либо равна 1 000 рублей.
 *
 * ///// Прочитать все статьи!!!
 *
 * abstract class ClassName {
 *     // class methods and variables
 *     ...
 *     abstract type AbstractMethod1(parameters1);
 *     abstract type AbstractMethod2(parameters2);
 *     ...
 *     abstract type AbstractMethodN(parametersN);
 * }
 * здесь
 *
 * ClassName – имя абстрактного класса, который объявляется;
 * AbstractMethod1, AbstractMethod2, AbstractMethodN – имена абстрактных методов,
 * объявляемых в абстрактном классе * type – некоторый тип;
 * parameters1, parameters2, parametersN – перечень параметров, которые получают соответствующие
 * абстрактные методы с именами AbstractMethod1, AbstractMethod2, AbstractMethodN.

 *
 */


/**
Улучшение и замечания

 Лебедев Павел @lebedev_pavel · 4 days ago
 Maintainer
 абстрактный класс не обязан содержать только абстрактные методы. Более того, лучше выносить всю логику,
 которая дублируется в наследуемых классах сюда, чтобы избегать дублирования кода.

 включая поля класса

 Лебедев Павел @lebedev_pavel · 4 days ago
 Maintainer
 всю основную логику работы со счетом лучше вынести в абстрактный класс и обращаться к этим методам при переопределении
 */

public abstract class Client {

    private double bankAccount;

    public double getAmount() {
        return this.bankAccount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0 ) {
            this.bankAccount = amountToPut;
        } else System.out.println("Сумма долна быть положительной!");
    }

    public void take(double amountToTake) {

        //// Если нужно списать больше чем есть на счете,
        //// тогда просто не списываем
        if (amountToTake < this.bankAccount) {
            this.bankAccount -= amountToTake;
        } else {
            System.out.println("Недостаточно средств для снятия!!!");
        }
    }

//    @Override
//    public void take2(double amountToTake) {
//
//        if (amountToTake < this.bankAccount) {
//            this.bankAccount -= (amountToTake + amountToTake * 0.01);
//        } else {
//            System.out.println( "Недостаточно средств для снятия!!!" );
//        }


   // }

}
