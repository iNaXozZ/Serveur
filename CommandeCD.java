import java.io.File;
import java.io.PrintStream;

public class CommandeCD extends Commande {
	
	public CommandeCD(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	//test push 
	public void execute() {
		File fichier = new File(repertoireCourant +"\\"+commandeArgs[0]);
		//File fichier1 = new File(repertoireCourant);
		
		try {
			if(commandeArgs[0].toLowerCase().equals("..")) {
				String cheminAbsolu = repertoireCourant;
				String mot = "";
				String cheminBase = cheminAbsolu.substring(0,cheminAbsolu.lastIndexOf(File.separator));
				repertoireCourant = cheminBase;
				ps.println("chemin absolu : " + cheminAbsolu);
				ps.println("Chemin initial : " + cheminBase );	
			}
			else if(fichier.isDirectory() == true) {
				String chemin = repertoireCourant + commandeArgs[0] +"\\";
				repertoireCourant = chemin;
				ps.println("0 commande cd OK");
				ps.println("0 chemin : " + chemin);
			}
			else {
				ps.println("2 Le répertoire que vous voulez accèder n'est pas présent. Merci d'utiliser un fichier valide.");
			}
		} catch (Exception e) {
			ps.println("Problème lors de l'éxécution de la commande CD");
		}
		
	}

}
