package domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project {
	
	private Long id;
	private String name;
	private List<Release> releases;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="project",cascade=CascadeType.PERSIST)
	public List<Release> getReleases() {
		return releases;
	}
	
	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
