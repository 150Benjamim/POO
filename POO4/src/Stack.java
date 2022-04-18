import java.util.ArrayList;
import java.util.Arrays;

public class Stack {

    private ArrayList<String> stack;

    public Stack(){
        this.stack = new ArrayList<>();
    }

    public Stack(Stack stack){
        this.stack = stack.getStack();
    }

    public Stack clone(){
        return new Stack(this);
    }

    public ArrayList<String> getStack(){
        ArrayList<String> resultado = new ArrayList<>(this.stack.size());
        resultado.addAll(stack);
        return resultado;
    }

    public void setStack(ArrayList<String> stack){
        this.stack = new ArrayList<>(stack.size());
        this.stack.addAll(stack);
    }

    public String top(){
        return this.stack.get(this.stack.size()-1);
    }

    public void push(String s){
        this.stack.add(s);
    }

    public void pop(){
        this.stack.remove(this.stack.size()-1);
    }

    public boolean empty(){
        if (this.stack.isEmpty()) return true;
        else return false;
    }

    public int length(){
        return this.stack.size();
    }



}
