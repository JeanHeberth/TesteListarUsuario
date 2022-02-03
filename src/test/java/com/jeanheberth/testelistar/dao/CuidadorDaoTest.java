/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanheberth.testelistar.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jeanheberth.testelistar.domain.Cuidador;

/**
 *
 * @author Jean Heberth
 */
public class CuidadorDaoTest {

	@Test
	@Ignore
	public void salvar() {
		Cuidador cuidador = new Cuidador();

		cuidador.setNome("Teste nome cuidador");
		cuidador.setEndereco("Márcia ");

		CuidadorDao cuidadorDao = new CuidadorDao();
		cuidadorDao.salvar(cuidador);
		System.out.println("Salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {
		CuidadorDao cuidadorDao = new CuidadorDao();
		List<Cuidador> resultadoCuidador = cuidadorDao.listar();

		try {
			if (!resultadoCuidador.equals("")) {
				System.out.println("Total de Registros Encontrados: " + resultadoCuidador.size());
				for (Cuidador cuidador : resultadoCuidador) {
					System.out.println(cuidador.getCodigo() + " - " + cuidador.getNome());
				}
			} else {
				System.out.println("NÃo existem estados cadastrados");
			}
		} catch (RuntimeException erro) {
			throw erro;
		}

	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;
		CuidadorDao cuidadorDao = new CuidadorDao();
		Cuidador cuidador = cuidadorDao.buscar(codigo);

		if (cuidador != null) {
			System.out.println("Registro encontrados: ");
			System.out.println("Codigo: " + cuidador.getCodigo() + " Nome: " + cuidador.getNome());
		} else {
			System.out.println("Nenhum registro encontrado!");
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		CuidadorDao cuidadorDao = new CuidadorDao();
		Cuidador cuidador = cuidadorDao.buscar(codigo);

		if (cuidador != null) {
			cuidadorDao.excluir(cuidador);
			System.out.println("Registro removido!");
		} else {
			System.out.println("Nenhum registro encontrado!");
		}
	}


	@Test
	public void editar() {
		Long codigo = 17L;
		CuidadorDao cuidadorDao = new CuidadorDao();
		Cuidador cuidador = cuidadorDao.buscar(codigo);

		if (cuidador != null) {
			cuidador.setNome("Teste nome cuidador");
			cuidadorDao.editar(cuidador);
			System.out.println("Editado com sucesso!");
		} else {
			System.out.println("Nenhum registro encontrado!");
		}
	}

}
