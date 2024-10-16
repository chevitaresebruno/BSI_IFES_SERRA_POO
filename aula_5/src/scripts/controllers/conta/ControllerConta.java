package scripts.controllers.conta;

import scripts.chore.conta.Conta;
import scripts.controllers.adt.ControllerSenha;

public final class ControllerConta
{
    public static void extrato(Conta conta)
    {
        System.out.println ("***EXTRATODACONTA***");
        System.out.println("Conta: " + conta.numero);
        System.out.println("Titular: " + conta.titular.cpf);
        System.out.println("Saldo disponivel para saque: " + conta.disponivel());
    }

    public static boolean transferir(Conta origin, Conta destination, double value, String senha) throws Exception
    {
        if(canSacar(origin, value, senha))
        {
            unsafeSacar(origin, value);
            depositar(destination, value);
            return true;
        }
        
        return false;
    }

    public static boolean canSacar(Conta conta, double value, String senha) throws Exception
    {
        if(!checkPassword(conta, senha))
        { return false; }

        if(!checkValue(value))
        { return false; }
        
        if(conta.disponivel() < value)
        {
            System.out.println("ERRO: Saque na conta " + conta.numero + " nao foi realizado. Valor disponivel: " + conta.disponivel());
            return false;
        }

        return true;
    }

    private static boolean checkPassword(Conta conta, String password) throws Exception
    {
        if(!ControllerSenha.compareSenha(conta.senha, password))
        {
            System.out.println("ERRO: A senha fornecida está incorreta");
            return false;
        }

        return true;
    }

    private static boolean checkValue(double value)
    {
        if(value <= 0)
        {
            System.out.println("ERRO: O valor fornecido deve ser maior ou igual a 0.");
            return false;
        }

        return true;
    }

    public static void depositar(Conta conta, double valor)
    {
        if(checkValue(valor))
            conta.saldo += valor;
    }

    public static double sacar(Conta conta, double valor, String senha) throws Exception
    {
        if(!canSacar(conta, valor, senha))
        { return 0.0d; }    
        
        conta.saldo -= valor;

        return conta.disponivel();
    }

    private static void unsafeSacar(Conta conta, double value)
    {
        conta.saldo -= value;
    }
}
