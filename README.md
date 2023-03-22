# spark_streaming
sparkstreaming实时计算项目
实时计算一般是指通过流处理方式计算当日的数据都算是实时计算。

本项目架构图如下:

![image](img/%E6%9E%B6%E6%9E%84.png)

后置提交offset+幂等方案，确保数据精确一次消费
offset 管理架构图:

![image](img/offset.png)
