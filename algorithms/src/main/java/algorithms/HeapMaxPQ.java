package algorithms;


public class HeapMaxPQ<E extends Comparable<? super E>> implements MaxPQ<E>
{
    private E[] array;  // binary heap
    private int N = 1;  // size + 1

    @SuppressWarnings("unchecked")
    public HeapMaxPQ(int capacity)
    {
        array = (E[]) new Comparable[capacity + 1];
    }

    @Override
    public E max() { return array[1]; }

    @Override
    public E delMax()
    {
        E maximum = array[1];

        swap(1, N);
        array[N] = null;    // avoid loitering
        N--;
        sink(1);

        return maximum;
    }

    @Override
    public void insert(E elem)
    {
        array[++N] = elem;
        swim(N);
    }

    private void swim(int i)
    {
        while (i > 1 && less(i/2, i)) {
            swap(i, i/2);
            i /= 2;
        }
    }

    private void sink(int i)
    {
        while (2*i <= N) {
            int j = 2 * i;  // left child of i
            if (j < N && less(j, j+1)) j++;  // find the larger child
            if (less(j, i)) break;
            swap(i, j);
            i = j;
        }
    }

    private void swap(int i, int j)
    {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean less(int i, int j)
    {
        return array[i].compareTo(array[j]) < 0;
    }

    @Override
    public boolean isEmpty() { return N == 1; }

    @Override
    public int size() { return N - 1; }
}