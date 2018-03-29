package ch18_3;

public class PrintThread extends Thread {
    SharedArea sharedArea;
    public void run() {
        if (sharedArea.isReady != true) {
            try {
                synchronized (sharedArea) {
                //신호 받음
                	sharedArea.wait();
                }            
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(sharedArea.result);
    }

}
