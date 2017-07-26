#!/usr/local/bin/lua
-- lua�ű��ļ�ʹ��ansi���뷽ʽ����
-- Lua���������Ǵ�1��ʼ

-- ���ǵ���ע��
--[[
	�ţ�������
	����Ƕ���ע��
--]]
-- ��������

print("��������")
array = {"Lua","Tutorial"}

print("ʹ��LuaĬ���ṩ��ʧ�ܺ���ipairs��")

for key,value in ipairs(array) do
	print(key,value)
end

print("��״̬�ĵ��������������κ�״̬�ĵ������������ѭ���п�������״̬ʧ�������ⴴ���հ����Ѷ�����ۣ���")
print("��״̬���������ͼ�������ipairs")

function square(iteratorMaxCount,currentNumber)
	if currentNumber < iteratorMaxCount then
		currentNumber = currentNumber+1
		return currentNumber,currentNumber*currentNumber
	end
end

for i,n in square,3,0 do
	print(i,n)
end

print("ʵ��ipairs��������")

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

print("��״̬��������")
print([[��������Ҫ������״̬��Ϣ�����Ǽ򵥵�״̬�����Ϳ��Ʊ�������򵥵ķ���ʹ�ñհ���
	����һ�ַ������ǽ�����״̬��Ϣ��װ��table�ڣ���table��Ϊ������״̬����]])

array = {"Lua", "Tutorial"}

function elementIterator(collection)
	local index = 0
	local count = #collection
	-- �հ�����
	return function()
		index = index+1
		if index <= count then
			-- ���ص�������ǰԪ��
			return collection[index]
		end
	end
end

for element in elementIterator(array) do
	print(element)
end

