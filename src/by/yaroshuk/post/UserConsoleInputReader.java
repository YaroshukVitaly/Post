package by.yaroshuk.post;

import by.yaroshuk.post.command.*;

import java.util.Arrays;
import java.util.Scanner;

public class UserConsoleInputReader {
    private Scanner scanner;
        public UserConsoleInputReader(){
        scanner = new Scanner(System.in);
    }

    public UserCommand nextCommand (){
        Scanner s = new Scanner(scanner.nextLine());
        String token = s.next();
        if (token.equalsIgnoreCase("remove")){
            return parseRemove(s);
        }else if (token.equalsIgnoreCase("edit")){
            return parseEdit(s);

        }else if (token.equalsIgnoreCase("add")){
            return parseAdd(s);
        }else if (token.equalsIgnoreCase("send")){
            if (!s.hasNext()) {
                return new SendCommand();
            }
        }else if (token.equalsIgnoreCase("list")){
            if (!s.hasNext()) {
                return new ListCommand();
            }
        }else if (token.equalsIgnoreCase("help")){
            if (!s.hasNext()) {
                return new HelpCommand();
            }
        }else if (token.equalsIgnoreCase("exit")){
            if (!s.hasNext()) {
                return new ExitCommand();
            }
        }
        return null;
    }

    private AddCommand parseAdd(Scanner s) {
        if (s.hasNext()) {
            return null;
        }
        System.out.println("Please, enter sender: ");
        String sender = scanner.nextLine();
        System.out.println("Please, enter reciever: ");
        String reciever = scanner.nextLine();
        System.out.println("Please, enter address: ");
        String address = scanner.nextLine();
        System.out.println("Please, enter category from " + Arrays.toString(Message.MassageCategory.values()));
        String category = scanner.nextLine().trim();
        Message.MassageCategory cat = parceCategory(category);
        return new AddCommand(sender, reciever, address, cat);
    }

    private EditCommand parseEdit(Scanner s) {
        if (s.hasNextLong()){
            long l = s.nextLong();
            if (!s.hasNext()){
                return new EditCommand(l);
            }
        }
        return null;
    }

    private RemoveCommand parseRemove(Scanner s) {
        if (s.hasNextLong()){
            long l = s.nextLong();
            if (!s.hasNext()){
                return new RemoveCommand(l);
            }
        }
        return null;
    }

      private Message.MassageCategory parceCategory(String category) {
        Message.MassageCategory cat;
        switch (category){
            case "first_class" :
                cat = Message.MassageCategory.FIRST_CLASS;
                break;
            case "special" :
                cat = Message.MassageCategory.SPECIAL;
                break;
            case "regular" :
            default:
                cat = Message.MassageCategory.REGULAR;
                break;
        }
        return cat;
    }

    public void readEdit(EditCommand command, Message message) {
        System.out.print("Change sender (" + message.getSender() + ") if you want: ");
        String line = scanner.nextLine().trim();
        if (!line.isEmpty()){
            command.setSender(line);
        }
        System.out.print("Change receiver (" + message.getReceiver() + ") if you want: ");
        line = scanner.nextLine().trim();
        if (!line.isEmpty()){
            command.setReceiver(line);
        }
        System.out.print("Change address (" + message.getAddress() + ") if you want: ");
        line = scanner.nextLine().trim();
        if (!line.isEmpty()){
            command.setAddress(line);
        }
        System.out.print("Change category (" + message.getCategory() + ") if you want: ");
        line = scanner.nextLine().trim();
        if (!line.isEmpty()){
            command.setCategory(parceCategory(line));
        }
    }
}
