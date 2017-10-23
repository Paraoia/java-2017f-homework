/**
 * 这个故事发生的地点，也即为众所周知的葫芦山
 * 在这个神奇的地方，发生过很多奇妙的事情
 * 就比如今天，我们的葫芦娃兄弟们不去打蛇精了（大概他们蛇精病了吧）
 * 他们在这里，进行了两场有趣的排序：
 */
 
// 直接使用 javac StoryEnvironment.java 编译代码时出现以下问题：
// 错误: 编码GBK的不可映射字符
// 解决方案：javac -encoding UTF-8 StoryEnvironment.java

public class StoryEnvironment {
    Crops crops;
    BubbleSorter bSorter;
    QuickSorter qSorter;

    StoryEnvironment() {
        crops = new Crops();
        bSorter = new BubbleSorter();
        qSorter = new QuickSorter();
    }

    public static void main(String[] args) {
        StoryEnvironment storyEnvironment = new StoryEnvironment();

        storyEnvironment.crops.generate();

        storyEnvironment.crops.randomPermutation();
        System.out.println("Before bubble sort:");
        storyEnvironment.crops.printNo();

        System.out.println("\nbubble sorting:");
        storyEnvironment.bSorter.bubbleSort(storyEnvironment.crops);
        System.out.println("\nAfter bubble sort:");
        storyEnvironment.crops.printNo();
        System.out.println();

        storyEnvironment.crops.randomPermutation();
        System.out.println("Before quick sort:");
        storyEnvironment.crops.printColor();

        System.out.println("\nquick sorting:");
        storyEnvironment.qSorter.quickSort(storyEnvironment.crops, 0, 6);
        System.out.println("\nAfter quick sort:");
        storyEnvironment.crops.printColor();
    }
}