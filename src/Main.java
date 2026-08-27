import stack.CustomStack;
import stack.HistogramSolver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CustomStack<Integer> stack = new CustomStack<>();

        int[] heights = {2, 1, 5, 6, 2, 3};

        HistogramSolver solver = new HistogramSolver();

        int maxArea = solver.findLargestRectangleArea(heights);

        System.out.println("Maximum area: " + maxArea);


    }
}