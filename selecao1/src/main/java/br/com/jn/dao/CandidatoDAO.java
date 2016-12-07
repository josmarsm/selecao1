
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.dao;

import br.com.jn.model.Candidato;
import br.com.jn.model.Users;
import static com.sun.faces.facelets.util.Path.context;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author josmar
 */
public class CandidatoDAO {

    public Boolean adicionar(Candidato candidato) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(candidato);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public Boolean editar(Candidato candidato) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(candidato);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public Boolean excluir(Candidato candidato) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(candidato);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public List<Candidato> listar() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        //Authentication authentication = context.getAuthentication();
        Object principal = a.getPrincipal();
        String username = "";
        username = (((User) a.getPrincipal()).getUsername());
        //username = ((UserDetails) principal).getUsername();
        System.out.println("login selecionado:" + username);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String sql = "select * from users where username = :username";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Users.class);
        query.setParameter("username", username);
        //Users usuario = (Users) query.uniqueResult();
        List logado = query.list();
        //List<Users> results = query.getResultList();
        
        

        String UserId = logado.get(0).toString();
        String usuario = "4";
        //System.out.println("Id do usuario selecionado:" + usuario.getUserId());
        //System.out.println("Id do usuario selecionado:" + usuario.getNome());
        
        //Integer UserId = usuario.getUserId();
        System.out.println("Id do usuario selecionado:" + UserId);

        Criteria crit = session.createCriteria(Candidato.class);
        crit.add(Restrictions.ge("notaEliminatoria", (5.0)));
        crit.add(Restrictions.eq("orientador1", username));
        crit.addOrder(Order.asc("nome"));

        List<Candidato> lista = crit.list();
        session.close();
        return lista;
    }

    public List<Candidato> listarCalculada() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from candiato").list();
        t.commit();
        return lista;
    }
}
