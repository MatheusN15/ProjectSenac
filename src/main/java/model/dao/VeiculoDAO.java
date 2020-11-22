package model.dao;

import java.util.ArrayList;

import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class VeiculoDAO {

	public boolean verificarResgistroPorPlaca(String placa) {
		
		return false;
	}

	public int cadastrarVeiculoDAO(VeiculoVO veiculoVO) {
		return 1;
	}

	public boolean verificarResgistroPorIdVeiculo(int idVeiculo) {
		return true;
	}

	public int excluirVeiculoDAO(VeiculoVO veiculoVO) {
		return 1;
	}

	public int atualizarVeiculoDAO(VeiculoVO veiculoVO) {
		return 1;
	}

	public ArrayList<VeiculoVO> consultarTodosVeiculosDAO() {
		ArrayList<VeiculoVO> lista = new ArrayList<VeiculoVO>();
		VeiculoVO veiculo1 = new VeiculoVO(1, "Gol", TipoVeiculo.CARRO, "VW", 2010, "Branco", "MML-1234");
		VeiculoVO veiculo2 = new VeiculoVO(1, "Gol", TipoVeiculo.CARRO, "VW", 2010, "Branco", "MML-1234");
		VeiculoVO veiculo3 = new VeiculoVO(1, "Gol", TipoVeiculo.SUV, "VW", 2010, "Branco", "MML-1234");
		VeiculoVO veiculo4 = new VeiculoVO(1, "Gol", TipoVeiculo.MOTO, "VW", 2010, "Branco", "MML-1234");
		lista.add(veiculo1);
		lista.add(veiculo2);
		lista.add(veiculo3);
		lista.add(veiculo4);
		return lista;
	}

	public VeiculoVO consultarVeiculoDAO(VeiculoVO veiculoVO) {
		VeiculoVO veiculo = new VeiculoVO(1, "Gol", TipoVeiculo.CARRO, "VW", 2010, "Branco", "MML-1234");
		return veiculo;
	}

}
