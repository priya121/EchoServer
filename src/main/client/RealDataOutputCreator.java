package main.client;

import java.io.DataOutputStream;
import java.io.OutputStream;

public class RealDataOutputCreator implements OutputStreamCreator {

    @Override
    public DataOutput createOutput(OutputStream outputStream) {
        return new RealDataOutput(new DataOutputStream(outputStream));
    }
}
