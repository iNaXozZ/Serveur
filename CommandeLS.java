
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class CommandeLS extends Commande {
	
	public CommandeLS(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
		
	}

	public void execute() {
		
		File file= new File(".");
		File[] liste=file.listFiles();
		
		//chemin en dur
		//String s = file.getAbsoluteFile().toString();
		
		//lire les fichiers d'un dossier en utilisant la maéthode newDIrectoryStream
		for(File item : liste){
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
