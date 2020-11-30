package controller;

import model.bo.ClienteBO;
import model.vo.ClienteVO;

public class ControladoraCliente {


	public void cadastrarCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.cadastrarVeiculoBO(clienteVO);
	}

	public ClienteVO consultarCliente(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.consultarCliente(clienteVO);
		
	}

}
