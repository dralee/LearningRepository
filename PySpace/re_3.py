#!/usr/bin/python3
# -*- coding: UTF-8 -*-
# 文件名：re_3.py

import re

print(re.search("www",'www.runoob.com').span()) # 在起始位置匹配
print(re.search("com",'www.runoob.com').span()) # 不在起始位置匹配