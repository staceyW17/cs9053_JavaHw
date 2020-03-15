package edu.nyu.cs9053.homework7;

public class Ethereum implements CryptoCurrency {
    private final double amount;

    public Ethereum(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAmount() {

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ethereum ethereum = (Ethereum) o;

        return Double.compare(ethereum.getAmount(), getAmount()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getAmount());
        return (int) (temp ^ (temp >>> 32));
    }
}
