#!/usr/bin/python3
#-*- coding: UTF-8 -*-
# 文件名：environ.py

import os

print ("Content-type: text/html")
print ()
print ("<meta charset=\"gbk\">")
print ("<b>环境变量</b><br>")
print ("<ul>")
for key in os.environ.keys():
    print ("<li><span style='color:green'>%30s </span> : %s </li>" % (key,os.environ[key]))
print ("</ul>")