import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

public class DatagramSocket {
    public static void main(String args[]) {
        System.out.println("Multicast Time Server");
        java.net.DatagramSocket serverSocket = null; // UDP
        try {
            serverSocket = new java.net.DatagramSocket();
            while (true) {
                String dateText = new Date().toString();
                byte[] buffer = new byte[256];
                buffer = dateText.getBytes();
                InetAddress group = InetAddress.getByName("224.0.0.117");
                DatagramPacket packet;
                packet = new DatagramPacket(buffer, buffer.length, group, 8888);
                serverSocket.send(packet);
                System.out.println("Time sent: " + dateText);
                try {
                    Thread.sleep(5000); // 5초 단위 딜레이
                } catch (InterruptedException ex) {
                    System.out.println("예외처리");
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}