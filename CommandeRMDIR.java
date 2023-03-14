import java.io.File;

import java.io.PrintStream;


public class CommandeRMDIR extends Commande {
	
	public CommandeRMDIR(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}
	
	public void execute() {
		
		File file = new File(repertoireCourant+"\\"+ commandeArgs[0]);
		        File[] liste = file.listFiles();
		          for(File item : liste){
		            if(item.isDirectory()== true)
		            { 
		            	file.delete();
		            	
		              ps.println("fichier supprimer"); 
		            } 
		            else 
		            {
		              ps.println("pas supprimer"); 
		            } 

		          }
		    }
}
