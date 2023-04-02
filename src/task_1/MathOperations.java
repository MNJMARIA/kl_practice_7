package task_1;

public class MathOperations {
    public void add(int a, int b) {
        System.out.println("Result: " + (a + b));
    }
    public void sub(int a, int b){
        System.out.println("Result: " + (a - b));
    }
    public void mul(int a, int b){
        System.out.println("Result: " + a * b);
    }
    public void div(int a, int b){
        if (b == 0){
            throw new IllegalArgumentException("Division by zero!");
        }else{
            System.out.println("Result: " + (double) a / b);
        }
    }
}

