/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jn.util;

/**
 *
 * @author josmar
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class EntityManagerUtil {
 
  private static final EntityManagerUtil instance = new EntityManagerUtil();
 
  private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SLPU");
 
  private EntityManagerUtil() {}
 
  public static EntityManagerUtil getInstance() {
    return instance;
  }
 
  public EntityManagerFactory getEntityManagerFactory() {
    return entityManagerFactory;
  }
 
  public EntityManager createEntityManager() {
    return entityManagerFactory.createEntityManager();
  }
}