## springcloud组件

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
  + **常见的负载均衡算法**：简单轮询、加权轮询、简单随机、加权随机、一致性哈希、最小活跃数。
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
  + 实现分布式事务的方式：直接通过数据库、通过消息队列、两阶段提交、三阶段提交；
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

  ```xml
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

+ 负载均衡分服务端和客户端，常见的nginx就是服务端的负载均衡，即nginx将客户请求发送给上游不同的服务器去处理；进程内负载均衡（客户端负载均衡），将负载均衡逻辑集成到 consumer，consumer 从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选择出一个合适的 provider。Ribbon 属于后者，它只是一个类库，集成于 consumer 进程，consumer 通过它来获取 provider 的地址。

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
    + 3.** 在BaseLoadBalancer的chooseServer方法中(负载均衡的核心方法)，我们发现最终调用了IRule中的choose方法来找到一个具体的服务实例，IRule是一个接口，**在BaseLoadBalancer它的默认实现是RoundRobinRule类，RoundRobinRule类中采用了最常用的线性负载均衡规则，**也就是所有有效的服务端轮流调用。
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



+ #### 策略：

  + 轮询策略：**`RoundRobinRule`**
    + 实现原理：轮询策略表示每次都顺序取下一个 provider，比如一共有 5 个 provider，第 1 次取第 1 个，第 2 次取第 2 个，第 3 次取第 3 个，以此类推。
  + 权重轮询策略：**`WeightedResponseTimeRule`**
    - 根据每个 provider 的响应时间分配一个权重，响应时间越长，权重越小，被选中的可能性越低。
    - 原理：一开始为轮询策略，并开启一个计时器，每 30 秒收集一次每个 provider 的平均响应时间，当信息足够时，给每个 provider 附上一个权重，并按权重随机选择 provider，高权越重的 provider 会被高概率选中。
  + 最小并发数策略：**`BestAvailableRule`**
    + 实现原理：选择正在请求中的并发数最小的 provider，除非这个 provider 在熔断中。
  + 重试策略：**`RetryRule`**
    + 实现原理：其实就是轮询策略的增强版，轮询策略服务不可用时不做处理，重试策略服务不可用时会重新尝试集群中的其他节点。
  + 可用性敏感策略：**`AvailabilityFilteringRule`**
    + 实现原理：过滤性能差的 provider
      + 第一种：过滤掉在 Eureka 中处于一直连接失败的 provider。
      + 第二种：过滤掉高并发（繁忙）的 provider。
  + 　区域性敏感策略：**`ZoneAvoidanceRule`**
    - 以一个区域为单位考察可用性，对于不可用的区域整个丢弃，从剩下区域中选可用的 provider。
    - 如果这个 ip 区域内有一个或多个实例不可达或响应变慢，都会降低该 ip 区域内其他 ip 被选中的权
      重。

+ ##### 全局策略实现：在启动类中注入

  + ~~~java
    @Bean
    public RandomRule randomRule() {
        return new RandomRule();
    }
    ~~~

+ ##### 局部策略实现：在配置文件中【格式：`服务应用名.ribbon.NFLoadBalancerRuleClassName`】

  ~~~yml
  service-provider:
    ribbon:
      NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
  ~~~

+ ##### ribbon依赖注入：有Eureka-client的需要去除，eureka中包含

  ```xml
  <!-- netflix ribbon 依赖 -->
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
  </dependency>
  ```

+ ##### eureka 与 ribbon 点对点直连

  ```yml
  # 关闭 Eureka 实现 Ribbon 点对点直连
  ribbon:
    eureka:
      enabled: true # false：关闭，true：开启
  ```

  开启后关闭Eureka注册中心，消费者依然可以消费。



---

## Feign &  openfeign

**```拦截器传递header 中的 oauth2 token```**

+ #### 是什么？
  + Feign 是 Spring Cloud Netflix 组件中的一个轻量级 RESTful 的 HTTP 服务客户端，实现了负载均衡和 Rest 调用的开源框架，**封装了 Ribbon 和 RestTemplate**，实现了 WebService 的面向接口编程，进一步降低了项目的耦合度。
  + **用来做客户端负载均衡调用服务注册中心的服务。**
  + Feign 本身并不支持 Spring MVC 的注解，它有一套自己的注解，为了更方便的使用，Spring Cloud 孵化了 OpenFeign。
  + **仅在 Consumer 中使用;**

+ #### 做什么？

  +  简化了 RestTemplate 代码，实现了 Ribbon 负载均衡；
  + Feign 实现负载均衡是首选方案。**只需要你创建一个接口，然后在上面添加注解即可。**

  ##### 总体来说：Feign 是声明式服务调用组件，其核心就是：**像调用本地方法一样调用远程方法，无感知远程 HTTP 请求。**它解决了让开发者调用远程接口就跟调用本地方法一样的体验，开发者完全感知不到这是远程方法，更感知不到这是个 HTTP 请求。无需关注与远程的交互细节，更无需关注分布式环境开发。

+ #### 与[为支持springMVC注解的]openfeign关系：

  　　OpenFeign 的 `@FeignClient` 可以解析 SpringMVC 的 `@RequestMapping` 注解下的接口，并通过动态代理的方式产生实现类，实现类中做负载均衡并调用服务。

+ #### Feign的性能优化

  + ##### gzip压缩

    gzip 作用：网络数据经过压缩后实际上**降低了网络传输的字节数**，最明显的好处就是可以**加快网页加载的速度**。网页加载速度加快的好处不言而喻，除了节省流量，改善用户的浏览体验外，另一个潜在的好处是 Gzip 与搜索引擎的抓取工具有着更好的关系。例如 Google 就可以通过直接读取 gzip 文件来比普通手工抓取更快地检索网页。

    + Http压缩传输规定：

      1. 客户端向服务器请求中带有：`Accept-Encoding:gzip`，`deflate` 字段，向服务器表示客户端支持的压缩格式（gzip 或者 deflate），如果不发送该消息头，服务端默认是不会压缩的。
      2. 服务端在收到请求之后，如果发现请求头中含有 `Accept-Encoding` 字段，并且支持该类型压缩，就会对响应报文压缩之后返回给客户端，并且携带 `Content-Encoding:gzip` 消息头，表示响应报文是根据该格式进行压缩的。
      3. 客户端接收到请求之后，先判断是否有 `Content-Encoding` 消息头，如果有，按该格式解压报文。否则按正常报文处理。

    + ##### 全局/局部压缩配置：

      ```yml
      server:
        port: 9090 # 端口
        compression:
          # 是否开启压缩  【全局压缩】
          enabled: true
          # 配置压缩支持的 MIME TYPE
          mime-types: application/json,application/xml,text/html,text/xml,text/plain
          
      feign:
        httpclient:
          enabled: true # 开启 httpclient
        # feign 的 gzip 压缩局部配置：
        compression:
          request:
            mime-types: text/xml,application/xml,application/json # 配置压缩支持的 MIME TYPE
            min-request-size: 512                                 # 配置压缩数据大小的最小阈值，默认 2048
            enabled: true                                         # 请求是否开启 gzip 压缩
          response:
            enabled: true
          
      ```

  + #### Http连接池：

    + 解决http请求过程的复杂与资源交互；

    + Feign 的 HTTP 客户端支持 3 种框架：`HttpURLConnection`、`HttpClient`、`OkHttp`；默认是 `HttpURLConnection`

    + **HttpClient** 相比传统 JDK 自带的 HttpURLConnection，它封装了访问 HTTP 的请求头，参数，内容体，响应等等；它不仅使客户端发送 HTTP 请求变得容易，而且也方便了开发人员测试接口（基于 HTTP 协议的），既提高了开发的效率，又提高了代码的健壮性；另外高并发大量的请求网络的时候，也是用“连接池”提升吞吐量。

      + ##### 需要添加的依赖

        ```xml
        <!-- 当前版本已经默认集成了 apache httpclient 依赖 -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.11</version>
        </dependency>
        <!-- feign apache httpclient 依赖 -->
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-httpclient</artifactId>
            <version>10.7.4</version>
        </dependency>
        ```

      + ```yml
        #配置信息：
        feign:
          httpclient:
            enabled: true # 开启 httpclient
        ```

  + #### 请求超时配置

    ~~~yml
    # 全局
    ribbon:
      ConnectTimeout: 5000 # 请求连接的超时时间 默认的时间为 1 秒
      ReadTimeout: 5000    # 请求处理的超时时间
    
    # 局部
    # service-provider 是需要调用的服务名称
    service-provider:
      ribbon:
        OkToRetryOnAllOperations: true  # 对所有请求都进行重试
        MaxAutoRetries: 2               # 对当前实例的重试次数
        MaxAutoRetriesNextServer: 0     # 切换实例的重试次数
        ConnectTimeout: 3000            # 请求连接的超时时间
        ReadTimeout: 3000               # 请求处理的超时时间  
    ~~~

    

[**logback**的@Data @AllargsConstructor @NoargsConstructor](https://blog.csdn.net/ChenXvYuan_001/article/details/84961992)

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

![image-20210714104528593](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203638.png)

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

+ [线程池](http://gityuan.com/2016/01/16/thread-pool/)

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

+ #### 解决的问题

  + 如何快速发现问题？
  + 如何判断故障影响范围？
  + 如何梳理服务依赖以及依赖的合理性？
  + 如何分析链路性能问题以及实时容量规划？

+ #### 功能：

  - `链路追踪`：通过 Sleuth 可以很清楚的看出一个请求都经过了那些服务，可以很方便的理清服务间的调用关系等。
  - `性能分析`：通过 Sleuth 可以很方便的看出每个采样请求的耗时，分析哪些服务调用比较耗时，当服务调用的耗时随着请求量的增大而增大时， 可以对服务的扩容提供一定的提醒。
  - `数据分析，优化链路`：对于频繁调用一个服务，或并行调用等，可以针对业务做一些优化措施。
  - `可视化错误`：对于程序未捕获的异常，可以配合 Zipkin 查看。

+ #### 依赖注入

  ```xml
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

