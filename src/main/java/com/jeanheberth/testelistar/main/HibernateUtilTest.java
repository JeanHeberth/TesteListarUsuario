package com.jeanheberth.testelistar.main;

import org.hibernate.Session;

import com.jeanheberth.testelistar.util.HibernateUtil;


public class HibernateUtilTest {

    
    public void conectar(){
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        sessao.close();
        HibernateUtil.getFabricaDeSessoes().close();
    }
}	
