public class ME implements Player {
    final boolean[] opponentHistory; // 상대 기록을 적어 넣은 배열
    final boolean[] selfopponentHistory;
    int recordIndex = 0; // 라운드 별 기록되는 위치의 인덱스

    public ME (int maxRounds) {
        this.selfopponentHistory = new boolean[maxRounds];
        this.opponentHistory = new boolean[maxRounds]; // 라운드 몇번 진행할지 넣어야함
    }
    @Override
    public boolean cooperate(int round) {
        if (round == 1) {
            return false;
        }
        if (round >=5 && selfopponentHistory[round-5] == opponentHistory[round-4] && // 3연속 같으면 협력
                selfopponentHistory[round-4] == opponentHistory[round-3] &&
                selfopponentHistory[round-3] == opponentHistory[round-2] ) {
            return true;
        }
        return false; // 기본적으로 배신
    }
    @Override
    public void recordOpponentMove(boolean opponentMove) {
        opponentHistory[recordIndex++] = opponentMove; // 상대 기록 배열에 상대의 행동을 0번부터 기록
    }
}
