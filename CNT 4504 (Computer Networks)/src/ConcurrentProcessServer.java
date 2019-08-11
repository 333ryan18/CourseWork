import java.net.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

//----------------------------------------------------------------------------------------------
//proposed ServerThread object
class ServerThread{
    PrintWriter out;
    BufferedReader in;
    Socket client;


    public ServerThread(Socket client)throws IOException{
        try{
            this.client = client;
            this.out = new PrintWriter(client.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        try{
            String line = in.readLine();
            int selection = line.charAt(0);
            switch (selection) {
                case 49:
                    String currentDate = new Date().toString();
                    out.println(currentDate);
                    break;
                case 50:
                    String currentUptime = getSystemUptime();
                    out.println(currentUptime + " seconds");
                    break;
                case 51:
                    StringBuilder memoryUse = getMemoryUse();
                    out.println(memoryUse);
                    break;
                case 52:
                    String netStat = getNetstat();
                    out.println(netStat);
                    break;
                case 53:
                    String currentUsers = getCurrentUsers();
                    out.println(currentUsers);
                    break;
                case 54:
                    String currentProcesses = getCurrentProcesses();
                    out.println(currentProcesses);
                    break;
                case 55:
                    String clientIP = client.getRemoteSocketAddress().toString();
                    System.out.println("Connection Closed with Client (" + clientIP + ").");
                    out.flush();
                    break;
            }//end switch
            in.close();
            out.close();
            client.close();
        }catch (IOException e) {
            System.out.println("Exception caught when handling a connection.");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end run

    public static String getSystemUptime () throws Exception {
        String uptime = new Scanner(new FileInputStream("/proc/uptime")).next();
        return uptime;
    }
    public  static StringBuilder getMemoryUse () throws Exception {
        Runtime runtime = Runtime.getRuntime();

        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        sb.append("Free Memory: " + format.format(freeMemory / 1024));
        sb.append("\n");
        sb.append("Allocated Memory: " + format.format(allocatedMemory / 1024));
        sb.append("\n");
        sb.append("Max Memory: " + format.format(maxMemory / 1024));
        sb.append("\n");
        sb.append("Total Free Memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024));

        return sb;
    }

    public static String getNetstat () {
        //
        String cmd = "netstat";
        return getString(cmd);
    }

    private static String getString (String cmd){
        String s;
        String M = "";
        Process p;
        try {
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
                M += s + "\n"; //store string
            }
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return M;
    }

    public static String getCurrentUsers () {
        //
        String cmd = "w";
        String s;
        String message = "";
        Process p;
        try {
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
                message = s;
            }
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }

    public static String getCurrentProcesses () {
        //
        String cmd = "ps -e";
        return getString(cmd);
    }
    //all of the other methods here. Will method output/architecture need to be changed in any way?
}

public class ConcurrentProcessServer {
    public static void main(String[] args) throws IOException {

        try(//moved some things together to try and consolidate IOException risks
            ServerSocket server = new ServerSocket(9090,100);

        ){
            while(true){
                try{
                    //accept new clients and run threads
                    ServerThread client = new ServerThread(server.accept());
                    client.run();

                }catch(IOException e){//catch for server.accept
                    e.printStackTrace();
                }
            }
        }
    }
}
