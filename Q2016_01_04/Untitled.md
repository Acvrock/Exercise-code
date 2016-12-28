1 说明Stream 与Collection的区别 以及关系

 可从 stream 的文档中找到答案，   
  1. 无存储。 流不是存储元素的数据结构; 而是通过"计算操作的流水线"的形式表达来自诸如数据结构，阵列，生成器函数或 I/O 通道的源的元素。   
  2. 本质是函数。对 Stream 对象操作能得到一个结果，但是不会修改原始数据。   
  3. Laziness-seeking（延迟搜索）：Stream 的很多操作如 filter、map、sort 和 duplicate    removal(去重）可以延迟实现，意思是我们只要检查到满足要求的元素就可以返回。   
  4. 可能是不受限制的：Streams 允许 Client 取足够多的元素直到满足某个条件为止。而 Collections 不能这么做。   
 5. 消耗的。Steam 中的元素在 steam 生存期内只能被访问一次。   
 
2 下面代码为什么输出流中的每个元素2遍
Stream.of("d2", "a2", "b1", "b3", "c")
    .filter(s -> {
        System.out.println("filter: " + s);
        return true;
    })
    .forEach(s -> System.out.println("forEach: " + s));
    
3  用Stream的API实现第四题的结果，其中增加一个过滤条件，即年薪大于10万的才被累加，分别用ParellStream与普通Stream来运算，看看效果的差距

4 自己动手编写不少于5个Stream的例子，并解释代码

加分题：
1  用自定义的Collect实现第三题的功能
        
          