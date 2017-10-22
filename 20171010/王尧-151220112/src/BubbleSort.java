public class BubbleSort implements Sorter{
	@Override
	public void sort(Queue queue) {
		int length = queue.getLength();
		for (int i = 0; i < length - 1; i++)
			for (int j = 0; j < length - i - 1; j++)
				if (! ((Comparable)(queue.getPosition(j).getHolder())).isBiggerThan((Comparable) (queue.getPosition(j + 1).getHolder())) ) {
					Creature tmp = queue.getPosition(j).getHolder();
					queue.getPosition(j).setHolder(queue.getPosition(j + 1).getHolder());
					queue.getPosition(j + 1).setHolder(tmp);
				}
	}
}
