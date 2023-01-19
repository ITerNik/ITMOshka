package Abstraction.Time;

public abstract class Uncountable extends Time {

    public static class Before extends Uncountable{
        @Override
        public String getTime() {
            return "Прежде";
        }
    }
    public static class ForNow extends Uncountable{
        @Override
        public String getTime() {
            return "Теперь";
        }
    }
    public static class A extends Uncountable{
        @Override
        public String getTime() {
            return "Прежде";
        }
    }
    public static class B extends Uncountable{
        @Override
        public String getTime() {
            return "Прежде";
        }
    }
}
