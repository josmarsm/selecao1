/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.dao;

import br.com.jn.model.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author josmar
 */
public class UsersDao {

    public void saveOrUpdate(Users users) {
        EntityManager em = br.com.jn.util.EntityManagerUtil.getInstance().createEntityManager();

        try {
            em.getTransaction().begin();
            if (users.getUserId()== null) {
                em.persist(users);
            } else {
                em.merge(users);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void delete(Users users) {
        EntityManager em = br.com.jn.util.EntityManagerUtil.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            Users us = em.find(Users.class, users.getUserId());
            em.remove(us);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public List<Users> list() {
        List<Users> result = null;
        try {
            EntityManager em = br.com.jn.util.EntityManagerUtil.getInstance().createEntityManager();
            Query query = em.createQuery("select u FROM Users u where u.username =:username");
            query.setParameter("username", "admin");
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }        
}