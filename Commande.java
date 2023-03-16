import java.io.PrintStream;

public abstract class Commande {
	
	protected PrintStream ps;
	protected String commandeNom = "";
	protected String [] commandeArgs ;
	public static String repertoireCourant = "C:\\Users\\";
	public static String [] chaineRemplace= new String [10];
	public static int i = 0;
	
	public Commande(PrintStream ps, String commandeStr) {
		this.ps = ps ;
		String [] args = commandeStr.split(" ");
		commandeNom = args[0];
		commandeArgs = new String[args.length-1];
		
		for(int i=0; i<commandeArgs.length; i++) {
			commandeArgs[i] = args[i+1];
		}
	}
	
	public abstract void execute();

}
