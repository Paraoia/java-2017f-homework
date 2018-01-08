public class Queue {

	private Position[] positions;

	public Queue(int queueLen) {
		positions = new Position[queueLen];
		for (int i = 0; i < queueLen; i++) {
			positions[i] = new Position();
			positions[i].holder = null;
		}
	}

	/** 占位 */
	public void seizeSeat(Huluwa[] huluwa) {
		positions[0].holder = null;
		positions[1].holder = huluwa[3];
		positions[2].holder = huluwa[5];
		positions[3].holder = huluwa[2];
		positions[4].holder = huluwa[1];
		positions[5].holder = huluwa[6];
		positions[6].holder = huluwa[0];
		positions[7].holder = huluwa[4];
	}

	/** 冒泡排序 */
	public void bubbleSort() {
		for (int i = 1; i < positions.length; i++) {
			for (int j = 1; j < positions.length - i; j++) {
				if (positions[j].holder.getRank() > positions[j + 1].holder.getRank()) {
					positions[0] = positions[j];

					positions[j] = positions[j + 1];
					positions[j + 1].holder.report(positions[j + 1].holder, j + 1, j);

					positions[j + 1] = positions[0];
					positions[j].holder.report(positions[j].holder, j, j + 1);
				}
			}
		}

		for (int i = 1; i < positions.length; i++) {
			positions[i].holder.reportRank(positions[i].holder);
		}

	}

	/** 二分法搜索 */
	public void binarySort(int left, int right) {
		int low, middle, high;

		for (int i = left + 1; i <= right; i++) {
			positions[0] = positions[i];
			low = left;
			high = i - 1;

			while (low <= high) {
				middle = (low + high) / 2;
				if (positions[i].holder.getRank() < positions[middle].holder.getRank()) {
					high = middle - 1;
				} else {
					low = middle + 1;
				}
			}

			for (int j = i - 1; j >= low; j--) {
				positions[j + 1] = positions[j];
				positions[j].holder.report(positions[j].holder, j, j + 1);
			}

			positions[low] = positions[0];
			positions[i].holder.report(positions[i].holder, i, low);

		}

		for (int i = 1; i < positions.length; i++) {
			positions[i].holder.reportColor(positions[i].holder);
		}
	}
}
