package d7_abstract;

public class GoldCard  extends  Card{

    @Override
    public void pay(double money) {
        System.out.println("您当前消费： "+ money);
        System.out.println("您当前消费余额 "+ getMoney());
        double rs = money*0.8;
        System.out.println("您实际支付： "+rs);
        setMoney(getMoney() - rs);

    }
}
