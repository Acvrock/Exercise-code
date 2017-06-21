package main

import "fmt"

func main() {
	goku := &Saiyan1{"Goku", 9001}
	goku.Super()
	fmt.Println(goku.Power) // 将打印：19001
	goku.SayHello()
}

type Saiyan1 struct {
	Name string
	Power int
}

func (s *Saiyan1) Super() {
	s.Power += 10000
}


func (s *Saiyan1) SayHello() {
	fmt.Println("hello");
}
