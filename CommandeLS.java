
import java.io.File;

import java.io.PrintStream;




public class CommandeLS extends Commande {
	
	public CommandeLS(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
		
	}

	public void execute() {
		
		File file= new File(".");
		File[] liste=file.listFiles();
		
		
		//lire les fichiers d'un dossier en utilisant la maéthode newDIrectoryStream
		for(File item : liste){
			if(file.getAbsoluteFile()!=null) {
	        if(item.isFile())
	        { 
	        	
	          System.out.format("Nom du fichier: %s%n", item.getName()); 
	        } 
	        else if(item.isDirectory())
	        {
	        	
	          System.out.format("Nom du répertoir: %s%n", item.getName()); 
	        }
			}
		}
	
				
		
	
		
		
	}	
}
