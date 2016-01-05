package ss.week7;

public class IntCell {
    private int contents = 0;

    public void add(int amount) {
        contents = contents + amount;
    }
    public int get() {
        return contents;
    }

    public static void main(String[] args) {
        IntCell cell = new IntCell();
        Adder a1 = new Adder(cell, 1);
        Adder a2 = new Adder(cell, 2);
        a1.start();
        a2.start();
        try {
            a1.join();
            a2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cell.get());
    }
}

class Adder extends Thread {
    private IntCell cell;
    private int amount;

    public Adder(IntCell cellArg, int amountArg) {
        this.cell = cellArg;
        this.amount = amountArg;
    }
    public void run() {
        cell.add(amount);
    }
}
