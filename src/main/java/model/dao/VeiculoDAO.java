package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class VeiculoDAO {

	public boolean verificarResgistroPorPlaca(String placa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idveiculo FROM veiculo WHERE placa = '" + placa + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		}catch (Exception e) {
			System.out.println("Erro ao executar a query que verifica a existencia de veiculo por placa.");
			e.printStackTrace();
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO veiculo (modelo, tipo, fabricante, ano, cor, placa) VALUES ('" 
		+ veiculoVO.getModelo() + "', '"
		+ veiculoVO.getTipo() + "', '"
		+ veiculoVO.getFabricante() + "', "
		+ veiculoVO.getAno() + ", '"
		+ veiculoVO.getCor() + "', '"
		+ veiculoVO.getPlaca() + "')";
		try {
			resultado = stmt.executeUpdate(query);
			
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de cadastro do veiculo.");
			e.printStackTrace();
		}finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean verificarResgistroPorIdVeiculo(int idVeiculo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idveiculo FROM veiculo WHERE idveiculo = '" + idVeiculo + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		}catch (Exception e) {
			System.out.println("Erro ao executar a query que verifica a existencia de veiculo por id.");
			e.printStackTrace();
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirVeiculoDAO(VeiculoVO veiculoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELET FROM veiculo WHERE idveiculo = " + veiculoVO.getIdVeiculo() + ";";
		try {
			resultado = stmt.executeUpdate(query);
			
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de excluir veiculo.");
			e.printStackTrace();
		}finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		
		return resultado;
	}

	public int atualizarVeiculoDAO(VeiculoVO veiculoVO) {
		return 1;
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<VeiculoVO> lista = new ArrayList<VeiculoVO>();
		String query = "SELECT idveiculo, modelo, tipo, fabricante, ano, cor, placa FROM veiculo";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				VeiculoVO veiculo = new VeiculoVO();
				veiculo.setIdVeiculo(Integer.parseInt(resultado.getString(1)));
				veiculo.setModelo(resultado.getString(2));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString(3)));
				veiculo.setFabricante(resultado.getString(4));
				veiculo.setAno(Integer.parseInt(resultado.getString(5)));
				veiculo.setCor(resultado.getString(6));
				veiculo.setPlaca(resultado.getString(7));
				lista.add(veiculo);
			}
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de consultar todos os veiculos.");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return lista;
	}

	public VeiculoVO consultarVeiculoDAO(int idVeiculo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		VeiculoVO veiculo = new VeiculoVO();
		String query = "SELECT idveiculo, modelo, tipo, fabricante, ano, cor, placa FROM veiculo"
				+ " WHERE idVeiculo = " + idVeiculo + ";";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				veiculo.setIdVeiculo(Integer.parseInt(resultado.getString(1)));
				veiculo.setModelo(resultado.getString(2));
				veiculo.setTipo(TipoVeiculo.valueOf(resultado.getString(3)));
				veiculo.setFabricante(resultado.getString(4));
				veiculo.setAno(Integer.parseInt(resultado.getString(5)));
				veiculo.setCor(resultado.getString(6));
				veiculo.setPlaca(resultado.getString(7));	
			}
			
		}catch  (Exception e) {
			System.out.println("Erro ao executar a query de consultar veiculo por id.");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return veiculo;
		
	}

}
