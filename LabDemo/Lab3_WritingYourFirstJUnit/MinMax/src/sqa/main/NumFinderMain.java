package sqa.main;

public class NumFinderMain {

	public static void main(String[] args) {
		
		MinMax minmax = new MinMax();
		
		//SolutionMinMax minmax = new SolutionMinMax();
		
		minmax.find(new int[] {4, 25, 7, 9});
		//minmax.find(new int[] {4, 3, 2, 1});
		
		System.out.println(minmax.getMax());
		System.out.println(minmax.getMin());
	}
}
