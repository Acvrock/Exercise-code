package main

import "rect"

func main() {
	goku := new(rect.Saiyan)
	goku.Name = "goku"
	goku.Power = 9001
	println(goku.Power)

	//对比

	goku1 := &rect.Saiyan{
		Name:  "goku",
		Power: 9000,
	}
	println(goku1.Power)
}
