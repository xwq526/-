import book.BookList;
import operation.IOperation;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static User login() {//返回值是父类类型User，发生了向上转型
        System.out.println("请输入你的名字:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入你的身份，1是管理员，0是普通用户");
        int choice = scanner.nextInt();
        if (choice == 1) {//发生了向上转型
            return new Admin(name);
        }else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();//向上转型
        //这里需要发生动态绑定，才能知道调用的是Admin还是NormalUser的菜单方法。
        while (true){
            int choice = user.menu();//menu方法的返回值是一个int
            IOperation iOperation = user.doOperation(choice);
            iOperation.work(bookList);
        }

    }
}
