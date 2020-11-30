package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.vo.ClienteVO;
import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class ClienteDAO {

	public String cadastarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		String query = "INSERT INTO cliente (nome, cpf, telefone) VALUES ('" 
		+ clienteVO.getNome() + "', '"
		+ clienteVO.getCpf() + "', '"
		+ clienteVO.getTelefone() + "')";
		try {
			stmt.executeUpdate(query);
			
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de cadastro do cliente.");
			e.printStackTrace();
		}finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return "Deu tudo certo no cadastro";
	}

	public ClienteVO consultarCliente(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ClienteVO clienteVo = new ClienteVO();
		String query = "SELECT nome, cpf, telefone FROM cliente"
				+ " WHERE idCliente = '" + clienteVO.getIdCliente() + "'";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				clienteVo.setNome(resultado.getString(1));
				clienteVo.setCpf(resultado.getString(2));
				clienteVo.setTelefone(resultado.getString(3));
					
			}
			
		}catch  (Exception e) {
			System.out.println("Erro ao executar a query de consultar veiculo por id.");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return clienteVo;
		
	}

}
