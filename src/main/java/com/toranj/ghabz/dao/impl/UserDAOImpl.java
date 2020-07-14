package com.toranj.ghabz.dao.impl;

import com.toranj.ghabz.dao.UserDAO;
import com.toranj.ghabz.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Transactional
@Component("userDAO")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            this.sessionFactory.getCurrentSession().persist(user);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getCause() + " happened!");
            e.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", username));
            return (User) criteria.uniqueResult();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getCause() + " happened!");
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<User> getUsers() {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<User> users = session.createCriteria(com.toranj.ghabz.entity.User.class).list();
            return users;
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        try {
            this.sessionFactory.getCurrentSession().merge(user);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getUsersForAdmin() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(User.class);
            List<User> users = criteria.add(Restrictions.or(Restrictions.eq("fkUserRole", "ROLE_Power"),
                    Restrictions.eq("fkUserRole", "ROLE_Support"),
                    Restrictions.eq("fkUserRole", "ROLE_Common"),
                    Restrictions.eq("fkUserRole", "ROLE_Dentist"))).list();
            return users;
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public List<User> getUsersForPowerUser() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(User.class);
            List<User> users = criteria.add(Restrictions.or(Restrictions.eq("fkUserRole", "ROLE_Support"),
                    Restrictions.eq("fkUserRole", "ROLE_Common"))).list();
            return users;
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<User> getUsersForSupportUser() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = (Criteria) session.createCriteria(User.class);
            List<User> users = criteria.add(Restrictions.eq("fkUserRole", "ROLE_Common")).list();
            return users;
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;

    }

    public String getUserNewShenase() {
        try {
            String sql = "Select max(o.shenase) from " + User.class.getName() + " o ";
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(sql);
            String value = (String) query.uniqueResult();
            String s = String.valueOf(Integer.valueOf(value) + 1);
            if (value == null) {
                return "10001";
            } else {
                return s;
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List getUserReport(Date startCreationDate, Date endCreationDate, Date startBirthDate, Date endBirthDate,
                              String shenase, String national_id, String fk_user_role, String family, String name, String mobile_number) {
        try {
            String sqlString = "SELECT u.shenase,u.fk_user_role,u.creationDate," +
                    "n.birth_date,n.family,n.name,n.mobile_number,n.national_id FROM tb_user u " +
                    "inner join tb_natural_person n on u.fk_person = n.id  " +
                    "WHERE (u.fk_user_role <> 'ROLE_Admin') ";

                if ((startCreationDate != null) && (endCreationDate != null)) {
                    java.sql.Date sqlStartCreationDate = new java.sql.Date(startCreationDate.getTime());
                    java.sql.Timestamp sqlEndCreationDate = new java.sql.Timestamp(endCreationDate.getTime());
                    sqlString += "AND (u.creationDate BETWEEN  '" + sqlStartCreationDate + "' AND '" + sqlEndCreationDate + "') ";
                }
                if (!(startBirthDate == null) && !(endBirthDate == null)) {
                    java.sql.Date sqlStartBirthDate = new java.sql.Date(startBirthDate.getTime());
                    java.sql.Timestamp sqlEndBirthDate = new java.sql.Timestamp(endBirthDate.getTime());
                    sqlString += "(n.birth_date BETWEEN  '" + sqlStartBirthDate + "' AND '" + sqlEndBirthDate + "') ";
                }
                if (shenase != null)
                    if (!shenase.equals("")) {
                        sqlString += "AND (u.shenase = '" + shenase + "') ";
                    }
                if (fk_user_role != null)
                    if (!fk_user_role.equals("")) {
                        sqlString += "AND  (u.fk_user_role = '" + fk_user_role + "') ";
                    }

                if (family != null)
                    if (!family.equals("")) {
                        sqlString += "AND  (n.family = '" + family + "') ";
                    }

                if (name != null)
                    if (!name.equals("")) {
                        sqlString += "AND (n.name = '" + name + "') ";

                    }

                if (mobile_number != null)
                    if (!mobile_number.equals("")) {
                        sqlString += "AND (n.mobile_number = '" + mobile_number + "') ";
                    }

                if (national_id != null)
                    if (!national_id.equals("")) {
                        sqlString += "AND (n.national_id = '" + national_id + "') ";
                    }
            sqlString += "ORDER BY u.shenase ASC ";
            List<Object[]> userReports = entityManager.createNativeQuery(sqlString).getResultList();

            return userReports;
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;
    }

}
