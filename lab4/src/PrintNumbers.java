public class PrintNumbers {
    static public void printNumbers() {
        for(int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" +
                    (Thread.currentThread().getId() + i));
        }
    }

}
