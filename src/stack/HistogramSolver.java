package stack;

public class HistogramSolver {

    public int findLargestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        CustomStack<Integer> stack = new CustomStack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight;

            if (i == heights.length) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {

                int removedIndex = stack.pop();
                int rectangleHeight = heights[removedIndex];

                int leftBoundary;

                if (stack.isEmpty()) {
                    leftBoundary = -1;
                } else {
                    leftBoundary = stack.peek();
                }

                int width = i - leftBoundary - 1;
                int area = rectangleHeight * width;

                if (area > maxArea) {
                    maxArea = area;
                }
            }

            if (i < heights.length) {
                stack.push(i);
            }
        }

        return maxArea;
    }
}
