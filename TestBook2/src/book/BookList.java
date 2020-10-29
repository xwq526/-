package book;

/**
 * 用来表示多本书。
 */
public class BookList {
    private Book[] elum = new Book[10];
    private int usedSize;

    //初始化就给了3本书，
    public BookList() {
        this.elum[0] =new Book("三国演义","罗贯中",12,"小说");
        this.elum[1] =new Book("西游记","吴承恩",32,"小说");
        this.elum[2] =new Book("java编程思想","小青",88,"学习");
        this.usedSize = 3;
    }
    //尾插           这里直接就是尾插了，简单一点，后期还可以优化
    public void setBook(int pos,Book book) {
        this.elum[pos] = book;
    }

    public Book getBook(int pos) {
        return this.elum[pos];
    }



    public Book[] getElum() {
        return elum;
    }

    public void setElum(Book[] elum) {
        this.elum = elum;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
