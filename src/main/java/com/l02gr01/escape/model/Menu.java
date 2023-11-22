package com.l02gr01.escape.model;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries = Arrays.asList("Start", "Instructions", "Leaderboard", "Exit");

    private int currentEntry = 0;

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }
    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedInstruction() {return isSelected(1);}

    public int getNumberEntries() {
        return this.entries.size();
    }



}
