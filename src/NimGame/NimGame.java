package NimGame;

/**
 * Created by SimingYe on 1/13/16.
 */
public class NimGame
{
    public boolean canWinNim(int n)
    {
        if (n % 4 == 0)
            return false;
        else
            return true;
    }
}
