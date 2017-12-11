# 作业：线程协同

课程网站上示例代码[waxomatic](https://github.com/njuics/java-2017f/blob/master/examples/Concurrency/src/main/java/concurrency/waxomatic/WaxOMatic.java)中创建了一个`WaxOn`线程和一个`WaxOff`线程，并通过`wait()`和`notify()`使其协同工作（在`Car`对象的`waxOn==true`时`WaxOff`线程开始工作，当`waxOn==fase`时`WaxOn`线程开始工作，如此交替，以此往复）

要求：将该段程序中增加开启一个`WaxOn`线程，即运行时存在两个`WaxOn`线程（分别命名为`WaxOn1` 和 `WanOn2`）和一个`WaxOff`线程，当`waxOn==true`时`WaxOff`工作，当`waxOn==false`时某一个（但不是某个确定的）`WaxOn`线程工作，并在原有“Wax On! \n”输出字符串前面增加线程名称（即分别输出“WaxOn1: Wax On! \n”和”WaxOn2: Wax On! \n“）。