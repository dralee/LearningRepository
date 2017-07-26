#!/usr/local/bin/lua
-- lua脚本文件使用ansi编码方式保存
-- Lua的索引都是从1开始

-- 这是单行注释
--[[
	呐，看好了
	这可是多行注释
--]]

string1 = "Hello World"

print(string.upper(string1)) -- 大写
print(string.lower(string1)) -- 小写
print(string.gsub(string1,"l","L",2)) -- 替换，第4个参数为需要替换次数，忽略则全部替换
print(string.find(string1,"Wor",1)) -- 可以指定查找索引范围，3、4个参数
print(string.reverse(string1)) -- 倒置
print(string.format("the value is:%d",12)) -- 返回printf的格式化字符串
print(string.char(97,98,99,100)) -- 将整数转换成字符并连接
print(string.byte("ABCD",4)) -- 将字符转换为数值（可以指定某个字符，默认第一个字符）
print(string.byte("ABCD"))
print(string.len(string1)) -- 长度
print(string.rep("ABCD",2)) -- 返回字符串的n个拷贝
print(string1.."连接") -- 连接字符串
