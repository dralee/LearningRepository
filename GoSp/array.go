package main

import "fmt"

func main() {
	var n [10]int /* n是一个长度为10数组 */
	var i,j int
	
	/* 为数组n初始化元素 */
	for i = 0; i < 10; i++ {
		n[i] = i + 100
	}
	
	/* 输出*/
	for j = 0; j < 10; j++ {
		fmt.Printf("Element[%d] = %d\n", j, n[j])
	}
}
