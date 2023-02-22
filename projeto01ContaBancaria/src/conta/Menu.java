package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		/*Conta c1 = new Conta(1, 123, 1, "Erica Araujo", 30000.0f);
		c1.visualizar();
		
		c1.setSaldo(35000.0f);
		System.out.println("\n\n" + c1.getSaldo());
		
		Conta c2 = new Conta(2, 123, 1, "Dener Cardoso", 50000.0f);
		c2.visualizar();
		
		if(c2.sacar(1000.0f))
			System.out.println("\n\n" + c2.getSaldo());
		
		c1.depositar(10000.0f);
		c1.visualizar();*/
		
		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "Vitória", 30000.0f, 1000f);
		cc1.visualizar();
		cc1.sacar(30900);
		cc1.visualizar();
		
		System.out.println();
		
		ContaPoupanca cp1 = new ContaPoupanca(1, 6548, 2, "Giovani", 30000.0f, 21);
		cp1.visualizar();
		cp1.sacar(29000);
		cp1.visualizar();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		
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
			System.out.println("                                                                        ");
			System.out.println(Cores.TEXT_CYAN + "Entre com a opção desejada:                                             ");
			System.out.println("                                                                        ");
			
			try {
				opcao = leia.nextInt();				
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros");
				leia.nextLine();
				opcao = 0;
			}
			
			
			if (opcao == 9) {
				System.out.println("\n                                                                        ");
				System.out.println(Cores.TEXT_BLUE_BOLD + "            Banco do Brazil com Z " + Cores.TEXT_RESET + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW + "- O seu Futuro começa aqui!           ");
				System.out.println("                                                                        ");
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println("Criar Conta                                                               \n");
				
				System.out.println("Informe o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				System.out.println("Informe o número da agência: ");
				agencia = leia.nextInt();
				
				System.out.println("Informe o saldo da conta: ");
				saldo = leia.nextFloat();
				
				do {
					System.out.println("Informe o tipo de conta: ");
					System.out.println("   1 - Conta Corrente");
					System.out.println("   2 - Conta Poupança");
					tipo = leia.nextInt();
					
					
				} while (tipo != 1 && tipo != 2); 
				
				switch (tipo) {
					case 1 -> {
						System.out.println("Informe o limite da Conta Corrente:");
						limite = leia.nextFloat();
						ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
						cc.visualizar();
					}
					case 2 -> {
						System.out.println("Informe o aniversário da Conta Poupança:");
						aniversario = leia.nextInt();
						ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();
					}
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas                                                  \n\n");
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número                                   \n\n");
				
				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta                                                \n\n");
				
				System.out.println("Informe o número da agência: ");
				agencia = leia.nextInt();
				
				//Condicional para verificar se a conta existe
				
				System.out.println("Informe o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				System.out.println("Informe o saldo da conta: ");
				saldo = leia.nextFloat();
				
				//Busca do tipo
				
				tipo = 0;
				
				switch (tipo) {
					case 1 -> {
						System.out.println("Informe o limite da Conta Corrente:");
						limite = leia.nextFloat();
						ContaCorrente cc = new ContaCorrente(0, agencia, tipo, titular, saldo, limite);
						cc.visualizar();
					}
					case 2 -> {
						System.out.println("Informe o aniversário da Conta Poupança:");
						aniversario = leia.nextInt();
						ContaPoupanca cp = new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();
					}
				}
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta                                                          \n\n");
				
				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				//Método Deletar
				
				keyPress();
				break;
			case 6:
				System.out.println("Saque                                                                   \n\n");
				
				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				System.out.println("Valor do Saque: ");
				valor = leia.nextFloat();
				
				//Método Sacar
				
				keyPress();
				break;
			case 7:
				System.out.println("Depósito                                                                \n\n");
				
				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				System.out.println("Valor do Depósito: ");
				valor = leia.nextFloat();
				
				//Método Depósito
				
				keyPress();
				break;
			case 8:
				System.out.println("Transferência entre contas                                              \n\n");
				
				System.out.println("Informe o número da Conta de Origem: ");
				numero = leia.nextInt();
				
				System.out.println("Informe o número da Conta de Destino: ");
				numeroDestino = leia.nextInt();
				
				System.out.println("Valor da Transferência: ");
				valor = leia.nextFloat();
				
				//Método Transferir
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!                                                         \n");
				keyPress();
				break;
			}
			
		}
	
	}
	
	public static void keyPress() {
		try {
			System.out.println("\n\nPressione " + Cores.TEXT_WHITE + "Enter" + Cores.TEXT_CYAN + " para continuar...                                       ");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter                            ");		
		}
	}

}
