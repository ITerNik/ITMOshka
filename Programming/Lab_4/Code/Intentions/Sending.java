package Intentions;

import People.Leader;
import Places.Base;
import Things.Resources;
import Transport.*;

public class Sending extends Action {
    public Sending(Transport transport, Leader leader) {
        content = String.format("послать за руководителем %s %s", leader, transport);
    }
    public Sending(Transport transport, Base base, Resources res) {
        content = String.format("послать транспорт %s с ресурсом %s на место %s", transport, res, base);
    }
    public Sending(Transport transport) {
        content = String.format("делать вылазки на транспорте %s", transport);
    }
}
