package operation;

import book.Book;
import book.BookList;
/**
 * 删除书籍
 */
public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书！");
        System.out.println("请输入你要删除的书籍：");
        String name = this.scanner.next();
        int currentSize = bookList.getUsedSize();
        int i = 0;
        for (; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                break;
            }
        }
        if(i == currentSize) {
            System.out.println("位置不合法！");
        }
        //i 存储的就是需要删除书籍的下标
        int pos = i;

        for (int j = pos; j < currentSize-1; j++) {
            //this.elem[i] = this.elem[i+1];
            //bookList[i] = bookList[i+1];
            Book book = bookList.getBook(i+1);
            bookList.setBook(i,book);
        }
        bookList.setBook(currentSize-1,null);//这句代码就没有了内存泄漏
        bookList.setUsedSize(currentSize-1);
        System.out.println("删除成功了！");




        /*System.out.println("删除图书");
        System.out.println("请输入您要删除的图书的名称：");
        String name = this.scanner.next();
        int currentSize = bookList.getUsedSize();
        int i = 0;
        for (; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                for (int j = i; j < currentSize-1; j++) {
                    bookList.getElum()[j] = bookList.getElum()[j+1];
//                    Book book1 = bookList.getBook(i+1);
//                    bookList.setBook(i,book1);
                }
                bookList.setUsedSize(currentSize-1);
                break;
            }
        }
        if (i == currentSize) {
            System.out.println("此书籍不存在,不能进行删除操作");
        }*/
    }
}
