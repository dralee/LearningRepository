#!/usr/local/bin/lua
-- lua脚本文件使用ansi编码方式保存

-- 这是单行注释
--[[
	呐，看好了
	这可是多行注释
--]]

-- table
print("table 使用示例：")
table1 = {name="Jackie",age=28,from="GD","This is a string in table",100}
for k,v in pairs(table1) do
	print(k.."-" .. v)
end

-- 键为nil，则等于是被删除了
table1.name = nil
for k,v in pairs(table1) do
	print(k..":"..v)
end

-- boolean
print("boolean 使用示例：")
print(type(true))
print(type(false))
print(type(nil))

if false or nil then
	print("至少false和nil有一个是true")
else
print("false和nil都为false!")
end

-- number
print("number 使用示例：")
print(type(2))
print(type(2.2))
print(type(0.2))
print(type(2e+1))
print(type(0.2e-1))
print(type(7.8263692594256e-06))

-- string
print("string 使用示例：")
string1 = "this is a string1"
string2 = "this is a string2"
html = [[
<html>
<head></head>
<body>
	<a href="http://www.w3cschool.cc/">w3cschool菜鸟教程</a>
</body>
</html>
]]
print(string1)
print(string2)
print(html)

-- 对一个数字字符串上进行算术操作时，Lua会尝试将这个数字字符串转成一个数字：
print("2"+6)
print("-2e2"*"6")

print("字符串连接")
string3 = "this is a combined string:"..string1.." "..string2
print(string3)

-- table
print("table 使用示例(Lua中表table是一个关联数组，索引可以是数字[从1开始]或字符串)：")
print("table不会固定长度大小，有新数据添加时table长度会自动增长，没初始的table都是nil")
-- 创建一个空table
local tbl1 = {}
-- 直接初始表
local tbl2 = {"apple","pear","orange","grape"}
a={}
a["key"]="value"
key=10
a[key]=22
a[key]=a[key]+11
for k,v in pairs(a) do
	print(k.." : "..v)
end

for k,v in pairs(tbl2) do
	print(k..":"..v)
end

print("------------------------")
a3={}
for i=0,10 do
	a3[i] = i
end
a3["key"] = "val"
print(a3["key"])
print(a3["none"])
print(a3[2])

-- function
print("function 函数被看作是“第一类值”，函数可存在变量里：")
function factorial(n)
	if n == 0 then
		return 1
	end
	return n * factorial(n-1)
end

print(factorial(5))
factorial2 = factorial
print(factorial2(5))

print("function可以匿名函数方式通过参数传递：")
function anonymous(tab,fun)
	for k,v in pairs(tab) do
		print(fun(k,v))
	end
end

tab = {key1="val1",key2="val2",120,"well done."}
anonymous(tab,function(k,v)
	return k.." = "..v
end)

-- thread
print("thread 线程，最主要的线程是协同程序。它跟线程差不多，拥有自己独立的栈、局部变量和指令指针，可以跟其他协同程序共享全局变量和其他大部分东西：")
print("线程跟协程的区别：线程可以同时多个运行，而协程任意时刻只能运行一个，并且处理运行状态的协程只有被挂起时才会暂停")

-- userdata
print("userdata 是一个用户自定义数据，用于表示一种由应用程序或C/C++语言库所创建的类型，可将任意C/C++类型的数据（通常是struct和指针）存储到Lua变量中调用")
