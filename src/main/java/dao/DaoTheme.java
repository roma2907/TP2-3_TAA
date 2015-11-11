package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import domain.Project;
import domain.Theme;

public class DaoTheme {

	private EntityManager em;
	
	public DaoTheme(EntityManager pEm){
		em=pEm;
	}
	
	public List<Theme> findThemes() {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Theme> query = builder.createQuery(Theme.class);
		query.from(Theme.class);
		return em.createQuery(query).getResultList();

	}

	public Theme findThemeById(Long id) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Theme> query = builder.createQuery(Theme.class);
		Root<Theme> root = query.from(Theme.class);
		query.where(builder.equal(root.get("id"), id));
		return em.createQuery(query).getSingleResult();
	}
}
