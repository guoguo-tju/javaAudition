





<h3 id="分布式篇">分布式篇</h3> 

1. 服务框架 , Dubbo , spring cloud , gRPC , Thrift . 

服务注册和发现 , 通信和序列化 , 负载均衡 , 扩展机制 , 请求重试 , 请求超时

2. spring cloud核心组件

   1. 注册中心Eureak
   2. 服务调用Feign
   3. 负载均衡Ribbon
   4. 网关Zuul / Gateway
      1. 灰度发布: 流量分发给灰度部署的机器
      2. 统一限流:
      3. 统一熔断:
      4. 统一鉴权:

3. Dubbo调用底层实现

   1. 消费者

      1. 动态代理:Proxy
      2. 负载均衡:Cluster , 故障转移
      3. 通信协议:Protocol , http/rmi/dubbo等协议
      4. 信息交换: Exchange , Request , Response
      5. 网络通信: Transport , 基于netty/mina实现
      6. 序列化: 封装好的请求序列化成二进制数组 , 通过netty/mina发送出去

   2. 生产者

      1. 反序列化
      2. 网络通信: Transport
      3. 信息交换: Exchange
      4. 通信协议: Protocol 
      5. 动态代理: Proxy

      ![Dubbo底层调用原理](C:\Users\guozh\Desktop\java\石杉\Dubbo底层调用原理.jpg)

   3. 网络通信netty

      1. 基于NIO实现的

      2. 服务提供者

         1. Acceptor线程通过Selector组件轮询ServerSocketChannel的网络事件  , 同时ServerSockerChannle会持续监听端口号 , 看有没有消费者netty来建立网络连接.
         2. 消费者通过netty框架与服务提供者的端口号和ServerSocketChannel建立连接 , 每个消费者建立一个SocketChannel对象 . netty会将建立好的连接SocketChannle分配给Processor线程 , 每一个Processor线程通过多路服用轮询组件Selector , 来不断轮询看这些SocketChannel对应的服务消费者有没有发请求过来. 轮询到有请求过来就会解析请求走后面的流程.
         3. 每个Processor可以支撑多个消费者的请求.
         4. 服务响应也是通过Processor线程 , 通过对应消费者的SockerChannel发响应发回到消费者的netty .

      3. 服务消费者

         1. 同提供者类似 ,也是对一个提供者建立一个SocketChannel连接, 一个Processor线程通过Selector轮询多个SocketChannel的网络事件 , 把响应值返回给消费者.

         ![网络通信netty框架原理](C:\Users\guozh\Desktop\java\石杉\网络通信netty框架原理.jpg)

4. 如何设计一个RPC框架

   1. 动态代理  
      1. 消费者和提供者都要实现某个框架的动态代理的, PRC框架的一切细节都在这个动态代理里面实现.调用动态代理的方法.
   2. 服务注册中心
      1. 服务注册,服务发现 . 或者 基于zookeeper .
   3. Cluster层 
      1. 从本地服务注册表根据负载均衡找到要调用的机器列表 .
      2. 负载均衡策略 . 
   4. 调用信息交给协议层 
      1. 协议
      2. 网络通信框架
      3. 序列化和反序列化

5. Springcloud底层原理

   1. 注册中心Eureka

      1. 服务注册与发现
         1. 服务注册表 , 二级缓存(ReadWrite缓存+ReadOnly缓存) , 后台有线程会定时将ReadWrite缓存同步给ReadOnly缓存 , 服务发现定时(每隔30s)拉取ReadOnly的缓存 . 
      2. 心跳与故障
         1. 服务注册机器会每30s发送一次心跳 , 服务注册表会记录心跳 , 后台有个心跳线程会定时检查,当发现一定时间内某个机器没有心跳 , 任务机器挂了 , 将该机器剔除服务注册表 , 同事会发指令ReadWrite缓存 , ReadWrite缓存会清空自己 , 然后定时同步线程也会清空ReadOnly缓存 . 当下次的服务发现时会去服务注册表拉取最新的数据更新到两个缓存中.

      ![Eureka注册中心原理](C:\Users\guozh\Desktop\java\石杉\Eureka注册中心原理.jpg)

   2. Ribbon

   3. Feign 

      1. 对一个接口打了一个注解 , 他会针对这个注解标注的接口生成动态代理 , 调用时底层生成http协议格式的请求 , 通过Ribbon 从本地的服务注册列表中根据负载均衡算法获选出一个机器 , 接着对机器发送http请求即可.

   4. Zuul

      1. 配置一下不同请求路径和服务的对应关系 , 把请求直接匹配到服务 , 基于Ribbon , 发请求到指定的机器上去.

