#!/usr/local/bin/lua
-- lua脚本文件使用ansi编码方式保存
-- Lua的索引都是从1开始

-- 这是单行注释
--[[
	呐，看好了
	这可是多行注释
--]]
-- 模块与包

-- 文件名为module.lua
-- 定义一个名为module模块
module = {}

-- 定义一个变量
module.constant = "这是一个常量"

-- 定义一个函数
function module.func1()
	io.write("这是一个公有函数！\n")
end

local function func2()
	print("这是一个私有函数！")
end

function module.func3()
	print("调用私有函数：")
	func2()
end

return module


