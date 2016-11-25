1. Lambda  
2. Stream API  
3. JavaFX API  
4. time API   
5. 并发 API  
6. Nashorn 引擎  
7.   


接口经常会重新声明 Object 类中的方法，而这些方法声明并不是抽象的   
Java 8 中接口可以声明非抽象的方法   
不能将一个 lambda 表达式赋值给一个 Object 类型的变量，因为 Object 不是一个函数式接口   
函数式接口在 java.util.function 包中   
使用 @FuntionalInterface 注解   
两种方式处理 lambda 中的异常，1：捕获、2:将 lambda 表达式赋给一个其抽象方法可以抛出异常的接口，例如 Callable   

方法引用：如果只想传递一个方法过去执行，可以使用方法引用， x->System.out.println(x); == System.out::println   
方法引用有三种情况：    
- 对象::实例方法   
- 类::静态方法     
- 类::实例方法   

构造器引用   
构造器引用和方法引用类似，不过写法为：   
- 类::new    

lambda 表达式构成：   
1. 一段代码   
2. 参数     
3. 自由变量的值   

含有自由变量的代码块被称为 “闭包”(closure)   
lambda 表达式中，被引用的变量的值不可以被改变   
lambda 表达式的方法体和嵌套代码块有着相同的作用域，所以有相同的命名冲突和屏蔽规则   

默认方法：如果接口需要添加新方法时，所有的实现类都必须要实现该方法，但是在 Java8 中可以通过默认方法来解决这个问题   
如果接口中的默认方法和其他父类或者接口的方法冲突，有以下解决方法   
1. 其他父类冲突，选择父类的方法   
2. 接口冲突，覆盖该方法来解决冲突,程序员手动指定要使用哪个默认方法   
优先使用类中的方法，即“类优先”原则   

接口中可以声明一些静态方法   

迭代器意味着特定的遍历策略，禁制了高效的并发执行    
从集合中创建 Stream   
使用 filter 选择元素，使用 map 改变元素      
使用 limit、distinct、sorted 改变元素   
使用 reduction 操作符获得结果，如 count、max、min、findFirst、findAny、orElse   
使用 Optional 类型安全代替 null 借助 ifPresent 和 orElse 方法   
使用 Collectors 类中的 groupingBy 和 partitioningBy 方法对 Stream 进行分组   
Java8 默认对原始类型提供了专门的 Stream，如 ing、long、double   
使用并行 Stream 时，请保证他不带有副作用，并且不保证排序约定   

Stream 和 集合的区别：  
1. Stream 自己不会存储元素
2. Stream 操作符不会改变源对象
3. Stream 操作符可能延迟执行

使用 Stream 过程   
1. 创建一个 Stream
2. 在1～N 个步骤中，制定将 Stream 转换成另外一个 Stream 的中间操作
3. 使用终止操作产生一个结果，该操作会让之前的中间操作立即强制执行，之后该 Stream 就不会再被使用了

创建 Stream 方法
1. java.util.stream.Stream.of 方法
2. Stream.empty
3. Stream.generate


filter 方法的参数是一个 Predicate<T> 对象，即一个从 T 到 boolean 的函数   
map 方法可以实现对流中的值进行某种形式的转换   
flatMap 待解释...   
limit 方法可以提取子流   
skip 方法可以丢弃前面 N 个元素   
concat 方法可以组合两个流   
peek 方法可以产生另一个与原始流具有相同元素的流，但是在每次获取一个元素时调用一个函数以便于调试  

有状态的转换   
distinct 方法可以去重   
sorted 方法可以进行排序   

聚合方法  
count 
min   
max   
findFirst 查找第一个   
findAny 查找所有   
anyMatch  只是看一下有没有匹配的   
allMatch  所有元素都匹配   
noneMatch  所有元素都不匹配   

Optional 类型是一种比较好的表示缺少返回值的方法      
如何使用：使用一个或者接受正确值、或者返回另一个替代值的方法   
ifPresent 接受一个函数，如果 Optional 存在值，那么他将会把该值传递给函数，否值不做任何操作   
map 待解释...   
orElse  如果没有值，那么就使用替代值   
orElseGet 如果没有值，那么就调用方法  
orElseThrow 如果没有值，那么就抛出异常   

创建可选值  
Optional.of   
Optional.empty   
ofNullable(obj)  如果 obj 不为 null 那么回返回 of(obj) ，否则回返回 empty()   

聚合操作    
将流中的元素组合为一个值，可以使用聚合方法，常见的有：求和、求积、字符串追加、求最大值和最小值、求并集和交集等      
reduce 从流的前两个元素开始，不断将它应用到流中的其他元素上   

收集结果   
toArray    
collect  待解释...   
collect 需要接受三个参数：  
1. 一个能创建目标类型实例等方法，例如 HashSet 的构造函数   
2. 一个将元素添加到目标的方法，例如一个 add 方法  
3. 一个将两个对象整合到一起的方法，例如 addAll 方法    

例如： ```HashSet<String> result = stream.collect(HashSet::new,HashSet::add,HashSet::addAll);```   
但实际上 Collector 接口已经为我们提供了这三个方法，并且在 Collectiors 中提供了工厂方法  
```Set<String> result = stream.collect(Collectors.toSet());```   如果想控制返回的类型，可使用  ```ThreeSet<String> result = stream.collect(Collectors.toCollection(ThreeSet::new));```   
把流中所有的字符串连接并收集起来，可以调用 Collectors.joining()   
如果希望在这些元素中添加一个分隔符，那么可以传递分隔符给 joining ,如 Collectors.joining(",")   
求总和、平均值、最大值、最小值可以使用：summarizing(int|Long|Double)     
```Map<Integer,String> idToName = peple.collect(Colletors.toMap(Person::getId,Person::getName));```   
Collectors.groupingBy 进行分组的分类函数   
Collectors.partitioningBy 更高效的分类函数  


原始类型流   
Stream API 提供了原始类型的流，如: IntStream、LongStream、DoubleStream   
IntStream.range  和 IntStream.rengeClosed  生成步进为 1 的一个整数范围   
CharSequence.codePoints 和 CharSequence.chars 生成包含字符 Unicode 代码的流  
Random 类提供 ints\longs\doubles 来返回包含随机数字的原始类型流   

并行流  
待解释...   

函数式接口   
待解释...   

使用 lambda 表达式的原因：延迟代码执行时间点   
执行 lambda 时，请确认所有必需的数据作为输入   
如果可以，请选择已经有的函数式表达式   
编写返回函数式接口实例的方法   
使用转换时，请考虑如何组合它们   
延迟组合转换，你需要保留一个所有未执行的转换列表，并在最后应用他们     
如果需要多次应用一个 lambda 表达式，最好将工作分成多个子任务，以便可以并发执行   
考虑如何处理 lambda 表达式中抛出异常的情况    
当使用泛型函数式接口时，请使用 ? Super 通配符作为参数类型，使用 ? Entend 通配符作为返回类型    
当使用可以被函数转换的泛型类型时，请考虑使用 map 和 flatMap   
