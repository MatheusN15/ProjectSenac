package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.bo.VendaBO;
import model.bo.VendaBO;
import model.vo.VendaVO;

public class ControladoraVenda {
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public String cadastrarVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.cadastrarVendaBO(vendaVO);
		
	}
	public String excluirrVendaController(VendaVO vendaVo) {
		return "Ok";
		
	}
	public String atualizarVendaController(VendaVO vendaVo) {
		return "Ok";
		
	}
	
	public ArrayList<VendaVO> consultarTodasVendasController() {
		ArrayList<VendaVO> lista = new ArrayList<VendaVO>();
		VendaVO venda1 = new VendaVO(1,1,2,200.00,LocalDate.parse("22/10/2020", dataFormatter));
		VendaVO venda2 = new VendaVO(1,1,2,200.00,LocalDate.parse("22/10/2020", dataFormatter));
		VendaVO venda3 = new VendaVO(1,1,2,200.00,LocalDate.parse("22/10/2020", dataFormatter));
		lista.add(venda1);
		lista.add(venda2);
		lista.add(venda3);
		return lista;	
	}
	
	public VendaVO consultarVendaController(VendaVO vendaVo) {
		VendaVO venda = new VendaVO(1,1,2,200.00,LocalDate.parse("22/10/2020", dataFormatter));
		return venda;
		
	}
	public ArrayList<VendaVO> consultarTodosVendas() {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.cunsultarTodosVendasBO();
	}
	public VendaVO consultarVenda(int idvenda) {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.cunsultarVendaBO(idvenda);
	}
	public String excluirVenda(VendaVO venda) {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.excluirVendaBO(venda);
	}
	
	
}
