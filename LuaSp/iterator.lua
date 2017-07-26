#!/usr/local/bin/lua
-- lua脚本文件使用ansi编码方式保存
-- Lua的索引都是从1开始

-- 这是单行注释
--[[
	呐，看好了
	这可是多行注释
--]]
-- 迭代器：

print("迭代器：")
array = {"Lua","Tutorial"}

print("使用Lua默认提供的失败函数ipairs：")

for key,value in ipairs(array) do
	print(key,value)
end

print("无状态的迭代器（不保留任何状态的迭代器，因此在循环中可利用无状态失败器避免创建闭包花费额外代价）：")
print("无状态迭代器典型简单例子是ipairs")

function square(iteratorMaxCount,currentNumber)
	if currentNumber < iteratorMaxCount then
		currentNumber = currentNumber+1
		return currentNumber,currentNumber*currentNumber
	end
end

for i,n in square,3,0 do
	print(i,n)
end

print("实现ipairs迭代器：")

function iter(a,i)
	i = i+1
	local v = a[i]
	if v then
		return i,v
	end
end

function myipairs(a)
	return iter,a,0
end

array = {"Jackie","GD"}
for i,n in myipairs(array) do
	print(i,n)
end

print("多状态迭代器：")
print([[迭代器需要保存多个状态信息而不是简单的状态常量和控制变量，最简单的方法使用闭包，
	还有一种方法就是将所有状态信息封装到table内，将table作为迭代器状态常量]])

array = {"Lua", "Tutorial"}

function elementIterator(collection)
	local index = 0
	local count = #collection
	-- 闭包函数
	return function()
		index = index+1
		if index <= count then
			-- 返回迭代器当前元素
			return collection[index]
		end
	end
end

for element in elementIterator(array) do
	print(element)
end

