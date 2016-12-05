/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.controller;

import br.com.jn.dao.UsersDao;
import br.com.jn.model.Users;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author josmar
 */
@ManagedBean
@SessionScoped
public class UsersController {
 private static final long serialVersionUID = 1L;
    private Users users;
    private UsersDao ad;
    private List<Users> UsersList;
    
    @PostConstruct
    public void init(){
        this.users = new Users();
        this.ad = new UsersDao();
        this.UsersList = ad.list();
    }
    public String newUsers(){
        return "manageUsers";
    }
    
    public String delete(Users users){
        ad.delete(users);
        return "users";
    }
    public String edit(Users users){
        this.users = users;
        return "manageUsers";
    }
    
    public String save() {
        ad.saveOrUpdate(users);
        this.users = new Users();
        return "users";
    }
    
    //Geters and seters
     
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
    public UsersDao getAd() {
        return ad;
    }
    public void setAd(UsersDao ad) {
        this.ad = ad;
    }
    public List<Users> getUsersList() {
        this.UsersList = ad.list();
        return UsersList;
    }
    public void setCandidatoList(List<Users> usersList) {
        UsersList = usersList;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}