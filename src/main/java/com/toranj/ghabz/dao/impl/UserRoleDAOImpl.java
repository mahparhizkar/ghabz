package com.toranj.ghabz.dao.impl;

import com.toranj.ghabz.dao.UserRoleDAO;
import com.toranj.ghabz.entity.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.toranj.ghabz.utils.UserRole.*;


@Service
public class UserRoleDAOImpl implements UserRoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private int getMaxOrderNum() {
        try {
            String sql = "Select max(o.id) from " + Role.class.getName() + " o ";
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(sql);
            Integer value = (Integer) query.uniqueResult();
            if (value == null) {
                return 0;
            } else {
                return value;
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void save() {
        try {
            int i = getMaxOrderNum();
            if (i == 0) {
                Session session = sessionFactory.getCurrentSession();
                session.persist(new Role(ADMIN.value(), ADMIN.text(),new Date()));
                session.persist(new Role(COMMON.value(), COMMON.text(),new Date()));
                session.persist(new Role(POWER.value(), POWER.text(),new Date()));
                session.persist(new Role(SUPPORT.value(), SUPPORT.text(),new Date()));
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }

    @Override
    public Role findById(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq("id", id));
            return (Role) criteria.uniqueResult();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role findByName(String name) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq("name", name));
            return (Role) criteria.uniqueResult();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Role> roleList(){
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.ne("name", "ROLE_Admin"));
            return  criteria.list();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;
    }
}
