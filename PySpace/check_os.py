#!/usr/bin/python3
# 文件名：check_os.py

# os模块功能

import os,sys

# 假定同一目录下存在temp.txt文件，且有读写权限

print('os.access()检测文件属性：')
ret = os.access('temp.txt',os.F_OK) # 测试是否存在
rets=[]
rets.append('F_OK:{}'.format(ret))

ret = os.access('temp.txt',os.R_OK) # 测试是否可读
rets.append('R_OK:{}'.format(ret))
ret = os.access('temp.txt',os.W_OK) # 测试是否可写
rets.append('W_OK:{}'.format(ret))
ret = os.access('temp.txt',os.X_OK) # 测试是否可执行
rets.append('X_OK:{}'.format(ret))

for x in rets:
	print(x)
	
print('os.chdir()目录切换：')
path='d:/'

# 查看当前工作目录
print('当前工作目录为%s' % os.getcwd())

# 修改当前工作目录
os.chdir(path)

# 查看当前工作目录
print('当前工作目录修改为%s' % os.getcwd())

print('os.chflags()方法设置路径标记为数字标记，只支持unix下使用，多个值通过 OR 组合')
print('os.chflags(path,flags)')
print("""
	flags -- 可以是以下值：
	stat.UF_NODUMP: 非转储文件
	stat.UF_IMMUTABLE: 文件是只读的
	stat.UF_APPEND: 文件只能追加内容
	stat.UF_NOUNLINK: 文件不可删除
	stat.UF_OPAQUE: 目录不透明，需要通过联合堆栈查看
	stat.SF_ARCHIVED: 可存档文件(超级用户可设)
	stat.SF_IMMUTABLE: 文件是只读的(超级用户可设)
	stat.SF_APPEND: 文件只能追加内容(超级用户可设)
	stat.SF_NOUNLINK: 文件不可删除(超级用户可设)
	stat.SF_SNAPSHOT: 快照文件(超级用户可设)
""")

print('chmod()更改文件或目录权限：')
print('''
	os.chmod(path,mode)
path -- 文件名路径或目录路径。
flags -- 可用以下选项按位或操作生成， 目录的读权限表示可以获取目录里文件名列表， ，执行权限表示可以把工作目录切换到此目录 ，删除添加目录里的文件必须同时有写和执行权限 ，文件权限以用户id->组id->其它顺序检验,最先匹配的允许或禁止权限被应用。
	stat.S_IXOTH: 其他用户有执行权0o001
	stat.S_IWOTH: 其他用户有写权限0o002
	stat.S_IROTH: 其他用户有读权限0o004
	stat.S_IRWXO: 其他用户有全部权限(权限掩码)0o007
	stat.S_IXGRP: 组用户有执行权限0o010
	stat.S_IWGRP: 组用户有写权限0o020
	stat.S_IRGRP: 组用户有读权限0o040
	stat.S_IRWXG: 组用户有全部权限(权限掩码)0o070
	stat.S_IXUSR: 拥有者具有执行权限0o100
	stat.S_IWUSR: 拥有者具有写权限0o200
	stat.S_IRUSR: 拥有者具有读权限0o400
	stat.S_IRWXU: 拥有者有全部权限(权限掩码)0o700
	stat.S_ISVTX: 目录里文件目录只有拥有者才可删除更改0o1000
	stat.S_ISGID: 执行此文件其进程有效组为文件所在组0o2000
	stat.S_ISUID: 执行此文件其进程有效用户为文件所有者0o4000
	stat.S_IREAD: windows下设为只读
	stat.S_IWRITE: windows下取消只读
''')

print('更多详情，看os模块http://www.runoob.com/python3/python3-os-file-methods.html')




















