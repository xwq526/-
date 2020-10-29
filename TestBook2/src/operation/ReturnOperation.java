package operation;

import book.Book;
import book.BookList;

/**
 * 归还书籍
 */
public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        System.out.println("请输入图书的名称：");
        String name= this.scanner.next();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                book.setBorrowed(false);
                break;
            }
        }
    }
}
