import java.io.File;
import java.io.PrintStream;

public class CommandeMKDIR extends Commande {
	
	public CommandeMKDIR(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}
	
	public void execute() {
		
		File dossier = new File(repertoireCourant+"\\"+commandeArgs[0]);
		try {
			boolean res = dossier.mkdir();
		      if(res)
		        { 
		    	  ps.println("0 commande mkir OK");
		        } 
		        else 
		        {
		        	ps.println("2 Le dossier "+ commandeArgs[0] + " existe déjà");
		        } 
			
		} catch (Exception e) {
			ps.println("Problème lors de l'éxécution de la commande MKDIR");
		}
		
	}

}
