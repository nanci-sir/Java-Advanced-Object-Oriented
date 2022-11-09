package d7_abstract;

public abstract class Card {
    private String  username;
    private  double money;

    //定义支付方法
    //抽象方法不能给方法体
    public abstract void pay(double money);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
