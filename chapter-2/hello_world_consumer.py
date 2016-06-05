#coding=utf-8
import  pika
credentials = pika.PlainCredentials("guest","guest")
conn_params = pika.ConnectionParameters("localhost",credentials=credentials)

conn_broker = pika.BlockingConnection(conn_params)  # 1. 建立到代理服务器的连接
channel = conn_broker.channel()   # 2. 获得信道
channel.exchange_declare(exchange="hello-exchange",
                         type="direct",
                         passive=False,
                         durable=True,
                         auto_delete=False)  # 3. 声明交换器

channel.queue_declare(queue="hello-queue")  # 4. 声明队列
channel.queue_bind(queue="hello-queue",
                   exchange="hello-exchange",
                   routing_key="hola")     # 5. 通过键 "hola" 将队列和交换器绑定

def msg_consumer(channel,method,header,body):  # 6. 定义一个用于处理传入消息的函数
    channel.basic_ack(delivery_tag=method.delivery_tag)    # 7. 确认消息
    if body == "quit":
        channel.basic_cancel(consumer_tag="hello-consumer")  # 8. 如果停止,就停止消费并退出
        channel.stop_consuming()
    else:
        print body
    return

channel.basic_consume(msg_consumer,
                      queue="hello-queue",
                      consumer_tag="hello-consumer")     # 9. 订阅消费者

channel.start_consuming()  # 10.开始消费