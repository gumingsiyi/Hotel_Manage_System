package com.dao.impl;

import com.dao.BaseDAO;
import com.dao.OrderDAO;
import com.model.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by stiles on 15/12/30.
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO {
    @Override
    public boolean delete(String id) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("delete from Order where id='" + id + "'");
            query.executeUpdate();
            ts.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean save(Order order) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            session.save(order);
            ts.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Order order) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            session.update(order);
            ts.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Order findById(String id) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Order where id='" + id +"'");
            query.setMaxResults(1);
            Order order = (Order) query.uniqueResult();
            ts.commit();
            session.clear();
            session.close();
            return order;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean ifConflict(Order order) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            String hql = "from Order as o where (o.room=?) and ((o.start<" +order.getStart()+ " and o.end>" +order.getStart()+ ") " +
                    "or (o.end>"+order.getEnd()+" and o.start<"+order.getEnd()+")" +
                    " or (o.start>"+order.getStart()+" and o.end<"+order.getEnd()+"))" +
                    " or (o.start="+order.getStart()+") or (o.end="+order.getEnd()+")";
            Query query = session.createQuery(hql);
            query.setParameter(0, order.getRoom());
            query.setMaxResults(1);
            Order tOrder = (Order) query.uniqueResult();
            ts.commit();
            session.clear();
            session.close();
            return tOrder != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
