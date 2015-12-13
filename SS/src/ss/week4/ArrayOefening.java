package ss.week4;
import java.*;

public class ArrayOefening {
	private int aantal;
	private int tijdelijk;

//	13.1
	public int getNegative(int[] array)	{
		aantal = 0;
		for (int i = 0; i < array.length; i++)	{
			if (array[i] < 0)	{
				aantal++;
			}
		}
		return aantal;
	}
	
//	13.2
	public int[] reverse(int[] array)	{
		for (int i = 0; i < array.length/2; i++)	{
			tijdelijk = array[i];
			array[i] = array[array.length - 1];
			array[array.length - 1] = tijdelijk;
		}
		return array;
	}
}