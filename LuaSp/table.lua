#!/usr/local/bin/lua
-- lua脚本文件使用ansi编码方式保存
-- Lua的索引都是从1开始

-- 这是单行注释
--[[
	呐，看好了
	这可是多行注释
--]]
-- table表：

print("table表（表是Lua特有的功能强大的东西）：")
-- 初始化表
mytable={}
--指定值
mytable[1]="Lua"
--移除引用
mytable=nil
-- Lua垃圾回收会释放内存

-- 简单table
mytable = {}
print("mytable的类型是",type(mytable))

mytable[1]="Lua"
mytable["wow"]="修改前"
print("mytable索引为1的元素是",mytable[1])
print("mytable索引为wow的元素是",mytable["wow"])

-- alternatetable和mytable指向同一个table
alternatetable = mytable
print("alternatetable索引为1的元素是",mytable[1])
print("alternatetable索引为wow的元素是",mytable["wow"])

alternatetable["wow"] = "修改后"

print("mytable索引为wow的元素是",mytable["wow"])

-- 释放变量
alternatetable = nil
print("alternatetable是",alternatetable)

-- mytable仍然可访问
print("mytable索引为wow的元素是",mytable["wow"])

mytable=nil
print("mytable是",mytable)

print("table的操作：")
print("连接:")

fruits = {"banana","orange","apple"}
-- 返回table连接后字符串
print("连接后的字符串",table.concat(fruits))

-- 指定连接字符
print("连接后的字符串",table.concat(fruits,","))

-- 指定索引来连接table
print("连接后的字符串",table.concat(fruits,",",2,3))

print("table插入和移除：")
fruits = {"banana","orange","apple"}
-- 在末尾插入
table.insert(fruits,"mango")
print("索引为4的元素为",fruits[4])
-- 在索引为2的键处插入
table.insert(fruits,2,"grapes")
print("索引为4的元素为",fruits[2])

print("最后一个元素为",fruits[5])
table.remove(fruits)
print("移除后最后一个元素为",fruits[5])

print("table排序")
fruits = {"banana","orange","apple","grapes"}
print("排序前：")
for k,v in ipairs(fruits) do
	print(k,v)
end

table.sort(fruits)
print("排序后：")
for k,v in ipairs(fruits) do
	print(k,v)
end

print("table最大值（在Lua5.2后table.maxn已不存在）：")
function table_maxn(t)
	local mn = 0
	for k,v in pairs(t) do
		if mn < k then
			mn = k
		end
	end
	return mn
end

tbl = {[1] = "a",[2]="b",[3]="c",[26]="z"}
print("tbl长度",#tbl)
print("tbl最大值",table_maxn(tbl))
