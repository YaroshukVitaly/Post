package by.yaroshuk.post;

import java.util.List;

public class Main {
    public static void main (String[] args){
        MessageBox messageBox = new MessageBox();
        UserConsoleInputReader consoleInputReader = new UserConsoleInputReader(messageBox);
        consoleInputReader.start();
    }
}
