package programa;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Motorista;
import classes.Pessoa;

public class AppHeranca {
    private static final Object[] motorista = null;
    private static int qtdCadastrados;

    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 28;
        final int MAX_ERROS_CPF = 3;
        int opcao, qtdCadastrados = 0;
        Motorista[] motoristas = new Motorista[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar motorista");
            System.out.println("2 - Listar motoristas cadastrados");
            System.out.println("0 - Sair");
            System.out.println("3 - Buscar motorista listado pelo cpf");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); 

            if (opcao == 1) {
            
                if (qtdCadastrados == MAX_ELEMENTOS) { 
                System.out.println("\nNão há mais espaço para cadastrar.Tente na próxima!");
                voltarMenu(in);
                  continue;
                }

                Motorista mot = new Motorista();

                System.out.print("Nome: ");
                mot.setNome(in.nextLine());

                System.out.print("Habilitação: ");
                mot.setHabilitacao(in.nextLine());

                int numVezes = 0;
                do {
                    try {
                        System.out.print("CPF: ");
                        mot.setCpf(in.nextLine());
                    } catch (InputMismatchException ex) {
                        System.out.println(ex.getMessage() + " Tente novamente.");
                        numVezes += 1;
                    }
                } while (mot.getCpf() == null && numVezes < MAX_ERROS_CPF);

               
                if (mot.getCpf() == null) {
                    System.out.printf("Você errou o CPF %d vezes. O programa será encerrado.", numVezes);
                    return;
                }

                motoristas[qtdCadastrados] = mot;
                qtdCadastrados = qtdCadastrados + 1;

                System.out.println("\nMotorista cadastrado com sucesso.");
                voltarMenu(in);
            } else if (opcao == 2) {
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("\nMOTORISTAS CADASTRADOS:");
                System.out.println("***********************");

                for (int i = 0; i < qtdCadastrados; i++) {
                    System.out.printf("\nMotorista %d: %s\n", (i + 1), motoristas[i].getNome());
                    System.out.printf("CPF: %s\n", motoristas[i].getCpf());
                    System.out.printf("Habilitação: %s\n", motoristas[i].getHabilitacao());
                }

                voltarMenu(in);
            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

   
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
      
        for (int i = 0; i < qtdCadastrados; i++) {
            Object auxCpf;
            if (auxCpf.equals(((Pessoa) motorista[i]).getCpf())){
                System.out.println("Motorista encontrado!!!!");
                System.out.printf("Motorista %d: %s", (i + 1), ((Pessoa) motorista[i]).getNome());
                System.out.printf("Cpf: %s", ((Motorista) motorista [i]).getHabilitacao());
            } else{
                System.out.println("Não há motoristas cadastrados para serem exibidos.");
                voltarMenu(in);
                continue;
            }
            voltarMenu(in);
            continue;

            
        }
            System.out.flush();

    }
}