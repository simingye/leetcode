package RectangleArea;

/**
 * Created by Siming on 6/30/15.
 */
public class RectangleArea
{
    public int computeArea (int A, int B, int C, int D, int E, int F, int G, int H)
    {
        int rectangleOne = (C - A) * (D - B);
        int rectangleTwo = (G - E) * (H - F);
        int overlap = 0;

        int topRightY = Math.min(D, H);
        int topRightX = Math.min(C, G);
        int bottomLeftX = Math.max(E, A);
        int bottomLeftY = Math.max(F, B);

        if (C <= E || G <= A)
            return rectangleOne + rectangleTwo;

        if (D <= F || H <= B)
            return rectangleOne + rectangleTwo;

        overlap = (topRightX - bottomLeftX) * (topRightY - bottomLeftY);

        int result = rectangleOne + rectangleTwo - overlap;

        return result;
    }

    public static void main(String[] args) {
        RectangleArea test = new RectangleArea();
        System.out.println(test.computeArea(-2, -2, 2, 2, 1, -3, 3, -1));
    }
}
