package edu.cpp.cs.cs241.prog_assgmnt_1;


public class Customer implements Comparable<Customer> 
{
    
    private String name;
    private int priority;
    
    public Customer(String name, int priority)
    {
        this.name = name;
        this.priority = priority;
        
    }
    
   
    public int compareTo(Customer other)
    {
        if( this.getPriority() < other.getPriority() )
        {
            return 1;
        }
        return -1;
    }
    
    
    public String getName()
    {
        return name;
    }
    
   
    public int getPriority()
    {
        return priority;
    }
    
   
    public String showPriority()
    {
        return priority + "";
    }
}
