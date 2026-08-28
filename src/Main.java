import stack.ArrayStack;
import stack.HistogramSolver;
import stack.LinkedStack;
import stack.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};

        HistogramSolver solver = new HistogramSolver();
        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> linkedStack = new LinkedStack<>();

        int arrayResult = solver.findLargestRectangleArea(heights, arrayStack);
        int linkedResult = solver.findLargestRectangleArea(heights, linkedStack);

        System.out.println("ArrayStack result: " + arrayResult);
        System.out.println("LinkedStack result: " + linkedResult);




    }
}