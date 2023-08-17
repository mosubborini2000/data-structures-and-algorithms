package linkedlist;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList() {
        this.head=null;
    }

    public void insert(T value){
        Node<T> newNode = new Node<>(value);
        if(head == null){
            head = newNode;
        }else{
            Node<T> tempRef = head;
            head = newNode;
            newNode.next = tempRef;
        }
    }

    public boolean include(T value){
//
        if(head == null){
            return false;
        }

        Node<T> tempRef = head;

        while (tempRef != null) {

            if (tempRef.value == value) {
                return true;
            }
            tempRef = tempRef.next;
        }
        return false;
    }

    public String toString(){

        if(head == null){
            return "Your List Empty";
        }

        Node<T> tempRef = head;
        String result="";
        while(tempRef != null){

            result = result + "{" + tempRef.value + "} -> ";

            tempRef = tempRef.next;
        }
        return result +  "Null";
    }


}






