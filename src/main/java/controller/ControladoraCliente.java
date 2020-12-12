package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.bo.ClienteBO;
import model.vo.ClienteVO;


public class ControladoraCliente {
	Scanner teclado = new Scanner(System.in);

	public void cadastrarCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		if (clienteVO.getCpf().length() > 11) {
			System.out.println("Cpf deve contem 11 digitos ou menos");
			clienteVO.setCpf(teclado.nextLine());
		}
		clienteBO.cadastrarVeiculoBO(clienteVO);
	}

	public ClienteVO consultarCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.consultarCliente(clienteVO);
		
	}

	public ArrayList<ClienteVO> consultarTodosClientes() {
		ClienteBO veiculoBO = new ClienteBO();
		return veiculoBO.cunsultarTodosClientesBO();
	}

	public String excluirCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.excluirClienteBO(clienteVO);
	}

	public String atualizarCliente(int idCliente, int escolha, String mudanca) {
		ClienteBO veiculoBO = new ClienteBO();
		String campo = "";
		switch (escolha) {
			case 1:
				campo = "nome";
				break;
			case 2:
				campo = "cpf";
				break;
			case 3:
				campo = "telefone";
				break;
		}
		return veiculoBO.atualizarClienteBO(idCliente, campo, mudanca);
	}
}
