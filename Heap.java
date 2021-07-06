package edu.cpp.cs.cs241.prog_assgmnt_1;

public interface Heap<V extends Comparable<V>>
{

    public void add(V value);

    public V[] toArray();

    public V remove();

    public void fromArray(V[] array);

    public V[] getSortedContents();
}
