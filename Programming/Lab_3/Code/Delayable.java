public interface Delayable {
    default void delay() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
