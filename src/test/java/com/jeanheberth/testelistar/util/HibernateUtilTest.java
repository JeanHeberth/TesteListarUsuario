package com.jeanheberth.testelistar.util;
        
import org.hibernate.Session;

public class HibernateUtilTest {


	public static void main(String[] args) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		
		
	}

}
