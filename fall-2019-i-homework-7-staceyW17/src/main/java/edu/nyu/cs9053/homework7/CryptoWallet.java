package edu.nyu.cs9053.homework7;

public class CryptoWallet<T extends CryptoCurrency> extends Wallet<T>{

    public CryptoWallet(ArrayCreator arrayCreator) {
        super(arrayCreator);
    }
}
