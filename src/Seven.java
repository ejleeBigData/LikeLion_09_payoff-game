public class Seven implements Player {
    final boolean[] opponentHistory;
    int recordIndex = 0;
    private boolean exploitMode = false;

    public Seven(int maxRounds) {
        this.opponentHistory = new boolean[10];  //무지성 전략일 경우 하드코딩?
    }

    //round = 1 부터, 이전 라운드는 index = 0 에서 시작하니 -2
    @Override
    public boolean cooperate(int round) {

        //Prober 에 10회만 배신
        // 1–4라운드: D, C, C, C
        if (round == 1 || round == 10)    return false;
        if (round >= 2 && round <= 4) return true;

        // 5라운드 직전까지 모두 협력했으면 영구 배신
        if (round == 5) {
            if (opponentHistory[1] && opponentHistory[2] && opponentHistory[3]) {
                exploitMode = true;
            }
        }
        if (exploitMode) {
            return false;
        }
        // 그 외에는 Tit‑for‑Tat
        return opponentHistory[round - 2];
    }

    @Override
    public void recordOpponentMove(boolean opponentMove) {
        opponentHistory[recordIndex++] = opponentMove;
    }
}
