import sun.font.TrueTypeFont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer2 implements Runnable {
    private static Socket clientSocket;

    public EchoServer2(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public static void main(String[] args) {
        ExecutorService eService = Executors.newFixedThreadPool(5);
        System.out.println("다중 접속 에코 서버");

        try (ServerSocket serverSocket = new ServerSocket(20000)) {
            while (true) {
                System.out.println("클라이언트 접속 대기 중...");
                clientSocket = serverSocket.accept();
                EchoServer2 tes = new EchoServer2(clientSocket);
                new Thread(tes).start();
                eService.submit(tes);
            }
        } catch (IOException ex) {
            System.out.println("입출력 예외 발생");
        }
        System.out.println("다중 접속 에코 서버 종료");
        eService.shutdown();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " 스레드 접속");
        try (
                BufferedReader br = new BufferedReader
                        (
                                new InputStreamReader(clientSocket.getInputStream())
                        );
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String inputLine;
            while ((inputLine = br.readLine()) != null){
                System.out.println(clientSocket.getRemoteSocketAddress().toString() + " " + Thread.currentThread() + "클라이언트가 보낸 메세지: " + inputLine);
                out.println(inputLine);
            }
            System.out.println(Thread.currentThread() + "클라이언트가 종료됨");
        } catch (IOException ex) {
            System.out.println("입출력 예외 발생");
        }
    }
}
