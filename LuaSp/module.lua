#!/usr/local/bin/lua
-- lua�ű��ļ�ʹ��ansi���뷽ʽ����
-- Lua���������Ǵ�1��ʼ

-- ���ǵ���ע��
--[[
	�ţ�������
	����Ƕ���ע��
--]]
-- ģ�����

-- �ļ���Ϊmodule.lua
-- ����һ����Ϊmoduleģ��
module = {}

-- ����һ������
module.constant = "����һ������"

-- ����һ������
function module.func1()
	io.write("����һ�����к�����\n")
end

local function func2()
	print("����һ��˽�к�����")
end

function module.func3()
	print("����˽�к�����")
	func2()
end

return module


