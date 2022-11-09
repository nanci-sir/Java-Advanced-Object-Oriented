# Java-Advanced-Object-Oriented
Java 面向对象进阶
# 1. 包

## 1.1 什么是包？

包是用来分门别类的管理各种不同类的，类似于文件夹、建包利于程序的管理和维护。
建包的语法格式：package 公司域名倒写.技术名称。报名建议全部英文小写，且具备意义

建包语句必须在第一行，一般IDEA工具会帮助创建

## 1.2 导包  

相同包下的类可以直接访问，不同包下的类必须导包,才可以使用！导包格式：import 包名.类名;
假如一个类中需要用到不同类，而这个两个类的名称是一样的，那么默认只能导入一个类，另一个类要带包名访问。

# 2. 权限修饰符

## 2.1 **什么是权限修饰符？**

权限修饰符：是用来控制一个成员能够被访问的范围。

可以修饰成员变量，方法，构造器，内部类，不同权限修饰符修饰的成员能够被访问的范围将受到限制。

## 2.2 权限修饰符的分类和具体作用范围：

权限修饰符：有四种作用范围由小到大（private -> 缺省 -> protected - > public ）

| **修饰符** | **同一 个类中** | **同一个包中**  **其他类** | **不同包下的**  **子类** | **不同包下的**  **无关类** |
| ---------- | --------------- | -------------------------- | ------------------------ | -------------------------- |
| private    | √               |                            |                          |                            |
| 缺省       | √               | √                          |                          |                            |
| protected  | √               | √                          | √                        |                            |
| public     | √               | √                          | √                        | √                          |

## 2.3 学完权限修饰符需要具备如下能力

能够识别别人定义的成员的访问范围。
自己定义成员（方法，成员变量，构造器等）一般需要满足如下要求：
成员变量一般私有。
方法一般公开。
如果该成员只希望本类访问，使用private修饰。
如果该成员只希望本类，同一个包下的其他类和子类访问，使用protected修饰。

```java
package modifer;

public class fu {
    //1.private
    private void privateMethod() {
        System.out.println("private");
    }

    //2.缺省
    void Method() {
        System.out.println("private");
    }

    //3.protected
    protected void protectedMethod() {
        System.out.println("protected");
    }

    //4.public
    public void publicMethod() {
        System.out.println("public");
    }

    public static void main(String[] args) {
        fu f = new fu();
        f.Method();;
        f.privateMethod();
        f.publicMethod();
        f.protectedMethod();
    }
}
```

```java
package modifer.itcast;

import modifer.fu;

public class zi extends  fu {
    public static void main(String[] args) {
        zi z =new zi();
        z.protectedMethod();
        z.publicMethod();


    }
}
```

```java
package modifer;

public class Test {
    public static void main(String[] args) {
        //权限修饰符作用范围
        fu f = new fu();
        f.Method();
        f.protectedMethod();
        f.publicMethod();
    }
}
```

```java
package modifer.itcast;

import modifer.fu;

public class Test2 {
    public static void main(String[] args) {
        fu f = new fu();
        f.publicMethod();
        //  f.Method();报错
        //f.protectedMethod();报错
        // f.privateMethod();报错
    }
}
```

# 3. final

## 3.1 final的作用

final 关键字是最终的意思，可以修饰（类、方法、变量）
修饰类：表明该类是最终类，不能被继承。
修饰方法：表明该方法是最终方法，不能被重写。
修饰变量：表示该变量第一次赋值后，不能再次被赋值(有且仅能被赋值一次)

## 3.2 final修饰变量的注意

final修饰的变量是基本类型：那么变量存储的数据值不能发生改变。
final修饰的变量是引用类型：那么变量存储的地址值不能发生改变，但是地址指向的对象内容是可以发生变化的。

```java
package d3_final;

public class Test {
    //记住final语法
    //final 关键字是最终的意思，可以修饰（类、方法、变量）
    //修饰类：表明该类是最终类，不能被继承。
    //修饰方法：表明该方法是最终方法，不能被重写。
    //修饰变量：表示该变量第一次赋值后，不能再次被赋值(有且仅能被赋值一次)。
}

class Student extends  People{
 //   @Override
 //   public   void eat(){
  //      System.out.println("学生吃的多");
  //  }
}
class People{
    public  final void eat(){
        System.out.println("人吃饭");
    }
}
//class wolf extends Animal{}
//final  class  Animal{}
```

```java
package d3_final;

public class Test2 {
    // 2.成员变量（实例成员变量和静态成员变量）
    public static final String school = "外事";
    //实例成员变量和静态成员变量
    private  final  String name = "小明";//几乎不用
    public static void main(String[] args) {

        //理解final修饰变量
        //1.局部变量
        final double rate = 3.12;
       // school ="西安"; 二次赋值
        //rate = 2.33;//二次赋值不行
        Test2 t = new Test2();
        System.out.println(t.name);
        //t.name = "张三"; 不能二次赋值
        //重点： final 引用类型地址不可以改变 指向对象内容可以改变
    final    Teacher T = new Teacher("学习，上课，吃饭");
    //T2 = null;
        System.out.println(T.getHobby());
        T.setHobby("运动");
        System.out.println(T.getHobby());


    }
}
class  Teacher{
    private String hobby;

    public Teacher(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
```

