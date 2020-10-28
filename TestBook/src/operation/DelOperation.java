package operation;

import book.Book;
import book.BookList;
/**
 * 删除书籍
 */
public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        System.out.println("请输入您要删除的图书的名称：");
        String name = this.scanner.next();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                for (int j = i; j < currentSize-1; j++) {
                    bookList.getElum()[j] = bookList.getElum()[j+1];
                }
                bookList.setUsedSize(currentSize-1);
                break;
            }
        }
    }
}
