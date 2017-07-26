#!/usr/local/bin/lua
-- lua�ű��ļ�ʹ��ansi���뷽ʽ����
-- Lua���������Ǵ�1��ʼ

-- ���ǵ���ע��
--[[
	�ţ�������
	����Ƕ���ע��
--]]
-- table��

print("table������Lua���еĹ���ǿ��Ķ�������")
-- ��ʼ����
mytable={}
--ָ��ֵ
mytable[1]="Lua"
--�Ƴ�����
mytable=nil
-- Lua�������ջ��ͷ��ڴ�

-- ��table
mytable = {}
print("mytable��������",type(mytable))

mytable[1]="Lua"
mytable["wow"]="�޸�ǰ"
print("mytable����Ϊ1��Ԫ����",mytable[1])
print("mytable����Ϊwow��Ԫ����",mytable["wow"])

-- alternatetable��mytableָ��ͬһ��table
alternatetable = mytable
print("alternatetable����Ϊ1��Ԫ����",mytable[1])
print("alternatetable����Ϊwow��Ԫ����",mytable["wow"])

alternatetable["wow"] = "�޸ĺ�"

print("mytable����Ϊwow��Ԫ����",mytable["wow"])

-- �ͷű���
alternatetable = nil
print("alternatetable��",alternatetable)

-- mytable��Ȼ�ɷ���
print("mytable����Ϊwow��Ԫ����",mytable["wow"])

mytable=nil
print("mytable��",mytable)

print("table�Ĳ�����")
print("����:")

fruits = {"banana","orange","apple"}
-- ����table���Ӻ��ַ���
print("���Ӻ���ַ���",table.concat(fruits))

-- ָ�������ַ�
print("���Ӻ���ַ���",table.concat(fruits,","))

-- ָ������������table
print("���Ӻ���ַ���",table.concat(fruits,",",2,3))

print("table������Ƴ���")
fruits = {"banana","orange","apple"}
-- ��ĩβ����
table.insert(fruits,"mango")
print("����Ϊ4��Ԫ��Ϊ",fruits[4])
-- ������Ϊ2�ļ�������
table.insert(fruits,2,"grapes")
print("����Ϊ4��Ԫ��Ϊ",fruits[2])

print("���һ��Ԫ��Ϊ",fruits[5])
table.remove(fruits)
print("�Ƴ������һ��Ԫ��Ϊ",fruits[5])

print("table����")
fruits = {"banana","orange","apple","grapes"}
print("����ǰ��")
for k,v in ipairs(fruits) do
	print(k,v)
end

table.sort(fruits)
print("�����")
for k,v in ipairs(fruits) do
	print(k,v)
end

print("table���ֵ����Lua5.2��table.maxn�Ѳ����ڣ���")
function table_maxn(t)
	local mn = 0
	for k,v in pairs(t) do
		if mn < k then
			mn = k
		end
	end
	return mn
end

tbl = {[1] = "a",[2]="b",[3]="c",[26]="z"}
print("tbl����",#tbl)
print("tbl���ֵ",table_maxn(tbl))
