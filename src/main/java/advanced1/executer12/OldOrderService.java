package advanced1.executer12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static advanced1.thread2.MyLogger.log;
import static advanced1.thread3.ThreadUtils.sleep;

public class OldOrderService {

    private final ExecutorService es = Executors.newFixedThreadPool(10);

    public void order(String orderNo) throws InterruptedException, ExecutionException {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        try {
            Future<Boolean> inventoryFuture = es.submit(inventoryWork);
            Future<Boolean> shippingFuture = es.submit(shippingWork);
            Future<Boolean> accountingFuture = es.submit(accountingWork);

            Boolean inventoryResult = inventoryFuture.get();
            Boolean shippingResult  = shippingFuture.get();
            Boolean accountingResult  = accountingFuture.get();

            // 결과 확인
            if (inventoryResult && shippingResult && accountingResult) {
                log("모든 주문 처리가 성공적으로 완료되었습니다."); } else {
                log("일부 작업이 실패했습니다."); }
        } finally {
            es.close();
        }
//
//        List<Work> works = List.of(inventoryWork, shippingWork, accountingWork);
//
//        ExecutorService es = Executors.newFixedThreadPool(3);
//        List<Future<Boolean>> values = es.invokeAll(works);
//        List<Boolean> results = new ArrayList<>(3);
//        for (Future<Boolean> value : values) {
//            results.add(value.get());
//        }
//
//        for (Boolean result : results) {
//            if (!result) {
//                log("일부 작업이 실패했습니다.");
//                return;
//            }
//        }
//        log("모든 주문 처리가 성공적으로 완료되었습니다.");

    }
    static class InventoryWork implements Work{
        private final String orderNo;
        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class ShippingWork implements Work{
        private final String orderNo;
        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class AccountingWork implements Work{
        private final String orderNo;
        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
