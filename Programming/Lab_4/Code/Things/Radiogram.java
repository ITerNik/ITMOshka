package Things;

import People.*;

public class Radiogram extends Communication {
    private String text;
    public Radiogram(String text) {
        this.text = String.format("\"%s\"", text);
    }
    public String call(Leader lead) {
        String real = deshifrate(text);
        return String.format("послал радиорамму руководителю %s с текстом:\n%s", lead, real);
    }
    public String call(Group adressed) {
        String real = deshifrate(text);
        return String.format("послал радиорамму руководителям %s с текстом:\n%s", adressed, real);
    }
    public String deshifrate(String code) {
        class Deshifrator{
             private String code;
            public Deshifrator(String code) {
                this.code = code;
            }
            static final char[] alphabet = {'а','б','в','г','д','е','ж','з','и',
                    'й','к','л','м','н','о','п','р','с','т','у','ф',
                    'х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
            static final public String[] morze = {"._","_...",".__","__.","_..",".","..._","__..","..",
                    ".___","_._","._..","__","-.","___",".__.","._.","...","_",".._",".._.",
                    "....","_._.","___.","____","__._","__.__","_.__","_.._",".._..","..__","._._"};
            public String getText() {
                String[] letters = code.split(" ");
                String str = "";
                for (int i = 0; i < letters.length; i++){
                    for (int j = 0; j < morze.length; j++){
                        if (morze[j].equals(letters[i])){
                            str = str + alphabet[j];
                            break;
                        }
                    }
                }
                return str;
            }
        }
        Deshifrator device = new Deshifrator(code);
        return device.getText();
        }
    }
