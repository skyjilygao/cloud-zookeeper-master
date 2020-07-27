# cloud-zookeeper-master
## cloud-zk-consumer 服务消费者
对外提供接口，接收请求后访问相应提供者中的服务

利用RestTemplate实现负载均衡

## cloud-zk-provider 服务提供者
启动多个provider时需要保证同台机器端口不同，否则提示端口占用，或在多台机器上启动。



参考：
https://blog.csdn.net/qq_16855077/article/details/96840346

https://blog.csdn.net/qq_16855077/article/details/96872207#%C2%A0%20%C2%A0%20%C2%A0%20%C2%A0%20%C2%A0%20%C2%A0%20%C2%A0%20%C2%A0%202.5%20%E6%B5%8B%E8%AF%95