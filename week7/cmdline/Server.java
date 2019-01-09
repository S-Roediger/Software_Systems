
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
	
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	if (args.length != 2) {
    		System.out.println(USAGE);
    		System.exit(0);
    	} //do not forget to check whether the arguments are correct!
    
    	String name = args[0]; 
    	int port = Integer.parseInt(args[1]);
    	
    	try {
    		System.out.println("Listening");
    		ServerSocket ssocket = new ServerSocket(port);
			Socket sock = ssocket.accept();
			System.out.println("Connected");
				
			Peer server = new Peer(name, sock);
			Thread streamInputHandlerS = new Thread(server);
			streamInputHandlerS.start();
			server.handleTerminalInput();
			server.shutDown();
				
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }

} // end of class Server
