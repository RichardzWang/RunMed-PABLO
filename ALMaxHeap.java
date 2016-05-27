//  Team Pablo: Jack Schluger, Manish Saha, Richard Wang
//  APCS1 pd05
//  HW46 -- Running M[edi]an
//  2016-05-25
import java.util.ArrayList;

public class ALMaxHeap {
    
    private ArrayList<Integer> _heap;

    public ALMaxHeap() {
	_heap = new ArrayList<Integer>();
    }

    public String toString() {
	String s = "";
	for ( Integer i : _heap) {
	    if (i != null)
		s+= i + " ";
	}
	return s;
    }

    public boolean isEmpty() {
	return _heap.isEmpty();
    }

    public Integer peekMax() {
	return _heap.get(0);
    }

    public void add( Integer addVal ) {
	_heap.add( addVal );
	int i = _heap.size() - 1;
	while ( i >= 0 ) {
	    if (addVal > _heap.get((i-1)/2)) {
		swap(i,(i-1)/2);
	    }
	    else {
		break;
	    }
	    i = (i-1)/2;
	}
    }

    public Integer removeMax() {
	if (isEmpty())
	    return null;

	swap(_heap.size()-1,0);

	Integer ret = _heap.remove(_heap.size()-1);

	int i = 0;

	while ( i < _heap.size() ) {

	    int j = maxChildPos(i);
		    
	    if (i == -1 || j == -1) {
		break;
	    }



	    if ( _heap.get(i) < _heap.get(j) )
	    
		swap(i,j);

	    else

		break;

		 

	    i = j;

	}

	return ret;
    }

    private int maxChildPos( int pos ) {
	if (pos * 2 + 1 > _heap.size() - 1)
	    return -1;
	else if (pos * 2 + 2 > _heap.size() - 1)
	    return pos * 2 + 1;
	else
	    return maxOfR(pos * 2 + 1, pos * 2 + 2);
    }

    private int maxOfR (int i, int j) {
	if (_heap.get(i) > _heap.get(j)) {
	    return i;
	}
	else {
	    return j;
	}
    }
	
	
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }

    //main method for testing
    public static void main( String[] args ) {


	ALMaxHeap pile = new ALMaxHeap();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);
	  

	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  


	  /*--V--------------MOVE ME DOWN------------------V---
	  ==|============================================|===*/

    }//end main()
    
}
