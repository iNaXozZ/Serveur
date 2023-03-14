import java.awt.image.RescaleOp;
import java.io.File;
import java.io.PrintStream;

public class CommandeMKDIR extends Commande {
	
	public CommandeMKDIR(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}
	
	public void execute() {
		
		File dossier = new File(repertoireCourant+"\\"+commandeArgs[0]);
		
		boolean res = dossier.mkdir();
	      if(res)
	        { 
	          ps.println("Le dossier a bien été crée"); 
	        } 
	        else 
	        {
	          ps.println("Le dossier n'a pas pu être crée");
	        } 
	}

}
