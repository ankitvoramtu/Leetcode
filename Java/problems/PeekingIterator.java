package problems;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
 private Iterator<Integer> it;
 private Integer next = null;

	public PeekingIterator(Iterator<Integer> iterator) {
	    it = iterator;
	    if (it.hasNext()) {
	        next = it.next();
	    }
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    return next;
     
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ret = next;
	    if (it.hasNext()) {
	        next = it.next();
	    }
	    else {
	        next = null;
	    }
	    return ret;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	    
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}