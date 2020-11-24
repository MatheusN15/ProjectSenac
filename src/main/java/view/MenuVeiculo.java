package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraVeiculo;
import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class MenuVeiculo {

	private static final int OPCAO_VEICULO_CADASTRAR = 1;
	private static final int OPCAO_VEICULO_CONSULTAR = 2;
	private static final int OPCAO_VEICULO_ATUALIZAR = 3;
	private static final int OPCAO_VEICULO_EXCLUIR = 4;
	private static final int OPCAO_VEICULO_VOLTAR = 5;
	
	private static final int OPCAO_VEICULO_CARRO = 1;
	private static final int OPCAO_VEICULO_MOTO = 2;
	private static final int OPCAO_VEICULO_SUV = 3;
	private static final int OPCAO_VEICULO_SAIR = 99;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_VEICULOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_VEICULO = 2;
	private static final int OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR =3;


	Scanner teclado = new Scanner(System.in);
	
	
	public void apresentarMenuVeiculo() {
		System.out.println("Revenda Ferro Velho");
		System.out.println("====Menu VEICULO====");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_VEICULO_CADASTRAR + "- Cadastrar VEICULO:");
		System.out.println(OPCAO_VEICULO_CONSULTAR + "- Consultar VEICULO:");
		System.out.println(OPCAO_VEICULO_ATUALIZAR + "- Atualizar VEICULO:");
		System.out.println(OPCAO_VEICULO_EXCLUIR + "- Excliur VEICULO:");
		System.out.println(OPCAO_VEICULO_VOLTAR + "- Retornar ao Menu:");
		System.out.print("\nDigite a opção: ");
		int opcao = Integer.parseInt(teclado.nextLine());
		
		while (opcao != OPCAO_VEICULO_VOLTAR) {
			switch (opcao) {
			case OPCAO_VEICULO_CADASTRAR: {
				this.cadastrarVeiculo();
			}
			case OPCAO_VEICULO_CONSULTAR: {
				this.consultarVeiculo();
			}
			case OPCAO_VEICULO_ATUALIZAR: {
				this.atualizarVeiculo();
			}
			case OPCAO_VEICULO_EXCLUIR: {
				this.excluirVeiculo();
				break;
			}
			default:
				System.out.println("Opcão invalida");
				break;
			}
		}
		
	}



