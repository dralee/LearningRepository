#!/usr/bin/python3
# 文件名：json3.py

"""
JSON (JavaScript Object Notation) 是一种轻量级的数据交换格式。它基于ECMAScript的一个子集。
Python3 中可以使用 json 模块来对 JSON 数据进行编解码，它包含了两个函数：
json.dumps(): 对数据进行编码。
json.loads(): 对数据进行解码。
在json的编解码过程中，python 的原始类型与json类型会相互转换，具体的转化对照如下：
"""

import json

# Python字典类型转换为JSON对象
data = {
	'no':1,
	'name':'Runoob',
	'url':'http://www.runoob.com'
}

# 操作json文件
# 写入JSON数据
with open('data.json','w') as f:
	json.dump(data,f)
	
# 读取数据
with open('data.json','r') as f:
	data2 = json.load(f)
	print(data2)
