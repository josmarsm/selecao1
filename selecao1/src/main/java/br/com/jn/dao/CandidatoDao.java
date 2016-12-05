/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.dao;

import br.com.jn.model.Candidato;
import br.com.jn.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author josmar
 */
public interface CandidatoDao {

 
public void save(Candidato candidato);
public Candidato getCandidato(int id);
public List<Candidato> list();
public void remove(Candidato candidato);
public void update(Candidato candidato);
 
}