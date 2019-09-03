# Java应用性能远程监控系统

适用于监控所有Java应用，具有堆内存监控、方法区监控、GC监控、类加载监控、类编译监控与线程监控，提供堆快照下载，线程快照下载。服务器性能信息查看

## 一、简介

JAVAMonitorPlus基于https://github.com/yueshutong/JavaMonitor修改增加了登录，使用权限管理和服务器性能信息查看，并将部分监控功能改为JMX处理。在今后的版本中将完善使用JMX监控应用程序性能

## 二、环境

要求JDK8及以上，必须有Java环境变量，且Java环境变量不冲突！

## 三、使用

在需要监控的主机上运行 client即可，默认8081端口，端口可以在application.properties配置文件修改。

然后，在作为监控中心的主机上运行 server.，默认8888端口，端口可以在application.properties配置文件修改。

## 四、主机

配置监控的主机非常简单，只需要在jar包所在目录下新建application.properties文件，配置以下字段即可。

```properties
monitor.serve[0].name=serve-1
monitor.serve[0].address=http://127.0.0.1:8081
monitor.serve[1].name=serve-1
monitor.serve[1].address=http://127.0.0.1:8082
```

注意：一定要写明HTTP协议！name值若不写，默认就是主机地址。

## 五、监控

默认监控频率为60秒，并且只记录当天产生的监控数据。

如果需要自定义监控频率与监控时长，只需要在jar包所在目录下新建application.properties文件，修改下列字段即可

```
monitor.rate=60 #监控频率/秒
monitor.cron=0 0 0 * * ? #每日的0:00:00时刻清空数据
```

连续监控1个月，示例

```
monitor.cron=0 0 0 1 * ?
```

连续监控1年，示例

```
monitor.cron=0 0 0 1 1 ? *
```

## 六、MySQL

不过JMP提供MySQL数据库的支持并使用MyBatis Plus框架。


## 七、监控参数

- S0C：s0（from）的大小
- S1C：s1（from）的大小
- S0U：s0（from）已使用的空间
- S1U：s1(from)已经使用的空间
- EC：eden区的大小
- EU：eden区已经使用的空间
- OC：老年代大小
- OU：老年代已经使用的空间
- MC：元空间的大小（Metaspace）
- MU：元空间已使用大小
- CCSC：压缩类空间大小（compressed class space）
- CCSU：压缩类空间已使用大小
- YGC：新生代gc次数
- YGCT：新生代gc耗时
- FGC：Full gc次数
- FGCT：Full gc耗时
- GCT：gc总耗时
- Loaded：表示载入了类的数量
- Unloaded：表示卸载类的数量
- Compiled：表示编译任务执行的次数
- Failed：表示编译失败的次数
- Total：线程总数
- Runnable：正在运行的线程数
- Sleeping：休眠的线程数
- Waiting：等待的线程数
