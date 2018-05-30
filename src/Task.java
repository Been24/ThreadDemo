import java.util.concurrent.TimeUnit;

/**
 * Created by Been on 2018/5/29.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
