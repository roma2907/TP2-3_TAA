package domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import util.CustomReleaseSerializer;
@Entity
@Table(name="SPRINT")
public class Sprint {
	
	private Long id;
	private List<UserStory> userStory;
	private Release release;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="sprint",cascade=CascadeType.PERSIST)
	public List<UserStory> getUserStory() {
		return userStory;
	}
	public void setUserStory(List<UserStory> userStory) {
		this.userStory = userStory;
	}

	@ManyToOne
	@JsonSerialize(using = CustomReleaseSerializer.class)
	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}
}
