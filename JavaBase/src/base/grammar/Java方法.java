package base.grammar;

public class Java方法 {

    public static void main(String args[]){
        for(int i=0; i<args.length; i++){
            System.out.println("args[" + i + "]: " + args[i]);
        }
    }
}


// 一个简单的构造函数
class MyClass {
    int x;

    // 以下是构造函数
    MyClass() {
        x = 10;
    }
}

/**
 * finalize() 方法
 *
 * Java 允许定义这样的方法，它在对象被垃圾收集器析构(回收)之前调用，这个方法叫做 finalize( )，它用来清除回收对象。
 *
 * 例如，你可以使用 finalize() 来确保一个对象打开的文件被关闭了。
 *
 * 在 finalize() 方法里，你必须指定在对象销毁时候要执行的操作。
 * */

