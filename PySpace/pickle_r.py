#!/usr/bin/python3
# 文件名：pickle.py

import pprint,pickle

# pickle实现基本数据序列和反序列化
# 使用pickle模块从文件中重构python

pkl_file = open('data.pkl','rb')

data = pickle.load(pkl_file)
pprint.pprint(data)

selfref_list = pickle.load(pkl_file)
pprint.pprint(selfref_list)

pkl_file.close()

#print(data)
#print(selfref_list)
print('dict data:')
for x in data:
	print(x,data[x])

print('list data:')
for x in selfref_list:
	print(x,end=' ')
