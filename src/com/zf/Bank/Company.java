package com.zf.Bank;

/**
 * Created by Been on 2018/5/29.
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            account.addAmount(1000);
        }
    }
}
