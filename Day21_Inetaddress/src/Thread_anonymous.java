import java.sql.SQLOutput;

public class Thread_anonymous {
    public static void main(String[] args) {
        new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++) {
                    System.out.print("잘가 ");
                    try{
                        java.lang.Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("예외발생");
                    }
                }
            }
        }).start();

        for (int i=0; i<5; i++) {
            System.out.print("안녕 ");
            try{
                java.lang.Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("예외발생");
            }
        }
    }
}
