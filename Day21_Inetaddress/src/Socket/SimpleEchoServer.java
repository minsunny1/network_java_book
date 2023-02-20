// socket은 전화기

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class EchoClient {
//    public static void main(String[] args) {
//
//    try {
//        InetAddress localAddress = InetAddress.getLocalHost(); // 127.0.0.1
//        Socket clientSocket = null;
//        PrintWriter out = null;
//        clientSocket = new Socket(localAddress, 6000);
//        try {Socket clientSocket = new Socket(localAddress, 6000);
//             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//             BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
//        {
//            System.out.println("서버에 연결됨");
//            Scanner sc = new Scanner(System.in);
//            while (true) {
//            System.out.print("Enter text: ");
//            String line = sc.nextLine();
//            if ("exit".equalsIgnoreCase(line)) {
//                break; // 종료조건
//            }
//            out.println(line); // 서버로 전송
//            // 서버로부터 수신받은 객체에서 라인 단위로 문자열 리턴
//            System.out.println("서버로부터 받은 메아리: " + response);
//        }
//
//        }
//    } catch (IOException ex) {
//        System.out.println("입출력 예외 발생");
//    } finally {
//            clientSocket.close();
//
//        }
//        }
//
//}
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.awt.SystemColor.text;

public class SimpleEchoServer {
    public static void main(String[] args) {
        System.out.println("에코 서버 시작됨");
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("클라이언트 접속 대기 중.....");
            Socket clientSocket = serverSocket.accept();  // 접속 대기
            System.out.println("클라이언트 접속됨.");

//            BufferedReader br = null;
//            PrintWriter pw = null;
//            try {
//                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                pw = new PrintWriter(clientSocket.getOutputStream(), true);
//                String line;
//                while ((line = br.readLine()) != null) {
//                    System.out.println("클라이언트로 부터 받은 메세지 : " + line);
//                    pw.println(line);  // 클라이언트로 송신
//                }
            try (
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter pw =
                            new PrintWriter(clientSocket.getOutputStream(), true))
            {
                Supplier<String> socketInput = () -> {
                    try {
                        return br.readLine();
                    } catch (IOException ex) {
                        return null;
                    }
                };
                Stream s = Stream.generate(socketInput);
                s.map(text -> {
                    System.out.println("클라이언트로부터 받은 메세지: " + text);
                    pw.println(text);
                    return text;
                }).allMatch(t->t!=null);
            } catch (IOException e) {
                throw new RuntimeException(e);
//            } finally {
//                br.close();
//                pw.close();
            }
        }
        catch (IOException ex) {
            System.out.println("접속 실패!");
        }
    }
}