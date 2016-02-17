package main;

import java.util.LinkedList;
import java.util.List;

public class FakeIOConsole implements IOConsole {
    LinkedList<String> input;

    public FakeIOConsole(List<String> input) {
        this.input = new LinkedList<>(input);
    }

    @Override
    public String getInput() {
        return input.pop();
    }

    @Override
    public String showOutput(String message) {
        return message;
    }
}
