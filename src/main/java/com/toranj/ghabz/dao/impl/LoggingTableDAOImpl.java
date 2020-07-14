package com.toranj.ghabz.dao.impl;

import com.toranj.ghabz.dao.LoggingTableDAO;
import com.toranj.ghabz.entity.LoggingTable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(noRollbackFor = Throwable.class , propagation = Propagation.REQUIRES_NEW)
@Component("loggingTableDAO")
public class LoggingTableDAOImpl implements LoggingTableDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(LoggingTable loggingTable) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(loggingTable);
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }




    }

    @Override
    public LoggingTable findByID(String id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(LoggingTable.class);
            criteria.add(Restrictions.eq("id", id));
            return (LoggingTable) criteria.uniqueResult();
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;



    }
}
