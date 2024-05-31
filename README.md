## Apache RocketMQ [![Build Status](https://travis-ci.org/apache/rocketmq.svg?branch=master)](https://travis-ci.org/apache/rocketmq) [![Coverage Status](https://coveralls.io/repos/github/apache/rocketmq/badge.svg?branch=master)](https://coveralls.io/github/apache/rocketmq?branch=master)
[![GitHub release](https://img.shields.io/badge/release-download-orange.svg)](https://rocketmq.apache.org/dowloading/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

**[Apache RocketMQ](https://rocketmq.apache.org) is a distributed messaging and streaming platform with low latency, high performance and reliability, trillion-level capacity and flexible scalability.**

<<<<<<< HEAD
[文档地址](https://rocketmq.apache.org/zh/docs/4.x/introduction/03whatis)  
阅读 rocketmq源码，并加上自己的注释和理解，再结合网上一些分析资料，摘抄一些流程图 

## RocketMQ的部署模型
![部署架构](https://rocketmq.apache.org/zh/assets/images/RocketMQ%E9%83%A8%E7%BD%B2%E6%9E%B6%E6%9E%84-ee0435f80da5faecf47bca69b1c831cb.png)

## 生产者 Producer
发布消息的角色。Producer通过 MQ 的负载均衡模块选择相应的 Broker 集群队列进行消息投递，投递的过程支持快速失败和重试。

## 消费者 Consumer
消息消费的角色。

- 支持以推（push），拉（pull）两种模式对消息进行消费。
同时也支持集群方式和广播方式的消费。
- 提供实时消息订阅机制，可以满足大多数用户的需求。
## NameServer
NameServer是一个简单的 Topic 路由注册中心，支持 Topic、Broker 的动态注册与发现。

主要包括两个功能：

- Broker管理，NameServer接受Broker集群的注册信息并且保存下来作为路由信息的基本数据。然后提供心跳检测机制，检查Broker是否还存活；
- 路由信息管理，每个NameServer将保存关于 Broker 集群的整个路由信息和用于客户端查询的队列信息。Producer和Consumer通过NameServer就可以知道整个Broker集群的路由信息，从而进行消息的投递和消费。

NameServer通常会有多个实例部署，各实例间相互不进行信息通讯。Broker是向每一台NameServer注册自己的路由信息，所以每一个NameServer实例上面都保存一份完整的路由信息。当某个NameServer因某种原因下线了，客户端仍然可以向其它NameServer获取路由信息。

=======
[文档地址](https://rocketmq.apache.org/zh/docs/4.x/introduction/03whatis)
## RocketMQ的部署模型
![部署架构](https://rocketmq.apache.org/zh/assets/images/RocketMQ%E9%83%A8%E7%BD%B2%E6%9E%B6%E6%9E%84-ee0435f80da5faecf47bca69b1c831cb.png)

## 生产者 Producer
发布消息的角色。Producer通过 MQ 的负载均衡模块选择相应的 Broker 集群队列进行消息投递，投递的过程支持快速失败和重试。

## 消费者 Consumer
消息消费的角色。

- 支持以推（push），拉（pull）两种模式对消息进行消费。
同时也支持集群方式和广播方式的消费。
- 提供实时消息订阅机制，可以满足大多数用户的需求。
## NameServer
NameServer是一个简单的 Topic 路由注册中心，支持 Topic、Broker 的动态注册与发现。

主要包括两个功能：

- Broker管理，NameServer接受Broker集群的注册信息并且保存下来作为路由信息的基本数据。然后提供心跳检测机制，检查Broker是否还存活；
- 路由信息管理，每个NameServer将保存关于 Broker 集群的整个路由信息和用于客户端查询的队列信息。Producer和Consumer通过NameServer就可以知道整个Broker集群的路由信息，从而进行消息的投递和消费。

NameServer通常会有多个实例部署，各实例间相互不进行信息通讯。Broker是向每一台NameServer注册自己的路由信息，所以每一个NameServer实例上面都保存一份完整的路由信息。当某个NameServer因某种原因下线了，客户端仍然可以向其它NameServer获取路由信息。

>>>>>>> f61de72 (add: first)
## 代理服务器 Broker
Broker主要负责消息的存储、投递和查询以及服务高可用保证。

NameServer几乎无状态节点，因此可集群部署，节点之间无任何信息同步。Broker部署相对复杂。

在 Master-Slave 架构中，Broker 分为 Master 与 Slave。一个Master可以对应多个Slave，但是一个Slave只能对应一个Master。Master 与 Slave 的对应关系通过指定相同的BrokerName，不同的BrokerId 来定义，BrokerId为0表示Master，非0表示Slave。Master也可以部署多个。