6. Dubbo和Springcloud的优缺点

​	1.总结：dubbo优点：深度优化后，基于TCP的RPC调用更加轻量级，速度更快。 dubbo缺点：只是一		套RPC服务框架没有配套设施，需要自己再找其他的组件去做配合使用。 SpringCloud优点：开箱即用，和spring完美搭配，提供一整套分布式系统解决方案。 SpringCloud缺点：基于http请求，较慢。有些组件存在问题（springCloud config） 两者差异：最大的差异在对请求的处理上，一个基于TCP一个基于HTTP。一个是RPC服务框架，一个是分布式系统解决方案。

7. 服务注册中心比较

   1. Eureka集群架构

      1. peer2peer，每个注册中心服务的节点地位相等，会将每次心跳和更新请求同步到每一个节点上，因此并发高了之后，注册中心的内部流量会很大。注册列表的更新方式是通过客户端拉取

   2. Zookeeper集群

      1. master-follower，通过只对主节点进行写，然后由主节点同步到从节点后，主动向节点推送到各个服务节点。时效性较高 .  服务消费者可以去加监听服务列表, ZK会主动通知给消费者服务列表的变动.当有机器新增或者下线, ZK的leader节点先感知到然后同步给Follower节点,Follower节点主动通知服务消费者.

         ![ZooKeeper服务注册与发现原理](C:\Users\guozh\Desktop\java\石杉\ZooKeeper服务注册与发现原理.jpg)

   3. 一致性保障 CP or AP

      1. C:Consisitency(一致性)

         A:Availability(可用性) 

         P:Partition Tolerance(分区容错性) .

         CAP相关文章: https://juejin.im/post/6844903936718012430

         在分布式的环境下，网络无法做到100%可靠，有可能出现故障，因此分区是一个必须的选项，如果选择了CA而放弃了P，若发生分区现象，为了保证C，系统需要禁止写入，此时就与A发生冲突，如果是为了保证A，则会出现正常的分区可以写入数据，有故障的分区不能写入数据，则与C就冲突了。因此分布式系统理论上不可能选择CA架构，而必须选择CP或AP架构。

      2. zk: 基于cp，保证数据的顺序一致性，因此需要牺牲掉一些可用性，例如主节点宕机后，就不再可用（不提供读写服务），需要从从节点中再次选取出主节点后才会继续提供服务。

      3. Eureka：基于ap，保证节点的可用性，在某一些服务节点挂掉之后，其余节点可以继续提供服务，但是因为数据未能同步，所以其它节点提供的数据可能是不一致的, 会确保最终一致性。 这两者之间的差异，都是因为模式造成的，一个是中心化，一个是去中心化。

   4. 服务注册发现的时效性

      1. zk时效性好 , 秒级别可以感知

      2. Eureka , 默认配置比较糟糕 , 服务发现感知到要几十秒 , 甚至分钟级别.

         优化:  

         1. ReadOnly缓存和ReadWrite缓存的同步周期缩短(30s->3s) , eureka.server.responseCacheUpdateIntervalMs = 3000

         2. 服务发现拉取的周期缩短(30s->3s),

            eureka.client.registryFetchIntervalSeconds = 3

         3. 服务心跳上报周期缩短(30s->3s)

            eureka.client.leaseRenewalIntervalInseconds = 3

         4. 心跳检查周期缩短(60s->6s)

            eureka.server.evictionIntervalTimeMs=6000

         5. 心跳超时时间(超过这个时间判定为死亡.90s->9s)

            eureka.instance.leaseExpirationDurationInSeconds= 90

         6. 关闭eureka的自我保护机制(突然网络故障,一定比例机器没有发生心跳,会触发保护机制,保护服务注册表不会被修改 , 源码的bug较多)

            eureka.server.enableSelfPreservation: false

   5. 容量

      1. zk: 不适合大规模的服务实例 , 因为服务上下线的时候会瞬间推送数据通知到所有的其他服务实例 , 一旦达到几千服务实例时 , 会导致网络带宽被大量地占用.
      2. Eureka: 也很难支撑大规模的服务实例 , 因为每个节点收到数据通知都要同步给其他节点 , 相当于每次更新会落到集群的每个节点上 , 如果服务过多 , Eureka整个集群内部流量巨大.
      3. 实际生成部署,会采用比较高的配置的机器来做,8C16G, 16C32G的高配机器来做,基本可以做到每台机器每秒钟支撑几千请求.

   6. 部署上万服务实例 , 服务注册中心如何优化(自研注册中心)

      1. 服务注册表分片存储. 每台机器存储部分的服务注册表,机器不互相同步数据 , 将集群请求分散到多个节点.应对. (高并发)
      2. 每个机器都有自己的Slave机器做备份机器来保证(高可用).
      3. 通过主从节点都写成功了再返回ack(一致性).
      4. 服务消费者 通过代理层去指定的节点拉取部分注册信息，不用每次都拉取集群的全集。

      ![自研注册中心架构](C:\Users\guozh\Desktop\java\石杉\自研注册中心架构.jpg)

   7. 其他注册中心比较

      |       Feature        | Consul                                  | Zookeeper                      | Etcd                  | Eureka                           | SofaRegistry           |
      | :------------------: | :-------------------------------------- | ------------------------------ | --------------------- | -------------------------------- | ---------------------- |
      |     服务健康检查     | 定期healthcheck(http/tcp/script/docker) | 定期心跳保持会话(session) +TTL | 定期refresh(http)+TTL | 定期心跳+TTL;支持自定义healcheck | 定期连接心跳＋锻炼敏感 |
      |        一致性        | raft                                    | ZAB                            | raft                  | 最终一致性BASE                   | 最终一致性BASE         |
      |         cap          | cp                                      |                                |                       |                                  |                        |
      | 使用接口(多语言能力) | 支持http和dns                           | 客户端                         | http/grpc             | 客户端/http                      | 客户端(java)           |
      |      watch支持       | 全量/支持long polling                   | 支持                           | 支持long polling      | 不支持(client定期fetch)          | 支持(服务端推送)       |
      |         安全         | acl/https                               | acl                            | https支持(弱)         | -                                | acl                    |
      |   spring cloud集成   | 支持                                    | 支持                           | 支持                  | 支持                             | 支持                   |

   

