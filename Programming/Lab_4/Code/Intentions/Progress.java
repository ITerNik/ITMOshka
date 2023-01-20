package Intentions;

public enum Progress {
    ACCEPTED("принято:"),
    CONDITION("Даже если решение будет принято"),
    WAITING("");
    private String content;
    Progress(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return content;
    }
}
