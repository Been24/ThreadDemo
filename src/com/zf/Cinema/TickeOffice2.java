package com.zf.Cinema;

/**
 * Created by Been on 2018/5/29.
 */
public class TickeOffice2 implements Runnable {
    private Cinema cinema;

    public TickeOffice2(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.sellTickets2(22);
        cinema.sellTickets2(4);
        cinema.sellTickets1(2);
        cinema.sellTickets1(1);
        cinema.returnTickets2(2);
        cinema.sellTickets1(3);
        cinema.sellTickets1(2);
        cinema.sellTickets2(2);
    }
}
