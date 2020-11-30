package view;

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

	private void consultarCliente() {
		System.out.println("Escolha o tipo de consulta:");
		System.out.println("1 - Consultar um cliente: ");
		System.out.println("2 - Consultar todos os clientes: ");
		int opcao = Integer.parseInt(teclado.nextLine());
		ClienteVO clienteVO = new ClienteVO();
		if (opcao == 1) {
			System.out.println("Informe o id: ");
			clienteVO.setIdCliente(Integer.parseInt(teclado.nextLine()));			
			ControladoraCliente contrCliente = new ControladoraCliente();
			ClienteVO cliente = contrCliente.consultarCliente(clienteVO);
			if (cliente == null) {
				System.out.println("\nVeiculo não localizado.");
			}
			System.out.println("\n------ RESULTADO DA CONSULTA ------");
			System.out.println("");
			cliente.imprimir();
		}else if (opcao == 2) {
			
		}else {
			
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
}
