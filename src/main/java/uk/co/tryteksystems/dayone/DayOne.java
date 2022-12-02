package uk.co.tryteksystems.dayone;

import utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DayOne {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("############################");
        System.out.println("DayOne Start");
        System.out.println("############################");

        List<Elf> elves = new ArrayList<>();
        List<String> lines = Utils.readLines(DayOne.class, "day-one.txt");

        Elf currentElf = new Elf();

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).isBlank()) {
                elves.add(currentElf);
                currentElf = new Elf();
            } else {
                currentElf.addRation(Long.parseLong(lines.get(i)));
            }
        }

        elves.sort(Elf::compareTo);

        Long rations = elves.get(elves.size() - 1).calories() + elves.get(elves.size() - 2).calories() + elves.get(elves.size() - 3).calories();

        System.out.println("Elf with the most rations has: " + elves.get(elves.size() - 1).calories());
        System.out.println("Rations belong to 3 elves with most: " + rations);

        System.out.println("############################");
        System.out.println("DayOne End");
        System.out.println("############################");
    }
}
