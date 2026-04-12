package throwable.yi_chang_chu_li;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * 异常处理
 * 方法1：try - catch - finally（抓抛模型）
 *       过程1：“抛”
 *                  自动抛
 *                      程序运行时，如果发生了异常，会创建一个异常对象，把异常对象抛出
 *                      一旦抛出异常，此程序后续的代码，将不再执行
 *                  手动抛
 *                      在实际工作中不符合逻辑的异常，应该在方法中手动抛出
 *                      throw new Exception("异常信息");
 *                      但执行throw后，会自动抛出异常对象，并结束方法调用，后面的代码不会运行
 *       过程2：“抓”
 *               针对抛出的异常，进行预处理。此捕获处理，被称为抓
 *               一旦将异常进行处理，代码将继续执行
 *
 * 方法2：throws + 异常类型（向上抛出异常，但也需要有try-catch处理）
 *      格式：     在方法声明时，使用"throws 异常类型1, 异常类型2, ..."
 *                  public void show() throws 异常类型1, 异常类型2, ...{
 *                          //可能存在的编译时异常
 *                  }
 *
 *
 *      基本结构：
 *      try{
 *              ...//可能会产生异常的代码
 *      }
 *      catch(异常类型1 变量名){
 *              ...//当产生异常类型1型的异常时，执行此代码
 *      }
 *      catch(异常类型2 变量名){
 *             ...//当产生异常类型2型的异常时，执行此代码
 *      }
 *      finally{
 *              ...//无论抛出异常与否，都会执行此代码
 *      }
 *
 *      catch：
 *      在catch有多个异常类型时，有顺序要求，从上到下，子类异常类型要写在父类异常类型之前
 *      catch中异常处理的方式：
 *      1.自己编写代码
 *      2.printStackTrace(),打印异常的详细信息（推荐）
 *      3.getMessage(),打印异常发生的原因
 *
 *      finally
 *      finally块中的代码，会无论是否产生异常，都会执行
 *      在三个块中，finally中的代码优先级最高
 *
 * 在实际工作中如何选择
 * 1. 代码有一定要被执行时，使用try-catch-finally处理异常
 * 2. 重写：父类没有throws，子类必须try-catch处理异常
 * 3. 开发中，a，b，c方法依次调用，通常用throws处理异常
 * */

public class _01 {
    //运行时异常
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            System.out.println(num);
        } catch (java.util.InputMismatchException e) {
            e.printStackTrace();
        }
        System.out.println("程序继续执行");
    }

    @Test
    public void test1() {
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("程序继续执行");
    }

    //编译时异常
    @Test
    public void test2() {
        try {
            File file = new File("D:\\code\\HelloWorld.java");
            FileInputStream fis = new FileInputStream(file);//代码作用：创建输入流对象
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println("程序继续执行");
    }

    @Test
    public void test3() {
        int num = method1(10);
        System.out.println(num);
    }

    public static int method1(int num) {
        try {
            return num;
        } catch (NumberFormatException e) {
            return num--;
        } finally {
            System.out.println("teat结束");
            return ++num;
        }
    }

    //方法2：throws + 异常类型
    @Test
    public void test4() {
        try {
            method2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void method2() throws FileNotFoundException {
        File file = new File("D:\\code\\HelloWorld.java");
        FileInputStream fis = new FileInputStream(file);//代码作用：创建输入流对象
    }

    //解释为什么必须"子类方法中抛出的异常类型是父类方法中抛出的异常类型的子类"(多态性）
    // 解释：基于多态性，当使用父类引用指向子类对象时（Father father = new Son()），
    // 编译器只关心父类声明的异常类型（IOException）。如果子类方法抛出了父类未声明的更宽泛的异常（父类），
    // 那么调用者按照父类标准编写的 catch 块将无法捕获该异常，导致编译错误或运行时风险。
    // 因此，子类抛出的异常必须是父类异常的子类或相同类型，以确保“里氏替换原则”成立，保证代码的安全性。
    //编译器认为异常为IOException，但实抛出的异常为FileNotFoundException
    @Test
    public void test5() {
        Father father = new Son();
        try {
            father.method1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//子类方法中的抛出异常类型要和父类方法一致或者，子类方法中抛出的异常类型是父类方法中抛出的异常类型的子类，不能是父类
class Father {
    public void method1() throws IOException {
        File file = new File("D:\\code\\HelloWorld.java");
    }
}

class Son extends Father {
    @Override
    public void method1() throws FileNotFoundException {
        File file = new File("D:\\code\\HelloWorld.java");
        FileInputStream fis = new FileInputStream(file);
    }
}

