springcloud组件

+ **主要由配置中心、注册中心、服务网关、负载均衡、RPC调用、服务熔断、服务降级、服务限流、全局锁、控制总线、分布式事务、服务安全、链路追踪、集群管理、事件驱动、任务调度、云连接器、函数计算 组成；**

+ 配置中心：常见的有**springcloud config**、阿里Nacos、携程Apollo、谷歌consul等；

+ #### 注册中心：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203612.png" alt="image-20210711182317685" style="zoom:50%;" />
  + 具有服务自动注册、健康检查、自动发现；【常见的注册中心有：zookeeper、**Eureka**、Nacos、Consul】

+ #### 服务网关：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203613.png" alt="image-20210711182645296" style="zoom:50%;" />
  + 服务网关具有：高并发、安全、**路由转发**、**监控与限流**、灰度发布、服务重试、服务别名。【常见的服务网关有：kong、**zuul**、springcloud gateway】

+ #### 负载均衡：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203614.png" alt="image-20210711183034849" style="zoom:50%;" />
  +  **常见的负载均衡算法**：简单轮询、加权轮询、简单随机、加权随机、一致性哈希、最小活跃数。
    + 一致性哈希：根据请求的客户端ip或请求参数通过哈希得到一个数值，利用取模映射出对应的服务器，这样保证同一个请求每次能使用同一台服务器。
    + 最小活跃数：统计每台服务器上当前正在处理的请求，将请求分发给活跃数最少的服务器。
    + 常见的负载均衡组件：**nginx**、lvs、**ribbon**；

+ #### RPC调用：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203615.png" alt="image-20210711183756481" style="zoom:50%;" />

  + ##### 与HTTP调用的区别：

    <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203616.png" alt="image-20210711183847726" style="zoom:50%;" />

    <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203617.png" alt="image-20210711184014815" style="zoom:50%;" />

  + 常见的RPC调用组件：dubbo、gRPC、thrift、**feign**。

+ #### 服务熔断：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203618.png" alt="image-20210711184148009" style="zoom:50%;" />
  + 熔断器：实现熔断功能的叫熔断器，代表组件为**Hystrix**、Sentinel。其熔断器有三种状态：closed、open和Half-open。
    + closed：当调用失败次数达到阈值时则启动熔断器；
    + open：此时不会真正的调用下游服务，而是直接返回，当过了某段时间后，熔断器会键入到半打开状态；
    + half-open：此时会有部分请求访问下游服务，如果这些请求都调用成功了，则认为下游服务恢复，则关闭熔断器，否则回到打开状态。

+ #### 服务降级：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203619.png" alt="image-20210711184831026" style="zoom:50%;" />

  + ##### 服务降级与服务熔断的区别：

    + 都是防止系统崩溃；
    + 都让用户体验到某些功能暂时不可用；
    + **熔断是下游服务故障触发的，降级是为了降级系统负载；**

  + #### 服务雪崩：

    + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203620.png" alt="image-20210711185257441" style="zoom:50%;" />

  + #### 服务限流：

    + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203621.png" alt="image-20210711185408226" style="zoom:50%;" />
    + 常用的限流算法：固定窗口计数器、滑动窗口计数器、令牌捅、漏铜。

+ #### 全局锁：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203622.png" alt="image-20210711185829254" style="zoom:50%;" />

  + ##### 全局锁的实现：

    + zookeeper：利用zookeeper的watch机制与临时节点特性；
    + Redis：利用Redis的消费订阅机制与数据超时特性。 

  + ##### 全局锁实现组件：

    + **Redisson**、curator

+ #### 控制总线：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203623.png" alt="image-20210711190605639" style="zoom:50%;" />
  + 控制总线的应用场景：springcloud Bus就是具体实现，某个微服务可以通过springcloud Bus，来广播事件，而其他微服务可以接收到事件并进行相关处理。

+ #### 分布式事务：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203624.png" alt="image-20210711191010549" style="zoom:50%;" />
  +  实现分布式事务的方式：直接通过数据库、通过消息队列、两阶段提交、三阶段提交；
  + 分布式事务的三个角色：事务协调器、事务管理者、资源管理器；
  + 常用的分布式事务框架：seata、icn、bytetcc；

+ #### 服务安全：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203625.png" alt="image-20210711191313152" style="zoom:50%;" />
  + 服务安全的特性：
    + 可扩展、可配置的认证和授权
    + 单点登录；
    + 防止会话固定、点击劫持、跨网站请求伪造等攻击；
    + 与servlet API集成；

+ #### 链路追踪：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203626.png" alt="image-20210711191549508" style="zoom:50%;" />

  + ##### 链路追踪的功能：

    + 分布式调用链查询和诊断；
    + 应用性能实时汇总；
    + 分布式拓扑动态发现；
    + 多语言开发程序接入；
    + 丰富的下游对接场景；

  + ##### 常用的链路追踪技术：Sleuth、zipkin

+ #### 集群管理：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203627.png" alt="image-20210711191855044" style="zoom:50%;" />

  + ##### 集群管理的功能：

    + 领导者选举；一致性存储、集群状态管理、一次性token。

+ #### 事件驱动：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203628.png" alt="image-20210711192108879" style="zoom:50%;" />

  + ##### 驱动中的概念：

    + 目标绑定器，目标指的是kafka或者**rabbitmq**
    + 绑定桥梁，连接消息系统和应用程序
    + 消息，应用程序和消息系统之间传递的数据；

  + 事件驱动的特点：

    + 异步处理、流量削锋、服务解耦

+ #### 云连接器：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203629.png" alt="image-20210711192546401" style="zoom:50%;" />
  + 目前支持的云平台：spring cloud cloud Foundry、spring cloud Heroku；

+ #### 函数计算：

  + <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203630.png" alt="image-20210711192720047" style="zoom:50%;" />
  + ##### 函数计算的特点：
    
    + 支持响应式等编程风格；
    + 输入输出类型透明转化；
    + 流数据处理；
    + 同一个jvm中运行多版本函数；
    + 打包函数指定云平台；





+ ### Spring Cloud Config

  + 配置中心，将系统中用到的一些配置信息存储到配置中心，方便维护，不用每次修改配置都重启服务。用的比较多的配置中心还有etcd、携程的 Apollo、Disconf 。

+ ### *Spring Cloud Netflix*：

  + Netflix OSS 是一组开源的框架和组件库，是Netflix公司开发出来解决分布式系统的一些有趣的可扩展类库。Spring Cloud 把他们都放到 Spring Cloud Netflix 下，这是一个框架集合，它包括 Eureka 、Ribbon、Zuul、Hystrix 等。
    + ***Eureka***：<u>服务中心</u>，这可以说是微服务架构的核心功能了，微服务部署之后，一定要有服务注册和发现的能力，Eureka 就是担任这个角色的。如果你用过 dubbo 的话，那一定知道 dubbo 中服务注册和发现的功能是用 zookeeper 来实现的。目前官方已停止升级，如果你的项目中还没有使用并且打算使用注册中心的话，可以直接使用 Spring Cloud Consul。
    + ***Ribbon***：提供客户端<u>负责均衡功能</u>，例如一个服务提供者部署了 3 个实例，那么使用 Ribbon 可以指定负载均衡算法请求其中一个实例，Ribbon 如果配合 Eureka ，使用起来非常简单。
    + ***Hystrix***：<u>熔断器</u>，假设有 3 个服务提供实例，其中有一个实例由于某中原因挂掉了，那么当再有请求进来的时候，如果还是向这个实例上发请求，那将会导致请求积压阻塞，这个时候，熔断器就要发挥它的作用，将这个有问题的实例下线，这样一来，再有新的请求进来，就不会再发到这个有问题的实例上了。
    + ***Zuul***：<u>服务网关</u>。主要实现了路由转发和过滤器功能，对于处理一些数据聚合、鉴权、监控、统计类的功能非常好用。
    + ***Gateway***：也是<u>服务网关</u>，可以认为它是 Zuul 的下一代，无论从易用性和性能方便都有所提高，如果你的系统中还没有使用 Zuul ，并且准备上网关，可以直接选择 Gateway 。

+ ### *Spring Cloud Consul*

  + Consul 让服务注册和服务发现（通过 DNS 和 HTTP 接口）更加简单，甚至对于外部服务（例如SaaS）注册也一样。Spring Cloud Consul 可替代已有的 Spring Cloud Eureka。Eureka 2.x 版本也已经停止开发，并且 Spring Cloud 官方也建议用 Spring Cloud Consul 来替代，当然如果已经用了 Eureka 在项目中也没有关系，Eureka 已经足够稳定，正常使用没有任何问题。

    Spring Cloud Consul 可替代已有的 Spring Cloud Config ，当做配置中心使用。

+ ### *Spring Cloud Stream*

  + Spring Cloud Stream 是消息中间件组件，它集成了 kafka 和 rabbitmq 。如果你的系统中打算集成 kafka 或 rabbitmq，可以考虑使用 Stream 。

+ ### *Spring Cloud Bus*

  + 消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。集成了 Rabbitmq 和 kafka 。刚刚上面说到的 Stream 好像也是这个功能。没错，我们可以认为 Bus 是 Stream 的进一步封装，使用更简单。而 Stream 的灵活性更高。

+ ### *Spring Cloud Feign*

  + **Feign是一种声明式、模板化的HTTP客户端**。它可以用注解的方式简化 HTTP 请求，可以快速简单的请求服务提供接口。如果你还在使用 restTemplate 或者其他方式，不妨考虑一下 Feign。

