package edu.cpp.cs.cs241.prog_assgmnt_1;

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{

    public void sampleMethod()
    {
        NodeHeap n = new NodeHeap<>();
        n.add(1);
        n.add(2);
        n.add(3);
        n.add(4);
        n.add(5);
        n.add(6);
        n.add(7);
        n.add(8);
        System.out.println("----");
        n.toArray();
       
//         System.out.println("----");
//         n.remove();
//         n.remove();
//         n.remove();
//         System.out.println("----");
//         n.getSortedContents();

    }
    
//     public Node<V> getNode(int n)
//     {
//         Node<V> nodeAtPos = root;
//         String path = Integer.toBinaryString(n);
//         path = path.substring(1, path.length());
//         for(int i = 0; i < path.length(); ++i)
//         {
//             if(path.charAt(i) == '0')
//                 nodeAtPos = nodeAtPos.getLeftChild();
//             if(path.charAt(i) == '1')
//                 nodeAtPos = nodeAtPos.getRightChild();
//         }
//         return nodeAtPos;
//     }
}
