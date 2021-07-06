package edu.cpp.cs.cs241.prog_assgmnt_1;
import java.lang.reflect.Array;
public class NodeHeap<V extends Comparable<V>> implements Heap<V> 
{
    private int size;
    private Node<V> root;
    private Node<V> lastNode;

    public NodeHeap()
    {
        root = null;
        lastNode = root;
        size = 0;
    }

    public void add(V value)
    {
        Node<V> node = new Node<>(null,null,null,value);
        //System.out.println(value);

        if (size == 0)
        {
            root = node;
            lastNode = root;
            size++; 
        }
        else 
        {
            size++;
            Node<V> n = root;
            String path = Integer.toBinaryString(size);
            path = path.substring(1, path.length());

            System.out.println(path + "for" + value);
            for(int i = 0; i < path.length()-1; i++)
            {
                if(path.charAt(i) == '1')
                {
                   n = n.getRightChild();
                }
                else
                {
                    n = n.getLeftChild();
                }
            }
            if(path.charAt(path.length()-1) == '1')
            {
                
                n.setRightChild(node);
            }
            if(path.charAt(path.length()-1) == '0')
            {
                
                n.setLeftChild(node);
            }
            node.setParent(n);
            shiftUp(node);
            lastNode = node;
        }
        
            System.out.println("The root node's value is : " + root.getData());
    }

    public void shiftUp(Node<V> n) 
    {

        while( !n.equals(root))
        {
            if( n.getData().compareTo(n.getParent().getData()) > 0) 
            {
                swapValues(n, n.getParent());
                n = n.getParent();
            } 
        } 
    }

    public void swapValues(Node<V> n1, Node<V> n2)
    {
        V temp = n1.getData();
        n1.setData(n2.getData());
        n2.setData(temp);
    }

    public V remove()
    {
        V result = null;
        if (size == 1)
        {
            result = root.getData();
            root = null;
            lastNode = null;
            size--; 
        }
        if( size > 1 )
        {
            result = root.getData();
            root.setData(lastNode.getData());
            String path = Integer.toBinaryString(size);
            path = path.substring(1, path.length());
            Node<V>  n = root;
            for(int i = 0; i < path.length()-1; i++)
            {
                if(path.charAt(i) == '1')
                    n = n.getRightChild();
                else
                    n = n.getLeftChild();
                if(path.charAt(path.length()-1) == '1')
                {
                    n.setRightChild(null);
                }
                if(path.charAt(path.length()-1) == '0')
                {
                    n.setLeftChild(null);
                }
                shiftDown(root);
            }
            size--; 
        }
        System.out.println(result);
        return result;
    }

    public void shiftDown(Node<V> value)
    {
        Node<V> val = value;
        Node<V> swapNode;
        boolean swapped = true;   

        while(swapped)
        {
            //swapNode = ( val.getRightChild().getData().compareTo(val.getLeftChild().getData()) > 0  ) ? val.getRightChild() : val.getLeftChild();
            if(val.getRightChild().getData().compareTo(val.getLeftChild().getData() )>0)
            {
                swapNode = val.getRightChild();
            }
            else
            {
                swapNode = val.getLeftChild();
            }
            if( (swapNode.getData().compareTo(val.getParent().getData()) > 0)   && swapNode != null)
            {
                swapValues(swapNode, val);
                val = swapNode;
            }
            else
            {
                swapped = false;
            }

        }

    }

    public V[] toArray()
    {
        V[] array = (V[]) Array.newInstance(root.getData().getClass(),size);
        array[0] = root.getData();
        System.out.println("the value is" + root.getData());
        for(int i = 1; i < size; i++)
        {
            Node<V> nodeAtPos = root;
            String path = Integer.toBinaryString(i+1);
            path = path.substring(1, path.length());
            System.out.println("The value for the path for the " +(i+1)+ "th node is" + "is " + path);
            for(int ii = 0; ii < path.length(); ii++)
            {
                if(path.charAt(ii) == '0')
                    nodeAtPos = nodeAtPos.getLeftChild();
                if(path.charAt(ii) == '1')
                    nodeAtPos = nodeAtPos.getRightChild();
                System.out.println("The node at " + i + "is" + nodeAtPos.getData());
            }
            array[i] = nodeAtPos.getData();
        }
        for(int i = 0; i< array.length; i++)
        {
            System.out.println(array[i]);
        }
        return (V[])array;

    }

    public void fromArray(V[] array)
    {
        root = null;
        add(array[0]);
        for(int i = 1; i < array.length; i++)
        {
            add(array[i]);
        }
    }

    public V[] getSortedContents()//Why is this array here?
    {
        V[] arr = toArray();
        int rounds = size-1;
        for(int i = 0; i< arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        while (rounds > 0)
        {
            V temp = arr[0];
            arr[0] = arr[rounds];
            arr[rounds] = temp;
            rounds--;
            shiftDown(arr, rounds);
        }
        for(int i = 0; i< arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        return arr;
    }

    public void shiftDown(V[] array, int end)
    {
        V leftChild = null;
        V rightChild = null;
        V swap = null;
        for(int i = 0; i < (end/2); i++)
        {
            if ( (2*i + 1) <= end )
                leftChild = array[((2*i) +1)];
            if ( (2*i + 2) <= end )
                rightChild = array[((2*i) +2)];
            if ( leftChild != null && rightChild == null )
            {
                swap = leftChild;
            }
            else if (leftChild != null && rightChild != null)
            {
                if(leftChild.compareTo(rightChild) > 0 )
                {
                    swap = leftChild;
                }
                else
                {
                    swap = rightChild;
                }
            }
            if(  (swap.compareTo(array[i])) > 0 )
            {
                V temp = array[i];
                array[i] = swap;
                swap = temp;
            }
        }
    }
}
