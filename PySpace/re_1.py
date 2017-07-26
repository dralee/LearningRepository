#!/usr/bin/python3
# -*- coding: UTF-8 -*-
# 文件名：re_1.py

import re
print(re.match('www','www.runoob.com').span()) # 在起始位置匹配
print(re.match('com','www.runoob.com')) # 不在起始位置匹配
