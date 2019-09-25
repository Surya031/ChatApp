import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Executors;


public class Server1 {

    
    public static void main(String[] args) throws Exception {
        try (var listener = new ServerSocket(59898)) {
            System.out.println("Chat Server is running...");
            var pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new Capitalizer(listener.accept()));
            }
        }
    }

    private static class Capitalizer implements Runnable {
        private Socket socket;

        Capitalizer(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Connected: " + socket);
            try {
            	Scanner sc =new Scanner(System.in);
                var in = new Scanner(socket.getInputStream());
                var out = new PrintWriter(socket.getOutputStream(), true);
                while (in.hasNextLine()) {
                    String str=in.nextLine();
                    System.out.println("Message from:"+"\nIP:"+socket.getLocalAddress()+"\nMessage:"+str);
                    System.out.println("Enter your message:");
                    String str2=sc.nextLine();
                    out.println(str2);
                }

            } catch (Exception e) {
                System.out.println("Error:" + socket);
            } finally {
                try { socket.close(); } catch (IOException e) {}
                System.out.println("Closed: " + socket);
            }
        }
    }
}