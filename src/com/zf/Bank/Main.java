package com.zf.Bank;

/**
 * Created by Been on 2018/5/29.
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        Company company = new Company(account);
        Thread companyThread = new Thread(company);
        Bank bank = new Bank(account);
        Thread banlThread = new Thread(bank);
        System.out.printf("Account:Initial Balance:%f\n", account.getBalance());
        companyThread.start();
        banlThread.start();
        try {
            companyThread.join();
            banlThread.join();
            System.out.printf("Account:Final Balance:%f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.printf("%f\n", account.getBalance());
    }
}
