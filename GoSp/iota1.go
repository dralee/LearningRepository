package main

/*
iota，特殊常量，可以认为是一个可以被编译器修改的常量。
在每一个const关键字出现时，被重置为0，然后再下一个const出现之前，每出现一次iota，其所代表的数字会自动增加1。
iota 可以被用作枚举值：

第一个 iota 等于 0，每当 iota 在新的一行被使用时，它的值都会自动加 1；所以 a=0, b=1, c=2 可以简写为如下形式：
*/

/*const (
	a = iota
	b = iota
	c = iota
)*/

func main(){
	const (
		a = iota 	// 0
		b 			// 1
		c			// 2
		d = "ha"	// 独立值， iota += 1
		e			// "ha"		iota += 1
		f = 100		// iota += 1
		g			// 100 		iota += 1
		h = iota	// 7, 恢复计数
		i			// 8		
	)
	
	println(a,b,c,d,e,f,g,h,i)
}