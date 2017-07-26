#!/usr/local/bin/lua
-- lua�ű��ļ�ʹ��ansi���뷽ʽ����
-- Lua���������Ǵ�1��ʼ

-- ���ǵ���ע��
--[[
	�ţ�������
	����Ƕ���ע��
--]]
-- LuaԪ��Metatable

print([[table�пɷ��ʶ�Ӧkey���õ�valueֵ��ȴ�޷�������table���в�����
	���Lua�ṩ��Ԫ��Metatable��������ı�table����Ϊ��ÿ����Ϊ����
	�˶�Ӧ��Ԫ������
	�磬ʹ��Ԫ��ɶ���lua��μ�������table����Ӳ���a+b��
	��lua��ͼ��������������ʱ���ȼ������֮һ�Ƿ���Ԫ�أ�֮������
	����һ���С�__add�����ֶΣ����ҵ�������ö�Ӧ��ֵ����__add���ȼ�ʱ�ֶΣ�
	���Ӧֵ��������һ����������table�����ǡ�Ԫ��������
	��������Ҫ����������Ԫ��
		1.setmetatable(table,metatable)����ָ��table����Ԫ��metatable����
		��Ԫ��metatable���д���__metatable��ֵ��setmetatable��ʧ�ܡ�
		2.getmetatable(table)�����ض����Ԫ��metatable����]])

mytable={} -- ��ͨ��
mymetatable = {} -- Ԫ��
setmetatable(mytable,mymetatable) -- ��mymetatable��Ϊmytable��Ԫ��

-- ֱ��дҲ
mytable = setmetatable({},{})

getmetatable(mytable) -- ��ط���mymetatable

-- __indexԪ����
print("__indexԪ����")
other = {foo=3}
t=setmetatable({},{__index=other})
print(t.foo)
print(t.bar)

mytable = setmetatable({key1="value1"},{
	__index = function(mytable,key)
		if key == "key2" then
			return "metatablevalue"
		else
			return nil
		end
	end
})

print(mytable.key1,mytable.key2)

-- __newindexԪ����

-- __call Ԫ����

-- __tostringԪ����

