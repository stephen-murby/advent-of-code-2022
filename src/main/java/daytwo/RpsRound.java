package daytwo;

public class RpsRound {

    private final RPS.Outcome roundExpectation;
    private final String notation;
    private final RPS playerOneMove;
    private final RPS playerTwoMove;
    private int ROUND_DRAW = 3;
    private int ROUND_LOSS = 0;
    private int ROUND_WIN = 6;

    public RpsRound(String line) {
        final String[] roundNotation = line.split(" ");
        final String playerOneMoveNotation = roundNotation[0];
        final String strategy = roundNotation[1];
        this.notation = line;
        this.playerOneMove = RPS.ofPlayerOneNotation(playerOneMoveNotation);
        this.roundExpectation = RPS.strategy(strategy);;
        this.playerTwoMove = this.playerOneMove.moveStrategy(roundExpectation);

        System.out.println(this);
    }

    public int playerOneScore() {
        if( playerOneMove.compareTo(playerTwoMove) == 0) {
            return ROUND_DRAW + playerOneMove.getValue();
        } else if ( playerOneMove.compareTo(playerTwoMove) < 0 ) {
            return ROUND_LOSS + playerOneMove.getValue();
        } else {
            return ROUND_WIN + playerOneMove.getValue();
        }
    }

    public int playerTwoScore() {
        if( playerTwoMove.compareTo(playerOneMove) == 0) {
            return ROUND_DRAW + playerTwoMove.getValue();
        } else if ( playerTwoMove.compareTo(playerOneMove) < 0 ) {
            return ROUND_LOSS + playerTwoMove.getValue();
        } else {
            return ROUND_WIN + playerTwoMove.getValue();
        }
    }

    @Override
    public String toString() {
        return "RpsRound{" +
                "notation='" + notation + '\'' +
                ", playerOne= { move: " + playerOneMove + ", score:" + this.playerOneScore() + "}" +
                ", playerTwo= { move: " + playerTwoMove + ", score:" + this.playerTwoScore() + "}" +
                ", expectedWinner=" + roundExpectation +
                '}';
    }
}
