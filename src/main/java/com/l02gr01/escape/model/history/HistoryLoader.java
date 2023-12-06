package com.l02gr01.escape.model.history;

import com.google.common.base.Splitter;
import com.l02gr01.escape.model.history.event.Event;
import com.l02gr01.escape.model.history.event.Loss;
import com.l02gr01.escape.model.history.event.Win;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class HistoryLoader {

    public List<Event> loadMemory() throws IOException {

        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String fileLocation = rootPath + "/src/main/resources/eventResults.txt";

        BufferedReader br = Files.newBufferedReader(Paths.get(fileLocation), Charset.defaultCharset());
        List<Event> events = readEvent(br);
        clear(fileLocation);
        return events;
    }

    private void clear(String fileLocation) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileLocation, false);
        outputStream.write(new byte[0]);
        outputStream.close();
    }

    private List<Event> readEvent(BufferedReader br) throws IOException {
        List<Event> events = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; ) {
            List<String> parts = Splitter.on(',').splitToList(line);
            String result = parts.get(0);
            String username = parts.get(1);
            long time = Long.parseLong(parts.get(2));
            int level = Integer.parseInt(parts.get(3));

            if (result.equals("Win")) {
                events.add(new Win(username, time, level));
            } else if (result.equals("Loss")) {
                events.add(new Loss(username, time, level));
            }
        }
        return events;
    }

    // A more general approach to storing events
    public void storeMemory(List<Event> events) throws IOException {

        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String fileLocation = rootPath + "/src/main/resources/eventResults.txt";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocation), StandardOpenOption.APPEND);

        writeEvent(bw, events);

    }

    // A more specific approach to storing events in memory that depends on the creation of a list to use the general approach
    public void storeMemory(Event event) throws IOException {
        List<Event> events = new ArrayList<>();
        events.add(event);
        storeMemory(events);
    }

    private void writeEvent(BufferedWriter bw, List<Event> events) throws IOException {

        for (Event event : events) {

            String parsedEvent = "";
            if (event instanceof Win) {
                parsedEvent = String.format("Win,%s,%d,%d", event.getName(), event.getTime(), event.getFinalLevel());
            } else if (event instanceof Loss) {
                parsedEvent = String.format("Loss,%s,%d,%d", event.getName(), event.getTime(), event.getFinalLevel());
            }

            bw.write(parsedEvent);
            bw.newLine();
        }
        bw.flush();
    }

}
