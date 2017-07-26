#!/usr/bin/python3
# 文件名：class.py

class MyClass:
	"""一个简单类实例"""
	i = 12345
	def f(self):
		return 'hello world'
		
# 实例化类
x = MyClass()

# 访问类属性、方法
print("MyClass 类属性i为：",x.i)
print("MyClass 类方法f输出为：",x.f())

