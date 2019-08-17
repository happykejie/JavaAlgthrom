package base.JavaOO;

public class JavaExtended {

    public  static void  main(String[] args)
    {
        System.out.println("test");
    }
}


// class Animal {
//    private String name;
//    private int id;
//    public Animal(String myName, int myid) {
//        name = myName;
//        id = myid;
//    }
//    public void eat(){
//        System.out.println(name+"正在吃");
//    }
//    public void sleep(){
//        System.out.println(name+"正在睡");
//    }
//    public void introduction() {
//        System.out.println("大家好！我是"         + id + "号" + name + ".");
//    }
//}
//
//
// class Penguin extends Animal {
//    public Penguin(String myName, int myid) {
//        super(myName, myid);
//    }
//}

/**
 *
 implements关键字

 使用 implements 关键字可以变相的使java具有多继承的特性，使用范围为类继承接口的情况，可以同时继承多个接口（接口跟接口之间采用逗号分隔）。

 * */


 interface A {
    public void eat();
    public void sleep();
}

 interface B {
    public void show();
}

class C implements A,B {
    @Override
    public void eat() {

    }

    @Override
    public void show() {

    }

    @Override
    public void sleep() {

    }
}



class Animal {
    void eat() {
        System.out.println("animal : eat");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("dog : eat");
    }
    void eatTest() {
        this.eat();   // this 调用自己的方法
        super.eat();  // super 调用父类方法
    }
}

 class Test {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.eat();
        Dog d = new Dog();
        d.eatTest();
    }
}

// final关键字
//
//final 关键字声明类可以把类定义为不能继承的，即最终类；或者用于修饰方法，该方法不能被子类重写


/**
 * 构造器
 *
 * 子类是不继承父类的构造器（构造方法或者构造函数）的，它只是调用（隐式或显式）。如果父类的构造器带有参数，
 * 则必须在子类的构造器中显式地通过 super 关键字调用父类的构造器并配以适当的参数列表。
 *
 * 如果父类构造器没有参数，则在子类的构造器中不需要使用 super 关键字调用父类构造器，系统会自动调用父类的无参构造器
 * */

class SuperClass {
    private int n;
    SuperClass(){
        System.out.println("SuperClass()");
    }
    SuperClass(int n) {
        System.out.println("SuperClass(int n)");
        this.n = n;
    }
}
// SubClass 类继承
class SubClass extends SuperClass{
    private int n;

    SubClass(){ // 自动调用父类的无参数构造器
        System.out.println("SubClass");
    }

    public SubClass(int n){
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass(int n):"+n);
        this.n = n;
    }
}
// SubClass2 类继承
class SubClass2 extends SuperClass{
    private int n;

    SubClass2(){
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass2");
    }

    public SubClass2(int n){ // 自动调用父类的无参数构造器
        System.out.println("SubClass2(int n):"+n);
        this.n = n;
    }
}
 class TestSuperSub{
    public static void main (String args[]){
        System.out.println("------SubClass 类继承------");
        SubClass sc1 = new SubClass();
        SubClass sc2 = new SubClass(100);
        System.out.println("------SubClass2 类继承------");
        SubClass2 sc3 = new SubClass2();
        SubClass2 sc4 = new SubClass2(200);
    }
}




