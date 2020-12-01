package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ControladoraCliente;
import model.vo.ClienteVO;

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
				cadastrarCliente();
				break;
			}
			case OPCAO_CLIENTE_CONSULTAR: {
				consultarCliente();
				break;
			}
			case OPCAO_CLIENTE_ATUALIZAR: {
				atualizarCliente();
				
				break;
			}
			case OPCAO_CLIENTE_EXCLUIR: {
				excluirCliente();
				break;
			}
			case OPCAO_CLIENTE_RETORNAR: {
				Menu menu = new Menu();
				menu.apresentarMenu();
				break;
			}
			default:
				System.out.println("Opcão invalida");
				break;
			}
		opcao = this.apresentarOpcoesMenuCliente();	
		}
		
	}

	private void atualizarCliente() {
		System.out.println("\nQual o ID do cliente voce quer atualizar? ");
		int idCliente = Integer.parseInt(teclado.nextLine());
		System.out.println("\nOque voce deseja alterar?");
		System.out.println("1 - Nome");
		System.out.println("2 - Cpf");
		System.out.println("3 - Telefone");
		int escolha = Integer.parseInt(teclado.nextLine());
		System.out.println("Digite o novo parametro: ");
		String mudanca = teclado.nextLine();
		ControladoraCliente contrCliente = new ControladoraCliente();
		String resultado =  contrCliente.atualizarCliente(idCliente, escolha, mudanca);
		System.out.println(resultado);
		
	}

	private void consultarCliente() {
		System.out.println("\nEscolha o tipo de consulta:");
		System.out.println("1 - Consultar um cliente: ");
		System.out.println("2 - Consultar todos os clientes: ");
		System.out.println("3 - Voltar ao menur anterior: ");
		int opcao = Integer.parseInt(teclado.nextLine());
		ClienteVO clienteVO = new ClienteVO();
		switch(opcao) {
			case 1:{
				System.out.println("Informe o id: ");
				clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));			
				ControladoraCliente contrCliente = new ControladoraCliente();
				ClienteVO cliente = contrCliente.consultarCliente(clienteVO);
				if (cliente == null) {
					System.out.println("\nCliente não localizado.");
				}
				System.out.println("\n------ RESULTADO DA CONSULTA ------");
				System.out.println("");
				cliente.imprimir();
				break;
			}
			case 2:{
				ControladoraCliente contrCliente = new ControladoraCliente();
				ArrayList<ClienteVO> listaClientesVO = contrCliente.consultarTodosClientes();
				if(listaClientesVO.isEmpty()) {
					System.out.println("\nLista de Clientes não localizada.");
				}
				System.out.println("\n------ RESULTADO DA CONSULTA ------");
				System.out.printf("\n%3s   %-10s   %-15s   %-15s \n",
						"ID", "NOME", "CPF", "TELEFONE");
				for (int i = 0; i < listaClientesVO.size(); i++) {
					listaClientesVO.get(i).imprimir();
				}
				break;
			}
			case 3:{
				apresentarMenuCliente();
				break;
			}
			
		}
		consultarCliente();
	}

	private int apresentarOpcoesMenuCliente() {
		System.out.println("\nRevenda Ferro Velho");
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
	
	private void cadastrarCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.println("Digite o nome do cliente: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.println("Digite o  cpf: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.println("Digite o telefone: ");
		clienteVO.setTelefone(teclado.nextLine());
		
		ControladoraCliente contrCliente = new ControladoraCliente();
		contrCliente.cadastrarCliente(clienteVO);
		apresentarMenuCliente();
	}
	
	private void excluirCliente() {
		ClienteVO apClienteVO = new ClienteVO();
		System.out.println("\nDigite o codigo do cliente: ");
		apClienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));
		
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		String resultado = controladoraCliente.excluirCliente(apClienteVO);
		System.out.println(resultado);
		
	}
}
