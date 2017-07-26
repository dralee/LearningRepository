#!/usr/local/bin/lua
-- lua�ű��ļ�ʹ��ansi���뷽ʽ����

-- ���ǵ���ע��
--[[
	�ţ�������
	����Ƕ���ע��
--]]

-- table
print("table ʹ��ʾ����")
table1 = {name="Jackie",age=28,from="GD","This is a string in table",100}
for k,v in pairs(table1) do
	print(k.."-" .. v)
end

-- ��Ϊnil��������Ǳ�ɾ����
table1.name = nil
for k,v in pairs(table1) do
	print(k..":"..v)
end

-- boolean
print("boolean ʹ��ʾ����")
print(type(true))
print(type(false))
print(type(nil))

if false or nil then
	print("����false��nil��һ����true")
else
print("false��nil��Ϊfalse!")
end

-- number
print("number ʹ��ʾ����")
print(type(2))
print(type(2.2))
print(type(0.2))
print(type(2e+1))
print(type(0.2e-1))
print(type(7.8263692594256e-06))

-- string
print("string ʹ��ʾ����")
string1 = "this is a string1"
string2 = "this is a string2"
html = [[
<html>
<head></head>
<body>
	<a href="http://www.w3cschool.cc/">w3cschool����̳�</a>
</body>
</html>
]]
print(string1)
print(string2)
print(html)

-- ��һ�������ַ����Ͻ�����������ʱ��Lua�᳢�Խ���������ַ���ת��һ�����֣�
print("2"+6)
print("-2e2"*"6")

print("�ַ�������")
string3 = "this is a combined string:"..string1.." "..string2
print(string3)

-- table
print("table ʹ��ʾ��(Lua�б�table��һ���������飬��������������[��1��ʼ]���ַ���)��")
print("table����̶����ȴ�С�������������ʱtable���Ȼ��Զ�������û��ʼ��table����nil")
-- ����һ����table
local tbl1 = {}
-- ֱ�ӳ�ʼ��
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
print("function �����������ǡ���һ��ֵ���������ɴ��ڱ����")
function factorial(n)
	if n == 0 then
		return 1
	end
	return n * factorial(n-1)
end

print(factorial(5))
factorial2 = factorial
print(factorial2(5))

print("function��������������ʽͨ���������ݣ�")
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
print("thread �̣߳�����Ҫ���߳���Эͬ���������̲߳�࣬ӵ���Լ�������ջ���ֲ�������ָ��ָ�룬���Ը�����Эͬ������ȫ�ֱ����������󲿷ֶ�����")
print("�̸߳�Э�̵������߳̿���ͬʱ������У���Э������ʱ��ֻ������һ�������Ҵ�������״̬��Э��ֻ�б�����ʱ�Ż���ͣ")

-- userdata
print("userdata ��һ���û��Զ������ݣ����ڱ�ʾһ����Ӧ�ó����C/C++���Կ������������ͣ��ɽ�����C/C++���͵����ݣ�ͨ����struct��ָ�룩�洢��Lua�����е���")
