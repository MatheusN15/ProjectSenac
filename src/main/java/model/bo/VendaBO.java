package model.bo;

import java.util.ArrayList;

import model.dao.VendaDAO;
import model.vo.VendaVO;

public class VendaBO {

	public String cadastrarVendaBO(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.cadastrarVendaDAO(vendaVO);
	}

	public ArrayList<VendaVO> cunsultarTodosVendasBO() {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.consultarTodosVendasDAO();
	}

	public VendaVO cunsultarVendaBO(int idvenda) {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.consultarVendaDAO(idvenda);
	}

	public String excluirVendaBO(VendaVO venda) {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.excluirVendaDAO(venda);
	}

	public String atualizarVendaBO(int idVenda, String campo, String mudanca) {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.atualizarVendaDAO(idVenda, campo, mudanca);
	}

}
