#!/usr/local/bin/lua
-- lua脚本文件使用ansi编码方式保存
-- Lua的索引都是从1开始

-- 这是单行注释
--[[
	呐，看好了
	这可是多行注释
--]]
-- 测试自定义模块

-- test_module.lua文件
-- module模块为module.lua文件
--[[
	require有自己的文件路径加载策略，会尝试从lua文件或C程序库中加载模块
	require用于搜索lua文件的路径是存放在全局变量package.path中，当lua启动后，
		会以环境变量LUA_PATH的值来初始化这个环境变量。如没找到该环境变量，则
		使用一个编译时定义的默认路径来初始化。
		当然，如没有LUA_PATH这个环境变量，也可自定义设置，在当前用户根目录下
		打开.profile文件（没有则创建，打开.bashrc文件也可以），如把”~/Lua/“
		路径加入LUA_PATH环境变量里
		#LUA_PATH
		export LUA_PATH="~/lua/?.lua;;"
		文件以”;“分隔，最后2个”;;“表示新加的路径后面加上原来的默认路径
		接着，更新环境变量参数，使之立即生效
		source ~/.profile
		这时假设package.path值是：
		/Users/dengjoe/lua/?.lua;./?.lua;/usr/local/share/lua/5.1/?.lua;/usr/local/share/lua/5.1/?/init.lua;
		/usr/local/lib/lua/5.1/?.lua;/usr/local/lib/lua/5.1/?/init.lua
		那么调用require("module")时就会尝试打开以下文件目录去搜索目标
		/Users/dengjoe/lua/module.lua;
		./module.lua;
		/usr/local/share/lua/5.1/module.lua;
		/usr/local/share/lua/5.1/module/init.lua;
		/usr/local/lib/lua/5.1/module.lua;
		/usr/local/lib/lua/5.1/module/init.lua
		如果找过目标文件，则会调用package.loadfile来加载模块。否则，就会去找C程序库。
		搜索的文件路径是从全局变量package.cpath获取，而这个变量则是通过环境变量LUA_PATH
		来初始。搜索的策略跟上面的一样，只不过现在换成搜索的是so或dll类型的文件。如果找
		得到，那么require就会通过package.loadlib来加载它。
		
	C包
		Lua和C是很容易结合的，使用C为Lua写包。
		与Lua中写包不同，C包在使用以前必须首先加载并链接，在大多数系统中最容易的实现方式
		是通过动态链接库机制。Lua在一个叫loadlib的函数内提供了所有动态链接的功能。这个函数
		有两个参数：库的绝对路径和初始化函数。所以典型调用例子如下：
			local path = "/usr/local/lua/lib/libluasocket.so"
			local f = loadlib(path,"luaopen_socket")
		loadlib函数加载指定的库并链接到Lua，然面它并不打开库（也就是说没有调用初始化函数），
		相反，它返回初始函数作为Lua的一个函数，这样就可以直接在Lua中调用它。
		如加载动态库或查找初始化函数出错，loadlib将返回nil和错误信息。可修改前面一段代码，
		使其检测错误然后初始化函数：
			local path="/usr/local/lua/lib/libluasocket.so"
			-- 或 path = "C:\\windows\\luasocket.dll" 这是Windows平台下
			local f = assert(loadlib(path,"luaopen_socket"))
			f() -- 真正打开库
		一般情况下期望二进制的发布库包含一个与前面代码相似的stub文件，安装二进制库时可随便放
		在某个目录，只需要修改stub文件对应二进制库的实际路径即可。
		将stub文件所在目录加入到LUA_PATH，这样设定后就可使用require函数加载C库了。
--]]

require("module")

print(module.constant)

module.func1()
module.func3()

