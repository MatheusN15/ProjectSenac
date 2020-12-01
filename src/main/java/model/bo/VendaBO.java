package model.bo;

import model.dao.VendaDAO;
import model.vo.VendaVO;

public class VendaBO {

	public String cadastrarVendaBO(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.cadastrarVendaDAO(vendaVO);
	}

}
