/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.digi.xbee.api.RemoteXBeeDevice;
import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.listeners.IDiscoveryListener;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class AutoDiscovery implements IDiscoveryListener{

    private List<RemoteXBeeDevice> listaXBeeDevice;
    private XBeeDevice xBeeDevice;

    public AutoDiscovery(XBeeDevice xBeeDevice) {
   
      this.xBeeDevice = xBeeDevice;
      this.listaXBeeDevice = new ArrayList<>();
    }
       
    /*
    Metedo check se ja existe o remote dispositivo 
    em sua lista
    */
    public boolean isExistXRemoteDev(RemoteXBeeDevice xBee){
        
        boolean status = false;
        
        if(listaXBeeDevice.isEmpty()) return status;
               
        //Loop dentro da lista para cada xBee
        for (RemoteXBeeDevice remoteXBeeDevice : listaXBeeDevice) {
    
            //checa se o xBee possui o mesmo MAC
            if(remoteXBeeDevice.get64BitAddress().equals(xBee.get16BitAddress()))
            {
                status = true;
                break;
            }
                
        }// end loop for
        return  status;
    }
    private void restarte(){
        
        System.err.println("Restarte");
        this.xBeeDevice.getNetwork().stopDiscoveryProcess();
        this.xBeeDevice.getNetwork().startDiscoveryProcess();
    }
    
    @Override
    public void deviceDiscovered(RemoteXBeeDevice rxbd) {
        
                
        System.err.println("Connection: "+rxbd.getNodeID());
        //checa se ja existe esse device, se não axiste add na lista
        if(!isExistXRemoteDev(rxbd)){
            
            //add na lista
            this.listaXBeeDevice.add(rxbd);
            
            System.err.println("Foi adicionado na lista: "+ rxbd);
            
            try {
                //send some data to remote
                this.xBeeDevice.sendDataAsync(rxbd,new String("You was connected!").getBytes());
            } catch (XBeeException ex) {
                System.err.println("Not impossible send any data to XBeeRemote\n"+ex);
            }
        }
    }

    @Override
    public void discoveryError(String string) {
        System.err.println("Error found: "+string);
    }

    @Override
    public void discoveryFinished(String string) {
        System.err.println("Processo finished: "+string);
   
        new Thread(()-> {
            
            while (this.xBeeDevice.getNetwork().isDiscoveryRunning()) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException ex) {

                }
            }
            this.restarte();
            
        }).start();
    }
    
}
