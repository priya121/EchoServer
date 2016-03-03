package main.client;

import java.io.DataOutputStream;
import java.io.IOException;

public class RealDataOutput implements DataOutput {
    private DataOutputStream dataOutputStream;

    public RealDataOutput(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void writeBytes(String word) {
        try {
            dataOutputStream.writeBytes(word);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
