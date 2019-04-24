package Principal;

import com.digi.xbee.api.XBeeDevice;

public class MainApp {


    /**
     * @return the nome
     */
    private static String PORT = "COM8";
    // TODO Replace with the baud rate of your sender module.  
    private static int BAUD_RATE = 115200;
    private static String nome = "Verifica Xbee"; 
    private static XBeeDevice xBee;
    private static String DATA_TO_SEND = "KIJO50,20,01,2345,01,16014,190810,181153,01,3,4,4,4,N,01,5,01,4,01,7,01,5,01,5,01,7,01,08,01,01,1,4B";
    private static String NOMETHREAD = "Verifica Xbee";
    

    public static String getNOMETHREAD() {
        return NOMETHREAD;
    }

    public static void setNOMETHREAD(String NOMETHREAD) {
        MainApp.NOMETHREAD = NOMETHREAD;
    }

         XBeeDevice myDevice = new XBeeDevice(PORT, BAUD_RATE);
       public void enviar(String DATA_TO_SEND){
           
       }
    public MainApp(XBeeDevice xBee) {
        this.xBee = xBee;
    }
   
    
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        nome = nome;
    }
  
    /**
     * @return the PORT
     */
    public static String getPORT() {
        return PORT;
    }

    /**
     * @param aPORT the PORT to set
     */
    public static void setPORT(String aPORT) {
        PORT = aPORT;
    }

    /**
     * @return the BAUD_RATE
     */
    public static int getBAUD_RATE() {
        return BAUD_RATE;
    }

    /**
     * @param aBAUD_RATE the BAUD_RATE to set
     */
    public static void setBAUD_RATE(int aBAUD_RATE) {
        BAUD_RATE = aBAUD_RATE;
    }

    /**
     * @return the DATA_TO_SEND
     */
    public static String getDATA_TO_SEND() {
        return DATA_TO_SEND;
    }

    /**
     * @param aDATA_TO_SEND the DATA_TO_SEND to set
     */
    public static void setDATA_TO_SEND(String aDATA_TO_SEND) {
        DATA_TO_SEND = aDATA_TO_SEND;
    }

    public static XBeeDevice getxBee() {
        return xBee;
    }

    public static void setxBee(XBeeDevice xBee) {
        MainApp.xBee = xBee;
    }

    
 
}
