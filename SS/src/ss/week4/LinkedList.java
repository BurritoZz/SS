package ss.week4;

public class LinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node first;

    // ensures \result.size == 0;
    public LinkedList() {
        size = 0;
        first = null;
    }

    public void add(int index, Element element) {
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node p = getNode(index - 1);
            newNode.next = p.next;
            p.next = newNode;
        }
        size = size + 1;
    }
// o = de vOrige; p/r = PRecies de goede; q = de volQende.
    //@ ensures this.size == \old(size) - 1;
    public void remove(Element element) {
    	Node o = findBefore(element);
        if (o != null)	{
        	Node q = o.next.next;
        	if (q.equals(o) || q.equals(o.next) || q == null)	{
            	o.next = o;
        	} else {
        		o.next = q;
        	}
        	size--;
        } else if (get(0).equals(element))	{
        	Node p = getNode(0);
        	Node q = getNode(1);
        	first = q;
        	p.next = null;
        	size--;
        }
    }

    public Node findBefore(Element element) {
    	int r = -1;
        for (int i = 0; i < size && r == -1; i++)	{
        	if (element.equals(get(i)))	{
        		r = i;
        	}
        }
        if (r > 0)	{
        	return getNode(r - 1);
        }
        return null;
    }

    //@ requires 0 <= index && index < this.size();
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    //@ requires 0 <= i && i < this.size();
    private /*@ pure @*/ Node getNode(int i) {
        Node p = first;
        int pos = 0;
        while (pos != i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    //@ ensures \result >= 0;
    public /*@ pure @*/ int size() {
        return size;
    }

    public class Node {
        private Element element;
        public Node next;

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }

        public Element getElement() {
            return element;
        }
    }
}
