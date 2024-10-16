package scripts.controllers.adt;

import java.util.Scanner;
import scripts.chore.adt.Senha;


public final class ControllerSenha {
    
    public static String inputSenha()
    {
        Scanner scanner;
        String senha; 

        scanner = new Scanner(System.in);

        System.out.print("Informe a Senha: ");
        senha = scanner.next();
        scanner.close();
        System.out.print("\n");

        return senha;
    }

    public static Senha newSenha() throws Exception
    {
        return new Senha(inputSenha());
    }

    public static boolean compareSenha(Senha senha, String input) throws Exception 
    {
        return senha.compare(input);
    }

    public static boolean compareInputSenha(Senha object) throws Exception
    {
        return object.compare(inputSenha());
    }
}
