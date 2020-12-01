package model.dao;

import java.sql.Connection;
import java.sql.Statement;

import model.vo.VendaVO;

public class VendaDAO {

	public String cadastrarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO venda (idcliente, idveiculo, valorvenda, datavenda) VALUES (" 
		+ vendaVO.getIdCliente() + ", "
		+ vendaVO.getIdVeiculo() + ", "
		+ vendaVO.getValorVenda() + ", "
		+ " now())";
		try {
			resultado = stmt.executeUpdate(query);
			
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de cadastro da venda.");
			e.printStackTrace();
		}finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return "";
	}

}
