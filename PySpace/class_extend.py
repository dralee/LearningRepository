#!/usr/bin/python3
# 文件名：class_extend.py

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
		
# 单继承示例
class student(people):
	grade = ''
	def __init__(self,n,a,w,g):
		# 调用父类构造函数
		people.__init__(self,n,a,w)
		self.grade = g
		
	# 覆写父类方法
	def speak(self):
		print("%s 说: 我 %d 岁了，我在读 %d 年级"%(self.name,self.age,self.grade))

		
# 实例化类
p = people('runoob',12,32)
p.speak()

s = student('kate',8,25,2)
s.speak()