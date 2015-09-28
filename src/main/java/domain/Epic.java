package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EPIC")
public class Epic{

	private Long id;
	private List<UserStory> userStory;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="epic")
	public List<UserStory> getUserStory() {
		return userStory;
	}
	public void setUserStory(List<UserStory> userStory) {
		this.userStory = userStory;
	}
}
