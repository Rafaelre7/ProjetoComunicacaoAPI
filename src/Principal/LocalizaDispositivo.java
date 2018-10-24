/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import com.digi.xbee.api.RemoteXBeeDevice;
import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.XBeeNetwork;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class LocalizaDispositivo {
       XBeeDevice myDevice;

  
    public LocalizaDispositivo(XBeeDevice myDevice) {
        this.myDevice = myDevice;
        
         }
       
        public List<RemoteXBeeDevice> getAllRemoteDev(){
        
         XBeeNetwork network = myDevice.getNetwork();
         
         network.startDiscoveryProcess();
         
         while(network.isDiscoveryRunning()){
           
             try {
                 System.out.println("Buscando dispositivos");
                 
                 Thread.currentThread().sleep(100);
                 
             } catch (InterruptedException ex) {
                 System.out.println("Thread is interrupeted!!");
             }
         }
         return  network.getDevices();
    }
}
