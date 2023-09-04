package stack;


public class PseudoQueue<T> {
    private final Stack<T> main;
    private final Stack<T> temp;

    public PseudoQueue(){
        main = new Stack<>();
        temp = new Stack<>();
    }

    public void enqueue(T value){
        while (!(main.isEmpty())){
            temp.push(main.pop());
        }
        temp.push(value);
        while (!(temp.isEmpty())){
            main.push(temp.pop());
        }
    }

    public T dequeue(){
        if(!(main.isEmpty())){
            return main.pop();
        }else {
            return null;
        }
    }

    public String toString() {
        return main.toString();
    }
}