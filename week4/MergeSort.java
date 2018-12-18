package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<E> {
	
	List<E> list;
	
    public static <E extends Comparable<E>> void mergesort(List<E> list) {
    	
    	ArrayList<E> a = null;
    	ArrayList<E> b = null;
    	
    	int first;
    	int second;

    	if (list.size() <= 1) {
    		return;
    	}
    	
    	first = list.size() / 2;
    	second = list.size() - first;
    		
	    //setup lists
    	a = new ArrayList<E>(first);
	    b = new ArrayList<E>(second);
	    	
	    //split lists
	    for (int i = 0; i < first; i++) {
	    	a.add(list.get(i));
	    }
	    	
	    for (int j = a.size(); j < list.size(); j++) {
	    	b.add(list.get(j));
	    }
	    	
	    System.out.println("a: " + a);
	    System.out.println("b: " + b);
	    		
    	mergesort(a);
    	mergesort(b);
    	
    	list.clear();
    	
    	while (a.size() > 0 && b.size() > 0) {
    		if (a.get(0).compareTo(b.get(0)) == 1) {
    	    	list.add(b.get(0));
    	    	b.remove(0);
    	    } else {
    	    	list.add(a.get(0));
    	    	a.remove(0);
    	    }
    		if (b.size() == 0) {
    			list.addAll(a);
    		} else if (a.size() == 0) {
    			list.addAll(b);	
    		}
    		
    	}
    		
	    
	    System.out.println("List: " + list);
    }
   

    public static void main(String[] args) {
    	ArrayList a = new ArrayList(5);
    	a.add(4);
    	a.add(2);
    	a.add(1);
    	a.add(3);
    	a.add(6);
    	a.add(5);
    	System.out.println(a);
    	mergesort(a);
    	
    }
}
