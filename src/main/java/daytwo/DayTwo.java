package daytwo;

import uk.co.tryteksystems.dayone.DayOne;
import utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class DayTwo {
    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println("############################");
        System.out.println("DayTwo Start");
        System.out.println("############################");

        List<String> rounds = Utils.readLines(DayOne.class, "day-two.txt");
        System.out.println("Number of rounds: " + rounds.size());
        final List<RpsRound> roundResults = rounds.stream().map(RpsRound::new).collect(Collectors.toList());

        int playerMatchScore = roundResults.stream().mapToInt(RpsRound::playerTwoScore).sum();
        int opponentMatchScore = roundResults.stream().mapToInt(RpsRound::playerOneScore).sum();

        System.out.println("Opponent Score: " + opponentMatchScore);
        System.out.println("My Score: " + playerMatchScore);

        System.out.println("############################");
        System.out.println("DayTwo End");
        System.out.println("############################");
    }
}
