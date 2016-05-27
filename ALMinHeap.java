/*
  Team Pablo: Jack Schluger, Manish Saha, Richard Wang
  APCS1 pd05
  HW46 -- Running M[edi]an
  2016-05-25
*/

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALMinHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALMinHeap() 
    { 
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    {
	String s = "";
	for ( Integer bluh : _heap)
	    if (bluh == null) s+= ".\t";
	    else s += bluh.toString() + "\t";
	return s;
	
    }//O(n)

    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    { 
	return _heap.isEmpty(); 
    } //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    {
	return _heap.get( 0 );
    } //O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) 
    { 
	_heap.add(  addVal );
	int i =  _heap.size() - 1;
	while ( i > 0 && _heap.get( (i - 1) / 2) > addVal) {
	    swap(i, (i - 1) / 2);
	    i = (i - 1) / 2;
	}
    } //O(logn)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() 
    {
	if (isEmpty()) return null;
	
	swap( _heap.size() - 1, 0);
	Integer tmp = _heap.remove( _heap.size() - 1 );

	int i = 0;
	int j = 0;
	while ( i < _heap.size() &&  minChildPos(i) > 0 && _heap.get(i) > _heap.get(minChildPos(i) ) )
	    {
		j = minChildPos( i );
		swap( i, j );
		i = j;
	    }
	return tmp;
    }//O(logn)

    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) 
    {
	if ( pos * 2 + 2 == _heap.size() && _heap.get(pos*2 + 1) != null )
	    return pos * 2 + 1;
	if ( pos*2 + 2 >= _heap.size() ||
	     ( _heap.get(pos*2 + 1) == null &&
	       _heap.get(pos*2 + 2) == null) ) return -1;
	else if ( minOf( _heap.get(pos*2 + 1), _heap.get(pos*2 + 2) ).equals(_heap.get(pos*2 + 2)) )
	    return pos*2 + 2;
	else return pos*2 + 1;
	
    }//O(1)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a!= null && b!= null && a.compareTo(b) < 0 )
	    return a;
	else if (b == null) return a;
	else return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {


	ALMinHeap pile = new ALMinHeap();

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
	  

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  


	  /*--V--------------MOVE ME DOWN------------------V---
	  ==|============================================|===*/

    }//end main()

}//end class ALHeap
