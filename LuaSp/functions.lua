#!/usr/local/bin/lua
-- lua脚本文件使用ansi编码方式保存
-- Lua的索引都是从1开始

-- 这是单行注释
--[[
	呐，看好了
	这可是多行注释
--]]

myprint = function(param)
	print("这是打印函数 - ##",param,"##")
end

function add(num1,num2,functionPrint)
	local result = num1 + num2
	-- 调用传递的函数参数
	functionPrint(result)
end

myprint(10)
-- myprint函数作为参数传递
add(2,5,myprint)

print("多返回值：")
s,e = string.find("www.runoob.com","runoob")
print(s,e) -- start,end

function maximum(a)
	local mi = 1 		-- 最大值索引
	local m = a[mi]		-- 最大值
	for i,val in ipairs(a) do
		if val > m then
			mi = i
			m = val
		end
	end
	return mi,m
end

print(maximum({8,10,23,55,19}))

print("可变参数：")

function average(...)
	local result = 0
	local arg = {...}
	for i,v in ipairs(arg) do
		result = result + v
	end
	print("总共传入 "..#arg.."个数")
	return result/#arg
end

print("平均值为",average(10,15,3,5,2,8,9,21))

a=21
b=10
if(a == b) then
	print("a等于b")
else
	print("a不等于b")
end

if (a ~= b) then
	print("a不等于(~=)b")
else
	print("a等于b")
end

a="Hello "
b="World"
print("连接字符串："..a..b);
print("a的长度："..#a)
print("Test的长度："..#"Test");
