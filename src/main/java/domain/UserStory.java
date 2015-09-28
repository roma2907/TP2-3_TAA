package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import util.CustomDevelopperSerializer;
import util.CustomSprintSerializer;
import util.CustomUserStorySerializer;

@Entity
@Table 
public class UserStory{
	
	private Long id;
	private String description;
	private int estimate;
	private int restant;
	private int priority;
	private List<Task> tasks;
	private Theme theme;
	private Sprint sprint;
	private Epic epic;
	private Developper developper;
	private StateEnum state;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getEstimate() {
		return estimate;
	}
	
	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@OneToMany(mappedBy="userStory",cascade={CascadeType.PERSIST})
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@OneToOne
	@JoinColumn(name="THEME_ID", nullable=true)
	public Theme getTheme() {
		return theme;
	}
	
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@ManyToOne
	@JsonSerialize(using = CustomSprintSerializer.class)
	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@ManyToOne
	public Epic getEpic() {
		return epic;
	}

	public void setEpic(Epic epic) {
		this.epic = epic;
	}

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JsonSerialize(using = CustomDevelopperSerializer.class)
	public Developper getDevelopper() {
		return developper;
	}

	public void setDevelopper(Developper developper) {
		this.developper = developper;
	}

	@Enumerated(EnumType.STRING)
	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public int getRestant() {
		return restant;
	}

	public void setRestant(int restant) {
		this.restant = restant;
	}
}
