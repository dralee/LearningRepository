#!/usr/bin/python3
# 文件名：read.py

str = input("请输入文件名：")
print("你输入的内容是：",str)

f=open(str,"w")
f.write("Python测试写文件内容\r\n很简单的操作方式！！")
f.close() # 关闭

strA = input("是读取写入的内容：")
strA = strA.lower()
if strA == "yes" or strA == 'y':
	f=open(str,'r')
	strContent = f.read()
	print("写入文件'{0}'的内容为'{1}'".format(str,strContent))
	f.close()

