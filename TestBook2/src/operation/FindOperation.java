package operation;
import book.Book;
import book.BookList;
/**
 * 查阅书籍
 */
public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        String name = this.scanner.next();
        int currentSize = bookList.getUsedSize();
        int i = 0;
        for (; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                System.out.println(book);
                break;
            }
        }
        if(i == currentSize) {
            System.out.println("您要找的书籍不存在！！");
        }
    }
}
