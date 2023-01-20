package Intentions;

public class Task extends Intention{
    public Task(boolean negative) {
        super(negative);
        content += "получил задание: ";
    }
}