8.网关

1. 网关的作用:

   1. 动态路由 , 负载均衡: 新开发某个服务 , 动态把请求路径和服务的映射关系加载到网关;服务增减机器,网关自动热感知.
   2. 灰度发布 . 可以调整流量比例到新代码的机器上.比如默认是50%的流量到新机器,如果新代码有问题,50%的服务就不可用了,可以通过网关来调整流量的比例 , 逐步扩大灰度比例 . 降低新代码上线的影响.
   3. 鉴权认证
   4. 接口性能监控 . 每个api接口的RT , QPS , 成功率等.
   5. 系统日志
   6. 限流熔断
   7. 数据缓存 . 某些接口的响应做缓存

2. 网关的技术选型

   1. Kong : 依托于Nginx实现，OpenResty，lua实现的模块，现成的一些插件，可以直接使用 . Nginx抗高并发的能力很强，少数几台机器部署一下，就可以抗很高的并发，精通Nginx源码，很难，c语言，很难从Nginx内核层面去做一些二次开发和源码定制
   2. Zuul : Spring cloud , 基于java开发,核心网关功能比较简单 , 但是比如灰度发布 , 限流 , 动态路由之类的都需要二次开发. 高并发能力不强.
   3. 自研网关: Java技术栈为主的大厂，很多其实用Java、Servlet、Netty来开发高并发、高性能的网关系统，自己可以把控一切

