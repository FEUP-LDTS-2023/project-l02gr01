package com.l02gr01.escape.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Instruction {
    private final List<String> lines;

    public Instruction() throws URISyntaxException, IOException {
        URL resource = Instruction.class.getResource("/instructionDraw.txt");
        assert resource != null;
        BufferedReader br = Files.newBufferedReader(Paths.get(resource.toURI()), Charset.defaultCharset());
        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    public List<String> getLines() {
        return lines;
    }
}
