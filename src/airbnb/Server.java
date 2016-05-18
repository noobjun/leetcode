package airbnb;

import java.net.*;
import java.io.*;

/**
 * Created by jun on 5/11/16.
 */


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(55555);
        Socket clientSocket = serverSocket.accept();

        InputStream is = clientSocket.getInputStream();
        OutputStream os = clientSocket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintWriter pw = new PrintWriter(os, true);

        String line;

        double currentThrottle = 0;
        double currentSpeed = 0;
        System.out.println("ACCEPTED INCOMING CONNECTION");

        while (!(line = br.readLine()).equals("BYE")) {
            System.out.println("Received from client " + line);
            String[] tokens = line.split(" ");
            String command = tokens[0];
            System.out.println("Command is " + command);
            if (command.equals("STATUS")) {
                pw.printf("%f %f", currentThrottle, currentSpeed);
                pw.println();
            } else if (command.equals("THROTTLE")) {
                double throttle = Double.valueOf(tokens[1]);
                currentThrottle = throttle;
                currentSpeed = throttle * 1.5;
                //pw.println("Throttle set to " + currentThrottle);
            }
        }
        br.close();
        pw.close();
        clientSocket.close();
        serverSocket.close();
        System.out.println("Closed everything.");
    }


}

