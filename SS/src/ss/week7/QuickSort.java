package ss.week7;


public class QuickSort extends Thread {
	private int[] a;
	private int first;
	private int last;

	public QuickSort(int[] a, int first, int last)	{
		this.a = a;
		this.first = first;
		this.last = last;
	}
	public QuickSort(int[] a)	{
		this.a = a;
		this.first = 0;
		this.last = a.length - 1;
	}
    public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }
    public static void qsort(int[] a, int first, int last) {
        if (first < last) {
            int position = partition(a, first, last);
            Thread een = new QuickSort(a, first, position - 1);
            Thread twee = new QuickSort(a, position + 1, last);
            een.start();
            twee.start();
        }
    }
    public static int partition(int[] a, int first, int last) {
    	int mid = (first + last) / 2;
        int pivot = a[mid];
        swap(a, mid, last); // put pivot at the end of the array
        int pi = first;
        int i = first;
        while (i != last) {
            if (a[i] < pivot) {
                swap(a, pi, i);
                pi++;
            }
            i++;
        }
        swap(a, pi, last); // put pivot in its place "in the middle"
        return pi;
    }
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public void run()	{
    	qsort(a, first, last);
    }
}
