import javax.swing.JOptionPane;

public class Sort
{
	public static String display(int []list,int amount,int limit)
	{
		StringBuilder formation = new StringBuilder(amount * String.valueOf(limit).length());
		if (amount > 0)
			formation.append(String.valueOf(list[0]));
		for (int i = 1;i < amount;i ++)
			formation.append(", " + String.valueOf(list[i]));
		return formation.toString();
	}
	public static void main(String[] args)
	{
		final int ELEMENT_NUMBER = 10,ELEMENT_CEILING = 100;
		JOptionPane.showMessageDialog(null,"There are " + ELEMENT_NUMBER + " numbers to sort,\nall below " + ELEMENT_CEILING + ".","MySort",JOptionPane.INFORMATION_MESSAGE);
		int[] elementSet = new int[ELEMENT_NUMBER],elementSequence = new int[ELEMENT_NUMBER];
		for (int i = 0;i < ELEMENT_NUMBER;i ++)
		{
			elementSet[i] = (int)(Math.random() * ELEMENT_CEILING);
			int j = 0;
			while (true)
			{
				if (j >= i)
				{
					elementSequence[i] = elementSet[i];
					break;
				}
				if (elementSequence[j] == elementSet[i])
				{
					i --;
					break;
				}
				if (elementSequence[j] > elementSet[i])
				{
					for (int k = i;k > j;k --)
						elementSequence[k] = elementSequence[k - 1];
					elementSequence[j] = elementSet[i];
					break;
				}
				j ++;
			}
		}
		JOptionPane.showMessageDialog(null,"Before sorted they are\n" + display(elementSet,ELEMENT_NUMBER,ELEMENT_CEILING) + ".\nAfter sorted they are\n" + display(elementSequence,ELEMENT_NUMBER,ELEMENT_CEILING) + ".","MySort",JOptionPane.INFORMATION_MESSAGE);
	}
}
