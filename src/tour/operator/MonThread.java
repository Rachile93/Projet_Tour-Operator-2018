/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour.operator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilisateur
 */
public class MonThread extends Thread{
    
    @Override
    public void run(){
        super.run();
        for(;;){
            System.out.println("bonjour");
           // LoadDataBaseLieuModele ldb = new LoadDataBaseLieuModele();
           // LoadDataBaseTransportModele ldbt = new LoadDataBaseTransportModele();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MonThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
