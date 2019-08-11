import java.net.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        int portNumber = 9090;
        try {
            ServerSocket server = new ServerSocket(9090 ,100);
            System.out.println("(Type CTRL+C to end the server program)");
            while (true) {
                try (
                        Socket client = server.accept();
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                )
                {
                        System.out.println("Connection successful with user: " + client.getInetAddress());
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
                                break;
                        }//end of switch statement for requests
                    //close IO and the client socket
                    System.out.println("Closing connection for user " + client.getInetAddress());
                    in.close();
                    out.close();
                    client.close();
                } catch (IOException e) {
                    System.out.println("Exception caught when handling a connection.");
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting for next connection...");
            }//end of server loop
        } catch(IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber);
            System.out.println(e.getMessage());
        }
    }

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
}
