package bca.util2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BCAMinPQ<E extends Comparable<E>> implements BCAQueue<E> {

  /*Stores items in heap starting at index 1*/
  private ArrayList<E> heap = new ArrayList<>();
  /*Number of items in the heap.*/

  public BCAMinPQ() {
    /* dummy element in index 0, making actual elements start at index 1 */
    heap.add(null);
  }

  /**
   * Return index of the left child of element at index i.
   */
  private int leftChildOf(int i){
    return i*2;
  }

  /**
   * Return index of the right child of element at index i.
   */
  private int rightChildOf(int i){
    return i*2 + 1;
  }

  /**
   * Return index of the parent of element at index i.
   */
  private int parentOf(int i){
    return i/2;
  }

  /**
   * Swap the elements at indexes i1 and i2.
   */
  private void swap(int i1, int i2){
    E temp = heap.get(i1);
    heap.set(i1, heap.get(i2));
    heap.set(i2, temp);
  }

  /**
   * Push up the element at index i (swapping with bigger parent)
   * until it is at the appropriate level. (parent is smaller)
   * This will fix the heap property if the element of index i
   * is the only element out of place.
   */
  private void pushUp(int i) {
    while (i > 1) {

      if (heap.get(parentOf(i)).compareTo(heap.get(i)) < 0)
        break;

      /* TODO Push element at i up!*/
      swap(parentOf(i), i);
      i /= 2;

    }
  }

  /** Adds a new element to the the queue. */
  public void enqueue(E o){
    /* TODO Add new element to heap, maintaining both shape and heap properties*/
    heap.add(o);
    pushUp(heap.size()-1);
  }

  /* Try BCAMinPQTest now! You should pass 0.1 to 0.6*/


  /**
   * Returns the next item from the queue without popping it.
   * If no item, returns null
   */
  public E peek(){
    /* TODO Return minimum element of heap*/
    E e = null;
    e = heap.size() > 0 ? heap.get(1) : null;
    return e;
  }

  /* Try BCAMinPQTest now! You should pass 1a*/

  /**
   * Push down the element at index i (swapping with its smallest child)
   * until it is at the appropriate level. (children are both bigger)
   * This will fix the heap property if the element of index i
   * is the only element out of place.
   */
  private void pushDown(int i) {
    while (i*2 < heap.size()) {
      /* TODO pick the smaller child (there might only be one!) */
      int i2;
      if ((i*2)+1 >= heap.size()) {
        i2 = i*2;
      }
      else {
        i2 = heap.get(i*2).compareTo(heap.get((i*2)+1)) < 0 ? i*2 : (i*2)+1;
      }
      if (heap.get(i).compareTo(heap.get(i2)) < 0)
        break;

      swap(i, i2);
      i = i2;
    }
  }

  /**
   * Removes the smallest item from the queue and returns it.
   *
   * @exception NoSuchElementException
   *                if the queue is empty.
   */
  public E dequeue(){

    if (isEmpty())
      throw new NoSuchElementException("MinPQ is empty");

    /* TODO Remove minimum element in heap, maintaining both shape and heap properties*/
    /* HINT: Swap minimum element and last element FIRST! */
    E temp = heap.get(1);
    swap(1, heap.size()-1);
    heap.remove(heap.size()-1);
    pushDown(1);

    return temp;
  }

  /* Try BCAMinPQTest now! You should pass the remaining tests 1b through 8, and HeapSort*/

  /**
   * Returns whether the queue is empty or not.
   */
  public boolean isEmpty(){
    return size() == 0;
  }

  /**
   * Returns the number of items currently in the queue.
   */
  public int size() {
    return heap.size()-1;  // The arraylist has an extra element at position 0, hence the subtraction of 1.
  }

  /**
   * Return item at index i
   */
  public E get(int i) {
    return heap.get(i);
  }
}
