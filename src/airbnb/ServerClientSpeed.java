package airbnb;

import java.io.*;
import java.net.Socket;

/**
 * Created by jun on 5/5/16.
 */
public class ServerClientSpeed {
    //status   50.1 3.75, first number means throttle force, second number means current velocity
    //throttle 50.1

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 55555);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintWriter pw = new PrintWriter(os, true);

        System.out.println("Server address is " + socket.getRemoteSocketAddress());
        String line;

        double hi = 100;
        double low = 0;
        double speed = 29.0;
        double prevSpeed = 0.0;

        double delta = 1e-2;
        boolean stablized = false;
        while (true) {
            pw.println("STATUS");
            line = br.readLine();
            double currentSpeed = Double.valueOf(line.split(" ")[1]);
            double currentThrottle = Double.valueOf(line.split(" ")[0]);
            stablized = Math.abs(currentSpeed - prevSpeed) < delta;
            prevSpeed = currentSpeed;
            System.out.println("Current speed: " + currentSpeed);
            System.out.println("Current throttle: " + currentThrottle);
            if (!stablized) {
                Thread.sleep(1000);
                continue;
            } else {
                System.out.println("hi"+hi + " " + "low "+low);
                if (Math.abs(currentSpeed - speed) < delta)
                    break;
                else if (currentSpeed < speed) {
                    low = currentThrottle;
                    pw.println("THROTTLE " + String.valueOf((low + hi) / 2));
                } else {
                    hi = currentThrottle;
                    pw.println("THROTTLE " + String.valueOf((low + hi) / 2));
                }
            }
        }

        br.close();
        pw.close();
        socket.close();
    }
}
