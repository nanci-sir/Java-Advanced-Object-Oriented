package d11_implements;
//实现类
public class PingPongMan implements  SportMan,Law {
    private  String name;

    public PingPongMan(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name +"必须跑步");

    }

    @Override
    public void competition() {
        System.out.println(name+"必须比赛");

}

    @Override
    public void rule() {
        System.out.println(name+"必须守法");
    }
}
