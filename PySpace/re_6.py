#!/usr/bin/python3
# -*- coding: UTF-8 -*-
# 文件名：re_6.py

'''
检索和替换
re.sub(pattern, repl, string, count=0)
参数：
pattern : 正则中的模式字符串。
repl : 替换的字符串，也可为一个函数。
string : 要被查找替换的原始字符串。
count : 模式匹配后替换的最大次数，默认 0 表示替换所有的匹配。
'''

import re

phone = '2004-959-559 # 这是一个电话号码'

# 删除注释
num = re.sub(r'#.*$',"",phone)
print('电话号码：',num)

# 移除非数字的内容
num = re.sub(r'\D',"",phone)
print('电话号码：',num)

# 将匹配的数字乘以2
def double(matched):
	value = int(matched.group('value'))
	return str(value*2)
	
s = 'A23G4HFD567'
print(re.sub('(?P<value>\d+)',double,s))