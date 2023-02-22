package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		Conta c1 = new Conta(1, 123, 1, "Erica Araujo", 30000.0f);
		c1.visualizar();
		
		c1.setSaldo(35000.0f);
		System.out.println("\n\n" + c1.getSaldo());
		
		Conta c2 = new Conta(2, 123, 1, "Dener Cardoso", 50000.0f);
		c2.visualizar();
		
		if(c2.sacar(1000.0f))
			System.out.println("\n\n" + c2.getSaldo());
		
		c1.depositar(10000.0f);
		c1.visualizar();
		
		int opcao;
		
		while (true) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "************************************************************************");		
			System.out.println("                                                                        ");
			System.out.println(Cores.TEXT_BLUE_BOLD + "                           BANCO DO BRAZIL COM Z                        ");
			System.out.println("                                                                        ");
			System.out.println(Cores.TEXT_RESET + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "************************************************************************");		
			System.out.println("                                                                        ");
			System.out.println("                     1 - Criar conta                                    ");
			System.out.println("                     2 - Listar todas as contas                         ");
			System.out.println("                     3 - Buscar conta por Número                        ");
			System.out.println("                     4 - Atualizar Dados da Conta                       ");
			System.out.println("                     5 - Apagar Conta                                   ");
			System.out.println("                     6 - Sacar                                          ");
			System.out.println("                     7 - Depositar                                      ");
			System.out.println("                     8 - Transferir valores entre Contas                ");
			System.out.println("                     9 - Sair                                           ");
			System.out.println("                                                                        ");
			System.out.println("************************************************************************");		
			System.out.println(Cores.TEXT_CYAN + "Entre com a opção desejada:                                             ");
			System.out.println("                                                                        ");
			
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_BLUE_BOLD + "\n            Banco do Brazil com Z " + Cores.TEXT_RESET + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "- O seu Futuro começa aqui!           ");
				System.out.println("                                                                        ");
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println("Criar Conta                                                             \n\n");
				
				break;
			case 2:
				System.out.println("Listar todas as Contas                                                  \n\n");
				
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número                                   \n\n");
				
				break;
			case 4:
				System.out.println("Atualizar dados da Conta                                                \n\n");
				
				break;
			case 5:
				System.out.println("Apagar a Conta                                                          \n\n");
				
				break;
			case 6:
				System.out.println("Saque                                                                   \n\n");
				
				break;
			case 7:
				System.out.println("Depósito                                                                \n\n");
				
				break;
			case 8:
				System.out.println("Transferência entre contas                                              \n\n");
				
				break;
			default:
				System.out.println("\nOpção Inválida!                                                         \n");
				break;
			}
			
		}
	
	}

}
