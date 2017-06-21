package main

import "fmt"
import "rect"
func main() {
	goku :=rect.Saiyan{
		Name:"Goku",
		Power:9000,
	}
	fmt.Println("",goku.Name,goku.Power)

	goku1 := rect.Saiyan{}
	fmt.Println("",goku1.Name,goku1.Power)

	// 或者

	goku2 := rect.Saiyan{Name: "Goku"}
	goku2.Power = 9000
	fmt.Println("",goku2.Name,goku2.Power)

	goku3 := rect.Saiyan{"Goku", 9000}
	Super(goku3)
	fmt.Println(goku3.Power)

	goku4 := &rect.Saiyan{"Goku", 9000}
	Super1(goku4)
	fmt.Println(goku4.Power)
}

func Super(s rect.Saiyan) {
	s.Power += 10000
}
func Super1(s *rect.Saiyan) {
	s.Power += 10000
}

