package main

import "fmt"
func main() {
	goku :=Saiyan{
		Name:"Goku",
		Power:9000,
	}
	fmt.Println("",goku.Name,goku.Power)

	goku1 := Saiyan{}
	fmt.Println("",goku1.Name,goku1.Power)

	// 或者

	goku2 := Saiyan{Name: "Goku"}
	goku2.Power = 9000
	fmt.Println("",goku2.Name,goku2.Power)

	goku3 := Saiyan{"Goku", 9000}
	Super(goku3)
	fmt.Println(goku3.Power)

	goku4 := &Saiyan{"Goku", 9000}
	Super1(goku4)
	fmt.Println(goku4.Power)
}

type Saiyan struct {
	Name string
	Power int
}

func Super(s Saiyan) {
	s.Power += 10000
}
func Super1(s *Saiyan) {
	s.Power += 10000
}

