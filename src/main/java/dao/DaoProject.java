package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import domain.Project;
import domain.Task;

public class DaoProject {
	private EntityManager em;
	
	public DaoProject(EntityManager entityManager){
		em=entityManager;
	}
	
	public List<Project> findProjects(){
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Project> query = builder.createQuery(Project.class);
		query.from(Project.class);
		return em.createQuery(query).getResultList();
		
	}
}
