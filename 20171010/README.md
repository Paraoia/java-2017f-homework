# 葫芦兄弟
## 抽象和封装
### 角色抽象和接口
所有的角色被抽象成:<br>
<code>Huluwa</code>(葫芦娃)<br>
<code>Grandpa</code>(爷爷)<br>
<code>Monster</code>(含子类蝎子精<code>Xiezijing</code>，子类小喽啰<code>Xiaolouluo</code>，和子类蛇精<code>Snake</code>)<br>
<code>Vacancy</code>(空位置)<br>

这些抽象再次通过接口类<code>Creature</code>被抽象，共同拥有如下属性:
<pre><code>
    public void report(); //报告自己的名字
    public void setPosition(Position position); //设置位置
    public Position getPosition(); //获取位置
</code></pre>
排序也从接口类<code>Sorter</code>派生出来，共同遵守<code>Sorter</code>的协议:
<pre><code>
    public void sort(Queue queue, int startRow, int startCol, int len);
</code></pre>

### 位置类
通过一个类<code>Position</code>来模拟每一个点，此类包含三个属性：
<pre><code>
    private int x;  //坐标X
    private int y;  //坐标Y
    private Creature holder;  //此点放置的生物（在上述各抽象成的角色中选择一个）
</code></pre>

## 设计原则
<li>SRP原则:各个角色类只用作单一角色的表示</li>
<li>OCP原则:Sort和Creature都遵循了这个原则，如果需要修改，不会影响其他不相关模块</li>
<li>LSP原则:Queue中存放的是Creature，而没指定是哪种具体的角色，增加通用性和鲁棒性</li>
<li>ISP原则:搭建阵形和取消阵型是不同的两个方法，体现了分离原则</li>
<li>DIP原则:子类都是通过父类提供的接口派生出来的</li>
