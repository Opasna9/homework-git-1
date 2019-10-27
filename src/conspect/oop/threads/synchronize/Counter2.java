package conspect.oop.threads.synchronize;

public class Counter2 {
    private int cnt;

    public int getCnt() {
        return cnt;
    }

    public synchronized void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void inc() {
        System.out.println("код без синхронизации inc begin");
        synchronized (this) {
            cnt++;
        }
        System.out.println("код без синхронизации dec end");
    }

    public void dec() {
        System.out.println("код без синхронизации dec begin");
        synchronized (this) {
            cnt--;
        }
        System.out.println("код без синхронизации dec end");
    }
}
