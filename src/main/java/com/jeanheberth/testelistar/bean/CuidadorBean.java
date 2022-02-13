/*
z * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanheberth.testelistar.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.primefaces.component.radiobutton.RadioButton;

import com.jeanheberth.testelistar.dao.CuidadorDao;
import com.jeanheberth.testelistar.domain.Cuidador;
import com.jeanheberth.testelistar.util.JSFUtil;

/**
 *
 * @author Jean Heberth
 */
@ManagedBean(name = "MBCuidador")
@ViewScoped
public class CuidadorBean implements Serializable {

	/**
	 *
	 */
	

	private Cuidador cuidador = new Cuidador();
	private ListDataModel<Cuidador> cuidadores;
	private ListDataModel<Cuidador> itensCuidadores;

	public Cuidador getCuidador() {
		return cuidador;
	}

	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

	public ListDataModel<Cuidador> getCuidadores() {
		return cuidadores;
	}

	public void setCuidadores(ListDataModel<Cuidador> cuidadores) {
		this.cuidadores = cuidadores;
	}

	public ListDataModel<Cuidador> getItensCuidadores() {
		return itensCuidadores;
	}

	public void setItensCuidadores(ListDataModel<Cuidador> itensCuidadores) {
		this.itensCuidadores = itensCuidadores;
	}

	public void salvar() {

		try {
			if (!cuidador.getNome().equals("")) {

				CuidadorDao cuidaDao = new CuidadorDao();
				cuidaDao.salvar(cuidador);

				ArrayList<Cuidador> lista = (ArrayList<Cuidador>) cuidaDao.listar();
				cuidadores = new ListDataModel<Cuidador>(lista);
				JSFUtil.adicionarMessagemDeSucesso("Cuidador salvo com sucesso!");

			} else {
				JSFUtil.adicionarMensagemDeErro("Nome não pode ser vazio!");
			}

		} catch (

		Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}

	}

	@PostConstruct
	public void preparPesquisa() {
		try {
			CuidadorDao cuidaDao = new CuidadorDao();
			ArrayList<Cuidador> listaCuidadores = (ArrayList<Cuidador>) cuidaDao.listar();
			cuidadores = new ListDataModel<Cuidador>(listaCuidadores);
		} catch (Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemDeErro(ex.getMessage());
		}
	}

	public void preparaNovoCadastro() {
		cuidador = new Cuidador();
	}

	public void prepararExcluir() {

		cuidador = cuidadores.getRowData();

	}

	public void excluir() {

		CuidadorDao cuidaDao = new CuidadorDao();
		cuidaDao.excluir(cuidador);

		ArrayList<Cuidador> listaCuidadores = (ArrayList<Cuidador>) cuidaDao.listar();
		cuidadores = new ListDataModel<>(listaCuidadores);
		JSFUtil.adicionarMessagemDeSucesso("Cuidador excluído com sucesso!");
	}

	public void prepararEditar() {
		cuidador = cuidadores.getRowData();
	}

	public void editar() {

		try {
			CuidadorDao cuidaDao = new CuidadorDao();
			cuidaDao.editar(cuidador);

			ArrayList<Cuidador> listaCuidadores = (ArrayList<Cuidador>) cuidaDao.listar();
			cuidadores = new ListDataModel<Cuidador>(listaCuidadores);
			JSFUtil.adicionarMessagemDeSucesso("Cuidador alterado com sucesso!");

		} catch (Exception ex) {
			ex.printStackTrace();
	
			
	}

		 
}
	public void selecionaSexo() {
		
		if (cuidador.getSexo().toString().equals("Masculino")) {
			
			
		}
	}
}