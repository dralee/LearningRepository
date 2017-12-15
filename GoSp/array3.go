package main

import "fmt"

func main() {
	// 5行2列
	var balance = []int{1000,2,3,18,53}
	var avg float32
	
	avg = getAverage(balance, 5)
		
	fmt.Printf("平均值为：%f",avg)
}

func getAverage(arr []int, size int) float32{
	var i,sum int
	for i = 0; i < size; i++ {
		sum += arr[i]
	}
	return float32(sum / size)
}
