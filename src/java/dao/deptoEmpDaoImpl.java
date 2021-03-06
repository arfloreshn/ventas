/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.TdeptoEmp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author root
 */
public class deptoEmpDaoImpl implements deptoEmpDao {

    private TdeptoEmp depto;
    private List<TdeptoEmp> listar;

    private Session session;
    private Transaction trans;

    @Override
    public List<TdeptoEmp> lstdep() {
        Session session = HibernateUtil.getSession();

        String sql = "FROM TdeptoEmp";
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            listar = session.createQuery(sql).list();
            tx.commit();

            //    session.beginTransaction().commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                listar = null;
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return listar;

    }

    @Override
    public boolean crearDepto(TdeptoEmp depto) {
        boolean flag = false;

        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            session.save(depto);
            trans.commit();
            flag = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            trans.rollback();
            throw ex;
        } finally {
            // Si la session esta abierta la cierro
            if (session != null) {
                session.close();
            }

        }

        return flag;
    }

    @Override
    public boolean editarDepto(TdeptoEmp depto) {
        boolean flag = false;

        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            session.update(depto);
            trans.commit();
            flag = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            trans.rollback();
            throw ex;
        } finally {
            // Si la session esta abierta la cierro
            if (session != null) {
                session.close();
            }

        }

        return flag;

    }

    @Override
    public boolean borrarDepto(Integer id) {
      boolean flag = false;
        try {
			session = HibernateUtil.getSession();
			trans = session.beginTransaction();
                        TdeptoEmp depto = (TdeptoEmp) session.load(TdeptoEmp.class, id);
                        session.delete(depto);
			trans.commit();
                        flag=true;
		} catch (Exception ex) {
                        System.out.println(ex.getMessage());
			trans.rollback();
                        throw ex;
		} finally {
	
                  // Si la session esta abierta la cierro
                 if (session!= null) 
                    {
                        session.close();
                    }

        }
        return flag;

    
    }

}
