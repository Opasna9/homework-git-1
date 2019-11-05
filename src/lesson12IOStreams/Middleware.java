package lesson12IOStreams;

public abstract class Middleware {
    private Middleware next;

    private Middleware successor;

    /**
     * Помогает строить цепь из объектов-проверок.
     */
    void setSuccessor(Middleware successor) {
        this.successor = successor;
    }

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    /**
     * Подклассы реализуют в этом методе конкретные проверки.
     */
    public abstract boolean check(String s);

    /**
     * Запускает проверку в следующем объекте или завершает проверку, если мы в
     * последнем элементе цепи.
     */
    protected boolean checkNext(String s) {
        if (next == null) {
            return true;
        }
        return next.check(s);
    }

}
