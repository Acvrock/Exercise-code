1 分析Collection接口以及其子接口，很通俗的方式说说，究竟有哪些类型的Collection，各自解决什么样的问题
Collection 接口关系如图   
![](QQ20161219-0@2x.png)   
三个子接口分别是: Queue、Set、List,还有一个抽象类 AbstractCollection,
Collection 接口抽象了一组元素的集合，提供了通用的集合操作方法
 ![](QQ20161219-1@2x.png)   

* 其中 Set 代表无序，不可重复的集合，就像是一个盘子里的小石头，每个都一样是石头，但是每一个形状又都不一样，Set 的 API 和 Collection 完全一样;      
* List 代表有序，可重复的集合，List中的每一个元素都有一个索引；第一个元素的索引值是0，往后的元素的索引值依次+1，对比 Collection，List 拓展了自己的方法，增加了 “添加、删除、获取、修改指定位置的元素”、“获取List中的子队列” 等方法;    
  ![](QQ20161220-0@2x.png)  
* Queue 代表一种队列集合，队列的头部保存在队列中存放时间最长的元素，尾部保存存放时间最短的元素。新元素插入到队列的尾部，取出元素会返回队列头部的元素，对比 Collection 接口，Queue 增加了"队尾元素插入"，"获取队头元素" 等方法
  ![](QQ20161220-1@2x.png)
* AbstractCollection 是一个抽象类，它实现了 Collection 中除 iterator() 和 size() 之外的函数。
AbstractCollection 的主要作用：它实现了 Collection 接口中的大部分函数。从而方便其它类实现Collection，比如ArrayList、LinkedList等，它们这些类想要实现Collection接口，通过继承AbstractCollection就已经实现了大部分的接口了。   

   
2 TreeSet继承了什么Set，与HashSet的区别是？HashSet与HashTable是“一脉相承”的么？
TreeSet 和 HashSet 类图如下:
 ![](set.png)
 可以看到，TreeSet 和 HashSet 都继承了 AbstractSet，都实现了 Serializable、Cloneable 接口，所以可以说HashSet与HashTable是“一脉相承”的，但是对比 HashSet，TreeSet 实现了 NavigableSet、SortedSet 接口
 SortedSet 具有排序功能，它支持对 Set 中的元素排序，提供了三大功能，分别是
 
 ```
 public interface SortedSet<E> extends Set<E> {
    // Range-view 范围查看 
    SortedSet<E> subSet(E fromElement, E toElement);
    SortedSet<E> headSet(E toElement);
    SortedSet<E> tailSet(E fromElement);

    // Endpoints  端点
    E first();
    E last();

    // Comparator access  访问 Comparator
    Comparator<? super E> comparator();
}
 ```
 
 NavigableSet  直译成中文就是：可导航的 Set,是 SortedSet 的子接口，有 ConcurrentSkipListSet, TreeSet 两种实现       
增加了返回小于（lower）、小于等于（floor）、大于等于（ceiling）和大于（higher）输入参数的一个元素的方法     
弹出第一个(pollFirst)，最后一个元素(pollLast)、    
以及正向和逆向的迭代器、     
返回更小的元素集合(headSet)，更大的元素集合(tailSet)，区间元素集合(subSet)
 ![](QQ20161223-0@2x.png)
 
3 Queue接口增加了哪些方法，这些方法的作用和区别是？   
Queue 本质上是一个操作受限的集合，结构图如下：   
 ![](QQ20161223-2@2x.png)   
  
```
 offer       添加一个元素并返回插入结果,优于add，因为如果队列已满，则返回false，不抛出异常  
 remove   	 移除并返回队列头部的元素， 如果队列为空，则抛出一个异常   
 poll        移除并返问队列头部的元素，优于remove,因为如果队列为空，则返回null   
 element     返回队列头部的元素，如果队列为空，则抛出一个异常      
 peek        返回队列头部的元素，优于peek,因为如果队列为空，则返回null       
```
 
4 LinkedList也是一种Queue么？是否是双向链表?
LinkedList 实现了 Queue 接口，所以可以作为队列，作为 FIFO 的队列时，下表的方法等价：

