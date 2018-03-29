
package tour.operator;
import java.io.IOException;
import java.nio.*;
import java.nio.charset.Charset;

public class TOUROPERATOR {

    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Voyagecontroller vc = new Voyagecontroller();
        vc.ajoutVoy();
        
        AeroportControlleur ac1 = new AeroportControlleur();
        ac1.ajoutAerop();
       
    }

}
