#!/usr/bin/python3
# 文件名：time5.py

"""
Python 程序能用很多方式处理日期和时间，转换日期格式是一个常见的功能。
Python 提供了一个 time 和 calendar 模块可以用于格式化日期和时间。
时间间隔是以秒为单位的浮点小数。
每个时间戳都以自从1970年1月1日午夜（历元）经过了多长时间来表示。
Python 的 time 模块下有很多函数可以转换常见日期格式。如函数time.time()用于获取当前时间戳, 如下实例:
"""

'''
Calendar模块有很广泛的方法用来处理年历和月历，例如打印某月的月历：
'''

import calendar

cal = calendar.month(2017,6)
print("以下输出2017年6月日历：")
print(cal)
