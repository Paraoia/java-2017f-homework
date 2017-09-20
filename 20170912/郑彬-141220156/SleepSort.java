
public class SleepSort {
        public static void main(String[] args) {
                int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
				SleepSort.sort(numbers);
				for(int n:numbers) {
					System.out.printf("%d  ", n);
				}
        }

		public static void sort(int[] nums) {
			Sleeper.idx = 0;
			Sleeper.output = new int[nums.length];

			for(int i = 0; i < nums.length; i ++) {
				new Sleeper(nums[i]).start();
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for(int i = 0; i < nums.length; i ++) {
				nums[i] = Sleeper.output[i];
			}
		}
}

class Sleeper extends Thread {
	public static int[] output;
	public static int idx;

	private int sleep_time;

	public Sleeper() {
		this.sleep_time = 0;
	}

	public Sleeper(int sleep_time) {
		this.sleep_time = sleep_time;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(this.sleep_time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		output[idx ++] = this.sleep_time;
	}
}