/*	private int apresentarOpcoesMenuVeiculo() {
		System.out.println("Revenda Ferro Velho");
		System.out.println("====Menu VEICULO====");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_VEICULO_CADASTRAR + "- Cadastrar VEICULO:");
		System.out.println(OPCAO_VEICULO_CONSULTAR + "- Consultar VEICULO:");
		System.out.println(OPCAO_VEICULO_ATUALIZAR + "- Atualizar VEICULO:");
		System.out.println(OPCAO_VEICULO_EXCLUIR + "- Excliur VEICULO:");
		System.out.println(OPCAO_VEICULO_VOLTAR + "- Retornar ao Menu:");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
		
	}*/
	
	private void cadastrarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("\nDigite o modelo do veiculo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.println("Digite o tipo do veiculo: ");
		int opcao = this.apresentarOpcoesTipoVeiculo();
		while(opcao != OPCAO_VEICULO_SAIR) {
			switch (opcao) {
				case OPCAO_VEICULO_CARRO: {
					veiculoVO.setTipo(TipoVeiculo.CARRO);
					opcao = OPCAO_VEICULO_SAIR;
					break;
				}
				case OPCAO_VEICULO_MOTO: {
					veiculoVO.setTipo(TipoVeiculo.MOTO);
					opcao = OPCAO_VEICULO_SAIR;
					break;
				}
				case OPCAO_VEICULO_SUV: {
					veiculoVO.setTipo(TipoVeiculo.SUV);
					opcao = OPCAO_VEICULO_SAIR;
					break;
				}
				default:{
					System.out.println("\nOpção Invalida!");
					opcao = this.apresentarOpcoesTipoVeiculo();
				}
			}
		}
		System.out.print("\nDigite o fabricante do veiculo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.print("\nDigite a cor do veiculo: ");
		veiculoVO.setCor(teclado.nextLine());
		System.out.print("\nDigite a placa do veiculo: ");
		veiculoVO.setPlaca(teclado.nextLine());
		System.out.print("\nDigite o ano do veiculo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.cadastrarVeiculoController(veiculoVO);
		System.out.println(resultado);
		apresentarMenuVeiculo();
	}



	private int apresentarOpcoesTipoVeiculo() {
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_VEICULO_CARRO + " - Carro");
		System.out.println(OPCAO_VEICULO_MOTO + " - Moto");
		System.out.println(OPCAO_VEICULO_SUV + " - SUV");
		System.out.println("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
	
	private void excluirVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.println("\nDigite o codigo do veiculo: ");
		veiculoVO.setIdVeiculo(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.excluirVeiculoController(veiculoVO);
		System.out.println(resultado);
		
	}
	
	private void atualizarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("\nDigite o modelo do veiculo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.println("Digite o tipo do veiculo: ");
		int opcao = this.apresentarOpcoesTipoVeiculo();
		while(opcao != OPCAO_VEICULO_SAIR) {
			switch (opcao) {
				case OPCAO_VEICULO_CARRO: {
					veiculoVO.setTipo(TipoVeiculo.CARRO);
					opcao = OPCAO_VEICULO_SAIR;
					break;
				}
				case OPCAO_VEICULO_MOTO: {
					veiculoVO.setTipo(TipoVeiculo.MOTO);
					opcao = OPCAO_VEICULO_SAIR;
					break;
				}
				case OPCAO_VEICULO_SUV: {
					veiculoVO.setTipo(TipoVeiculo.SUV);
					opcao = OPCAO_VEICULO_SAIR;
					break;
				}
				default:{
					System.out.println("\nOpção Invalida!");
					opcao = this.apresentarOpcoesTipoVeiculo();
				}
			}
		}
		System.out.print("\nDigite o fabricante do veiculo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.print("\nDigite a cor do veiculo: ");
		veiculoVO.setCor(teclado.nextLine());
		System.out.print("\nDigite a placa do veiculo: ");
		veiculoVO.setPlaca(teclado.nextLine());
		System.out.print("\nDigite o ano do veiculo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.cadastrarVeiculoController(veiculoVO);
		System.out.println(resultado);
	}
	

	private void consultarVeiculo() {
		int opcao = this.apresentarOpcoesMenuConsulta();
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		while(opcao != OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR) {
			switch(opcao) {
				case OPCAO_MENU_CONSULTAR_TODOS_VEICULOS:{
					opcao = OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR;
					ArrayList<VeiculoVO> listaVeiculosVO = controladoraVeiculo.consultarTodosVeiculosController();
					if(listaVeiculosVO.isEmpty()) {
						System.out.println("\nLista de Veiculos não localizada.");
					}
					System.out.println("\n------ RESULTADO DA CONSULTA ------");
					System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-5s   %-10s   %-10s \n",
							"ID", "MODELO", "TIPO", "FABRICANTE", "ANO", "COR", "PLACA");
					for (int i = 0; i < listaVeiculosVO.size(); i++) {
						listaVeiculosVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UM_VEICULO:{
					opcao = OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR;
					System.out.println("Digite o codigo do pedido: ");
					int idVeiculo = (Integer.parseInt(teclado.nextLine()));
					
					VeiculoVO veiculo = controladoraVeiculo.consultarVeiculoController(idVeiculo); 
					if (veiculo == null) {
						System.out.println("\nVeiculo não localizado.");
					}
					System.out.println("\n------ RESULTADO DA CONSULTA ------");
					System.out.println("");
					veiculo.imprimir();
					break;
				}
			}
			consultarVeiculo();
			}
		apresentarMenuVeiculo();
		}
		

	private int apresentarOpcoesMenuConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada.");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_VEICULOS + " - Consultar todos os veículos");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_VEICULO + " - Consultar um veículo");
		System.out.println(OPCAO_MENU_CONSULTAR_VEICULOS_VOLTAR + " - Voltar para menu");
		System.out.println("Digite a opção: ");
		return Integer.parseInt(teclado.nextLine());

	}


}
	


