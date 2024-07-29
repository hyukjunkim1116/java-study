package advanced1.executer12;

import java.util.concurrent.ExecutionException;

public class OldOrderServiceTestMain {
    public static void main(String[] args) throws Exception {
        String orderNo = "Order#1234";
        OldOrderService orderService = new OldOrderService();
        orderService.order(orderNo);
    }
}
