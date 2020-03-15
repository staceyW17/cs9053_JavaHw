package edu.nyu.cs9053.homework7;

public class CryptoWalletTransfer<T extends CryptoCurrency > {

    public <T> void transfer(Wallet<? extends T > from, Wallet<? super T> to){
        for(int i = 0; i<from.size();i++){
            to.add(from.get(i));
        }
    }
}
