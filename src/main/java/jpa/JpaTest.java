package jpa;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.DaoProject;
import domain.Developper;
import domain.Project;
import domain.Release;
import domain.Sprint;
import domain.StateEnum;
import domain.Task;
import domain.Theme;
import domain.UserStory;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			createData(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		
		
		tx.begin();
		try {
			DaoProject dao = new DaoProject(manager);
//			Task task = dao.searchFirstTask();
//			manager.remove(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		
		manager.close();
		factory.close();
	}
	
	private static void createData(EntityManager manager){
		Theme th1 = new Theme();
		th1.setName("CSS");
		manager.persist(th1);
		Theme th2 = new Theme();
		th2.setName("Script");
		manager.persist(th2);
		Theme th3 = new Theme();
		th3.setName("Test unitaire");
		manager.persist(th3);
		Theme th4 = new Theme();
		th4.setName("Développement fonctionnel");
		manager.persist(th4);
		
		Developper developper = new Developper();
		developper.setName("Romain");
		Task t1 = new Task();
		t1.setDescription("création du modèle");
		Task t2 = new Task();
		t2.setDescription("mise en place des annotations");
		UserStory u1 = new UserStory();
		u1.setDescription("modélisation");
		u1.setTheme(th4);
		u1.setDevelopper(developper);
		u1.setEstimate(3);
		u1.setPriority(2);
		u1.setState(StateEnum.DOING);
		t1.setUserStory(u1);
		t2.setUserStory(u1);
		u1.setTheme(th1);
		u1.setTasks(new ArrayList<Task>());

		Sprint s1 = new Sprint();
		u1.setSprint(s1);
		s1.setUserStory(new ArrayList<UserStory>());
		s1.getUserStory().add(u1);
		
		Release release = new Release();
		release.setSprints(new ArrayList<Sprint>());
		release.getSprints().add(s1);
		Project projet = new Project();
		projet.setName("TP2TAA");
		s1.setRelease(release);
		projet.setReleases(new ArrayList<Release>());
		projet.getReleases().add(release);
		release.setProject(projet);
		
		manager.persist(projet);
		
	}

}
