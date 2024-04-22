package beginner.poly12.ex2.hans_answer;

public class PayService {
    public void processPay(String option, int amount) {
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);
        Pay pay = PayStore.findPay(option);
        boolean result=pay.pay(amount);
        System.out.println(result ? "결제가 성공했습니다." : "결제가 실패했습니다.");
    }
}
