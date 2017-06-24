# spring-message
在Spring中使用JMS和AMQP，代码示例，学习笔记

## JMS使用
1. 到ActiveMQ官网下载http://activemq.apache.org/download.html二进制文件，使用windows为例
2. 解压下载的文件到目录
3. 通过命令行cd到目录/bin下
4. 通过以下命令启动
```bash
./activemq.bat start
```

Jms.java 使用传统方式发送和接受消息

AlertServiceImpl 使用Spring的JmsTemplate来发送和接受消息，这种方式接受消息是同步的，当队列中没有消息是会阻塞线程直到接受到新消息或者线程超时

BnadeAlertHandler 异步接受消息，需要在配置文件中配置消息监听器，当队列中有新的消息时自动调用处理器，实现异步

为了支持基于消息的RPC， Spring提供JmsInvokerServiceExporter把bnean导出为RMI服务

JMS消息支持String, byte array, Map<String,?>, Serializable object

ActiveMQ 5.12.2 and 5.13.0之后版本，发送Serializable对象，需要在connectionFactory中配置这些对象的包为trust packages