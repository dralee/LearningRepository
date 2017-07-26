#!/usr/bin/python3
# 文件名：xml_sax.py

'''
python对XML的解析
常见的XML编程接口有DOM和SAX，这两种接口处理XML文件的方式不同，当然使用场合也不同。
python有三种方法解析XML，SAX，DOM，以及ElementTree:
1.SAX (simple API for XML )
python 标准库包含SAX解析器，SAX用事件驱动模型，通过在解析XML的过程中触发一个个的事件并调用用户定义的回调函数来处理XML文件。
2.DOM(Document Object Model)
将XML数据在内存中解析成一个树，通过对树的操作来操作XML。
本章节使用到的XML实例文件movies.xml内容如下：
'''

"""
使用xml.dom解析xml
文件对象模型（Document Object Model，简称DOM），是W3C组织推荐的处理可扩展置标语言的标准编程接口。
一个 DOM 的解析器在解析一个 XML 文档时，一次性读取整个文档，把文档中所有元素保存在内存中的一个树结构里，之后你可以利用DOM 提供的不同的函数来读取或修改文档的内容和结构，也可以把修改过的内容写入xml文件。
python中用xml.dom.minidom来解析xml文件，实例如下：
"""
from xml.dom.minidom import parse
import xml.dom.minidom

# 使用minidom解析器打开XML文档
DOMTree = xml.dom.minidom.parse("movies.xml")
collection = DOMTree.documentElement
if collection.hasAttribute("shelf"):
	print("Root element : %s" % collection.getAttribute("shelf"))
	
# 在集合中获取所有电影
movies = collection.getElementsByTagName("movie")

# 打印每部电影详细信息
for movie in movies:
	print("*****Movie*****")
	if movie.hasAttribute("title"):
		print("Title: %s" % movie.getAttribute("title"))
		
	type = movie.getElementsByTagName('type')[0]
	print("Type: %s" % type.childNodes[0].data)
	format = movie.getElementsByTagName('format')[0]
	print ("Format: %s" % format.childNodes[0].data)
	rating = movie.getElementsByTagName('rating')[0]
	print ("Rating: %s" % rating.childNodes[0].data)
	description = movie.getElementsByTagName('description')[0]
	print ("Description: %s" % description.childNodes[0].data)
