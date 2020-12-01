package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.ClienteVO;

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
		String query = "SELECT idCliente, nome, cpf, telefone FROM cliente"
				+ " WHERE idCliente = '" + clienteVO.getIdCliente() + "'";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				clienteVo.setIdCliente(Integer.parseInt(resultado.getString(1)));
				clienteVo.setNome(resultado.getString(2));
				clienteVo.setCpf(resultado.getString(3));
				clienteVo.setTelefone(resultado.getString(4));
					
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

	public ArrayList<ClienteVO> consultarTodosClientes() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ClienteVO> lista = new ArrayList<ClienteVO>();
		String query = "SELECT idCliente, nome, cpf, telefone FROM cliente";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setIdCliente(Integer.parseInt(resultado.getString(1)));
				cliente.setNome(resultado.getString(2));
				cliente.setCpf(resultado.getString(3));
				cliente.setTelefone(resultado.getString(4));
				lista.add(cliente);
			}
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de consultar todos os clientes.");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return lista;
	}

	public String excluirClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		@SuppressWarnings("unused")
		int resultado = 0;
		String query = "DELETE FROM cliente WHERE idCliente = " + clienteVO.getIdCliente() + ";";
		try {
			resultado = stmt.executeUpdate(query);
			
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de excluir cliente.");
			e.printStackTrace();
		}finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		
		return "Sucesso!";
	}

	public String atualizarClienteDAO(int idCliente, String escolha, String mudanca) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		@SuppressWarnings("unused")
		int resultado = 0;
		String query = "UPDATE cliente SET " + escolha + " = '" + mudanca  + "' WHERE idCliente = " + idCliente + ";";
		try {
			resultado = stmt.executeUpdate(query);
			
		}catch (Exception e) {
			System.out.println("Erro ao executar a query de atualizar cliente.");
			e.printStackTrace();
		}finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return "Foi né?";
	}

}
