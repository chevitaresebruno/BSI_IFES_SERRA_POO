// Explicações adicionais:
// O projeto do vscode tem uma base de como organizar os arquivos, logo segui esse modelo.
// O Vscode alertava um erro amrelo que me dava toc, por isso defini os atributos como públicos.

import scripts.chore.adt.Data;
import scripts.chore.conta.Corrente;
import scripts.chore.conta.Poupanca;
import scripts.chore.usuarios.Gerente;
import scripts.chore.usuarios.Pessoa;
import scripts.controllers.adt.ControllerData;

public class App {
    public static void main(String[] args) throws Exception
    {
        Data dataHoje = new Data(9, 10, 2024);
        Data dataNascimento = new Data(1, 1, 1990);
        Pessoa pessoa1 = new Pessoa("Alice", dataNascimento, 'F', "123.456.789-00");
        Gerente gerente1 = new Gerente("Bob", new Data(5, 5, 1985), 'M', "987.654.321-00", "001", "senha123");

        Corrente contaCorrente1 = new Corrente("CC001", pessoa1, dataHoje, gerente1, "SenhaNova");
        Poupanca poupanca1 = new Poupanca("P001", pessoa1, dataHoje, gerente1);

        // Testando métodos
        ControllerData.imprimir(dataHoje);
        System.out.print("OI");
    }
}
