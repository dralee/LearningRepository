#!/usr/local/bin/lua
-- lua�ű��ļ�ʹ��ansi���뷽ʽ����
-- Lua���������Ǵ�1��ʼ

-- ���ǵ���ע��
--[[
	�ţ�������
	����Ƕ���ע��
--]]

myprint = function(param)
	print("���Ǵ�ӡ���� - ##",param,"##")
end

function add(num1,num2,functionPrint)
	local result = num1 + num2
	-- ���ô��ݵĺ�������
	functionPrint(result)
end

myprint(10)
-- myprint������Ϊ��������
add(2,5,myprint)

print("�෵��ֵ��")
s,e = string.find("www.runoob.com","runoob")
print(s,e) -- start,end

function maximum(a)
	local mi = 1 		-- ���ֵ����
	local m = a[mi]		-- ���ֵ
	for i,val in ipairs(a) do
		if val > m then
			mi = i
			m = val
		end
	end
	return mi,m
end

print(maximum({8,10,23,55,19}))

print("�ɱ������")

function average(...)
	local result = 0
	local arg = {...}
	for i,v in ipairs(arg) do
		result = result + v
	end
	print("�ܹ����� "..#arg.."����")
	return result/#arg
end

print("ƽ��ֵΪ",average(10,15,3,5,2,8,9,21))

a=21
b=10
if(a == b) then
	print("a����b")
else
	print("a������b")
end

if (a ~= b) then
	print("a������(~=)b")
else
	print("a����b")
end

a="Hello "
b="World"
print("�����ַ�����"..a..b);
print("a�ĳ��ȣ�"..#a)
print("Test�ĳ��ȣ�"..#"Test");
