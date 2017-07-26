#!/usr/bin/python3
# 文件名：class_method.py

# 类定义
class people:
	# 定义基本属性
	name = ''
	age = ''
	# 定义私有属性民，私有属性在类外部无法直接进行访问
	__weight = 0
	# 定义构造方法
	def __init__(self,n,a,w):
		self.name = n
		self.age = a
		self.__weight = w
		
	def speak(self):
		print("%s 说：我%d岁。"%(self.name,self.age))
		
# 实例化类
p = people('runoob',12,32)
p.speak()
