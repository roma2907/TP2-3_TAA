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

import util.CustomProjectSerializer;
import util.CustomReleaseSerializer;

@Entity
@Table(name="RELEASE")
public class Release {
	
	private Long id;
	private List<Sprint> sprints;
	private Project project;
	
	@OneToMany(mappedBy="release",cascade=CascadeType.PERSIST)
	public List<Sprint> getSprints() {
		return sprints;
	}
	public void setSprints(List<Sprint> sprint) {
		this.sprints = sprint;
	}
	
	@ManyToOne
	@JsonSerialize(using = CustomProjectSerializer.class)
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
