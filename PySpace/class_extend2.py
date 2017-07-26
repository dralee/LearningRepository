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

# 另一个类，多重继承之前的准备
class speaker():
	topic = ''
	name = ''
	def __init__(self,n,t):
		self.name = n
		self.topic = t
		
	def speak(self):
		print("我叫 %s，我是一个演说家，我演讲的主题是 %s"%(self.name,self.topic))

# 多重继承（按圆括号中父类从左到右，查找是否父类中包含方法）
class sample(speaker,student):
	a = ''
	def __init__(self,n,a,w,g,t):
		student.__init__(self,n,a,w,g)
		speaker.__init__(self,n,t)
				
# 实例化类
p = people('runoob',12,32)
p.speak()

s = student('kate',8,25,2)
s.speak()

test = sample("Tim",25,80,4,"Python")
test.speak()   #方法名同，默认调用的是在括号中排前地父类的方法
