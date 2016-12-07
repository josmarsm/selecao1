/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.dao;

import br.com.jn.model.Candidato;
import br.com.jn.model.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.context.SecurityContext;

/**
 *
 * @author josmar
 */
@Stateless
public class UsersDAO {

    @PersistenceContext(unitName = "SLPU")
    private EntityManager em;

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
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria crit = session.createCriteria(Users.class);        
        crit.addOrder(Order.asc("nome"));
        
        List<Users> lista = crit.list();
        session.close();
        return lista;
    }
}
