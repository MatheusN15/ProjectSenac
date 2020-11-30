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
		ClienteBO veiculoBO = new ClienteBO();
		return veiculoBO.excluirClienteBO(clienteVO);
	}
}
