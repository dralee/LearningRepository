#!/usr/local/bin/lua
-- lua脚本文件使用ansi编码方式保存
-- Lua的索引都是从1开始

-- 这是单行注释
--[[
	呐，看好了
	这可是多行注释
--]]
-- 一维数组

print("一维数组：")
array = {"Lua", "Tutorial"}

for i = 0,2 do
	print(array[i])
end

array = {}
for i=-2,2 do
	array[i] = i*2
end

for i = -2,2 do
	print(array[i])
end

print("多维数组：")
array = {}
for i=1,3 do
	array[i] = {}
	for j = 1,3 do
		array[i][j] = i * j
	end
end

for i = 1,3 do
	for j=1,3 do
		print(array[i][j])
	end
end

print("不同索引键的三行三列阵列多维数组：")
array = {}
maxRows = 3
maxColumns = 3
for row=1,maxRows do
	for col=1,maxColumns do
		array[row*maxColumns+col]=row*col
	end
end

for row=1,maxRows do
	for col=1,maxColumns do
		print(array[row*maxColumns + col])
	end
end


