package main

import "fmt"

const (
	i = 1 << iota
	j = 3 << iota
	k
	l
)

func main(){
	var a int = (3 << 1)
	fmt.Println("a=",a)
	fmt.Println("i=",i)
	fmt.Println("j=",j)
	fmt.Println("k=",k)
	fmt.Println("l=",l)
}

/*
iota表示从0开始自动加1，所以i=1<<0,j=3<<1（<<表示左移的意思），即：i=1,j=6，这没问题，
关键在k和l，从输出结果看，k=3<<2，l=3<<3。
*/