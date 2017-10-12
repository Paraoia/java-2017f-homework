public class Huluwa {
	int num;
	Color color;
	String name = new String();
	
	void setNum(int num) {
		this.num = num;
	}
	
	void setColor(Color color) {
		this.color = color;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	void move (Queue queue, int pos) {
		System.out.println(queue.positions[pos].holder.name + ": " + (pos + 1) + "->" + (pos + 2));
		System.out.println(queue.positions[pos + 1].holder.name + ": " + (pos + 2) + "->" + (pos + 1));
		Huluwa tmp = queue.positions[pos].holder;
		queue.positions[pos].holder = queue.positions[pos + 1].holder;
		queue.positions[pos + 1].holder = tmp;
	}
	
	void swap (Queue queue, int pos, int splitPoint) {
		if (pos == splitPoint)
			return;
		System.out.println(queue.positions[pos].holder.name + ": " + (pos + 1) + "->" + (splitPoint + 1));
		System.out.println(queue.positions[splitPoint].holder.name + ": " + (splitPoint + 1) + "->" + (pos + 1));
		Huluwa tmp = queue.positions[pos].holder;
		queue.positions[pos].holder = queue.positions[splitPoint].holder;
		queue.positions[splitPoint].holder = tmp;
	}
}

enum Color {
	CHI, CHENG, HONG, LV, QING, LAN, ZI;
}