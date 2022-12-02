package daytwo;

public abstract class RPS implements Comparable<RPS> {

    enum Outcome {
            WIN("Player One Win"), LOSE("Player One Lose"), DRAW("Draw");

        private final String formattedOutput;

        Outcome(final String formattedOutput) {
            this.formattedOutput = formattedOutput;
        }

        @Override
        public String toString() {
            return formattedOutput;
        }
    }

    public abstract int getValue();
    public static RPS ofPlayerOneNotation(String s) {
        switch (s) {
            case "A": return new Rock();
            case "B": return new Paper();
            case "C": return new Scissors();
        }
        return null;
    }

    public static Outcome strategy(String s) {
        switch (s) {
            case "X": return Outcome.WIN;
            case "Y": return Outcome.DRAW;
            case "Z": return Outcome.LOSE;
        }
        return null;
    }

    public abstract RPS moveStrategy(final Outcome roundExpectation);

}

class Rock extends RPS {
    @Override
    public RPS moveStrategy(final Outcome roundExpectation) {
        switch (roundExpectation) {
            case WIN: return new Scissors();
            case LOSE: return new Paper();
            case DRAW: return new Rock();
        }
        return null;
    }
    @Override
    public int compareTo(final RPS o) {
        final Class<? extends RPS> thatClass = o.getClass();
        if(thatClass.equals(Paper.class)) return - 1;
        if(thatClass.equals(Scissors.class)) return 1;
        return 0;
    }
    @Override
    public String toString() {
        return "Rock";
    }

    @Override
    public int getValue() {
        return 1;
    }
}

class Paper extends RPS {
    public int value = 2;
    @Override
    public int compareTo(final RPS o) {
        final Class<? extends RPS> thatClass = o.getClass();
        if(thatClass.equals(Scissors.class)) return - 1;
        if(thatClass.equals(Rock.class)) return 1;
        return 0;
    }
    @Override
    public String toString() {
        return "Paper";
    }

    @Override
    public int getValue() {
        return 2;
    }

    @Override
    public RPS moveStrategy(final Outcome roundExpectation) {
        switch (roundExpectation) {
            case WIN: return new Rock();
            case LOSE: return new Scissors();
            case DRAW: return new Paper();
        }
        return null;
    }
}

class Scissors extends RPS {
    public int value = 3;
    @Override
    public int compareTo(final RPS o) {
        final Class<? extends RPS> thatClass = o.getClass();
        if(thatClass.equals(Rock.class)) return - 1;
        if(thatClass.equals(Paper.class)) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Scissors";
    }

    @Override
    public int getValue() {
        return 3;
    }

    @Override
    public RPS moveStrategy(final Outcome roundExpectation) {
        switch (roundExpectation) {
            case WIN: return new Paper();
            case LOSE: return new Rock();
            case DRAW: return new Scissors();
        }
        return null;
    }
}
