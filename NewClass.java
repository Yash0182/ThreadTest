
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaio1
 */
class LinkedList
{
    int data;
    LinkedList next;
    int count=0;
    
    public int lengthElement(LinkedList first)
    {
        if(first==null)
        {
            return 0;
        }
        count++;
        first=first.next;
        lengthElement(first);
        return count;
    }
    public void display(LinkedList head)
    {
        System.out.println("Before swapping head");
        while(head!=null)
        {
            System.out.print(head.data + "-->");
            head=head.next;
        }
        System.out.println("");
    }
    public void swapNode(LinkedList head, LinkedList second)
    {
        System.out.println("Just enrte");
        while(second!=null)
        {
        System.out.print(second.data+ "-->");
        second=second.next;
        }
        LinkedList temp = head;
        head=second;
        second=temp;
        System.out.println("After swapping head");
        while(head!=null)
        {
        System.out.print(head.data+"-->");
        head=head.next;
        }
        System.out.println("");
        System.out.println("After swapping second");
        while(second!=null)
        {
        System.out.print(second.data+ "-->");
        second=second.next;
        }
        
    }
    public void swapData(LinkedList head, int x, int y)
    {
        LinkedList temp=head;
        head=temp;
        LinkedList prev=new LinkedList();
        LinkedList secondprev=new LinkedList();
        prev.next=head;
        secondprev.next=head;
        while(head!=null&&head.data!=x)
        {
            head=head.next;
            prev=prev.next;
            
        }
        LinkedList first = head;
        head=temp;
        while(head!=null&&head.data!=y)
        {
          head=head.next;
           secondprev=secondprev.next;
           
        }
        LinkedList second = head;
        LinkedList last=head.next;
        second.next=first.next;
        first.next=last;
        prev.next=second;
        secondprev.next=first;
        head=temp;
        System.out.println("");
        System.out.println("After reversing the node");
        while(head!=null)
        {
            System.out.print(head.data+ "-->");
            head=head.next;
        }
    }
}
public class NewClass {
    public static void main(String args[])
    {
        LinkedList L = new LinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data");
        L.data=sc.nextInt();
        LinkedList head=L;
        char c;
        System.out.println("Enter more elements y/n");
        c= sc.next().charAt(0);
        while(c=='y')
        {
            LinkedList M = new LinkedList();
            L.next=M;
            System.out.println("Enter data");
            M.data=sc.nextInt();
            L=M;
            System.out.println("Enter more elements y/n");
            c= sc.next().charAt(0);
        }
        LinkedList sw[] = new LinkedList[5];
        for(int i=0;i<5;i++)
        {
            sw[i] = new LinkedList();
        }
        for(int i=0;i<5;i++)
        {
        sw[i].data=i*20;
        }
        for(int i=0;i<5;i++)
        {
        if(i<4)
        {
        sw[i].next=sw[i+1];
        }
        else
                {sw[i]=null;}
        }
        int i=0;
        System.out.println("second");
        while(sw[i]!=null)
        {
            System.out.print(sw[i].data+"-->");
            i++;
        }
        LinkedList s1 = new LinkedList();
        s1.data=20;
        LinkedList s2 = new LinkedList();
        s2.data=40;
        LinkedList s3 = new LinkedList();
        s3.data=60;
        LinkedList s4 = new LinkedList();
        s4.data=80;
        s1.next=s2;
        s2.next=s3;
        s3.next=s4;
        System.out.println("");
        /*System.out.println("Before swapping second original");
        while(s1!=null)
        {
            System.out.print(s1.data+"-->");
            
            s1=s1.next;
        }*/
        L.display(head);
        System.out.println("");
        System.out.println("Length of list " +L.lengthElement(head));
        //L.swapNode(head, s1);
        
        L.swapData(head, 23, 67);
    }
}
