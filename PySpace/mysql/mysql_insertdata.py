#!/usr/bin/python3
# 文件名：mysql_createtable.py

import pymysql

# 打开数据库连接
db = pymysql.connect('localhost','root','1234','fdtest')

# 使用cursor()方法创建一个游标对象cursor
cursor = db.cursor()

# SQL插入语句
sql = """INSERT INTO EMPLOYEE(
		FIRST_NAME,LAST_NAME,AGE,SEX,INCOME)
		VALUES('Mac2','Mohan2',20,'M',6000)"""

"""
或
sql = "INSERT INTO EMPLOYEE(FIRST_NAME, \
       LAST_NAME, AGE, SEX, INCOME) \
       VALUES ('%s', '%s', '%d', '%c', '%d' )" % \
       ('Mac', 'Mohan', 20, 'M', 2000)
"""

try:
	# 执行sql语句
	cursor.execute(sql)
	# 提交到数据库执行
	db.commit()
except:
	# 如发生错误则回滚
	db.rollback()

# 关闭数据库连接
db.close()
