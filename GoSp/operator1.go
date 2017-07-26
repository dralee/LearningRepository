package main

import "fmt"

const (
	i = 1 << iota
	j = 3 << iota
	k
	l
)

func main(){
	var a int = 21
	var b int = 10
	var c int
	
	c = a + b
	fmt.Printf("第一行c的值为%d\n",c)
	c = a - b
	fmt.Printf("第二行c的值为%d\n",c)
	c = a * b
	fmt.Printf("第三行c的值为%d\n",c)
	c = a / b
	fmt.Printf("第四行c的值为%d\n",c)
	c = a % b
	fmt.Printf("第五行c的值为%d\n",c)
	a++
	fmt.Printf("第六行a的值为%d\n",a)
	a--
	fmt.Printf("第七行a的值为%d\n",a)
}
