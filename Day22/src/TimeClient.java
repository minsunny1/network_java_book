import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class TimeClient {
        public static void main(String args[]) {
            System.out.println("Multicast Time Client");
            try (MulticastSocket socket = new MulticastSocket(10000)) {
                InetAddress group = InetAddress.getByName("224.0.0.117");
                socket.joinGroup(group);
                System.out.println("Multicast Group Joined");
                byte[] buffer = new byte[256];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                for (int i = 0; i < 5; i++) {
                    socket.receive(packet);
                    String received = new String(packet.getData());
                    System.out.println(received.trim());
                }socket.leaveGroup(group);
            } catch (IOException ex) {
                System.out.println("예외처리");
            }
            System.out.println("Multicast Time Client Terminated");
        }
    }

