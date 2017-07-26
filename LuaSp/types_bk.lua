#!/usr/local/bin/lua

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
