#!/usr/bin/python3
# 文件名：class_method3.py

'''
	类私有方法：两个下划线开头，声明该方法为私有方法，只能在类内部调用，不能在类外部调用
	self.__private_methods.
'''
# 类定义
class JustCounter:
	__secretCount = 0 # 私有变量
	publicCount = 0 # 公开变量
	
	def count(self):
		self.__secretCount += 1
		self.publicCount += 1
		print(self.__secretCount)
		
		
# 实例化类
counter = JustCounter()
counter.count()
counter.count()
print(counter.publicCount)
print(counter.__secretCount) # 报错，实例不能访问私有变量
