/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.dao;

import br.com.jn.model.Candidato;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
        }
        catch(HibernateException e) {
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
        }
        catch(HibernateException e) {
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
        }
        catch(HibernateException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List<Candidato> listar() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria crit = session.createCriteria(Candidato.class);
        crit.add(Restrictions.ge("notaEliminatoria", new Double(5));
        crit.addOrder(Order.asc("nome"));
        
        List<Candidato> lista = crit.list();
        session.close();
        return lista;
    }  
}