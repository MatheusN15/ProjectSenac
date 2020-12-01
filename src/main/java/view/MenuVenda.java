package view;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import controller.ControladoraVeiculo;
import controller.ControladoraVenda;
import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;
import model.vo.VendaVO;

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
			System.out.println("\nRevenda Ferro Velho");
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
			VendaVO venda = new VendaVO();
			System.out.println("\nRevenda Ferro Velho");
			System.out.println("==== Realizar Venda ====");
			System.out.println("\nDigite o ID do cliente: ");
			venda.setIdCliente(Integer.parseInt(teclado.nextLine()));
			System.out.println("\nDigite o ID do veiculo: ");
			venda.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
			System.out.println("\nDigite o valor da compra: ");
			venda.setValorVenda(Double.parseDouble(teclado.nextLine()));
			LocalDate dataVenda = LocalDate.now();
			venda.setDataVenda(dataVenda);
			System.out.println(venda.getDataVenda());
			ControladoraVenda controladoraVenda = new ControladoraVenda();
			String resultado = controladoraVenda.cadastrarVendaController(venda);
			System.out.println(resultado);
			apresentarMenuVenda();
		}
		
	

}
