package t20170118;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * Created by moon on 18/01/2017.
 *
 * @Description:
 */
public class PingTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String ip = "github.com";
        System.out.println(runSystemCommand("ping -c 5 " + ip));

        checkReachable();

    }

    private static void checkReachable() throws IOException {
        InetAddress inet;

        inet = InetAddress.getByName("github.com");
        System.out.println("Sending Ping Request to " + inet);
        System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
    }

    public static String runSystemCommand(String command) {
        StringBuilder sb = new StringBuilder();
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            // reading output stream of the command
            while ((s = inputStream.readLine()) != null) {
                sb.append(s).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return sb.toString();
        }
    }
}
