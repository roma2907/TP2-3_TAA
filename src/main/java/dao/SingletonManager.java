package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SingletonManager {

	private static SingletonManager instance;
	private EntityManager manager;
	
	private SingletonManager(EntityManager pManager){
		manager = pManager;
	}
	
	public static  SingletonManager getInstance(){
		if(instance == null){
			instance = new SingletonManager(Persistence
					.createEntityManagerFactory("dev").createEntityManager() ) ;
		}
		return instance;
	}
	
	public EntityManager getManager(){
		return manager;
	}
}
