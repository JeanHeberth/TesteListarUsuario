/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeanheberth.testelistar.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jean Heberth
 */
public class JSFUtil {

    public static void adicionarMessagemDeSucesso(String mensagem) {

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }

    public static void adicionarMensagemDeErro(String mensagem) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }

}
