#!/usr/bin/python3
# 文件名：class_method3.py

'''
	类私有方法：两个下划线开头，声明该方法为私有方法，只能在类内部调用，不能在类外部调用
	self.__private_methods.
'''
# 类定义
class Site:
	def __init__(self, name, url):
		self.name = name # public
		self.__url = url # private
		
	def who(self):
		print('name:',self.name)
		print('url:',self.__url)
		
	def __foo(self): # 私有方法
		print('这是私有方法')
		
	def foo(self): # 公开方法
		print("这是公开方法")
		self.__foo()
		
		
# 实例化类
x = Site('菜鸟教程', 'www.runoob.com')
x.who()        # 正常输出
x.foo()        # 正常输出
x.__foo()      # 报错
