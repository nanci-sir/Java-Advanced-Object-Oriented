package d7_abstract;

public class Test {
    public static void main(String[] args) {
        GoldCard c = new GoldCard();
        c.setMoney(10000);
        c.setUsername("张三");

        c.pay(300);
        System.out.println(c.getUsername()+"账户剩余余额："+c.getMoney());
        //您当前消费： 300.0
        //您当前消费余额 10000.0
        //您实际支付： 240.0
        //张三账户剩余余额：9760.0

    }
}
