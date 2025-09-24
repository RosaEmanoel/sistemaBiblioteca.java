import java.util.Scanner;

public class Input {
    public static int scanInt(String mensagem, Scanner scan) {
        System.out.print(mensagem);
        while (!scan.hasNextInt()) {
            System.out.print("Valor inválido. Tente novamente: ");
            scan.next();
        }
        int value = scan.nextInt();
        scan.nextLine(); 
        return value;
    }

    public static String scanString(String mensagem, Scanner scan) {
        System.out.print(mensagem);
        String value = scan.nextLine();
        while (value.trim().isEmpty()) {
            System.out.print("Valor inválido. Digite novamente: ");
            value = scan.nextLine();
        }
        return value.trim();
    }
}
