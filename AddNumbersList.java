package com.worksheet.java;

public class AddNumbersList 
{
  static Node head1, head2;

 static class Node //created a node
 {
     int data;
     Node next;

     Node(int d)
     {
         data = d;
         next = null;
     }
 }

 /* Adds contents of two linked lists and return the 
    addition list */
 Node addTwoLists(Node first, 
                  Node second)
 {
     // res is head node of the 
     // resultant list
     Node res = null;
     Node prev = null;
     Node temp = null;
     int carry = 0, sum;

     // while both lists exist
     while (first != null ||
            second != null) 
     {
         // Calculate value of next digit in resultant list.  
   
         sum = carry + (first != null ? first.data : 0) + 
               (second != null ? second.data : 0);

         // Update carry for next calculation
         carry = (sum >= 10) ? 1 : 0;

         // Update sum if it is greater than 10
         sum = sum % 10;

         // Create a new node with sum as data
         temp = new Node(sum);

         // if this is the first node then set it as head of the resultant list
         if (res == null) 
         {
             res = temp;
         }

         // If this is not the first node then connect it to the rest.
         else 
         {
             prev.next = temp;
         }

         // Set prev for next insertion
         prev = temp;
         if (first != null) 
         {
             first = first.next;
         }
         if (second != null) 
         {
             second = second.next;
         }
     }

     if (carry > 0) 
     {
         temp.next = new Node(carry);
     }

     // return head of the resultant list
     return res;
 }

 //Printing a list
 void printList(Node head)
 {
     while (head != null) 
     {
         System.out.print(head.data + 
                          " ");
         head = head.next;
     }
     System.out.println("");
 }

 
 public static void main(String[] args)
 {
     AddNumbersList list = new AddNumbersList();

     // Creating first list
     list.head1 = new Node(7);
     list.head1.next = new Node(5);
     list.head1.next.next = new Node(9);
     list.head1.next.next.next = 
     new Node(4);
     list.head1.next.next.next.next =  
     new Node(6);
     System.out.print("First List is ");
     list.printList(head1);

     // Creating second list
     list.head2 = new Node(8);
     list.head2.next = new Node(4);
     System.out.print("Second List is ");
     list.printList(head2);

     // Add the two lists and see the result
     Node rs = list.addTwoLists(head1, head2);
     System.out.print("Resultant List is ");
     list.printList(rs);
 }
}