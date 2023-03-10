package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		ContaController contas = new ContaController();
				
		System.out.println("\nCriar Contas\n");
				
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
			
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();

		
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
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						// cc.visualizar();
					}
					case 2 -> {
						System.out.println("Informe o aniversário da Conta Poupança:");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						// cp.visualizar();
					}
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas                                                  \n\n");
				
				contas.listarTodas();
				
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número                                   \n\n");
				
				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta                                                \n\n");
				
				System.out.println("Informe o número da conta: ");
				numero = leia.nextInt();
				
				if(contas.buscarNaCollection(numero) != null) {
					System.out.println("Informe o nome do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					System.out.println("Informe o número da agência: ");
					agencia = leia.nextInt();
					
					System.out.println("Informe o saldo da conta: ");
					saldo = leia.nextFloat();
					
					//Busca do tipo
					tipo = contas.retornaTipo(numero);
					
					switch (tipo) {
						case 1 -> {
							System.out.println("Informe o limite da Conta Corrente:");
							limite = leia.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
							
						}
						case 2 -> {
							System.out.println("Informe o aniversário da Conta Poupança:");
							aniversario = leia.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
					}
				} else {
					
				}
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta                                                          \n\n");
				
				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println("Saque                                                                   \n\n");
				
				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				System.out.println("Valor do Saque: ");
				valor = leia.nextFloat();
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println("Depósito                                                                \n\n");
				
				System.out.println("Número da Conta: ");
				numero = leia.nextInt();
				
				System.out.println("Valor do Depósito: ");
				valor = leia.nextFloat();
				
				contas.depositar(numero, valor);
				
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
				
				contas.transferir(numero, numeroDestino, valor);
				
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
