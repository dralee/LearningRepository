#!/usr/bin/python3
# -*- coding: UTF-8 -*-
# 文件名：re_5.py

import re

line = "Cats are smarter than dogs"

matchObj = re.match(r'dogs', line, re.M|re.I)

if matchObj:
	print("match --> matchObj.group():",matchObj.group())
else:
	print("No match!!!")	

searchObj = re.search(r'dogs', line, re.M|re.I)
if searchObj:
	print("search --> searchObj.group():",searchObj.group())
else:
	print("Nothing found!!!")