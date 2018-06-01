/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import com.digi.xbee.api.RemoteXBeeDevice;
import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.XBeeNetwork;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.models.DiscoveryOptions;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 *
 * @author Windows
 */
public class DescoveryRemoto{

    private final XBeeDevice xDev;
    private final long timeoutDescovery = 1000;
    
    public DescoveryRemoto(XBeeDevice dev) {
        
        this.xDev = dev;
    }
    
    public List<RemoteXBeeDevice> getAllRemoteDev(){
        
         XBeeNetwork network = xDev.getNetwork();
         
         network.startDiscoveryProcess();
         
         while(network.isDiscoveryRunning()){
           
             try {
                 System.err.println("Wainting for any device");
                 Thread.currentThread().sleep(5000);
             } catch (InterruptedException ex) {
                 System.out.println("Thread is interrupeted!!");
             }
         }
         return  network.getDevices();
    }
    
}
