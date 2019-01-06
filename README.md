
# java面试知识点

<br>

* [TCP的三次握手](#TCP的三次握手)
* [TCP的四次挥手(断开时)](#TCP的四次挥手(断开时))
* [TCP的滑动窗口](#TCP的滑动窗口)
* [超文本传输协议HTTP](#超文本传输协议HTTP)
* [在浏览器键入url,按下回车之后经历的流程](#在浏览器键入url,按下回车之后经历的流程)
* [HTTP状态码](#HTTP状态码)
* [GET请求和POST请求的区别](#GET请求和POST请求的区别)
* [Cookie和Session的区别](#Cookie和Session的区别)
* [HTTP和HTTPS的区别](#HTTP和HTTPS的区别)
* [如何设计一个关系型数据库](#如何设计一个关系型数据库)
* [索引模块](#索引模块)
* [如何定位并优化慢查询sql](#如何定位并优化慢查询sql)





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
   
   * 索引的数据结构?  
   
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
   * 密集索引和稀疏索引的区别: 见图 
   ![密集索引和稀疏索引](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/%E5%AF%86%E9%9B%86%E7%B4%A2%E5%BC%95%E5%92%8C%E7%A8%80%E7%96%8F%E7%B4%A2%E5%BC%95.png "密集索引和稀疏索引")
    
       密集索引: 每个搜索码都对应一个索引值.叶子结点中不仅保存键值还保存了该列的数据.一个表只能创建一个密集索引.  
       稀疏索引:
       只为索引码的某些值建立索引项.叶子结点只保存了键值以及该行数据的地址或者主键信息.找到叶子结点以后仍要通过地址或者主键信息来寻找数据.
   
   * 对Mysql分析:  见图  
   ![InnoDB与MyISAM](https://raw.githubusercontent.com/guoguo-tju/javaAudition/master/src/main/resources/picture/InnoDB%E4%B8%8EMyISAM.png "InnoDB与MyISAM")
   
       MyISAM: 表的所有类型的索引都用稀疏索引,索引与数据是分两个文件存储的.  
       InnoDB: 表有且仅有一个密集索引,其他索引都是稀疏索引(辅助键索引),索引与数据是在一个文件存储的.  
       
       密集索引规则:
        1) 有主键,该主键则作为密集索引  
        2) 没有主键,表的第一个唯一非空索引作为密集索引  
        3) 都没有,InnoDB会生成一个隐藏主键作为密集索引  
        4) 其他的稀疏索引(辅助键索引),其叶子结点会存储键值以及主键值,然后在通过主键值去密集索引里查找.  

       在mysql的根目录data文件下数据库里可以找到表相关文件:  
           xxx.frm存储的是表结构信息.  
           xxx.ibd是InnoDB下索引与数据的存储文件.  
           xxx.MYI是MyISAM下存储索引的文件.  
           xxx.MYD是MyISAM下存储数据的文件.  
    
   
   * 衍生出来的问题,以mysql为例:  

   * 如何定位并优化慢查询sql  
   
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
   

   * 联合索引的最左匹配原则的成因:  

   最左匹配原则:   
   1. mysql会一直向右匹配知道遇到范围查询(>,<,between,like)就停止匹配,比如a=3 and b=2 and c >5 and d =6 如果建立(a,b,c,d)顺序的联合索引,d是用不到索引的,如果建立(a,b,d,c)的联合索引就可以用到,a,b,d的顺序可以任意调整.  
   2. =和in可以乱序,比如a=1 and b=2 and c=3 建立(a,b,c)索引可以任意顺序,mysql的查询优化器会帮你优化成索引可以识别的形式.  

   原因:  
    创建联合索引时,先对最左边的字段进行排序,在第一个排序的基础上再对第二个索引字段进行排序.直接用第二个字段是用不到索引的.  
    建立联合索引的时候,把可能范围查询的字段放在后面.


   * 索引是建立的越多越好么?  
     1. 数据量小的表不需要建立索引,建立会增加额外的索引开销.  
     2. 数据变更需要维护索引,更多的索引意味着更多的维护成本.  
     3. 更多的索引意味着需要更多的空间.  
   
   <h3 id="锁模块">锁模块</h3>
* MyISAM与InnoDB关于锁方面的区别是什么?  
   
     MyISAM只支持表级锁,而InnoDB支持行级锁,也支持表级锁.  

     lock tables person_info read/write;   //给表加读锁或写锁  
     unlock tables;  //释放锁  

   读锁:是共享锁,上读锁以后仍然可以读操作,但不可以写操作.即上共享锁之后可以伤共享锁,不能上排它锁.  
   写锁:是排它锁,上了写锁以后既不能读操作也不能写操作.即上了排它锁之后不能上共享锁也不能上排它锁.  

   给读操作上排它锁:  
   select * from person_info where id = 111 for update.

   InnoDB用的是二段锁,即运行时加锁,然后commit提交来解锁,默认是自动提交事务的,通过下面的命令去除自动提交事务:   
   commit;  提交事务  
   
   show variables like 'autocommit'; 为on表示自动提交已经开启.  
   set autocommit = 0; 关闭自动提交.  

   InnoDB对select有改进,查询时不加读锁.要想select加入读锁,执行:  
    select * from person_info where id = 3 lock in share mode; 无法加入排它锁  
    commit;  之后可以加入排它锁  

   InnoDB当sql不走索引的时候,整张表就会被锁住,也就是用的表级锁.当sql走索引的时候,用的行级锁或者gap锁.  
   
   MyISAM适合的场景:  
   1. 频繁执行全表count语句,因为MyISAM有一个变量来存储表数据的行数,而InnoDB没有.
   2. 对数据进行增删改的频率不高,查询非常频繁
   3. 不用事务的场所. 
    
   InnoDB适合的场景:  
   1. 数据增删改查都相当频繁.
   2. 可靠性有求比较高,要求支持事务.  

* 数据库锁的分类:  

     按锁的粒度划分:表级锁,行级锁,页级锁
       
     按锁级别划分:共享锁,排它锁    
     
     按加锁方式划分:自动锁,显示锁  
       自动锁: insert,update,detele以及MyISAM的表锁,这是Mysql自动为我们上的.  
       显示锁: select for update , lock in share mode这些我们显示加的锁.  
       
     按操作划分: DML锁(多数据操作),DDL锁(对表结构操作) .
       
     按使用方式划分: 乐观锁,悲观锁  
        悲观锁:   
        对外界的修改持保守态度,依靠数据库提供的锁机制,在数据处理全程中用排它锁锁定(悲观锁的一种实现方式),即先取锁再访问的保守策略,数据的安全有保障,但是会增加数据库的开销,增加产生死锁的几率.    
  		乐观锁:   
  		认为外界的修改不会造成冲突,在数据提交时才会对数据的冲突与否进行检测,若发现错误则返回错误的信息,让用户决定怎么做.乐观锁并不使用数据库提供的所机制,采用记录数据版本(1.用版本号记录version(int) 2.用时间戳记录)的方式来实现.    	
  		先读取数据,得到version的值为versionValue;  
  		每次更新数据的时候,为了防止冲突,先去检查version再做更新,更新成功的话version+1,冲突的话将失败信息返回给用户.  
  		认为数据之间冲突的可能性较小,在提交时才检查版本,而不是在提交之前就锁住数据.不会产生死锁.
  		类似CAS机制??

*  数据库事务的四大特性:  ACID  
  	原子性(Atomic):  
  	  事务包含的所有操作要么全部执行,要么全部不执行.  
  	一致性(Consistency):  
  	  事务应确保数据库状态从一个一致的状态转变为另外一个一致的状态, 比如A和B无论怎么转账,两者的金额之和不变.   
  	隔离性(Isolation):  
      多个事务并行执行时,一个事务的执行不能影响其他事务的执行.  
  	持久性(Durability):  
  	  一个事务一旦提交它对数据库的修改应该永久性的保存在数据库中,即当数据库发生故障时,确保已经提交的事务不能丢失.  
 
* 事务隔离级别以及各级别下的并发访问问题:
  	
