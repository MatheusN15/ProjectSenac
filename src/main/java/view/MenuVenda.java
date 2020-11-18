package view;

import java.util.Scanner;

public class MenuVenda {
	
	private static final int OPCAO_VENDA_CADASTRAR = 1;
	private static final int OPCAO_VENDA_CONSULTAR = 2;
	private static final int OPCAO_VENDA_ATUALIZAR = 3;
	private static final int OPCAO_VENDA_EXCLUIR = 4;
	private static final int OPCAO_VENDA_VOLTAR = 5;

		

		Scanner teclado = new Scanner(System.in);
		
		public void apresentarMenuVenda() {
			int opcao = this.apresentarOpcoesMenuVenda();
			
			while (opcao != OPCAO_VENDA_VOLTAR) {
				switch (opcao) {
				case OPCAO_VENDA_CADASTRAR: {
					cadastrarvenda();
				}
				case OPCAO_VENDA_CONSULTAR: {
					break;
				}
				case OPCAO_VENDA_ATUALIZAR: {
					break;
				}
				case OPCAO_VENDA_EXCLUIR: {
					
					break;
				}
				default:
					System.out.println("Opcão invalida");
					break;
				}
			opcao = this.apresentarOpcoesMenuVenda();	
			}
			
		}

		private int apresentarOpcoesMenuVenda() {
			System.out.println("Revenda Ferro Velho");
			System.out.println("====Menu venda====");
			System.out.println("\nOpções:");
			System.out.println(OPCAO_VENDA_CADASTRAR + "- Cadastrar venda:");
			System.out.println(OPCAO_VENDA_CONSULTAR + "- Consultar venda:");
			System.out.println(OPCAO_VENDA_ATUALIZAR + "- Atualizar venda:");
			System.out.println(OPCAO_VENDA_EXCLUIR + "- Excliur venda:");
			System.out.println(OPCAO_VENDA_VOLTAR + "- Retornar ao Menu:");
			System.out.print("\nDigite a opção: ");
			return Integer.parseInt(teclado.nextLine());
			
		}
		
		private void cadastrarvenda() {
			// TODO Auto-generated method stub
			
		}
		
	

}
