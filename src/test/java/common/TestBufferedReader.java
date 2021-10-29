package common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
@ToString
public class TestBufferedReader extends BufferedReader {
    private int index = 0;
    private final List<String> lines = new ArrayList<>();

    @Getter
    @Setter
    private Object result;

    public TestBufferedReader() {
        super(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        return lines.get(index++);
    }

    public TestBufferedReader addLine(String line) {
        lines.add(line);
        return this;
    }

    @Override
    public boolean ready() {
        return index < lines.size();
    }
}