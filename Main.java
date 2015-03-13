import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private class MyStack{
        int size = 0;
        private int arr[];
        private static final int DEFAULT_CAPACITY = 10;

        /**
         * Initializes a MyStack instance with a new array of size 10
         */
        public MyStack(){
            arr = new int[DEFAULT_CAPACITY];
            size = 0;
        }

        /**
         * Checks if an instance of MyStack class is empty
         * @return true if empty, false if not empty
         */
        private boolean isEmpty(){
            return size < 1;
        }

        /**
         * Gets the size of a MyStack instance. 
         * @return size of the current MyStack instance
         */
        private int size(){
            return size;
        }

        /**
         * Pushes an integer value in a MyStack instance.If the current stack instance is full. A new stack is
         * created with twice the size of the old stack. The values in the old stack are then copied into the
         * new stack before pushing the new interger value unto the stacck.
         * @param num to be pushed
         */
        private void push(int num){
            if(arr.length > size){
                arr = Arrays.copyOf(arr, 2 * arr.length);
            }
            arr[size++] = num;
        }

        /**
         * Returns the last value added to a MyStack instance
         * @return an int value
         */
        private int pop(){
            return arr[--size];
        }

        /**
         * Adds a list of interger values to a stack instance
         */
         public void addAll(List<Integer> list){
             for (int i = 0; i < list.size(); i++) {
                 arr[size++] = list.get(i);
             }
         }

        /**
         * Clears the contents of a stack instance. Since the underlying data structure of a stack instance
         * is an array, every number at every index is set to the default integer value of zero;
         * The array is then set back to what is was like in the constructor
         */
        private void clear(){
            while (size > 0){
                arr[--size] = 0;
            }
        }
    }

    public static void main(String[] args){
        List<String> input = new ArrayList<>();
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(args[0]));
            String line = "";
            while((line = br.readLine()) != null){
                input.add(line.trim());
            }
        }catch(Exception e){
            throw new RuntimeException("Encountered a problem while reading file: "+e.getCause());
        }finally{
            try{
                br.close();
            }catch(Exception e){}
        }

        Main main = new Main();
        for (String x : input){
            main.createAndPrintStack(x);
        }
    }

    /**
     * Prints every alternate integer in the current instance of MyStack.  
     * @param stack instance to be printed
     */
    private void printAlternateIntegersInStack(MyStack stack){
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
            if(!stack.isEmpty()){
               stack.pop(); // We just pop a value but do not show it to the PrintStream
            }
        }
        System.out.println();
    }

    /**
     * Takes a String made of integer values. Converts each value in the String to an actual integer
     * value and pushes this value unto a stack. this value unto a stack. Afterwards, it prints every
     * alternate integer in the stack
     * @param str is integer values given in the form of a String. E.g String str = "1 2 3 4 5";
     */
    private void createAndPrintStack(String str){

        MyStack stk = new MyStack();
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length ; i++) {
            stk.push(Integer.parseInt(arr[i]));
        }

        printAlternateIntegersInStack(stk);
    }
}
