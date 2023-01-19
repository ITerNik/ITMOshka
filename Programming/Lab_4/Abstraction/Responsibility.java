package Abstraction;
import People.Gender;

abstract public class Responsibility {
    static public String must(Gender gender) {
        String res = switch (gender) {
            case MALE: yield "должен";
            case FEMALE: yield "должна";
            case NEUTER: yield "должно";
            case PLURAL: yield "должны";
        };
        return res;
    }
    static public String plan(Gender gender) {
        String res = switch (gender) {
            case MALE, FEMALE, NEUTER: yield "планирует";
            case PLURAL: yield "планируют";
        };
        return res;
    }
    static public String setTask(Gender gender) {
        String res = "";
        switch (gender) {
            case MALE: res = "получил";
                break;
            case FEMALE: res = "получила";
                break;
            case PLURAL: res =  "получили";
                break;
            case NEUTER: res = "получило";
        };
        return res += " задание";
    }
    public static String makeDecision(Gender gender) {
        String res = switch (gender) {
            case MALE: yield  "решил";
            case FEMALE: yield  "решила";
            case PLURAL: yield "решили";
            case NEUTER: yield "решило";
        };
        return res;
    }
    static public String possibility(Gender gender) {
        String res = switch (gender) {
            case MALE, FEMALE, NEUTER: yield "может";
            case PLURAL: yield "могут";
        };
        return res;
    }
    static public String noNeed(Gender gender) {
        return "не " + must(gender);
    }
}
