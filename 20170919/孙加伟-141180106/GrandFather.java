public class GrandFather {

	public static void main(String[] args) {

		Huluwa[] huLuWa = new Huluwa[7];

		huLuWa[0] = new Huluwa("红娃", Color.RED, 1);
		huLuWa[1] = new Huluwa("橙娃", Color.ORANGE, 2);
		huLuWa[2] = new Huluwa("黄娃", Color.YELLOW, 3);
		huLuWa[3] = new Huluwa("绿娃", Color.GREEN, 4);
		huLuWa[4] = new Huluwa("青娃", Color.CYAN, 5);
		huLuWa[5] = new Huluwa("蓝娃", Color.BLUE, 6);
		huLuWa[6] = new Huluwa("紫娃", Color.PURPLE, 7);

		Queue positions = new Queue(huLuWa.length + 1);
		positions.seizeSeat(huLuWa);
		// positions.bubbleSort();
		positions.binarySort(1, huLuWa.length);
	}
}