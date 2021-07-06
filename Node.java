package edu.cpp.cs.cs241.prog_assgmnt_1;



public class Node<V extends Comparable<V>>
{
    private Node<V> leftChild;
    
    private Node<V> rightChild;
 
    private Node<V> parent;
    
    private V data;
    public Node(Node<V> left, Node<V> right, Node<V> parent, V data)
    {
        leftChild = left;
        rightChild = right;
        this.parent = parent;
        this.data = data;
    }

    public void setLeftChild(Node<V> n)
    {
        leftChild = n;
    }
    public Node<V> getLeftChild()
    {
        return leftChild;
    }
    
    public void setRightChild(Node<V> n)
    {
        rightChild = n;
    }
     public Node<V> getRightChild()
    {
        return rightChild;
    }
    
    
    public Node<V> getParent()
    {
        return parent;
    }
    public void setParent(Node<V> n)
    {
        parent = n;
    }
    
    public V getData()
    {
        return data;
    }
    public void setData(V data)
    {
        this.data = data;
    }
    
 }