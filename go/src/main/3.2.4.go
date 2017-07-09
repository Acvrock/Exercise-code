package main

import "fmt"

func main() {
	scores := make([]int, 0, 5)
	c := cap(scores)
	fmt.Println(c)
	for i := 0; i < 25; i++ {
		scores = append(scores, i)
		// 如果容量已经改变，go为了容下这些新数据，不得不增长数组的长度
		if cap(scores) != c {
			c = cap(scores)
			fmt.Println(c)
		}
	}
}