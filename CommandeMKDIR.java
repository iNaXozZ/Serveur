import java.io.File;
import java.io.PrintStream;

public class CommandeMKDIR extends Commande {
	
	public CommandeMKDIR(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}
	
	public void execute() {
		
		File file = new File(commandeArgs[1]);
		String s = file.getAbsoluteFile().toString();
		
		//for ()
		
	}

}