+ ### *Spring Cloud Sleuth*

  + 服务日志收集和链路追踪模块，封装了 Dapper 和 log-based 追踪以及 **Zipkin** 和 HTrace 操作。与之功能相同的框架还有 skywalking、Pinpoint，另外国内还有美团开源的 CAT，只不过 CAT 属于代码侵入的，需要开发人员在系统中做代码埋点，不过也更加灵活，更加精细。

+ ### *Spring Cloud Security*

  + 可用做**授权服务、单点登录**等。如果服务需要做权限控制，那除非你自己实现。不然用到最多的就是 shiro 和 Spring Security 。Spring Boot 中用的比较多的就是 Security，众多授权机制中属于 **OAuth2** 最为流行。**Spring Cloud Security 就是将 Security、OAuth2 做了集成**，方便使用。	





---

## 注册中心Eureka：

+ Eureka 是 Netflix 开源的服务注册发现组件，服务发现可以说是微服务架构的核心功能了，微服务部署之后，一定要有服务**注册和发现的能力**，Eureka 就是担任这个角色的。如果你用过 dubbo 的话，那一定知道 <u>dubbo 中服务注册和发现的功能是用 zookeeper 来实现的</u>。

+ https://www.cnblogs.com/fengzheng/p/10603672.html

  + bootstrap.yml 和 application.yml 的区别：
    - bootstrap.yml 在 application.yml 之前启动；
    - bootstrap.yml 配置 application 的 name、spring.cloud.config.server.git.uri、一些encryption/decryption（加密/解密）信息；
    - application.yml 的信息会覆盖 bootstrap.yml 中的内容，当遇到相同的配置的时候；

+ ##### 依赖

  ```java
  <dependency>
   <groupId>org.springframework.cloud</groupId>  
   <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
  </dependency>  //如果是服务提供者，则为client
  ```

  

