package conspect.oop.threads.concurrent.atomic;

public class AtomicValue {
    //AtomicLong
    private volatile long value;

    public final long get() {
        return value;
    }

    public final long getAndAdd(long delta) {
        while (true) {
            long current = get();
            long next = current + delta;
            if (compareAndSet(current, next))
                return current;
        }
    }

    private boolean compareAndSet(long current, long next) {
        throw new IllegalStateException("Метод compareAndSet " +
                "представляет из себя механизм оптимистичной блокировки " +
                "и позволяет изменить значение value, " +
                "только если оно равно ожидаемому значению (т.е. current). ");
    }
}
