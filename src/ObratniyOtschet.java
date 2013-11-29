public class ObratniyOtschet {
   
    public static void main(String[] args) throws InterruptedException {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(0);
    }
   
}