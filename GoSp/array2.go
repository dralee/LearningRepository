package main

import "fmt"

func main() {
	// 5行2列
	var a = [5][2]int{{0,0},{1,2},{2,4},{3,6},{4,8}}
	var i,j int
		
	/* 输出*/
	for i = 0; i < 5; i++ {
		for j = 0; j < 2; j++ {
			fmt.Printf("Element[%d][%d] = %d\n", i,j, a[i][j])
		}
	}
}
