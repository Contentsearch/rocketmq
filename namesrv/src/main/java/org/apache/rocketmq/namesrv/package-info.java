/*
 *NameServer是一个简单的 Topic 路由注册中心
 * 支持 Topic、Broker 的动态注册与发现。
 * 主要包括两个功能：
 *
 * * Broker管理，NameServer接受Broker集群的注册信息并且保存下来作为路由信息的基本数据。
 *   然后提供心跳检测机制，检查Broker是否还存活；
 * * route 路由信息管理，每个NameServer将保存关于 Broker 集群的整个路由信息和用于客户端查询的队列信息。
 *   Producer和Consumer通过NameServer就可以知道整个Broker集群的路由信息，从而进行消息的投递和消费。
 *
 * NameServer通常会有多个实例部署，各实例间相互不进行信息通讯。Broker是向每一台NameServer注册自己的路由信息，
 * 所以每一个NameServer实例上面都保存一份完整的路由信息。当某个NameServer因某种原因下线了，客户端仍然可以向其它NameServer获取路由信息。
 *
 *Namesrv组件
 *  KVConfigManager：KV配置管理
 *    key-value配置管理，增删改查
 *  RouteInfoManager：路由信息管理
 *   Broker注册，提供Broker信息（名字、角色编号、地址、集群名）
 *   Topic注册， 提供Topic信息（Topic名、读写权限、队列情况）
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * @Description: package-info
 * @Date: 2024/5/29
 */
package org.apache.rocketmq.namesrv;