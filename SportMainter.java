package d13_inface;

public interface SportMainter {
    //1.默认方法
    //接口不能创造对象，过继给了实现类，实现类对象才可以调用
   default  void run(){
       go();
       System.out.println("跑得快");
}
//2.静态方法 static修饰
    //必须接口名自己调用
    static  void  inAdd() {
        System.out.println("今天下雨了");}

        //3.私有方法
        //接口内部使用 必须自己调用
        private void go () {
            System.out.println("跑");
    }

}
class PingPong implements  SportMainter{

}
class Test{
    public static void main(String[] args) {
        PingPong p = new PingPong();
        p.run();

        SportMainter.inAdd();
    }
}