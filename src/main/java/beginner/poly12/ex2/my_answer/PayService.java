package beginner.poly12.ex2.my_answer;

public class PayService {
    private int payIndex;
    private boolean isPayable(String option) {
        for (int i=0; i<Pay.PAY_NAME.length;i++) {
            if (Pay.PAY_NAME[i].equals(option)) {
                payIndex=i;
                return true;
            }
        }
        return false;
    }
    private Pay getPay() {
        Pay pay = null;
        if (payIndex == 0) {
            pay = new KakaoPay();
        }
        if (payIndex == 1) {
            pay = new NaverPay();
        }
        return pay;
    }
    public void processPay(String option, int amount) {
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);
        if (!isPayable(option)) {
            System.out.println("결제 수단이 없습니다.");
            System.out.println("결제가 실패했습니다.");
            return;
        }
        getPay().pay(amount);
        System.out.println("결제가 성공했습니다.");

    }
}
