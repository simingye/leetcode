package TrappingRainWaterII;

import java.util.Comparator;

/**
 * Created by SimingYe on 3/6/16.
 */
public class CellComparator implements Comparator<Cell>
{
    public int compare(Cell c1, Cell c2) {
        if (c1.h > c2.h)
        {
            return 1;
        }
        else if (c1.h < c2.h)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