+ ##### 简单流程：

  + 新建 bootstrap.yml，并配置 Spring cloud 参数；

  + 新建 application.yml ，并配置参数；

  + 新建 Application.java 启动文件；

  + 运行 Application.java ，访问 [http://localhost:3000](http://localhost:3000/) 即可看到 Eureka 提供的 ui 控制台。

    <img src="https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203631.png" alt="image-20210711213519179" style="zoom:50%;" />

  + 接下来创建一个服务提供者，并注册到上面创建的 Eureka 注册中心。

    + 配置 application.yml

    + 创建一个简单的 RESTful 接口 controller

    + 创建 spring boot 启动类

    + 启动项目，正常情况下就注册到了 Eureka 注册中心，打开 Eureka 控制台，会看到已经出现了这个服务

      ![image-20210711213818896](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203632.png)

  + 有了服务提供者，接下来创建一个消费者来消费一下：

    + 配置 application.yml

    + 开始消费提供者提供的服务接口，这里演示了两种消费方法，一种是用 RestTemplate ，另外一种是用 FeignClient，Feign 同样是 Netflix 开源，并被 Spring Cloud 封装到 spring-cloud-starter-openfeign 包中。

    + 创建一个服务接口类，这是 Feign 的使用方式，详细的用法可以查一下 Spring Cloud Feign 相关文档

    + 创建一个 Controller 用于调用服务

    + 最后，启动服务，访问地址：http://localhost:3002/commonRequest 和 http://localhost:3002/feignRequest便可以看到内容成功返回。

      ![image-20210711213950463](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203633.png)

+ #### 相关参考：

  [[你一直在用的 Spring Boot Starters 究竟是怎么回事](https://www.cnblogs.com/fengzheng/p/10947585.html)]

  [[Spring Boot 和 Docker 实现微服务部署](https://www.cnblogs.com/fengzheng/p/10329097.html)]

  [[Spring Cloud 系列之 Spring Cloud Stream](https://www.cnblogs.com/fengzheng/p/11576661.html)]

  [[Spring Cloud Config 实现配置中心，看这一篇就够了](https://www.cnblogs.com/fengzheng/p/11242128.html)]

  [[如果你也打算学习 Spring Cloud](https://www.cnblogs.com/fengzheng/p/10567632.html)]

  [[Spring Cloud 系列之 Eureka 实现服务注册与发现](https://www.cnblogs.com/fengzheng/p/10603672.html)]

  [[为 Eureka 服务注册中心实现安全控制](https://www.cnblogs.com/fengzheng/p/10635000.html)]

  ---

  [Eureka 注册中心](https://blog.csdn.net/mshxuyi/article/details/107241547)

  [[微服务Eureka使用详解](https://www.cnblogs.com/yxth/p/10845640.html)]

  [Spring Cloud服务注册-Eureka介绍和部署](http://www.heartthinkdo.com/?p=1933)

  ---

  [SpringCloud(1):说说什么是微服务](https://www.jianshu.com/p/183871ec8add)

  [SpringCloud(2)：注册中心Eureka的搭建](https://www.jianshu.com/p/79b1000e068f)

  [SpringCloud(3):服务的提供与注册](https://www.jianshu.com/p/eb93d91a0ec1)

  [SpringCloud(4)：服务消费方](https://www.jianshu.com/p/15005902dedb)

  [SpringCloud(5):快速搭建你的监控中心](https://www.jianshu.com/p/dc97ccc6146d)





---

## 负载均衡器：Ribbon-LoadBalancer

[几种负载均衡器的简单分析](https://blog.csdn.net/lij231/article/details/82925245)

+ 负载均衡分服务端和客户端，常见的nginx就是服务端的负载均衡，即nginx将客户请求发送给上游不同的服务器去处理；
+ 负载均衡都会维护一个可用的服务端清单，然后通过心跳机制来删除故障的服务端节点以保证清单中都是可以正常访问的服务端节点；
+ 负载均衡服务器按照某种配置好的规则从可用服务端清单中选出一台服务器去处理客户端的请求。这就是服务端负载均衡。

+ “Ribbo是一个基于HTTP和TCP的客户端负载均衡器，当我们将Ribbon和Eureka一起使用时，Ribbon会从Eureka注册中心去获取服务端列表，然后进行轮询访问以到达负载均衡的作用，客户端负载均衡中也需要心跳机制去维护服务端清单的有效性，当然这个过程需要配合服务注册中心一起完成。”

+ 从上面的描述我们可以看出，客户端负载均衡和服务端负载均衡最大的区别在于服务清单所存储的位置。在客户端负载均衡中，所有的客户端节点都有一份自己要访问的服务端清单，这些清单统统都是从Eureka服务注册中心获取的。在Spring Cloud中我们如果想要使用客户端负载均衡，方法很简单，开启`@LoadBalanced`注解即可，这样客户端在发起请求的时候会先自行选择一个服务端，向该服务端发起请求，从而实现负载均衡。

+ 服务的发现和消费实际上是两个行为，这两个行为要由不同的对象来完成：服务的发现由Eureka客户端来完成，而服务的消费由Ribbon来完成。Ribbo是一个基于HTTP和TCP的客户端负载均衡器，当我们将Ribbon和Eureka一起使用时，Ribbon会从Eureka注册中心去获取服务端列表，然后进行轮询访问以到达负载均衡的作用，服务端是否在线这些问题则交由Eureka去维护。

+ @LoadBalanced注解与@Bean注解与RestTemplate的使用：

  + **提供RestTemplate的Bean** 

    RestTemplate可以帮助我们发起一个GET或者POST请求，这个我们在后文会详细解释，这里我们只需要提供一个RestTemplate  Bean就可以了，在提供Bean的同时，添加`@LoadBalanced`注解，表示开启客户端负载均衡。

  + 在项目```charger.common.security.component```中，ChargerResourceServerAutoConfiguration由以上三个组成的一个入口类;

  + 

+ #### Ribbon【请求处理的超时时间配置？】 、maven：com.netflix.ribbon：ribbon-loadbalancer：2.3.0-com.netflix-loadbalancer-reactive

+ ###### ILoadBalancer接口-chooseServer的核心方法；

+ ###### getServerList方法用来获取某一个分组中所有的的服务实例；

+ ###### getLoadBalancerStats方法用来获取LoadBalancerStats对象，LoadBalancerStats对象中保存了每一个服务的所有细节信息；

+ ### 抽象实现类：

  + ###### AbstractLoadBalancer枚举类：

    + 服务实例的分组枚举类，包含了三种类型的服务：`ALL`表示所有服务，`STATUS_UP`表示正常运行的服务，`STATUS_NOT_UP`表示下线的服务。

    ###### BaseLoadBalancer

    + BaseLoadBalancer是AbstractLoadBalancer的一个实现类；

    + **1.** 首先这个类中有两个List集合中放的Server对象，一个List集合用来保存所有的服务实例，还有一个List集合用来保存当前有效的服务实例。
    + **2.** BaseLoadBalancer中定义了一个IPingStrategy，用来描述服务检查策略，IPingStrategy默认实现采用了SerialPingStrategy实现，SerialPingStrategy中的pingServers方法就是遍历所有的服务实例，一个一个发送请求，查看这些服务实例是否还有效，如果网络环境不好的话，这种检查策略效率会很低，如果我们想自定义检查策略的话，可以重写SerialPingStrategy的pingServers方法。
    + 3.** 在BaseLoadBalancer的chooseServer方法中(负载均衡的核心方法)，我们发现最终调用了IRule中的choose方法来找到一个具体的服务实例，IRule是一个接口，在BaseLoadBalancer它的默认实现是RoundRobinRule类，RoundRobinRule类中采用了最常用的线性负载均衡规则，也就是所有有效的服务端轮流调用。
    + 4.** 在BaseLoadBalancer的构造方法中会启动一个PingTask，这个PingTask用来检查Server是否有效，PingTask的默认执行时间间隔为10秒。
    + 5.** markServerDown方法用来标记一个服务是否有效，标记方式为调用Server对象的setAlive方法设置isAliveFlag属性为false。
    + 6.** getReachableServers方法用来获取所有有效的服务实例列表。
    + **7.** getAllServers方法用来获取所有服务的实例列表。
    + **8.** addServers方法表示向负载均衡器中添加一个新的服务实例列表。

  + ###### DynamicServerListLoadBalancer

    + 对基础的负载均衡器BaseLoadBalancer做了扩展，使其拥有服务实例清单在运行期的动态更新的能力。同时也具备了对服务实例清单的过滤功能。
    + DynamicServerListLoadBalancer是BaseLoadBalancer的一个子类，在DynamicServerListLoadBalancer中对基础负载均衡器的功能做了进一步的扩展；
    + **1.** 首先DynamicServerListLoadBalancer类一开始就声明了一个变量serverListImpl，serverListImpl变量的类型是一个`ServerList`，这里的泛型得是Server的子类，ServerList是一个接口，里边定义了两个方法：一个getInitialListOfServers用来获取初始化的服务实例清单；另一个getUpdatedListOfServers用于获取更新的服务实例清单。
    + **2.** ServerList接口有很多实现类，DynamicServerListLoadBalancer默认使用了DomainExtractingServerList类作为ServerList的实现，但是在DomainExtractingServerList的构造方法中又传入了DiscoveryEnabledNIWSServerList对象，查看源码发现最终两个清单的获取方式是由DiscoveryEnabledNIWSServerList类来提供的。
    + **3.** DomainExtractingServerList类中的obtainServersViaDiscovery方法是用来发现服务实例并获取的，obtainServersViaDiscovery方法的主要逻辑是这样：首先依靠EurekaClient从服务注册中心获取到具体的服务实例InstanceInfo列表，然后对这个列表进行遍历，将状态为UP的实例转换成DiscoveryEnabledServer对象并放到一个集合中，最后将这个集合返回。
    + **4.** DynamicServerListLoadBalancer中还定义了一个ServerListUpdater.UpdateAction类型的服务更新器，Spring Cloud提供了两种服务更新策略：一种是PollingServerListUpdater，表示定时更新；另一种是EurekaNotificationServerListUpdater表示由Eureka的事件监听来驱动服务列表的更新操作，默认的实现策略是第一种，即定时更新，定时的方式很简单，创建Runnable，调用DynamicServerListLoadBalancer中updateAction对象的doUpdate方法，Runnable延迟启动时间为1秒，重复周期为30秒。
    + **5.** 在更新服务清单的时候，调用了我们在第一点提到的getUpdatedListOfServers方法，拿到实例清单之后，又调用了一个过滤器中的方法进行过滤。过滤器的类型有好几种，默认是DefaultNIWSServerListFilter，这是一个继承自ZoneAffinityServerListFilter的过滤器，具有区域感知功能。即它会对服务提供者所处的Zone和服务消费者所处的Zone进行比较，过滤掉哪些不是同一个区域的实例。
    + 综上，DynamicServerListLoadBalancer主要是实现了服务实例清单在运行期间的动态更新能力，同时提供了对服务实例清单的过滤功能。

  + ###### ZoneAwareLoadBalancer

    + ZoneAwareLoadBalancer是DynamicServerListLoadBalancer的子类，ZoneAwareLoadBalancer的出现主要是为了弥补DynamicServerListLoadBalancer的不足。由于DynamicServerListLoadBalancer中并没有重写chooseServer方法，所以DynamicServerListLoadBalancer中负责均衡的策略依然是我们在BaseLoadBalancer中分析出来的线性轮询策略，这种策略不具备区域感知功能，这样当需要跨区域调用时，可能会产生高延迟。

    + ZoneAwareLoadBalancer重写了setServerListForZones方法，该方法在其父类中的功能主要是根据区域Zone分组的实例列表，为负载均衡器中的LoadBalancerStats对象创建ZoneStats并存入集合中，ZoneStats是一个用来存储每个Zone的状态和统计信息。重写之后的setServerListForZones方法主要做了两件事：

      + 一件是调用getLoadBalancer方法来创建负载均衡器，同时创建服务选择策略；
      + 另一件是对Zone区域中的实例清单进行检查，如果对应的Zone下已经没有实例了，则将Zone区域的实例列表清空，防止节点选择时出现异常。

    + ZoneAwareLoadBalancer负载均衡器是对DynamicServerListLoadBalancer类的扩展和补充，该负载混合器实现了Zone(区域)的概念，避免了因为跨区域而导致的区域性故障，从而实现了服务的高可用。

    + ###### ZoneAwareLoadBalancer主要做了以下几件事：

      + 为所有Zone区域分别创建一个快照，存储在zoneSnapshot 里面
      + 通过Zone快照中的信息，按照某种策略例如Zone的服务实例数量，故障率等等来筛选掉不符合条件的Zone区域。
      + 如果发现没有符合剔除要求的区域，同时实例最大平均负载小于阈值（默认百分之20），就直接返回所有可以的Zone区域，否则，随机剔除一个最坏的Zone。
      + 获得的可用的Zone列表不为空，并且数量小于之前快照中的总数量，则根据IRule规则随机选一个Zone区域

      - 确定了最终的Zone之后，最终调用 BaseLoadBalancer的chooseServer来选择一个合适的服务实例。

## 负载均衡策略

+ #### Ribbon具体提供了哪些规则供我们使用呢？通过查看Ribbon的IRule接口的实现集成关系图，我们最终可以发现，Ribbon主要提供了以下几个规则实现的。
  
+ RandomRule 类：该策略实现了从服务实例清单中随机选择一个服务实例的功能
  
+ RoundRobinRule类：该策略实现了轮询的方式从服务实例清单中依次选择服务实例的功能RetryRule
  
+ RetryRule类：该策略实现了具备重试机制的实例选择功能
  
+ WeightedResponseTimeRule类：根据权重来选择实例
  
+ BestAvailableRule类：选择一个最空闲的实例
  
+ PredicateBasedRule 类：先过滤，然后再以轮询的方式选择实例
  
    。。。（共11个）

![image-20210714141510701](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203634.png)

+ #### IRule接口：

```java
public interface IRule{
​
    public Server choose(Object key);
    
    public void setLoadBalancer(ILoadBalancer lb);
    
    public ILoadBalancer getLoadBalancer();    
}
```





---

## Springcloud eureka Resttemplate

+ 当我们从服务消费端去调用服务提供者的服务的时候，使用了一个很好用的对象，叫做RestTemplate，当时我们只使用了RestTemplate中最简单的一个功能getForEntity发起了一个get请求去调用服务端的数据，同时，我们还通过配置@LoadBalanced注解开启客户端负载均衡；

+ #### RestTemplate的四个请求：

  + ##### **GET请求**

    + ###### restTemplate.getForEntity

      + getForEntity：该方法的返回值是一个`ResponseEntity<T>`，`ResponseEntity<T>`是Spring对HTTP请求响应的封装，包括了几个重要的元素，如响应码、contentType、contentLength、响应消息体等。
      + getForEntity的第一个参数为我要调用的服务的地址,是通过服务名调用而不是服务地址;
      + getForEntity第二个参数String.class表示我希望返回的类型;

    + ###### restTemplate.getForObject

      + getForObject函数实际上是对getForEntity函数的进一步封装，如果你只关注返回的消息体的内容，对其他信息都不关注，此时可以使用getForObject;

  + ##### **POST请求**

    + ###### restTemplate.postForEntity

      + 方法的第一参数表示要调用的服务的地址
      + 方法的第二个参数表示上传的参数
      + 方法的第三个参数表示返回的消息体的数据类型

      ###### restTemplate.postForObject

      + 如果你只关注，返回的消息体，可以直接使用postForObject。用法和getForObject一致。	

      ###### restTemplate.postForLocation:

      + postForLocation也是提交新资源，提交成功之后，返回新资源的URI，postForLocation的参数和前面两种的参数基本一致，只不过该方法的返回值为Uri，这个只需要服务提供者返回一个Uri即可，该Uri表示新资源的位置。

  + ##### **PUT请求**

    + 在RestTemplate中，PUT请求可以通过put方法调用，put方法的参数和前面介绍的postForEntity方法的参数基本一致，只是put方法没有返回值而已。

  + ##### **DELETE请求**

    + delete请求我们可以通过delete方法调用来实现；也是两个参数，一个是删除的地址，一个是删除值；

+ #### RestTemplate从发送请求到负载均衡

  + 当时我们说开启负载均衡很简单，只需要在RestTemplate的bean上再添加一个@LoadBalanced注解即可；这个注解使用来给RestTemplate做标记，使LoadBalancerClient来配置它.

  + 首先我们来看看@LoadBalanced注解的源码：

    ```java
    /**
     * Annotation to mark a RestTemplate bean to be configured to use a LoadBalancerClient
     * @author Spencer Gibb
     */
    @Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Inherited
    @Qualifier
    public @interface LoadBalanced {
    }
    ```

    这个注解是用来给RestTemplate做标记，以使用LoadBalancerClient来配置它。那我们来看看LoadBalancerClient是什么:

    ```java
    public interface ServiceInstanceChooser {
        ServiceInstance choose(String serviceId);
    }
    public interface LoadBalancerClient extends ServiceInstanceChooser {
    
        <T> T execute(String serviceId, LoadBalancerRequest<T> request) throws IOException;
    
        <T> T execute(String serviceId, ServiceInstance serviceInstance, LoadBalancerRequest<T> request) throws IOException;
    
        URI reconstructURI(ServiceInstance instance, URI original);
    }
    ```

    ##### LoadBalancerClient是一个接口，该接口中有3个方法:

    + 1.ServiceInstance choose(String serviceId)根据传入的服务名serviceId从客户端负载均衡器中挑选一个对应服务的实例;

    + 2.T execute() ,使用从负载均衡器中挑选出来的服务实例来执行请求。

    + 3.URI reconstructURI(ServiceInstance instance, URI original)表示为系统构建一个合适的URI，我们在[Spring Cloud中服务的发现与消费]中发送请求时使用了服务的逻辑名称(`http://HELLO-SERVICE/hello`)而不是具体的服务地址，在reconstructURI方法中，第一个参数ServiceInstance实例是一个带有host和port的具体服务实例，第二个参数URI则是使用逻辑服务名定义为host和port的URI，而返回的URI则是通过ServiceInstance的服务实例详情拼接出的具体的host:port形式的请求地址。一言以蔽之，就是把类似于`http://HELLO-SERVICE/hello`这种地址转为类似于`http://195.124.207.128/hello`地址（IP地址也可能是域名）。

      

      那么具体的配置是在哪里执行的呢?我们在LoadBalancerClient的包下面发现了一个类叫做**LoadBalancerAutoConfiguration**[自动化配置类],看名字有点像是客户端负载均衡服务器的自动化配置类,其核心功能有：

      + LoadBalancerAutoConfiguration类上有两个关键注解，分别是@ConditionalOnClass(RestTemplate.class)和@ConditionalOnBean(LoadBalancerClient.class),说明Ribbon如果想要实现负载均衡的自动化配置需要满足两个条件：

        + 第一个，RestTemplate类必须存在于当前工程的环境中；
        + 第二个，在Spring容器中必须有LoadBalancerClient的实现Bean。

      + ribbonInterceptor方法返回了一个拦截器叫做LoadBalancerInterceptor，这个拦截器的作用主要是在客户端发起请求时进行拦截，进而实现客户端负载均衡功能。

      + restTemplateCustomizer方法返回了一个RestTemplateCustomizer，这个方法主要用来给RestTemplate添加LoadBalancerInterceptor拦截器。

      + restTemplates是一个被@LoadBalanced注解修饰的RestTemplate对象列表，在loadBalancedRestTemplateInitializer方法中通过调用RestTemplateCustomizer中的customizef方法来给RestTemplate添加上LoadBalancerInterceptor拦截器。

        ###### 该自动配置类主要干的三件事：

        + 创建了LoadBalancerInterceptor的bean，用于对客户端发起请求时进行拦截，以实现客户端负载均衡。

        + 创建了RestTemplateCustomizer的bean，给restTemplate添加LoadBalancerInterceptor。

        + 维护了一个被@LoadBalanced修饰的RestTemplate列表，并初始化。

          ~~~java
          @LoadBalanced
          @Autowired(required = false)
          private List<RestTemplate> restTemplates = Collections.emptyList();
          ~~~

          

      

      这里的核心其实就是一个拦截器，就是这个拦截器让一个普通的RestTemplate逆袭成为了一个具有负载均衡功能的请求器。那我们接下来就来看看这个拦截器：

      ![image-20210714104707479](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203635.png)

      + 拦截器中注入了LoadBalancerClient的实现，**当一个被@LoadBalanced注解修饰的RestTemplate对象向外发起HTTP请求时，会被LoadBalancerInterceptor类的intercept方法拦截，在这个方法中直接通过getHost方法就可以获取到服务名**（因为我们在使用RestTemplate调用服务的时候，使用的是服务名而不是域名，所以这里可以通过getHost直接拿到服务名然后去调用execute方法发起请求）。

      + LoadBalancerClient还只是一个接口，我们要去看看这个接口的实现是什么样的：

        ![image-20210714105528826](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203636.png)

        在execute方法中，首先根据serviceId获取一个ILoadBalancer，然后调用getServer方法去获取一个服务实例，但是在getServer方法中，我们看到并没有调用LoadBalancerClient中的choose方法，而是调用了另一个叫做ILoadBalancer的中定义的chooseServer方法。那这个接口又是什么呢？

        ```java
        protected Server getServer(ILoadBalancer loadBalancer, Object hint) {
        		if (loadBalancer == null) {
        			return null;
        		}
        		// Use 'default' on a null hint, or just pass it on?
        		return loadBalancer.chooseServer(hint != null ? hint : "default");   //loadBalancer的chooseServer方法
        	}
        ```

        ~~~java
        public interface ILoadBalancer {
            public void addServers(List<Server> newServers);
            public Server chooseServer(Object key);
            public void markServerDown(Server server);
            public List<Server> getReachableServers();
            public List<Server> getAllServers();
        }
        ~~~

        + addServers表示向负载均衡器中维护的实例列表增加服务实例
        + chooseServer表示通过某种策略，从负载均衡服务器中挑选出一个具体的服务实例
        + markServerDown表示用来通知和标识负载均衡器中某个具体实例已经停止服务，否则负载均衡器在下一次获取服务实例清单前都会认为这个服务实例是正常工作的
        + getReachableServers表示获取当前正常工作的服务实例列表
        + getAllServers表示获取所有的服务实例列表，包括正常的服务和停止工作的服务

        这里的几个接口都涉及到一个Server对象，这里的Server对象就是一个传统的服务端节点，这个对象中存储了服务端节点的一些元数据信息，包括host，port以及其他一些部署信息。

        ![image-20210714111351379](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203637.png)

        在这些实现类中，BaseLoadBalancer类实现了基础的负载均衡，而DynamicServerListLoadBalancer和ZoneAwareLoadBalancer则在负载均衡的策略上做了一些功能的扩展。那么在和Ribbon整合的时候，Spring Cloud默认采用了哪个具体的实现呢?

        我们可以从RibbonClientConfiguration类中看到，系统默认采用了ZoneAwareLoadBalancer负载均衡器。

+ RestTemplate从一个简单的服务请求控件变成了具有客户端负载均衡功能的请求控件，简而言之，就是RestTemplate发起一个请求，这个请求被LoadBalancerInterceptor给拦截了，拦截后将请求的地址中的服务逻辑名转为具体的服务地址【从server里拿出对应的主机名，端口，然后在进行拼接整合，形成最终要访问的具体地址。】，然后继续执行请求。就是这么一个过程。[写得不错的RestTemplate](https://mp.weixin.qq.com/s/uvJDmN2f9y3EEI6A3ss_aQ)

+ 这个具体的地址是通过ServiceRequestWrapper继承HttpRequestWrapper 类，并且重写了getURI()方法，同时在 getURI() 方法中，具体采纳了RibbonLoadBalancerClient.reconstructURI方法来组织具体请求的URL实例地址。

+ 大致过程是：通过LoadBalancerInterceptor对RestTemplate的请求进行拦截，并利用Spring cloud的LoadBalancerClient将逻辑服务名转换为具体实例地址的过程。同时通过LoadBalancerClient的实现RibbonLoadBalancerClient，就可以知道再使用Ribbon实现的负载均衡时，实际使用的还是Ribbon中定义的ILoadBalancer接口的实现，且自动化配置类会使用ZoneAwareLoadBalancer作为客户端负载均衡的实现。
  
+ ###### 要想通过spring cloud ribbon实现负载均衡，非常简单，只需要两步：

  1. 服务提供者启动多个实例注册到注册中心
  2. 服务消费者直接调用被@LoadBalanced注解修饰过的RestTemplate来实现服务的调用。





---

## Eureka 自我保护 安全认证

## actuator

​	![image-20210714104528593](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203638.png)

#### 优雅停服：

+ ##### 依赖：

  ~~~xml
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-actuator</artifactId>
          </dependency>
  ~~~

+ ##### 配置文件：

  ~~~yml
  management:
    endpoints:
      web:
        exposure:
          include: shutdown    #开启shutdown端点访问
    endpoint:
        shutdown:
          enabled: true     #开启优雅停服：http://localhost:port/actuator/shutdown
  ~~~

  





##### 实现自动刷新 

Spring Cloud Config 在项目启动时加载配置内容这一机制，导致了它存在一个缺陷，修改配置文件内容后，不会自动刷新。例如我们上面的项目，当服务已经启动的时候，去修改 github 上的配置文件内容，这时候，再次刷新页面，对不起，还是旧的配置内容，新内容不会主动刷新过来。 但是，总不能每次修改了配置后重启服务吧。如果是那样的话，还是不要用它了为好，直接用本地配置文件岂不是更快。

它提供了一个刷新机制，但是需要我们主动触发。那就是 @RefreshScope 注解并结合 actuator ，注意要引入 spring-boot-starter-actuator 包。





+ #### 监控管理：

  + ##### 依赖：

    ```java
    <!-- 监控管理 -->
    <dependency>
     <groupId>org.springframework.boot</groupId>  
     <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    ```

    

## okhttp URL

## 代理式负载均衡

## 线程池-多线程

## Feign【拦截器传递header 中的 oauth2 token】  openfeign

## 信号量[模式]



## [session、token、jwt、oauth2](https://www.yuque.com/pig4cloud/pig/egcx5x)

---

##  Spring Cloud Security OAuth2

+ 传统的 Web 开发登录认证一般都是基于 session 的，但是在前后端分离的架构中继续使用 session 就会有许多不便，因为移动端（Android、iOS、微信小程序等）要么不支持 cookie（微信小程序），要么使用非常不便，对于这些问题，使用 OAuth2 认证都能解决。在互联网应用中最常见的 OAuth2 应该就是各种第三方登录了，例如 QQ 授权登录、微信授权登录、微博授权登录、GitHub 授权登录等等。

+ “在不知道密码的情况下也能在户主的授权下进出小区”————快递员问题-授权机制
+ **简单说，OAuth 就是一种授权机制。数据的所有者告诉系统，同意授权第三方应用进入系统，获取这些数据。系统从而产生一个短期的进入令牌（token），用来代替密码，供第三方应用使用。**
+ 令牌（token）与密码（password）的作用是一样的，都可以进入系统，但是有三点差异。
  + （1）令牌是短期的，到期会自动失效，用户自己无法修改。密码一般长期有效，用户不修改，就不会发生变化。
  + （2）令牌可以被数据所有者撤销，会立即失效。以上例而言，屋主可以随时取消快递员的令牌。密码一般不允许被他人撤销。
  + （3）令牌有权限范围（scope），比如只能进小区的二号门。对于网络服务来说，只读令牌就比读写令牌更安全。密码一般是完整权限。

+ OAuth 引入了一个授权层，用来分离两种不同的角色：客户端和资源所有者。......资源所有者同意以后，资源服务器可以向客户端颁发令牌。客户端通过令牌，去请求数据。[RPC6749]

+ ###### [四种授权方式（authorization grant ):](https://www.ruanyifeng.com/blog/2019/04/oauth-grant-types.html)                    [其他介绍](https://mp.weixin.qq.com/s/AELXf1nmpWbYE3NINpLDRg)

  + 授权码（authorization-code）--**指的是第三方应用先申请一个授权码，然后再用该码获取令牌。**	

    + 这种方式是最常用的流程，安全性也最高，它适用于那些有后端的 Web 应用。授权码通过前端传送，令牌则是储存在后端，而且所有与资源服务器的通信都在后端完成。这样的前后端分离，可以避免令牌泄漏。

    + 第一步，A 网站提供一个链接，用户点击后就会跳转到 B 网站，授权用户数据给 A 网站使用。下面就是 A 网站跳转 B 网站的一个示意链接。链接形式：

      ```javascript
      https://b.com/oauth/authorize?response_type=code&client_id=CLIENT_ID&redirect_uri=CALLBACK_URL&scope=read
      ```

      `response_type`参数表示要求返回授权码（`code`），`client_id`参数让 B 知道是谁在请求，`redirect_uri`参数是 B 接受或拒绝请求后的跳转网址，`scope`参数表示要求的授权范围（这里是只读）。

    + 第二步，用户跳转后，B 网站会要求用户登录，然后询问是否同意给予 A 网站授权。用户表示同意，这时 B 网站就会跳回`redirect_uri`参数指定的网址。跳转时，会传回一个授权码，就像下面这样。

      ```javascript
      https://a.com/callback?code=AUTHORIZATION_CODE   //code参数就是授权码。
      ```

    + 第三步，A 网站拿到授权码以后，就可以在后端，向 B 网站请求令牌。

      ```javascript
      https://b.com/oauth/token?
       client_id=CLIENT_ID&
       client_secret=CLIENT_SECRET&
       grant_type=authorization_code&
       code=AUTHORIZATION_CODE&
       redirect_uri=CALLBACK_URL
      ```

      上面 URL 中，`client_id`参数和`client_secret`参数用来让 B 确认 A 的身份（`client_secret`参数是保密的，因此只能在后端发请求），`grant_type`参数的值是`AUTHORIZATION_CODE`，表示采用的授权方式是授权码，`code`参数是上一步拿到的授权码，`redirect_uri`参数是令牌颁发后的回调网址。

    + 第四步，B 网站收到请求以后，就会颁发令牌。具体做法是向`redirect_uri`指定的网址，发送一段 JSON 数据。

      ```javascript
      {    
        "access_token":"ACCESS_TOKEN",
        "token_type":"bearer",
        "expires_in":2592000,
        "refresh_token":"REFRESH_TOKEN",
        "scope":"read",
        "uid":100101,
        "info":{...}
      }
      ```

      上面 JSON 数据中，`access_token`字段就是令牌，A 网站在后端拿到了。

    + ![image-20210714165803008](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203639.png)

  + 隐藏式（implicit）--**RFC 6749 就规定了第二种方式，允许直接向前端颁发令牌。这种方式没有授权码这个中间步骤，所以称为（授权码）"隐藏式"（implicit）。**

  + 密码式（password）--**如果你高度信任某个应用，RFC 6749 也允许用户把用户名和密码，直接告诉该应用。该应用就使用你的密码，申请令牌，这种方式称为"密码式"（password）。**

  + 客户端凭证（client credentials）--**最后一种方式是凭证式（client credentials），适用于没有前端的命令行应用，即在命令行下请求令牌。**

注意，不管哪一种授权方式，第三方应用申请令牌之前，都必须先到系统备案，说明自己的身份，然后会拿到两个身份识别码：客户端 ID（client ID）和客户端密钥（client secret）。这是为了防止令牌被滥用，没有备案过的第三方应用，是不会拿到令牌的。

###### [这个案例写出来，还怕跟面试官扯不明白 OAuth2 登录流程？](https://www.cnblogs.com/lenve/p/12695733.html)





## springcloud sleuth-分布式服务链路跟踪

+ 通常一个由客户端发起的请求在后端系统中会经过多个不同的微服务调用来协同产生最后的请求结果，在复杂的微服务架构系统中，几乎每一个前端请求都会形成一条复杂的分布式服务调用链路。在每条链路中任何一个依赖服务出现延迟过高或错误的时候都有可能引起请求最后的失败。这时候对于每个请求全链路调用的跟踪就变得越来越重要，通过实现对请求调用的跟踪可以帮助我们快速的发现错误根源以及监控分析每条请求链路上的性能瓶颈等好处。

+ #### 依赖注入

  ```java
  <dependency>
  	<groupId>org.springframework.cloud</groupId>
  	<artifactId>spring-cloud-starter-sleuth</artifactId>
  </dependency>
  ```

+ #### 四个返回值

  + spring.application.name配置属性
  + **Trach ID**：用来标识一条请求链路。一条请求链路中包含一个Trace ID，多个Span ID。
  + **Span ID**：表示一个基本的工作单元，比如：发送一个HTTP请求。为了统计各处理单元的时间延迟，当请求达到各个服务组件时，或是处理逻辑到达某个状态时，通过spanid标识来标记它的开始、具体过程以及结束。【必须有开始和结束两个节点，另外还有事件名称、请求信息等】
  + `false`：表示是否要将该信息输出到Zipkin等服务中来收集和展示。

  上面四个值中的`Trace ID`和`Span ID`是Spring Cloud Sleuth实现分布式服务跟踪的核心。在一次服务请求链路的调用过程中，**会保持并传递同一个`Trace ID`**，从而**将整个分布于不同微服务进程中的请求跟踪信息串联起来**，以上面输出内容为例，`trace-1`和`trace-2`同属于一个前端服务请求来源，所以他们的`Trace ID`是相同的，处于同一条请求链路中。

  + 请求通过**RestTemplate**实现：

    + 对该请求进行处理，在发送到`trace-2`之前sleuth会为在该请求的Header中增加实现跟踪需要的重要信息，主要有：
      + **X-B3-TraceId**：一条请求链路（Trace）的唯一标识，必须值
      + **X-B3-SpanId**：一个工作单元（Span）的唯一标识，必须值
      + **X-B3-ParentSpanId**:标识当前工作单元所属的上一个工作单元，Root Span（请求链路的第一个工作单元）的该值为空
      + **X-B3-Sampled：**是否被抽样输出的标志，1表示需要被输出，0表示不需要被输出
      + **X-Span-Name：**工作单元的名称

  + #### 日志信息中添加跟踪信息功能：【ELK平台】

    + 由于日志文件都离散的存储在各个服务实例的文件系统之上，仅仅通过查看日志文件来分析我们的请求链路依然是一件相当麻烦的差事，所以我们还需要一些工具来帮助我们集中的收集、存储和搜索这些跟踪信息。引入基于日志的分析系统是一个不错的选择，比如：**ELK平台**【包含：**ElasticSearch**、**Logstash**和**Kiabana**】

      + Elasticsearch是个开源分布式搜索引擎，它的特点有：分布式，零配置，自动发现，索引自动分片，索引副本机制，restful风格接口，多数据源，自动搜索负载等。
      + Logstash是一个完全开源的工具，他可以对你的日志进行收集、过滤，并将其存储供以后使用。
      + Kibana 也是一个开源和免费的工具，它Kibana可以为 Logstash 和 ElasticSearch 提供的日志分析友好的 Web 界面，可以帮助您汇总、分析和搜索重要数据日志。

    + #### 日志收集&数据对接：

      + logstash的输出是json，springboot的logback，只需要通过在logback的配置中添加对logstash的appender。

      但是，在ELK平台中的数据分析维度缺少对请求链路中各阶段时间延迟的关注，很多时候我们追溯请求链路的一个原因是**为了找出整个调用链路中出现延迟过高的瓶颈源，亦或是为了实现对分布式系统做延迟监控等与时间消耗相关的需求**，这时候类似ELK这样的日志分析系统就显得有些乏力了。对于这样的问题，我们就可以引入**Zipkin**来得以轻松解决。





+ ## Zipkin-分布式服务跟踪

  + 可以使用它来收集各个服务器上请求链路的跟踪数据，并通过它提供的**REST API接口**来辅助我们查询跟踪数据以实现对分布式系统的监控程序，从而**及时地发现系统中出现的延迟升高问题**并找出系统性能瓶颈的根源。除了**面向开发的API接口**之外，它也提供了方便的**UI组件**来帮助我们直观的搜索跟踪信息和分析请求链路明细，比如：可以查询某段时间内各用户请求的处理时间等。

  + #### 四个核心的基础组件架构：

    ![image-20210716151751129](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214233.png)

  + **Collector**：**收集器组件**，它主要用于处理从外部系统发送过来的跟踪信息，将这些信息转换为Zipkin内部处理的Span格式，以支持后续的存储、分析、展示等功能。

  + **Storage**：**存储组件**，它主要对处理收集器接收到的跟踪信息，默认会将这些信息存储在内存中，我们也可以修改此存储策略，通过使用其他存储组件将跟踪信息存储到数据库中。

  + **RESTful API**：**API组件**，它主要用来提供外部访问接口。比如给客户端展示跟踪信息，或是外接系统访问以实现监控等。

  + **Web UI**：**UI组件**，基于API组件实现的上层应用。通过UI组件用户可以方便而有直观地查询和分析跟踪信息。

  

  + #### Http收集：

    + **第一步：搭建Zipkin Server**
    + **第二步：为应用引入和配置Zipkin服务**

  + #### 消息中间件收集：

    + **第一步：修改客户端`trace-1`和`trace-2`**==>主要修改收集的方式为中间件收集
    + **第二步：修改`zipkin-server`服务端**==>核心依赖：spring-cloud-sleuth-zipkin-stream
    
  + #### Sleuth中的抽样收集策略：

    + 在Sleuth中的抽样收集策略是通过`Sampler`接口实现的，它的定义如下：

      ```java
      public interface Sampler {
          /**
           * @return true if the span is not null and should be exported to the tracing system
          */
          boolean isSampled(Span span);
      }
      ```

      默认情况下，Sleuth会使用`PercentageBasedSampler`实现的抽样策略，以请求百分比的方式配置和收集跟踪信息，我们可以通过在`application.properties`中配置下面的参数对其百分比值进行设置，它的默认值为`0.1`，代表收集10%的请求跟踪信息。

    + 在开发调试期间，通常会收集全部跟踪信息输出到远程仓库，我们可以将其值设置为`1`，或者也可以通过创建`AlwaysSampler`的Bean（它实现的`isSampled`方法始终返回`true`）来覆盖默认的`PercentageBasedSampler`策略，比如：

      ```java
      @Bean
      public AlwaysSampler defaultSampler() {
          return new AlwaysSampler();
      }
      ```

    + 在实际使用时，通过与Span对象中存储信息的配合，我们可以根据实际情况做出更贴近需求的抽样策略，比如实现一个仅对包含指定Tag的抽样策略：

      ```java
      public class TagSampler implements Sampler {
      
          private String tag;
      
          public TagSampler(String tag) {
              this.tag = tag;
          }
      
          @Override
          public boolean isSampled(Span span) {
              return span.tags().get(tag) != null;
          }
      }
      ```

    + #### 收集原理

      + ##### 收集机制：

        + 首先，我们来看看Sleuth在请求调用时是怎么样来记录和生成跟踪信息的。下图展示了我们在本章节中实现示例的运行全过程：客户端发送了一个HTTP请求到`trace-1`，`trace-1`依赖于`trace-2`的服务，所以`trace-1`再发送一个HTTP请求到`trace-2`，待`trace-2`返回响应之后，`trace-1`再组织响应结果返回给客户端。

          ![img](https://blog.didispace.com/assets/sleuth-analysis-1.png)

  











---

## RPC协议

## redis令牌桶：

## 热更新  记仇





---

## zuul核心过滤器--服务网关

+ netflix开源的Gateway服务器，本质上是一个web servlet应用；

+ 在云平台上提供动态路由，监控，弹性，安全等边缘服务的框架。相当于是设备和Netflix流应用的web网站后端所有请求的前门；

+ zuul最主要的功能是==路由转发==和==过滤器==的实现；

+ #### 解决了什么问题：

  ![image-20210715084940804](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214240.png)

+ 首先，破坏了服务无状态特点。为了保证对外服务的安全性，我们需要实现对服务访问的权限控制，而开放服务的权限控制机制将会贯穿并污染整个开放服务的业务逻辑，这会带来的最直接问题是，破坏了服务集群中REST API无状态的特点。从具体开发和测试的角度来说，在工作中除了要考虑实际的业务逻辑之外，**还需要额外可续对接口访问的控制处理。**

+ 其次，无法直接复用既有接口。当我们需要对一个即有的集群内访问接口，实现外部服务访问时，我们不得不通过**在原有接口上增加校验逻辑**，或**增加一个代理调用来实现权限控制**，无法直接复用原有的接口。

+ 为了解决上面这些问题，我们需要将权限控制这样的东西从我们的服务单元中抽离出去，而最适合这些逻辑的地方就是处于对外访问最前端的地方，我们需要一个更强大一些的**均衡负载器**：

  + 服务网关是微服务架构中一个不可或缺的部分。通过服务网关统一向外系统提供REST API的过程中，除了具备服务路由、均衡负载功能之外，它还具备了权限控制等功能。
  + 为微服务架构提供了前门保护的作用，同时将权限控制这些较重的非业务逻辑内容迁移到服务路由层面，使得服务集群主体能够具备更高的可复用性和可测试性。

+ #### zuul的使用：

  + ##### 注入依赖

    ```java
        org.springframework.cloud    spring-cloud-starter-zuul
    ```

  + 应用主类使用`@EnableZuulProxy`注解开启Zuul

  + `pplication.properties`中配置Zuul应用的基础信息，如：应用名、服务端口等。

  + ##### zuul的服务路由：

    + 通过服务路由的功能，我们在对外提供服务的时候，只需要通过暴露Zuul中配置的调用地址就可以让调用方统一的来访问我们的服务，而不需要了解具体提供服务的主机信息了。

    + 通配符：

      ![image-20210715085402653](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214243.png)

  + ##### zuul的两种映射方式：

    + Url的映射方式：

      ```java
      # routes to url
      zuul.routes.api-a-url.path=/api-a-url/**
      zuul.routes.api-a-url.url=http://localhost:2222/
      ```

      `/api-a-url/**`的访问都映射到`http://localhost:2222/`上，也就是说当我们访问`http://localhost:5555/api-a-url/add?a=1&b=2`的时候，Zuul会将该请求路由到：`http://localhost:2222/add?a=1&b=2`上。

      - 通过url映射的方式对于Zuul来说，并不是特别友好，Zuul需要知道我们所有为服务的地址，才能完成所有的映射配置。而实际上，我们在实现微服务架构时，服务名与服务实例地址的关系在eureka server中已经存在了，所以只需要将Zuul注册到eureka server上去发现其他服务，我们就可以实现对serviceId的映射。例如，我们可以如下配置：

    + ##### serviceId映射方式：

      ```java
      zuul.routes.api-a.path=/api-a/**
      zuul.routes.api-a.serviceId=service-A
      zuul.routes.api-b.path=/api-b/**
      zuul.routes.api-b.serviceId=service-B
      eureka.client.serviceUrl.defaultZone=http://localhost:1111/eureka/
      ```

      针对我们在准备工作中实现的两个微服务service-A和service-B，定义了两个路由api-a和api-b来分别映射。另外为了让Zuul能发现service-A和service-B，也加入了eureka的配置。

      ##### 配置的映射关系：

      - `http://localhost:5555/api-a/add?a=1&b=2`：通过serviceId映射访问service-A中的add服务
      - `http://localhost:5555/api-b/add?a=1&b=2`：通过serviceId映射访问service-B中的add服务
      - `http://localhost:5555/api-a-url/add?a=1&b=2`：通过url映射访问service-A中的add服务

      *推荐使用serviceId的映射方式，除了对Zuul维护上更加友好之外，serviceId映射方式还支持了断路器，对于服务故障的情况下，可以有效的防止故障蔓延到服务网关上而影响整个系统的对外服务*。

  + #### 路由的排除方式：

    + ![image-20210715085525002](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214302.png)

  + #### zuul的服务过滤：

    + 在完成了服务路由之后，我们对外开放服务还需要一些安全措施来保护客户端只能访问它应该访问到的资源。所以我们需要利用Zuul的过滤器来实现我们对外服务的安全控制。

    + 在服务网关中定义过滤器只需要继承`ZuulFilter`抽象类实现其定义的四个抽象函数就可对请求进行拦截与过滤。

    + ###### 过滤实现需要：

      + ##### **继承ZuulFilter；**

      + ##### **重写实现4个方法：**
        
        + filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
          - `pre`：可以在请求被路由之前调用
          - `routing`：在路由请求时候被调用
          - `post`：在routing和error过滤器之后被调用
          - `error`：处理请求时发生错误时被调用
        + `filterOrder`：通过int值来定义过滤器的执行顺序
        + `shouldFilter`：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效。
        + `run`：过滤器的具体逻辑。需要注意，这里我们通过`ctx.setSendZuulResponse(false)`令zuul过滤该请求，不对其进行路由，然后通过`ctx.setResponseStatusCode(401)`设置了其返回的错误码，当然我们也可以进一步优化我们的返回，比如，通过`ctx.setResponseBody(body)`对返回body内容进行编辑等。
    
  + ##### **实例化该过滤器**；
    
    ![image-20210715085621374](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214310.png)
  
+ #### zuul的请求生命周期
  
  ![image-20210715085906468](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214312.png)
  
+ #### 服务网关在微服务中的作用：
  
      + 不仅仅实现了路由功能来屏蔽诸多服务细节，更实现了服务级别、均衡负载的路由。
      + 实现了接口权限校验与微服务业务逻辑的解耦。通过服务网关中的过滤器，在各生命周期中去校验请求的内容，将原本在对外服务层做的校验前移，保证了微服务的无状态性，同时降低了微服务的测试难度，让服务本身更集中关注业务逻辑的处理。
      + 实现了断路器，不会因为具体微服务的故障而导致服务网关的阻塞，依然可以对外服务。





----

## 熔断器-Hystrix：

+ 在分布式环境中，许多服务依赖关系中的一些必然会失败。Hystrix是一个库，它通过添加延迟容忍和容错逻辑来帮助您控制这些分布式服务之间的交互。Hystrix通过隔离服务之间的访问点、停止跨服务的级联故障并提供回退选项来实现这一点，所有这些选项都提高了系统的总体弹性。

+ #### hystrix依赖

  ```java
  <dependency>
      <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
  </dependency>
  ```

+ #### 主要步骤：

  + ###### 通过@EnableHystrix注解激活服务提供方短路

  + ###### 通过`@HystrixCommand`实现服务提供方短路。

  + ###### 使用`@EnableCircuitBreaker` 实现服务调用方短路

  + ###### 服务调用

  + ###### 使用编程方式自定义短路实现

  + ###### 服务监控Hystrix Dashboard仪表盘

+ hystrix作为一个服务容错保护组件，可以避免因为请求得不到及时响应而可能出现的大量**请求挤压**，甚至引发**雪崩效应**的情况，使得一个服务不可用之后直接熔断服务，而不至于导致整个分布式应用都受到影响。

+ #### Hystrix解决灾难性雪崩效应：

  + ##### 降级

    + 超时降级或资源不足时（线程或信号量）降级，降级后配合降级接口返回兜底数据，实现一个fallback方法，当请求后端服务出现异常的时候，可以使用fallback方法返回的值；在xxxxservice中，@HystrixCommand(value = '')可以指定返回的兜底方法，并给出具体实现方法。

  + ##### 缓存

    + Hystrix为了降级访问服务的频率，支持将一个请求与返回结果做缓存处理。如果再次请求的URL没有变化，那么Hystrix不会请求服务，而是直接从缓存中将结果返回，可以大大降低访问服务压力。[参考](https://dpb-bobokaoya-sm.blog.csdn.net/article/details/91456676)

  + ##### 请求合并

    + 微服务中独立的模块通过远程调用来相互配合，但在高并发情况下，通信次数的增加会导致总的通信时间增加，同时线程池的资源也是有限的，高并发环境会导致大量线程处于等待状态，导致响应延迟，所以Hystrix的请求合并可以解决。
      + **缺点：**设置请求合并后，本来一个请求可能5ms就搞定了，但现在必须再等10ms去等其他的请求一起处理，这样的一个请求就增加了更多耗时，不过若我们要发起的命令本身就是一个高延时的命令，那么就可以使用请求合并，因为时间窗的时间消耗就显得微不足道了，另外高并发也是请求合并的重要场景。

  + ##### 熔断

    + 当失败率（网络故障/超时造成失败率上升）达到阈值自动触发降级，熔断器触发的快速失败会进行快速恢复。
    + 熔断就是在降级的基础上，引入了重试的机制，当达到某一重试次数就会触发；
    + 启动类上，@EnableCircuitBreaker的注解开启Hystrix熔断；

    ![image-20210715083948283](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214318.png)

    ![image-20210715084023507](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214326.png)

  + ##### 隔离【限制调用分布式服务的资源使用，某一个调用的服务出现问题都不会影响其他服务的调用】

    + ###### 线程隔离

      ![image-20210715084106212](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214328.png)

      ![image-20210715084122245](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214332.png)

    + ###### 信号量隔离

      ![image-20210715084455270](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214337.png)

    + ###### 区别

      ![image-20210715084528283](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214218.png)

  

  + #### 熔断监测之monitor:

    + https://blog.csdn.net/feinifi/article/details/96035614







## SpringCloud Config配置中心

+ 将系统中用到的一些配置信息存储到配置中心，方便维护，不用每次修改配置都重启服务。用的比较多的配置中心还有etcd、携程的 Apollo。

![image-20210715223452112](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232646.png)

![image-20210715223517694](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232644.png)

![image-20210715223552278](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232643.png)

![image-20210715223612230](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232640.png)

![image-20210715230133145](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232637.png)

![image-20210715232538761](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232638.png)





## springcloud stream消息驱动

+ #### [核心概念][https://blog.didispace.com/spring-cloud-starter-dalston-7-2/]

+ 解决实际开发中系统难免使用多个或途中更改消息中间件，而 stream 就是用来整合消息中间件的工具，从而降低系统于中间件的耦合度。

+ 官方定义为构建消息驱动微服务的框架；应用通过inputs或outputs来与steam中的binder交互，通过配置binding，而stream的binder负责与中间件交互。通过使用spring integration来连接消息代理中间件来实现消息事件驱动。stream为一些供应商的消息中间件产品提供一个个性化的自动化配置实现，引用了发布-订阅，消息组，分区的三个核心概念。【目前只支持rabbitmq、kafka】

+ stream解决了开发人员无感知的使用消息中间件的问题，因为stream对消息中间件的进一步封装，可以做到代码层面度中间件的无感知，甚至于动态的切换中间件。是的微服务开发的高度解耦，服务可以关注更多自己的业务。

  ![image-20210716084009323](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214203.png)

  ![image-20210716083744664](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214159.png)

+ #### 消费组

  + ##### 使用消费组实现消息消费的负载均衡[https://blog.didispace.com/spring-cloud-starter-dalston-7-3/]

  + [使用消息分区](https://blog.didispace.com/spring-cloud-starter-dalston-7-4/)





## springcloud Bus消息总线

+ 集成了常用的消息中间件【rabbitmq、kafka】，连接微服务系统中所有的节点，当有数据变更时，可以通过消息代理的=广播通知微服务技师变更数据，例如微服务的配置更新。
+ 解决的是微服务的数据变更与同步问题；







---

## RabbitMQ：

+ #### Overview(概述)

  + **Totals**里面有Unacked未确认的消息数

    **Nodes** ：其实就是支撑RabbitMQ运行的一些机器（可以理解为集群的节点），RabbitMQ我只装在了本地，因而只能看到一个节点。

    **Listening ports**：3个端口（5672,25672,15672）;

    　　5672对应的是amqp，25672对应的是clustering，15672对应的是http（也就是我们登录RabbitMQ后台管理时用的端口）。

    　　25672对应的是集群，15672对应的是后台管理。因为RabbitMQ遵循Ampq协议，所以5672对应的就是RabbitMQ的通信了。

  + **所有队列上一分钟的消息阻塞情况**

    Ready：待消费的消息总数。
    Unacked：待应答的消息总数。
    Total：总数 Ready+Unacked。

    ![image-20210716091352295](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214200.png)

    

  + ##### 所有队列的消费情况

    Publish：producter pub消息的速率。
    Publisher confirm：确认pub消息的速率。
    Deliver(manual ack)：customer手动确认的速率。
    Deliver(auto ack)：customer自动确认的速率。
    Consumer ack：customer正在确认的速率。
    Redelivered：正在传递'redelivered'标志集的消息的速率。
    Get (manual ack)：响应basic.get而要求确认的消息的传输速率。
    Get (auto ack)：响应basic.get而发送不需要确认的消息的速率。
    Return：将basic.return发送给producter的速率。
    Disk read：queue从磁盘读取消息的速率。
    Disk write：queue从磁盘写入消息的速率。

    ![image-20210716091635829](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214157.png)

  + **全局数据**

    Connections：client的tcp连接的总数。
    Channels：通道的总数。
    Exchange：交换器的总数。
    Queues：队列的总数。
    Consumers：消费者的总数。

    ![image-20210716091829532](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214156.png)

  + ##### 消息服务器节点信息

    Name：节点名称
    File descriptors：节点打开的文件描述符和限制。
    Socket descriptors：管理的网络套接字数量和限制。当限制被耗尽时，RabbitMQ将停止接受新的网络连接。
    Erlang processes：erlang启动的进程数。
    Memory：当前消息服务器占用的内存。
    Disk space：当前服务器占用的硬盘。
    Uptime：当前节点持续运行的时长。
    Info：节点信息。
    Reset stats：重置节点状态。
    ![image-20210716091939864](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214402.png)

    

+ #### Connections(连接)

  + 当前所有客户端活动的连接。包括生成者和消费者。"连接"就是生产者和消费者的连接情况；

    不管生产者还是消费者，其实都是应用程序（主体是计算机，有ip地址即可，物理上可以位于任何地方），都需要和rabbitmq服务器建立连接。

  + ##### **为什么要用虚拟主机？**

    + RabbitMQ server 可以说就是一个消息队列服务器实体（**Broker**），**Broker**当中可以有多个用户（[增加用户的命令](http://www.cnblogs.com/ericli-ericli/p/5902270.html)），而用户只能在虚拟主机的粒度进行权限控制，所以RabbitMQ中需要多个虚拟主机。每一个RabbitMQ服务器都有一个默认的虚拟主机“/”。】	

  + ##### 连接属性:

    Virtual host：所属的虚拟主机。
    Name：名称。
    User name：使用的用户名。
    State：当前的状态，running：运行中；idle：空闲；flow：流控。
    SSL/TLS：是否使用ssl进行连接。
    Protocol：使用的协议。
    Channels：创建的channel的总数。
    From client：每秒发出的数据包。
    To client：每秒收到的数据包。

+ #### Channels(通道)

  + 　"通道"是建立在"连接"基础上的，实际开发中"连接"应为全局变量，"通道"为线程级；

  + 一个连接(ip) 可以有多个通道，eg，采用多线程。

  +  一个连接（Connections）可以创建多个通道【采用多线程】；一个应用或者一个线程 都是一个通道（Channel）；在通道中 创建队列Queue

    生产者的通道一般会立马关闭；消费者是一直侦听的，通道几乎是会一直存在。

  + ##### 当前连接所有创建的通道。通道的属性：

    channel：名称。
    Virtual host：所属的虚拟主机。
    User name：使用的用户名。
    Mode：渠道保证模式。 可以是以下之一，或者不是：C: confirm。T：transactional(事务)。
    State ：当前的状态，running：运行中；idle：空闲；flow：流控。 
    Unconfirmed：待confirm的消息总数。
    Prefetch：设置的prefetch的个数。
    Unacker：待ack的消息总数。
    publish：producter pub消息的速率。
    confirm：producter confirm消息的速率。
    deliver/get：consumer 获取消息的速率。
    ack：consumer ack消息的速率。

+ #### Exchanges(交换器)      [RabbitMQ交换器Exchange介绍与实践](https://www.cnblogs.com/vipstone/p/9295625.html)

  + ##### 交换器属性：

    Virtual host：所属的虚拟主机。
    Name：名称。
    Type：exchange type。
    Features：功能。 可以是以下之一，或者不是：D: 持久化。T：Internal，存在改功能表示这个exchange不可以被client用来推送消息，仅用来进行exchange和exchange之间的绑定，否则可以推送消息也可以绑定。
    Message rate in：消息进入的速率。
    Message rate out：消息出去的速率。

+ #### Queues(队列)

  + 是指 队列中此时含有未被消费的数据条数。

    **下方可以查看队列有没有消费者（consumer）**

  + ##### 队列的属性：

    Virtual host：所属的虚拟主机。
    Name：名称。
    Features：功能。 可以是以下之一，或者不是：D: 持久化。
    State：当前的状态，running：运行中；idle：空闲。
    Ready：待消费的消息总数。
    Unacked：待应答的消息总数。
    Total：总数 Ready+Unacked。
    incoming：消息进入的速率。
    deliver/get：消息获取的速率。
    ack：消息应答的速率。  

+ #### Admin(用户管理)

  + 　"用户管理"就是用户增删改查以及虚拟主机、规则等的配置。

##### [RabbitMQ后台管理界面1](https://www.cnblogs.com/peterYong/p/10845560.html)

##### [RabbitMQ后台管理界面2](https://blog.csdn.net/suman35/article/details/103011177)







---

## Elasticsearch

## swagger





## 重温MVC框架

[SpringMVC 包教包会](https://www.cnblogs.com/lenve/p/12100698.html)

+  Web MVC 设计模式的请求驱动类型的轻量级 Web 框架
+ 基于请求驱动指的就是使用请求-响应模型，框架的目的就是帮助我们简化开发
+ 提供了非常灵活的数据验证、格式化和数据绑定机制；提供了强大的约定大于配置（惯例优先原则）的契约式编程支持。

## Java回调机制

+ 回调是一个函数，它作为参数传递给另一个函数，并在其父函数完成后执行。



## 应用上下文

+ ##### [BeanFactory和ApplicationContext有什么区别？](https://cwl-java.blog.csdn.net/article/details/102902308)



## AOP

+ AOP为Aspect Oriented Programming的缩写，意为：面向切面编程，通过**预编译**方式和运行期间动态代理实现程序功能的统一维护的一种技术。AOP是**OOP**的延续，是软件开发中的一个热点，也是**Spring**框架中的一个重要内容，是**函数式编程**的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的**耦合度**降低，提高程序的可重用性，同时提高了开发的效率。
+ [Spring-AOP](https://baijiahao.baidu.com/s?id=1675058725019522890&wfr=spider&for=pc)



## Java日志

+ ###### 日志体系

  ![image-20210714145729913](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203640.png)

+ **日志门面**

  日志门面定义了一组日志的接口规范，它并不提供底层具体的实现逻辑。`Apache Commons Logging` 和 `Slf4j` 就属于这一类。

  **日志实现**

  日志实现则是日志具体的实现，包括日志级别控制、日志打印格式、日志输出形式（输出到数据库、输出到文件、输出到控制台等）。`Log4j`、`Log4j2`、`Logback` 以及 `Java Util Logging` 则属于这一类。

+ ##### 日志级别：

  + **Java Util Logging**

    `Java Util Logging` 定义了 7 个日志级别，从严重到普通依次是：

    - SEVERE-WARNING-INFO-CONFIG-FINE-FINER-FINEST

    因为默认级别是 INFO，因此 INFO 级别以下的日志，不会被打印出来。

  + **Log4j**

    `Log4j` 定义了 8 个日志级别（除去 OFF 和 ALL，可以说分为 6 个级别），从严重到普通依次是：

    - OFF：最高等级的，用于关闭所有日志记录。
    - FATAL：重大错误，这种级别可以直接停止程序了。
    - ERROR：打印错误和异常信息，如果不想输出太多的日志，可以使用这个级别。
    - WARN：警告提示。
    - INFO：用于生产环境中输出程序运行的一些重要信息，不能滥用。
    - DEBUG：用于开发过程中打印一些运行信息。
    - TRACE
    - ALL 最低等级的，用于打开所有日志记录。

  + **Logback**

    `Logback` 日志级别比较简单，从严重到普通依次是：

    - ERROR-WARN-INFO-DEBUG-TRACE

  + ##### springboot的日志实现:

    + springboot真正的日志实现是Logback；

    + springboot只要配置web依赖就会自动配置日志依赖；

    + ###### 日志配置：

      + logging.level.org.springframework.web=debug logging.level.org.hibernate=error   //logging.level 前缀+包名
      + logging.file.name=javaboy.log   //输出到文件
      + logging.file.name=/Users/sang//javaboy/javaboy.log  //指定文件名或全路径
      + logging.file.path=/Users/sang//javaboy   //只输出路径

    + ###### 日志进行精细化管理，还有如下一些属性可以配置：

      + logging.logback.rollingpolicy.file-name-pattern：日志归档的文件名，日志文件达到一定大小之后，自动进行压缩归档。
      + logging.logback.rollingpolicy.clean-history-on-start：是否在应用启动时进行归档管理。
      + logging.logback.rollingpolicy.max-file-size：日志文件大小上限，达到该上限后，会自动压缩。
      + logging.logback.rollingpolicy.total-size-cap：日志文件被删除之前，可以容纳的最大大小。
      + logging.logback.rollingpolicy.max-history：日志文件保存的天数。

      [springboot日志的各种使用](https://www.cnblogs.com/lenve/p/14142244.html)





+ #### 错误归纳：

  + ###### BeanPostProcessor before instantiation of bean failed; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/tools/PointcutPrimitive

    原因：缺少aspectj依赖：

    ```java
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.2</version>
    </dependency>  
        
    ```

    ---

  + zipkin注入依赖请求监测项目链路，控制台输出的zipkin收集不到链路信息，INFO [spc-sleuth,cbb42cb34409e44a,cbb42cb34409e44a,**false**]

    解决的办法为配置文件中加上```spring.sleuth.sampler.percentage=1.0```，采样默认是0.1【10%】

  + > ###### 收集方式冲突问题 【依赖冲突修改 +  启动类注解修改】【https://blog.csdn.net/lvyuan1234/article/details/77652938】
    >
    > Description:
    >
    > Parameter 0 of method sleuthStreamSpanReporter in org.springframework.cloud.sleuth.stream.SleuthStreamAutoConfiguration required a bean of type 'org.springframework.cloud.sleuth.stream.HostLocator' that could not be found.
    >
    > 	- Bean **method 'zipkinEndpointLocator' not loaded because @ConditionalOnProperty (spring.zipkin.locator.discovery.enabled=true) did not find property 'spring.zipkin.locator.discovery.enabled'**
    >
    >
    > Action:
    >
    > Consider revisiting the conditions above or defining a bean of type 'org.springframework.cloud.sleuth.stream.HostLocator' in your configuration.
    >
    
  + SpringCloud集成 报错 An attempt was made to call a method that does not exist. The attempt was made from the following location:...

    > springboot 与 springcloud版本冲突~
    >
    > https://blog.csdn.net/qq_29950673/article/details/102621679
    >
    > https://zhuanlan.zhihu.com/p/147899433















###### ‘org.springframework.web.client.RestTemplate‘ that could not be found【https://blog.csdn.net/weixin_44259720/article/details/109216423】

----



![image-20210720211958846](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224050.png)

![image-20210720212039137](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224043.png)

#### 



























































----

### 725：

![image-20210725124209638](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224039.png)

![image-20210725125318976](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224036.png)

![image-20210725130833994](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224031.png)



![image-20210725150749119](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224029.png)

![image-20210725210030779](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224026.png)

![image-20210725210320840](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224024.png)

![image-20210725210356945](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224019.png)

![image-20210725211903859](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224015.png)

![image-20210725211919748](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224012.png)

![image-20210725212119737](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224010.png)

![image-20210725213135477](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224004.png) 

![image-20210725213453182](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224002.png)

![image-20210725214012071](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224124.png)

![image-20210725221807960](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224113.png)

## 本周任务：

https://www.bilibili.com/video/BV1R54y1J74K?p=58&spm_id_from=pageDriver

https://www.bilibili.com/video/BV1eE41187Ug?p=1

https://www.bilibili.com/video/BV18K4y1Q7Ez?p=1

