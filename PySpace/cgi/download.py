#!/usr/bin/python3
#-*- coding: UTF-8 -*-
# 文件名：environ.py

# HTTP 头部
print ("Content-Disposition: attachment; filename=\"foo.txt\"")
print ()
# 打开文件
fo = open("foo.txt", "rb")

str = fo.read();
print (str)

# 关闭文件
fo.close()