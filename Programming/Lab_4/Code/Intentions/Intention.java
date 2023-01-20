package Intentions;

public abstract class Intention {
    protected String content;
    Intention(boolean negative) {
        content = (negative == true? "не " : "");
    }
    public String getContent() {
        return content;
    }
}
