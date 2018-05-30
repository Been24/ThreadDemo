package com.zf.Cinema;

/**
 * Created by Been on 2018/5/29.
 */
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;
    private final Object controlCinema1,controlCinema2;

    public Cinema() {
        controlCinema1=new Object();
        controlCinema2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    /**
     * 实现sellTickets1()方法,它使用controlCinema1对象控制
     */
    public boolean sellTickets1(int number) {
        synchronized (controlCinema1) {
            if (number < vacanciesCinema1) {
                vacanciesCinema1-=number;
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean sellTickets2(int number) {
        synchronized (controlCinema2) {
            if (number < vacanciesCinema2) {
                vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 实现returnTickets()方法，当有票退回时调用
     */
    public boolean returnTickets1(int number) {
        synchronized (controlCinema1) {
            vacanciesCinema1 += number;
            return true;
        }
    }

    public boolean returnTickets2(int number) {
        synchronized (controlCinema2) {
            vacanciesCinema2 += number;
            return true;
        }
    }

    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }
}
