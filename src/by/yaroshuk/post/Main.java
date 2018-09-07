package by.yaroshuk.post;

import by.yaroshuk.post.command.*;

import java.util.List;

public class Main {
    public static void main (String[] args){
        MessageBox messageBox = new MessageBox();
        UserConsoleInputReader consoleInputReader = new UserConsoleInputReader();
        while (true){
            UserCommand userCommand = consoleInputReader.nextCommand();
            if (userCommand == null){
                System.out.println("Unkown command");
            }else {
                execute(userCommand, messageBox, consoleInputReader);
            }
        }
    }
    private static void execute(UserCommand userCommand, MessageBox messageBox, UserConsoleInputReader consoleInputReader){
        if (userCommand instanceof EditCommand){
            EditCommand command = (EditCommand) userCommand;
            Message message = messageBox.search(command.getId());
            if (message == null){
                System.out.println("User unknown");
            }else {
                consoleInputReader.readEdit(command, message.getSender(), message.getReceiver(), message.getAddress(), message.getCategory());
            }
        }

        userCommand.execute(messageBox);
    }
}
