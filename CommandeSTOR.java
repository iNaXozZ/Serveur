import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.file.FileAlreadyExistsException;

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
			
			//Récupération du chemin absolu du répertoire où l'on veut créer le fichier
			File fichierClient = new File(repertoireCourant + commandeArgs[0]);
			File fichierServeur = new File("");
			String fichierString = fichierServeur.getAbsolutePath()+"\\";
			//Récupération du chemin absolu du fichier recherché dans le serveur 
			File fichierDuServeur = new File(fichierString+ commandeArgs[0]);
			
			// Lecture des flux d'écriture et de lecture
			InputStream is = new FileInputStream(fichierClient);
		    BufferedInputStream bis = new BufferedInputStream(is);
		    FileOutputStream fos = new FileOutputStream(fichierDuServeur);
		    
		    //Vérification que l'argument passé en paramètre dans la commande est bien un nom de fichier qui existe dans le répertoire du serveur 
		    if(fichierClient.isFile())
			{
		    	//Création du buffer
			    byte[] buffer = new byte[(int)fichierClient.length()];
	            int compteur;
	            // Écriture du contenu du fichier dans le fichier local du client
	            while ((compteur = bis.read(buffer)) != -1) {
	                fos.write(buffer, 0, compteur);
	                out.println(buffer);
	            }
				
			}
		    ps.println("0 Commande STOR OK");
            transfertSocket.close();
            out.close();
            bis.close();
            fos.close();

			} 
			  catch (FileNotFoundException te) {
				ps.println("2 impossible de trouver le fichier "+te);
			} catch (Exception e) {
				ps.println("2 Problème lors de l'éxécution de la commande GET "+e);
			}
	}

}
