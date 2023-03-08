import java.io.PrintStream;

public class CommandeCD extends Commande {
	
	public CommandeCD(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	//test push
	public void execute() {
		ps.println("La commande cd n'est pas encoré implémentée");
	}

}
