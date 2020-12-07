package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import controller.ControladoraVenda;
import controller.ControladoraVenda;
import model.vo.VendaVO;
import model.vo.VendaVO;

public class MenuVenda {
	
	private static final int OPCAO_VENDA_CADASTRAR = 1;
	private static final int OPCAO_VENDA_CONSULTAR = 2;
	private static final int OPCAO_VENDA_ATUALIZAR = 3;
	private static final int OPCAO_VENDA_EXCLUIR = 4;
	private static final int OPCAO_VENDA_VOLTAR = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_VENDAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_VENDA = 2;
	private static final int OPCAO_MENU_CONSULTAR_VENDAS_VOLTAR =3;
	

		Scanner teclado = new Scanner(System.in);
		
		public void apresentarMenuVenda() {
			int opcao = this.apresentarOpcoesMenuVenda();
			
			while (opcao != OPCAO_VENDA_VOLTAR) {
				switch (opcao) {
				case OPCAO_VENDA_CADASTRAR: {
					cadastrarvenda();
				}
				case OPCAO_VENDA_CONSULTAR: {
					consultarVenda();
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
			System.out.println("\nDigite o ID do venda: ");
			venda.setIdVenda(Integer.parseInt(teclado.nextLine()));
			System.out.println("\nDigite o ID do venda: ");
			venda.setIdVenda(Integer.parseInt(teclado.nextLine()));
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
		
		private void consultarVenda() {
			int opcao = this.apresentarOpcoesMenuConsulta();
			ControladoraVenda controladoraVenda = new ControladoraVenda();
			while(opcao != OPCAO_MENU_CONSULTAR_VENDAS_VOLTAR) {
				switch(opcao) {
					case OPCAO_MENU_CONSULTAR_TODOS_VENDAS:{
						opcao = OPCAO_MENU_CONSULTAR_VENDAS_VOLTAR;
						ArrayList<VendaVO> listaVendasVO = controladoraVenda.consultarTodosVendas();
						if(listaVendasVO.isEmpty()) {
							System.out.println("\nLista de Vendas não localizada.");
						}
						System.out.println("\n------ RESULTADO DA CONSULTA ------");
						System.out.printf("\n%3s   %3s   %3s   %-10s   %-10s \n",
								"IDVenda", "IDCLiente", "IDVeiculo", "Valor Venda", "Data Venda");
						for (int i = 0; i < listaVendasVO.size(); i++) {
							listaVendasVO.get(i).imprimir();
						}
						break;
					}
					case OPCAO_MENU_CONSULTAR_UM_VENDA:{
						opcao = OPCAO_MENU_CONSULTAR_VENDAS_VOLTAR;
						System.out.println("Digite o codigo do pedido: ");
						int idVenda = (Integer.parseInt(teclado.nextLine()));
						
						VendaVO venda = controladoraVenda.consultarVenda(idVenda); 
						if (venda == null) {
							System.out.println("\nVenda não localizado.");
						}
						System.out.println("\n------ RESULTADO DA CONSULTA ------");
						System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-10s \n",
								"IDVenda", "IDCLiente", "IDVeiculo", "Valor Venda", "Data Venda");
						venda.imprimir();
						break;
					}
				}
				consultarVenda();
				}
			apresentarMenuVenda();
			}
			

		private int apresentarOpcoesMenuConsulta() {
			System.out.println("\nInforme o tipo de consulta a ser realizada.");
			System.out.println(OPCAO_MENU_CONSULTAR_TODOS_VENDAS + " - Consultar todos os vendas");
			System.out.println(OPCAO_MENU_CONSULTAR_UM_VENDA + " - Consultar um venda");
			System.out.println(OPCAO_MENU_CONSULTAR_VENDAS_VOLTAR + " - Voltar para menu");
			System.out.println("Digite a opção: ");
			return Integer.parseInt(teclado.nextLine());

		}

}
