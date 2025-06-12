public class Seven implements Player {
    final boolean[] opponentHistory;
    int recordIndex = 0;

    public Seven(int maxRounds) {
        this.opponentHistory = new boolean[10];  //무지성 전략일 경우 하드코딩?
    }

    //round = 1 부터, 이전 라운드는 index = 0 에서 시작하니 -2
    @Override
    public boolean cooperate(int round) {
        if(round == 1 || round == 10) {
            return false;
        }

        return opponentHistory[round - 2];
    }

    @Override
    public void recordOpponentMove(boolean opponentMove) {
        opponentHistory[recordIndex++] = opponentMove;
    }
}
