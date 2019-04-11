package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<Item> implements Stack<Item>
{
    private Item[] a ;  // stack entries
    private int N = 0;  // size

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap)
    {
        a = (Item[]) new Object[cap];
    }

    @Override
    public boolean isEmpty() { return N == 0; }

    @Override
    public int size() { return N; }

    @Override
    public void push(Item item)
    {
        a[N++] = item;
    }

    @Override
    public Item pop()
    {
        return a[--N];
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new Iterator<Item>()
        {
            private int id = N;

            public boolean hasNext() { return id != 0; }

            public Item next()
            {
                if (!hasNext()) throw new NoSuchElementException();
                return a[--id];
            }
        };
    }

    public static void main(String[] args)
    {
        Stack<String> strs = new FixedCapacityStack<>(10);
        strs.push("hello");
        strs.push("world");

        System.out.println(strs.size());

        // for (String str: strs) {
        //     System.out.println(str);
        // }

    }
}