package operation;

import book.Book;
import book.BookList;

/**
 * 增加书籍
 */
public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("添加图书");
        System.out.println("请输入书名：");
        String name = this.scanner.next();
        System.out.println("请输入作者：");
        String author = this.scanner.next();
        System.out.println("请输入价格：");
        int price = scanner.nextInt();
        System.out.println("请输入类型：");
        String type = scanner.next();

        Book book = new Book(name,author,price,type);
        int currentSize = bookList.getUsedSize();
        bookList.setBook(currentSize,book);
        bookList.setUsedSize(currentSize+1);
    }

}
