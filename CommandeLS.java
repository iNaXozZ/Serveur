import java.awt.SystemTray;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class CommandeLS extends Commande {
	
	public CommandeLS(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	public void execute() {
		ps.println("La commande ls n'est pas encoré implémentée");
		
		
		//lire les fichiers d'un dossier en utilisant la maéthode newDIrectoryStream
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(repertoireCourant))) {
		  
			//itérer la liste des fichiers
			for (Path file: stream) {
		        System.out.println(file.getFileName());
		    }
		} 
		catch (IOException | DirectoryIteratorException ex) {
		    System.err.println(ex);
		}
		
		
			
		
		
		
		//test aller au repertoire courant du projet
		String pwd= System.getProperty(repertoireCourant);
	System.out.println("repertoire courant"+pwd);
	}

}
