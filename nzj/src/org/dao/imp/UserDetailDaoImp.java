package org.dao.imp;

import java.util.List;

import org.dao.UserDetailDao;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.UserDetail;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;
import org.view.VUser;

@Service
public class UserDetailDaoImp implements UserDetailDao {
	public long addUserDetail(UserDetail ud) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			long id = (Long) session.save(ud);
			ts.commit();

			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateUserDetail(UserDetail ud) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			session.update(ud);
			ts.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updatePhoto(long userId, String photourl) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("UPDATE UserDetail ud SET ud.photourl = ? WHERE ud.userId = ?");
			query.setParameter(0, photourl);
			query.setParameter(1, userId);
			query.executeUpdate();
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	@Override
	public boolean updateSupport (long userId, Integer support){
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("UPDATE UserDetail ud SET ud.support = ? WHERE ud.userId = ?");
			query.setParameter(0, support);
			query.setParameter(1, userId);
			query.executeUpdate();
			ts.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	@Override
	public UserDetail getUserDetail(String username) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from UserDetail where username=?");
			query.setParameter(0, username);
			query.setMaxResults(1);
			UserDetail ud = (UserDetail) query.uniqueResult();
			
			return ud;
		} catch (Exception e) {
			e.printStackTrace();
			return new UserDetail();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean getUserDetail(Long userId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from UserDetail where userId=?");
			query.setParameter(0, userId);
			query.setMaxResults(1);
			UserDetail ud = (UserDetail) query.uniqueResult();
			
			if(ud==null)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public UserDetail getUserDetailById(Long userId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from UserDetail where userId=?");
			query.setParameter(0, userId);
			query.setMaxResults(1);
			UserDetail ud = (UserDetail) query.uniqueResult();
			return ud;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean getUserDetailSupport(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("FROM VUser v WHERE v.id.id = ? AND v.id.support = ?");
			query.setParameter(0, id);
			query.setParameter(1, 0);
			query.setMaxResults(1);
			query.uniqueResult();
			//可以添加（未被服务过）
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<VUser> getUserDetailListBySupport(
			Integer start, Integer limit, Integer support) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("FROM VUser vu WHERE vu.id.support = ?");
			query.setParameter(0, support);
			if (start == null) {
				start = 0;
			}
			query.setFirstResult(start);
			if (limit == null) {
				limit = 15;
			}
			query.setMaxResults(limit);
			List<VUser> li = query.list();
			ts.commit();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long getCountBySupport(Integer support) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("SELECT COUNT(*) FROM VUser vu WHERE vu.id.support = ?");
			query.setParameter(0, support);
			query.setMaxResults(1);
			long count  = (Long)query.uniqueResult();
			ts.commit();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<VUser> getUserDetailListById(Long[] id) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM v_user vu WHERE vu.id = :id");
			sqlQuery.setParameterList("id", id, Hibernate.LONG);
			sqlQuery.addEntity(VUser.class);
			List<VUser> li = sqlQuery.list();
			ts.commit();
			return li;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}
