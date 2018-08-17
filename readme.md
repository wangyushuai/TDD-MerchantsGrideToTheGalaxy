//最近太忙了，时间不多，没法详细完成作业
//这里大体说一下思路，希望有机会一起结对编程来完成它。

已有代码采用了TDD思路进行开发。
具体逻辑如下：
 1. 主要逻辑分为：翻译服务 和 计算服务，两整块逻辑，故抽象成两个Service。 
 2. 另需一个工具类RomanToIntegerService 完成 罗马数字到阿拉伯数字的转化。
 3. TranslateService 负责翻译，将输入解析成最终的计算规则。
 4. ComputeService 负责计算，使用TranlateService 形成的规则初始化而后完成计算。


https://github.com/wangyushuai/TDD-MerchantsGrideToTheGalaxy
 
 
 