package d9_abstract;
//模板方法
public abstract  class Student {
    public  final  void write() {

        System.out.println("\t《我的爸爸》");
        System.out.println("我的爸爸啥样");
        //正文部分
        //把正文部分定义成抽象方法交给子类完成
        System.out.println(WriteMain());

        System.out.println("我的爸爸太好了");
    }
    public  abstract String WriteMain();
}
