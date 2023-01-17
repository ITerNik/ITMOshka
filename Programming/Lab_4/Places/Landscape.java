package Places;

import People.Leader;

public class Landscape extends Place {
    private Nature type;
    public Landscape(String name, Nature type) {
        this.name = name;
        this.type = type;
    }
    public Landscape(Nature type, Leader opener) {
        this(null, type);
        this.type.setOpener(opener);
    }
    public Landscape(Nature type) {
        this(null, type);
    }
    @Override
    public String toString() {
        return type.toString() + (name == null? "": " " + name);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Landscape l = (Landscape) o;
        return (name.equals(l.name)) && (type.equals(l.type));
    }
    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 29 * result + type.hashCode();
        return result;
    }
}
