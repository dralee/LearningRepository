#!/usr/bin/python3
# 文件名：pipe.py

# os模块功能 unix下才有fork函数

from mmap import mmap,ACCESS_READ
from xlrd import open_workbook

data = open_workbook('商城积分转账错误.xlsx')
table = data.sheets()[0]

nrows = table.nrows
ncols = table.ncols

#for i in range(nrows):
#	print(table.row_values(i))

#for i in range(ncols):
#	print(table.col_values(i))

#print(table.col_values(0))

#print("%d"%table.cell(2,0))
#for i in range(2,nrows):
#	str+=table.cell(0,i)
#print(str)

ids = table.col_values(0)

str=""
for i in range(2,len(ids)):
	str="%s,%d"%(str,ids[i])
	#print(ids[i])
print(str)

















