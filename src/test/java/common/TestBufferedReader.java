package common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Accessors(chain = true)
@ToString
public class TestBufferedReader extends BufferedReader {
    private int index = 0;
    private final List<String> linesInternal = new ArrayList<>();

    @Getter
    @Setter
    private Object result;

    public TestBufferedReader() {
        super(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        return linesInternal.get(index++);
    }

    public TestBufferedReader addLine(String line) {
        linesInternal.add(line);
        return this;
    }

    public TestBufferedReader addLines(Collection<String> lines) {
        linesInternal.addAll(lines);
        return this;
    }

    @Override
    public boolean ready() {
        return index < linesInternal.size();
    }
}