package main

import (
	"fmt"
	"rect"
)

func main() {
	scores:= make([]int, 5)
	scores = append(scores,9332)
	fmt.Println(scores)
}

func extractPowers(saiyans []*rect.Saiyan) []int {
	powers := make([]int, len(saiyans))
	for index, saiyan := range saiyans {
		powers[index] = saiyan.Power
	}
	return powers
}

func extractPowers1(saiyans []*rect.Saiyan) []int {
	powers := make([]int, 0, len(saiyans))
	for _, saiyan := range saiyans {
		powers = append(powers, saiyan.Power)
	}
	return powers
}