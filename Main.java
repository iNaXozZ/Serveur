/*
 * TP JAVA RIP
 * Min Serveur FTP
 * */

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintStream;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	 
	
		  
		public static void main(String[] args) throws Exception {
			try{
				/**
				 * Création d'un socket server 
				 * port:2124
				 */
			      ServerSocket server=new ServerSocket(2124);
			      /**
			       * création variable compteur pour compter nombre de client
			       */
			      int counter=0;
			      System.out.println("Demarrage serveur ....");
			      /**
			       *
			       * ajout dans le compteur
			       * le server accept le client il est connecté
			       * enregistre la requete
			       * 
			       */
			      while(true){
			        counter++;
			        Socket serverClient=server.accept(); 
			        
			        System.out.println(" >> " + "client Numero:" + counter + " s'est connecté");
			        ServerClientThread sct = new ServerClientThread(serverClient,counter); 
			        sct.start();
			      }
			    }catch(Exception e){
			      System.out.println(e);
			    }
		}
}
			class ServerClientThread extends Thread {
		   
		    	  Socket serverClient;
		    	  int clientNo;
		    	  int squre;
		    	  ServerClientThread(Socket inSocket,int counter){
		    	    serverClient = inSocket;
		    	    clientNo=counter;
		    	  }
		    	  public void run(){
		    	    try{
		    	    	
		    	    		
		    	    	BufferedReader br = new BufferedReader(new InputStreamReader(serverClient.getInputStream()));
		    	        PrintStream ps = new PrintStream(serverClient.getOutputStream());

		    	        ps.println("1 Bienvenue ! ");
		    	        ps.println("1 Serveur FTP Personnel.");
		    	        ps.println("0 Authentification : ");


		    	        String commande = "";

		    	        // Attente de reception de commandes et leur execution
		    	        while(!(commande=br.readLine()).equals("aurevoir")) {
		    	            System.out.println(">> "+commande);
		    	            CommandExecutor.executeCommande(ps, commande);
		    	        }
		    	    	
		    		 
		    	        /**
		    	         * fermeture du buffer , socket ,stream
		    	         */
		    	        br.close();
			    	    ps.close();
		    	        serverClient.close();
		    	    	
		    	    	}
		    	    	catch(Exception ex){
		    	      System.out.println(ex);
		    	    }finally{
		    	      System.out.println("Client -" + clientNo + " est parti!! ");
		    	    }
		    	  }
		    	}	    
		 
	


