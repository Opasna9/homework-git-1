package conspect.oop.threads.synchronize;

public class Counter1 {
    private int cnt;

    public int getCnt() {
        return cnt;
    }

    public synchronized void setCnt(int cnt) {
            this.cnt = cnt;
    }

    public synchronized void inc(){
            cnt++;
    }

    public synchronized void dec(){
            cnt--;
    }
}
