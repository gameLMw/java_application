package throwable.yi_chang_chu_li;

/*
 * 使用throw手动抛出异常
 * 在实际工作中不符合逻辑的异常，应该手动抛出
 * */

public class _02 {
    public static void main(String[] args) {
        Student student = new Student();
        try {
            student.regist(-10);
            System.out.println(student.id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println("程序继续执行");
    }
}


class Student {
    int id;

    public void regist(int id) {
        if (id > 0) {
            this.id = id;
        } else {
//            throw new RuntimeException("id不合法");
            //手动抛出异常
            //编译时异常
            throw new RuntimeException("id不合法");
        }
        System.out.println("注册成功");
    }
}