package throwable.gai_lun;

/*
 * 异常：指的是程序在执行过程中，出现的非正常情况，如果不处理最终会导致JVM的非正常退出
 *
 * Java中把不同异常用不同的类表示
 *
 * Throwable：所有异常的超类
 *
 * //Throwable的两大子类
 * //错误
 * java.lang.Error：JVM虚拟机无法解决的错误，不编写代码处理，比如StackOverflowError（栈溢出）和OutOfMemoryError（堆内存溢出）
 *
 * //异常
 * java.lang.Exception：因外部环境原，可以处理也可以不处理，如果不处理，默认处理就是抛出异常
 *
 * 编译时异常（checked异常，受检异常）：在编译时检测到的异常，必须处理，否则编译不通过
 * 运行时异常（runtime异常,unchecked异常，非受检异常）：在运行时检测到的异常，可以不处理，也可以处理，如果不处理，默认处理就是抛出异常
 * */

import org.junit.jupiter.api.Test;

public class _01 {
    public static void main(String[] args) {
        //StackOverflowError
        main(args);
    }


    //运行时异常
    //ArrayIndexOutOfBoundsException
    //数组越界异常
    @Test
    public void test1() {
        int[] arr = new int[10];
        System.out.println(arr[10]);
    }

    //NullPointerException
    //空指针异常
    @Test
    public void test2() {
        String str = null;
        System.out.println(str.charAt(0));
    }

    //InputMismatchException
    //输入不匹配异常
    @Test   //@Test默认只能输出
    public void test3() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(num);
    }

    //ClassCastException
    //类型转换异常
    //NumberFormatException
    //数字格式化异常
    //ArithmeticException
    //数学异常


    //编译时异常
    //ClassNotFoundException
    //类未找到异常
    //FileNotFoundException
    //文件未找到异常
    // IOException
    //IO异常

}

