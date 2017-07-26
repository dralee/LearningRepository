#!/usr/bin/python3
# 文件名：pickle.py

import pickle

# pickle实现基本数据序列和反序列化
# 使用pickle模块将数据对象保存到文件
data = {'a':[1,2.0,3,4+6j],
		'b':('string',u'Unicode string'),
		'c':None}

selfref_list = [1,2,3]
selfref_list.append(selfref_list)

output = open('data.pkl','wb')

# Pickle dictinary using protocol 0.
pickle.dump(data,output)

# Pickle the list using the highest protocol available.
pickle.dump(selfref_list,output,-1)

output.close()