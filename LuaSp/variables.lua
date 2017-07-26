#!/usr/local/bin/lua
-- lua脚本文件使用ansi编码方式保存

-- 这是单行注释
--[[
	呐，看好了
	这可是多行注释
--]]

print("Lua变量三种类型：全局变量（默认，哪怕是语句块或函数里，除非用local显式声明为局部变量）、局部变量、表中的域")
print("变量的默认值均为nil")
a=5 -- 全局变量
local b=6 -- 局部变量

function joke()
	c = 7 -- 全局变量
	local d = 8 -- 局部变量
end

joke()
print(c,d)

do
	local a = 6 -- 局部变量
	b = 9 -- 全局变量
	print(a,b)
end

print(a,b)

print("Lua可对多个变量同时赋值，变量列表和值列表的各个元素用逗号分开，赋值语句右边的值会依次赋给左边变量")
x = 3e5
a,b = 10,2*x

print(a,b)

print("遇到赋值语句Lua会先计算右边所有值再执行赋值操作，所以可以进行交换变量的值")
x=10
y=5
x,y = y,x
print(x,y)

a = {20,30}
i=1
j=2
a[i],a[j] = a[j],a[i]
for k,v in pairs(a) do
	print(k..":"..v)
end

print("当变量个数和值的个数不一致时，Lua会一直以变量个数为基础采取以下策略：")
str=[[
	a.变量个数 > 值的个数		按变量个数补足nil
	b.变量个数 < 值的个数		多余的值会被忽略
]]
print(str)

a,b,c = 0,1
print(a,b,c)
a,b = a+1,b+2,b+3
print(a,b)
a,b,c = 0
print(a,b,c) -- 0 nil nil
a,b,c = 0,0,0
print(a,b,c) -- 0 0 0
print("多值赋值经常用来交换变量，或将函数调用返回给变量")
print([[应尽可能使用局部变量，有两个好处：
	1.避免命名冲突
	2.访问局部变量的速度比全局变量更快
]])

print("索引：对于table的索引使用方括号[]。Lua也提供了.操作")
local a={name="jackie",from="China"}
print(a["name"])
print(a.name) -- 当索引为字符串类型时的一种简化写法
print("gettable_event(a,name) -- 采用索引访问本质上是一个类似这样的函数调用")

