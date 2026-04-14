package generic.use;

public class Demo<T> {
    T t;

    int i;

    public Demo() {
    }

    public Demo(T t, int i) {
        this.t = t;
        this.i = i;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "t=" + t +
                ", i=" + i +
                '}';
    }
}
