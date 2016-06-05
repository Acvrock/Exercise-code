#coding=utf-8
import pika,sys

credentials = pika.PlainCredentials("guest","guest")
conn_params = pika.ConnectionParameters("localhost",credentials=credentials)

conn_broker = pika.BlockingConnection(conn_params)   ## 1. 建立到代理服务器的连接

channel = conn_broker.channel()    ## 2. 获得信道
channel.exchange_declare(exchange="hello-exchange",
                         type="direct",
                         passive=False,
                         durable=True,
                         auto_delete=False)   ## 3. 声明交换器

msg = sys.argv[1]
msg_props = pika.BasicProperties()
msg_props.content_type = "text/plain"    ## 4. 创建纯文本消息

channel.basic_publish(body=msg,
                      exchange="hello-exchange",
                      properties=msg_props,
                      routing_key="hola")    ## 5. 发布消息

