import java.util.*;

class Node
{
    int data;
    Node node;
    Node temp=null;
    
    public void diplay(Node first)//displaying the linked list
    {
        Node head=first;
       while(first!=null)
        {
            System.out.print(first.node+" -->");
            first=first.node;
        }
        first=head;
        System.out.println("");
        while(first!=null)
        {
            System.out.print(first.data+" -->");
            first=first.node;
        } 
    }
    public void reverseDisplay(Node first)//reversing the linked list
    {
        
        System.out.println("");
        System.out.println("This is the reverse link list");
        Node current =first;
        Node next= null;
        Node previous = null;
        while(current!=null)
        {
            next=current.node;
            current.node=previous;
            previous=current;
            current=next;
        }
        while(previous!=null)
        {
            System.out.print(previous.data+" -->");
            previous=previous.node;
        }
    }
    public void displayMiddle(Node first)//fiding the middle element of linked list
    {
        Node middle= first;
            int length=0;
            first=first.node;
            while(first!=null)
            {
            length++;
            if(length%2==0)
            {
                middle=middle.node;
               
            }
            first=first.node;
            }
            System.out.println("Middle element: "+middle.data);
    }
    public void addElement(Node first,Node add,int n)//addinf element into the linked list
    {
        Node temp = first;
        System.out.println("Before addition");
        while(temp!=null)
        {
           System.out.print(temp.data+" -->");
            temp=temp.node; 
        }
        temp=first;
        for(int i =2;i<n;i++)
        {
            first=first.node;
        }
        add.node=first.node;
        first.node=add;
        System.out.println("");
        System.out.println("After addition");
        while(temp!=null)
        {
           System.out.print(temp.data+" -->");
            temp=temp.node; 
        }
    }
    public void deleteElement(Node first,int n)//deleting element from the linked list
    {
        Node temp = first;
        System.out.println("Before deletion");
        while(temp!=null)
        {
           System.out.print(temp.data+" -->");
            temp=temp.node; 
        }
        temp=first;
        for(int i=2;i<n;i++)
        {
            first=first.node;
        }
        Node temp1=first;
        first=first.node;
        temp1.node=first.node;
        first.node=null;
        first=temp1.node;
        System.out.println("");
        System.out.println("After deletion");
        while(temp!=null)
        {
           System.out.print(temp.data+" -->");
            temp=temp.node; 
        }
    }
    public void pushElement(Node head, Node element)//implementing stack's push method
    {
       
        Node current=head;
        System.out.println("List initially");
        System.out.println("");
        while(head.node!=null)
        {
            
            System.out.print(head.data + "-->");
            
            head = head.node;
            
        }
        System.out.println("");
        head.node=element;
        head=element;
        System.out.println("After addition of element the list becomes ");
        System.out.println("");
        head=current;
        while(head!=null)
        {
           
            System.out.print(head.data + "-->");
            
            head = head.node;
        }
    }
    public void popElement(Node head)//implementing stack's pop method
    {
        Node current = null;
        current=head;
        Node previous=current;
        System.out.println("");
        System.out.println("List prior to deleting element");
        while(current.node!=null)
        {
                           
            System.out.print(current.data + "-->");
            previous=current;
            current = current.node;
            
        }
        current = head;
        while(current!=null)
        {
            System.out.print(current.node + "-->");
            current = current.node;
        }
        System.out.println("");
        previous.node=null;
        System.out.println("After deletion of element the list becomes ");
        System.out.println("");
        previous = head;
        while(previous!=null)
        {
            System.out.print(previous.data + "-->");
            previous = previous.node;
        }
        previous = head;
        while(previous!=null)
        {
            System.out.print(previous.node + "-->");
            previous = previous.node;
        }
        System.out.println("");
        System.out.println("head wala");
        while(head!=null)
        {
            System.out.print(head.node + "-->");
            head = head.node;
        }
    }
    public void queueInsert(Node head, Node element)
    {
        Node current=null;
        current=head;
        
        System.out.println("Before adding the queue in changed one");
        while(head.node!=null)
        {
            
            System.out.print(head.data + "-->");
            head = head.node;
        }
        
        head.node=element;
        element.node=null;
        head=current;
        
        System.out.println("");
        System.out.println("After adding element");
        while(head!=null)
        {
            
            System.out.print(head.data + "-->");
            head = head.node;
        }
        
    }
    public void queueRemove(Node head)
    {
        Node current = null;
        current=head.node;
        Node temp = null;
        temp=head;
        System.out.println("");
        System.out.println("Before changed one");
        while(head!=null)
        {
            
            System.out.print(head.data + "-->");
            head = head.node;
        }
        head=temp;
        head.node=null;
        head=current;
        System.out.println("");
        System.out.println("After removing");
        while(head!=null)
        {
            
            System.out.print(head.data + "-->");
            head = head.node;
        }
    }
    public Node merge(Node first,Node second)
    {
        Node result=new Node();
        Node temp=result;
        
        while(first!=null && second!=null)
        {
        if(first.data<=second.data)
        {
            result.data=first.data;
            result.node=new Node();
            result=result.node;
            first=first.node;
            
            
        }
        else
        {
               result.data=second.data;
               result.node=new Node();
               result=result.node;
               second=second.node;
               
        }
        }
        if(first==null)
        {
            while(second!=null)
            {
               result.data=second.data;
               result.node=new Node();
               result=result.node;
               second=second.node;
               
            }
        }
        if(second==null)
        {
            while(first!=null)
            {
            result.data=first.data;
            result.node=new Node();
            result=result.node;
            first=first.node; 
           
            }
        }
        result=temp;
        return result;
    }
    public void bubbleSort(Node head)
    {
        Node list=head;
        while(head!=null)
        {
            System.out.println(head.data+"");
                    head=head.node;
        }
        head=list;
        Node back=head;
        
        head=head.node;
        Node front=head;
        head=list;
        
        while(head!=null)
        {   
            
        while(front!=null)
        {
            if(back.data>front.data)
            {
               
                int temp = front.data;
                front.data=back.data;
                back.data=temp;
            }
                back=back.node;
                front=front.node;
        }
        back=list;
        front=list.node;
        head=head.node;
        }
        while(list!=null)
        {
            System.out.print(list.data + "->");
            list=list.node;
        }
    }
    public void insertionSort(Node head)
    {
        Node list=head;
        
        Node newList=new Node();
        Node p = newList;
        Node temp=newList;
        newList.data=head.data;
        head=head.node;
        while(head!=null)
        {
            if(head.data<newList.data)
            {
                Node newTemp = new Node();
                newTemp.data=head.data;
                newTemp.node=newList;
                newList=newTemp;
                p=newList;
            }   
            else
            {
                while(newList!=null && head.data>newList.data)
                {
                    temp=newList;
                    newList=newList.node;
                }
                Node newTemp = new Node();
                newTemp.data=head.data;
                temp.node=newTemp;
                newTemp.node=newList;
                newList=p;
            }
            
            head=head.node;
        }
        System.out.println("After sorting");
        while(p!=null)
        {
            System.out.print(p.data+"-->");
            p=p.node;
        }
    }
    public Node mergeSort(Node head)
    {
        Node merged=head;
        if(head.node!=null)
        {
       
        Node initial=head;
        int count=1;
        while(head!=null)
        {
            head=head.node;
            count++;
        }
        head=initial;
        int mid=1;
        while(mid<count/2)
        {
            head=head.node;
            mid++;
        }
        Node middle=head;
        head=head.node;
        middle.node=null;
        middle=initial;
        
        Node list1=mergeSort(middle);
        System.out.println("list1: "+list1.data);
        Node list2=mergeSort(head);
        System.out.println("list2 "+list2.data);
        merged=mergeAlgo(initial,list1,list2);
       System.out.println("data of merge list: "+merged.data);
        
    }
        return merged;
    }
    public Node mergeAlgo(Node result,Node low, Node high)
    {
            Node fakeHead=new Node();
            fakeHead.data=100;
          Node printtemp=fakeHead;
        while(low!=null && high!=null)
        {
        
        if(low.data<high.data)
        {
            printtemp.node=new Node();
            printtemp=printtemp.node;
            printtemp.data=low.data;
            
            low=low.node;
            
        }
        else
       {
           printtemp.node=new Node();
            printtemp=printtemp.node;
            printtemp.data=high.data;
            high=high.node;
            
        }
        }
        if(low!=null)
        {
            
            while(low!=null)
            {
            printtemp.node=new Node();
            printtemp=printtemp.node;
            printtemp.data=low.data;
            low=low.node;
           
            }
        }
        else
        {
            while(high!=null)
            {
               printtemp.node=new Node();
            printtemp=printtemp.node;
            printtemp.data=high.data;
            high=high.node;
           
            }
        }
    fakeHead=fakeHead.node;
    
    return fakeHead;
    
    }
    public void groupDisplay(Node head, int a)
    {
        Node init=head;
        Node start=head;
        Node init1=null,temp=null,temp1=null;
        Node next=null, previous=null;
        int length=0;
        while(head!=null)
        {
            head=head.node;
            length++;
        }
        System.out.println("length of the list "+length);
        head=init;
        if(length>=a)
        {
            length=length-a;
            int i=1;
            while(i<a)
            {
                next=head.node;
                head.node=previous;
                previous=head;
                head=next;
                i++;
            }
            next=head.node;
            head.node=previous;
            start=head;
        }
        if(length>=a)
        {
            while(length>=a)
            {
                temp=next;
                init1=next;
                next=next.node;
                temp1=next;
                length=length-a;
                int i=2;
                while(i<a)
                {
                    next=next.node;
                    temp1.node=init1;
                    init1=temp1;
                    temp1=next;
                    i++;
                }
                head=init1;
                init.node=head;
                init=temp;
            }
        }
        else
        {
            int i=1;
            temp=next;
                init1=next;
                next=next.node;
                temp1=next;
                length=length-a;
            while(i<=length)
            {
                if(next!=null)
                {
                    next=next.node;
                    temp1.node=init1;
                    init1=temp1;
                    temp1=next;
                    i++;
                   }
                 i++;
            }
                head=init1;
                init.node=head;
                init=temp;
        }
        head=start;
        while(head!=null)
        {
            System.out.print(head.data + "-->");
            head=head.node;
        }
    }
    public int detectLoop(Node head)
    {
        Node temp=head;
        int flag=0;
        HashMap h = new HashMap();
        //ListMultimap m = ArrayListMultimap.create();
        
        
        while(head.node!=null)
        {
            h.put(head.data, head.node);
            head=head.node;
            if(h.containsValue(head.node))
            {
                System.out.println("There is a loop");
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("System has no loop");
            System.out.println(h);
            return 0;
        }
        else
        {
            System.out.println(h);
            return 1;
        }
    }
}

public class assign4
{
    
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner (System.in);
        Node first = new Node();
        Node head=first;
        System.out.println("Enter data");
        first.data=sc.nextInt();
        char c;
        System.out.println("Want to continue y/n");
        c=sc.next().charAt(0);
        while(c=='y'){
            Node next=new Node();
            System.out.println("Enter data for the first linked list");
            first.node=next;
            first=first.node;
            first.data=sc.nextInt();
            System.out.println("Want to continue y/n");
            c=sc.next().charAt(0);
        }
        
