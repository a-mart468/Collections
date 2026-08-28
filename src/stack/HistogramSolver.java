package stack;


public class HistogramSolver {

    public int findLargestRectangleArea(int[] heights, Stack<Integer> stack) {
        validateArguments(heights, stack);

        if (heights.length == 0) {
            return 0;
        }
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight;

            if (i == heights.length) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }

            while (!stack.isEmpty() && currentHeight <= heights[stack.peek()]) {
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

    private void validateArguments(int[] heights, Stack<Integer> stack) {
        if (heights == null) {
            throw new IllegalArgumentException(
                    "Heights cannot be null"
            );
        }

        if (stack == null) {
            throw new IllegalArgumentException(
                    "Stack cannot be null"
            );
        }

        if (!stack.isEmpty()) {
            throw new IllegalArgumentException(
                    "Stack must be empty"
            );
        }

        for (int height : heights) {
            if (height < 0) {
                throw new IllegalArgumentException(
                        "Height cannot be negative"
                );
            }
        }
    }
}