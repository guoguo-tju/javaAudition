
# java进阶知识点

<br>


## 目录

* [参考书籍及课程](#参考书籍及课程)

### 网络知识
* [TCP的三次握手](#TCP的三次握手)
* [TCP的四次挥手(断开时)](#TCP的四次挥手(断开时))
* [TCP的滑动窗口](#TCP的滑动窗口)
* [超文本传输协议HTTP](#超文本传输协议HTTP)
* [在浏览器键入url,按下回车之后经历的流程](#在浏览器键入url,按下回车之后经历的流程)
* [HTTP状态码](#HTTP状态码)
* [GET请求和POST请求的区别](#GET请求和POST请求的区别)
* [Cookie和Session的区别](#Cookie和Session的区别)
* [HTTP和HTTPS的区别](#HTTP和HTTPS的区别)

### 关系型数据库
* [如何设计一个关系型数据库](#如何设计一个关系型数据库)
* [索引模块](#索引模块)
* [索引的数据结构](#索引的数据结构)
* [密集索引和稀疏索引的区别](#密集索引和稀疏索引的区别)
* [如何定位并优化慢查询sql](#如何定位并优化慢查询sql)
* [联合索引的最左匹配原则的成因](#联合索引的最左匹配原则的成因)
* [索引是建立的越多越好么](#索引是建立的越多越好么)
* [锁模块](#锁模块)
* [MyISAM与InnoDB关于锁方面的区别是什么](#MyISAM与InnoDB关于锁方面的区别是什么)
* [数据库锁的分类](#数据库锁的分类)
* [数据库事务的四大特性ACID](#数据库事务的四大特性ACID)
* [事务隔离级别以及各级别下的并发访问问题](#事务隔离级别以及各级别下的并发访问问题)
* [InnoDB可重复读隔离级别在如何避免幻读](#InnoDB可重复读隔离级别在如何避免幻读)

### 缓存知识考点
* [缓存中间件Memcache和redis的区别](#缓存中间件Memcache和redis的区别)
* [为什么Redis这么快](#为什么Redis这么快)
* [说说你用过的Redis的数据类型](#说说你用过的Redis的数据类型)
* [从海量key里查出某一固定前缀的key](#从海量key里查出某一固定前缀的key)
* [如何使用Redis做异步队列](#如何使用Redis做异步队列)
* [Redis如何做持久化](#Redis如何做持久化)
* [使用Pipeline的好处](#使用Pipeline的好处)
* [Redis的读写分离同步机制](#Redis的读写分离同步机制)
* [如何将不同的key均匀放在不同的redis集群节点](#如何将不同的key均匀放在不同的redis集群节点)

### Linux
* [Linux的体系结构](#Linux的体系结构)
* [查找特定的文件](#查找特定的文件)
* [根据文件内容去筛选](#根据文件内容去筛选)
* [对文件内容做统计](#对文件内容做统计)

### JVM
* [JVM如何加载class文件](#JVM如何加载class文件)
* [什么是反射](#什么是反射)
* [谈谈ClassLoader](#谈谈ClassLoader)
* [类的加载方式](#类的加载方式)
* [Java的内存模型](#Java的内存模型)
* [JVM三大性能调优参数](#JVM三大性能调优参数)
* [Java内存模型中堆和栈的区别](#Java内存模型中堆和栈的区别)
* [元空间/堆/线程独占部分的联系](#元空间/堆/线程独占部分的联系)
* [不同JDK版本间intern方法的表现](#不同JDK版本间intern方法的表现)

### GC

* [Java对象被判定为垃圾的标准是什么](#Java对象被判定为垃圾的标准是什么)
* [判定对象是否为垃圾的算法](#判定对象是否为垃圾的算法)
* [垃圾回收的算法](#垃圾回收的算法)
* [分代收集算法(Generational-Collector)](#分代收集算法(Generational-Collector))
* [GC中什么是Stop-the-World](#GC中什么是Stop-the-World)
* [什么是Safepoint](#什么是Safepoint)
* [JVM的运行模式](#JVM的运行模式)
* [常见的垃圾收集器](#常见的垃圾收集器)
* [Object的finalize()方法的作用是否与C++的析构函数作用相同](#Object的finalize()方法的作用是否与C++的析构函数作用相同)
* [Java中的强引用,软引用,弱引用,虚引用](#Java中的强引用,软引用,弱引用,虚引用)
* [引用队列(ReferenceQueue)的作用](#引用队列(ReferenceQueue)的作用)


### 消息队列
* [为什么要引入消息中间件](#为什么要引入消息中间件)
* [引入消息中间件之后会有哪些缺点](#引入消息中间件之后会有哪些缺点)
* [消息中间件全链路100%数据不丢失(三个方面)](#消息中间件全链路100%数据不丢失(三个方面))
* [如果消费者接收到消息,完成消息之前宕机怎么办?](#如果消费者接收到消息,完成消息之前宕机怎么办?)
* [分析一下消费者手动ack机制保证消息不丢失的底层原理](#分析一下消费者手动ack机制保证消息不丢失的底层原理)
* [如何保证消息中间件里的消息不会丢失? (消息的持久化)](#如何保证消息中间件里的消息不会丢失? (消息的持久化))
* [在某次高峰期间MQ中间件故障的情况下的卡死情况](#在某次高峰期间MQ中间件故障的情况下的卡死情况)
* [消息中间件的生产端如何保证数据不丢失](#消息中间件的生产端如何保证数据不丢失)


### Java常用类库
* [Error和Exception的区别](#Error和Exception的区别)
* [Java的异常体系](#Java的异常体系)
* [常见的Error以及Exception](#常见的Error以及Exception)
* [数据结构和算法考点](#数据结构和算法考点)
* [Java集合](#Java集合)
* [HashMap/HashTable/ConcurentHashMap的区别](#HashMap/HashTable/ConcurentHashMap的区别)
* [Java8前后HashMap的区别](#Java8前后HashMap的区别)
* [HashMap的put方法](#HashMap的put方法)
* [HashMap如何减少碰撞以提高效率](#HashMap如何减少碰撞以提高效率)
* [HashMap扩容的问题](#HashMap扩容的问题)
* [什么是HashTable](#什么是HashTable)
* [什么是ConcurrentHashMap](#什么是ConcurrentHashMap)
* [CountDownLatch和CyclicBarrier的区别](#CountDownLatch和CyclicBarrier的区别)
* [BIO/NIO/AIO的区别](#BIO/NIO/AIO的区别)


### Spring
* [SpringIOC](#SpringIOC)
* [Spring的ApplicationContext](#Spring的ApplicationContext)
* [Spring的getBean](#Spring的getBean)
* [SpringBean的作用域](#SpringBean的作用域)
* [SpringBean的生命周期](#SpringBean的生命周期)
* [SpringAOP](#SpringAOP)
* [SpringCloud](#SpringCloud)
* [注册中心Eureka内部原理](#注册中心Eureka内部原理)

### 分布式架构
* [微服务架构中如何保证整套系统的高可用](#微服务架构中如何保证整套系统的高可用)
* [TCC分布式事务](#TCC分布式事务)
* [可靠消息最终一致性方案](#可靠消息最终一致性方案)
* [Redis分布式锁](#Redis分布式锁)
* [高并发场景下对分布式锁的优化](#高并发场景下对分布式锁的优化)

### 多线程   
* [Java中进程和线程的关系](#Java中进程和线程的关系)
* [线程的start和run方法的区别](#线程的start和run方法的区别)
* [线程的状态](#线程的状态)
* [sleep和wait的区别](#sleep和wait的区别)
* [notify和notifyAll的区别](#notify和notifyAll的区别)
* [yield](#yield)
* [interrupt](#interrupt)
* [线程之间状态的转换](#线程之间状态的转换)
* [线程安全问题](#线程安全问题)
* [synchronized](#synchronized)
* [ReentrantLock与synchronized的区别](#ReentrantLock与synchronized的区别)
* [Java线程池](#Java线程池)
* [一道JVM类加载机制的面试题](#一道JVM类加载机制的面试题)


### 实用tips
* [Java中进程和线程的关系](#Java中进程和线程的关系)



<br>

<h2 id="网络知识">网络知识</h2>

<br>

   <h3 id="TCP的三次握手">TCP的三次握手</h3>  
   
   TCP是属于传输层的协议,抓包的工具Wireshark  
    
   * 三次握手的流程如下:  
   1) 第一次握手,建立连接时,客户端发送SYN包(syn=j)到服务器,并进入SYN_SEND状态,等待服务器确认;  
   2) 第二次握手,服务器收到SYN包,必须确认客户的SYN,同时自己也发送一个SYN包(syn=k),即SYN+ACK(ack=j+1)包,此时服务器进入SYN_RECV状态.  
   3) 第三次握手,客户端收到服务器的SYN+ACK包,向服务器发送确认包ACK(ack=k+1),此包发送完毕,客户端和服务器进入ESTABLISHED状态,完成三次握手.
         
   * 为什么需要三次握手才能建立起连接?   
     为了初始化Sequence Number的初始值(即上面的j和k),以保证信息传输过程中不会乱序.所以在服务器发送了Sequence Number后(第二次握手),需要客户端发送确认报文给服务器,告知已收到其初始化的Sequence Number了.
         
   * 首次握手的隐患--SYN超时问题  
     Server收到Client的SYN,回复SYN-ACK的时候未收到ACK确认.Server会不断重试直至超时,Linux默认重试5次,每次等待时间翻倍(2+4+8+16+32),总共等待63秒才断开连接.会是server招到SYN Flood攻击,将服务器的连接数耗尽,不能处理正常的连接请求.
           
   * Liunx下针对SYN Flood的防护措施:   
     SYN队列满后,Server会通过TCP的一个特殊的tcp_syncookies参数(请求地址+目标地址+时间戳组成)会发SYB Cookie,若为正常连接Client是会有响应的,会回发SYN Cookie,在即使SYN队列满的情况下,也能建立连接.  
          
   <h3 id="TCP的四次挥手(断开时)">TCP的四次挥手(断开时)</h3>  
   
   * 第一次挥手:Client发送一个FIN,用来关闭Client到Server的数据传送,Client进入FIN_WAIT_1状态;  
   * 第二次挥手:Server收到FIN后,发送一个ACK给Client,确认序号为收到序号+1(与SYN相同,一个FIN占用一个序号,Server进入CLOSE_WAIT状态);  
   * 第三次挥手:Server发送一个FIN,用来关闭Server到Client的数据传送,Server进入LAST_ACK状态;  
   * 第四次挥手:Client收到FIN后,Client进入TIME_WAIT状态,接着发送一个ACK给Server,确认序号为收到序号+1,Server进入一个CLOSED状态,完成四次挥手.  
   * 为什么需要四次挥手才能断开连接?  
     因为全双工,发送方和接收方都需要FIN报文和ACK报文.  
   * 服务器中出现大量CLOSE_WAIT状态的原因?  
     Client关闭socket连接,Server没有及时关闭连接,可能情况:1)缺少一些释放资源的代码; 2)处理请求的线程配置不合理.  
     
   <h3 id="TCP的滑动窗口">TCP的滑动窗口</h3>  
   
   * RTT: 发送一个数据包到收到对应的ACK,锁花费的时间.   
   * RTO: 重传的时间间隔,是根据RTT的值动态计算的.   
   * TCP传输过程中是把数据分为一段一段传输的,我们不能上一段被确认之后再发送下一段.要批量的发送,就要解决可靠传输和包乱序的问题. TCP使用滑动窗口做流量控制与乱序重排.
     
   <h3 id="超文本传输协议HTTP">超文本传输协议HTTP</h3>  
    
   1.1相比1.0 : 引入keep-alive机制.以前是close
   若为close,是服务器主动关闭连接,若为keep-alive,则连接会保持一段时间不会立刻关闭,在此期间还可以数据传输.      
     
   <h3 id="在浏览器键入url,按下回车之后经历的流程">在浏览器键入url,按下回车之后经历的流程</h3> 
   
   1) 会依据url逐层查询DNS缓存,解析url中的域名对应的ip地址. 浏览器缓存-->系统缓存-->路由器缓存-->服务器缓存  
   2) 根据ip地址和端口(默认80)与服务器建立TCP连接  
   3) 浏览器发送http请求  
   4) 服务器对http请求做出响应  
   5) 浏览器解析渲染html  
   6) 浏览器释放TCP连接,四次挥手   
     	
   <h3 id="HTTP状态码">HTTP状态码</h3> 
   
   1xx: 指示信息--表示请求已接收,继续处理  
   2xx: 成功--表示请求已被成功接收  
   3xx: 重定向--要完成请求必须进行进一步转发  
   4xx: 客户端错误--请求有语法错误或请求无法实现  
   5xx: 服务端错误--服务端未能实现合法的请求  
   400 Bad Request: 客户端有语法错误,不能被服务器所理解  
   401 Unauthorized: 请求未经授权,这个状态码必须和www-Authenticate报头域一起使用.  
   403 Forbidden: 服务器接收到请求,但是由于某些原因(ip被禁)拒绝提供服务.  
   404 NOT FOUND: 请求资源不存在,输入了错误的url.  
   500 Internal Server Error: 服务器内部发生不可逾期的错误(代码写的有问题)  
   503 Server Unavaiable : 服务器当前不能处理客户端请求(比如连接池占用满了),一段时间后可能恢复正常    
   	
   <h3 id="GET请求和POST请求的区别">GET请求和POST请求的区别</h3> 
   
   1. HTTP报文层面:  
     GET将请求信息放在url中,POST放在请求体中,所以POST请求没有长度限制,GET请求会有一些长度限制.  
   2. 数据库层面:  
     GET都是查询请求,符合数据的幂等性和安全性,POST会修改数据库,不符合  
   3. 缓存层面:  
     GET请求可以被缓存,被存储,而POST不行.所以绝大部分GET请求会被CDN缓存,大大减少web服务器压力,而POST是非幂等的,必须交由web服务器来处理  
    CDN缓存:  
     客户端浏览器先检查是否有本地缓存是否过期，如果过期，则向CDN边缘节点发起请求，CDN边缘节点会检测用户请求数据的缓存是否过期，如果没有过期，则直接响应用户请求，此时一个完成http请求结束；如果数据已经过期，那么CDN还需要向源站发出回源请求（back to the source request）,来拉取最新的数据。  
     
   <h3 id="Cookie和Session的区别">Cookie和Session的区别</h3> 
   
   * Cookie: 由服务器发给客户端的特殊信息,以文本的形式存放在客户端存放在response header中,客户端再请求浏览器就会携带上这些信息.  
   * Session: 在服务器上保存的信息.解析客户请求并生成操作session,sessionId.  
   * session的实现方式:  
     1) 通过Cookie来传输JSESSIONID-xxx  
     2) 使用url回写来实现,服务器发送给浏览器的所有链接中都包含JSESSIONID,客户端点击任何一个链接都可以吧JSESSIONID带回浏览器.单独输入链接地址请求是不会携带JSESSIONID.  
     tomcat两种实现方式都支持,如果浏览器禁用Cookie,则使用url回写.  
   * 区别:  
    Cookie数据存放在浏览器上,Session数据存放在服务器上.所以Cookie数据不安全,容易被认为使用造假进行Cookie欺骗,Session相对安全 . 考虑到减轻服务器负担推荐使用Cookie.
       
   <h3 id="HTTP和HTTPS的区别">HTTP和HTTPS的区别</h3>  
    
   * HTTPS:  
     在HTTP下加了一层SSL(Sercurity Sockets Layer,安全套接层,SSL3.0后更名为TLS),对传输信息进行加密.      
   
   * HTTPS数据传输流程:  
    1) 浏览器将支持的加密算法信息发送给服务器  
    2) 服务器选择一套浏览器支持的加密算法,以证书的形式回发浏览器  
    3) 浏览器验证证书的合法性,并结合证书公钥加密信息发送给服务器  
    4) 服务器使用私钥解密信息,验证哈希,加密响应消息回发浏览器.  
    5) 浏览器解密响应消息,并对消息进行验真,之后进行加密数据的交互.    
    
   * HTTP和HTTPS的区别:  
    1. HTTPS需要到CA申请证书,HTTP不需要.  
    2. HTTPS密文传输,HTTP是明文传输  
    3. HTTPS默认使用443端口,HTTP使用80端口  
    4. HTTPS=HTTP+加密+认证+完整性保护,较HTTP安全  
   SOCKET简介:  
     Socket是对TCP/IP的抽象,是操作系统对外开放的接口.


<br>

<h2 id="关系型数据库">关系型数据库</h2>

<br>
   
   <h3 id="如何设计一个关系型数据库">如何设计一个关系型数据库</h3>   
   
   ![设计一个数据库](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E8%AE%BE%E8%AE%A1%E4%B8%80%E4%B8%AA%E6%95%B0%E6%8D%AE%E5%BA%93.png "设计一个数据库")
     
   分为两部分:  
   		存储部分:将数据通过I/O持久化到磁盘上.I/O持久化是数据库速度的瓶颈,所以我们需要程序实例部分对存储部分进行管理和优化.  
   		程序实例:  
   * 存储管理:将物理关系映射为逻辑关系.  
   * 缓存机制:优化执行效率,会缓存之前查询到的结果以及其相关结果  
   * SQL解析:将SQL语句进行解析  
   * 日志管理:记录操作,以便主从同步及数据恢复  
   * 权限划分:进行多用户管理的权限划分模块  
   * 容灾机制:灾难恢复模块  
   * 索引管理:优化数据查询效率  
   * 锁管理:使数据库支持并发操作  
   	数据库的开发其实与我们平时的开发的项目一样,模块也相似,是经典的架构.  
   	
   <h3 id="索引模块">索引模块</h3>
   
   * 为什么要使用索引?  
   		避免全表扫描,提升查找效率,思想来源于字典,通过关键信息来快速定位.  
   
   * 什么样的信息可成为索引?  
   		把该记录限定在一定查找范围内的字段(关键字).比如主键/唯一键/普通键
   
   <h3 id="索引的数据结构">索引的数据结构</h3>
   
   * 二叉树查找树  
       平衡二叉树:任意结点的左子树和右子树的高度差不超过1.  
       当数据删除,新增比较多的时候,现有的结构会发生打乱,二叉查找树会被打乱成为线性的.假定二叉树全都存在磁盘中,查找深度每增加1就要多进行一次IO操作,这样数据一多,数的深度就会很深,会增加IO次数,速度反而不如全表扫描来的快(全表扫描是每次读一页或者一块的数据进来),所以要让树变得矮一些,每阶层结点存储的数据多一些.要用到B-Tree了  
   
   * B-Tree(平衡多路查找树)见图.   
   ![B-Tree结构图](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/B-Tree%E7%BB%93%E6%9E%84%E5%9B%BE.png "B-Tree结构图")  
   
        每个节点包括:关键字(索引字段)+每个子节点的指针.  
        每个结点有几个孩子就是几阶B树,比如三阶B树.除根节点和叶子节点(没有子节点的节点)以外,其他每个节点至少有ceil(m/2)个孩子.所有叶子节点都位于同一层.  
        当数据删除,新增比较多的时候,B树通过它的规定来保持树的特征.使得查询复杂度保持在O(logn).  
   
   * B+-Tree(Mysql中用)见图    
   ![B+-Tree结构图](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/B%2B-Tree%E7%BB%93%E6%9E%84%E5%9B%BE.png "B+-Tree结构图")
   
        B+是B的变体,基本定义与B树相同,除了:  
        非叶子节点的子树指针与关键字个数相同:可以存更多关键字,树更矮  
        非叶子节点的子树指针P[i],指向关键字[K[i],K[i+1])的子树.  
        非叶子节点仅用来索引,数据都保存在叶子节点中:非叶子节点只能用来存索引,指针,意味着B+-Tree可以存更多的索引,可以变得更矮.所有的搜索都在叶子节点中终结.  
        所有叶子节点均有一个链指针指向下一个叶子节点,并且按大小顺序排布:查询到范围的端点以后便通过链接找到之前或之后所有数据,便于范围的统计  
   
   * B+Tree更适合来做存储索引:   
      磁盘读写代价更低.(一次加载更多的关键字,减少IO读写次数)  
      查询效率更加稳定.(所有的搜索都会走一遍根节点到叶子节点的过程,查询不同元素复杂度都为O(logn))  
      更有利于数据库的扫描,数据都保存在叶子节点中,并且有链指针链接,便于范围查找统计.  
   
   
   * Hash索引: 见图  
   ![hash索引](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/hash%E7%B4%A2%E5%BC%95.png "hash索引")
   
   所查数据根据hash计算只需一次便可定位到查找数据所在的bucket,之后将bucket中的entry(链表)全部加载进入内存,顺着链表指针找到所需的数据.理论上比B+Tree查询效率高.   

   缺点:  
   1. 仅仅能满足=,in,不能用范围查询: hash索引比较的是hash运算之后的hash值,只能用于等值过滤,因为经过计算hash值与原来的大小关系不一定相同,不同的值可能计算出相同的hash值,所以不能用于范围查询.  
   2. 数据库无法用索引来避免排序操作:因为索引是计算后的hash值,大小关系不一定相同.  
   3. 做组合索引时,hash索引不能利用部分索引来查询.B+Tree支持.  
   4. 不能避免表扫描,因为根据索引找到bucket之后必须要扫描bucket中的数据来查找.  
   5. 遇到大量hash值相等的情况后性能不一定比B+Tree高,因为大量的数据指针会存到同一个bucket中.  
   
   * BitMap位图索引: (Oracle支持)   
       表中的某个字段只有几种枚举值时,十分适用.不适合高并发多的系统,适合统计多的系统.
       
   <h3 id="密集索引和稀疏索引的区别">密集索引和稀疏索引的区别</h3>  
     
   ![密集索引和稀疏索引](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%AF%86%E9%9B%86%E7%B4%A2%E5%BC%95%E5%92%8C%E7%A8%80%E7%96%8F%E7%B4%A2%E5%BC%95.png "密集索引和稀疏索引")
    
   * 密集索引: 每个搜索码都对应一个索引值.叶子结点中不仅保存键值还保存了该列的数据.一个表只能创建一个密集索引.  
   * 稀疏索引:   
       只为索引码的某些值建立索引项.叶子结点只保存了键值以及该行数据的地址或者主键信息.找到叶子结点以后仍要通过地址或者主键信息来寻找数据.
   
   * 对Mysql分析:  见图  
   ![InnoDB与MyISAM](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/InnoDB%E4%B8%8EMyISAM.png "InnoDB与MyISAM")
   
       * MyISAM: 表的所有类型的索引都用稀疏索引,索引与数据是分两个文件存储的.  
       * InnoDB: 表有且仅有一个密集索引,其他索引都是稀疏索引(辅助键索引),索引与数据是在一个文件存储的.  
       
   * 密集索引规则:
        1) 有主键,该主键则作为密集索引  
        2) 没有主键,表的第一个唯一非空索引作为密集索引  
        3) 都没有,InnoDB会生成一个隐藏主键作为密集索引  
        4) 其他的稀疏索引(辅助键索引),其叶子结点会存储键值以及主键值,然后在通过主键值去密集索引里查找.  

   * 在mysql的根目录data文件下数据库里可以找到表相关文件:      
           xxx.frm存储的是表结构信息.  
           xxx.ibd是InnoDB下索引与数据的存储文件.  
           xxx.MYI是MyISAM下存储索引的文件.  
           xxx.MYD是MyISAM下存储数据的文件.  
    
   
   * 衍生出来的问题,以mysql为例:  

   <h3 id="如何定位并优化慢查询sql">如何定位并优化慢查询sql</h3>    
   
   1. 根据慢日志定位查询慢sql  
        在my.ini(windows环境下)配置文件里修改慢日志的一些参数.  
        一条sql查询时间超过1s就是慢的.  
        一旦mysql重启,慢sql日志就会被清零.  
        
   2. 用explain来分析慢sql   
       在查询语句的前面加上explain即可.  
       Explain关键字段:  
       id字段:  指查询顺序,在复合查询里面,id越大的越先执行.  
       type字段:    
        system > const > eq_ref > ref > fulltext > ref_or_null > index_merge > unique_subquery > index_subquery > range > index > all  
        当type是index/all时,意味着sql进行了全表扫描,需要优化.  
       extra字段:  
        extra中出现以下2项意味着MYSQL根本不能使用索引,效率会受到重大影响,需要优化:  
        Using filesort--表示MYSQL会对结果使用一个外部索引排序,而不是使用本表的索引,可能在内存或者磁盘上进行排序.MYSQL中无法利用索引完成的排序操作称为"文件排序".  
        Using temporary--表示MYSQL在对查询结果排序时使用临时表,常见于排序order by 和 分组查询group by  
        
   3. 修改sql或者尽量让sql走索引  
        EXPLAIN SELECT COUNT(id) FROM `repayment` ORDER BY create_time DESC; 查询时没有走主键索引,而是根据查询优化来选择走哪个索引.   
        EXPLAIN SELECT COUNT(id) FROM `repayment` ORDER BY create_time DESC force index(primary)强制用主键索引. 
   4. where查询条件里不要包含null , 因为不会走索引 . 所以在建表时尽量不要让字段有null值 , 用 NOT NULL DEFAULT ''

   <h3 id="联合索引的最左匹配原则的成因">联合索引的最左匹配原则的成因</h3>   

   最左匹配原则:   
   1. mysql会一直向右匹配知道遇到范围查询(>,<,between,like)就停止匹配,比如a=3 and b=2 and c >5 and d =6 如果建立(a,b,c,d)顺序的联合索引,d是用不到索引的,如果建立(a,b,d,c)的联合索引就可以用到,a,b,d的顺序可以任意调整.  
   2. =和in可以乱序,比如a=1 and b=2 and c=3 建立(a,b,c)索引可以任意顺序,mysql的查询优化器会帮你优化成索引可以识别的形式.  

   原因:  
    创建联合索引时,先对最左边的字段进行排序,在第一个排序的基础上再对第二个索引字段进行排序.直接用第二个字段是用不到索引的.  
    建立联合索引的时候,把可能范围查询的字段放在后面.

   <h3 id="索引是建立的越多越好么">索引是建立的越多越好么</h3>    
   1. 数据量小的表不需要建立索引,建立会增加额外的索引开销.  
   2. 数据变更需要维护索引,更多的索引意味着更多的维护成本.  
   3. 更多的索引意味着需要更多的空间.  
   
   <h3 id="锁模块">锁模块</h3>
   
   
   <h3 id="MyISAM与InnoDB关于锁方面的区别是什么">MyISAM与InnoDB关于锁方面的区别是什么</h3>
   
   * MyISAM只支持表级锁,而InnoDB支持行级锁,也支持表级锁.  

   lock tables person_info read/write;   //给表加读锁或写锁  
   unlock tables;  //释放锁  

   * 读锁:是共享锁,上读锁以后仍然可以读操作,但不可以写操作.即上共享锁之后可以伤共享锁,不能上排它锁.  
   * 写锁:是排它锁,上了写锁以后既不能读操作也不能写操作.即上了排它锁之后不能上共享锁也不能上排它锁.  

   * 给读操作上排它锁:  
   select * from person_info where id = 111 for update.

   * InnoDB用的是二段锁,即运行时加锁,然后commit提交来解锁,默认是自动提交事务的,通过下面的命令去除自动提交事务:   
   commit;  提交事务  
   
   show variables like 'autocommit'; 为on表示自动提交已经开启.  
   set autocommit = 0; 关闭自动提交.  

   * InnoDB对select有改进,查询时不加读锁.要想select加入读锁,执行:  
    select * from person_info where id = 3 lock in share mode; 无法加入排它锁  
    commit;  之后可以加入排它锁  

   * InnoDB当sql不走索引的时候,整张表就会被锁住,也就是用的表级锁.当sql走索引的时候,用的行级锁或者gap锁.  
   
   * MyISAM适合的场景:  
   1. 频繁执行全表count语句,因为MyISAM有一个变量来存储表数据的行数,而InnoDB没有.
   2. 对数据进行增删改的频率不高,查询非常频繁
   3. 不用事务的场所. 
    
   * InnoDB适合的场景:  
   1. 数据增删改查都相当频繁.
   2. 可靠性有求比较高,要求支持事务.  

   <h3 id="数据库锁的分类">数据库锁的分类</h3>

   * 按锁的粒度划分:表级锁,行级锁,页级锁
       
   * 按锁级别划分:共享锁,排它锁    
     
   * 按加锁方式划分:自动锁,显示锁  
     * 自动锁: insert,update,detele以及MyISAM的表锁,这是Mysql自动为我们上的.  
     * 显示锁: select for update , lock in share mode这些我们显示加的锁.  
       
   * 按操作划分: DML锁(多数据操作),DDL锁(对表结构操作) .    
       
   * 按使用方式划分: 乐观锁,悲观锁  
     * 悲观锁:   
        对外界的修改持保守态度,依靠数据库提供的锁机制,在数据处理全程中用排它锁锁定(悲观锁的一种实现方式),即先取锁再访问的保守策略,数据的安全有保障,但是会增加数据库的开销,增加产生死锁的几率.      
  	 * 乐观锁:   
  		认为外界的修改不会造成冲突,在数据提交时才会对数据的冲突与否进行检测,若发现错误则返回错误的信息,让用户决定怎么做.乐观锁并不使用数据库提供的所机制,采用记录数据版本(1.用版本号记录version(int) 2.用时间戳记录)的方式来实现.      	
  		先读取数据,得到version的值为versionValue;   
  		每次更新数据的时候,为了防止冲突,先去检查version再做更新,更新成功的话version+1,冲突的话将失败信息返回给用户.    
  		认为数据之间冲突的可能性较小,在提交时才检查版本,而不是在提交之前就锁住数据.不会产生死锁.  
  		类似CAS机制??  

   <h3 id="数据库事务的四大特性ACID">数据库事务的四大特性ACID</h3>   
   
  * 原子性(Atomic):  
  	  事务包含的所有操作要么全部执行,要么全部不执行.  
  * 一致性(Consistency):  
  	  事务应确保数据库状态从一个一致的状态转变为另外一个一致的状态, 比如A和B无论怎么转账,两者的金额之和不变.   
  * 隔离性(Isolation):  
      多个事务并行执行时,一个事务的执行不能影响其他事务的执行.  
  *	持久性(Durability):  
  	  一个事务一旦提交它对数据库的修改应该永久性的保存在数据库中,即当数据库发生故障时,确保已经提交的事务不能丢失.  


   <h3 id="事务隔离级别以及各级别下的并发访问问题">事务隔离级别以及各级别下的并发访问问题</h3>   
   
   1. 更新丢失--mysql的InnoDB引擎有很多的事务隔离级别,使得在数据库层面可可以避免   
   2. 脏读:一个事务读到另一个事务未提交的更新数据. --READ-COMMITTED已提交读事务隔离级别上可以避免,Oracle默认的事务隔离级别READ-COMMITTED   
       select @@tx_isolation;     // 	查看事务的隔离级别  
       set session transaction isolation level read uncommitted;   // 设置当前session级别为读未提交  
   3. 不可重复读: 事务a多次读取同一数据,事务b在事务a多次读取的过程中做了更新提交,使a多次读取时结果不一致.  
    --REPEATABLE-READ可重复读事务隔离级别以上可以避免,Mysql的InnoDB默认事务隔离级别REPEATABLE-READ  
   4. 幻读: 事务a读取与搜索条件相匹配的若干行,事务b以插入或者删除行来修改事务a的结果集,导致事务a再执行当前读操作,出现幻行(比如原来读共有3行,然后全局update,竟然更新了4行).  
    --SERIALIZABLE串行事务隔离级别可以避免.  
    
   <h3 id="InnoDB可重复读隔离级别在如何避免幻读">InnoDB可重复读隔离级别在如何避免幻读</h3>   
   
   * 表象:快照读(非阻塞读)---伪MVCC,多版本并发控制(因为没有实现多版本共存)   
   
        当前读: 读取的是最新记录,并且保证读到的数据不能被其他数据修改,加锁.   
        加了锁的增删改查   
        select...lock in share mode , select...for update , update , delete , insert   

        快照读: 不加锁的非阻塞读(事务隔离级别不为SERIALIZABLE,SERIALIZABLE为串行读,快照退化为当前读)  
        select  

        在RC隔离级别下,当前读和快照读读到的数据是一样的,在RR隔离级别下,如果先快照读,再更新,快照读可能读到修改之前的数据. 如果更新完再快照读,就会读到最新版本,也就是在RR级别下快照读的时机很重要  
        RC,RR级别下的InnoDB的快照读如何实现?  
        --数据行里的DB_TRX_ID(事务) , DB_ROLL_PTR(回滚) , DB_ROW_ID的字段  
        --undo日志(老版本的记录回滚时候用,分为insert的undo,update的undo)  
        --read view 判断快照读能看哪个版本的数据  
        将要修改的数据的SB_TRX_ID取出来,与系统其它活跃事务id做对比,如果>=这些id的话,就根据DB_ROLL_PTR指针去取出undo日志中上一层的DB_TRX_ID,知道小于这些活跃事务id,保证我们获取到的数据版本是当前可用的最稳定版本.  
        再一次事务内,RR首次快照读会创建一个read view , 此后在调用快照读时,用的还是同一个read view , 在RC中每次快照读都会重新创建一个快照 . 所以RR select --> update -->select 可能读到旧数据.  

   * 内在:next-key锁(行锁+gap锁)   
   
     * Gap锁: 锁一定范围间隙内的数据,比如delete,id=9的数据(未命中),此时你插入id=10,就会因为gap锁而失效.  
       RR以及Seriaizable隔离级别下,默认都支持gap锁.  

     * Gap锁的触发?  
        如果where条件全部命中,则不会用Gap锁,只会加记录所锁,就能保障不幻读.  
        如果where条件部分命中或者全不命中,则会增加Gap锁.  
       Gap锁会用在非唯一索引或者不走索引的当前读.比如delete,id=9(id非唯一索引),此时会触发Gap锁,锁住(6,9],(9,11]的区间(临界点也与主键的值有关),此时另一个session想要插入id=9的数据会失败,直到该事务提交或者回滚.防止了幻读.不然会出现delete前只有一条,delete完之后有两条数据被删除的情况.不走索引的情况,会触发所有的Gap锁,这样比全表锁的效率更低,因此要避免这种情况.    
       
     * 在Gap锁锁住的区间内,不会出现幻读 . 所以RR隔离级别下只能内部防止幻读 .
       gap锁只锁二级索引 , 且是范围所 . 同时这条数据对应的主键索引row也会被行锁.
       
   <h3 id="复杂的sql语句写法">复杂的sql语句写法</h3>          
   * group by / having   
  	   统计相关: COUNT , SUM , MAX , MIN , AVG   

   * group by  
     1. 满足 "select子句中的列名必须为group by里用到的列或者sum,min等列函数的列"只针对同一张表成立,联查时不成立.  
  	 2. 列函数对于group by 子句定义的每个组各返回一个结果.  
  	   group by会把结果集缓存在一张临时表里,然后再通过统计函数对这些结果集进行统计,再展现出来.  

   * having   
     1. 通常与group by子句一起使用 , 没有groupby,having与where作用相同.   
   	 2. where过滤行,having过滤组  
  	 3. 出现在同一sql的顺序: where > group by > having  

   * 查询平均成绩大雨60分的同学的学号和平均成绩: 
     
<pre>
  	select
  		student_id , avg(score)
	from score
	group by student_id
	having avg(score) > 60 ;
	
</pre>  

   * 查询没有学全所有课的同学的学号,姓名:   
   
<pre> 
  	select
  		stu.student_id,
  		stu.name
  	from student stu, score s
  	where stu.student_id = s.student_id
  	group by student_id
  	having count(*) >
  	( select count(*) from course ) ;
</pre>  
  学习一下数据库的理论范式.



<br>

<h2 id="缓存知识考点">缓存知识考点</h2>

<br>

   缓存穿透 : 要查的数据缓存里没有,去数据库里查,然后回写存储在缓存层.

   <h3 id="缓存中间件Memcache和redis的区别">缓存中间件Memcache和redis的区别</h3>  
    
   Memcache :
   1. 支持简单数据类型
   2. 不支持数据持久化
   3. 不支持主从
   4. 不支持分片   
   
   Redis :
   1. 数据类型丰富
   2. 支持数据磁盘持久化存储
   3. 支持主从
   4. 支持分片


   <h3 id="为什么Redis这么快">为什么Redis这么快</h3>  
   
   支持10w+ QPS (query per second , 每秒内查询次数)
   1. 完全基于内存,绝大部分请求时纯粹的内存操作,执行效率高.
   2. 数据结构简单,非关系型数据库,存储结构就是键值对,类似于hashMap,查找的时间复杂度为O(1).
   3. 采用单线程,单线程也能处理高并发请求,避免了锁竞争,没有线程安全问题,想多核可以启动多个redis实例.
   4. 使用多路I/O复用模型,非阻塞I/O:   
        FD: File Descriptor , 文件描述符: 一个打开的文件通过唯一的描述符进行引用,该描述符是打开文件的元数据到文件本身的映射.   
        * 传统的阻塞I/O模型:   
        当对某个文件FD进行读写时,如果该FD不可读/写,整个服务就不会对其他操作响应.   
        * 多用I/O复用模型:   
        Select系统调用:select模型可以同时监控多个文件FD的可读/可写情况,然后程序就可以做别的事情而不被阻塞了.   
        redis会依据操作系统的不同选用不同的多路复用函数(epoll,kqueue,evport,select),优先选择时间复杂度为O(1)的I/O多路复用函数,如果没有就选择时间复制读为O(n)的select作为保底.  


   <h3 id="说说你用过的Redis的数据类型">说说你用过的Redis的数据类型</h3>  
   
   1. String : 最常用的key-value形式 , value最大存512M的数据,二进制安全(可以存JPEG图像,序列化的对象)   
            redis中每一个操作都是原子性的,所以可以不用考虑并发性,用incr来计数.例如:想统计用户每天访问网站的次数,可以用userId+日期作为key,每次用户访问,redis就执行一次incr来计数.   
   2. Hash : String类型的field-value的映射,适合用于存储对象.   
            创建一个lilei的映射 : hmset lilei name "LiLei" age 26 title "Senior"   
            查name字段 :  hget lilei age   
            修改title字段 : hset lilei title "Pricipal"    
   3. List : 按照String元素插入顺序排序 , 后进先出(类似于stack,实现最新消息排行榜等功能) , 可存40亿数据    
            给mylist中插入数据 : lpush mylist aaa   
            查看mylist中数据 : lrange mylist 0 10  (从左往右取出第0位到第10位)   
   4. Set : String元素组成的无序集合 , 通过hash实现(所以查找,新增,删除一个元素的时间复杂度是O(1)),不允许重复.   
            添加元素 : sadd myset 111   
            查看myset中的元素 : smembers myset   
          redis可以求出两个集合的交集并集差集等功能,实现共同关注,共同喜好等功能.   
   5. Sorted Set : String元素的有序不重复集合,每个元素对应一个分数,通过分数来为集合中成员从小到大排序.   
            给zset中添加元素 : zadd myset 3 abc  (添加时指定元素对应的分数)  
            查看zset中数据 : zrangebyscore myzset 0 10  (从左往右取出第0位到第10位)   
           用Sorted Set来做带权重的队列,比如普通消息的score为1 , 重要消息的score为2 , 工作线程也可按工作的大小获取消息,让重要的任务优先执行.   
   6. 除了以上5个常用的以外,还有用于计数的HyperLogLog , 用于支持存储地理位置信息的Geo.  
   
  
   <h3 id="从海量key里查出某一固定前缀的key">从海量key里查出某一固定前缀的key</h3>   
      
   1. 要先问清数据规模,问清边界.  
   2. keys pattern : 查找出符合给定模式pattern的key.  
            keys k1*   
            keys指令一次性返回所有匹配的key,key的数量过大会使服务卡顿.   
   3. 若redis正在给线上提供服务,使用keys指令会有什么问题?   
           会使redis服务卡顿   
   4. 用SCAN指令,无阻塞地提取key列表:   
            SCAN cursor(游标) [MATCH pattern] [COUNT count]       
            
         1. 基于游标的迭代器,需要基于上一次的游标延续之前的迭代过程.返回值:当前遍历到的游标,以及查询到的数据.  
         2. 以0作为游标开始新的迭代,直到命令返回游标0完成一次遍历.  
         3. 不保证每次执行都返回某个给定数量的元素,支持模糊查询.  
         4. 一次返回的数量不可控,只能是大概率符合count参数.  
            例如:  
            scan 0 match k1* count 10    :   开始迭代,返回匹配k1的数据,期望返回10条.cursor为0表示刚开始迭代.  
            返回值:  
            1)"115379"					游标  
            2)1) "k1323454"				匹配到的key  
              2) "k1454365"  
              3) "k1546763"  
            scan 115379 match k1* count 10    :  将查询到的cursor再次传入redis查询  
            可能会获取到重复的key,需要我们在外部去重,比如将查询到的结果放入HashSet里面.  
            代码参考 : https://blog.csdn.net/zhxdick/article/details/78268027

   <h3 id="如何通过redis实现分布式锁">如何通过redis实现分布式锁</h3>   
   
   * 分布式锁:控制分布式系统或者不同系统之间共同访问共享资源的锁的实现.     
        * 互斥性   
        * 安全性 : 锁只能被持有该锁的客户端删除,不能被其他客户端删除.   
        * 死锁 : 获取锁的客户端,因为某些原因宕机,而未能释放锁,其他客户端无法获取该锁而导致死锁.   
        * 容错 : 部分redis节点宕机之后,客户端仍然能够获取锁及释放锁.  

   * 如何实现:   
        * 一种思路(有问题):   
                用 setnx key value , 如果key不存在,set成功,返回值为1,如果key存在,set失败,返回值为0.当返回值是1时,用expire给key设定一个时间,并进行task任务,当返回值是0时,表示该资源被占用,不进行task任务.   
                伪代码:   
                <pre>
                    long status = redisService.setnx(key , "1");   
                    if(status = 1){   
                        redisService.expire(key , expireTime);
                        // 执行占用资源的逻辑.
                        doTask();
                    }
                </pre>
                这里的问题是: setnx与expire不是原子性的,如果setnx完之后程序挂了来不及expire,那么资源会被一直锁上,别的程序无法使用.   

        * 另一个思路:   
                通过 set key value [EX seconds] [PX millseconds] [NX|XX] ,原子性操作   
                    EX second : 设置过期时间为second秒.   
                    PX millsecond : 设置键的过期时间为millsecond毫秒.   
                    NX : 只在键不存在时,才对键进行设置操作   
                    XX : 只在键已经存在时,才对键进行设置操作.  
                    SET操作成功完成后,返回OK,否则返回nil.  
                伪代码:  
                <pre>
                    String result = redisService.set(lockKey , requestId , SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME , expireTime);
                    if ("OK".equals(result)){
                        // 执行占用资源的逻辑.
                        doTask();
                    }
                </pre>   
         可参考示例代码.
   * 大量的key同时过期的注意事项:   
        key集中过期,redis清除大量key会很耗时,出现短暂卡顿现象.   
        解决方案: 在设置key的过期时间时,给key加上一个随机值.避免集中过期.   
        
   <h3 id="如何使用Redis做异步队列">如何使用Redis做异步队列</h3>          
        
   * 使用List作为队列,RPUSH生产消息,LPOP消费消息.   
        * 给队列中添加元素: rpush testlist aaa   
        * 逐条弹出队列里的信息: lpop testlist   
        * 缺点:没有等待队列里有值就直接消费   
        * 弥补:可以通过在应用层引入Sleep机制去调用LPOP机制.或者用BLOPL key [key...] timeout 阻塞直到有消息到来或者超时.   
         	    例如: blpop testlist 30    
        * 生产一次供多个消费者消费:    
         	pub/sub: 主题订阅者模式    
         	例如: subscribe myTopic  (订阅myTopic频道,无需事先定义频道)    
         		  publish myTopic "hello" (向topic里发信息)    
   
   
   <h3 id="Redis如何做持久化">Redis如何做持久化</h3>   
         
   * RDB(快照持久化): 保存某个时间点的全量数据快照.    
   
        * 配置:在redis.conf文件中:   
         
            1.    
             save 900 1    (在900s之内有1条写入就备份)    
             save 300 10   (在300s之内有10条写入就备份)    
             save 60 10000	(在60s之内有10000条写入就备份)    
             reids每个时段的读写请求都是不同的,为了平衡性能和数据安全的需要,需要根据自身redis得到情况进行合理配置多种策略.    
             
            2.    
             stop-writes-on-bgsave-error yes    
             当备份进程出错时,主进程就停止写入操作,为了保障持久化数据一致性的问题.    
            3.   
             rdbcompression no    
             在备份时,将rdb文件做压缩之后再缓存.建议关闭,因为带来更多CPU消耗.    
             备份文件保存在redis根目录的src文件下,dump.rdb.   
   
        * 主动触发持久化指令:       
         SAVE:阻塞Redis的服务进程,直到RDB文件被创建完毕.    
         BGSAVE:Fork出一个子进程来创建RDB文件,不阻塞服务器进程.    
         可以通过定时任务定期调用BGSAVE命令来备份RDB文件,并按照不同时间戳来存储:   
         lastsave发现时间变化了--> mv dump.rdb dumpxxxx.rdb   
   
        * 自动触发RDB持久化的方式:   
          1. 根据redis.conf配置里的SAVE m n 定时触发(用的是BGSAVE)      
          2. 主从复制时,主节点自动触发   
          3. 执行Debug Reload时   
          4. 执行Shutdown且没有开启AOF持久化   
   
        * BGSAVE的原理:   
           调用系统fork,创建一个子进程,实现Copy-on-Write (COW写时复制).父进程继续处理client请求,子进程负责将内存内容写入临时文件中,此时父子进程会共享相同的物理页面,当父进程处理写请求时,OS会为父进程要修改的页面创建副本,而不是写共享的页面,所以子进程保存的数据是fork时刻的数据.   
            * Copy-on-Write:   
              如果多个调用者同时要求相同资源,它们会共同获取相同的指针指向相同的资源,直到某个调用者试图修改资源时,系统才会真正复制一份副本给该调用者,而其他调用者所见到的最初的资源仍然保持不变.并在新数据写入完成后更新读指针.提升读写并发效率.   
   
        * RDB持久化缺点:    
           1. 内存数据的全量同步,数据量大会由于I/O而严重影响性能.    
           2. 可能会因为Redis挂掉而丢失从当前至最近一次快照期间的数据.  
   
   * AOF(Append-Only-File)持久化:    
        1. 记录下除了查询以外的所有变更数据库状态的指令    
        2. 以append的形式追加保存到AOF文件中.     
        * 配置: redis.conf中      
         appendonly yes        (开启AOF)   
         appendfsync everysec  (每隔一秒将缓存区的内存写入AOF)   
         重启以后在客户端: config set appendonly yes   
   
        * 随着写操作的不断增加,AOF文件会越来越大.     
         redis可以在不中断AOF的前提下,在后台重写AOF文件,原理:  
          1. 调用fork(),创建一个子进程.   
          2. 子进程把新的AOF写到一个临时文件里,把当前的内存数据直接生成命令,并不需要读取老AOF进行分析.   
          3. 主进程持续将新的变动同时写到内存和原来的AOF里.    
          4. 主进程获取子进程重写AOF的完成信号,往新的AOF同步增量变动.  
          5. 使用新的AOF文件替换掉旧的AOF文件.    
          主动触发: bgrewriteaof 指令   
          自动触发配置: ...  
   
        * redis数据的恢复:   
           RDB文件和AOF文件共存情况下的数据恢复流程:   
           重新启动redis,如果有aof文件,直接加载aof文件忽略rdb文件,如果没有aof,再来加载rdb文件.   
   
   * RDB和AOF的优缺点   
        * RDB:   
           优点: 全量数据快照,文件小,恢复快   
           缺点: 无法保存最近一次的快照之后的数据   
        * AOF:   
           优点: 可读性高,适合保存增量数据,数据不易丢失  
           缺点: 以redis命令的形式存储,文件体积大,恢复时间长  
   
        * RDB-AOF混合持久化方式   
           redis的4.0之后推出的混合持久化方式,并且作为默认配置.   
           BGSAVE做镜像全量持久化,AOF做增量持久化   
           先以RDB格式写入全量数据,再以AOF方式写入增量数据.从而减少文件的大小,也不会丢失数据.   
   
   <h3 id="使用Pipeline的好处">使用Pipeline的好处</h3>     
 
   * 通过pipeline一次性传入多条指令(比如2000w)去批量执行,节省多次IO往返的时间,为一次的时间.
   
   
   <h3 id="Redis的读写分离同步机制">Redis的读写分离同步机制</h3>  
   
   写操作在master上进行,读操作在slave上进行.   
   *  主从同步: 最终一致性
   		*	全量同步的过程:  
   			    1. 主节点做一次bgsave,并同时将后续修改操作记录到内存buffer.   
   				2. 主节点完成后将rdb文件全量同步到从节点.从节点加载rdb文件.  
   				3. 从节点加载完成后,再通知主节点将期间增量数据同步到从节点上.   
   
   		*	主从正常运行时增量同步的过程:    
   				1. master接收到用户的操作指令,判断是否需要传播到Slave.    
   				2. 将操作记录追加到AOF文件.  
   				3. 将操作传播到其他Slave: 1)对齐主从库  2)往响应缓存写入指令    
   				4. 将缓存中的数据发送给Slave 
   
   * 解决主从模式master宕机后服务不可用的问题:   
   	    利用Redis Sentinel(redis哨兵) , 它是一个独立的进程,监控多个master-slave集群,发现master宕机之后可以自动进行切换.包括如下功能:   
   		1. 监控: 检查主从服务器是否运行正常.   
   		2. 提醒: 通过API向管理员或者其他应用程序发送故障通知.  
   		3. 自动故障迁移: 主从切换(将失效的master下的slave升级为master)  
   
   * 流言协议Gossip:  
   		1. 每个节点都随机与对方通信,最终所有节点的状态打成一致.  
   		2. 种子节点定期随机向其他节点发送节点列表以及需要传播的消息.  
   		3. 不保证信息一定会传递给所有的节点,但是最终会趋于一致.  
   		区块链利用Gossip进行点对点的去中心化.   
   
   *	主从模式，主负责写，从节点负责读，怎么保证一定能从从节点读到最新的数据呢？如果读的时候刚好在写呢？     
   		这个保证不了，有这种強一致的需求的话建议还是从主库读，毕竟都会有延迟的。或者用dbproxy框架，有些dbproxy框架会把刚写进去又读的放到一个mysql connection里，这样来保证读写一致。   
   
   
   <h3 id="如何将不同的key均匀放在不同的redis集群节点">如何将不同的key均匀放在不同的redis集群节点</h3>     
   
   * redis集群:   
   将不同的key通过某个规则分散存储在多个redis节点上,即数据分片.redis-client采用无中心结构,每个节点都和其他节点连接,采用Gossip协议传播信息和发现新的节点.
      
   * 如何将不同的key均匀放在不同的redis集群节点
   
       * 获取key的hash值,然后对节点数量取模,来对应分配节点.缺点:当我们要动态地增减节点,会导致大量的key无法被命中.为解决这个问题,引入一致性哈希算法.
            *  一致性哈希算法:    
       		  	* 对2^32取模,将哈希值空间组成虚拟的圆环.按顺时针组织,圆环的正上方为0,0点右侧的第一个点为1,0点左侧的第一个点为(2^32-1)
       		  	* 选用服务的ip或者主机名作为关键字,来进行hash,来确定每台服务器在hash环上的位置.将key采用与服务器相同的hash函数来计数hash,确定key在环上的位置,然后顺时针行走第一个遇到的节点即为目标存储服务器. (见图)
       		  	
       		    ![用key计算在环上的位置.png](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E7%94%A8key%E8%AE%A1%E7%AE%97%E5%9C%A8%E7%8E%AF%E4%B8%8A%E7%9A%84%E4%BD%8D%E7%BD%AE.png "用key计算在环上的位置.png")
       		    
       		  	* 好处: 对服务器的增减只需重新定位一小段数据.比如C宕机,只有C那段数据会受影响,C段的数据会重新定位到D上. 新增服务器,同理.
   
       		*  哈希环的数据倾斜问题: (见图)    
       		  	* 在节点很少时会因为节点分布不均匀而造成大量数据集中缓存到某一台服务器上.    
       		  	
                ![哈希环的数据倾斜问题.png.png](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%93%88%E5%B8%8C%E7%8E%AF%E7%9A%84%E6%95%B0%E6%8D%AE%E5%80%BE%E6%96%9C%E9%97%AE%E9%A2%98.png "哈希环的数据倾斜问题.png.png")
                
       		*  引入虚拟节点解决数据倾斜问题: (见图)  
       		
       		    ![引入虚拟节点解决数据倾斜问题.png.png](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%BC%95%E5%85%A5%E8%99%9A%E6%8B%9F%E8%8A%82%E7%82%B9%E8%A7%A3%E5%86%B3%E6%95%B0%E6%8D%AE%E5%80%BE%E6%96%9C%E9%97%AE%E9%A2%98.png "引入虚拟节点解决数据倾斜问题.png.png")
       		
       		    * 为每台服务器计算虚拟节点,均匀分布到环上,多了一步虚拟节点到实体节点的映射,数据定位算法不变.这样相对较少的数据节点也能实现数据的均匀分布.
       		  	* 实际应用中将虚拟节点设置为32.  
   
   

<br>

<h2 id="Linux">Linux</h2>

<br>
   

   <h3 id="Linux的体系结构">Linux的体系结构</h3>      
 
   ![Linux的体系结构.png](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/Linux%E7%9A%84%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84.png "Linux的体系结构.png")   
   
   * 体系结构分为用户态和内核态:
		* 内核: 本质是一段管理计算机硬件设备的程序.
		* 系统调用: 内核的访问接口,是一种不能再简化的原子性操作.
		* 公用函数库: 系统调用的组合拳.
		* shell: 本质是命令解释器,下通系统调用,上通应用程序.   
			 比如:ls -lrt --> 在默认路径下找到ls的执行文件,并且将附带参数-lrt传入这个文件里面执行.   
		     echo $SHELL  --查看当前版本的shell     
		     cat /etc/shells  --查看本机器支持的shell版本   
		     
   <h3 id="查找特定的文件">查找特定的文件</h3>   

   * 语法: find path [options] params
	    
	    1. find ~ -name "target.java"     --在用户目录下查找文件(~可省略)
	    2. find / -name "target.java"     --在根目录下查找文件
	    3. find ~ -name "target.java"     --模糊查找文件
	    4. find ~ -iname "target*"        --不区分文件名大小写去查找文件.    

	     cd ./karl   "./"代表当前目录下     
	     cd  /karl   "/"代表根目录下   
 
   <h3 id="根据文件内容去筛选">根据文件内容去筛选</h3>     

   * 语法: grep [options] pattern file  
		* 作用: 查找文件里符合条件的字符串的行,支持正则表达式.    
	    * grep "java" target*   --查找target打头的文件夹下的包含java文本的行    

   * 管道操作符 |  
	    * 作用: 可将指令连接起来,前一个指令的输出作为后一个指令的输入   
	    * find ~ | grep "target"   --将"find ~"的输出结果作为grep "target"的输入参数.即在home下所有文件名查包含target的文件. 相当于 find ~ -name "target*"
	    * 管道注意的要点:   
	    	1. 只处理前一个命令正确输出,不处理错误输出.
	    	2. 右边命令必须能够接受标准输入流,否则传递过程中数据会被抛弃.
	    	3. 常用的接收数据管道的命令: sed,awk,grep,cut,head,top,less,more,wc,join,sort,split等.    

	    * 实现日志筛选功能 
	       1. grep 'partial\[true\]' bsc-data.info.log     在log文件里查出"partial[true]"的日志([]需要转义)   
	       2. grep -o 'engine\[[0-9a-z]*\]'   将-o上一步的输出结果作为输入结果,进一步筛出engine信息.    
	       grep 'partial\[true\]' bsc-data.info.log | grep -o 'engine\[[0-9a-z]*\]'   
	       3. grep -v "grep"        -v过滤掉包含"grep"的结果   
	       grep 'partial\[true\]' bsc-data.info.log | grep -o 'engine\[[0-9a-z]*\]' | grep -v "grep" 

   <h3 id="对文件内容做统计">对文件内容做统计</h3>   
   
   * 语法: awk [options] 'cmd' file     awk特别适合处理一些表格里的数据      
        1. 一次读取一行文本,按输入分隔符进行切片,切成多个组成部分
        2. 将切片直接保存在内建的变量中,$1,$2...($0表示行的全部)
        3. 支持对单个切片的判断,支持循环判断,默认分隔符为空格  
   * 例如:
       1. awk '{print $1,$4}' netstat.txt      筛出文件里某些列的数据    
    --netstat.txt文件中,将每一行数据按空格分片,过滤出每一行分片中第一片和第四片的信息.刷选文件可以是多个,只需按空格传入文件即可.
       2. awk '$1=="tcp" && $2==1 {print $0}' netstat.txt       依据一些条件来筛选某些列   
    --过滤出netstat.txt文件中满足每组分片,第一个分片="tcp"以及第二个分片="1"的信息.    
       3. 如果想要过滤的信息中带有表头:  
            NR==1 默认读取的数据行数是1       
            awk '($1=="tcp" && $2==1) || NR==1 {print $0}' netstat.txt   
       4. awk -F "," '{print $2}' test.txt   --  -F ","以","做为分隔符
       5. awk '{enginearr[$1]++}END{for(i in enginearr)print i "\t" enginearr[i]}'   
           对内容逐行统计操作,并列出统计结果.
           定义一个数组enginearr[],用它的下标保存引擎的名字,一旦有相同名字名字的引擎出现,就在原来的基础上累加作为数组元素的值;END{}扫描结束后进行的操作,结束之后遍历enginearr数组,将数组下标和对应的值打印出来.得到engine的名称和其对应出现的次数.
		      
   * grep过滤数据形成一些表格化的数据,再由awk来处理.   
          grep 'partial\[true\]' bsc-data.info.log | grep -o 'engine\[[0-9a-z]*\]' | awk '{enginearr[$1]++}END{for(i in enginearr)print i "\t" enginearr[i]}'          
          统计了各种engine出现的次数.
          
   <h3 id="批量替换文本内容">批量替换文本内容</h3>             
     
   - 语法 :  sed  [option]  'sed command'  filename
     
       - sed , 全名 : stream editor , 流编辑器 . 适合用于对文本的行内容进行处理
     
       - sed -i 's/^Str/String/' replace.java        将java文件中每行开头的Str替换为String
     
         's/^Str/String/'中 : "s"表示进行字符串操作 , 前两个"/"之间表示要替换的内容 , 后两个"/"之间表示要替换成的内容. "^Str" 表示以Str开头 . "-i" 表示改变文件的内容.
     
       - sed -i 's/\\.$/\;/'  replace.java        将java文件中每行末尾的.替换为;
     
         's/\\.$/\;/'中 :  "\\." 表示对"."进行转义 , "$"表示在每行的末尾 . 同样";"也需要转义 . 
     
       - sed -i 's/Jack/Tom/g'  replace.java          将java文件中的Jack替换为Tom(全文)
     
         第三个"/" 后面加g表示全文的替换 , 如果不加g表示将每行的第一个Jack替换掉.
     
       - sed -i '/Integer/d'  replace.java         将带有Integer的行删掉
     
         "d"表示删除
     
     
<h2 id="JVM">JVM</h2>

<br>

   <h3 id="JVM如何加载class文件">JVM如何加载class文件</h3>   

   ![JVM结构模型.png](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/JVM%E7%BB%93%E6%9E%84%E6%A8%A1%E5%9E%8B.png.jpg)

   - JVM 主要由一下四部分组成
     - Class Loader
       - 依据特定格式 , 加载class文件到内存
     - Runtime Data Area (JVM内存模型)
       - 包括Stack , Heap , Method Area , PC Register , Native Method Stack
     - Execution Engine
       - 对命令进行解析
     - Native Interface
       - 融合不同的开发语言的原生库为java语言所用

   <h3 id="什么是反射">什么是反射</h3>   

   ​	是在运行状态中, 对于任意一个类 , 或者一个对象 , 都能够直到这个类的所有属性和方法 , 这种动态获取信息以及动态调用对象的方法称为java语言的反射机制. 即 把java类中的各种成分一个个映射成java对象 . 

   - 写一个反射的例子(见代码)
     - 通过反射机制可以获取/调用类的私有属性以及私有的方法
     - rc.getDeclaredMethod(...) 可以获取到该类的私有和公有方法 , sayNameAndAge.setAccessible(true);但是不能获取到继承来的方法和实现接口的方法 . 
     - rc.getMethod(...) 不能获取到该类的私有方法 , 可以获取到该类的继承方法和实现接口的方法

   <h3 id="谈谈ClassLoader">谈谈ClassLoader</h3>   

   - ClassLoader主要负责将Class里的二进制数据流装载进系统 , 然后交给java虚拟机进行连接 , 初始化等操作 .

   - ClassLoader的种类

     - BootStrapClassLoader : 由C++编写 , 加载java的核心库java.*

     - ExtClassLoader : java编写 , 加载扩展库javax.*

     - AppClassLoader : java编写 , 加载程序所在目录

     - 自定义ClassLoader : java编写 , 自定义加载 (见代码)

       MyClassLoader --> loadClass --> findClass --> loadClassData --> defineClass

   - 谈谈类加载器的双亲委派机制

     ![类加载器的双亲委派机制](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E7%9A%84%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%9C%BA%E5%88%B6.jpg)

   - 为什么使用双亲委派机制去加载类

     - 避免多分同样的字节码被重复加载 , 保证内存中只有一份.

   - 何如通过openJDK查看native对应的代码 ?

     openJDK , http://hg.openjdk.java.net/jdk8u/jdk8u/jdk/ , browse/src/share(不依赖于平台部分的代码) /native / java / lang

   <h3 id="类的加载方式">类的加载方式</h3>   

   - 隐式加载 : new  : 通过new生成对象时 , 隐式调用类加载器 , 加载对应的class到JVM中 . 

   - 显示加载 : loadClass , forName等 , 还要通过newInstance来得到类的对象 . 

   - loadClass 和 forName的区别 : 

     - 类的装载过程:

       - 通过ClassLoader加载class文件字节码 , 生成Class对象
       - 链接 : 校验 : 检查加载的class的正确性和安全性

       ​	          准备 : 为类变量( static )分配存储空间并设置类变量初始值

       - 初始化 : 执行类变量赋值和静态代码块

     - Class.forName得到的class是已经初始化完成的 , 适用于加载class时就需要完成初始化的场景 , 比如mysql-connector中的Driver中有一段static的初始化代码段 , 我们需要用forName来加载它 . 

     - Class.loadClass得到的class是还没有链接的(只完成了第一步) . 比如spring的ioc , 在初始化bean时 , 为了加快初始化速度 , 对于bean的加载采用延迟加载lazy-loading , 不执行类中的初始化代码 , 到用到这个类时才进行初始化操作 , 就需要用到loadClass的加载方式.

   <h3 id="Java的内存模型">Java的内存模型</h3>   

   ​	![JVM内存模型](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/JVM%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B.jpg)

   - 程序计数器 , 每个线程都有一个程序计数器 , 只对Java方法计数 . 

   - java虚拟机栈( Stack ) , 里面存储多个栈帧 ,每调用一个方法 , 就在栈中生成一个栈帧 , 每一个方法从调用开始至执行完成的过程，都对应着一个栈帧在虚拟机里面从入栈到出栈的过程，在活动线程中，只有位于栈顶的栈帧才是有效的，称为当前栈帧，与这个栈帧相关联的方法称为当前方法。方法调用结束后 , 栈帧就会被自动释放掉 (不需要通过GC回收), 每个栈帧中包含 : 局部变量表 , 操作栈 , 动态连接 , 返回地址 等

     - 局部变量表 : 包含方法执行过程中的所有变量
     - 操作数栈 : 入栈 , 出栈 , 复制 ,交换 等产生的变量

     执行时按程序计数器的数从大到小压入栈 , 再按从小到大的顺序来执行 . 

     - 递归为什么会引起StackOverFlow异常 ? 

       - 什么是斐波那契函数 ?

         F(0) = 0 , F(1) = 1 , 当你>= 2 时 , F(n) = F( n - 1 ) + F( n - 2 );

       ```java    
        public static int fibonacci(int n) {
               if (n == 0) return 0;
               if (n == 1) return 1;
               return fibonacci(n - 1) + fibonacci(n - 2);
           }
       ```

       - 因为每次递归都会往栈里面压一个栈帧 , 递归过深 , 栈帧超出了虚拟栈的深度 . 

   - 本地 方法栈

     - 与虚拟机栈相似 , 主要作用于native的方法

   - 元空间 (MetaSpace)

     - 放类的加载信息 , 类中的属性和方法
     - java8以后 , 元空间( MetaSpace ) 替换了永久代( PermGen ) , 用来存储class相关信息 , 包括class对象的method以及field , 元空间与永久代均是方法区的实现(方法区只是JVM的一种规范) , java7以后字符串常量池从方法区中移动到了java堆中. MetaSpace 与 PermGen最大的区别是 , 元空间使用的是本地内存 , 而永久代使用的是JVM的内存 . 内存分配更合理 , 不会动不动就出现永久代内存溢出的异常 . 

   - Java堆( Heap )

     - 包括常量池( 放字符串常量, 符号常量)
     - 放 数组 , 类对象.

   <h3 id="JVM三大性能调优参数">JVM三大性能调优参数</h3>  
    
   JVM三大性能调优参数 -Xms -Xmx -Xss的含义    
    
   java -Xms128m -Xmx128m -Xss256k -jar xxx.jar

   - -Xss : 规定了每个线程虚拟机栈( 堆栈 )的大小 .  一般256k足够 .
   - -Xms : 创建时的java堆的初始大小 . 
   - -Xmx : java堆的最大值 . 通常将Xms与Xmx的值设为一样 , 因为堆扩容时会发生内存抖动 , 影响程序稳定 .
   - **那么spring boot 环境下，tomcat的运行模式是哪种**
     - SpringBoot默认是以 `java -Xmx256m -Xss256k -jar xx.jar` 来运行内置Tomcat启动方式默认是NIO (非阻塞IO , 基于IO多路复用技术实现，只需要一个线程或者少量线程，就可以处理大量请求 , 而Tomcat7及以前采用BIO , 阻塞IO ,一个请求就用一个线程来处理 , 不适用于高并发场景)

   <h3 id="Java内存模型中堆和栈的区别">Java内存模型中堆和栈的区别</h3>  
   - 内存分配策略 : 

     - 栈式存储 : 数据区需求在编译时未知 , 运行时模块入口前确定内存大小
     - 堆式存储 : 编译时或运行时模块入口都无法确定内存大小 , 程序运行时才动态分配 . 比如可变长度串和对象实例 . 

   - 联系 : 

     引用对象 / 数组时 , 栈里定义局部变量保存堆中目标的首地址 . 

   - 管理方式 : 

     JVM执行机制可以自动释放栈空间 (方法结束时) , 堆内存需要GC释放 .

   - 分配方式 : 

     栈支持静态和动态分配 , 而堆仅支持动态分配 . 

   - 效率

     栈(Stack数据结构)只支持入栈和出栈的操作 , 效率高 , 但不如堆更灵活 ,堆(双向链表)的优势在于动态分配 . 

   <h3 id="元空间/堆/线程独占部分的联系">元空间/堆/线程独占部分的联系</h3>  

   例如一下代码 : 

   ```java
   public class HelloWorld {
       private String name;
       public void setName(String name) {
           this.name = name;
       }
       public void sayHello() {
           System.out.println("hello " + name);
       }
       public static void main(String[] args) {
           int a = 1;
           HelloWorld hw = new HelloWorld();
           hw.setName("test");
           hw.sayHello();
       }
   }
   ```

   元空间 : 

   Class : HelloWorld - Method : sayHello/setName/main - Field : name

   Class : System

   Java堆 : 

   Object : String( "test" )

   Object :  HelloWorld 

   线程独占 (栈) : 

   局部变量 test , 保存String 对象的引用 .

   局部变量 hw , 保存HelloWorld 对象的引用 .

   局部变量 a , 保存的常量 1 .

   代码的行号

   - 在idea中改变永久代的大小 :

      run --> Edit Configration --> 选定方法 --> VM options --> 输入 -XX:MaxPermSize=6M  -XX:PermSize=6M

     JDK6之后字符串常量池移到堆中了 , 不在永久代里了 . 

   <h3 id="不同版本间intern方法的表现">不同版本间intern方法的表现</h3> 

   JDK6 : 如果s字符串常量池中没有该字符串 , 则将字符串添加进常量池中 , 返回字符串在常量池中的引用 ; 如果字符串常量池中有该字符串 , 则直接返回字符串在常量池中的引用 . 

   JDK6+ : 如果字符串常量池中没有该字符串 , 则将字符串在堆中的引用添加进常量池中 , 返回该引用 ; 如果字符串常量池中有该字符串 , 则直接返回字符串在常量池中的引用 .  如果堆中不存在 , 则在池中创建该字符串并返回其引用 .     

   ```java   
   String s1 = new String("a");
   s1.intern();
   String s2 = "a";
   System.out.println( s1 == s2 );
   
   String s3 = new String("a") + new String("a");
   s3.intern();
   String s4 = "aa";
   System.out.println( s3 == s4 );
   ```

   在JDK6下 : 

   ​	false

   ​	false

   分析:  

   s1 == s2 : "a" 会直接在字符串常量池中创建出来 ,  而new String都是在Java的堆中创建出来的 . 因为字符串常量池中以及有了 , 所以s1.intern()没有效果 ,s1是字符串对象在堆中的地址 , s2是字符串在字符串常量池中的地址 .故 s1 != s2 ;

   s3 == s4 : 在堆中生成"aa"对象 , s3.intern()发现常量池中没有该字符串 , 将"aa"的副本放入常量池(注意此时字符串常量池与堆式独立的)中 , s3是堆中的"aa"对象的地址 , s4是常量池中的"aa"的地址 . 故 s3 != s4 ; 

   ![intern-jdk6](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/intern-jdk6.jpg)

   在JDK6+下 :

   ​	false

   ​	true

   分析 :

   s1 == s2 与上面分析同理;

   s3 == s4 : 在堆中生成"aa"对象 , 字符串常量池中没有"aa" , 将堆中"aa"对象的地址放入常量池中(注意此时常量池也放入堆中了) , s3 是"aa"在堆中的地址 , s4也是堆中的引用 , 故 s3 == s4 ;

   ![intern-jdk7](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/intern-jdk7.jpg)


<br>

<h2 id="GC">GC</h2>

<br>

   <h3 id="Java对象被判定为垃圾的标准是什么">Java对象被判定为垃圾的标准是什么</h3>  

   - 没有被其他对象引用

   <h3 id="判定对象是否为垃圾的算法">判定对象是否为垃圾的算法</h3>  

   - 引用计数算法

     通过判断对象的引用数量来决定对象是否可以被回收 

     - 每个对象实例都有一个引用计数器 , 被引用则 + 1 ,完成引用则 - 1
     - 任何引用计数为0的对象实例可以被当做垃圾收集
     - 优点 : 执行效率高 , 程序执行受影响小
     - 缺点 : 无法检测出循环引用的情况 , 导致内存泄漏

   - 可达性分析算法

     通过可达性算法判断对象的引用链是否可达来决定对象是否可以被回收

     - 从一系列GC root节点作为起始点用可达性算法向下搜索 , 所走过的路径称为引用链(Reference chain) . 如果一个对象不在引用链上 , 会被表明不可达 , 被回收 . 
     - 可以作为GC Root的对象
       - 虚拟机栈中的引用的对象
       - 方法区中的常量引用的对象
       - 方法区中的类静态属性引用的对象
       - 本地方法栈中JNI( Native方法 )的引用对象
       - 活跃线程的引用对象

   <h3 id="垃圾回收的算法">垃圾回收的算法</h3>  

   - 标记-清除算法(Mark and Sweep)   ---- 适用于老年代

     - 标记 : 用可达性算法从root节点开始扫描 , 对可达对象进行标记

       清除 : 对堆内存从头到尾进行线性遍历 , 回收不可达的对象内存

     - 缺点 :  仅对不存活的对象进行处理 , 因此在清除之后会产生大量不连续的内存碎片 , 导致以后无法分配较大的连续内存 , 而提前触发另一次GC.

   - 复制算法 ( Copying ) -- 适用于年轻代

     - 分为对象面和空闲面 , 对象在对象面上创建 , 当对象面的空间用完 , 就将存活的对象从对象面复制到空闲面 , 再将对象面的所有对象内存清除 . 每次都对整个半区进行整体的内存回收 , 无需考虑内存碎片 , 适用于对象存活率较低的场景 , 比如年轻代 . 

       ![复制算法](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%A4%8D%E5%88%B6%E7%AE%97%E6%B3%95.jpg)

   - 标记- 整理算法 ( Compacting )  -- 适用于老年代

     - 标记 : 用可达性算法从root节点开始扫描 , 对可达对象进行标记

       清除 : 移动所有存活的对象 , 且按照内存地址次序依次排列 , 然后将末端内存地址以后的内存全部回收 . 

     - 解决了内存碎片的问题 , 适用于存活率高的场景 . 

   - 分代收集算法 ( Generational Collector )

     - 按照对象生命周期的不同划分区域以采用不同的垃圾回收算法

     - jdk6/jdk7 

       年轻代 / 老年代 / 永久代

     ![jdk6,7的堆内存划分](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/jdk6%2C7%E7%9A%84%E5%A0%86%E5%86%85%E5%AD%98%E5%88%92%E5%88%86.jpg)

     - jdk8

       年轻代 / 年老代

       ![jdk8堆内存的划分](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/jdk8%E5%A0%86%E5%86%85%E5%AD%98%E7%9A%84%E5%88%92%E5%88%86.jpg)

   <h3 id="分代收集算法(Generational-Collector)">分代收集算法(Generational-Collector)</h3>  

   - GC的分类

     - Minor GC -- 发生在年轻代中的垃圾收集动作 , 采用复制算法

       - 年轻代 : 尽可能快速地收集那些生命周期短的对象

         - Eden区 : 新的对象刚创建时分配在此 . 

         - 两个Survivor区 (一个from区 , 一个to区 , 不断变化的)

           ![年轻代](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%B9%B4%E8%BD%BB%E4%BB%A3.jpg)

       - 年轻代垃圾回收的过程

         - Eden区空间不足时 , 触发Minor GC . 
         - 将Eden和一块Survivor上的存活对象一次性复制到另一个Survivor上 , 清理掉Eden和一块Survivor的全部对象 , 当Survivor不够用了 , 需要依靠老年代做担保 . 

       - 年轻代对象如何晋升到老年代

         - 存活对象每经过一个GC , 它的年龄就 +１，或年龄超过( -XX:MaxTenuringThreshold 默认为15) , 会被移入老年代 .
         - Survivor区中存放不下的对象 , 会移入老年代. 
         - 新生成的大对象 ( -XX: +PretenuerSizeThreshold 设置对象大小)

       - 常用的调优参数

         - -XX:SurvivorRatio : Eden和Survivor的比值 , 默认 8 : 1
         - -XX:NewRatio : 老年代和年轻代内存大小的比例 , 默认 2 : 1
         - -XX:MaxTenuringThreshold : 对象从年轻代晋升到老年代经过GC次数的最大阈值 . 

     - Full GC

       - 老年代 : 存放生命周期较长的对象 , 用标记-清理算法 / 标记-整理算法 

       - 通常Full GC也会对年轻代进行垃圾回收 . 

         Major GC 要问清楚是指full GC 还是只针对年老代的GC

         Full GC比Minor GC慢 , 执行效率低

       - 触发Full GC的条件

         - 老年代空间不足

         - 永久代空间不足 (JDK7以前)

           所以jdk8用元空间代理永久代 , 减少了Full GC的频率 , 降低了GC负担.

         - CMS GC时出现promotion failed , concurrent mode failure

         - Minor GC晋升到老年代的平均大小大于老年代的剩余空间

         - 调用System.gc(); 这里只是程序员提醒JVM进行GC , 决定权在JVM手里 .

         - 使用RMI来进行RPC或管理JDK应用 , 每小时执行一次Full GC;

   <h3 id="GC中什么是Stop-the-World">GC中什么是Stop-the-World</h3>  

   - JVM由于要执行GC而停止了应用程序的执行 , 除了GC线程外 , 其他线程都处于等待状态 . 
   - 任何一种GC算法中都会发生
   - GC的优化就是要减少Stop-the-world发生的时间来提高程序的吞吐量

   <h3 id="什么是Safepoint">什么是Safepoint</h3>  

   - 是分析过程中对象引用关系不会发生变化的点 , 一旦GC发生 , 让所有的线程跑到安全点再停顿下来 . 
   - 安全点的数量不能太少 , 会增加GC等待的时间 ; 不能太多 , 会增加程序运行的负荷 . 

   <h3 id="JVM的运行模式">JVM的运行模式</h3>  

   - Server : 启动慢 , 长期运行时执行速度快 , 因为Server模式启动的是重量级的虚拟机 , 堆程序采用了更多的优化 .
   - Client :  启动快 , 长期运行时执行速度慢 , Client模式采用的轻量级虚拟机 . 
   - java -version 查看 :   比如 "Server VM"

   <h3 id="常见的垃圾收集器">常见的垃圾收集器</h3>  

   - 垃圾收集器之间的联系

     ![垃圾收集器之间的联系](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%9E%83%E5%9C%BE%E6%94%B6%E9%9B%86%E5%99%A8%E4%B9%8B%E9%97%B4%E7%9A%84%E8%81%94%E7%B3%BB.jpg)

   - 年轻代常见垃圾收集器

     - Serial收集器 ( -XX: +UserSerialGC , 复制算法 )
       - 单线程收集 , 进行垃圾收集时 , 必须暂停所有的工作线程 (停顿在几十ms到一百ms之间)
       - 简单高效 , Client 模式下默认的年轻代收集器
     - ParNew收集器 ( -XX: +UseParNewGC , 复制算法 )
       - 多线程收集 , 其余的行为特点和Serial收集器一样
       - 单核执行效率不如Serial , 在多核执行才有优势 . (可以与CMS配合)
     - Parallel Scavenge收集器 ( -XX: +UseParallelGC , 复制算法 )
       - 吞吐量 = 运行用户代码时间 / ( 运行用户代码时间 + 垃圾收集时间 )
       - 比起关注用户线程停顿时间 , 更关注系统的吞吐量
       - 在多核执行才有优势 , Server模式下默认的年轻代收集器
       - 优化时配合自适应调节策略 : -XX: +UseAdaptiveSizePolicy 把内存管理的调优任务交给JVM区完成 . 

   - 老年代常见的垃圾收集器

     - Serial Old收集器 ( -XX:+UseSerialOldGC , 标记-整理算法 )

       - 单线程收集 , 进行垃圾收集时 , 必须暂停所有工作线程
       - 简单高效 , Client模式下默认的老年代收集器

     - Parallel Old收集器 ( -XX: +UseParallelOldGC , 标记-整理算法 )

       - 多线程 , 吞吐量优先
       - Parallel Scavenge + Parallel Old 搭配使用 , 适用注重吞吐量和CPU资源敏感的场合

     - CMS收集器 ( -XX: +UseConcMarkSweepGC , 标记-清除算法 )

       - 垃圾回收线程几乎能与用户线程做到同时工作 (一边打扫一边丢垃圾) , 即Stop-the-world尽可能被缩短 , 适用于对停顿敏感 , 并且可以提供更大的内存和CPU(更好的硬件) , 适合有较多存活时间长的对象 .  

       - CMS收集垃圾的过程 :

         1. 初始标记: 会短暂暂停JVM , 只扫描并标记到能够和根对象直接关联的对象 . 

         2. 并发标记 : 并发追溯标记 , 程序不会停顿 .

         3. 并发预清理 : 查找执行并发标记阶段从年轻代晋升到老年代的对象 . 

         4. 重新标记 : 暂停JVM , 扫描CMS堆中的剩余对象

         5. 并发清理 : 清理垃圾对象 , 程序不停顿

         6. 并发重置 : 重置CMS收集器的数据结构

            ![CMS工作流程图](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/CMS%E5%B7%A5%E4%BD%9C%E6%B5%81%E7%A8%8B%E5%9B%BE.jpg)

       - 缺点 : 采用的标记-清除算法 , 会产生不连续的内存碎片 , 当要存储一个较大的对象时 , 会触发GC . 

   - 既能用于年轻代 , 可能用于老年代的收集器

     - G1收集器 (-XX: +UseG1GC , 复制 + 标记-整理算法 )
       - 将整个Java堆内存划分成多个大小相等的Region
       - 年轻代和老年代不再物理隔离 , 不需要在JVM启动时就决定那些Region属于年轻代 , 哪些属于年老代
       - Garbage First收集器的特点
         - 并行和并发 
         - 独立管理整个堆 , 分代收集 
         - 空间整合 (基于标记-整理算法 , 解决内存碎片问题)
         - 可预测的停顿 ( 可以设置停顿时间不超过m毫秒)

   - jdk11正在开发的两个垃圾收集器 : EpsilonGC 和 ZGC

   <h3 id="Object的finalize()方法的作用是否与C++的析构函数作用相同">Object的finalize()方法的作用是否与C++的析构函数作用相同</h3>  

   - 与C++的析构函数不同 , 析构函数调用确定(即在对象离开作用域之后会被delete掉), 而它的是不确定的 . 

   - 将未被引用的对象放置于F- Queue队列 , 并在稍后由一个低优先级的finalize线程去处理 . 

   -  由于是低优先级 , 方法的执行随时可能被终止 . 

   - finalize()的作用是给对象最后一次重生的机会

   - finalize()运行不确定性较大 , 运行代价高 , 不建议使用 

   - 举例 : 

     ```java   
     public class Finalization {
     
         public static Finalization finalization;
     
         @Override
         protected void finalize() {
             System.out.println("into finalize");
             finalization = this;    1
         }
     
         public static void main(String[] args) {
             Finalization f = new Finalization();
             System.out.println("first print: " + f);
             f = null;
             // gc()会调用我们重写的finalize()方法
             System.gc();
             System.out.println("second print: " + f);
             System.out.println(f.finalization);
         }
     }
     ```

     运行结果为:

     > first print: com.guoguo.javaAudition.gc.Finalization@7440e464
     > second print: null
     > into finalize
     > null

     最后一个结果为null , 表明finalize()方法中的finalization = this 没有被执行到该方法就被终止了 . 可以在Sysyem.gc()之后加一个等待 , 让finalize()方法执行完 . 结果为 : 

     > first print: com.guoguo.javaAudition.gc.Finalization@7440e464
     > into finalize
     > second print: null
     > com.guoguo.javaAudition.gc.Finalization@7440e464     
     
   <h3 id="Java中的强引用,软引用,弱引用,虚引用">Java中的强引用,软引用,弱引用,虚引用</h3>    

   - 强引用 (Strong Reference )

      - 最普遍的引用: Object obj = new Object();
      - 抛出OutOfMemoryError终止程序也不会回收具有强饮用的对象
      - 通过将对象设置为null来弱化引用 , 使其被回收

   - 软引用 (Soft Reference )

      - 对象处在有用但非必须的状态

      - 只有当内存空间不足时  , GC会回收该引用的对象的内存

      - 可以用来实现高速缓存

        ```java   
        String str = new String("abc");          // 先强引用声明
        SoftReference<String> softRef = new SoftReference<String>(str);              // 软引用
        
        ```

   - 弱引用 (Weak Reference )

      - 非必须对象 , 比软引用更弱一些

      - GC时会被回收

      - 被回收的概率也不大 , 因为GC线程优先级比较低

      - 适用于引用偶尔被使用且不影响垃圾收集的对象

        ```java   
        String str = new String("abc");
        WeakReference<String> weakRef = new WeakReference<String>(str);           // 虚引用
        
        ```

   - 虚引用 (PhantomReference )

      - 不会决定对象的生命周期

      - 任何时候都可能被垃圾收集器回收

      - 跟踪对象被垃圾收集器回收的活动 , 起哨兵作用

      - 必须和引用队列ReferenceQueue联合使用

        ```java   
        String str = new String("abc");
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(str, queue);
        
        ```

   - 四种引用的比较

   ![java中的四种引用](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/java%E4%B8%AD%E7%9A%84%E5%9B%9B%E7%A7%8D%E5%BC%95%E7%94%A8.jpg)

   <h3 id="引用队列(ReferenceQueue)的作用">引用队列(ReferenceQueue)的作用</h3>  

   - 无实际存储结构 , 存储逻辑依赖于内部节点之间的关系表达
   - 存储关联的且被GC的软引用 , 弱引用以及虚引用




<br>

<h2 id="消息队列">消息队列</h2>

<br>
   

  <h3 id="为什么要引入消息中间件">为什么要引入消息中间件</h3>  

  - 系统解耦

    - 比如系统A，这个系统A会产出一个核心数据，现在下游有系统B,C,D,E需要这个数据。然后如果要是某个下游系统突然宕机了呢？系统A的调用代码里是不是会抛异常？
    - 那系统A的同学会收到报警说异常了，结果他还要去care是下游哪个系统宕机了,这样系统耦合度太严重.就采用MQ中间件来实现系统解耦,系统A就把自己的一份核心数据发到MQ里，下游哪个系统感兴趣自己去消费即可.

  - 异步调用

    - 假设你有一个系统调用链路，是系统A调用系统B，一般耗时20ms；系统B调用系统C，一般耗时200ms；系统C调用系统D，一般耗时2s. 可以将系统D从链路中抽离出去做成异步调用,大幅度提高全链路的性能. 
    - 比如点外卖,创建订单、通知商家、分配骑手,那这个找骑手的过程，是需要一套复杂算法来实现调度的，比较耗时. 就可以把找骑手给你送餐的这个步骤从链路中抽离出去，做成异步化的，哪怕延迟个几十秒，但是只要在一定时间范围内给你找到一个骑手去送餐就可以了。

  - 流量削峰

    - MQ中间件来进行流量削峰。所有机器前面部署一层MQ，平时每秒几百请求大家都可以轻松接收消息。

    - 一旦到了瞬时高峰期，一下涌入每秒几千的请求，就可以积压在MQ里面，然后那一台机器慢慢的处理和消费。

    - 等高峰期过了，再消费一段时间，MQ里积压的数据就消费完毕了。
    
   <h3 id="引入消息中间件之后会有哪些缺点">引入消息中间件之后会有哪些缺点</h3>      

  - 系统可用性降低

    - 一旦引入了MQ中间件，你就必须去考虑这个MQ是如何部署的，考虑如果MQ一旦挂了以后，你的系统有没有备用兜底的技术方案，可以保证系统继续运行下去,即高可用保证方案.

  - 系统稳定性降低

    - 消息会丢失
    - 消息会重复insert
    - 百万消息积压在消费者实例里导致OOM

  - 分布式一致性问题

    - 举个例子，比如说系统C现在处理自己本地数据库成功了，然后发送了一个消息给MQ，系统D也确实是消费到了。但是系统D操作自己本地数据库失败了,系统C成功了，系统D失败了，会导致系统整体数据不一致。

  <h3 id="消息中间件全链路100%数据不丢失(三个方面)">消息中间件全链路100%数据不丢失(三个方面)</h3> 

  1. **生产端如何保证投递出去的消息不丢失**消息在半路丢失，或者在MQ内存中宕机导致丢失，此时你如何基于MQ的功能保证消息不要丢失？
  2. **MQ自身如何保证消息不丢失**起码需要让MQ对消息是有持久化到磁盘这个机制。
  3. **消费端如何保证消费到的消息不丢失**如果你处理到一半消费端宕机，导致消息丢失，此时怎么办？
      
   <h3 id="如果消费者接收到消息,完成消息之前宕机怎么办?">如果消费者接收到消息,完成消息之前宕机怎么办?</h3>  

  - 将自动ack关闭, 改为手动ack , 在消费者处理完成后手动提交ack. 一旦MQ发现代表消费者的某个仓储服务实例突然宕机了，而这个仓储服务收到的一些订单消息还没来得及处理，没给自己发送那些消息的ack通知。

    此时，RabbitMQ会自动对这条订单消息重发推送给其他在运行中的仓储服务实例，让其他的仓储服务实例去处理这条订单消息。


   <h3 id="分析一下消费者手动ack机制保证消息不丢失的底层原理">分析一下消费者手动ack机制保证消息不丢失的底层原理</h3>      

  - delivery tag .  RabbitMQ就会通过自己内部的一个**“basic.delivery”**方法来投递消息到仓储服务里去，让他消费消息。

    投递的时候，会给这次消息的投递带上一个重要的东西，就是**“delivery tag”**，你可以认为是本次消息投递的一个**唯一标识**。

  - channel . 每个消费者从RabbitMQ获取消息的时候，都是通过一个channel的概念来进行的 , 这个channel就是进行数据传输的一个管道 .  delivery tag仅仅在一个channel内部是唯一标识消息投递的。所以说，你ack一条消息的时候，必须是通过接受这条消息的同一个channel来进行。

    ![channel](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/mq_channel.png)

  - 其实这里还有一个很重要的点，就是我们可以设置一个参数，然后就批量的发送ack消息给RabbitMQ，这样可以提升整体的性能和吞吐量。

    比如下面那行代码，把第二个参数设置为true就可以了。   
    

    ```java
    channel.basicAck(
    
    ​            delivery.getEnvelope().getDeliveryTag(), 
    
    ​            true);
    ```

    

  - **仓储服务处理失败时的消息重发** , 某个仓储服务实例处理某个消息失败了，此时会进入catch代码块 , 使用nack操作 , 通知RabbitMQ自己没处理成功消息，然后让RabbitMQ将这个消息再次投递给其他的仓储服务实例尝试去完成调度发货的任务。

    ![try-catch代码](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/mq_%E6%B6%88%E8%B4%B9%E8%80%85_try-catch%E4%BB%A3%E7%A0%81.png)

    

    ```java
    channel.basicNack(
    
    ​            delivery.getEnvelope().getDeliveryTag(), 
    
    ​            true);
    ```

    

  - **RabbitMQ如何感知到仓储服务实例宕机** ???

  - **unack消息的积压问题** ,  对于每个channel而言，其实都有一些处于unack状态的消息。

    - 比如RabbitMQ正在投递一条消息到channel，此时消息肯定是unack状态.
    - 然后仓储服务接收到一条消息以后，要处理这条消息需要耗费时间，此时消息肯定是unack状态.
    - 即使你执行了ack之后，你要知道这个ack他默认是异步执行的，尤其如果你开启了批量ack的话，更是有一个延迟时间才会ack的，此时消息也是unack.
    - 如果RabbitMQ给你的消费者服务实例推送的消息过多过快，比如都有几千条消息积压在某个消费者服务实例的内存中。那么此时这几千条消息都是unack的状态，一直积压着，有可能会导致消费者服务实例的内存溢出？内存消耗过大？甚至内存泄露之类的问题产生？

  - RabbitMQ基于一个**prefetch count**来控制这个unack message的数量。可以通过 **“channel.basicQos(10)” **这个方法来设置当前channel的prefetch count。

    - prefetch count设置过大 , 比如说3000，5000 ,  在高并发大流量的场景下，可能就会导致消费者服务的内存被快速的消耗掉 , 服务宕机，然后大量unack的消息会被重新投递给其他的消费者服务，此时其他消费者服务一样的情况，直接宕机，最后造成**雪崩效应**。
    - prefetch count设置过小 , 比如 prefetch count = 1 .  此时你刚处理完这条消息，然后执行了ack的那行代码，结果不幸的是，ack需要异步执行，也就是需要100ms之后才会让RabbitMQ感知到。在这100ms期间，你的消费者服务啥都没干 , 这不就直接导致了你的消费者服务处理消息的吞吐量可能下降10倍，甚至百倍，千倍 .
    - RabbitMQ官方给出的建议是**prefetch count一般设置在100~300之间。**

  - **总结** : 消费端的代码里，必须考虑三个问题：

    - **手动ack、**
    - **处理失败的nack、**
    - **prefetch count的合理设置**

    这三个问题背后涉及到了各种机制：

    - 自动ack机制

    - delivery tag机制

    - ack批量与异步提交机制

    - 消息重发机制

    - 手动nack触发消息重发机制

    - prefetch count过大导致内存溢出问题

    - prefetch count过小导致吞吐量过低

  <h3 id="如何保证消息中间件里的消息不会丢失? (消息的持久化)">如何保证消息中间件里的消息不会丢失? (消息的持久化)</h3>  

  - 在创建queue时 , 有个参数 , 将其设置为true ,  表示创建的queue是durable的，也就是支持持久化的。

  - 生产者发送消息到MQ的时候，需要定义这条消息也是durable，即持久化的。

  - RabbitMQ的消息持久化，是不承诺100%的消息不丢失的。因为有可能RabbitMQ接收到了消息，但是还没来得及持久化到磁盘，他自己就宕机了，这个时候消息还是会丢失的。需要依靠其他的机制。

   <h3 id="在某次高峰期间MQ中间件故障的情况下的卡死情况">在某次高峰期间MQ中间件故障的情况下的卡死情况</h3>      

  - 我们的核心思路是一旦MQ中间件故障，触发降级机制之后，系统接收到一条请求不是立马写本地磁盘，而是采用**内存双缓冲 + 批量刷磁盘的机制**。

    - 这个内存缓冲实际在设计的时候，分为了两个区域。

    - 一个是current区域，用来供系统写入数据，另外一个是ready区域，用来供后台线程刷新数据到磁盘里去。

    - 每一块内存区域设置的缓冲大小是512kb，系统接收到请求就写current缓冲区，但是current缓冲区总共就512kb的内存空间，因此一定会写满。current缓冲区写满之后，就会交换current缓冲区和ready缓冲区。交换过后，ready缓冲区承载了之前写满的512kb的数据。然后current缓冲区此时是空的，可以继续接着系统继续将新来的数据写入交换后的新的current缓冲区。

      ![内存双缓冲机制](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/mq_%E5%86%85%E5%AD%98%E5%8F%8C%E7%BC%93%E5%86%B2%E6%9C%BA%E5%88%B6.png)

    - 此时，后台线程就可以将ready缓冲区中的数据通过Java NIO的API，直接高性能append方式的写入到本地磁盘文件里。当然，这里后台线程会有一整套完善的机制，比如说一个磁盘文件有固定大小，如果达到了一定大小，自动开启一个新的磁盘文件来写入数据。

    - 但是 , 某一次高峰期，系统请求压力达到了平时的10倍以上 , 瞬时涌入的高并发请求一下将current缓冲区写满，然后两个缓冲区交换，后台线程开始刷新ready缓冲区的数据到磁盘文件里去。结果因为高峰期请求涌入过快，导致ready缓冲区的数据还没来得及刷新到磁盘文件，此时current缓冲区又突然写满了。所有机器上部署的实例全部线程都卡死，处于wait的状态。

    - 解决方法就是对线上系统扩容双段缓冲的大小，从512kb扩容到一个缓冲区10mb。

  <h3 id="消息中间件的生产端如何保证数据不丢失">消息中间件的生产端如何保证数据不丢失</h3> 

  - 有一种重量级的机制，就是**事务消息机制**。采用类事务的机制把消息投递到MQ，可以保证消息不丢失，但是性能极差，经过测试性能会呈现几百倍的下降。

  - **保证投递消息不丢失的confirm机制**
    - 生产端（比如订单服务）首先需要开启一个confirm模式，接着投递到MQ的消息，如果MQ一旦将消息持久化到磁盘之后，必须也要回传一个confirm消息给生产端。如果没有接收到confirm消息，那么就说明这条消息半路可能丢失了，此时你就可以重新投递消息到MQ去，确保消息不要丢失。
    - 一旦你开启了confirm模式之后，每次消息投递也同样是有一个delivery tag的，也是起到唯一标识一次消息投递的作用。这样，MQ回传ack给生产端的时候，会带上这个delivery tag。你就知道具体对应着哪一次消息投递了，可以删除这条消息。
    - 如果RabbitMQ接收到一条消息之后，结果内部出错发现无法处理这条消息，那么他会回传一个nack消息给生产端。此时你可以选择重新再次投递这条消息到MQ去。或者另一种情况，如果某条消息很长时间都没给你回传ack/nack，那可能是极端意外情况发生了，数据也丢了，你也可以自己重新投递消息到MQ去。

  ![confirm机制代码](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/mq_confirm%E6%9C%BA%E5%88%B6%E4%BB%A3%E7%A0%81.png)
  

  - **confirm机制投递消息的高延迟性**

    - 一旦启用了confirm机制投递消息到MQ之后，MQ是不保证什么时候会给你一个ack或者nack的。正常情况下，你投递到RabbitMQ的消息都会先驻留在内存里，然后过了几百毫秒的延迟时间之后，再一次性批量把多条消息持久化到磁盘里去。因为要是你来一条消息就写一次磁盘，那么性能会很差 . 

      所以正是因为这个原因，你打开了confirm模式之后，很可能你投递出去一条消息，要间隔几百毫秒之后，MQ才会把消息写入磁盘，接着你才会收到MQ回传过来的ack消息，这个就是所谓**confirm机制投递消息的高延迟性**。

    - 首先，用来临时存放未ack消息的存储需要承载高并发写入，**建议采用kv存储**。kv存储承载高并发能力极强，而且kv操作性能很高。

    - 其次，投递消息之后等待ack的过程必须是异步的，也就是类似上面那样的代码，已经给出了一个初步的异步回调的方式。

      消息投递出去之后，这个投递的线程其实就可以返回了，至于每个消息的异步回调，是通过在channel注册一个confirm监听器实现的。收到一个消息ack之后，就从kv存储中删除这条临时消息；收到一个消息nack之后，就从kv存储提取这条消息然后重新投递一次即可；也可以自己对kv存储里的消息做监控，如果超过一定时长没收到ack，就主动重发消息。

  
  
<br>

<h2 id="Java常用类库">Java常用类库</h2>

<br>

  <h3 id="Error和Exception的区别">Error和Exception的区别</h3> 

   - Error : 程序无法处理的系统错误(与JVM相关 : 系统崩溃, 堆内存空间不足  , 方法调用栈溢出等) , 编译器不做检查 . 
   - Exception : 程序可以处理的异常 , 捕获后可能恢复 . 
   - 总结 : 前者是程序无法处理的错误 , 后者是可以处理的异常 . 
   
  <h3 id="Java的异常体系">Java的异常体系</h3> 

   ![java的异常体系](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/java%E7%9A%84%E5%BC%82%E5%B8%B8%E4%BD%93%E7%B3%BB.png)

   - RunTimeException : 不可预知的 , 程序应当自行避免 . ( 比如空指针 , 数组下标越界 )
   - 非RunTimeException(直接继承Exception , 而不是RunTimeException ) : 可预知的 , 从编译器校验的异常 , 即编译时异常. ( 比如IOException , SQLException , 编译器直接报错的 , 需要try-catch) 
   - 从责任角度来看
     - Error属于JVM需要负担的责任
     - RunTimeException是程序应该负担的责任
     - CheckedException可检查异常是Java编译器应该负担的责任 

  <h3 id="常见的Error以及Exception">常见的Error以及Exception</h3> 

   - RuntimeException
     - NullPointerException -- 空指针异常
     - ClassCastException -- 类型强制转换异常
     - IllegalArgumentException -- 传递非法参数异常
     - IndexOutOfBoundsException -- 下标越界异常
     - NumberFormatException  -- 数字格式异常
   - 非RunTimeException
     - ClassNotFoundException  -- 找不到指定class的异常
     - IOException -- IO操作异常
   - Error
     - NoClassDefFoundError  --  找不到class定义的异常
       - 成因 :
       - 类依赖的class或者jar不存在
       - 类文件存在 , 但是存在不同的域中
       - 大小写问题 , javac编译的时候是无视大小写的 , 很有可能编译出来的class文件就与想要的不同
     - StackOverFlowError -- 深递归导致栈被耗尽而抛出的异常
     - OutOfMemoryError -- 内存溢出异常

  <h3 id="数据结构和算法考点">数据结构和算法考点</h3> 

   ![数据结构考点](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E8%80%83%E7%82%B9.jpg)

   ![算法考点](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E7%AE%97%E6%B3%95%E8%80%83%E7%82%B9.jpg)


  <h3 id="Java集合">Java集合</h3> 
  
   - list和set考点![list和set常考考点](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/list%E5%92%8Cset%E5%B8%B8%E8%80%83%E8%80%83%E7%82%B9.jpg)
     - set本质是由Map实现的 , 把元素放入Map中的key , 而value给一个new Onject() . 
     - TreeSet中自然排序 ( 传入的对象实现了Comparable的接口) 的优先级低于客户化排序 (在new TreeSet时在构造方法中传入的Comparator类)

  <h3 id="HashMap/HashTable/ConcurentHashMap的区别">HashMap/HashTable/ConcurentHashMap的区别</h3> 

   - HashMap线程不安全 , 数组 + 链表 + 红黑树
   - HashTable线程安全 , 锁住整个对象 , 数组 + 链表
   - ConcurrentHashMap线程安全 , CAS + 同步锁(将锁细粒度到数组的每个元素上) , 数组 + 链表 + 红黑树

  <h3 id="Java8前后HashMap的区别">Java8前后HashMap的区别</h3> 

   - HashMap(Java8以前) :数组(数组的默认长度是16) + 链表
     - 极端情况下元素key全都落在同一个链表下面 , 性能恶化: 从O(1)变为O(n)
   - HashMap(Java8以后) : 数组 + 链表 + 红黑时
     - 通过一个常量TREEIFY_THRESHOLD 默认为8, 当链表长度大于这个值后 , 转化为红黑树 , 这样性能恶化时的复杂度从 O(n)提高到 O(logn) . 当红黑树因为被删除而元素个数小于UNTREEIFY_THRESHOLD默认为6时 , 红黑树转化为链表以保障效率

  <h3 id="HashMap的put方法">HashMap的put方法</h3> 

   1. 如果HashMap未被初始化过 , 则初始化 . 
   2. 对Key求Hash值 , 然后再计算出数组下标. 
   3. 如果没有碰撞 , 直接放入数组下标对应的元素中 . 
   4. 如果碰撞了 , 以链表的方式链接到后面 . 
   5. 如果链表长度超过阈值 默认8, 就把链表转成红黑树
   6. 如果链表长度低于6, 就把红黑树转回链表
   7. 如果key已经存在就替换旧值
   8. 如果数组满了(容量16*加载因子0.75) , 就需要resize (扩容2倍后重排)

  <h3 id="HashMap如何减少碰撞以提高效率">HashMap如何减少碰撞以提高效率</h3> 

   - 利用一些扰动函数 , 促使元素位置分布均匀 , 减少碰撞几率 . 
   - key值使用final对象 , 并采用合适的equals()和hashCode()方法 . 使用String / Integer这样的包装类作为key是很好的选择 , 因为String是final的 , 并重写了equals和hashCode方法了 , final防止防止放入时和查找时的hashCode不一样.

  <h3 id="HashMap扩容的问题">HashMap扩容的问题</h3>     

   - 多线程环境下就, 调整大小会存在条件的竞争 , 容易造成死锁 . 
   - 扩容后重新分配元素的rehashing是一个比较耗时的过程 . 

  <h3 id="什么是HashTable">什么是HashTable</h3>     

   - 是早期Java类库提供的哈希表的实现
   - 线程安全的 : 涉及到的修改方法 , 使用synchronzie锁住整个对象 . 性能较差 . 

  <h3 id="什么是ConcurrentHashMap">什么是ConcurrentHashMap</h3>     

   - java8之前的实现 :  给数据分段(默认分为16个Segment) , 每个分段Segment都有一把分段锁 . 访问其中一个Segment不影响其他Segment的访问 , 理论上比HashTable的效率提高16倍 .  

   - java8之后的实现 : CAS + synchronize(锁更加细粒化 , 只锁定链表/红黑树的首节点 , 这样只要hash不冲突 , 就不会产生并发冲突 , 效率得到提高) 

      底层数据结构也类似于java8以后的HashMap(数组 + 链表 +红黑树)

   - ConcurrentHashMap的put方法逻辑:

      1. 判断Node[]数组是否初始化 , 没有则进行初始化操作 . 
      2. 通过hash定位数组的索引坐标 , 是否有Node节点 , 如果没有则使用CAS进行添加( 链表的头节点 ) , 添加失败则进入下次循环 . 添加成功 :
      3. 检查到内部正在扩容 , 就帮助它一块扩容 . 
      4. 如果链表/红黑树的头节点 != null , 则使用synchronized锁住该头节点 . 继续对链表/红黑树执行添加操作 . 
      5. 判断链表长度 , 如果大于8 , 将链表结构转换为红黑树 . 

  <h3 id="CountDownLatch和CyclicBarrier的区别">CountDownLatch和CyclicBarrier的区别</h3>     

   - CyclicBarrier是所有线程达到栅栏处 , 才触发执行另外一个预先设置的线程 . 这里子线程在await()之后计数器-1 , 就阻塞住了. 
   - CountDownLatch是让主线程等待一组事件发生后继续执行 . 这里子线程在countDown()之后计数器-1 , 没有被阻塞住 . 
   - Exchanger : 两个线程到达同步点后 , 相互交换数据 . 

  <h3 id="BIO/NIO/AIO的区别">BIO/NIO/AIO的区别</h3>     

   - BIO(Block-IO)是基于流模型实现的 , 意味着其交互方式是同步阻塞的 . 

   - NIO(NonBlock-IO) 是多路复用的 , 同步非阻塞的IO操作 . 

      - 核心 :

        - Channels 

          IO都从channel中开始 , 像流 , 数据可以从Channel进入Buffer , 也可以从Buffer流向Channel . 

        - Buffers

        - Selectors

          允许单线程处理多个Channel . 单线程的轮循机制 , 通过高效定位就绪的channel来决定做什么 . 
          如果同时打开多个Channel , 每个Channel流量又很低 , 使用Selector就会很方便 (Channel需要在selector上注册).      

        ![NIO中Selector,Channel,Buffer](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/NIO%E4%B8%ADSelector%2CChannel%2CBuffer.jpg)

   - AIO (Asynchronous IO) :  异步非阻塞IO 

     基于事件和回调机制 , 应用操作直接返回而不会阻塞在那里 ,  当后台处理完成 , 响应线程会调用回调函数 . 
     
   ![BIO,NIO,AIO的对比](https://github.com/guoguo-tju/javaAudition/blob/master/src/main/resources/picture/BIO,NIO,AIO%E7%9A%84%E5%AF%B9%E6%AF%94.jpg?raw=true)



<br>

<h2 id="Spring">Spring</h2>

<br>
  	
  	
  <h3 id="SpringIOC">SpringIOC</h3>       	

   - 高层不依赖于底层 , 底层只作为高层的一个成员变量注入 . 
    
      优势 :
    
      - 避免在各处使用new来创建类 , 可以做到同一维护
    
      - 创建实例的时候不需要了解其中的细节 (蓝色框内是被隐藏掉的细节 , spring就像一个工厂一样 , 你需求什么它给你什么 )
    
        ![ioc的优势](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/ioc%E7%9A%84%E4%BC%98%E5%8A%BF.png)
    
   - ioc在启动时的过程
    
      ![ioc在启动时](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/ioc%E5%9C%A8%E5%90%AF%E5%8A%A8%E6%97%B6.png)
    
   - BeanDefiniton
    
      Spring启动时会将xml / 注解里的Bean的定义解析为BeanDefinition. 
    
   - BeanDefinitonRegistry
    
      提供向IOC容器注册BeanDefinition对象的方法 .  以BeanName为key , BeanDefinition为vaule存入beanDefinitionMap里 . 
      

  <h3 id="Spring的ApplicationContext">Spring的ApplicationContext</h3>       	      
      
   - ApplicationContext面向使用Spring框架的开发者的 . BeanFactory是Spring框架的基础设施 , 面向Spring的 . ( ApplicationContext是车, BeanFactory是车内的发动机 )
   - 功能 :
     - BeanFactory : 能够管理 , 装配Bean
     - ResourcePatternResolver : 能够加载资源文件
     - MessageSource : 能够实现国际化等功能
     - ApplicationEventPublisher : 能够注册监听器 , 实现监听机制 
         	 
   - refresh方法 (spring启动时会调用)
     - 为IOC容器以及Bean的声明周期管理提供条件
     - 刷新Spring上下文信息 , 定义Spring上下文加载流程
   
  <h3 id="Spring的getBean">Spring的getBean</h3>       

   - 转换beanName .

     ```java    
     final String beanName = transformedBeanName(name);
     ```

   - 检查缓存中有没有bean实例 , 有的话加载

     ```java    
     Object sharedInstance = getSingleton(beanName);
     if (sharedInstance != null && args == null) {
     	....
     	bean = getObjectForBeanInstance(sharedInstance, name, beanName, null);
     }
     ```

   - 没有的话开始实例bean

   - 检测parentBeanFactory是否有需要的bean

     ```java    
     BeanFactory parentBeanFactory = getParentBeanFactory();
     ```

   - 初始化bean所依赖的bean , getBean递归创建所需的bean

     ```java   
     String[] dependsOn = mbd.getDependsOn();
     if (dependsOn != null) {
     	getBean(..) ;
     }
     ```

   - 各种创建bean

     ```java    
     bean = getObjectForBeanInstance(sharedInstance, name, beanName, mbd);
     ```
    
  <h3 id="SpringBean的作用域">SpringBean的作用域</h3>       
      
   - singleton : spring的默认作用域 , 容器里拥有唯一的Bean实例
   - prototype : 针对每个getBean请求 , 容器都会创建一个Bean实例
   - request : 会为每个Http请求创建一个Bean实例
   - session : 会为每个session创建一个Bean实例
   - globalSession : 会为每个全局Http Session创建一个Bean实例 , 该作用域仅对Protlet有效
   
  <h3 id="SpringBean的生命周期">SpringBean的生命周期</h3>    
     https://juejin.im/post/5c3c00eae51d45522578e815
     
   - 创建过程
     - 实例化Bean , 以及设置bean属性
     - Aware( 注入Bean ID , BeanFactory和AppCtx )
     - BeanPostProcessor( s ).postProcessBeforeInitialization , 在bean实例化之后 , 进行一些自定义bean的处理逻辑 .  aop相关 . 
     - IntializingBean(s).afterPropertiesSet , 做一些属性被设置之后的自定义的事情 . 
     - Bean的init方法做一些初始化操作 . 
     - BeanPostProcessor(s).postProcessAfterInitialization , 在bean实例化之后 , 进行一些自定义bean的处理逻辑 .  aop相关 . 
     - Bean初始化完毕
   - 销毁过程
     - 若配置了destry-method属性 , 则会调用其配置的销毁方法
     - 若实现了DisposableBean接口 , 则会调用destroy方法

  <h3 id="SpringAOP">SpringAOP</h3>    

   - 常用来记录web请求的通用日志信息 , 请求来源的ip , 请求的url , 请求返回的信息
   - AOP主要名词概念
     - Aspect : 通用功能的代码实现 ,比如 HttpLogAspect 类.
     - Target : 被织入Aspect的对象 , 比如controller类 . 
     - Join Point : 可以作为切入点的机会 , 所有方法都可以作为切入点 . 
     - Pointcut : Aspect实际被应用在的Join Point , 支持正则 . @Pointcut("execution(* com.zichan360.controller..*.*(..))")
     - Advice : 类里点方法以及这个方法如何织入目标方法的方式 
     - Weaving : Aop的实现过程
   - Advice的种类
     - 前置通知( Before )
     - 后置通知( AfterReturning )
     - 异常通知( AfterThrowing )
     - 最终通知( After )
     - 环绕通知( Around )

  <h3 id="SpringAOP的实现">SpringAOP的实现</h3>    

   - JdkProxy和Cglib

   - 由AopProxyFactory根据AdvisedSupport对象的配置来决定
   - 默认策略: 如果目标是接口用JDKProxy来实现 , 否则用Cglib
   - JDKProxy的核心 : InvocationHandler接口和Proxy类 , 通过Java内部反射机制实现
   - Cglib : 通过ASM(能够修改字节码的框架)修改字节码 , 以继承的方式动态生成目标类的代理 , 如果目标类标记为final 的 ,是无法用Cglib来做动态代理 .  
   - 反射机制在生成类的过程中比较高效 , ASM在生成类之后的执行过程中比较高效 ( 可以通过对ASM生成的类进行缓存来避免ASM这种缺点 )
   - Spring里的代理模式的实现
     - 真实实现类的逻辑包含在了getBean方法里 , 所以spring只能作用于spring中的bean . 
     - getBean方法返回的实际上是代理类
     - 代理类实例是Spring采用JDK Proxy或Cglib动态生成的

     Spting事务 : ACID , 隔离级别 , 事务传播


  <h3 id="SpringCloud">SpringCloud</h3>   
   
   - **Eureka**

     - Eureka是微服务架构中的注册中心，专门负责服务的注册与发现。
     - **Eureka** **Client：**负责将这个服务的信息注册到Eureka Server中
     - **Eureka Server：**注册中心，里面有一个注册表，保存了各个服务所在的机器和端口号

   - **Feign**

     - 服务之间进行通信 , 底层还是http请求
     - 如果你对某个接口定义了@FeignClient注解，Feign就会针对这个接口创建一个动态代理
     - 接着你要是调用那个接口，本质就是会调用 Feign创建的动态代理，这是核心中的核心
     - Feign的动态代理会根据你在接口上的@RequestMapping等注解，来动态构造出你要请求的服务的地址
     - 最后针对这个地址，发起请求、解析响应

   - **Ribbon**

     - 它的作用是负载均衡，会帮你在每次请求时选择一台机器，均匀的把请求分发到各个机器上
     - Ribbon的负载均衡默认使用的最经典的Round Robin轮询算法。这是啥？简单来说，就是如果订单服务对库存服务发起10次请求，那就先让你请求第1台机器、然后是第2台机器、第3台机器、第4台机器、第5台机器，接着再来—个循环，第1台机器、第2台机器。。。以此类推。

   - **Ribbon是和Feign以及Eureka紧密协作，完成工作的，具体如下：**

     - 首先Ribbon会从 Eureka Client里获取到对应的服务注册表，也就知道了所有的服务都部署在了哪些机器上，在监听哪些端口号。

     - 然后Ribbon就可以使用默认的Round Robin算法，从中选择一台机器

     - Feign就会针对这台机器，构造并发起请求。

       ![ribbon,Feign,Eureka](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/ribbon%2CFeign%2CEureka.jpg)

   - **Hystrix**

     - 这么多服务互相调用，要是不做任何保护的话，某一个服务挂了，就会引起连锁反应，导致别的服务也挂。比如积分服务挂了，会导致订单服务的线程全部卡在请求积分服务这里，没有一个线程可以工作，瞬间导致订单服务也挂了，别人请求订单服务全部会卡住，无法响应。**就算积分服务挂了，订单服务也可以不用挂啊！**
     - Hystrix是隔离、熔断以及降级的一个框架。Hystrix会搞很多个小小的线程池，比如订单服务请求库存服务是一个线程池，请求仓储服务是一个线程池，请求积分服务是一个线程池。每个线程池里的线程就仅仅用于请求那个服务。
     - **现在很不幸，积分服务挂了，会咋样？**当然会导致订单服务里的那个用来调用积分服务的线程都卡死不能工作了！但是由于订单服务调用库存服务、仓储服务的这两个线程池都是正常工作的，所以这两个服务不会受到任何影响。只不过调用积分服务的时候，每次都会报错。**但是如果积分服务都挂了，每次调用都要去卡住几秒钟干啥呢？****有意义吗？当然没有！**所以我们直接对积分服务熔断不就得了，比如在5分钟内请求积分服务直接就返回了，不要去走网络请求卡住几秒钟，这个过程，就是所谓的熔断！
     - 咱们再来个降级：每次调用积分服务，你就在数据库里记录一条消息，说给某某用户增加了多少积分，因为积分服务挂了，导致没增加成功！这样等积分服务恢复了，你可以根据这些记录手工加一下积分。这个过程，就是所谓的降级。

   ![hystrix](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/hystrix.jpg)

   - **Zuul**
     - 一般微服务架构中都必然会设计一个网关在里面，像android、ios、pc前端、微信小程序、H5等等，不用去关心后端有几百个服务，就知道有一个网关，所有请求都往网关走，网关会根据请求中的一些特征，将请求转发给后端的各个服务。而且有一个网关之后，还有很多好处，比如可以做统一的降级、限流、认证授权、安全，等等。

   
  <h3 id="注册中心Eureka内部原理">注册中心Eureka内部原理</h3>   

   - Eureka简介

     - 各个服务内的Eureka Client组件，默认情况下，每隔30秒会发送一个请求到Eureka Server，来拉取最近有变化的服务信息 . 除此之外，Eureka还有一个心跳机制，各个Eureka Client每隔30秒会发送一次心跳到Eureka Server，通知人家说，我这个服务实例还活着！
     - 现在咱们假设手头有一套大型的分布式系统，一共100个服务，每个服务部署在20台机器上，机器是4核8G的标准配置。

     也就是说，相当于你一共部署了100 * 20 = 2000个服务实例，有2000台机器。

     每台机器上的服务实例内部都有一个Eureka Client组件，它会每隔30秒请求一次Eureka Server，拉取变化的注册表。

     此外，每个服务实例上的Eureka Client都会每隔30秒发送一次心跳请求给Eureka Server。

     那一天的话，就是8000 * 60 * 24 = 1152万，也就是**每天千万级访问量** , 即使算上其他一些额外操作，我们姑且就算每秒钟请求Eureka Server在200次~300次吧。

   - **Eureka Server设计精妙的注册表存储结构**

     - 从源码中可以看到，Eureka Server的注册表直接基于**纯内存**，即在内存里维护了一个数据结构**CocurrentHashMap**。各个服务的注册、服务下线、服务故障，全部会在内存里维护和更新这个注册表。这是Eureka Server非常核心的一个点。
     - 这个ConcurrentHashMap的key就是服务名称，比如“inventory-service”，就是一个服务名称。value的这个Map：Map<String, Lease<InstanceInfo>>  , Map的key就是服务实例的id , value是一个叫做**Lease**的类，它的泛型是一个叫做**InstanceInfo**的东东 , InstanceInfo，其实啊，我们见名知义，这个InstanceInfo就代表了**服务实例的具体信息**，比如机器的ip地址、hostname以及端口号。这个Lease，里面则会维护每个服务**最近一次发送心跳的时间**

   - **Eureka Server端优秀的多级缓存机制**

     - Eureka Server为了避免同时读写内存数据结构造成的并发冲突问题，还采用了**多级缓存机制**来进一步提升服务请求的响应速度。

     - 在拉取注册表的时候：

     - - 首先从**ReadOnlyCacheMap**里查缓存的注册表。

     - - 若没有，就找**ReadWriteCacheMap**里缓存的注册表。

     - - 如果还没有，就从**内存中获取实际的注册表数据。**

     - 在注册表发生变更的时候：

     - - 会在内存中更新变更的注册表数据，同时**过期掉ReadWriteCacheMap**。

     - - 此过程不会影响ReadOnlyCacheMap提供人家查询注册表。

     - - 一段时间内（默认30秒），各服务拉取注册表会直接读ReadOnlyCacheMap

     - - 30秒过后，Eureka Server的后台线程发现ReadWriteCacheMap已经清空了，也会清空ReadOnlyCacheMap中的缓存

     - - 下次有服务拉取注册表，又会从内存中获取最新的数据了，同时填充各个缓存。

     - **多级缓存机制的优点是什么**

       - 尽可能保证了内存注册表数据不会出现频繁的读写冲突问题。

       - 并且进一步保证对Eureka Server的大量请求，都是快速从纯内存走，性能极高。
  
  
  
  
<h2 id="分布式架构">分布式架构</h3>       
  
  
  <h3 id="微服务架构中如何保证整套系统的高可用">微服务架构中如何保证整套系统的高可用</h3>     

   - 微服务架构本身**最最核心**的保障高可用的措施，就是两点：

     1. 一个是基于Hystrix做资源隔离以及熔断；
     2. 另一个是做备用降级方案。

   - **在生产环境中，我们到底应该如何设置服务中每个hystrix线程池的大小？**

     - 假设你的服务A，每秒钟会接收30个请求，同时会向服务B发起30个请求，然后每个请求的响应时长经验值大概在200ms，那么你的hystrix线程池需要多少个线程呢？

       计算公式是：30（每秒请求数量） * 0.2（每个请求的处理秒数） + 4（给点缓冲buffer） = 10（线程数量）。

   - **线上经验—如何设置请求超时时间**

     - 线程数量OK了，那么请求的超时时间设置为多少？**答案是300毫秒。**

       为啥呢？很简单啊，如果你的超时时间设置成了500毫秒，想想可能会有什么后果？

       考虑极端情况，如果服务B响应变慢，要500毫秒才响应，你一个线程每秒最多只能处理2个请求了，10个线程只能处理20个请求。大量的线程会全部卡死，来不及处理那么多请求，最后用户会刷不出来页面。

       所以说，此时你的超时时间得设置成300毫秒，保证一个请求300毫秒内执行不完，立马超时返回。

       这样线程池里的线程不会长时间卡死，可以有条不紊的处理多出来的请求，大不了就是300毫秒内处理不完立即超时返回，但是线程始终保持可以运行的状态。

   - **服务降级**

     - 举一些常见的例子：

       - 如果查询数据的服务挂了，你可以查本地的缓存

       - 如果写入数据的服务挂了，你可以先把这个写入操作记录日志到比如mysql里，或者写入MQ里，后面再慢慢恢复

       - 如果redis挂了，你可以查mysql

       - 如果mysql挂了，你可以把操作日志记录到es里去，后面再慢慢恢复数据。


  <h3 id="TCC分布式事务">TCC分布式事务</h3>     

   - 微服务架构相互调用的服务之间 . 比如 :

     订单服务-修改订单状态，库存服务-扣减库存，积分服务-增加积分，仓储服务-创建销售出库单。

     上述这几个步骤，要么一起成功，要么一起失败，**必须是一个整体性的事务**。

     我们有必要使用TCC分布式事务机制来保证各个服务形成一个整体性的事务。

     国内开源的TCC分布式事务框架**ByteTCC、himly、tcc-transaction**

   - **落地实现TCC分布式事务**

     - **TCC实现阶段一：Try**

       - 首先，上面那个订单服务先把自己的状态修改为：**OrderStatus.UPDATING**。你别直接把订单状态修改为已支付啊！你先把订单状态修改为**UPDATING**，也就是修改中的意思。
       - 库存服务直接提供的那个reduceStock()接口里，也别直接扣减库存啊，你可以是**冻结掉库存**。你可以把可销售的库存：100 - 2 = 98，设置为98没问题，然后在一个单独的冻结库存的字段里，设置一个2。也就是说，有2个库存是给冻结了。
       - 积分服务的addCredit()接口也是同理，别直接给用户增加会员积分。你可以先在积分表里的一个**预增加积分字段**加入积分。
       - 仓储服务的saleDelivery()接口也是同理啊，你可以先创建一个销售出库单，但是这个销售出库单的状态是“**UNKNOWN**”。也就是说，刚刚创建这个销售出库单，此时还不确定他的状态是什么呢！
       - 如果你要实现一个TCC分布式事务，首先你的业务的主流程以及各个接口提供的业务含义，不是说直接完成那个业务操作，而是完成一个Try的操作。这个操作，一般都是锁定某个资源，设置一个预备类的状态，冻结部分数据，等等，大概都是这类操作。

     - **TCC实现阶段二：Confirm**

       - 一旦订单服务里面的TCC分布式事务框架感知到各个服务的Try阶段都成功了以后，就会执行各个服务的Confirm逻辑。
       - **订单服务**里，你可以加入一个Confirm的逻辑，就是正式把订单的状态设置为“已支付”了
       - **库存服务**也是类似的，你可以有一个InventoryServiceConfirm类，里面提供一个reduceStock()接口的Confirm逻辑，这里就是将之前冻结库存字段的2个库存扣掉变为0。
       - **积分服务**也是类似的，可以在积分服务里提供一个CreditServiceConfirm类，里面有一个addCredit()接口的Confirm逻辑，就是将预增加字段的10个积分扣掉，然后加入实际的会员积分字段中，从1190变为1120。
       - **仓储服务**也是类似，可以在仓储服务中提供一个WmsServiceConfirm类，提供一个saleDelivery()接口的Confirm逻辑，将销售出库单的状态正式修改为“已创建”，可以供仓储管理人员查看和使用，而不是停留在之前的中间状态“UNKNOWN”了。

     - **TCC实现阶段三：Cancel**

       - 订单服务的TCC分布式事务框架只要感知到了任何一个服务的Try逻辑失败了，就会跟各个服务内的TCC分布式事务框架进行通信，然后调用各个服务的Cancel逻辑 .
       - 首先**订单服务**，他得提供一个OrderServiceCancel的类，在里面有一个pay()接口的Cancel逻辑，就是可以将订单的状态设置为“CANCELED”，也就是这个订单的状态是已取消。
       - **库存服务**也是同理，可以提供reduceStock()的Cancel逻辑，就是将冻结库存扣减掉2，加回到可销售库存里去，98 + 2 = 100。
       - **积分服务**也需要提供addCredit()接口的Cancel逻辑，将预增加积分字段的10个积分扣减掉。**
       - **仓储服务**也需要提供一个saleDelivery()接口的Cancel逻辑，将销售出库单的状态修改为“CANCELED”设置为已取消。

     - TCC分布式事务的核心思想，说白了，就是当遇到下面这些情况时，**保证大家要么一起成功，要么一起失败**。

       - 某个服务的数据库宕机了

       - 某个服务自己挂了

       - 那个服务的redis、elasticsearch、MQ等基础设施故障了

       - 某些资源不足了，比如说库存不够这些

     - 订单服务突然挂了，然后再次重启 , TCC分布式事务框架是**如何保证之前没执行完的分布式事务继续执行的呢？**

       - TCC事务框架都是要记录一些分布式事务的活动日志的，可以在磁盘上的日志文件里记录，也可以在数据库里记录。保存下来分布式事务运行的各个阶段和状态。

     - 万一某个服务的Cancel或者Confirm逻辑执行一直失败怎么办呢？

       - TCC事务框架会通过活动日志记录各个服务的状态。
       - 举个例子，比如发现某个服务的Cancel或者Confirm一直没成功，会不停的重试调用他的Cancel或者Confirm逻辑，务必要他成功！当然了，如果你的代码没有写什么bug，有充足的测试，而且Try阶段都基本尝试了一下，那么其实一般Confirm、Cancel都是可以成功的！


  <h3 id="可靠消息最终一致性方案">可靠消息最终一致性方案</h3>     

- 在实际系统的开发过程中，可能服务间的调用是异步的。也就是说，一个服务发送一个消息给MQ，即消息中间件，比如RocketMQ、RabbitMQ、Kafka、ActiveMQ等等。然后，另外一个服务从MQ消费到一条消息后进行处理。这就成了基于MQ的异步调用了。这个时候，就要用上**可靠消息最终一致性方案**，来实现分布式事务。

- **可靠消息最终一致性方案的核心流程**

  ![可靠消息最终一致性方案](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%8F%AF%E9%9D%A0%E6%B6%88%E6%81%AF%E6%9C%80%E7%BB%88%E4%B8%80%E8%87%B4%E6%80%A7%E6%96%B9%E6%A1%88.png)

  - **上游服务投递消息**

    - 如果要实现可靠消息最终一致性方案，一般你可以自己写一个可靠消息服务，实现一些业务逻辑。
    - 首先，上游服务需要发送一条消息给可靠消息服务。这条消息说白了，你可以认为是对下游服务一个接口的调用，里面包含了对应的一些请求参数。
    - 然后，可靠消息服务就得把这条消息存储到自己的数据库里去，状态为“待确认”。
    - 接着，上游服务就可以执行自己本地的数据库操作，根据自己的执行结果，再次调用可靠消息服务的接口。如果本地数据库操作执行成功了，那么就找可靠消息服务确认那条消息。如果本地数据库操作失败了，那么就找可靠消息服务删除那条消息。此时如果是确认消息，那么可靠消息服务就把数据库里的消息状态更新为“已发送”，同时将消息发送给MQ。
    - 这里有一个**很关键的点**，就是可靠消息服务里更新数据库里的消息状态和投递消息到MQ。这俩操作，你得放在一个方法里，而且得开启本地事务。

  - **下游服务接收消息**

    - 下游服务就一直等着从MQ消费消息好了，如果消费到了消息，那么就操作自己本地数据库。
    - 如果操作成功了，就反过来通知可靠消息服务，说自己处理成功了，然后可靠消息服务就会把消息的状态设置为“已完成”。

  - **如何上游服务对消息的100%可靠投递？**

    - 如果上游服务给可靠消息服务发送待确认消息的过程出错了，那没关系，上游服务可以感知到调用异常的，就不用执行下面的流程了，这是没问题的。
    - 如果上游服务操作完本地数据库之后，通知可靠消息服务确认消息或者删除消息的时候，出现了问题。其实也没关系，因为在这些情况下，那条消息在可靠消息服务的数据库里的状态会一直是“待确认”。
      - 此时，我们在可靠消息服务里开发一个**后台定时运行的线程**，不停的检查各个消息的状态。如果一直是“待确认”状态，就认为这个消息出了点什么问题。此时的话，就可以回调上游服务提供的一个接口，问问说，兄弟，这个消息对应的数据库操作，你执行成功了没啊？如果上游服务答复说，我执行成功了，那么可靠消息服务将消息状态修改为“已发送”，同时投递消息到MQ。如果上游服务答复说，没执行成功，那么可靠消息服务将数据库中的消息删除即可。**通过这套机制，就可以保证，可靠消息服务一定会尝试完成消息到MQ的投递。**

  - **如何保证下游服务对消息的100%可靠接收？**

    - 那如果下游服务消费消息出了问题，没消费到？或者是下游服务对消息的处理失败了，怎么办？其实也没关系，**在可靠消息服务里开发一个后台线程，不断的检查消息状态。**如果消息状态一直是“已发送”，始终没有变成“已完成”，那么就说明下游服务始终没有处理成功。此时可靠消息服务就可以再次尝试重新投递消息到MQ，让下游服务来再次处理。只要下游服务的接口逻辑**实现幂等性**，保证多次处理一个消息，不会插入重复数据即可。

  - 在上面的通用方案设计里，完全依赖可靠消息服务的各种自检机制来确保：

    - 如果上游服务的数据库操作没成功，下游服务是不会收到任何通知

    - 如果上游服务的数据库操作成功了，可靠消息服务死活都会确保将一个调用消息投递给下游服务，而且一定会确保下游服务务必成功处理这条消息。

    通过这套机制，保证了基于MQ的异步调用/通知的服务间的分布式事务保障。其实阿里开源的RocketMQ，就实现了高并发场景下可靠消息服务的所有功能，核心思想跟上面类似。

- **可靠消息最终一致性方案的高可用保障生产实践**

  - 这套方案里保障高可用性最大的一个依赖点，就是**MQ的高可用性**。MQ一旦完全不可用，就会导致业务系统的各个服务之间无法通过MQ来投递消息，导致业务流程中断。这种情况，就需要针对这套分布式事务方案实现一套高可用保障机制。

    ![基于KV存储的队列支持的高可用降级方案](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%9F%BA%E4%BA%8EKV%E5%AD%98%E5%82%A8%E7%9A%84%E9%98%9F%E5%88%97%E6%94%AF%E6%8C%81%E7%9A%84%E9%AB%98%E5%8F%AF%E7%94%A8%E9%99%8D%E7%BA%A7%E6%96%B9%E6%A1%88.jpg)

  - 自行封装MQ客户端组件与故障感知

    - 首先第一点，你要做到自动感知MQ的故障接着自动完成降级，那么必须动手对MQ客户端进行封装，发布到公司Nexus私服上去。然后公司需要支持MQ降级的业务服务都使用这个自己封装的组件来发送消息到MQ，以及从MQ消费消息。在你自己封装的MQ客户端组件里，你可以根据写入MQ的情况来判断MQ是否故障。比如说，如果连续10次重试尝试投递消息到MQ都发现异常报错，网络无法联通等问题，说明MQ故障，此时就可以自动感知以及自动触发降级开关。

  - 基于kv存储中队列的降级方案

    - 此时就可以类似redis的kv存储中的队列来进行替代。这里有几个大坑，一定要注意一下。

    - **第一个**，任何kv存储的集合类数据结构，建议不要往里面写入数据量过大，否则会导致大value的情况发生，引发严重的后果。因此绝不能在redis里搞一个key，就拼命往这个数据结构中一直写入消息，这是肯定不行的。

    - **第二个**，绝对不能往少数key对应的数据结构中持续写入数据，那样会导致热key的产生，也就是某几个key特别热。大家要知道，一般kv集群，都是根据key来hash分配到各个机器上的，你要是老写少数几个key，会导致kv集群中的某台机器访问过高，负载过大。

    - **基于以上考虑，下面是设计的方案：**

      - 根据他们每天的消息量，在kv存储中固定划分上百个队列，有上百个key对应。

      - 这样保证每个key对应的数据结构中不会写入过多的消息，而且不会频繁的写少数几个key。

      - 一旦发生了MQ故障，可靠消息服务可以对每个消息通过hash算法，均匀的写入固定好的上百个key对应的kv存储的队列中。

      - 同时此时需要通过zk触发一个降级开关，整个系统在MQ这块的读和写全部立马降级。

  - **下游服务消费MQ的降级感知**

    - 下游服务消费MQ也是通过自行封装的组件来做的，此时那个组件如果从zk感知到降级开关打开了，首先会判断自己是否还能继续从MQ消费到数据？如果不能了，就开启多个线程，并发的从kv存储的各个预设好的上百个队列中不断的获取数据。每次获取到一条数据，就交给下游服务的业务逻辑来执行。

  - **故障的自动恢复**

    - 如果降级开关打开之后，自行封装的组件需要开启一个线程，每隔一段时间尝试给MQ投递一个消息看看是否恢复了。如果MQ已经恢复可以正常投递消息了，此时就可以通过zk关闭降级开关，然后可靠消息服务继续投递消息到MQ，下游服务在确认kv存储的各个队列中已经没有数据之后，就可以重新切换为从MQ消费消息。

  - 其次就是根据大家公司的实际对高可用需求来决定，如果感觉MQ偶尔宕机也没事，可以容忍的话，那么也不用实现这种降级方案。但是如果公司领导认为MQ中间件宕机后，一定要保证业务系统流程继续运行，那么还是要考虑一些高可用的降级方案，比如本文提到的这种。


  <h3 id="Redis分布式锁">Redis分布式锁</h3>     

- 自定义注解实现

  - 自定义一个注解 , 比如: RedisLock.
  - 定义一个类RedisDistributionLock , 通过Jedis实现获取锁和释放锁 . 
  - 利用spring的aop , 定义一个切面类RedisLockAspect , 切加有 @RedisLock 的方法. 在切面方法中 , 设置好key(注解传入)和value(UUID随机生成) 以及加锁时间等参数, 在try中调用redisDistributionLock中的方法实现加锁 , 在finally中调用redisDistributionLock中的方法释放锁 , 就可在service方法执行完成后释放锁. 

- 通过**Redisson**框架实现

  ![Redisson原理流程图](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/Redisson%E5%8E%9F%E7%90%86%E6%B5%81%E7%A8%8B%E5%9B%BE.jpg)

  - **加锁机制**

    - 如果该客户端面对的是一个redis cluster集群，他首先会根据hash节点选择一台机器。紧接着，就会发送一段lua脚本到redis上，那段lua脚本如下所示：

      ![lua脚本](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/lua%E8%84%9A%E6%9C%AC.jpg)

    - 为啥要用lua脚本呢？因为一大坨复杂的业务逻辑，可以通过封装在lua脚本中发送给redis，保证这段复杂业务逻辑执行的**原子性**。

    - **KEYS[1]**代表的是你加锁的那个key，比如说：

      RLock lock = redisson.getLock("myLock");

      这里你自己设置了加锁的那个锁key就是“myLock”。

      **ARGV[1]**代表的就是锁key的默认生存时间，默认30秒。

      **ARGV[2]**代表的是加锁的客户端的ID，类似于下面这样：

      8743c9c0-0795-4907-87fd-6c719a6b4586:1

      给大家解释一下，第一段if判断语句，就是用“exists myLock”命令判断一下，如果你要加锁的那个锁key不存在的话，你就进行加锁。

      如何加锁呢？很简单，用下面的命令：

      hset myLock 

      ​    8743c9c0-0795-4907-87fd-6c719a6b4586:1 1

      上述就代表“8743c9c0-0795-4907-87fd-6c719a6b4586:1”这个客户端对“myLock”这个锁key完成了加锁。

      接着会执行“pexpire myLock 30000”命令，设置myLock这个锁key的生存时间是30秒。加锁完成了。

  - **锁互斥机制**

    - 如果客户端2来尝试加锁，执行了同样的一段lua脚本，第一个if判断会执行“exists myLock”，发现myLock这个锁key已经存在了。接着第二个if判断，判断一下，myLock锁key的hash数据结构中，是否包含客户端2的ID，但是明显不是的，因为那里包含的是客户端1的ID。所以，客户端2会获取到pttl myLock返回的一个数字，这个数字代表了myLock这个锁key的**剩余生存时间。**比如还剩15000毫秒的生存时间。此时客户端2会进入一个while循环，不停的尝试加锁。

  - **watch dog自动延期机制**

    - 客户端1加锁的锁key默认生存时间才30秒，如果超过了30秒，客户端1还想一直持有这把锁，怎么办呢？简单！只要客户端1一旦加锁成功，就会启动一个watch dog看门狗，**他是一个后台线程，会每隔10秒检查一下**，如果客户端1还持有锁key，那么就会不断的延长锁key的生存时间。

  - **可重入加锁机制**

    - 这时我们来分析一下上面那段lua脚本。第一个if判断肯定不成立，“exists myLock”会显示锁key已经存在了。第二个if判断会成立，因为myLock的hash数据结构中包含的那个ID，就是客户端1的那个ID，也就是“8743c9c0-0795-4907-87fd-6c719a6b4586:1”此时就会执行可重入加锁的逻辑，他会用：

      incrby myLock 

       8743c9c0-0795-4907-87fd-6c71a6b4586:1 1

      通过这个命令，对客户端1的加锁次数，累加1 , 变为 : 

      mylock: 

      {"8743c9c0-0795-4907-87fd-6c71a6b4586:1": 2}

  - **释放锁机制**

    - 如果执行lock.unlock()，就可以释放分布式锁，此时的业务逻辑也是非常简单的。其实说白了，就是每次都对myLock数据结构中的那个加锁次数减1。如果发现加锁次数是0了，说明这个客户端已经不再持有锁了，此时就会用：“del myLock”命令，从redis里删除这个key。然后呢，另外的客户端2就可以尝试完成加锁了

  - **上述Redis分布式锁的缺点**

    - redis master-slave架构的**主从异步复制**导致的redis分布式锁：在redis master实例宕机的时候，可能导致多个客户端同时完成加锁。
    - 如果你对某个redis master实例，写入了myLock这种锁key的value，此时会异步复制给对应的master slave实例。但是这个过程中一旦发生redis master宕机，主备切换，redis slave变为了redis master。接着就会导致，客户端2来尝试加锁的时候，在新的redis master上完成了加锁，而客户端1也以为自己成功加了锁。此时就会导致多个客户端对一个分布式锁完成了加锁。**导致各种脏数据的产生**。
    

  <h3 id="高并发场景下对分布式锁的优化">高并发场景下对分布式锁的优化</h3>     

   - 用分布式锁解决超卖问题 : 

     - 同一时刻 , 只有一个订单系统实例可以成功加分布式锁，然后只有他一个实例可以查库存、判断库存是否充足、下单扣减库存，接着释放锁。
     - 释放锁之后，另外一个订单系统实例才能加锁，接着查库存，一下发现库存只有2台了，库存不足，无法购买，下单失败。不会将库存扣减为负数。

   - 分布式锁的方案在高并发场景下问题 : 

     - 分布式锁一旦加了之后，对同一个商品的下单请求，会导致所有客户端都必须对同一个商品的库存锁key进行加锁。比如，对iphone这个商品的下单，都必对“iphone_stock”这个锁key来加锁。这样会导致对同一个商品的下单请求，就必须串行化，一个接一个的处理。

   - 如何对分布式锁进行高并发优化

     - 采用类似ConcurrentHashMap的思想 , **分段加锁** .

       ![高并发超卖的分段加锁](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E9%AB%98%E5%B9%B6%E5%8F%91%E8%B6%85%E5%8D%96%E7%9A%84%E5%88%86%E6%AE%B5%E5%8A%A0%E9%94%81.png)

     - 就是把你的1000件库存给他拆开，每个库存段是50件库存，比如stock_01对应50件库存，stock_02对应50件库存。接着，每秒1000个请求过来了，好！此时其实可以是自己写一个简单的随机算法，每个请求都是随机在20个分段库存里，选择一个进行加锁。这样就好了，同时可以有最多20个下单请求一起执行，每个下单请求锁了一个库存分段，然后在业务逻辑里面，就对数据库或者是Redis中的那个分段库存进行操作即可 . 这样一下子并发性能可以增长几十倍。

     - 有一个坑大家一定要注意：就是如果某个下单请求，咔嚓加锁，然后发现这个分段库存里的库存不足了，此时咋办？ ,  这时你得自动释放锁，然后立马换下一个分段库存，再次尝试加锁后尝试处理。这个过程一定要实现。

     -  Java 8中新增了一个LongAdder类，也是针对Java 7以前的AtomicLong进行的优化，解决的是CAS类操作在高并发场景下，使用乐观锁思路，会导致大量线程长时间重复循环。LongAdder中也是采用了类似的分段CAS操作，失败则自动迁移到下一个分段进行CAS的思路。


  <h3 id="从0设计一个消息中间件">从0设计一个消息中间件</h3>     
    
   - **生产消费模型以及核心数据结构**
      - 存在内存还是磁盘 , 还是两者都存
      - 缓冲 , 批量写入
      - 磁盘拆分
      - 消息的偏移量offset以及唯一id
      - 建议去研究研究比如kafka底层的文件存储原理，那是非常经典的高性能高并发消息中间件存储架构的实现。
   - **支撑TB级数据写入的分布式架构**
      - 多节点 , 数据的分布式存储
      - 某一个大的数据集合做分片存储
      - 多节点,分片的扩容
   - **数据宕机场景下的高可用架构**
      - **多副本冗余机制**
      - 研究一下kafka的多副本冗余机制，他的每个partition数据分片都是有多个副本的，任何一台机器宕机，丢失一个数据分片，还有其他机器上的副本分片在，可以支持数据不丢失。
   - **支持数据不丢失的ack机制**
      - 生产端，一旦投递了消息，必须要求他将数据比如写入多个副本之后，才返回一个ack回调响应。
      - 消费端，一旦消费处理成功一条消息了，必须返回一个ack给消息中间件，然后消息中间件才能删除这条消息。


<h2 id="多线程">多线程</h3>        
  	
  <h3 id="Java中进程和线程的关系">Java中进程和线程的关系</h3>       	
    - 启动一个java程序会产生一个进程 , 进程包含至少一个线程
    - 每个线程对应一个JVM实例 , 多个线程共享JVM里的堆 
    - Java采用单线程编程模型 , 程序会自动创建主线程

  <h3 id="线程的start和run方法的区别">线程的start和run方法的区别</h3>     
 
   ```java     
    public static void main(String[] args){
        Thread t = new Thread(){
            public void run(){
                attack();
            }
        };
        t.run();
        t.start();
    }
   ```
   - start()方法会创建一个新的子线程并启动
   - run()方法只是Thread中的一个普通方法的调用 , 还是在主线程里执行 

  <h3 id="线程的状态">线程的状态</h3>       
    
   - 新建(New) : 创建后尚未启动的线程的状态
   - 运行(Runnable) : 包含Running 和 Ready
   - 无限期等待( Waiting ) : 不会被分配CPU执行时间 , 需要显示被唤醒
   - 限期等待(Timed Waiting) : 在一定时间后会由系统自动唤醒
   - 阻塞(Blocked) : 等待获取排它锁
   - 结束(Terminated) : 已终止线程的状态 , 线程已经结束执行
     - 已经结束的线程不能再调用start方法 : t.join()之后再调用t.start()会抛出异常
     - t.join()  程序在main线程中调用t1线程的join方法，则main线程放弃CPU控制权，并返回t1线程继续执行直到线程t1执行完毕 , 所以结果是t1线程执行完后，才到主线程执行

  <h3 id="sleep和wait的区别">sleep和wait的区别</h3>            
   - sleep是Thread类的方法 , wait是object类中定义的方法
   - sleep方法可以在任何地方使用 ,Thread.sleep只会让出CPU , 不会导致锁行为的改变
   - wait方法只能在synchronized方法或synchronized块中使用 , Object.wait不仅让出CPU , 还会释放已经占有的锁资源 .  

  <h3 id="notify和notifyAll的区别">notify和notifyAll的区别</h3>      

   - 锁池EntryList 和 等待池WaitSet

     - 假设线程A已经拥有了某个对象(不是类)的锁 , 而其他线程B , C想要调用这个对象的某个synchronized方法(或者块) , 由于该对象的锁正被A占用 , 此时B , C线程就会被阻塞 , 进入一个地方去等待锁的释放 , 这个地方便是对象的锁池 . 

     - 假设线程A调用了某个对象的wait()方法 , 线程A就会释放该对象的锁 , 同时线程A就进入到了该对象的等待池中 , 进入到等待池中的线程不会去竞争该对象的锁 . 

   - notifyAll会让所有处于等待池的线程全部进入锁池去竞争获取锁

   - notify只会随机选取一个处于等待池中的线程进入锁池去竞争获取锁

  <h3 id="yield">yield</h3>   

   - 当调用Thread.yield()函数时 , 会给线程调度器一个当前线程愿意让出CPU使用的暗示 , 但是线程调度器可能会忽略这个暗示 . 

     ```java     
     public class YieldDemo {
         public static void main(String[] args) {
             Runnable yieldTask = new Runnable() {
                 @Override
                 public void run() {
                     for (int i = 1; i <= 10; i++) {
                         System.out.println(Thread.currentThread().getName() + i);
                         if (i == 5) {
                             Thread.yield();
                         }
                     }
                 }
             };
             Thread t1 = new Thread(yieldTask, "A");
             Thread t2 = new Thread(yieldTask, "B");
             t1.start();
             t2.start();
         }
     }
     ```
  <h3 id="interrupt">interrupt</h3>   

   - 调用interrupt() , 通知线程应该中断了
     - 如果线程处于被阻塞状态 (sleep , wait, join ), 那么线程将立即退出被阻塞状态 , 并抛出一个InterruptedException异常 . 
     - 如果线程处于正常活动状态 , 那么会将该线程的中断标志设置为true , 被设置中断标志的线程讲继续正常运行 , 不受影响 . 只是把其体内的中断状态字段改变，实际还是需要根据业务去处理，比如说判断为中断后是否还要继续执行或者提前结束，此时线程依然处于Running状态。而对于wait或者sleep，由于已经让出执行，则此时咱们连中断状态都设置不了，只能抛出InterruptedException提早结束等待或者阻塞的状态，变回runnable，执行catch的逻辑。

  <h3 id="线程之间状态的转换">线程之间状态的转换</h3>   

   ![线程状态之间的转换](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E7%BA%BF%E7%A8%8B%E7%8A%B6%E6%80%81%E4%B9%8B%E9%97%B4%E7%9A%84%E8%BD%AC%E6%8D%A2.png)   
         
  <h3 id="线程安全问题">线程安全问题</h3>         

   - 诱因
     - 存在多条线程共同操作这些共享数据( 临界资源 )
   - 根本解决思路
     - 同一时刻有且只有一个线程在 操作共享数据 , 其他线程必须等到该线程处理完数据后再对共享数据进行操作 . 

  <h3 id="synchronized">synchronized</h3>       

   - 只能锁对象和锁类

     - 同步代码块synchronized(this) , synchronized(类实例对象) . 同步非静态方法synchronized method  , 锁当前对象的实例对象 .
     - 同步代码块 synchronized(类.class) , 同步静态方法synchronized static method , 锁当前对象的类对象(Class 对象) . 

   - 实现synchronized的基础

     - Java对象头

       - 对象在堆内存中的布局

         - 对象头

           ![对象头结构](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%AF%B9%E8%B1%A1%E5%A4%B4%E7%BB%93%E6%9E%84.png)

         - 实例数据

         - 对齐填充

     - Monitor 

       - 存在于每个Java对象的对象头中 .
       - \_WaitSet对应着等待池 , \_EntryList对应着锁池 . 当多个线程访问同一段代码时 , 首先进入\_EntryList集合里面 , 当某线程获取到锁之后就进入\_object区 , 并把\_owner变量设置为当前线程 , 同时计数器\_count就会加1 ; 若线程调用wait方法 , 讲释放当前线程持有的Monitor , \_owner被回复成null , \_count会-1 , 复位别的变量的值, 该线程及objectWaiter会进入\_WaitSet等待被唤醒 .

     - synchronized是可重入的

     - 早期synchronized效率低下的原因 :

       - 早期版本中synchronized属于重量级锁 , 依赖于Mutex Lock实现
       - 线程之间的切换需要从用户态转换到核心态 , 开销较大 

     - java6以后 , 从JVM层面对synchronized进行了很多优化

       - 自适应自旋 Adaptive Spinning
       - 锁消除 Lock Eliminate
       - 锁粗化 Lock Coarsening
       - 轻量级锁 Lightweight Locking 
       - 偏向锁 Biased Locking
       - 为了在线程之间更高效地共享数据 , 解决竞争问题 . 

   - 自旋锁

     - 在很多情况下 , 共享数据的锁定状态只会持续很短的时间 , 为了这段时间去挂起或回复阻塞线程并不值得, 完全可以让另一个没获取到锁的线程在门外等待一会 , 但不让出CPU , 通过让线程执行忙循环等待锁的释放 . 本质上是与阻塞不同的 . CAS
     - 适用于锁被占用时间短 , 若锁被其他线程长时间占用 , 会带来许多性能上的开销 . 

   - 自适应自旋锁 (java6之后引入)

     - 自旋的次数不在固定 , 由前一次在同一个锁上的自旋时间及锁的拥有者的状态来决定 . 
     - 如果在同一个锁对象上自旋等待成功刚刚获取到锁 , 并且持有锁的线程正在运行中 , jvm会认为该锁自旋获取到锁的可能性很大 , 会自动增加等待时间 , 比如增加到50次循环 ; 相反如果对于某个锁自旋很少获取到 , 那在以后获取到锁时可能省略掉自旋过程 , 避免CPU的浪费 .

   - 锁消除

     - JIT编译时 , 对运行上下文进行扫描 , 去除不可能存在竞争的锁 . 比如某一个方法内部的StringBuffer sb = new StringBuffer(); sb属于不可能共享的资源 , JVM会自动消除内部的锁 .	

   - 锁粗化

     - 通过扩大加锁的范围 , 避免反复加锁和解锁 . 比如 , 在循环中对同一个对象反复加锁 :

       ```java   
       StringBuffer sb = new StringBuffer();
       while(i < 100){
           sb.append(1);
           i ++;
       }
       return sb.toString;
       ```

   - synchronized的四种锁状态

     - 无锁 -> 偏向锁 -> 轻量级锁 -> 重量级锁

     - 偏向锁 : 减少同一线程获取锁的代价 , 适合竞争不激烈的场合 , 因为在该场合下 , 锁不存在多线程竞争 , 总是由同一线程多次获得 . 

       - 核心思想 : 如果一个线程获得了锁  , 那么锁就进入偏向模式 , 此时Mark Word的结构也变为偏向锁结构 , 当该线程再次请求锁时 , 无需再做CAS任何同步操作 , 即获取锁的过程只需要检查Mark Word的锁标记为偏向锁以及当前线程Id等于Mark Word的ThreadID即可 , 这样就省去了大量有关申请的操作 . 

     - 轻量级锁 : 偏向锁运行在一个线程进入同步块的情况下 , 当第二个线程加入锁争用时 , 偏向锁就会升级为轻量级锁 , 适用于线程交替执行同步块

       三种锁状态的区别:

       ![三种锁状态的区别](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E4%B8%89%E7%A7%8D%E9%94%81%E7%8A%B6%E6%80%81%E7%9A%84%E5%8C%BA%E5%88%AB.jpg)

  <h3 id="ReentrantLock与synchronized的区别">ReentrantLock与synchronized的区别</h3>       

   - synchronized时关键字 , ReentrantLock是类
   - ReentrantLock可以对获取锁的等待时间进行设置 , 避免死锁
   - ReentrantLock可以获取各种锁的信息 ,可以灵活实现多路通知
   - sych操作的是对象头Mark Word , lock调用Unsafe类的park()方法 . 


  <h3 id="Java线程池">Java线程池</h3>          

   - newFixedThreadPool( int  nThreads)  

     - 指定工作线程数量的线程池

   - newCachedThreadPool() : 处理大量短时间工作任务的线程池

     - 试图缓存线程并重用 , 当无缓存线程可用时 , 就会创建新的工作线程;
     - 如果线程闲置的时间超过阈值 , 则会被终止并移出缓存 , 一般是60s ;
     - 系统长时间闲置的时候 , 不会消耗什么资源;

   - newSingleThreadPool

     - 创建唯一的工作者线程来执行任务 , 如果线程异常结束 , 会有另一个线程取代它;

   - newSingleThreadScheduledExecutor()与newScheduledThreadPool(int corePoolSize)

     - 定时或者周期性的工作调度 , 两者的区别在于单一工作线程还是多个线程;

   - newWorkStealingPool()

     - 内部会构建ForkJoinPool , 利用working-stealing算法 , 并行地处理任务 , 不保证处理顺序 ;

     - Fork/Join框架 

       - 把大任务分割成若干小任务分发给线程池中的工作线程 , 并行执行 , 最终汇总每个小任务结果后得到大任务结果的框架 . ( 原理类似map - reduce )

       - 使用工作窃取算法 , work-stealing算法 : 某个线程从其他队列里窃取任务来执行

         Fork/Join把这些子任务分别放在不同的队列里 , 并为每个队列创建一个单独的线程来执行队列里的任务 ,  完成自己队列任务的工作线程可以从其他busy的队列中窃取任务来执行 . 

   - J.U.C的三个Executor接口

     - Executor : 运行新任务的简单接口 , 将任务提交和任务执行细节解耦

     - ExecutorService : 具备管理执行器和任务生命周期的方法 , 提交任务机制更完善

     - ScheduledExecutorService : 支持Future和定期执行任务

       ![Executor的框架](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/Executor%E7%9A%84%E6%A1%86%E6%9E%B6.png)

   - ThreadPoolExecutor的构造函数

     - corePoolSize : 核心线程数量 (长期维持)
     - maximumPoolSize : 线程不够用时能够创建的最大线程数
     - workQueue : 任务等待队列
     - keepAliveTime : 非核心线程无工作任务的等待时间 , 超过时间会被销毁
     - threadFactory : 创建新线程的工厂 , Executors.defaultThreadFactory()
     - handler : 饱和策略 ,  等待队列满了且没有空闲的线程 , 继续提交该任务会执行该拒绝策略
       - AbortPolicy : 直接抛出异常 , 这是默认策略
       - CallerRunPolicy : 用调用者所在的线程来执行任务
       - DiscardOldestPolicy : 丢弃队列中靠最前的任务 , 并执行当前任务
       - DiscardPolicy : 直接丢弃任务
       - 实现RejectedExecutionHandler接口的自定义handler

   - ThreadPoolExecutor内部的处理流程

     ![ThreadPoolExecutor流程](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/ThreadPoolExecutor%E6%B5%81%E7%A8%8B.png)

     - 在刚刚创建ThreadPoolExecutor的时候，核心线程并不会立即启动，而是要等到有任务提交时才会启动，除非调用了prestartCoreThread/prestartAllCoreThreads事先启动核心线程。
     - 等待队列WorkQueue先来接收新的任务 , 将任务排队提交给内部的线程池(静态内部类Worker继承了AQS)
     - ThreadFactory进行创建线程 , 放入Worker
     - 如果运行的线程少于corePoolSize , 则创建的新线程来维持核心线程的数量
     - 如果线程池中的线程数量大于等于corePoolSize且小于maximumPoolSize , 则只有当workQueue满时才创建新的线程去处理任务
     - 如果corePoolSize和maximumPoolSize相同 , 则新任务放入workQueue中
     - 当线程池shutDown了 , 或者等待队列满了 , 执行RejectExecutionHandler . 

   - 线程池的状态
   
     - RUNNING : 能接受新提交的任务 , 并且也能处理阻塞队列中的任务 . 
     - SHUTDOWN : 不再接受新提交的任务 , 但可以处理存量任务 . 
     - STOP : 不再接受新提交的任务 , 也不处理存量任务 . 
     - TIDYING : 所有的任务都已终止 . 
     - TERMINATED : terminated()方法执行完后进入该状态 . 
   
     ![线程池状态转换图](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E7%BA%BF%E7%A8%8B%E6%B1%A0%E7%8A%B6%E6%80%81%E8%BD%AC%E6%8D%A2%E5%9B%BE.png)
   
   - 线程池的大小如何选定
   
     - CPU密集型 (任务主要计算的) : 线程数 = 核数 + 1 , 线程过多会造成频繁的上下文切换
     - I/O密集型 (处理较多等待的任务,吞吐量优先) : 线程数 = CPU核数 * ( 1+平均等待时间/平均工作时间 ) 

     
  <h3 id="一道JVM类加载机制的面试题">一道JVM类加载机制的面试题</h3>          

![jvm加载顺序代码](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/jvm%E5%8A%A0%E8%BD%BD%E9%A1%BA%E5%BA%8F%E4%BB%A3%E7%A0%81.jpg)

- 请问这段程序的输出是什么

- 答案 : 

  > 2
  >
  > 3
  >
  > a=110,b=0
  >
  > 1
  >
  > 4

- 这里主要的点之一：**实例初始化不一定要在类初始化结束之后才开始初始化**。 

  - 类的生命周期是：加载->验证->准备->解析->初始化->使用->卸载。

  - 只有在准备阶段和初始化阶段才会涉及类变量的初始化和赋值，因此只针对这两个阶段进行分析；类的准备阶段需要做是为类变量分配内存并设置默认值，因此类变量st为null、b为0；需要注意的是如果类变量是final，编译时javac将会为value生成ConstantValue属性，在准备阶段虚拟机就会根据ConstantValue的设置将变量设置为指定的值。如果这里这么定义：static final int b=112，那么在准备阶段b的值就是112，而不再是0了。

  - 类的初始化阶段需要做的是执行类构造器。类构造器是编译器收集所有静态语句块和类变量的赋值语句，按语句在源码中的顺序合并生成类构造器，对象的构造方法是()，类的构造方法是()，可以在堆栈信息中看到。因此，先执行第一条静态变量的赋值语句，即st = new StaticTest ()，此时会进行对象的初始化。对象的初始化是先初始化成员变量，再执行构造方法。因此打印2->设置a为110->执行构造方法(打印3,此时a已经赋值为110，但是b只是设置了默认值0，并未完成赋值动作)。

  - 等对象的初始化完成后，继续执行之前的类构造器的语句。接下来就不详细说了，按照语句在源码中的顺序执行即可。

- 这里面还牵涉到一个冷知识，就是在嵌套初始化时有一个特别的逻辑。特别是内嵌的这个变量恰好是个静态成员，而且是本类的实例。这会导致一个有趣的现象：“实例初始化竟然出现在静态初始化之前”。 其实并没有提前，你要知道java记录初始化与否的时机。看一个简化的代码，把关键问题解释清楚：

  ```java    
  public class Test{
      public static void main(String[] args){
          func();
      }
      static Test st = new Test();
      static void func(){}
  }
  ```

- 根据上面的代码，有以下步骤：  

  1. 首先在执行此段代码时，首先由main方法的调用触发静态初始化。
  2. 在初始化Test 类的静态部分时，遇到st这个成员。
  3. 但凑巧这个变量引用的是本类的实例。
  4. 那么问题来了，此时静态初始化过程还没完成就要初始化实例部分了。是这样么？
  5. 从人的角度是的。但从java的角度，一旦开始初始化静态部分，无论是否完成，后续都不会再重新触发静态初始化流程了。
  6. 因此在实例化st变量时，实际上是把实例初始化嵌入到了静态初始化流程中，并且在楼主的问题中，嵌入到了静态初始化的起始位置。这就导致了实例初始化完全至于静态初始化之前。这也是导致a有值b没值的原因。
  7. 最后再考虑到文本顺序，结果就显而易见了。
  
  


# Guava

1. spilt拆分

   ```
   String a = "a,,b,,c";
   ```

   用string.spilt(",")拆分空值是拆分不掉的,可以用Guava提供的工具类快速去掉空值:

   ```
   String a = ",a,,b,";
   String[] split = a.split(",");
   log.info("原生split拆分: {}", Lists.newArrayList(split));  // 结果["","a","","b"]
   // Guava拆分
   List<String> splitGuava = Splitter.on(",")
   .omitEmptyStrings()   // 去掉空值
   .trimResults()   // 默认去掉首尾的空格
   .splitToList(a);
   log.info("guava的split拆分: {}" , splitGuava); // ["a","b  c"]
   ```



2. join合并

   ```
   // String.join 的两个缺点: 1.不支持一次join多个字符串,后一次join会把前一次覆盖  2.如果join的是一个list,无法过滤到null值
   // Guava的API
   String join = Joiner.on(",").skipNulls().join("karl", null, "awesome");
   log.info("一次join多个字符串: {}", join);
   
   String join1 = Joiner.on(",").skipNulls().join(Lists.newArrayList("karl", null, "awesome"));
   log.info("自动去除list中空值: {}", join1);
   ```

   
   
   
   

<h2 id="实用tips">实用tips</h3>        
  	
  <h3 id="策略模式两种实现思路">策略模式两种实现思路</h3>    
      	
   1. 容器类利用spring的BeanFactoryAware , BeanPostProcessor方式  com/guoguo/javaAudition/example/SpringBeanContainer.java:21

   2. 实现类利用@PostConstruct注解方式  com/guoguo/javaAudition/example/StrategyModeContainer.java:16

      