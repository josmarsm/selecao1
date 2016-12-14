/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.dao;

import br.com.jn.model.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author josmar
 */
public class UsersDAO {

    //@PersistenceContext(unitName = "SLPU")
    //private EntityManager em;
    public Boolean adicionar(Users users) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(users);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public Boolean editar(Users users) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(users);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public Boolean excluir(Users users) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(users);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public List<Users> listar() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        Object principal = a.getPrincipal();
        String username = "";
        username = (((User) a.getPrincipal()).getUsername());

        System.out.println("Username recuperado para recuperar o nome completo e o id {" + username + "}");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria crit = session.createCriteria(Users.class);

        crit.add(Restrictions.eq("username", username));

        List<Users> lista = crit.list();
        session.close();
        for (Users users : lista) {
            users.setUserId(users.getUserId());
            users.setNome(users.getNome());
            System.out.println("Id do Usuario: {" + users.getUserId() + "} Nome Complento: {" + users.getNome() + "}");
        }
        return lista;
    }

    public Users procuraUsuario() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria crit = session.createCriteria(Users.class);

        crit.add(Restrictions.eq("username", "alencar"));
        
        Users users = (Users) crit.uniqueResult();
        session.close();
        return users;
    }
}