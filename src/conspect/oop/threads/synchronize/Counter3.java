package conspect.oop.threads.synchronize;

public class Counter3 {
    private int cnt1;
    private int cnt2;
    private Object lock1;
    private Object lock2;

    public Counter3() {
        lock1 = new Object();
        lock2 = new Object();
    }

    public int getCnt1() {
        return cnt1;
    }

    public void setCnt1(int cnt1) {
        synchronized (lock1) {
            this.cnt1 = cnt1;
        }
    }

    public int getCnt2() {
        synchronized (lock2) {
            return cnt2;
        }
    }

    public void setCnt2(int cnt2) {
        this.cnt2 = cnt2;
    }

    // работа паралельно 2-ух счетчиков
    // 1-ая синхронизация для 1-ого счетчика
    public void inc1() {
        synchronized (lock1) {
            cnt1++;
        }
    }

    public void dec1() {
        synchronized (lock1) {
            cnt1--;
        }
    }

    // 2-ая синхронизация для 2-ого счетчика
    public void inc2() {
        synchronized (lock2) {
            cnt2++;
        }
    }

    public void dec2() {
        synchronized (lock2) {
            cnt2--;
        }
    }
}