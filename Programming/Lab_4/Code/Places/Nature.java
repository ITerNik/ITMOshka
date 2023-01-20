package Places;

import People.Leader;

public enum Nature {
    MOUNTAIN,
    CREEK,
    ISLAND;
    private Leader opener;
    public void setOpener(Leader person) {
        this.opener = person;
    }
    @Override
    public String toString() {
        String res = switch (this) {
            case CREEK:
                yield "залив";
            case MOUNTAIN:
                yield "горы";
            case ISLAND:
                yield "остров";
        };
        return (opener == null? "": "открытые " + opener.toString() + "ом ") + res;
    }
}
