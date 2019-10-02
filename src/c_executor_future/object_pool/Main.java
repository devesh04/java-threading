package c_executor_future.object_pool;

/**
 * Created by devesh on 06/05/19.
 */
public class Main {

    public static void main(String a[]) throws InterruptedException {
        SwimmingPool swimmingPool = new SwimmingPool();
        swimmingPool.turnUpTheNotch();
        Thread.sleep(6000);
        Liqour liqour = swimmingPool.turnUpTheNotch();


        swimmingPool.poolFullOfLiqour.returno(liqour);
        Thread.sleep(6000);

        swimmingPool.flush();


    }
}
