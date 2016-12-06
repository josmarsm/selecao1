/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.controller;

import br.com.jn.dao.CandidatoDAO;
import br.com.jn.model.Candidato;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author josmar
 */

@ManagedBean(name = "candidatoBean")
@ViewScoped
public class CandidatoBean implements java.io.Serializable {
    
    private Candidato candidato;
    private List lista;
    private Integer id;
    
    public CandidatoBean() {
        this.candidato = new Candidato();
        this.lista = new CandidatoDAO().listar();
        this.id = 0;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    public Integer getIdCandidato() {
        return id;
    }

    public void setIdCandidato(Integer id) {
        this.id = id;
    }
    
    public void preparar(ActionEvent actionEvent) {
        this.candidato = new Candidato();
        this.lista = new CandidatoDAO().listar();
    }
    
    public void adicionar(ActionEvent actionEvent) {
        candidato.setNome(" ");
        new CandidatoDAO().adicionar(candidato);
        preparar(actionEvent);
    }
    
    public void editar(ActionEvent actionEvent) {
        new CandidatoDAO().editar(candidato);
        preparar(actionEvent);
    }
    
    public void excluir(ActionEvent actionEvent) {
        new CandidatoDAO().excluir(candidato);
        preparar(actionEvent);
    } 
}