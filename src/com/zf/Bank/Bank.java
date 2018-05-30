package com.zf.Bank;

/**
 * Created by Been on 2018/5/29.
 */
public class Bank implements Runnable {
    private com.zf.Bank.Account account;

    public Bank(com.zf.Bank.Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            account.subtractAmount(1000);
        }
    }
}
