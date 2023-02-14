//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//public class URL_connection {
//    try {
//        URL url = new URL("http://www.inha.ac.kr");
//        URLConnection urlConnection = url.openConnection();
//        BufferedReader br = new BufferedReader(
//                new InputStreamReader(urlConnection.getInputStream()));
//        String line;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
//        br.close();
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        } catch (IOException ex) {
//        System.out.println("입출력 오류");
//        }
//        } // p38 chanel과 buffer를 이용하여 똑같이 돌아가게 만듦