3. 动态路由的实现

   1. 动态路由实现: 可以使用第三方组件保存路由关系，然后在网关里面通过定时任务去定时刷新组件中保存的路由信息。 因此就可以基于mqsql去做路由关系的保存，然后通过后台管理系统去操作db，再由网关去定时查询db更新路由表，实现动态路由效果。 
   2. 代码实现: C:\Users\guozh\Desktop\java\石杉\代码2\zuul-gateway\src\main\java\com\zhss\demo\zuul\gateway 中

4. 网关抗住每秒10w的高并发访问 ,如何优化

   1. zuul集群部署  , 前面有一层Ngnix反向代理 , 前面再有一层LVS负载均衡层.

      LVS是Linux virtual 
      server的缩写，是一个高可用性、高性能的虚拟服务器集群系统。主要针对高可伸缩、高可用网络服务的需求，给出了基于IP层和基于内容请求分发的负载平衡调度解决方法，并在Linux内核中实现了这些方法，将一组服务器构成一个实现可伸缩的、高可用网络服务的虚拟服务器。

   2. zuul网关部署机器,部署8C16G , 每秒几千请求不是问题 . 10w请求要几十台网关机器

   3. 生产级的网关应该具备上面的几个特点和功能.需要二次开发. 动态路由/灰度发布/鉴权认证/限流熔断

5. 如何基于网关实现灰度发布

   1.  开发流程： 首先自己建一张表，存入具体uri以及是否灰度发布的一些信息，然后搞一张映射表。 启动个线程每个多少时间就去刷新数据写到concurrenthashmap里面。 接着搞一个filter继承ZuulFilter，重写里面几个函数，其中shouldFilter根据返回值去判断执不执行run。 因此再should里面遍历map去看这次请求是否有开启灰度发布，如果有就执行run里面的逻辑，就自定义一些分发逻辑，这里用的时通过version去判断和分发。 2、灰度发布流程 首先通过后台系统更改灰度发布标识，后台线程更新了map后，就会去执行根据version分发的策略，将少部分流量分发到new上，然后监控和对应的后台，如果没问题，就更改为current，全线上线，最后将灰度发布表示改回来。
   2. 代码实现:  C:\Users\guozh\Desktop\java\石杉\代码 3\zuul-gateway\src\main\java\com\zhss\demo\zuul\gateway 里面 GrayRelease*的三个文件.

6. 公司的网关mbgw的架构图

   ![公司网关架构图](C:\Users\guozh\Desktop\java\石杉\公司网关架构图.jpg)



9.分布系统实践问题

1. 各服务在生产环境如何部署

   1. 中小型公司，一般服务拆分大概在十几二十个，那么相对来说比较好部署。

      注册中心，4核8G的机器，可以抗住每秒大概1000左右的请求，那么部署两台，就完全足够了。另外部署两台还可以作为高可用的冗余，相关的优化参数可以调到很小，让服务的发现，服务注册，服务异常等等信息的时效性很高。 

      网关的话，4核8G的机器，也是差不多能抗1000左右，但是一般会部署3-4机器，保证高可用的同时也可以降低每个网关系统的压力，通常在网关之前还会用ngx的反向代理+LVS负载均衡。 

      数据库，16核32G的机器部署mysql，高峰期可以抗住三四千的请求。 

      以上是对应机器配置的相对经验值，如果要求对应的qps达到几千几万的话。需要一个个模块再次进行优化

      