+ zuul最主要的功能是**路由转发**和**过滤器**的实现；

+ ##### 网关应具备的功能：

  　　网关具有身份认证与安全、审查与监控、动态路由、负载均衡、缓存、请求分片与管理、静态响应处理等功能。当然最主要的职责还是与“外界联系”。

  - 性能：API 高可用，负载均衡，容错机制。
  - 安全：权限身份认证、脱敏，流量清洗，后端签名（保证全链路可信调用），黑名单（非法调用的限制）。
  - 日志：日志记录，一旦涉及分布式，全链路跟踪必不可少。
  - 缓存：数据缓存。
  - 监控：记录请求响应数据，API 耗时分析，性能监控。
  - 限流：流量控制，错峰流控，可以定义多种限流规则。
  - 灰度：线上灰度部署，可以减小风险。
  - 路由：动态路由规则。

+ #### 解决了什么问题：

  ![image-20210715084940804](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214240.png)

  ![img](https://mrhelloworld.com/resources/articles/spring/spring-cloud/zuul/280044-20170731002541646-1718153933.png)

+ 首先，破坏了服务无状态特点。为了保证对外服务的安全性，我们需要实现对服务访问的权限控制，而开放服务的权限控制机制将会贯穿并污染整个开放服务的业务逻辑，这会带来的最直接问题是，破坏了服务集群中REST API无状态的特点。从具体开发和测试的角度来说，在工作中除了要考虑实际的业务逻辑之外，**还需要额外可续对接口访问的控制处理。**

+ 其次，无法直接复用既有接口。当我们需要对一个即有的集群内访问接口，实现外部服务访问时，我们不得不通过**在原有接口上增加校验逻辑**，或**增加一个代理调用来实现权限控制**，无法直接复用原有的接口。

+ 为了解决上面这些问题，我们需要将权限控制这样的东西从我们的服务单元中抽离出去，而最适合这些逻辑的地方就是处于对外访问最前端的地方，我们需要一个更强大一些的**均衡负载器**：

  + 服务网关是微服务架构中一个不可或缺的部分。通过服务网关统一向外系统提供REST API的过程中，除了具备服务路由、均衡负载功能之外，它还具备了权限控制等功能。
  + 为微服务架构提供了前门保护的作用，同时将权限控制这些较重的非业务逻辑内容迁移到服务路由层面，使得服务集群主体能够具备更高的可复用性和可测试性。

+ 微服务：微服务的应用可能部署在不同机房，不同地区，不同域名下。此时客户端（浏览器/手机/软件工具）想要请求对应的服务，都需要知道机器的具体 IP 或者域名 URL，当微服务实例众多时，这是非常难以记忆的，对于客户端来说也太复杂难以维护。此时就有了网关，客户端相关的请求直接发送到网关，由网关根据请求标识解析判断出具体的微服务地址，再把请求转发到微服务实例。这其中的记忆功能就全部交由网关来操作了。

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

      ```properties
      # routes to url
      zuul.routes.api-a-url.path=/api-a-url/**
      zuul.routes.api-a-url.url=http://localhost:2222/
      ```

      `/api-a-url/**`的访问都映射到`http://localhost:2222/`上，也就是说当我们访问`http://localhost:5555/api-a-url/add?a=1&b=2`的时候，Zuul会将该请求路由到：`http://localhost:2222/add?a=1&b=2`上。

      - 通过url映射的方式对于Zuul来说，并不是特别友好，Zuul需要知道我们所有为服务的地址，才能完成所有的映射配置。而实际上，我们在实现微服务架构时，服务名与服务实例地址的关系在eureka server中已经存在了，所以只需要将Zuul注册到eureka server上去发现其他服务，我们就可以实现对serviceId的映射。例如，我们可以如下配置：

    + ##### serviceId映射方式：

      ```properties
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

    + ##### 各个过滤器功能

      - 身份认证与安全：识别每个资源的验证要求，并拒绝那些与要求不符的请求
      - 审查与监控：在边缘位置追踪有意义的数据和统计结果，从而带来精确的生产试图
      - 动态路由：动态地将请求路由到不同的后端集群
      - 压力测试：逐渐增加只想集群的流量，以了解性能
      - 负载分配：为每一种负载类型分配对应容量，并弃用超出限定值的请求
      - 静态响应处理：在边缘位置直接建立部份响应，从而避免其转发到内部集群\
      - 多区域弹性：跨越AWS Region进行请求路由，旨在实现ELB（Elastic Load Balancing）使用的多样化，以及让系统的边缘更贴近系统的使用者

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
      + 易于监控，可在微服务网关收集监控数据并将其推送到外部系统进行分析
      + 易于认证，可在微服务网关上进行认证，然后再将请求转发到后端的微服务，从而无需在每个微服务中进行认证
      + 减少了客户端与各个微服务之间的交互次数





----

## 熔断器-Hystrix：

+ 在分布式环境中，许多服务依赖关系中的一些必然会失败。Hystrix是一个库，它通过添加延迟容忍和容错逻辑来帮助您控制这些分布式服务之间的交互。Hystrix通过隔离服务之间的访问点、停止跨服务的级联故障并提供回退选项来实现这一点，所有这些选项都提高了系统的总体弹性。

+ #### hystrix依赖

  ```xml
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

  + ##### 缓存[支持将一个请求与返回结果做缓存处理]

    + Hystrix为了降级访问服务的频率，支持将一个请求与返回结果做缓存处理。如果再次请求的URL没有变化，那么Hystrix不会请求服务，而是直接从缓存中将结果返回，可以大大降低访问服务压力。[参考](https://dpb-bobokaoya-sm.blog.csdn.net/article/details/91456676)

  + ##### 请求合并[将相同的请求进行合并然后调用批处理接口]

    + 微服务中独立的模块通过远程调用来相互配合，但在高并发情况下，通信次数的增加会导致总的通信时间增加，同时线程池的资源也是有限的，高并发环境会导致大量线程处于等待状态，导致响应延迟，所以Hystrix的请求合并可以解决。
      + **缺点：**设置请求合并后，本来一个请求可能5ms就搞定了，但现在必须再等10ms去等其他的请求一起处理，这样的一个请求就增加了更多耗时，不过若我们要发起的命令本身就是一个高延时的命令，那么就可以使用请求合并，因为时间窗的时间消耗就显得微不足道了，另外高并发也是请求合并的重要场景。

  + ##### 熔断[牺牲局部服务，保全整体系统稳定性的措施]

    + 当失败率（网络故障/超时造成失败率上升）达到阈值自动触发降级，熔断器触发的快速失败会进行快速恢复。
    + 熔断就是在降级的基础上，引入了重试的机制，当达到某一重试次数就会触发；
    + 启动类上，@EnableCircuitBreaker的注解开启Hystrix熔断；

    ![image-20210715083948283](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214318.png)

    ![image-20210715084023507](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214326.png)

  + ##### 降级[服务熔断以后，客户端调用自己本地方法返回缺省值]

    + 超时降级或资源不足时（线程或信号量）降级，降级后配合降级接口返回兜底数据，实现一个fallback方法，当请求后端服务出现异常的时候，可以使用fallback方法返回的值；在xxxxservice中，@HystrixCommand(value = '')可以指定返回的兜底方法，并给出具体实现方法。

  + ##### 隔离【限制调用分布式服务的资源使用，某一个调用的服务出现问题都不会影响其他服务的调用】

    + ###### 线程隔离

      ![image-20210715084106212](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214328.png)

      ![image-20210715084122245](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214332.png)

    + ###### 信号量隔离

      ![image-20210715084455270](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214337.png)

    + ###### 区别

      ![image-20210715084528283](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214218.png)

  

  + #### 请求缓存
  + Hystrix 为了降低访问服务的频率，支持将一个请求与返回结果做缓存处理。如果再次请求的 URL 没有变化，那么 Hystrix 不会请求服务，而是**直接从缓存中将结果返回**。这样可以大大降低访问服务的压力。
    
      + Hystrix 自带缓存有两个缺点：
        - 本地缓存，集群情况下缓存无法同步。
        - 不支持第三方缓存容器，如：Redis，MemCache。
      
    + ##### 步骤：
    
      + 服务消费者 pom.xml 添加 redis 和 commons-pool2 依赖：
    
        ```xml
         <!-- spring boot data redis 依赖 -->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-data-redis</artifactId>
                </dependency>
                <!-- commons-pool2 对象池依赖 -->
                <dependency>
                    <groupId>org.apache.commons</groupId>
                    <artifactId>commons-pool2</artifactId>
                </dependency>
        ```
    
      + ```yml
        spring:
          # redis 缓存
          redis:
            timeout: 10000        # 连接超时时间
            host: 192.168.10.101  # Redis服务器地址
            port: 6379            # Redis服务器端口
            password: root        # Redis服务器密码
            database: 0           # 选择哪个库，默认0库
            lettuce:
              pool:
                max-active: 1024  # 最大连接数，默认 8
                max-wait: 10000   # 最大连接阻塞等待时间，单位毫秒，默认 -1
                max-idle: 200     # 最大空闲连接，默认 8
                min-idle: 5       # 最小空闲连接，默认 0
        ```
    
      + ##### redis使用：
    
        + ##### 开启：目录下redis-server.exe——>另一个cmd：redis-cli——>config get requirepass 查看密码——>设置密码并验证：config set  requirepass "root"——>AUTH root
    
      + 添加 Redis 配置类重写序列化规则。
        
        + 需要重写 RedisTemplate 序列化和重写 Cache 序列化
      + 服务消费者启动类开启缓存注解：
        
        + 开启缓存注解 @EnableCaching  @SpringBootApplication
    + 服务消费者业务层代码添加缓存规则：
      
      + 指定在redis显示的名称：@Cacheable(cacheNames = "") 
  

  
+ #### 请求合并
  
  **在高并发情况下**，通信次数的增加会导致总的通信时间增加，同时，**线程池的资源也是有限的**，高并发环境会导致有**大量的线程处于等待状态**，进而导致**响应延迟**，为了解决这些问题，我们需要来了解 Hystrix 的请求合并。
  
  ![image-20210721152347909](D:\桌面的东西\springcloud-learnning\image-20210721152347909.png)
  
    + ##### 依赖注入
  
      ```xml
      <!-- spring-cloud netflix hystrix 依赖 -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
      </dependency>
      ```
    ```
  
  + 启动类开启熔断器注解 2 选 1，@EnableHystrix 封装了 @EnableCircuitBreaker

  
    ```
  
+ #### 服务隔离：
  
  + ##### 线程池隔离：
  
    + 通过每次都开启一个单独线程运行。它的隔离是通过线程池，即每个隔离粒度都是个线程池，互相不干扰。线程池隔离方式，等于多了一层的保护措施，可以通过 hytrix 直接设置超时，超时后直接返回。
  
        **优点：**
  
      - 使用线程池隔离可以安全**隔离依赖的服务**（例如图中 A、C、D 服务），减少所依赖服务发生故障时的影响面。比如 A 服务发生异常，导致请求大量超时，对应的线程池被打满，这时并不影响 C、D 服务的调用。
        - 当失败的服务再次变得可用时，线程池将清理并立即恢复，而不需要一个长时间的恢复。
      - 独立的线程池**提高了并发性**。
  
      　　
  
        **缺点：**

        - 请求在线程池中执行，肯定会带来任务调度、排队和上下文切换带来的 CPU 开销。
      - 因为涉及到跨线程，那么就存在 ThreadLocal 数据的传递问题，比如在主线程初始化的 ThreadLocal 变量，在线程池线程中无法获取。
  
    + ##### 依赖
  
      ```xml
      <!-- spring-cloud netflix hystrix 依赖 -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
      </dependency>
      ```
    ```
    
    ```

  + 服务消费者启动类开启熔断器注解。@EnableCircuitBreaker /@EnableHystrix 
  
  
  
+ #### 信号量隔离：
  
  + 每次调用线程，当前请求通过计数信号量进行限制，当信号量大于了最大请求数 `maxConcurrentRequests` 时，进行限制，调用 `fallback` 接口快速返回。信号量的调用是同步的，也就是说，每次调用都得阻塞调用方的线程，直到结果返回。这样就导致了无法对访问做超时（只能依靠调用协议超时，无法主动释放）。
  
    ![image-20210721165056542](D:\桌面的东西\springcloud-learnning\image-20210721165056542.png)
  
  + ##### 信号量隔离与线程池隔离：
  
    + | 隔离方式   | 是否支持超时 | 是否支持熔断 | 隔离原理             | 是否是异步调用       | 资源消耗 |
    | :--------- | :----------- | :----------- | :------------------- | :------------------- | :------: |
      | 线程池隔离 | 支持         | 支持         | 每个服务单独用线程池 | 支持同步或异步       |    大    |
    | 信号量隔离 | 不支持       | 支持         | 通过信号量的计数器   | 同步调用，不支持异步 |    小    |
  
    + ##### 信号量隔离
  
      - 请求线程和调用 Provider 线程**是同一条线程**；
      - 不支持超时；
      - 支持熔断，当信号量达到 `maxConcurrentRequests` 后。再请求会触发 `fallback` 接口进行熔断；
      - 隔离原理：通过信号量的计数器；
    - 同步调用，不支持异步；
      - 资源消耗小，只是个计数器；
    - 可以传递 Http Header。
  
    + ##### 线程池隔离
  
      - 请求线程和调用 Provider 线程**不是同一条线程**；
      - 支持超时，可直接返回；
      - 支持熔断，当线程池到达最大线程数后，再请求会触发 `fallback` 接口进行熔断；
      - 隔离原理：每个服务单独用线程池；
    - 支持同步和异步两种方式；
      - 资源消耗大，大量线程的上下文切换、排队、调度等，容易造成机器负载高；
    - 无法传递 Http Header。
  
    + ##### 使用场景

      > - 请求并发大，**耗时长**（计算大，或操作关系型数据库），采用线程隔离策略。这样可以保证大量的线程可用，不会由于服务原因一直处于阻塞或等待状态，快速失败返回。还有就是对依赖服务的网络请求的调用和访问，会涉及 timeout 这种问题的都使用线程池隔离。
    > - 请求并发大，**耗时短**（计算小，或操作缓存），采用信号量隔离策略，因为这类服务的返回通常会非常的快，不会占用线程太长时间，而且也减少了线程切换的开销，提高了缓存服务的效率。还有就是适合访问不是对外部依赖的访问，而是对内部的一些比较复杂的业务逻辑的访问，像这种访问系统内部的代码，不涉及任何的网络请求，做信号量的普通限流就可以了，因为不需要去捕获 timeout 类似的问题，并发量突然太高，稍微耗时一些导致很多线程卡在这里，所以进行一个基本的资源隔离和访问，避免内部复杂的低效率的代码，导致大量的线程被夯住。
  
+ #### 服务熔断
  
  服务熔断一般是指软件系统中，由于某些原因使得服务出现了过载现象，为防止造成整个系统故障，从而采用的一种保护措施，所以很多地方把熔断亦称为过载保护。
  
  ![img](https://mrhelloworld.com/resources/articles/spring/spring-cloud/hystrix/1579098034754.png)
  
+ #### 服务降级
  
  忍痛将某些服务先关掉，待渡过难关，再开启回来。
  
    + ##### 触发条件
  
      - 方法抛出非 `HystrixBadRequestException` 异常；
    - 方法调用超时；
      - 熔断器开启拦截调用；
    - 线程池/队列/信号量跑满。
  

  

  
+ #### Hystrix之Actuator
  
  Hystrix 除了可以实现服务容错之外，还提供了近乎实时的监控功能，将服务执行结果和运行指标，请求数量成功数量等等这些状态通过 `Actuator` 进行收集，然后访问 `/actuator/hystrix.stream` 即可看到实时的监控数据。
  
+ #### Hystrix 与 Sentinel(流量保护)

  + ##### 熔断降级

    由于调用关系的复杂性，如果调用链路中的某个资源出现了不稳定，最终会导致请求发生堆积。Sentinel 和 Hystrix 的原则是一致的: 当调用链路中某个资源出现不稳定，

    例如，表现为 timeout，异常比例升高的时候，则对这个资源的调用进行限制，并让请求快速失败，避免影响到其它的资源，最终产生雪崩的效果。

  + ##### 熔断降级设计理念

    + ###### Hystrix：

      在限制的手段上，Sentinel 和 Hystrix 采取了完全不一样的方法。Hystrix 通过[线程池](https://github.com/Netflix/Hystrix/wiki/How-it-Works#benefits-of-thread-pools)的方式，来对依赖(在我们的概念中对应资源)进行了隔离。这样做的好处是资源和资源之间做到了最彻底的隔离。缺点是除了增加了线程切换的成本，还需要预先给各个资源做线程池大小的分配。

    + ###### Sentinel：

      - **通过并发线程数进行限制**

      和资源池隔离的方法不同，Sentinel 通过限制资源并发线程的数量，来减少不稳定资源对其它资源的影响。这样不但没有线程切换的损耗，也不需要您预先分配线程池的大小。当某个资源出现不稳定的情况下，例如响应时间变长，对资源的直接影响就是会造成线程数的逐步堆积。当线程数在特定资源上堆积到一定的数量之后，对该资源的新请求就会被拒绝。堆积的线程完成任务后才开始继续接收请求。

      - **通过响应时间对资源进行降级**

      除了对并发线程数进行控制以外，Sentinel 还可以通过响应时间来快速降级不稳定的资源。当依赖的资源出现响应时间过长后，所有对该资源的访问都会被直接拒绝，直到过了指定的时间窗口之后才重新恢复。

  + ##### 流量控制

    + 流量控制在网络传输中是一个常用的概念，它用于**调整网络包的发送数据**。然而，从系统稳定性角度考虑，在处理请求的速度上，也有非常多的讲究。任意时间到来的请求往往是随机不可控的，而系统的处理能力是有限的。我们**需要根据系统的处理能力对流量进行控制**。Sentinel 作为一个**调配器**，可以根据需要把随机的请求调**整成合适的形状**。

      ![img](https://cdn.nlark.com/yuque/0/2020/png/283679/1600614134148-ed7c7493-0754-497b-bc00-2f31b1f12df7.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_10%2Ctext_cGlnNGNsb3VkLmNvbQ%3D%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

      + ###### 流量控制有以下几个角度:

        + **资源的调用关系**，例如资源的调用链路，资源和资源之间的关系；
        + **运行指标**，例如 QPS、线程池、系统负载等；
        + **控制的效果**，例如直接限流、冷启动、排队等。

  + ##### 系统负载保护

    Sentinel 同时提供[系统维度的自适应保护能力](https://sentinelguard.io/zh-cn/docs/system-adaptive-protection.html)。防止雪崩，是系统防护中重要的一环。当系统负载较高的时候，如果还持续让请求进入，可能会导致系统崩溃，无法响应。在集群环境下，**网络负载均衡会把本应这台机器承载的流量转发到其它的机器上去**。如果这个时候其它的机器也处在一个**边缘状态**的时候，这个增加的流量就会导致这台机器也崩溃，最后导致整个集群不可用。

    针对这个情况，Sentinel 提供了对应的保护机制，让系统的入口流量和系统的负载达到一个平衡，保证系统在能力范围之内处理最多的请求。

  

  #### Hystrix 与 Sentinel区别：

  

  ![image-20210720211958846](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224050.png)

  ![image-20210720212039137](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210725224043.png)

  

  

  
  
  
  
  
  
  + #### 熔断监测之monitor:
  
    + https://blog.csdn.net/feinifi/article/details/96035614













---

## SpringCloud Config配置中心

+ 将系统中用到的一些配置信息存储到配置中心，方便维护，不用每次修改配置都重启服务。用的比较多的配置中心还有etcd、携程的 Apollo。

![image-20210715223452112](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232646.png)

![image-20210715223517694](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232644.png)

![image-20210715223552278](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232643.png)

![image-20210715223612230](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232640.png)

![image-20210715230133145](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232637.png)

![image-20210715232538761](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210715232638.png)

+ #### 具体实现：

  + ##### actuator
  
    ​	![image-20210714104528593](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210714203638.png)
    
    + #### 监控管理：
    
      + ##### 依赖：
    
        ```xml
        <!-- 监控管理 -->
        <dependency>
         <groupId>org.springframework.boot</groupId>  
         <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        ```
    
        
    
  + https://mp.weixin.qq.com/s?__biz=MzAxMjA0MDk2OA==&mid=2449469000&idx=1&sn=a17b361942bae695ed45775ece1305d6&chksm=8fbca02fb8cb293997ae011e56f1356c598de23886e43369762b16708c1a71102649c92133fe&scene=178&cur_album_id=1338255993817612289#rd









## springcloud Bus消息总线

+ 集成了常用的消息中间件【rabbitmq、kafka】，连接微服务系统中所有的节点，当有数据变更时，可以通过消息代理的=广播通知微服务技师变更数据，例如微服务的配置更新。
+ 解决的是微服务的数据变更与同步问题；







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

  + "通道"是建立在"连接"基础上的，实际开发中"连接"应为全局变量，"通道"为线程级；

  + 一个连接(ip) 可以有多个通道，eg，采用多线程。

  + 一个连接（Connections）可以创建多个通道【采用多线程】；一个应用或者一个线程 都是一个通道（Channel）；在通道中 创建队列Queue

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

##### [RocketMQ、RabbitMQ、KafKa](https://blog.csdn.net/a718515028/article/details/116613960)



----

## springcloud gateway 网关服务

+ [Spring Cloud Gateway](https://links.jianshu.com/go?to=https%3A%2F%2Fgithub.com%2Fspring-cloud%2Fspring-cloud-gateway) 是由 [WebFlux](https://links.jianshu.com/go?to=http%3A%2F%2Fwww.iocoder.cn%2FSpring-Boot%2FWebFlux%2F%3Fself) + [Netty](https://links.jianshu.com/go?to=https%3A%2F%2Fgithub.com%2FYunaiV%2Fnetty) + [Reactor](https://links.jianshu.com/go?to=https%3A%2F%2Fgithub.com%2Freactor%2Freactor) 实现的**响应式**的 API 网关。
  + https://www.jianshu.com/p/dd47605c420d
  + https://www.jianshu.com/p/2ba07a16efa8
  + https://www.jianshu.com/p/757030b16940
  + https://www.jianshu.com/p/bd179178891e
  + https://www.jianshu.com/p/c66509972def
  + https://www.jianshu.com/p/ee06606c927f

+ #### 流量网关与业务网关

  + > **流量网关：**跟具体的后端业务系统和服务完全无关的部分，比如安全策略、全局性流控策略、流量分发策略等。流量网关的功能跟 Web 应用防火墙（WAF）非常类似。WAF一般是基于 Nginx/OpenResty 的 ngx_lua 模块开发的 Web 应用防火墙。
    >
    > **业务网关：**针对具体的后端业务系统，或者是服务和业务有一定关联性的部分，并且一般被直接部署在业务服务的前面。**业务网关一般部署在流量网关之后，业务系统之前，比流量网关更靠近系统**。我们大部分情况下说的 API 网关，狭义上指的是业务网关。并且如果系统的规模不大，我们也会将两者合二为一，使用一个网关来处理所有的工作。

  + ##### 业务网关： = 路由转发 + 过滤器

    - **请求接入：**作为所有 API 接口服务请求的接入点，管理所有的接入请求；
    - **业务聚合：**作为所有后端业务服务的聚合点，所有的业务服务都可以在这里被调用；

    - **中介策略：**实现安全、验证、路由、过滤、流控，缓存等策略，进行一些必要的中介处理；
    - **统一管理：**提供配置管理工具，对所有 API 服务的调用生命周期和相应的中介策略进行统一管理。

  + ##### spring cloud gateway 作为业务网关的一种，整个作用原理如下图[下工作原理图]。

+ 虽然zuul可以通过自定义 Filter 实现我们想要的功能，但是由于 Zuul 本身的设计是基于`单线程的接收请求和转发处理`，是阻塞 IO，不支持长连接。目前来看 Zuul 就显得很鸡肋，随着 Zuul 2.x 一直跳票（2019 年 5 月发布了 Zuul 2.0 版本），Spring Cloud 推出自己的 Spring Cloud Gateway。

+ ##### API 网关在微服务架构中的作用大概是这样的：

  ![img](https://mrhelloworld.com/resources/articles/spring/spring-cloud/zuul/250417-20171207105003644-36470790.png)

  ##### 本项目的网关关注的就是 Aggr API Gateway 这部分，在这里做**聚合服务**的操作。

+ #### zuul的路由请求：

  ~~~xml
     <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
          </dependency>
  ~~~

  ~~~java
  // 开启 Zuul 注解 
  @EnableZuulProxy
  ~~~

  + ##### 路由规则：

    ~~~yml
    zuul:
      routes:
        product-service:              # 路由 id 自定义
          path: /product-service/**   # 配置请求 url 的映射路径
          url: http://localhost:7070/ # 映射路径对应的微服务地址
    ~~~

    | 通配符 | 含义                             | 举例                | 解释                                            |
    | :----- | :------------------------------- | :------------------ | :---------------------------------------------- |
    | ?      | 匹配任意单个字符                 | /product-service/?  | /product-service/a，/product-service/b，...     |
    | *      | 匹配任意数量字符不包括子路径     | /product-service/*  | /product-service/aa，/product-service/bbb，...  |
    | **     | 匹配任意数量字符包括所有下级路径 | /product-service/** | /product-service/aa，/product-service/aaa/b/ccc |

    ~~~yml
    # 路由规则
    zuul:
      routes:
        product-service:              # 路由 id 自定义
          path: /product-service/**   # 配置请求 url 的映射路径
          serviceId: product-service  # 根据 serviceId 自动从注册中心获取服务地址并转发请求
     #简化的路由配置：
    zuul:
      routes:
        product-service:              # 路由 id 自定义
          path: /product-service/**   # 配置请求 url 的映射路径
          serviceId: product-service  # 根据 serviceId 自动从注册中心获取服务地址并转发请求
    #路由排除：
    zuul:
      ignored-patterns: /**/order/**  # URL 地址排除，排除所有包含 /order/ 的路径
      # 不受路由排除影响
      routes:
        product-service:              # 路由 id 自定义
          path: /product-service/**   # 配置请求 url 的映射路径
          serviceId: product-service  # 根据 serviceId 自动从注册中心获取服务地址并转发请求
    #服务名称排除：
    zuul:
      ignored-services: order-service # 服务名称排除，多个服务逗号分隔，'*' 排除所有
      # 不受路由排除影响
      routes:
        product-service:              # 路由 id 自定义
          path: /product-service/**   # 配置请求 url 的映射路径
          serviceId: product-service  # 根据 serviceId 自动从注册中心获取服务地址并转发请求
    #路由前缀：
    zuul:
      prefix: /api
    
    
    # 配置 Eureka Server 注册中心
    eureka:
      instance:
        prefer-ip-address: true       # 是否使用 ip 地址注册
        instance-id: ${spring.cloud.client.ip-address}:${server.port} # ip:port
      client:
        service-url:                  # 设置服务注册中心地址
          defaultZone: http://localhost:8761/eureka/,http://localhost:8762/eureka/
    ~~~


  + #### zuul的过滤功能：

    ![img](https://mrhelloworld.com/resources/articles/spring/spring-cloud/zuul/iht0ibqnf5.png)

    + Zuul 包含了对请求的路由和过滤两个核心功能，其中路由功能负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础；而过滤器功能则负责对请求的处理过程进行干预，是实现请求校验，服务聚合等功能的基础。然而实际上，路由功能在真正运行时，它的路由映射和请求转发都是由几个不同的过滤器完成的。

      + 路由映射主要通过 `pre` 类型的过滤器完成，它将请求路径与配置的路由规则进行匹配，以找到需要转发的目标地址；
      + 而请求转发的部分则是由 `routing` 类型的过滤器来完成，对 `pre` 类型过滤器获得的路由地址进行转发。
      + 所以说，过滤器可以说是 Zuul 实现 API 网关功能最核心的部件，每一个进入 Zuul 的 http 请求都会经过一系列的过滤器处理链得到请求响应并返回给客户端。

    + #### 四个过滤器类型：

      - **pre：请求被路由到源服务器之前执行的过滤器**
        - 身份认证
        - 选路由
        - 请求日志
      - **routing：处理将请求发送到源服务器的过滤器**
      - **post：响应从源服务器返回时执行的过滤器**
        - 对响应增加 HTTP 头
        - 收集统计和度量指标
        - 将响应以流的方式发送回客户端
      - **error：上述阶段中出现错误时执行的过滤器**

  + Spring Cloud Netflix Zuul 中实现过滤器必须包含 4 个基本特征：**过滤器类型**，**执行顺序**，**执行条件**，**动作（具体操作）**。这些步骤都是 `ZuulFilter` 接口中定义的 4 个抽象方法：

    + **filterType**：该函数需要返回一个字符串代表过滤器的类型，而这个类型就是在 http 请求过程中定义的各个阶段。在 Zuul 中默认定义了 4 个不同的生命周期过程类型，具体如下：
      - pre：请求被路由之前调用
      - routing： 路由请求时被调用
      - post：**routing 和 error 过滤器之后被调用**
      - error：处理请求时发生错误时被调用
    + **filterOrder**：通过 int 值来定义过滤器的执行顺序，数值越小优先级越高。
    + **shouldFilter**：返回一个 boolean 值来判断该过滤器是否要执行。
    + **run**：过滤器的具体逻辑。在该函数中，我们可以实现自定义的过滤逻辑，来确定是否要拦截当前的请求，不对其进行后续路由，或是在请求路由返回结果之后，对处理结果做一些加工等。

  + #### zuul的生命周期：

    ![img](https://mrhelloworld.com/resources/articles/spring/spring-cloud/zuul/1010726-20191018040056721-2124170892.png)

    1. HTTP 发送请求到 Zuul 网关；
    2. Zuul 网关首先经过 pre filter
    3. 验证通过后进入 routing filter，接着将请求转发给远程服务，远程服务执行完返回结果，如果出错，则执行 error filter
    4. 继续往下执行 post filter
    5. 最后返回响应给 HTTP 客户端

  + #### zuul & Hystrix：

    + 开启数据监控的项目中要添加 `dashboard` 依赖：

      ```xml
      <!-- spring cloud netflix hystrix dashboard 依赖 -->
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
      </dependency>
      ```

    + 在配置文件中开启 `hystrix.stream` 端点。

      ```yml
      # 度量指标监控与健康检查
      management:
        endpoints:
          web:
            exposure:
              include: hystrix.stream
      ```

    + 在需要开启数据监控的项目启动类中添加 `@EnableHystrixDashboard` 注解。

  + ##### 限流算法

    + ##### 计数器算法：计数器算法是限流算法里最简单也是最容易实现的一种算法。比如我们规定，对于 A 接口来说，我们 1 分钟的访问次数不能超过 100 个。

    + ##### **漏桶算法**其实也很简单，可以粗略的认为就是注水漏水的过程，往桶中以任意速率流入水，以一定速率流出水，当水超过桶流量则丢弃，因为桶容量是不变的，保证了整体的速率。漏桶算法是使用`队列机制`实现的。 　漏桶算法无法应对突发调用。不管上面流量多大，下面流出的速度始终保持不变。

      ![img](https://mrhelloworld.com/resources/articles/spring/spring-cloud/zuul/LeakyBucket.jpg)

    + ##### 令牌桶算法：

      + 令牌桶算法是对漏桶算法的一种改进，漏桶算法能够限制请求调用的速率，而令牌桶算法能够在限制调用的平均速率的同时还允许一定程度的突发调用。

      + 在令牌桶算法中，存在一个桶，用来存放固定数量的令牌。算法中存在一种机制，以一定的速率往桶中放令牌。每次**请求调用需要先获取令牌**，只有**拿到令牌**，才有机会**继续执行**，否则选择选择等待可用的令牌、或者直接拒绝。放令牌这个动作是持续不断的进行，如果桶中令牌数达到上限，就丢弃令牌。

        > 场景大概是这样的：桶中一直有大量的可用令牌，这时进来的请求可以直接拿到令牌执行，比如设置 QPS 为 100/s，那么限流器初始化完成一秒后，桶中就已经有 100 个令牌了，等服务启动完成对外提供服务时，该限流器可以抵挡瞬时的 100 个请求。当桶中没有令牌时，请求会进行等待，最后相当于以一定的速率执行。

    + 当请求通过 Zuul 网关路由到服务，并等待服务返回响应，这个过程中 Zuul 也有超时控制。Zuul 的底层使用的是 Hystrix + Ribbon 来实现请求路由。

      + Zuul 中的 Hystrix 内部使用线程池隔离机制提供请求路由实现，其默认的超时时长为 1000 毫秒。Ribbon 底层默认超时时长为 5000 毫秒。**如果 Hystrix 超时，直接返回超时异常。如果 Ribbon 超时，同时 Hystrix 未超时，Ribbon 会自动进行服务集群轮询重试，直到 Hystrix 超时为止。如果 Hystrix 超时时长小于 Ribbon 超时时长，Ribbon 不会进行服务集群轮询重试。**

  + #### zuul & sentinel：

    单独使用添加 `sentinel-zuul-adapter` 依赖即可。

    　　若想跟 Sentinel Starter 配合使用，需要加上 `spring-cloud-alibaba-sentinel-gateway` 依赖，同时需要添加 `spring-cloud-starter-netflix-zuul` 依赖来让 `spring-cloud-alibaba-sentinel-gateway` 模块里的 Zuul 自动化配置类生效。

    　　同时请将 `spring.cloud.sentinel.filter.enabled` 配置项置为 false（若在网关流控控制台上看到了 URL 资源，就是此配置项没有置为 false）。

    + ##### 自定义限流处理：

      发生限流之后的处理流程 ：

      - 发生限流之后可自定义返回参数，通过实现 `ZuulBlockFallbackProvider` 接口，默认的实现是 `DefaultBlockFallbackProvider`。
      - 默认的 fallback route 的规则是 route ID 或自定义的 API 分组名称。

    + ##### 高可用网关：

      + 实现高可用的主要手段是**数据的冗余备份**和**服务的失效转移**，这两种手段具体可以怎么做呢，在网关里如何体现？主要有以下几个方向：
        - 集群部署、负载均衡、健康检查、节点自动重启、熔断、服务降级、接口重试

+ #### springcloud gateway服务网关

  + #### 核心概念：

    + **路由（Route）**：路由是网关最基础的部分，路由信息由 ID、目标 URI、一组断言和一组过滤器组成。如果断言路由为真，则说明请求的 URI 和配置匹配。
    + **断言（Predicate）**：Java8 中的断言函数。Spring Cloud Gateway 中的断言函数输入类型是 Spring 5.0 框架中的 ServerWebExchange。Spring Cloud Gateway 中的断言函数允许开发者去定义匹配来自于 Http Request 中的任何信息，比如请求头和参数等。
    + **过滤器（Filter）**：一个标准的 Spring Web Filter。Spring Cloud Gateway 中的 Filter 分为两种类型，分别是 Gateway Filter 和 Global Filter。过滤器将会对请求和响应进行处理。

  + #### 工作原理：

    ![img](https://mrhelloworld.com/resources/articles/spring/spring-cloud/gateway/spring_cloud_gateway_diagram.png)

    客户端向 `Spring Cloud Gateway` 发出请求。再由网关处理程序 `Gateway Handler Mapping` 映射确定与请求相匹配的路由，将其发送到网关 Web 处理程序 `Gateway Web Handler`。该处理程序通过指定的过滤器链将请求发送到我们实际的服务执行业务逻辑，然后返回。过滤器由虚线分隔的原因是，过滤器可以在发送代理请求之前和之后运行逻辑。所有 `pre` 过滤器逻辑均被执行。然后发出代理请求。发出代理请求后，将运行 `post` 过滤器逻辑。

  + #### 路由规则：

    + Spring Cloud Gateway 创建 Route 对象时， 使用 RoutePredicateFactory 创建 Predicate 对象，Predicate 对象可以赋值给 Route。

    + 　路由断言工厂 RoutePredicateFactory 包含的主要实现类如图所示，包括 Datetime、 请求的远端地址、 路由权重、 请求头、 Host 地址、 请求方法、 请求路径和请求参数等类型的路由断言。

      ![img](https://mrhelloworld.com/resources/articles/spring/spring-cloud/gateway/20181125155612444.png)

  + #### 动态路由：

    + 动态路由其实就是面向服务的路由，Spring Cloud Gateway 支持与 Eureka 整合开发，根据 serviceId 自动从注册中心获取服务地址并转发请求，这样做的好处不仅可以通过单个端点来访问应用的所有服务，而且在添加或移除服务实例时不用修改 Gateway 的路由配置。

  + #### 服务名称转发：

    + 即使配置了动态获取 URI 的方式，项目中微服务一旦过多几十上百个时，配置中仍然要写很多配置，这时候就可以使用服务名称转发，与服务发现组件进行结合，通过 `serviceId` 转发到具体服务实例。默认匹配URL `/微服务名称/**` 路由到具体微服务。

  + #### 过滤器：

    + Spring Cloud Gateway 根据作用范围划分为 `GatewayFilter` 和 `GlobalFilter`，二者区别如下：

      + `GatewayFilter`：网关过滤器，需要通过 `spring.cloud.routes.filters` 配置在具体路由下，只作用在当前路由上或通过 `spring.cloud.default-filters` 配置在全局，作用在所有路由上。
      + `GlobalFilter`：全局过滤器，不需要在配置文件中配置，作用在所有的路由上，最终通过 `GatewayFilterAdapter` 包装成 `GatewayFilterChain` 可识别的过滤器，它为请求业务以及路由的 URI 转换为真实业务服务请求地址的核心过滤器，不需要配置系统初始化时加载，并作用在每个路由上。

    + ##### 网关过滤器

      网关过滤器用于拦截并链式处理 Web 请求，可以实现横切与应用无关的需求，比如：安全、访问超时的设置等。修改传入的 HTTP 请求或传出 HTTP 响应。Spring Cloud Gateway 包含许多内置的网关过滤器工厂一共有 22 个。

      ![img](https://mrhelloworld.com/resources/articles/spring/spring-cloud/gateway/20181202154250869.png)

    + ##### 全局过滤器：

      全局过滤器不需要在配置文件中配置，作用在所有的路由上，最终通过 GatewayFilterAdapter 包装成 GatewayFilterChain 可识别的过滤器，它是请求业务以及路由的 URI 转换为真实业务服务请求地址的核心过滤器，不需要配置系统初始化时加载，并作用在每个路由上。

      ![img](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210726203800.png)

    + ##### 自定义过滤器：

      + 自定义网关过滤器需要实现以下两个接口 ：`GatewayFilter`，`Ordered`。

    + ##### 自定义全局过滤器：

      + 自定义全局过滤器需要实现以下两个接口 ：`GlobalFilter`，`Ordered`。通过全局过滤器可以实现权限校验，安全性验证等功能。

  + #### Gateway限流：

    + Spring Cloud Gateway 官方提供了 `RequestRateLimiterGatewayFilterFactory` 过滤器工厂，使用 `Redis` 和 `Lua` 脚本实现了令牌桶的方式。

    + ##### 限流规则：

      + URI限流
      + 参数限流
      + IP限流
      + **Sentinel限流**
      + 分组限流

---

## springcloud stream消息驱动

+ #### [核心概念][https://blog.didispace.com/spring-cloud-starter-dalston-7-2/ ]                  [csdn解释](https://jeecg.blog.csdn.net/article/details/106497202)

+ 解决实际开发中系统难免使用多个或途中更改消息中间件，而 stream 就是用来整合消息中间件的工具，从而降低系统于中间件的耦合度。

+ 官方定义为构建消息驱动微服务的框架；应用通过inputs或outputs来与steam中的binder交互，通过配置binding，而stream的binder负责与中间件交互。通过使用spring integration来连接消息代理中间件来实现消息事件驱动。stream为一些供应商的消息中间件产品提供一个个性化的自动化配置实现，引用了发布-订阅，消息组，分区的三个核心概念。【目前只支持rabbitmq、kafka】

+ stream解决了开发人员无感知的使用消息中间件的问题，因为stream对消息中间件的进一步封装，可以做到代码层面度中间件的无感知，甚至于动态的切换中间件。是的微服务开发的高度解耦，服务可以关注更多自己的业务。

  ![image-20210716084009323](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214203.png)

  

  ![image-20210716083744664](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210716214159.png)



+ #### stream的几个重要概念

**Destination Binders**：目标绑定器，目标指的是 kafka 还是 RabbitMQ，绑定器就是封装了目标中间件的包。如果操作的是 kafka 就使用 kafka binder ，如果操作的是 RabbitMQ 就使用 rabbitmq binder。

**Destination Bindings**：外部消息传递系统和应用程序之间的桥梁，提供消息的“生产者”和“消费者”（由目标绑定器创建）

**Message**：一种规范化的数据结构，生产者和消费者基于这个数据结构通过外部消息系统与目标绑定器和其他应用程序通信。





+ #### 消费组

  + ##### 使用消费组实现消息消费的负载均衡[https://blog.didispace.com/spring-cloud-starter-dalston-7-3/]

  + [使用消息分区](https://blog.didispace.com/spring-cloud-starter-dalston-7-4/)

+ #### 异步处理

  比如用户在电商网站下单，下单完成后会给用户推送短信或邮件，发短信和邮件的过程就可以异步完成。因为下单付款是核心业务，发邮件和短信并不属于核心功能，并且可能耗时较长，所以针对这种业务场景可以选择先放到消息队列中，有其他服务来异步处理。

+ #### 应用解耦

  假设公司有几个不同的系统，各系统在某些业务有联动关系，比如 A 系统完成了某些操作，需要触发 B 系统及 C 系统。如果 A 系统完成操作，主动调用 B 系统的接口或 C 系统的接口，可以完成功能，但是各个系统之间就产生了耦合。用消息中间件就可以完成解耦，当 A 系统完成操作将数据放进消息队列，B 和 C 系统去订阅消息就可以了。这样各系统只要约定好消息的格式就好了。

+ #### 流量削峰

  比如秒杀活动，一下子进来好多请求，有的服务可能承受不住瞬时高并发而崩溃，所以针对这种瞬时高并发的场景，在中间加一层消息队列，把请求先入队列，然后再把队列中的请求平滑的推送给服务，或者让服务去队列拉取。

+ #### 日志处理

  kafka 最开始就是专门为了处理日志产生的。

  当碰到上面的几种情况的时候，就要考虑用消息队列了。如果你碰巧使用的是 RabbitMQ 或者 kafka ，而且同样也是在使用 Spring Cloud ，那可以考虑下用 Spring Cloud Stream。





---

## Elasticsearch

+ **Elasticsearch 简称 ES**：实时的分布式搜索和分析引擎，它可以用于全文搜索，结构化搜索以及分析。建立在全文搜索引擎 Apache Lucene 基础上的搜索引擎，使用 Java 语言编写。



https://mrhelloworld.com/elasticsearch-search/

https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html

https://mrhelloworld.com/docker5/#elasticsearch

https://www.cnblogs.com/shoufeng/p/9934436.html

https://blog.csdn.net/weixin_33092023/article/details/80765775

+ ####  [IK](https://github.com/medcl/elasticsearch-analysis-ik) 分词：

  + `ik_max_word`：会将文本做最细粒度的拆分，比如会将“中华人民共和国国歌”拆分为“中华人民共和国,中华人民,中华,华人,人民共和国,人民,人,民,共和国,共和,和,国国,国歌”，会穷尽各种可能的组合，适合 Term Query。
  + `ik_smart`：会将文本做最粗粒度的拆分，比如会将“中华人民共和国国歌”拆分为“中华人民共和国,国歌”，适合 Phrase Query。

+ #### 倒排索引：

  - **正排索引**是文档 ID 到文档内容、单词的关联关系。也就是说通过 ID 获取文档的内容。
  - **倒排索引**是单词到文档 ID 的关联关系。也就是说通过单词搜索到文档 ID。
  - **倒排索引**的查询流程是：首先根据关键字搜索到对应的文档 ID，然后根据正排索引查询文档 ID 的完整内容，最后返回给用户想要的结果

+ #### 组成：

  ##### 倒排索引是搜索引擎的核心，主要包含两个部分：

  + 单词词典（Trem Dictionary）：记录所有的文档分词后的结果。**一般采用 B+Tree 的方式，来保证高效**。
  + 倒排列表（Posting List）：记录单词对应的文档的集合，由倒排索引项（Posting）组成。

  ##### 倒排索引项（Posting）主要包含如下的信息：

  + 文档 ID，用于获取原始文档的信息。
  + 单词频率（TF，Term Frequency），记录该单词在该文档中出现的次数，用于后续相关性算分。
  + 位置（Position），记录单词在文档中的分词位置（多个），用于做词语搜索。
  + 偏移（Offset），记录单词在文档的开始和结束位置，用于高亮显示。

















## netty





## undertow容器











## swagger

## 锁

+ [锁](https://github.com/biezhi/learn-java8/blob/master/java8-concurrent/README.md)





## 重温MVC框架

[SpringMVC 包教包会](https://www.cnblogs.com/lenve/p/12100698.html)

+  Web MVC 设计模式的请求驱动类型的轻量级 Web 框架
+  基于请求驱动指的就是使用请求-响应模型，框架的目的就是帮助我们简化开发
+  提供了非常灵活的数据验证、格式化和数据绑定机制；提供了强大的约定大于配置（惯例优先原则）的契约式编程支持。

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



---

## Docker

+ #### Docker的应用场景

  + Web 应用的自动化打包和发布。
  + 自动化测试和持续集成、发布。
  + 在服务型环境中部署和调整数据库或其他的后台应用。
  + 从头编译或者扩展现有的 OpenShift 或 Cloud Foundry 平台来搭建自己的 PaaS 环境。

+ #### Docker 的优点

  Docker 是一个用于开发，交付和运行应用程序的开放平台。Docker 使您能够将应用程序与基础架构分开，从而可以快速交付软件。借助 Docker，您可以与管理应用程序相同的方式来管理基础架构。通过利用 Docker 的方法来快速交付，测试和部署代码，您可以大大减少编写代码和在生产环境中运行代码之间的延迟。

Docker的应用场景

#### Docker的应用场景





https://mrhelloworld.com/docker5/#elasticsearch

https://xie.infoq.cn/article/c6ba952182d9b4338be73a0be

https://xie.infoq.cn/article/228886d139aabfb286a1ab971

https://www.cnblogs.com/linjiqin/p/8608975.html

https://www.cnblogs.com/xhyan/p/6593075.html



+ ## 错误归纳：

  + ###### BeanPostProcessor before instantiation of bean failed; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/tools/PointcutPrimitive

    原因：缺少aspectj依赖：

    ```xml
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
  
  + SpringCloud集成 报错 An attempt was made to call a method that does not exist. The attempt was made from the following location:...
  
  > springboot 与 springcloud版本冲突~
    >
    > https://blog.csdn.net/qq_29950673/article/details/102621679
    >
    > https://zhuanlan.zhihu.com/p/147899433
  
  ----
  
  + ##### Eureka Server 加上安全认证之后，服务无法注册
  
    > Request execution failed with message: com.fasterxml.jackson.databind.exc.MismatchedInputException: Root name 'timestamp' does not match expected ('instance') for type [simple type, class com.netflix.appinfo.InstanceInfo]
    >
    > + 解决：**新版本的security默认开启csrf了，关掉**，在注册中心新建一个类，继承WebSecurityConfigurerAdapter来关闭
    >
    >   ```java
    >   package com.rrw.eureka.server.conf;
    >   import org.springframework.beans.factory.annotation.Value;
    >   import org.springframework.context.annotation.Bean;
    >   import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
    >   import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    >   import org.springframework.security.config.annotation.web.builders.WebSecurity;
    >   import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    >   import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
    >   import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    >   
    >   /**
    >    * 开启 security 时才需要
    >    */
    >   @EnableWebSecurity
    >   class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    >       @Value("${spring.security.user.name}")
    >       private String userName;
    >       @Value("${spring.security.user.password}")
    >       private String password;
    >       @Bean
    >       public BCryptPasswordEncoder passwordEncoder() {
    >           return new BCryptPasswordEncoder();
    >       }
    >       @Override
    >       protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    >   auth.inMemoryAuthentication().withUser(userName).password(passwordEncoder().encode(password)).roles("ADMIN");
    >       }
    >       @Override
    >       public void configure(WebSecurity web) throws Exception {
    >           super.configure(web);
    >       }
    >   ```
  >       @Override
  >       protected void configure(HttpSecurity http) throws Exception {
  >           http.csrf().ignoringAntMatchers("/eureka/**");
  >           super.configure(http);
  >       }
  >       }
  
  ----
  
+ ##### 高可用注册中心搭建注意事项：【https://www.cnblogs.com/clwydjgs/p/9290075.html】
  
    + **client.registerWithEureka 和 client.registerWithEureka 设置为 true**，表示要注册到 eureka 。单点模式中设置为 false。高可用版本要允许注册到 eureka 。注意：eureka-center1 和 eureka-center2 的 serviceUrl.defaultZone 是互相注册的。
    
    + ##### 两个配置文件：
    
      ![image-20210719161118353](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210726203735.png)
    
      ```yml
      spring:
        profiles: eureka-center1/2
      server:
        port: 8761/8762
      eureka:
        instance:
          hostname: ha-eureak-center1/2
        appname: 注册中心
        client:
        registerWithEureka: true
          fetchRegistry: true
        serviceUrl:
            defaultZone: http://localhost:8762/eureka  /  http://localhost:8761/eureka
      ```
      
  + ##### VM配置：
  
      ![image-20210719161313949](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210726203715.png)
  
    + ##### 并且配置文件与配置文件中的名字最好一致，VM参数配置也是，不然找不到注册服务，暂时不清楚原因。
  
      ![image-20210719162011505](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210726203709.png)
  
    + ##### 再分别启动两个application能看到：
    
      ![image-20210719161419037](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210726203720.png)
  
  ---
  
  + #### DataSource默认数据源异常：
  
      ~~~java
      @Autowire
      private DataSource datasource;
      ~~~
  
      > **Field dataSource in com.rrw.oauth.config.oautho2Config required a bean of type 'javax.sql.DataSource' that could not be found.**
      >
      > The injection point has the following annotations:
      >
      > 	- @org.springframework.beans.factory.annotation.Autowired(required=true)
      >
      > The following candidates were found but could not be injected:
      > 	- Bean method 'dataSource' in 'JndiDataSourceAutoConfiguration' not loaded **because** @ConditionalOnClass did not find required class 'org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType'
      > 	- Bean method 'dataSource' in 'XADataSourceAutoConfiguration' not loaded **because** @ConditionalOnClass did not find required class 'javax.transaction.TransactionManager'
      >
      >
      > Action:
      >
      > Consider revisiting the entries above or defining a bean of type 'javax.sql.DataSource' in your configuration.
  
      缺少JDBC与Mysql连接的依赖：
  
      ~~~xml
              <dependency>
                  <groupId>mysql</groupId>
                  <artifactId>mysql-connector-java</artifactId>
              </dependency>
              <dependency>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-starter-jdbc</artifactId>
              </dependency>
      ~~~
  
  ---
  
  + ###### ‘org.springframework.web.client.RestTemplate‘ that could not be found【https://blog.csdn.net/weixin_44259720/article/details/109216423】







---





















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



---

## 注解：

```java
@RequestParam("id")
@PathVariable("id")
@Bean
@Component、@service、@controller、@Repository [https://www.jianshu.com/p/8d3f5cede6bf]
@LoadBalanced
@Document 注解用于映射 Elasticsearch 索引库。
@Select--import org.apache.ibatis.annotations.Select;
@Repository   @Resource与@autowire的区别
@EnableAuthorizationServer -- oauth-config
@Order标记定义了组件的启动顺序，值越小拥有越高的优先级，可为负数；定义Spring IOC容器中Bean的执行顺序的优先级，而不是定义Bean的加载顺序，Bean的加载顺序不受@Order或Ordered接口的影响；
@Primary
@EnableWebSecurity注解修饰，并继承自WebSecurityConfigurerAdapter类。这个类的重点就是声明 PasswordEncoder 和 AuthenticationManager两个 Bean。稍后会用到。其中 BCryptPasswordEncoder是一个密码加密工具类，它可以实现不可逆的加密，AuthenticationManager是为了实现 OAuth2 的 password 模式必须要指定的授权管理 Bean。
@SneakyThrows从字面理解就是“偷偷摸摸的抛出”。该注解属于Lombok，它的作用为减少程序的异常捕获。
@Configuration
@Builder:是一种无需编写样板代码即可使用Builder 模式的有用机制。我们可以将此注释应用于类或方法。[https://www.jianshu.com/p/d08e255312f9]
@Accessors(chain = true)
@inner迫使一个命名空间的成员被描述作为内部成员（默认情况下，这是一个静态成员）。
@Valid用于验证注解是否符合要求，直接加在变量user之前，在变量中添加验证信息的要求，当不符合要求时就会在方法中返回message 的错误提示信息。[https://blog.csdn.net/weixin_38118016/article/details/80977207]
```

#### Component与Bean注解：

+ @Component注解表明一个类会作为组件类，并告知Spring要为这个类创建bean。

+ @Bean注解告诉Spring这个方法将会返回一个对象，这个对象要注册为Spring应用上下文中的bean。通常方法体中包含了最终产生bean实例的逻辑。
  + 两者的目的是一样的，都是注册bean到Spring容器中。
  + @Component和@Bean都是用来注册Bean并装配到Spring容器中，但是Bean比Component的自定义性更强。可以实现一些Component实现不了的自定义加载类。

##### @Async异步调用：

+ 在处理与第三方系统交互的时候，容易造成响应迟缓的情况，之前大部分都是使用多线程来完成此类任务，在`spring 3.x`之后，就已经内置了`@Async`来解决这个问题。

+ 同一个类中，一个方法调用另外一个有@Async的方法，该注解是不会生效的。注解本质使用的是动态代理，因为调用方法的是对象本身而不是代理对象，因为没有经过Spring容器，所以也就不会生效。

+ ##### 异步调用：

  > 异步调用则是只是发送了调用的指令，调用者无需等待被调用的方法完全执行完毕；而是继续执行下面的流程。

+ ##### 常规的异步调用处理方式：

  + 也就是基于创建独立的线程去完成相应的异步调用逻辑，通过主线程和不同的线程之间的执行流程，从而在启动独立的线程之后，主线程继续执行而不会产生停滞等待的情况。
  + 在Spring中，基于`@Async`标注的方法，称之为异步方法；这些方法将在执行的时候，将会在独立的线程中被执行，调用者无需等待它的完成，即可继续其他的操作。

##### @Cacheable

+ 第一次调用这个方法时，返回的数据能被放到服务器端的缓存里，以便于后面要调用这个方法时，能直接从缓存里取到，这样就不用再查数据库占用资源了。

+ **刷新数据不更新时，记得看看是不是因为有`@Cacheable`。对于频繁变化的数据就不要加缓存**

+ 当一个支持缓存的方法在**对象内部被调用时是不会触发缓存功能**的。注解本质使用的是动态代理，因为调用方法的是对象本身而不是代理对象，因为没有经过Spring容器，所以也就不会生效。

+ ##### `@Cacheable`可以指定三个属性:`value、key和condition`：

  |   参数    |                             解释                             |                           example                            |
  | :-------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
  |   value   | 缓存的名称，在 spring 配置文件中定义，必须指定至少一个;表示当前方法的返回值是会被缓存在哪个Cache上 | 例如:·@Cacheable(value=”mycache”)     、@Cacheable(value={”cache1”,”cache2”} |
  |    key    | 缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合;用来指定Spring缓存方法的返回结果时对应的key。 |        @Cacheable(value=”testcache”,key=”#userName”)         |
  | condition | 缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存。有的时候我们可能并不希望缓存一个方法所有的返回结果。通过condition属性可以实现这一功能 | @Cacheable(value=”testcache”,condition=”#userName.length()>2”) |

+ ##### @CacheEvict:

  + 是用来标注在需要清除缓存元素的方法或类上的。当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。`@CacheEvict`可以指定的属性有`value、key、condition、allEntries和beforeInvocation。[https://www.jianshu.com/p/202331ae068a]

+ ##### @Autowired

  + 多数情况我们用`@Autowired`自动从Spring容器里面装配一个对象。如果添加了`Component`注解并且`instanceof`是这个类型的只有一个类就自动装配进去，如果有多个，需要在`@Component("name")`加上名字，然后`@Autowired`的变量名字是该名称即可指定装配哪个具体实现类。

  + ##### 定义集合对象List、Map:

    + 会把该类的所有在容器内的子类（必须加了`@Component`）都装配到集合里面。
      定义下面的这个 `List`属性，当服务启动的时候会自动装配`BzPackageIndex`下面的两个子类。

      ```java
          @Autowired
          private List<BzPackageIndex> indexList;//会把此类所有的子类bean从IOC容器自动取出后放到list里面。
      //很多时候一个@Service有好几个实现类，我可以通过这种方式把实现类放到一个缓存的map里面，后期通过子类的一个标识符key拿到具体的Service来操作。
      ```

+ #### @Data

  + 相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode这5个注解的合集。
  + @EqualsAndHashCode 重写了hashcode和equals方法；
  + **默认仅使用该类中定义的属性且不调用父类的方法** 。比如，有多个类有相同的部分属性，把它们定义到父类中，恰好id（数据库主键）也在父类中，那么就会存在部分对象在比较时，它们并不相等，却因为lombok自动生成的equals(Object other) 和 hashCode()方法判定为相等，从而导致出错。——>**使用在使用@Data时同时加上@EqualsAndHashCode(callSuper=true)注解。**

+ #### @PreAuthorize自定义鉴权https://blog.csdn.net/qq_42507357/article/details/107997549

  是可以用来控制一个方法或类是否能够被调用的，通俗一点就是看看你有没有权利用被注解的东西。









## Nginx

#### 配置路由规则：

~~~c++
  server {
        listen       80;
        server_name  localhost;

        ...

        # 路由到商品服务
        location /api-product {
            proxy_pass http://localhost:7070/;
        }

        # 路由到订单服务
        location /api-order {
            proxy_pass http://localhost:9090/;
        }

        ...
    }
~~~





## 本周任务：

https://www.bilibili.com/video/BV1R54y1J74K?p=58&spm_id_from=pageDriver

https://www.bilibili.com/video/BV1eE41187Ug?p=1

https://www.bilibili.com/video/BV18K4y1Q7Ez?p=1





![image-20210726212400207](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20210726212409.png)

https://www.dockerchina.cn/?id=80

https://zhuanlan.zhihu.com/p/90419842

https://zhuanlan.zhihu.com/p/88421654

https://github.com/Zealon159/light-reading-cloud-client

https://github.com/Zealon159/light-reading-cloud



## Reactor

+ ##### 1. 和原来的阻塞式编程的对应关系

  返回值，原来返回List<xxxx>的地方变成Flux<xxxx>，原来返回单个对象的地方变成Mono<xxxx>。
  Flux就是List的一种变式，Mono表示单个对象。

+ ##### 2.由于WebFlux 是响应式的， 所以从DAO 到Service 再到 Controller ，层层之间都必须是响应式的，层与层之前数据交互处理都只能是Mono和Flux

  这样就导致了很多阻塞式的框架无法使用，所以传统的关系型数据库框架(JDBC、JPA) 都无法使用（其实已经有了RxJDBC，但是要你去直接操作JDBC，太麻烦了，只要跟数据库相关的，基本都没有办法搞响应了）

+ ##### 3. Mono的三个阶段：

  + ##### （1） Mono创建

    首先是Mono.just()，直接由这个对象构造出一个Mono。
     然后Mono.fromRunnable(），用一个线程来构建一个Mono。

    ##### （2） Mono中间处理阶段

    + flatMap（把一个Mono处理一下变成另一个Mono，意思是这后面可以接着加点什么什么，继续链式处理）
    + Map（这个Mono直接就变成了普通对象，后面接不上了）
    + then（这个只是时间上的先后，并不是逻辑上的处理先后，就是then处理前后并不是一个变量，then接收一个变量，然后then前面处理的那个就结束了，后面开始处理then接收的这个变量）

    ##### （3） Mono结束

    这个基本不用你管，你只要返回一个Mono对象，Spring自动就帮你处理后续的。

+ ### Reactor-Netty:

  ##### [Netty](https://zhuanlan.zhihu.com/p/181239748)

-----

### c-auth

认证服务器配置适配类AuthorizationServerConfigurerAdapter类，r只是一个提供给开发配置ClientDetailsServiceConfigurer、AuthorizationServerEndpointsConfigurer、AuthorizationServerSecurityConfigurer空壳类并没有持有以上三个配置Bean对象。

##### 重写配置三个configure()方法：

+ **ClientDetailsServiceConfigurer回调配置**

  主要是注入ClientDetailsService实例对象（唯一配置注入）。其它地方可以通过ClientDetailsServiceConfigurer调用开发配置的ClientDetailsService。系统提供的二个ClientDetailsService实现类：JdbcClientDetailsService、InMemoryClientDetailsService。

+ **AuthorizationServerEndpointsConfigurer端点配置**

  AuthorizationServerEndpointsConfigurer其实是一个装载类，装载Endpoints所有相关的类配置（AuthorizationServer、TokenServices、TokenStore、ClientDetailsService、UserDetailsService）。

+ **AuthorizationServerSecurityConfigurer端点安全配置**

  AuthorizationServerSecurityConfigurer继承SecurityConfigurerAdapter.也就是一个 Spring Security安全配置提供给AuthorizationServer去配置AuthorizationServer的端点（/oauth/****）的安全访问规则、过滤器Filter。

+ TokenStore：token管理服务。

  TokenEnhancer：token信息的额外信息处理。

+ ##### 两个成功失败处理器：

  ###### AUTHENTICATIONSUCCESSHANDLER、AUTHENTICATIONFAILUREHANDLER

## c-gateway

+ ##### @FunctionnalInterface

函数式接口：@FunctionalInterface ,该注解只能标记在”有且仅有一个抽象方法”的接口上。

@FunctionalInterface标记在接口上，“函数式接口”是指仅仅只包含一个抽象方法的接口。主要用于**编译级错误检查**，加上该注解，当你写的接口不符合函数式接口定义的时候，编译器会报错。

+ #### @controller  @RestController 与 @RouterFunction

  + **在功能领域，Web 服务被称为路由**，*@* *Controller*和*@RequestMapping*的传统概念被*RouterFunction*取代。

  + ```java
    @RestController
    public class ProductController {
    
        @RequestMapping("/product")
        public List<Product> productListing() {
            return ps.findAll();
        }
    }
    
    //等价于：
    @Bean
    public RouterFunction<ServerResponse> productListing(ProductService ps) {
        return route().GET("/product", req -> ok().body(ps.findAll()))
          .build();  //route() 上使用 GET() 方法来指定这是一个GET请求，路径以字符串形式提供
    }
    ```

  + 我们应该注意到，在函数式方法中，*productListing()*方法返回的是*RouterFunction*而不是响应体。**它是路由的定义，而不是请求的执行。**

    所述*RouterFunction*包括路径，请求头，一个处理功能，这将被用于生成响应主体和响应标头。它可以包含单个或一组 Web 服务。

    当我们查看嵌套路由时，我们将更详细地介绍 Web 服务组。

    在这个例子中，**我们使用了\*RouterFunctions 中\*的静态 route() 方法来创建一个\*RouterFunction\*。**可以使用此方法提供路由的所有请求和响应属性。

  + **当我们想要指定请求的更多细节时，我们也可以使用RequestPredicate:```RequestPredicates.path("/product")```

  + ##### 创建一个路由函数，将*/hello*请求路由到传入处理程序中名为*handleRequest*的方法：

    ```java
    @Bean
    public RouterFunction<ServerResponse> routeRequest(Handler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/hello")
          .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), 
            handler::handleRequest);
        }
    ```

    ###### [Spring Boot 响应式 WebFlux 入门](https://www.jianshu.com/p/72d541c36f4d)

    ###### [SpringBoot中的响应式web应用](https://www.jianshu.com/p/56dfb1367b5b)

----

## c-ups

+ #### 回调与确认

  + ##### Queue

    - 队列，用于储存消息，先入先出，prefetchCount限制平分给消费者的消息个数

  + ##### Exchange

    - 交换机，生产者生产的消息先经过交换机，再路由到一个或多个Queue，这个过程通过binding key完成
    - Exchange交换类别
      - fanout：会把所有发到Exchange的消息路由到所有和它绑定的Queue
      - direct：会把消息路由到routing key和binding key完全相同的Queue，不相同的丢弃
      - topic：direct是严格匹配，那么topic就算模糊匹配，routing key和binding key都用.来区分单词串，比如A.B.C，*匹配任意单词，#匹配任意多个或0个单词，比如*。B.*可以匹配到A.B.C
      - headers：不依赖routing key和binding key，通过对比消息属性中的headers属性，对比Exchange和Queue绑定时指定的键值对，相同就路由过来。

+ ##### RabbitTemplate.ReturnCallBack:

  生产者发送消息的时候，需要通过exchange+queue，那么这个过程中就可能出现收不到或者是路由不成功的情况。就需要通过发送返回状态来进行，完整性的处理。

  + ##### 实际业务流程：DB--发送（Producer==>Exchange==>Queue==>Consumer)

  + ##### 回调时调用ReturnCallBack【ReturnsCallBack】与confirmCallBack

    + ##### 消息发送确认

      ###### 发送的消息怎么样才算失败或成功？如何确认？

      当消息无法路由到队列时，确认消息路由失败。消息成功路由时，当需要发送的队列都发送成功后，进行确认消息，对于持久化队列意味着写入磁盘，对于镜像队列意味着所有镜像接收成功

      ##### ConfirmCallback

      + 通过实现 ConfirmCallback 接口，消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中。

      ##### ReturnCallback

      - 通过实现 ReturnCallback 接口，启动消息失败返回，比如路由不到队列时触发回调。

    + ##### 消息接收确认....【https://www.jianshu.com/p/2c5eebfd0e95】【https://blog.csdn.net/qq_33589510/article/details/106258270】

+ ##### convertAndSend 与 convertSendAndReceive

  + **convertSendAndReceive**(…)：可以同步消费者。使用此方法，当确认了所有的消费者都接收成功之后，才触发另一个convertSendAndReceive(…)，也就是才会接收下一条消息。RPC调用方式。

    **convertAndSend**(…)：使用此方法，交换机会马上把所有的信息都交给所有的消费者，消费者再自行处理，不会因为消费者处理慢而阻塞线程。

+ #### Iservice接口的CRUD

  [https://mp.baomidou.com/guide/crud-interface.html#update]

+ #### Model通过实体进行CRUD

  [https://blog.csdn.net/lp840312696/article/details/106707969]

+ #### IPage分页插件

  [https://mp.baomidou.com/guide/page.html]

+ #### RedisTemplate 与 StringRedisTemplate

  [https://blog.csdn.net/lydms/article/details/105224210]

+ 