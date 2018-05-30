package com.zf.Cinema;

/**
 * Created by Been on 2018/5/29.
 */
public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        TickeOffice1 office1 = new TickeOffice1(cinema);
        Thread thread1 = new Thread(office1, "office1");
        TickeOffice2 office2 = new TickeOffice2(cinema);
        Thread thread2 = new Thread(office2, "office2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Room 1 Vacancies:%d\n", cinema.getVacanciesCinema1());
        System.out.printf("Room 2 Vacancise:%d\n", cinema.getVacanciesCinema2());
    }
}
