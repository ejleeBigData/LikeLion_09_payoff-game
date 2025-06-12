public class A implements Player{
    // 경기 결과 기록배열
    final boolean[] opponentHistory;
    // 현재 라운드
    int recordIndex = 0;

    // 총 라운드
    public A(int maxRounds){
        this.opponentHistory = new boolean[maxRounds];
    }

    @Override
    // 실행문. 1 9 10라운드 거짓, 이후는 상대방 전 라운드 결과 값 출력
    public boolean cooperate(int round) {
        if (round == 1 || round == 10 || round == 9){
            return false;
        }

        // 이전 라운드(-1), 인덱스 0부터 시작(-1)
        return opponentHistory[round - 2];
    }

    @Override
    // 상대방 결과 기록
    public void recordOpponentMove(boolean opponentMove) {
        // 기록 배열의 현재 라운드 인덱스에 상대 출력 기록
        opponentHistory[recordIndex++] = opponentMove;
    }
}