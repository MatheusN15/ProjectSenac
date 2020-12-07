package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.VendaVO;

public class VendaDAO {

	public String cadastrarVendaDAO(VendaVO vendaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		@SuppressWarnings("unused")
		int resultado = 0;
		String query = "INSERT INTO venda (idcliente, idvenda, valorvenda, datavenda) VALUES (" 
		+ vendaVO.getIdCliente() + ", "
		+ vendaVO.getIdVenda() + ", "
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

	public ArrayList<VendaVO> consultarTodosVendasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<VendaVO> lista = new ArrayList<VendaVO>();
		String query = "SELECT idvenda, idcliente, idveiculo, valorvenda, datavenda FROM venda";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				VendaVO venda = new VendaVO();
				venda.setIdVenda(Integer.parseInt(resultado.getString(1)));
				venda.setIdCliente(Integer.parseInt(resultado.getString(2)));
				venda.setIdVeiculo(Integer.parseInt(resultado.getString(3)));
				venda.setValorVenda(Double.parseDouble(resultado.getString(4)));
				LocalDate dtVenda = LocalDate.parse(resultado.getString(5));
				venda.setDataVenda(dtVenda);
				lista.add(venda);
			}
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de consultar todos as vendas.");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return lista;
	}

	public VendaVO consultarVendaDAO(int idvenda) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		VendaVO venda = new VendaVO();
		String query = "SELECT idvenda, idcliente, idveiculo, valorvenda, datavenda FROM venda WHERE idVeiculo = " + idvenda + ";";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {	
				venda.setIdVenda(Integer.parseInt(resultado.getString(1)));
				venda.setIdCliente(Integer.parseInt(resultado.getString(2)));
				venda.setIdVeiculo(Integer.parseInt(resultado.getString(3)));
				venda.setValorVenda(Double.parseDouble(resultado.getString(4)));
				LocalDate dtVenda = LocalDate.parse(resultado.getString(5));
				venda.setDataVenda(dtVenda);
			}
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de consultar todos as vendas.");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return venda;
	}

}