# 4 常量

常量是使用了public static final修饰的成员变量，必须有初始化值，而且执行的过程中其值不能被改变。
常量名的命名规范：英文单词全部大写，多个单词下划线连接起来。
常量的作用：通常用来记录系统的配置数据。

## 4.1 常量做信息配置的原理、优势

在编译阶段会进行“宏替换”：把使用常量的地方全部替换成真实的字面量。
维护系统容易，可读性更好。

```JAVA
package d4_constant;

public class Demo {
    public  static  final String SCHOOL_NAME = "外事学院";
    public  static  final String UESR_NAME = "外事学院";
    public  static  final String PASS_WORD= "外事学院";
    public static void main(String[] args) {
        System.out.println(SCHOOL_NAME);
        System.out.println(SCHOOL_NAME);
        System.out.println(SCHOOL_NAME);
        System.out.println(SCHOOL_NAME);
        if(UESR_NAME.equals("")){

        }
    }
}
```

## 4.2 案例说明：超级玛丽游戏

现在开发的超级玛丽游戏需要接收用户输入的四个方向的信号（上下左右），以便控制玛丽移动的方向。

选择常量做信息标志和分类：
代码可读性好，实现了软编码形式。

```JAVA
package d4_constant;

public class Constant {
    /**
     常量类：配置类
     */
        public static final int UP = 1;
        public static final int DOWN = 2;
        public static final int LEFT = 3;
        public static final int RIGHT = 4;
    }
```

```JAVA
package d4_constant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo2 {
    public static void main(String[] args) {



            // 目标：理解常量的另外一个作用：做信息的标志和分类。
            // 模拟：控制玛丽的移动：上下左右。
            // 桌面编程
            // 1、创建窗口
            JFrame win = new JFrame("超级玛丽");
            win.setSize(300, 200);

            // 2、设计一个面板（桌布）
            JPanel jPanel = new JPanel();
            win.add(jPanel);

            // 2、放置几个按钮
            JButton b1 = new JButton("上");
            jPanel.add(b1);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 控制玛丽往上跳
                    move(Constant.UP);
                }
            });

            JButton b2 = new JButton("下");
            jPanel.add(b2);
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 控制玛丽往下蹲
                    move(Constant.DOWN);
                }
            });

            JButton b3 = new JButton("左");
            jPanel.add(b3);
            b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 控制玛丽往左走
                    move(Constant.LEFT);
                }
            });

            JButton b4 = new JButton("右");
            jPanel.add(b4);
                    b4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // 控制玛丽往右走
                    move(Constant.RIGHT);
                }
            });

            win.setLocationRelativeTo(null);
            win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            win.setVisible(true);
        }

        public static void move(int orientation){
            // 控制玛丽移动
            switch (orientation) {
                case Constant.UP:
                    System.out.println("玛丽往↑飞了一下~~");
                    break;
                case Constant.DOWN:
                    System.out.println("玛丽往↓蹲了一下~~");
                    break;
                case Constant.LEFT:
                    System.out.println("玛丽往←跑了一下~~");
                    break;
                case Constant.RIGHT:
                    System.out.println("玛丽往→跑了一下~~");
                    break;
            }
        }
    }
```

# 5 枚举

## 5.1枚举的概述

枚举是Java中的一种特殊类型
枚举的作用："是为了做信息的标志和信息的分类"。
定义枚举类的格式：enum Season{   SPRING , SUMMER , AUTUMN , WINTER;}

## 5.2 枚举特征：

枚举类都是继承了枚举类型：java.lang.Enum
枚举都是最终类，不可以被继承。
构造器都是私有的，枚举对外不能创建对象。
枚举类的第一行默认都是罗列枚举对象的名称的。
枚举类相当于是多例模式。

# 6 抽象类

## 6.1 抽象的使用场景

抽象类可以理解成不完整的设计图，一般作为父类，让子类来继承。
当父类知道子类一定要完成某些行为，但是每个子类该行为的实现又不同，于是该父类就把该行为定义成抽象方法的形式，具体实现交给子类去完成。此时这个类就可以声明成抽象类。

## 6.2 抽象类、抽象方法是什么样的？

都是用abstract修饰的；抽象方法只有方法签名，不能写方法体。
一个类中定义了抽象方法，这个类必须声明成抽象类。

## 6.3抽象类基本作用是啥？

作为父类，用来被继承的。

## 6.4 继承抽象类有哪些要注意？

一个类如果继承了抽象类，那么这个类必须重写完抽象类的全部抽象方法，否则这个类也必须定义成抽象类。

```java
package d5_abstract;
//抽象类
public  abstract  class Animal {
    //抽象方法
    public abstract  void run();
}
```

```java
package d5_abstract;

public class Dog  extends Animal{
    @Override
    public void run() {
        System.out.println("狗跑的快");
    }
}
```

