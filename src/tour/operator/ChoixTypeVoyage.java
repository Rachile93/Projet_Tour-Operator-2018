package tour.operator;

public class ChoixTypeVoyage {

    public TypeVoyage getChoix(String s) {
        
        TypeVoyage tp = null;
        if (s.equals("loisir")) {
            tp = TypeVoyage.loisir;
        }
        if(s.equals("aventure"))
        {
            tp = TypeVoyage.avanture;
        }
        if(s.equals("sport")){
                tp = TypeVoyage.sport;
        }
    return tp ;
    }
}
