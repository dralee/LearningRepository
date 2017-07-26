#!/usr/bin/python3
# 文件名：class_complex.py

class Complex:
	def __init__(self, realpart, imagpart): # 构造函数 self指向类实例本身，self不是关键字，可用其他替换（同样表示类实例本身），但只能为第一个参数
		self.r = realpart
		self.i = imagpart
		
x = Complex(3.0,-4.5)
print("%.1f+%.1fi" % (x.r,x.i))
