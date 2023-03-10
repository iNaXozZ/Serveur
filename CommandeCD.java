import java.io.File;
import java.io.PrintStream;

public class CommandeCD extends Commande {
	
	public CommandeCD(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	//test push 
	public void execute() {
		File fichier = new File(repertoireCourant);
		System.out.println(commandeArgs[0]);
		
		if(commandeArgs[0].toLowerCase().equals("..")) {
			String cheminAbsolu = fichier.getAbsolutePath();
			String cheminBase = cheminAbsolu.substring(0,cheminAbsolu.lastIndexOf(File.separator));
			ps.println("chemin absolu : " + cheminAbsolu);
			ps.println("Chemin initial : " + cheminBase );	
		}
		else if(fichier.isDirectory() == true) {
			String chemin = repertoireCourant + commandeArgs[0] +"\\";
			System.out.println("Nouveau chemin : " + chemin);
			repertoireCourant = chemin;
			ps.println("chemin : " + chemin);
		}
		else {
			ps.println("Le répertoire que vous voulez accèder n'est pas présent. Merci d'utiliser un fichier valide.");
		}
	}

}
