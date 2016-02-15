public class EchoServer {

    private final IOConsole io;
    private String input = "";

    public EchoServer(IOConsole io) {
        this.io = io;
    }

    public String write() {
        return input;
    }

    public void start() {
        io.showOutput("Enter quit to exit the program: ");
        String currentInput = io.getInput();
        while (isNotQuit(currentInput)) {
            input += currentInput + "\n";
            io.showOutput(input);
            currentInput =  io.getInput();
        }
        io.showOutput("Exiting the program");
    }

    private boolean isNotQuit(String nextInput) {
        return !nextInput.equals("quit");
    }
}
