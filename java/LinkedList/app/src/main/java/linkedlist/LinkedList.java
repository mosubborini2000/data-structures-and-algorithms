package linkedlist;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> tempRef = head;
            head = newNode;
            newNode.next = tempRef;
        }
    }

    public boolean include(T value) {
        if (head == null) {
            return false;
        }

        Node<T> tempRef = head;

        while (tempRef != null) {
            if (tempRef.value.equals(value)) {
                return true;
            }
            tempRef = tempRef.next;
        }
        return false;
    }

    public String toString() {
        if (head == null) {
            return "Your List Empty";
        }

        Node<T> tempRef = head;
        StringBuilder result = new StringBuilder();
        while (tempRef != null) {
            result.append("{").append(tempRef.value).append("} -> ");
            tempRef = tempRef.next;
        }
        return result + "Null";
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> tempRef = head;
            while (tempRef.next != null) {
                tempRef = tempRef.next;
            }
            tempRef.next = newNode;
        }
    }

    public String insertBefore(T existNum, T newValue) {
        boolean trueFalse = this.include(existNum);
        if (!trueFalse) {
            return "Number doesn't exist";
        }
        Node<T> node = new Node<>(newValue);
        Node<T> tempRefForFirstValue;
        if (head.value.equals(existNum)) {
            tempRefForFirstValue = head;
            head = node;
            head.next = tempRefForFirstValue;
        }

        Node<T> tempRef = head;
        Node<T> tempRef2 = tempRef;
        while (!tempRef.value.equals(existNum)) {
            tempRef2 = tempRef;
            tempRef = tempRef.next;
        }

        tempRef2.next = node;
        node.next = tempRef;

        return "Number Added";
    }

    public void insertAfter(T value, T newVal) {
        Node<T> curr = head;
        Node<T> newNode = new Node<>(value);
        newNode.value = newVal;

        while (curr != null && !curr.value.equals(value)) {
            curr = curr.next;
        }
        if (curr != null) {
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }
    public T kthFromEnd(int k){
        if(k < 0 || head == null) {
            return null;
        }

        Node<T> tempRef = head;
        Node<T> tempRef2 = head;
        int count = 0;

        while(tempRef.next != null) {
            tempRef = tempRef.next;
            count++;
            if(count > k) {
                tempRef2 = tempRef2.next;
            }
        }

        if(count < k) {
            return null;
        }
        return tempRef2.value;

    }
    public LinkedList<T> linkedListZip(LinkedList<T> one, LinkedList<T> two){

        Node<T> tempRefOne = one.head;
        Node<T> tempRefTwo = two.head;

        LinkedList<T> mergedList = new LinkedList<>();

        while (tempRefOne != null || tempRefTwo != null){
            if(tempRefOne != null){
                mergedList.append(tempRefOne.value);
                tempRefOne = tempRefOne.next;
            }
            if(tempRefTwo != null){
                mergedList.append(tempRefTwo.value);
                tempRefTwo = tempRefTwo.next;
            }
        }
        return mergedList;
    }
}
