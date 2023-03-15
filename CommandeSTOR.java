import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class CommandeSTOR extends Commande {
	
	public CommandeSTOR(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	public void execute() {
		final Socket transfertSocket;
		PrintStream out;
		try {
			//Création du socket de transfert entre le serveur et le client
			transfertSocket = new Socket("localhost",4000);
			
			//Création du flux pour envoyer :
			out = new PrintStream(transfertSocket.getOutputStream());
			
			File fichier = new File(repertoireCourant + commandeArgs[0]);
			File fichierServeur = new File("");
			String fichierString = fichierServeur.getAbsolutePath()+"\\";
			
			InputStream is = new FileInputStream(fichierString);
			
		    BufferedInputStream bis = new BufferedInputStream(is);
		    FileOutputStream fos = new FileOutputStream(fichier);
		    
		    //Création du buffer
		    byte[] buffer = new byte[(int)fichier.length()];
            int compteur;
            ps.println("test");
            // Écriture du contenu du fichier dans un fichier local
            while ((compteur = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, compteur);
            }
            ps.println("Transfert réussi");
            
            transfertSocket.close();
            bis.close();
            fos.close();

			} catch (Exception e) {
				ps.println("2 Problème lors de l'éxécution de la commande STOR");
			}
	}

}
