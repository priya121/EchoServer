package main.client;

public class FakeDataOutput implements DataOutput {
    private String word = "";

    public FakeDataOutput() {
    }

    @Override
    public void writeBytes(String word) {
        this.word += word;
    }

    public String getWrittenBytes() {
        return word;
    }
}
