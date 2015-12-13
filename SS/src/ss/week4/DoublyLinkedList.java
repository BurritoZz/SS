package ss.week4;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, Element element) {
    	Node q = new Node(element);
    	if (getNode(index) != null) {
    		Node n = getNode(index);
    		n.previous = q;
    		q.next = n;
    	}
    	if (getNode(index - 1) != null) {
    		Node p = getNode(index - 1);
    		p.next = q;
    		q.previous = p;
    	}
    	size++;
    	
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
    	if (getNode(index) != null) {
    		if (getNode(index - 1) != null) {
    			Node p = getNode(index - 1);
    			if (getNode(index + 1) != null) {
    				Node n = getNode(index + 1);
    				n.previous = p;
    				p.next = n;
    				size--;
    				return;
    			}
    			p.next = null;
    			size--;
    		} else if (getNode(index + 1) != null) {
    			Node n = getNode(index + 1);
    			n.previous = null;
    			size--;
    		}
    	}
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
