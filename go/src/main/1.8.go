package main

import (
	"fmt"
	"os"
)

func main() {
	log("hello log")
	fmt.Println("1+2 = %d", add(1, 2))
	value, exists := power("power")
	if exists == false {
		fmt.Println("error");
		os.Exit(1)
	}
	fmt.Printf("value %d", value)

	_, exists1 := power("goku")
	if exists1 == false {
		// 处理出错情况
	}
}

func log(message string) {
	fmt.Println(message)
}

func add(a int, b int) int {
	return a + b
}

func power(name string) (int, bool) {
	return 0, true
}

func add1(a, b int) int {
	return a + b
}
