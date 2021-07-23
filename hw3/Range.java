package hw3;

public class Range {
	
	int range;
	
	public Range(int x1, int y1, int x2, int y2)
	{
		double sum=Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);
		this.range=(int) Math.sqrt(sum);
	}
	
	public int getRange()
	{
		return this.range;
	}

}
