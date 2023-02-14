//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//// try ()안에 유효한 객체들을 생성하고, try 구문이 끝나면 자동으로 소멸됨 => close() 호출 안해도 됨
//public class EchoServer {
//    try(
//    ServerSocket serverSocket = new ServerSocket(6000))
//    {
//        System.out.println("클라이언트 접속 대기 중...");
//        Socket clientSocket = serverSocket.accept(); // 접속 대기
//        // server에 접속한 client의 주소가 저장됨
//        System.out.println("클라이언트 접속됨");
//
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) // true는 buffer를 자동적으로 flush 해줌 => buffer를 비워줌
//        {
//            String inputLine;
//            while ((inputLine = br.readLine()) != null)
//            { // br은 cilient의 정보
//                System.out.println("클라이언트로부터 받은 메세지: " + inputLine);
//                out.println(inputLine); // 클라이언트로 송신 // out은 printwriter의 객체
//            }
//        } catch (IOException e)
//        {
//            throw new RuntimeException(e);
//        }
//    }
//    // BufferedReader는 수신용
//    // PrintWriter는 송신용 객체
//catch (IOException ex) {
//        System.out.println("접속 실패!");
//}
//
//
//    public EchoServer() throws IOException {
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleEchoClient {
    public static void main(String[] args) {
        System.out.println("에코 클라이언트 시작됨");
        try {
            // InetAddress localAddress = InetAddress.getLocalHost();  // 127.0.0.1
            Socket clientSocket = null;
            PrintWriter pw = null;
            BufferedReader br = null;
            try{
                clientSocket = new Socket("165.246.115.165", 9000);
                pw = new PrintWriter(clientSocket.getOutputStream(), true);
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("서버에 연결됨");
                Scanner sc = new Scanner(System.in);
                while (true) {
                    System.out.print("전송 메세지 입력 : ");
                    String line = sc.nextLine();
                    if ("exit".equalsIgnoreCase(line)) {
                        break;  // 종료 조건
                    }
                    pw.println(line);  // 서버로 전송
                    // 서버로 부터 수신받은 객체에서 라인 단위로 문자열 리턴
                    System.out.println("서버로 부터 받은 메아리 : " + br.readLine());
                }
            } catch (IOException ex) {
                System.out.println("입출력 예외 발생");
            } finally {  // 자원 해제
                clientSocket.close();
                pw.close();
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // unicast: 일대일 통신
        // multicast: 타겟이 정해있는 일대다 통신
        // broadcast
    }
}
