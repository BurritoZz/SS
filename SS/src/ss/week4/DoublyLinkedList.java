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
    	Node p = new Node(element);
    	int lengte = size;
    	if (getNode(index) != null)	{
    		Node q = getNode(index);
    		p.next = q;
    		q.previous = p;
        	size = lengte + 1;
    	}
    	if (getNode(index - 1) != null)	{
    		Node o = getNode(index - 1);
    		o.next = p;
    		p.previous = o;
        	size = lengte + 1;
    	}
    	if (index == 0)	{
    		p.previous = p;
    	}
    	if (index == this.size() - 1)	{
    		p.next = p;
    	}
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
    	if (getNode(index - 1) != null)	{
    		if (getNode(index + 1) != null)	{
    			Node o = getNode(index - 1);
    			Node q = getNode(index + 1);
    			o.next = q;
    			q.previous = o;
    	    	size--;
    		} else {
    			Node o = getNode(index - 1);
    			o.next = o;
    			size--;
    		}
    	} else if (getNode(index + 1) != null)	{
			Node q = getNode(index + 1);
			q.previous = q;
			size--;
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
