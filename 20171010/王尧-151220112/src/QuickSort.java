public class QuickSort implements Sorter{
	@Override
	public void sort(Queue queue) {
		int length = queue.getLength();
		quickSort(0, length - 1, queue);
				
	}
	
	private void quickSort(int left, int right, Queue queue) {
		if (left < right) {
			int mid = partition(left, right, queue);
			quickSort(left, mid - 1, queue);
			quickSort(mid + 1, right, queue);
		}
	}
	
	private int partition(int left, int right, Queue queue) {
		int splitPoint = left;
		Position pivot;
		pivot = queue.getPosition(left);
		for (int i = left + 1; i <= right; i++)
			if (((Comparable)(queue.getPosition(i).getHolder())).isBiggerThan((Comparable) pivot.getHolder()))
			{
				splitPoint ++;
				Creature tmp = queue.getPosition(splitPoint).getHolder();
				queue.getPosition(splitPoint).setHolder(queue.getPosition(i).getHolder());
				queue.getPosition(i).setHolder(tmp);
			}
		queue.getPosition(left).setHolder(queue.getPosition(splitPoint).getHolder());
		queue.getPosition(splitPoint).setHolder(queue.getPosition(left).getHolder());
		return splitPoint;
	}
}