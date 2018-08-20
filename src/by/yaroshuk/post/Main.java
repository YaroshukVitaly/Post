package by.yaroshuk.post;

public class Main {
    public static void main (String[] args){
        MessageBox messageBox = new MessageBox(3);
        messageBox.add(Message.MassageCategory.REGULAR, "Григорьев В. М.", "В г. Москва", "Петров П.П.");
        messageBox.add(Message.MassageCategory.REGULAR, "Тарковский К. А.", "В г. Москва", "Петров П.П.");
        messageBox.add(Message.MassageCategory.REGULAR, "Иванов И.", "В г. Москва", "Петров П.П.");
        messageBox.add(Message.MassageCategory.REGULAR, "Иванов И.", "В г. Москва", "Петров П.П.");

        System.out.println(messageBox);

        System.out.println();
        System.out.println();
        System.out.println();

        Message m = messageBox.search(2);
        m.setCategory(Message.MassageCategory.FIRST_CLASS);

        System.out.println(messageBox);

        System.out.println();
        System.out.println();
        System.out.println();

        boolean d = messageBox.delete(1);
        System.out.println("d = " + d);
        System.out.println(messageBox);

    }
}
