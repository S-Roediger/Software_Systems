package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException {
    	this.name = nameArg;
    	this.sock = sockArg;
		
		
    	
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
    	try {
    		InputStream inp = sock.getInputStream();
    		in = new BufferedReader(new InputStreamReader(inp));
			String line = in.readLine();
			while (line != null) {
				System.out.println("Other: " + line);
				line = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
    	OutputStream outp;
		try {
			outp = sock.getOutputStream();
			out = new BufferedWriter(new OutputStreamWriter(outp));
			String a = "start";
			
			while (a != null) {
				a = readString();
				
				if (!a.equals(EXIT)) {
					out.write(a);
					out.newLine();
				    out.flush();
				    
				    
				    //System.out.println("You: " + a);
				} else {
					out.write("Exit confirmed.");
		    		System.out.println(EXIT);
		    		out.close();
				}
	    		
	    		
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
    	try {
    		System.out.println("The system shuts down now");
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**  returns name of the peer object*/
    public String getName() {
        return name;
    }

    /** read a line from the default input */
    static public String readString() {
        String antw = null;
        try {
            BufferedReader in1 = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in1.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
