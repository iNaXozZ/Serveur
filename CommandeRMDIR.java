import java.io.File;
import java.io.PrintStream;

public class CommandeRMDIR extends Commande {
	
	public CommandeRMDIR(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}
	
	public void execute() {
		
		File dossier = new File(repertoireCourant+"\\"+commandeArgs[0]);
		try {
			if(dossier.isDirectory()){
		        //si le dossier est vide, on le supprime
		        if(dossier.list().length == 0){
		          dossier.delete();
		          ps.println("0 la comande rmdir est OK");
		          ps.println("Votre dossier "+ commandeArgs[0] + " a bien été supprimé");
		        }
		        else {
		        	ps.println("1 Votre dossier existe mais n'est pas vide");
		        }
			}
			else {
				ps.println("2 Votre dossier n'existe pas");
			}
			
		} catch (Exception e) {
			ps.println("Problème lors de l'éxécution de la commande");
		}

	}

}
