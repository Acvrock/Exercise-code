package main

import "rect"

func main() {
	gohan := &rect.Saiyan{
		Name: "Gohan",
		Power: 1000,
		Father: &rect.Saiyan {
			Name: "Goku",
			Power: 9001,
			Father: nil,
		},
	}
	println(gohan);
}
