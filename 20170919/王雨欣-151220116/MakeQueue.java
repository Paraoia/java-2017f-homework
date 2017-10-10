
// 排序类
public class MakeQueue {
    // 任意排序
    void random_sort(Huluwa[] hulubro, Seat[] seats){
        System.out.print("Initial: ");
        seats[0].holder = hulubro[6];
        seats[1].holder = hulubro[1];
        seats[2].holder = hulubro[0];
        seats[3].holder = hulubro[4];
        seats[4].holder = hulubro[5];
        seats[5].holder = hulubro[2];
        seats[6].holder = hulubro[3];
        finish(seats,0);  //结束后报个数
    }

    // 冒泡排序
    void bubble_sort(Seat[] seats){
        System.out.print("Bubble Sort: \n");
        int i,j;
        for(i=0; i<6; i++)
            for(j=0; j<6-i; j++)
            {
                if(seats[j].holder.rank > seats[j+1].holder.rank) {
                    shout(seats[j].holder, seats[j].no, seats[j + 1].no);   // 报到葫芦娃位置移动
                    shout(seats[j + 1].holder, seats[j + 1].no, seats[j].no);  // 报到葫芦娃位置移动
                    swap(seats[j], seats[j + 1]);  // 交换两个葫芦娃位置
                }
            }
        finish(seats,0);  //结束后报个数
    }

    // 快速排序
    void quick_sort(Seat[] seats){
        System.out.print("Quick Sort: \n");
        qs(seats, 0, 6);  //快速排序递归过程
        finish(seats,1);  //结束后报个数
    }

    void qs(Seat[] seats, int left, int right)  //快速排序递归过程
    {
        if(left>=right)
            return;
        int low = left;
        int high = right;
        Huluwa key = seats[left].holder;
        while(low < high)
        {
            while(low < high && seats[high].holder.color >= key.color)
                high--;
            seats[low].holder = seats[high].holder;  // 报到葫芦娃位置移动
            shout(seats[high].holder, seats[high].no, seats[low].no);
            while(low < high && seats[low].holder.color <= key.color)
                low++;
            seats[high].holder = seats[low].holder;
            shout(seats[low].holder, seats[low].no, seats[high].no);  // 报到葫芦娃位置移动
        }
        seats[low].holder = key;
        shout(key, left, seats[low].no); // 报到葫芦娃位置移动
        qs(seats, left, low-1);
        qs(seats, low+1, right);
    }

    //交换两个葫芦娃位置
    void swap(Seat s1, Seat s2){
        Huluwa temp = s1.holder;
        s1.holder = s2.holder;
        s2.holder = temp;
    }

    //葫芦娃报到位置移动
    void shout(Huluwa hu, int no1, int no2) {
        System.out.println(hu.rank_name + ": " + no1 + "->" + no2);
    }

    //排序结束后报个序
    void finish(Seat[] s, int index) {  /*后面的参数index 指示报的是rank_name还是color_name
                                         index = 0 表示报名字，index = 1 表示报颜色*/
        int i;
        for (i = 0; i < 7; i++) {
            if(index == 0)
                System.out.print(s[i].holder.rank_name + " ");
            else
                System.out.print(s[i].holder.color_name + " ");
        }
        System.out.print("\n\n");
    }
}
