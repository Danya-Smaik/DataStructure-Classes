package com.mycompany.datastructure;

public class LinkedList {
    Node head;
    int num =0;
    public LinkedList(Object data){
        this.head = new Node(data);
        num++;
    
    }
    public boolean addFirst(Object data){
    if (head==null){
        head = new Node (data);}
    
     Node newNode = new Node (data);
     newNode.setNext(head);
     head= newNode;
     num++;
    return true;}
    
    public boolean addLast(Object data){
       if(head==null){
       head = new Node(data);
       num++;
       return true; }
       
       Node w = new Node(data);
       Node temp = head;
       
       while(temp.getNext()!=null){
           temp=temp.getNext();}
       temp.setNext(w);
       num++;
       return true;
    }
    public boolean addByIndex(Object data , int index ){
        if(head==null){
        return false;}
        
        Node temp = head ;
        Node newNode = new Node (data);
        
        while(index>0 && temp!=null){
        temp=temp.getNext();
         index--;}
        if(index != 0 ){return false;}
        
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        num++;
        return true;
    }
    public Object removeFirسt(){
    if(head == null){
        return null ;}
     Node temp = head ;
      head = head.getNext();
      num--;
     return temp.getData();
    
}
    public Object removeLast(){
    if(head==null) return null;
    
    Node temp = head ; 
    while(temp.getNext().getNext()!=null)
    temp = temp.getNext();
    
    Node dt = temp.getNext();
    temp.setNext(null);
    num--;
    return dt.getData();
    }
    
   public Object removeByIndex(int index) {
    if (head == null) {
        return null;
    }

    Node temp = head;
    Node temp_pre = null;

    while (index > 0 && temp != null) {
        temp_pre = temp;
        temp = temp.getNext();
        index--;
    }

    if (index != 0) {
        return null;
    }

    temp_pre.setNext(temp.getNext());
    num--;
    return temp.getData();
}
public int size(){ return num;}

public Object get(int index) {
    if (head == null) {
        return null;
    }

    Node temp = head;
    while (index > 0 && temp != null) {
        temp = temp.getNext();
        index--;
    }

    if (index != 0) {
        return null;
    }

    return temp.getData();
}

}
