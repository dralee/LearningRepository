#!/usr/bin/python3
# 文件名：pipe.py

# os模块功能 unix下才有fork函数

import os,sys

print('创建管道:os.pipe()')
# 文件描述符r，w用于读写
r,w=os.pipe()

processid = os.fork()
if processid:
	# 父进程
	# 关闭文件描述 w
	os.close(w)
	r = os.fdopen(r)
	print('Parent reading')
	str = r.read()
	print('text=',str)
	sys.exit(0)
else:
	# 子进程
	os.close(r)
	w = os.fdopen(w,'w')
	print('Child writing')
	w.write('Text written by child...')
	w.close()
	print('Child closing')
	sys.exit(0)

print('更多详情，看os模块http://www.runoob.com/python3/python3-os-file-methods.html')




















