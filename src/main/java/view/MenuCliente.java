package view;

import java.util.Scanner;

public class MenuCliente {

	Scanner teclado = new Scanner(System.in);

	
	private static final int OPCAO_CLIENTE_CADASTRAR = 1;
	private static final int OPCAO_CLIENTE_CONSULTAR = 2;
	private static final int OPCAO_CLIENTE_ATUALIZAR = 3;
	private static final int OPCAO_CLIENTE_EXCLUIR = 4;
	private static final int OPCAO_CLIENTE_RETORNAR = 5;
	
	public void apresentarMenuCliente() {
		int opcao = this.apresentarOpcoesMenuCliente();
		
		while (opcao != OPCAO_CLIENTE_RETORNAR) {
			switch (opcao) {
			case OPCAO_CLIENTE_CADASTRAR: {
				break;
			}
			case OPCAO_CLIENTE_CONSULTAR: {
				break;
			}
			case OPCAO_CLIENTE_ATUALIZAR: {
				break;
			}
			case OPCAO_CLIENTE_EXCLUIR: {
				break;
			}
			default:
				System.out.println("Opcão invalida");
				break;
			}
		opcao = this.apresentarOpcoesMenuCliente();	
		}
		
	}

	private int apresentarOpcoesMenuCliente() {
		System.out.println("Revenda Ferro Velho");
		System.out.println("====Menu Cliente====");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_CLIENTE_CADASTRAR + "- Cadastrar Cliente:");
		System.out.println(OPCAO_CLIENTE_CONSULTAR + "- Consultar Cliente:");
		System.out.println(OPCAO_CLIENTE_ATUALIZAR + "- Atualizar Cliente:");
		System.out.println(OPCAO_CLIENTE_EXCLUIR + "- Excliur Cliente:");
		System.out.println(OPCAO_CLIENTE_RETORNAR + "- Retornar ao Menu:");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
		
	}
}
