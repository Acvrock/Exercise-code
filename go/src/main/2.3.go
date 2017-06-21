package main

import "rect"

func main() {
	saiyan := NewSaiyan("hello", 1)
	//print(saiyan.Name)
	print(saiyan)
}

func NewSaiyan(name string, power int) *rect.Saiyan {
	return &rect.Saiyan{
		Name: name,
		Power: power,
	}
}

func NewSaiyan1(name string, power int) rect.Saiyan {
	return rect.Saiyan{
		Name: name,
		Power: power,
	}
}