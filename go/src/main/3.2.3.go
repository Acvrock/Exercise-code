package main

import "fmt"

func main() {
	scores := make([]int, 0, 10)
	scores = scores[0:6]
	scores[5] = 9033
	fmt.Println(scores)
}
