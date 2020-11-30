package model.bo;

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
}
