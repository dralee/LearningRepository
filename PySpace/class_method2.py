#!/usr/bin/python3
# 文件名：class_method2.py

# 类定义
class Parent: # 父类
	def myMethod(self):
		print('调用父类方法')
		
class Child(Parent): # 子类
	def myMethod(self):
		print('调用子类方法')
		
# 实例化类
c = Child()
c.myMethod() # 子类中重写方法
