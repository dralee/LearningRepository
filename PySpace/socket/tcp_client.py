#!/usr/bin/python3
# 文件名：tcp_client.py

# 导入socket、sys模块
import socket
import sys

# 创建socket对象
s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

# 获取本地主机名
host = socket.gethostname()

port = 9999

# 绑定端口
s.connect((host,port))

# 接收小于1024字节的数据
msg = s.recv(1024)

s.close()

print(msg.decode('utf-8'))
