
public class Time implements Runnable{
    private final int PAUSE = 1;
    public static int countSteps = 0;
    @Override
    public void run() {
        while (Main.game == true) {
            countSteps++;
            Main.background.repaint();
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {

            }
        }
    }
}
