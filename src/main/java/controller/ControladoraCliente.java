package controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.bo.VeiculoBO;
import model.vo.ClienteVO;
import model.vo.VeiculoVO;


public class ControladoraCliente {


	public void cadastrarCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
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
