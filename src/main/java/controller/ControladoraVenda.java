package controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
	public String atualizarVenda(int idVenda, int escolha, String mudanca) {
		VendaBO vendaBO = new VendaBO();
		String campo = null;
		if (escolha == 1) {
			campo = "VALORVENDA";
		} else if (escolha == 2) {
			campo = "IDCLIENTE";
		} else{
			campo = "IDVEICULO";
		}
		return vendaBO.atualizarVendaBO(idVenda, campo, mudanca);
	}
	
	
}