队列方法 | 	等效方法
---- | ----
add(e) |	addLast(e)
offer(e) | offerLast(e)
remove() | removeFirst()
poll()	| pollFirst()
element() | getFirst()
peek()	| peekFirst()

LinkedList 是双向链表实现，从下图可以看出，它分别记录了头节点和尾节点，便于双向遍历   
![](QQ20161224-0@2x.png)   
5 Java数组如何与Collection相互转换

Collection to Array:    
1. ```Bar[] result = foos.stream().map(Bar::new).toArray(Bar[]::new);```     
2. ```Foo[] foos = x.toArray(new Foo[x.size()]); ```   
3. 
 
```
int i = 0;   
Bar[] bars = new Bar[fooCollection.size()];
for( Foo foo : fooCollection ) { // where fooCollection is Collection<Foo>
    bars[i++] = new Bar(foo);
}    
``` 

Array to Collection:   
1. ```XXX xxx = new XXX(Arrays.asList(array));```   
2. ```Collections.addAll(list, array); ```  
3. ```XXX xxx = Arrays.stream(array).collect(Collectors.toXXX());``` 

6 Map的一级子接口有哪些种类，分别用作什么目的？  
下图为 Map 实现类和子接口 
![](QQ20161224-3@2x.png)   
子接口有：   
Bindings,      不明
ConcurrentMap<K,V>,   定义了几个基于 CAS（Compare and Set）操作
MessageContext,   不明     
ObservableMap,   允许注册观察者跟踪 Map 值的更改   
SortedMap<K,V>    可进行排序的 Map    
XSNamedMap,      为内部使用的接口，不明   
7 HashSet 与HashMap中放入的自定义对象必须要实现哪些方法，说明原因
如果要将自定义的对象放入到HashMap或HashSet中，需要@Override hashCode()和equals()方法。hashCode()方法决定了对象会被放到哪个bucket里，当多个对象的哈希值冲突时，equals()方法决定了这些对象是否是“同一个对象”。    
8 TreeSet里的自定义对象必须要实现什么方法，说明原因     
因为 TreeSet 具有排序功能，所以对象集合必须实现Comparable接口,并重写compareTo()方法，通常我们需要保持 compareTo 和 equals 同步，所以最好也实现 equalse 方法    
9 LinkedHashMap使用什么来保存数据，其效率与HashMap相比如何？它又有什么独特特性   
LinkedHashMap 继承了 HashMap ，所以底层使用了数组来保存数据，用 set 来保存 key 集合，但是它又新增了 head 和 tail 实现双向循环链表，下面是开销情况：
![](9Ete5.jpg)      
对比 HashMap Hash的无序性，LinkedHashMap 的元素可以按插入顺序或访问顺序排列                        

10 IdentityHashMap 里面如果按照下面的方法放入对象，分别是什么结果，请解释原因
        Integer a=5;
        Integer b=5;
        map.put(a,"100");
        map.put(b,"100";
        System.out.println(map.size);
        map.clear();
       Integer a=Integer.MAX_VALUE-1;
       Integer b=Integer.MAX_VALUE-1;
       map.put(a,"100");
        map.put(b,"100";
        System.out.println(map.size);
结果如图:
![](QQ20161224-1@2x.png)   
原因是：是 IdentityHashMap 使用的是==比较key的值，调用 Integer.valueOf, 当值小于 127 时，返回的都是 IntegerCache 的值，所以 IdentityHashMap 认为它是同一个 key ，128 开始就返回一个新的 Integer, IdentityHashMap就认为不相等了    

加分题，
给出ＪＤＫ　１.８的java 集合框架全图谱（Class类图）， 并标明1.7与1.8里出现的新的类，解释其目的


[Java 集合系列02之 Collection架构](http://www.cnblogs.com/skywang12345/p/3308513.html#a4)   
[Java HashSet和HashMap源码剖析](http://www.importnew.com/19892.html)   
[Difference between HashMap, LinkedHashMap and TreeMap](http://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-treemap)