package edu.nyu.cs9053.homework7;

public class Bitcoin implements CryptoCurrency {
    private double amount;

    public Bitcoin(double amount) {

        this.amount = amount;
    }

    @Override
    public double getAmount() {

        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Bitcoin that = (Bitcoin) o;

        return Double.compare(that.getAmount(), getAmount()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getAmount());
        return (int) (temp ^ (temp >>> 32));
    }

}
