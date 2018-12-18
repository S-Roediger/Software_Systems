package ss.week4;

public class Exercises {
	
    public static int countNegativeNumbers(int[] arr) {
    	int neg = 0;
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] < 0) {
    			neg ++;
    		}
    	}
    	return neg;
    }

    public static void reverseArray(int[] ints) {
    	int x = 0;
    	int y = ints.length-1;
    	while (x < y) {
    		int temp = ints[x];
    		ints[x] = ints[y];
    		ints[y] = temp;
    		x++;
    		y--;
    	}
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
