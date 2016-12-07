/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.controller;

import br.com.jn.dao.UsersDAO;
import br.com.jn.model.Users;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author josmar
 */
@ManagedBean(name = "usersBean")
@ViewScoped
public class UsersBean implements Serializable {

    private Users users;
    private List lista;
    private Integer id;

    public UsersBean() {
        this.users = new Users();
        this.lista = new UsersDAO().listar();
        this.id = 0;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Users> getLista() {
           return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    public Integer getIdUsers() {
        return id;
    }

    public void setIdUsers(Integer id) {
        this.id = id;
    }

    public void preparar(ActionEvent actionEvent) {
        this.users = new Users();
        this.lista = new UsersDAO().listar();
    }

    public void adicionar(ActionEvent actionEvent) {
        users.setNome(" ");
        new UsersDAO().adicionar(users);
        preparar(actionEvent);
    }

    public void editar(ActionEvent actionEvent) {
        new UsersDAO().editar(users);
        preparar(actionEvent);
    }

    public void excluir(ActionEvent actionEvent) {
        new UsersDAO().excluir(users);
        preparar(actionEvent);
    }
}