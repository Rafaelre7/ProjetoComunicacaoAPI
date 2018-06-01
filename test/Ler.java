
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class Ler {
    public static  void main(String[] args){
       
     Path caminho = Paths.get("C:/Users/rafae/Desktop/Solinftec/SGIB (Balança)/Kijos.txt");
    
        try {
           byte[] texto = Files.readAllBytes(caminho);
           String leitura = new String(texto);
           
            System.out.println("Texto lido: " + leitura);
        } catch (IOException ex) {
            Logger.getLogger(Ler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
