# 逻辑介绍
代码采用了TDD思路进行开发。
具体逻辑如下：
 1. 主要逻辑分为：翻译服务 和 计算服务，两整块逻辑，故抽象成两个Service。 
 2. 另需一个工具类RomanToIntegerService 完成 罗马数字到阿拉伯数字的转化。
 3. TranslateService 负责翻译，将输入内容解析成最终的计算规则。
 4. ComputeService 负责计算，使用TranlateService 形成的规则初始化而后完成计算。
 5. IndexService 负责调度，为程序入口，完成读取，输出，打印等工作。

# 程序说明
程序为Gradle项目，使用了Junit4.7及Mockito完成单元测试

# 运行结果
![运行结果](https://github.com/wangyushuai/TDD-MerchantsGrideToTheGalaxy/blob/master/result.png)


# github 地址
https://github.com/wangyushuai/TDD-MerchantsGrideToTheGalaxy
 
 
 
