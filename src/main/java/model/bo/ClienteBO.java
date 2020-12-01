package model.bo;

import java.util.ArrayList;


import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO {


	public void cadastrarVeiculoBO(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.cadastarClienteDAO(clienteVO);
		
	}

	public ClienteVO consultarCliente(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultarCliente(clienteVO);
		
	}


	public ArrayList<ClienteVO> cunsultarTodosClientesBO() {
		ClienteDAO clientesDAO = new ClienteDAO();
		return clientesDAO.consultarTodosClientes();
	}

	public String excluirClienteBO(ClienteVO clienteVO) {
		ClienteDAO clientesDAO = new ClienteDAO();
		return clientesDAO.excluirClienteDAO(clienteVO);
	}

	public String atualizarClienteBO(int idCliente, String escolha, String mudanca) {
		ClienteDAO clientesDAO = new ClienteDAO();
		return clientesDAO.atualizarClienteDAO(idCliente, escolha, mudanca);
	}
}