        /*Scanner sc1 = new Scanner (System.in);
        Node second = new Node();
        Node head2=second;
        System.out.println("Enter data");
        second.data=sc1.nextInt();
        char c2;
        System.out.println("Want to continue y/n");
        c2=sc1.next().charAt(0);
        while(c2=='y'){
            Node next2=new Node();
            System.out.println("Enter data for second linked list");
            second.node=next2;
            second=second.node;
            second.data=sc1.nextInt();
            System.out.println("Want to continue y/n");
            c2=sc1.next().charAt(0);
        }
        */
        System.out.println("");;
        //Node result=second.merge(head, head2);
        /*while(result!=null)
        {
            System.out.print(result.data+"-->");
            result=result.node;
        }*/
        //first.bubbleSort(head);
        //first.insertionSort(head);
        
       // Node finalso=first.mergeSort(head);
        
        /*while(finalso!=null)
        {
            System.out.print(finalso.data+"-->");
            finalso=finalso.node;
        }
          */      
        first=head;
        first.diplay(head);
        System.out.println("Enter the number");
        Scanner sct = new Scanner(System.in);
        int a = sct.nextInt();
        System.out.println("Value returned by the furnction is: "+first.detectLoop(head));
        //first.groupDisplay(head,a);
        //first.reverseDisplay(head);
        Node add=new Node();
        add.data=23;
        first=head;
        //first.addElement(head, add, 4);
        //first.deleteElement(head,3);
       // first.pushElement(first, add);
        //first.popElement(first);
        //first.queueInsert(head, add);
        //first.queueRemove(head);
        //first.displayMiddle(head);
        /*first.data=sc.nextInt();
        System.out.println(first + "first refre");
        Node second = new Node();
        System.out.println("This is the second object: "+second);
        first.node=second;
        second.data=sc.nextInt();
        while(first!=null)
        {
            System.out.print(first.data + "-->");
            System.out.println("This is the first: "  +first);
            System.out.println("This is the pointer reference: "  +first.node);
            System.out.println("This is the head data: "  +head.data);
            System.out.println("This is the head data: "  +head.node);
            System.out.println("This is the head data: "  +head);
                    first=first.node;
        }*/
        
    }
}
        
    