#!/usr/bin/python3
# 文件名：mysql_createtable.py

import pymysql

# 打开数据库连接
db = pymysql.connect('localhost','root','1234','fdtest')

# 使用cursor()方法创建一个游标对象cursor
cursor = db.cursor()

# SQL查询语句
sql = "SELECT * FROM EMPLOYEE \
		WHERE INCOME> '%d'" % (1000)

try:
	# 执行sql语句
	cursor.execute(sql)
	# 获取所有记录列表
	results = cursor.fetchall()
	for row in results:
		fname = row[0]
		lname = row[1]
		age = row[2]
		sex = row[3]
		income = row[4]
		# 打印结果
		print("fname=%s,lname=%s,age=%d,sex=%s,income=%d" % \
			(fname,lname,age,sex,income))
except:
	print("Error: unable to fetch data")

# 关闭数据库连接
db.close()
