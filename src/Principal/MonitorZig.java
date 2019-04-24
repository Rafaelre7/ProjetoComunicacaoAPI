/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import com.digi.xbee.api.RemoteXBeeDevice;
import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.listeners.IDataReceiveListener;
import com.digi.xbee.api.models.XBeeMessage;
import static java.lang.Thread.interrupted;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Pimenta
 */
public class MonitorZig extends Thread {

    private String nome;
    private List<ProcessoZig> listaZigs;
    private boolean running;
    public static boolean xbeeSemComunicacao = false;
    private ConexaoFrame conexaoFrame;

    public MonitorZig(String nome, ConexaoFrame conexaoFrame) {

        this.nome = nome;
        this.listaZigs = new ArrayList<>();
        this.running = true;
        this.conexaoFrame = conexaoFrame;
        start();

    }

    public void addZig(XBeeDevice zig, String nome, String porta, int baudrate) {

        ProcessoZig p = new ProcessoZig(zig, nome, porta, baudrate);

        //add na lista
        this.listaZigs.add(p);
    }

    public void removeZig(XBeeDevice zig) {

        for (int i = 0; i < listaZigs.size(); i++) {

            if (zig.get64BitAddress().equals(listaZigs.get(i).getZig().get64BitAddress())) {
                listaZigs.remove(i);
                break;
            }
        }
    }

    @Override
    public void run() {

        while (this.running && !interrupted()) {

            //define status para true
            for (ProcessoZig zig : listaZigs) {
                zig.setStatus(false);
            }

            //envia para zig e espera resposta
            for (ProcessoZig sender : listaZigs) {

                if (!sender.getZig().isOpen()) {
                    continue;
                }

                try {

                    sender.getZig().sendData(sender.getRemoteZig(), new String("Teste conexão xbee").getBytes());

                    //Variaveis na memoria
                    String nomeThread, porta;
                    int vel;

                    vel = MainApp.getBAUD_RATE();
                    nomeThread = MainApp.getNOMETHREAD();
                    porta = MainApp.getPORT();

                    System.out.println("Dados: " + nomeThread + "-" + porta + "-" + vel);

                } catch (XBeeException ex) {
                }

                for (ProcessoZig recepitor : listaZigs) {

                    if (recepitor == sender) {
                        continue;
                    }
                    if (!recepitor.getZig().isOpen()) {
                        continue;
                    }

                    try {

                        sender.getZig().sendData(recepitor.getRemoteZig(), new String("Teste conexão xbee").getBytes());

                    } catch (XBeeException ex) {
                        ex.printStackTrace();
                    }

                }// end for

            }// end for

            try {
                //case 1 minuto processa
                Thread.sleep(5000);// 30 segundos
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            //traz todos o xbees conectados
            for (ProcessoZig p : listaZigs) {
                //pega o status
                if (p.isStatus()) {
                    xbeeSemComunicacao = false;
                    System.out.println("Status de erro sem comunicação: " + xbeeSemComunicacao);
                    continue;
                } else {

                    System.out.println("Zig " + p.getNome() + " não esta respondendo!!!");
                    p.startAlarme();

                    xbeeSemComunicacao = true;
                    System.out.println("Esta com alarme: " + xbeeSemComunicacao);
                    //Tenta fazer a reconexao
                    try {

                        //Variaveis na memoria
//                        String porta;
//                        int vel;
//
//                        vel = MainApp.getBAUD_RATE();
//                        porta = MainApp.getPORT();
//                        
////                        XBeeDevice xBee = conexaoFrame.getMainApp().getxBee();
////                        if(xBee == null){
////                            return;
////                        }else{
////                            System.out.println("Esta com conexao");
////                        }
//                        
//                        
//                        XBeeDevice xBee = new XBeeDevice(porta,vel);
//                        
//                        xBee.open();
//                        conexaoFrame.startListenner();
//                    
//                        conectarXbee();

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("ESTA SEM CONEXÃO COM A PORTA SERIAL");
                    }
                }
            }

        }// end while

    }

//    public void conectarXbee() {
//        String porta;
//        int vel;
//
//        vel = MainApp.getBAUD_RATE();
//        porta = MainApp.getPORT();
//
//        XBeeDevice xBee = this.conexaoFrame.getMainApp().getxBee();
//
//        xBee = new XBeeDevice(porta, vel);
//        this.conexaoFrame.setZigBeeDevice(xBee);
//
//        try {
//
//            xBee.open();
//
////            this.conexaoFrame.getMainApp().setxBee(xBee);
////
////            this.conexaoFrame.getMainApp().setPORT(porta);
////            this.conexaoFrame.getMainApp().setBAUD_RATE(vel);
//            conexaoFrame.startListenner();
//
////            JOptionPane.showMessageDialog(null, "Conectado com sucesso DataCall");
//        } catch (XBeeException ex) {
//
//                ex.printStackTrace();
//
//        }
//    }

    private class ProcessoZig implements IDataReceiveListener {

        private XBeeDevice zig;
        private String nome;
        private boolean status;
        private RemoteXBeeDevice remoteZig;
        private String porta;
        private int baudreta;
        private boolean running;

        public ProcessoZig(XBeeDevice zig, String nome, String porta, int baudrate) {

            this.zig = zig;
            this.nome = nome;
            this.status = true;
            this.porta = porta;
            this.baudreta = baudrate;
            this.running = false;
            this.zig.addDataListener(this);

            this.remoteZig = new RemoteXBeeDevice(zig, zig.get64BitAddress());

        }

        public void startAlarme() {

            if (running) {
                return;
            }

            System.out.println("Não está respondendo");

            this.running = true;
        }

        public void stopAlarme() {

            if (!running) {
                return;
            }

            System.out.println("Xbee respondendo");

            this.running = false;
        }

        public void resetStatus() {

            this.status = false;
        }

        /**
         * @return the zig
         */
        public XBeeDevice getZig() {
            return zig;
        }

        /**
         * @param zig the zig to set
         */
        public void setZig(XBeeDevice zig) {
            this.zig = zig;
        }

        /**
         * @return the nome
         */
        public String getNome() {
            return nome;
        }

        /**
         * @param nome the nome to set
         */
        public void setNome(String nome) {
            this.nome = nome;
        }

        /**
         * @return the status
         */
        public boolean isStatus() {
            return status;
        }

        /**
         * @param status the status to set
         */
        public void setStatus(boolean status) {
            this.status = status;
        }

        @Override
        public void dataReceived(XBeeMessage xbeeMessage) {

            this.status = true;
            this.stopAlarme();
        }

        /**
         * @return the remoteZig
         */
        public RemoteXBeeDevice getRemoteZig() {
            return remoteZig;
        }

        public int getBaudreta() {
            return baudreta;
        }

        public String getPorta() {
            return porta;
        }

    }

}
