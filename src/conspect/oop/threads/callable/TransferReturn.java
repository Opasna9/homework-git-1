package conspect.oop.threads.callable;

public class TransferReturn {
    private Boolean isSuccessful;
    private String message;

    public TransferReturn(Boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    @Override
    public String toString() {
        return "TransferReturn{" +
                "isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                '}';
    }
}
