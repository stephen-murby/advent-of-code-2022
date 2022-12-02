package uk.co.tryteksystems.dayone;

import java.util.Arrays;

public class Elf implements Comparable<Elf> {
    private long[] rations;
    private int rationIndex;

    public Elf() {
        this.rations = new long[10];
        this.rationIndex = 0;
    }

    public void addRation(long calories) {
        if (rationIndex >= rations.length) {
            increaseRationsStorage();
        }
        rations[rationIndex] = calories;
        rationIndex++;
    }

    public long calories() {
        return Arrays.stream(this.rations).sum();
    }

    private void increaseRationsStorage() {
        long[] rationStorage = new long[rations.length * 2];
        for (int i = 0; i < rations.length; i++) {
            rationStorage[i] = rations[i];
        }
        rations = rationStorage;
    }

    @Override
    public int compareTo(final Elf o) {
        if (this.calories() == o.calories()) return 0;
        if (this.calories() > o.calories()) return 1; else return -1;
    }
}
