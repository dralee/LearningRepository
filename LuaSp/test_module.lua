#!/usr/local/bin/lua
-- lua�ű��ļ�ʹ��ansi���뷽ʽ����
-- Lua���������Ǵ�1��ʼ

-- ���ǵ���ע��
--[[
	�ţ�������
	����Ƕ���ע��
--]]
-- �����Զ���ģ��

-- test_module.lua�ļ�
-- moduleģ��Ϊmodule.lua�ļ�
--[[
	require���Լ����ļ�·�����ز��ԣ��᳢�Դ�lua�ļ���C������м���ģ��
	require��������lua�ļ���·���Ǵ����ȫ�ֱ���package.path�У���lua������
		���Ի�������LUA_PATH��ֵ����ʼ�����������������û�ҵ��û�����������
		ʹ��һ������ʱ�����Ĭ��·������ʼ����
		��Ȼ����û��LUA_PATH�������������Ҳ���Զ������ã��ڵ�ǰ�û���Ŀ¼��
		��.profile�ļ���û���򴴽�����.bashrc�ļ�Ҳ���ԣ�����ѡ�~/Lua/��
		·������LUA_PATH����������
		#LUA_PATH
		export LUA_PATH="~/lua/?.lua;;"
		�ļ��ԡ�;���ָ������2����;;����ʾ�¼ӵ�·���������ԭ����Ĭ��·��
		���ţ����»�������������ʹ֮������Ч
		source ~/.profile
		��ʱ����package.pathֵ�ǣ�
		/Users/dengjoe/lua/?.lua;./?.lua;/usr/local/share/lua/5.1/?.lua;/usr/local/share/lua/5.1/?/init.lua;
		/usr/local/lib/lua/5.1/?.lua;/usr/local/lib/lua/5.1/?/init.lua
		��ô����require("module")ʱ�ͻ᳢�Դ������ļ�Ŀ¼ȥ����Ŀ��
		/Users/dengjoe/lua/module.lua;
		./module.lua;
		/usr/local/share/lua/5.1/module.lua;
		/usr/local/share/lua/5.1/module/init.lua;
		/usr/local/lib/lua/5.1/module.lua;
		/usr/local/lib/lua/5.1/module/init.lua
		����ҹ�Ŀ���ļ���������package.loadfile������ģ�顣���򣬾ͻ�ȥ��C����⡣
		�������ļ�·���Ǵ�ȫ�ֱ���package.cpath��ȡ���������������ͨ����������LUA_PATH
		����ʼ�������Ĳ��Ը������һ����ֻ�������ڻ�����������so��dll���͵��ļ��������
		�õ�����ôrequire�ͻ�ͨ��package.loadlib����������
		
	C��
		Lua��C�Ǻ����׽�ϵģ�ʹ��CΪLuaд����
		��Lua��д����ͬ��C����ʹ����ǰ�������ȼ��ز����ӣ��ڴ����ϵͳ�������׵�ʵ�ַ�ʽ
		��ͨ����̬���ӿ���ơ�Lua��һ����loadlib�ĺ������ṩ�����ж�̬���ӵĹ��ܡ��������
		��������������ľ���·���ͳ�ʼ�����������Ե��͵����������£�
			local path = "/usr/local/lua/lib/libluasocket.so"
			local f = loadlib(path,"luaopen_socket")
		loadlib��������ָ���ĿⲢ���ӵ�Lua��Ȼ���������򿪿⣨Ҳ����˵û�е��ó�ʼ����������
		�෴�������س�ʼ������ΪLua��һ�������������Ϳ���ֱ����Lua�е�������
		����ض�̬�����ҳ�ʼ����������loadlib������nil�ʹ�����Ϣ�����޸�ǰ��һ�δ��룬
		ʹ�������Ȼ���ʼ��������
			local path="/usr/local/lua/lib/libluasocket.so"
			-- �� path = "C:\\windows\\luasocket.dll" ����Windowsƽ̨��
			local f = assert(loadlib(path,"luaopen_socket"))
			f() -- �����򿪿�
		һ����������������Ƶķ��������һ����ǰ��������Ƶ�stub�ļ�����װ�����ƿ�ʱ������
		��ĳ��Ŀ¼��ֻ��Ҫ�޸�stub�ļ���Ӧ�����ƿ��ʵ��·�����ɡ�
		��stub�ļ�����Ŀ¼���뵽LUA_PATH�������趨��Ϳ�ʹ��require��������C���ˡ�
--]]

require("module")

print(module.constant)

module.func1()
module.func3()

