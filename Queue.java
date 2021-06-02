//Thomas Kestler CS310
import java.util.*;
public class Queue//uses generics, can remove the <T> if needed
{

private ArrayList<Integer> alqueue;

public Queue()
{
   this.alqueue = new ArrayList<Integer>();
}

public void loadValue(int a)//enqueue, add item to queue
{
   this.alqueue.add(a);
}

public int nextValue()//dequeue, remove item from queue
{
   if (this.alqueue.isEmpty())
      return -1;
   else
      return this.alqueue.remove(0);
}

public int size() //return length/size of queue
{
   return this.alqueue.size();
}

public boolean isEmpty()//return true if the queue has no items
{
   return this.alqueue.isEmpty();
}

void normalize() {//subtract the first item in the queue from all the other items
	int first = alqueue.get(0);
	for(int i=1;i<alqueue.size();i++) {
		alqueue.set(1,alqueue.get(1)-first);
	}
}

int[] peek(int num) {//return an array of the next values in the queue
	int[] arr = new int[num];
	for(int i=0;i<num;i++) {
		arr[i] = alqueue.get(i);
	}
	return arr;
}


}