
import com.digi.xbee.api.RemoteXBeeDevice;
import com.digi.xbee.api.WiFiDevice;
import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.XBeeNetwork;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.listeners.IDataReceiveListener;
import com.digi.xbee.api.models.XBeeMessage;
import com.digi.xbee.api.models.XBeeProtocol;
import com.digi.xbee.api.utils.HexUtils;
import java.util.List;

/**
 *
 * @author Windows
 */
public class MainApp {

    /* Constants */
    // TODO Replace with the port where your sender module is connected to.
    private static final String PORT = "COM5";
    // TODO Replace with the baud rate of your sender module.  
    private static final int BAUD_RATE = 9600;
    public static final int NEW_TIMEOUT_FOR_SYNC_OPERATIONS = 5*1000; //5 seconds
    private static final String DATA_TO_SEND = "Hello XBee World!";
    
    public static void main(String[] args) {
        
        XBeeDevice myDevice = new XBeeDevice(PORT, BAUD_RATE);
        myDevice.setReceiveTimeout(NEW_TIMEOUT_FOR_SYNC_OPERATIONS);
        
        byte[] dataToSend = DATA_TO_SEND.getBytes();
        
        try {
            myDevice.open();
                  
            myDevice.addDataListener(new IDataReceiveListener() {
                @Override
                public void dataReceived(XBeeMessage xbeeMessage) {
                    
                    System.out.println("XBee: " + xbeeMessage.getDevice().getNodeID());
                    System.out.println("Buffer: " + new String(xbeeMessage.getData()));
//                   System.out.format("From %s >> %s | %s%n", xbeeMessage.getDevice().get64BitAddress(),
//                            HexUtils.prettyHexString(HexUtils.byteArrayToHexString(xbeeMessage.getData())),
//                            new String(xbeeMessage.getData()));
                }
            });
            System.err.println("Protocolo: "+myDevice.getXBeeProtocol());
            XBeeNetwork network = myDevice.getNetwork();
            
            network.addDiscoveryListener(new AutoDiscovery(myDevice));
            network.startDiscoveryProcess();
       
            //Descovery Remotos XBee
//            DescoveryRemoto descovery = new DescoveryRemoto(myDevice);
//            
//            List<RemoteXBeeDevice> devices = descovery.getAllRemoteDev();
//            
//            System.err.println("All sizes: "+devices.size());
//            for (RemoteXBeeDevice device : devices) {
//                
//                System.out.println("Name: "+device.getNodeID());
//                
//                System.out.println("Device Info: ");
//                
//                System.err.println("Send datas: "+dataToSend);
//                myDevice.sendData(device, dataToSend);
//                                                               
//            }
//
//            System.out.println(" >> Success");
            
        } catch (XBeeException e) {
            System.out.println(" >> Error");
            e.printStackTrace();
            System.exit(1);
        } finally {
            //  myDevice.close();
        }
        
    }
}
