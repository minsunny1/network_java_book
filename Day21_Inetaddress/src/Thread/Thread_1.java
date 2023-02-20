public class Thread_1 {
    public static void main(String[] args){
        java.lang.Thread t = new java.lang.Thread(new MyRunnable());
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.print("안녕. ");
            try{
                java.lang.Thread.sleep(500); // 0.5초 대기
            } catch (InterruptedException e) {
                System.out.println("예외입니다.");
            }
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.print("잘가. ");
            try{
                java.lang.Thread.sleep(500);
            }catch (InterruptedException e) {
                System.out.println("예외입니다.");
            }
        }
    }
}
