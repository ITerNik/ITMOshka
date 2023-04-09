package logic;

import annotations.Builder;

import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.*;

public abstract class IODevice implements Closeable {

    protected Scanner input;

    public IODevice(Scanner input) {
        this.input = input;
    }

    public String readLine() {
        return input.nextLine();
    }

    public abstract  <T> T readElement(T base);

    protected TreeSet<Method> selectMethods(Method[] methods) {
        TreeSet<Method> ordered = new TreeSet<>(Comparator.comparingInt(m -> m.getAnnotation(Builder.class).order()));
        for (Method method: methods) {
            if (method.isAnnotationPresent(Builder.class)) ordered.add(method);
        }
        return ordered;
    }



    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public void close() {
        input.close();
    }
}
