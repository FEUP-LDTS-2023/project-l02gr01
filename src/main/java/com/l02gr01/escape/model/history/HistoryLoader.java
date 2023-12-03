package com.l02gr01.escape.model.history;

import com.google.common.base.Splitter;
import com.l02gr01.escape.model.LevelBuilder;
import com.l02gr01.escape.model.history.event.Event;
import com.l02gr01.escape.model.history.event.Loss;
import com.l02gr01.escape.model.history.event.Win;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class HistoryLoader {

    public void loadMemory() throws URISyntaxException, IOException {

        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String fileLocation = rootPath + "/src/main/resources/eventResults.txt";

        BufferedReader br = Files.newBufferedReader(Paths.get(fileLocation), Charset.defaultCharset());
        readEvent(br);
        clear(fileLocation);
    }

    private void clear(String fileLocation) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileLocation, false);
        byte[] empty = new byte[0];
        outputStream.write(new byte[0]);
        outputStream.close();
    }

    private void readEvent(BufferedReader br) throws IOException {
        for (String line; (line = br.readLine()) != null; ) {
            List<String> parts = Splitter.on(',').splitToList(line);
            String result = parts.get(0);
            String username = parts.get(1);
            int time = Integer.parseInt(parts.get(2));
            int level = Integer.parseInt(parts.get(3));

            if (result.equals("Win")) {
                History.getInstance().push(new Win(username, time, level));
            } else if (result.equals("Loss")) {
                int keys = Integer.parseInt(parts.get(4));
                History.getInstance().push(new Loss(username, time, level, keys));
            }
        }
    }

    public void storeMemory(List<Event> events) throws URISyntaxException, IOException {

        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String fileLocation = rootPath + "/src/main/resources/eventResults.txt";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocation), StandardOpenOption.APPEND);

        writeEvent(bw, events);

    }

    private void writeEvent(BufferedWriter bw, List<Event> events) throws IOException {

        for (Event event : events) {

            String parsedEvent = "";
            if (event instanceof Win) {
                parsedEvent = String.format("Win,%s,%d,%d", event.getName(), event.getTime(), event.getFinallevel());
            } else if (event instanceof Loss) {
                parsedEvent = String.format("Loss,%s,%d,%d,%d", event.getName(), event.getTime(), event.getFinallevel(), ((Loss) event).getKeysgrabbed());
            }

            bw.write(parsedEvent);
            bw.newLine();
        }
        bw.flush();
    }

}
