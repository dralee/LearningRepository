#!/usr/local/bin/lua
-- lua�ű��ļ�ʹ��ansi���뷽ʽ����
-- Lua���������Ǵ�1��ʼ

-- ���ǵ���ע��
--[[
	�ţ�������
	����Ƕ���ע��
--]]

string1 = "Hello World"

print(string.upper(string1)) -- ��д
print(string.lower(string1)) -- Сд
print(string.gsub(string1,"l","L",2)) -- �滻����4������Ϊ��Ҫ�滻������������ȫ���滻
print(string.find(string1,"Wor",1)) -- ����ָ������������Χ��3��4������
print(string.reverse(string1)) -- ����
print(string.format("the value is:%d",12)) -- ����printf�ĸ�ʽ���ַ���
print(string.char(97,98,99,100)) -- ������ת�����ַ�������
print(string.byte("ABCD",4)) -- ���ַ�ת��Ϊ��ֵ������ָ��ĳ���ַ���Ĭ�ϵ�һ���ַ���
print(string.byte("ABCD"))
print(string.len(string1)) -- ����
print(string.rep("ABCD",2)) -- �����ַ�����n������
print(string1.."����") -- �����ַ���
