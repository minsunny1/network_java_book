import java.net.UnknownHostException;

public class InetAddress {
// public 생성자가 없음
// static getter(정적 메서드) 방식으로 객체를 생성함
    public static void main(String[] args){
        // surround with try/catch => 예외처리
        try {
            java.net.InetAddress addr = java.net.InetAddress.getByName("www.inha.kr");
            //getByName에 Ctrl + V => 내부 코드 구조를 알 수 있음
            //InetAddress addr = InetAddress.getByName("www.inhazzz.kr"); // 존재하지 않는 주소는 예외처리
            System.out.println(addr); // 서버의 IP 주소 출력
            System.out.println(addr.getCanonicalHostName());
            System.out.println(addr.getHostAddress());
            System.out.println(addr.getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
            //System.out.println("해당 URL은 존재하지 않습니다.");
        }
    }
}
