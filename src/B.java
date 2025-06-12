import java.util.Random;

public class B implements Player{
    final Random rand = new Random();

    @Override
    public boolean cooperate(int round) {

        if( round > 9 ) {
            return false;
        } else {
            return rand.nextBoolean();
        }
    }

    @Override
    public void recordOpponentMove(boolean opponentMove) {

    }
}
