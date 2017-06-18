package main

import "fmt"

func main() {
	var power int
	power = 9000
	fmt.Printf("It's over 0 %d\n",power)

	var power1 int = 9000
	fmt.Printf("It's over 1 %d\n",power1)

	power2 := 9000
	fmt.Printf("It's over 2 %d\n",power2)

	power3 := getPower()
	fmt.Printf("It's over 3 %d\n",power3)


	name, power := "Goku", 9001
	fmt.Printf("%s's power is over %d\n", name, power)

}
func getPower() int {
	return 9001
}