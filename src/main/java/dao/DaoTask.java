package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import domain.Task;

public class DaoTask {
	private EntityManager em;

	public DaoTask(EntityManager entityManager) {
		em = entityManager;
	}

	public List<Task> findTasks() {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Task> query = builder.createQuery(Task.class);
		query.from(Task.class);
		return em.createQuery(query).getResultList();

	}

	public Task findTaskById(Long id) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Task> query = builder.createQuery(Task.class);
		Root<Task> root = query.from(Task.class);
		query.where(builder.equal(root.get("id"), id));
		return em.createQuery(query).getSingleResult();
	}
}
