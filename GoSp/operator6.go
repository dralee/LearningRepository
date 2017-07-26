package main

import "fmt"

func main(){
	var a int = 4
	var b int32
	var c float32
	var ptr *int
	
	fmt.Printf("第1行 a变量类型为 %T\n", a)
	fmt.Printf("第2行 b变量类型为 %T\n", b)
	fmt.Printf("第3行 c变量类型为 %T\n", c)
	
	ptr = &a /* ptr 包含了 a变量的地址 */	
	fmt.Printf("a的值为%d，*ptr为 %d，ptr为%d\n", a, *ptr, ptr)
}
