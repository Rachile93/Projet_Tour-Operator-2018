
package tour.operator;

public class PortControlleur {

    private PortModele ptm1 = null;
    private PortVue pv1 = null;

    public PortControlleur() {

    }

    public PortControlleur(PortModele ptm1, PortVue pv1) {
        this.ptm1 = ptm1;
        this.pv1 = pv1;
    }

    public void ajoutAerop() {
        ptm1 = new PortModele();
        pv1 = new PortVue();
        pv1.affMsg(ptm1.ajoutPort(pv1.initPort()));
    }

}
