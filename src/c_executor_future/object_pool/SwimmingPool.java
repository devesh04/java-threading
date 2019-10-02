package c_executor_future.object_pool;

import java.util.concurrent.TimeUnit;

/**
 * Created by devesh on 06/05/19.
 */
public class SwimmingPool {

    GenericPool<Liqour> poolFullOfLiqour;

    public SwimmingPool(){

        this.poolFullOfLiqour = new GenericPool<Liqour>(2, 8, 5, TimeUnit.SECONDS) {
            @Override
            public Liqour createResource() {
                return new Liqour();
            }
        };

    }

    public Liqour turnUpTheNotch(){
        Liqour borrow = this.poolFullOfLiqour.borrow();
        borrow = this.poolFullOfLiqour.borrow();
        borrow = this.poolFullOfLiqour.borrow();
        borrow = this.poolFullOfLiqour.borrow();

        return borrow;

//        borrow = this.poolFullOfLiqour.borrow();
//        borrow = this.poolFullOfLiqour.borrow();
//        borrow = this.poolFullOfLiqour.borrow();
//        borrow = this.poolFullOfLiqour.borrow();
//        borrow = this.poolFullOfLiqour.borrow();
//        borrow = this.poolFullOfLiqour.borrow();
//        borrow = this.poolFullOfLiqour.borrow();
//        borrow = this.poolFullOfLiqour.borrow();
//        borrow = this.poolFullOfLiqour.borrow();
//        borrow = this.poolFullOfLiqour.borrow();
    }

    public void flush(){
        this.poolFullOfLiqour.shutdown();
    }




}