```java
package d5_abstract;

public class Test {
    public static void main(String[] args) {
        //认识抽象类
        //父类就把该行为定义成抽象方法的形式，具体实现交给子类去完成。此时这个类就可以声明成抽象类
        Dog D= new Dog();
        D.run();

    }
}
```

## 6.4 系统需求 加油站

某加油站推出了2种支付卡，一种是预存10000的金卡，后续加油享受8折优惠，另一种是预存5000的银卡 ,后续加油享受8.5折优惠。
请分别实现2种卡片进入收银系统后的逻辑，卡片需要包含主人名称，余额，支付功能。

```java
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
```

```java
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
```

```java
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
```

## 6.5 特征和注意事项

类有的成员（成员变量、方法、构造器）抽象类都具备
抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类
一个类继承了抽象类必须重写完抽象类的全部抽象方法，否则这个类也必须定义成抽象类。
不能用abstract修饰变量、代码块、构造器。
最重要的特征：得到了抽象方法，失去了创建对象的能力（有得有失）

```java
package d8_abstract;

public class Test {
    public static void main(String[] args) {
        //类有的成员（成员变量、方法、构造器）抽象类都具备
        //抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类
        //一个类继承了抽象类必须重写完抽象类的全部抽象方法，否则这个类也必须定义成抽象类。
        //不能用abstract修饰变量、代码块、构造器。
        //最重要的特征：得到了抽象方法，失去了创建对象的能力（有得有失）
        //原因 ： 反证法 加入抽象类可以创造对象
        //Animal a = new Animal();
        //a.run();//run方法都没有方法体
      //  Card c= new Card();//抽象方法不允许创造对象
    }
}
abstract  class Card{
    private  String name;
}
class cat extends  Animal{

    @Override
    public void run() {

    }

    @Override
    public void eat() {

    }
}
abstract class Animal{
    public abstract  void run();
    public abstract  void eat();


}
```

## 6.7 final和abstract是什么关系？面试题

互斥关系
abstract定义的抽象类作为模板让子类继承，final定义的类不能被继承。
抽象方法定义通用功能让子类重写，final定义的方法子类不能重写。

# 7 模板方法模式

## 7.1 理解模板方法：写作文案例

```java
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
```

```java
package d9_abstract;

public class StudentChild extends  Student{

    @Override
    public String WriteMain() {
        return "我的爸爸太牛了";
    }
}
```

```java
package d9_abstract;

public class StudentMiddle extends  Student {

    @Override
    public String WriteMain() {
        return "我的爸爸会飞";
    }
}
```

## 7.2 模板方法模式解决了什么问题？

 提高了代码的复用性
 模板方法已经定义了通用结构，模板方法不能确定的部分定义成抽象方法，交给子类实现，因此，使用者只需要关心自己需要实现的功能即可。

```java
package d9_abstract;

public class Test {
    public static void main(String[] args) {
        StudentMiddle s = new StudentMiddle();
        s.write();
        StudentChild s2 = new StudentChild();
        s2.write();
        // 《我的爸爸》
        //我的爸爸啥样
        //我的爸爸会飞
        //我的爸爸太好了
        // 《我的爸爸》
        //我的爸爸啥样
        //我的爸爸太牛了
        //我的爸爸太好了
    }
}
```

#  8 接口

## 8.1 接口是一种规范 规范一定是公开的

```java
package d10_interface;
//声明了一个接口
public interface Demo {
    //1.常量
    public static  final String SCHOOL_NAME= "外事";
    //2.抽象方法
    //接口是公开的，所以public static 可以不写
     void  run();
   // public  abstract  void  run();
  void  eat();
  //  public  abstract  void  eat();

}

```

## 8.2 类和接口多实现

```java
package d11_implements;

public class Test {
    public static void main(String[] args) {
        //被类实现
        PingPongMan p = new PingPongMan("张继科");
        p.run();
        p.competition();
        p.rule();
        //张继科必须跑步
        //张继科必须比赛
        //张继科必须守法
    }
}
```

```java
package d11_implements;

public interface SportMan {
    void  run();
    void  competition();
}
```

```java
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
```

```java
package d11_implements;

public class Test {
    public static void main(String[] args) {
        //被类实现
        PingPongMan p = new PingPongMan("张继科");
        p.run();
        p.competition();
        p.rule();
        //张继科必须跑步
        //张继科必须比赛
        //张继科必须守法
    }
}
```

## 8.3 接口的基本使用

接口是用来被实现的，实现接口的类型称为实现类

类和类单继承；

接口和接口多继承

```JAVA
package d12_exends;

public interface Law {
    void run();
}
```

```JAVA
package d12_exends;

public interface People {
    void eat();
}
```

```JAVA
package d12_exends;

public interface SportMan extends Law,People{
    void heh();
}
```

```java
package d12_exends;

public class Ball implements Law,People,SportMan {
    @Override
    public void run() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void heh() {

    }
}
```

## 8.4 JDK8开始接口新增方法 开发一般不用

接口不能创造对象

一个类实现多个接口，多个接口有同样的静态方法不冲突；

一个类继承了父类，同时又实现了接口，父类中的接口有同名的方法，默认用父类的

```java
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
```
