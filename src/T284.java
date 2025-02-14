import java.util.Iterator;

/**
 * @author ZhangYihe
 * @since 2025/2/13
 **/
public class T284 {
}

class PeekingIterator implements Iterator<Integer> {
    int nextNum;
    Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.

        nextNum= iterator.hasNext()?iterator.next():0;
        this.iterator=iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextNum;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int n=nextNum;
        if(iterator.hasNext()){
            nextNum= iterator.next();
        }else{
            nextNum=0;
        }

        return n;
    }

    @Override
    public boolean hasNext() {
        return nextNum!=0;
    }
}