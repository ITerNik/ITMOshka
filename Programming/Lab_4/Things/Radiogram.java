package Things;

import People.*;

public class Radiogram extends Communication {
    private String text;
    private Leader adressed;
    Radiogram(String text, Leader adressed) {
        this.text = String.format("\"%s\"", text);
        this.adressed = adressed;
    }
    public String call() {
        return String.format("послал радиорамму руководителю %s с текстом:\n%s", adressed, text);
    }
}
