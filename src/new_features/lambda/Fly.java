package new_features.lambda;

@FunctionalInterface
public interface Fly {
    void fly();

    default void run() {
        System.out.println("running...");
    }
}
