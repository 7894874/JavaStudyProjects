import java.util.Objects;

public class Account {

    private int qttOfTransfer;
    private long money;
    private String accNumber;

    public void setQttOfTransfer(int qttOfTransfer) {
        this.qttOfTransfer = this.qttOfTransfer + qttOfTransfer;
    }

    public int getQttOfTransfer() {
        return qttOfTransfer;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money =  this.money + money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return qttOfTransfer == account.qttOfTransfer && money == account.money && Objects.equals(accNumber, account.accNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qttOfTransfer, money, accNumber);
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
}
