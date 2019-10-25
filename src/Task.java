//Matt Lynn
public class Task
{
private String name;
private String description;
private String dueDate;
private Boolean completed;
	
	public Task()
	{
		name = "Unassigned";
		description = "No description entered";
		dueDate = "Not set";
		completed = false;
		
		
		
	}
	
	public Task(String name, String description, String dueDate)
	{
		completed = false;
		
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
		getName();
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
		getDescription();
	}
	
	public String getDueDate()
	{
		return dueDate;
	}
	
	public void setdueDate(String dueDate)
	{
		this.dueDate = dueDate;
		getDueDate();
	}
	
	public Boolean getCompleted()
	{
		return completed;
	}
	
	public void setCompleted(Boolean completed)
	{
		this.completed = completed;
		getCompleted();
	}
	
@Override
	
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s", completed, dueDate, name, description);
}
	
	
	

}
