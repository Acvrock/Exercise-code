#coding=utf-8
import pika,sys
from pika import spec

credentials = pika.PlainCredentials("guest","guest")
conn_params = pika.ConnectionParameters("localhost",credentials=credentials)

conn_broker = pika.BlockingConnection(conn_params)   ## 1. 建立到代理服务器的连接

channel = conn_broker.channel()    ## 2. 获得信道

def confirm_handler(frame):    # 3. 发送方确认模式处理器
    if type(frame.method) == spec.Confirm.SelectOk:
        print "Channel in 'confirm' mode."
    elif type(frame.method) == spec.Basic.Nack:
        if frame.method.delivery_tag in msg_ids:
            print "Message lost!"
    elif type(frame.method) == spec.Basic.Ack:
        if frame.method.delivery_tag in msg_ids:
            print "Confirm received!"
            msg_ids.remove(frame.method.delivery_tag)

def on_confirm(method):
    print method

## 这里有点问题https://www.zouyesheng.com/rabbitmq.html
channel.confirm_delivery(callback=on_confirm,nowait=True)  # 4. 将信道设置为 confirm 模式
channel.add_on_return_callback(confirm_handler)
## 这里有点问题

msg = sys.argv[1]
msg_props = pika.BasicProperties()
msg_props.content_type = "text/plain"    ## 5. 创建纯文本消息
msg_ids = []     ## 6. id 追踪器
channel.basic_publish(body=msg,
                      exchange="hello-exchange",
                      properties=msg_props,
                      routing_key="hola")    ## 7. 发布消息
msg_ids.append(len(msg_ids)+1)  ## 8. 把id添加到追踪列表中
channel.close()