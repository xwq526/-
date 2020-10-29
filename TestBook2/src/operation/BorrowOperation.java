package operation;

import book.Book;
import book.BookList;

/**
 * 借阅书籍
 */
public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        System.out.println("请输入图书的名称：");
        String name = this.scanner.next();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                book.setBorrowed(true);
                break;
            }
        }
    }
}
