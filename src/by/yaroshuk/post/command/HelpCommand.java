package by.yaroshuk.post.command;

import by.yaroshuk.post.MessageBox;

public class HelpCommand implements UserCommand {
    @Override
    public void execute(MessageBox messageBox) {
        System.out.println("You can use following commands: ");
        System.out.println("add");
        System.out.println("send");
        System.out.println("list");
        System.out.println("edit <<id>>");
        System.out.println("remove <<id>>");
        System.out.println("help");
        System.out.println("exit");
    }
}
