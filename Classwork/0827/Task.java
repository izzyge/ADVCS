public class Task
{
	private String task;
	private int rank;
	public Task(String a, int b)
	{
		task = a;
		if(b>=-1)
		{
			rank = b;
		}
	}
	public String getTask()
	{
		return task;
	}
	public int getRank()
	{
		return rank;
	}
	public String toString()
	{
		return "Task: "+ task+" Rank: "+rank;
	}
}
