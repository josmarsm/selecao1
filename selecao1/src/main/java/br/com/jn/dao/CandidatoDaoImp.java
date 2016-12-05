/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.dao;

import br.com.jn.model.Candidato;
import br.com.jn.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author josmar
 */
public class CandidatoDaoImp implements CandidatoDao {
 
public void save(Candidato candidato) {
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction t = session.beginTransaction();
session.save(candidato);
t.commit();
}
public Candidato getCandidato(int id) {
Session session = HibernateUtil.getSessionFactory().openSession();
return (Candidato) session.load(Candidato.class, id);
}
public List<Candidato> list() {
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction t = session.beginTransaction();
List lista = session.createQuery("select c from Candidato c").list();
t.commit();
return lista;
}
public void remove(Candidato candidato) {
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction t = session.beginTransaction();
session.delete(candidato);
t.commit();
}
public void update(Candidato candidato) {
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction t = session.beginTransaction();
session.update(candidato);
t.commit();
}
}