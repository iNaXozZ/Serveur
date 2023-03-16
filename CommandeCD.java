import java.io.File;
import java.io.PrintStream;

public class CommandeCD extends Commande {
	
	public CommandeCD(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	//test push 
	public void execute() {
		File fichier = new File(repertoireCourant +"\\"+commandeArgs[0]);
		
		//Ajoute dans une variable le résultat de la commande si la commande est différente de cd ..
		if (!(commandeArgs[0].equals("..")))
		{
			chaineRemplace[i] = commandeArgs[0]+"\\";
			i++;
		}
		
		try {
			// Cas où l'on utilise la commande cd ..
			if(commandeArgs[0].toLowerCase().equals("..")) {
				String cheminAbsolu = repertoireCourant;
				cheminAbsolu = cheminAbsolu.replace(chaineRemplace[i-1], "");
				repertoireCourant = cheminAbsolu;
				i--;
				ps.println("chemin absolu : " + cheminAbsolu);
			}
			//Cas où on utilise la commande cd + un nom de fichier
			else if(fichier.isDirectory() == true) {
				String chemin = repertoireCourant + commandeArgs[0] +"\\";
				repertoireCourant = chemin;
				ps.println("0 commande cd OK");
				ps.println("0 chemin : " + chemin);
			}
			// Sinon retourner que le répertoire souhaité n'existe pas
			else {
				ps.println("2 Le répertoire que vous voulez accèder n'est pas présent. Merci d'utiliser un fichier valide.");
			}
		}
		catch (Exception e) {
			ps.println("Problème lors de l'éxécution de la commande CD");
		}
		
	}

}
