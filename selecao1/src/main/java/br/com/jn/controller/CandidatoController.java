/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.controller;

import br.com.jn.dao.CandidatoDao;
import br.com.jn.dao.CandidatoDaoImp;
import br.com.jn.model.Candidato;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author josmar
 */
@ManagedBean
@SessionScoped
public class CandidatoController {
 private Candidato candidato;
private DataModel listaCandidatos;
 
public DataModel getListarCandidatos() {
List<Candidato> lista = new CandidatoDaoImp().list();
listaCandidatos = new ListDataModel(lista);
return listaCandidatos;
}
public Candidato getCandidato() {
return candidato;
}
public void setCandidato(Candidato candidato) {
this.candidato = candidato;
}
public String prepararAdicionarCandidato(ActionEvent actionEvent){
        candidato = new Candidato();
     return null;
    }

public void prepararAlterarCandidato(ActionEvent actionEvent){
        candidato = (Candidato)(listaCandidatos.getRowData());
     
    }


public String excluirCandidato(){
Candidato candidatoTemp = (Candidato)(listaCandidatos.getRowData());
CandidatoDao dao = new CandidatoDaoImp();
dao.remove(candidatoTemp);
return "index";
}
public String adicionarCandidato(){
CandidatoDao dao = new CandidatoDaoImp();
dao.save(candidato);
return "index";
}
public String alterarCandidato(){
CandidatoDao dao = new CandidatoDaoImp();
dao.update(candidato);
return "index";
}
}