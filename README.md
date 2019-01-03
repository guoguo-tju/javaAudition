
# java面试知识点

<br>

* [网络知识](#网络知识)

* [代理模式](#代理模式)
* [模板方法模式](#模板方法模式)



<br>


<h2 id="网络知识">网络知识</h2>

<br>

   1. TCP的三次握手  
    TCP是属于传输层的协议,抓包的工具Wireshark
    三次握手的流程如下:  
    1)第一次握手,建立连接时,客户端发送SYN包(syn=j)到服务器,并进入SYN_SEND状态,等待服务器确认;  
    2)第二次握手,服务器收到SYN包,必须确认客户的SYN,同时自己也发送一个SYN包(syn=k),即SYN+ACK(ack=j+1)包,此时服务器进入SYN_RECV状态.  
    3)第三次握手,客户端收到服务器的SYN+ACK包,向服务器发送确认包ACK(ack=k+1),此包发送完毕,客户端和服务器进入ESTABLISHED状态,完成三次握手.    
    为什么需要三次握手才能建立起连接?   
     为了初始化Sequence Number的初始值(即上面的j和k),以保证信息传输过程中不会乱序.所以在服务器发送了Sequence Number后(第二次握手),需要客户端发送确认报文给服务器,告知已收到其初始化的Sequence Number了.  
    首次握手的隐患--SYN超时问题  
     Server收到Client的SYN,回复SYN-ACK的时候未收到ACK确认.Server会不断重试直至超时,Linux默认重试5次,每次等待时间翻倍(2+4+8+16+32),总共等待63秒才断开连接.会是server招到SYN Flood攻击,将服务器的连接数耗尽,不能处理正常的连接请求.    
     Liunx下针对SYN Flood的防护措施:   
     SYN队列满后,Server会通过TCP的一个特殊的tcp_syncookies参数(请求地址+目标地址+时间戳组成)会发SYB Cookie,若为正常连接Client是会有响应的,会回发SYN Cookie,在即使SYN队列满的情况下,也能建立连接.  
    
   2. TCP的四次挥手(断开时)  
     第一次挥手:Client发送一个FIN,用来关闭Client到Server的数据传送,Client进入FIN_WAIT_1状态;  
     第二次挥手:Server收到FIN后,发送一个ACK给Client,确认序号为收到序号+1(与SYN相同,一个FIN占用一个序号,Server进入CLOSE_WAIT状态);  
     第三次挥手:Server发送一个FIN,用来关闭Server到Client的数据传送,Server进入LAST_ACK状态;  
     第四次挥手:Client收到FIN后,Client进入TIME_WAIT状态,接着发送一个ACK给Server,确认序号为收到序号+1,Server进入一个CLOSED状态,完成四次挥手.  
     为什么需要四次挥手才能断开连接?  
     因为全双工,发送方和接收方都需要FIN报文和ACK报文.  
     服务器中出现大量CLOSE_WAIT状态的原因?  
     Client关闭socket连接,Server没有及时关闭连接,可能情况:1)缺少一些释放资源的代码; 2)处理请求的线程配置不合理.  
     
   3. TCP的滑动窗口:  
     RTT: 发送一个数据包到收到对应的ACK,锁花费的时间.   
     RTO: 重传的时间间隔,是根据RTT的值动态计算的.   
     TCP传输过程中是把数据分为一段一段传输的,我们不能上一段被确认之后再发送下一段.要批量的发送,就要解决可靠传输和包乱序的问题. TCP使用滑动窗口做流量控制与乱序重排.
        
   4. 超文本传输协议HTTP:
     1.1相比1.0 : 引入keep-alive机制.以前是close
     若为close,是服务器主动关闭连接,若为keep-alive,则连接会保持一段时间不会立刻关闭,在此期间还可以数据传输.      
     
   5. 在浏览器键入url,按下回车之后经历的流程:  
     	1) 会依据url逐层查询DNS缓存,解析url中的域名对应的ip地址. 浏览器缓存-->系统缓存-->路由器缓存-->服务器缓存  
     	2) 根据ip地址和端口(默认80)与服务器建立TCP连接  
     	3) 浏览器发送http请求  
     	4) 服务器对http请求做出响应  
     	5) 浏览器解析渲染html  
     	6) 浏览器释放TCP连接,四次挥手   
   6. HTTP状态码:  
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
   	
   7. GET请求和POST请求的区别:    
    1.HTTP报文层面:  
     GET将请求信息放在url中,POST放在请求体中,所以POST请求没有长度限制,GET请求会有一些长度限制.  
    2.数据库层面:  
     GET都是查询请求,符合数据的幂等性和安全性,POST会修改数据库,不符合  
    3.缓存层面:  
     GET请求可以被缓存,被存储,而POST不行.所以绝大部分GET请求会被CDN缓存,大大减少web服务器压力,而POST是非幂等的,必须交由web服务器来处理  
    CDN缓存:  
     客户端浏览器先检查是否有本地缓存是否过期，如果过期，则向CDN边缘节点发起请求，CDN边缘节点会检测用户请求数据的缓存是否过期，如果没有过期，则直接响应用户请求，此时一个完成http请求结束；如果数据已经过期，那么CDN还需要向源站发出回源请求（back to the source request）,来拉取最新的数据。  
     
   8. Cookie和Session的区别: 


   

   * 工厂模式包括工厂方法模式和抽象工厂模式.
   * 抽象工厂模式是工厂方法模式得扩展.
   * 意图:
   	定义一个接口来创建对象,但是让子类来决定哪些类需要被实例化.
   	工厂方法把实例化的工作推迟到子类中去实现.
   	在软件系统中经常面临着对象的创建工作,由于需求的变化,这个对象可能也会随之发生变化,但它有比较稳定的接口.为此,我们需要提供一种封装机制来隔离出这个易便对象的的变化,从而保持系统中其他依赖该对象的对象不随需求变化而变化.
    
   ![工厂模式类图](https://raw.githubusercontent.com/guoguo-tju/DesignPattern/master/src/main/resources/picture/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F%E7%B1%BB%E5%9B%BE.png?t=1 "工厂模式类图")
	
   <h3 id="常见应用">常见应用</h3>
   
   * JDBC
   
   ![工厂模式在JDBC的实现](https://raw.githubusercontent.com/guoguo-tju/DesignPattern/master/src/main/resources/picture/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F%E5%9C%A8JDBC%E7%9A%84%E5%AE%9E%E7%8E%B0.png?t=1 "工厂模式在JDBC的实现")
   * Spring beanFactory 
   
      BeanFactory,作为Spring基础的Ioc容器,是Spring的一个Bean工厂.它是用来生产Bean,然后提供给客户端.
           Bean的实例化过程如下:
           1)调用Bean的默认构造方法,或指定的构造方法,生成bean实例(instance1).
           2)如果Bean的配置文件中注入了Bean属性值,则在instance1基础上进行属性注入形成instance2,这种注入是覆盖性的.
           3)如果Bean实现了InitializingBean接口,则调用afterPropertiesSet()方法,来改变或操作instance2,得到instance3.
           4)如果Bean的配置文件中指定了init-method="init"属性,则会调用指定的初始化方法,则在instance3的基础上调用初始化方法init(),将对象最终初始化为instance4,这个初始化的名字是任意的.
<br>

