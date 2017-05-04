package com.megatech.domain.rest.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.megatech.domain.rest.model.Assets;

/**
 * @author karpov
 *
 */
@Repository
@Transactional
public class AssetDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public Assets getAssetById(int id) {
		Session session;
		session = sessionFactory.getCurrentSession();
		return session.get(Assets.class, id);
	}

	public List<Assets> getAllAssets() {
		Session session;
		List<Assets> assetList;
		try {
			session = sessionFactory.getCurrentSession();
			assetList = session.createQuery("from Assets").list();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
			assetList = session.createQuery("from Assets").list();
		}

		return assetList;
	}

	// public Assets getAssets(int id) {
	//
	// Session session = this.sessionFactory.getCurrentSession();
	// Assets assets = (Assets) session.load(Assets.class, new Integer(id));
	// return assets;
	// }
	//

	public Assets getAssets(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Assets assets = new Assets();
		try {
			assets = (Assets) session.get(Assets.class, id);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return assets;
	}

	public Assets addAssets(Assets assets) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(assets);
		return assets;
	}

	public boolean addAssets1(Assets assets) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(assets);
		return false;
	}

	public void updateAssets(Assets assets) {
		Session session = this.sessionFactory.getCurrentSession();
		// Session session = this.sessionFactory.openSession();
		session.saveOrUpdate(assets);
	}

	@Transactional
	public void updateAssets1(Assets assets) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Assets p = getAssetById(assets.getId());
		p.setAssetId(assets.getAssetId());
		p.setTags(assets.getTags());
		p.setTagValue(assets.getTagValue());
		session.saveOrUpdate(p);
		transaction.commit();
	}

	public void deleteAssets(int id) {
		// Session session = this.sessionFactory.getCurrentSession();
		// Assets p = (Assets) session.load(Assets.class, new Integer(id));
		// if (null != p) {
		// session.delete(p);
		// }

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Assets assets = new Assets();
		assets = (Assets) session.get(Assets.class, id);
		try {

			if (null != assets) {
				session.delete(assets);
			}
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		// return assets;

	}
}
