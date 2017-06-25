# spring-message
在Spring中使用JMS和AMQP，代码示例，学习笔记

## JMS使用
1. 到ActiveMQ官网下载http://activemq.apache.org/download.html 二进制文件，使用windows为例
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

## AMQP使用
1. 在RabbitMQ官网[https://www.rabbitmq.com/download.html](https://www.rabbitmq.com/download.html)下载RabbitMQ
2. 安装RabbitMQ, 需要提前安装Erlang，可以去Erlang官网[http://www.erlang.org/downloads](http://www.erlang.org/downloads)下载安装
3. 通过命令行cd到/sbin下
4. RabbitMQ启动关闭命令
```bash
# 启动
./rabbitmq-server
# 后台运行
./rabbitmq-server -detached
# 通知RabbitMQ干净地关闭，并保护好那些持久化队列
./rabbitmqctl stop
# 创建用户bnade
 ./rabbitmqctl.bat add_user bnade cashMel
# 删除用户
 ./rabbitmqctl.bat delete_user bnade
# 查看当前存在哪些用户
./rabbitmqctl.bat list_users
# 修改用户的密码
./rabbitmqctl.bat change_password bnade 123456
# 查看用户在RabbitMQ服务器所有vhost上的权限
./rabbitmq.bat list_user_permissons bnade

# 列出队列和消息数目
./rabbitmqctl.bat list_queues
# 查看交换器和绑定
./rabbitmqctl.bat list_exchanges
```