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
                consoleInputReader.readEdit(command, message);
            }
            executeEdit(command, messageBox, message);
        }

        if (userCommand instanceof AddCommand){
            executeAdd((AddCommand) userCommand, messageBox);
        }
        if (userCommand instanceof RemoveCommand){
            executeRemove((RemoveCommand) userCommand, messageBox);
        }
        if (userCommand instanceof ExitCommand){
            executeExit((ExitCommand) userCommand, messageBox);
        }
        if (userCommand instanceof HelpCommand){
            executeHelp((HelpCommand) userCommand, messageBox);
        }
        if (userCommand instanceof SendCommand){
            executeSend((SendCommand) userCommand, messageBox);
        }
        if ( userCommand instanceof ListCommand){
            executeList((ListCommand) userCommand, messageBox);
        }
    }

    private static void executeList(ListCommand userCommand, MessageBox messageBox) {
        System.out.println("List of messsages: ");
        for (Message message : messageBox.list()){
            System.out.println(message);
        }

    }

    private static void executeSend(SendCommand userCommand, MessageBox messageBox) {
        List<Long> longs = messageBox.sendToMainOffice();
        System.out.println("Following message were sent: " + longs);
    }

    private static void executeHelp(HelpCommand userCommand, MessageBox messageBox) {
        System.out.println("You can use following commands: ");
        System.out.println("add");
        System.out.println("send");
        System.out.println("list");
        System.out.println("edit <<id>>");
        System.out.println("remove <<id>>");
        System.out.println("help");
        System.out.println("exit");
    }

    private static void executeExit(ExitCommand userCommand, MessageBox messageBox) {
        System.out.println("Exiting....");
        System.exit(0   );
    }

    private static void executeRemove(RemoveCommand userCommand, MessageBox messageBox) {
        boolean delete = messageBox.delete(userCommand.getId());
        if (delete) {
            System.out.println("Message" + userCommand.getId() + "was sucessfully remove!");
        }else {
            System.out.println("Message" + userCommand.getId() + "was not found!");
        }
    }

    private static void executeAdd(AddCommand userCommand, MessageBox messageBox) {
        messageBox.add(userCommand.getCategory(), userCommand.getSender(), userCommand.getAddress(), userCommand.getReciever());
    }

    private static void executeEdit(EditCommand command, MessageBox messageBox, Message message) {
        if (command.getCategory() != null ){
            message.setCategory(command.getCategory());
        }
        if (command.getSender()!= null) {
            message.setSender(command.getSender());
        }
        if (command.getReciever() != null) {
            message.setReceiver(command.getReciever());
        }
        if (command.getAddress() != null) {
            message.setAddress(command.getAddress());
        }
    }
}
