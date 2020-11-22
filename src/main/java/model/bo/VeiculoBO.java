package model.bo;

import java.util.ArrayList;

import model.dao.VeiculoDAO;
import model.vo.VeiculoVO;

public class VeiculoBO {

	public String cadastrarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		if(veiculoDAO.verificarResgistroPorPlaca(veiculoVO.getPlaca())) {
			retorno = "\nVeiculo já cadastrado no banco.";
		}else {
			int resultado = veiculoDAO.cadastrarVeiculoDAO(veiculoVO);
			if(resultado == 1) {
				retorno = "\nVeiculo cadastrado com sucesso.";
			}else {
				retorno = "\nNão foi possvel.";
			}
		}
		return retorno;
	}

	public String excluirVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		if(veiculoDAO.verificarResgistroPorIdVeiculo(veiculoVO.getIdVeiculo())) {
			int resultado = veiculoDAO.excluirVeiculoDAO(veiculoVO);
			if(resultado == 1) {
				retorno = "\nVeiculo excluido com sucesso.";
			}else {
				retorno = "\nNão foi possvel.";
			}
		}else {
			retorno = "\nVeiculo ainda nao cadastrado no banco.";
		}
		return retorno;
	}

	public String atualizarVeiculoBO(VeiculoVO veiculoVO) {
		String retorno;
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		if(veiculoDAO.verificarResgistroPorIdVeiculo(veiculoVO.getIdVeiculo())) {
			int resultado = veiculoDAO.atualizarVeiculoDAO(veiculoVO);
			if(resultado == 1) {
				retorno = "\nVeiculo atualizado com sucesso.";
			}else {
				retorno = "\nNão foi possvel.";
			}
		}else {
			retorno = "\nVeiculo ainda nao cadastrado no banco.";
		}
		return retorno;
	}

	public ArrayList<VeiculoVO> cunsultarTodosVeiculosBO() {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		return veiculoDAO.consultarTodosVeiculosDAO();
	}

	public VeiculoVO cunsultarVeiculoBO(VeiculoVO veiculoVO) {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		return veiculoDAO.consultarVeiculoDAO(veiculoVO);
	}



}
