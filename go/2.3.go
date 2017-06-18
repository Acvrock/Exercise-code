package main

func main() {
	saiyan := NewSaiyan("hello", 1)
	//print(saiyan.Name)
	print(saiyan)
}

func NewSaiyan(name string, power int) *Saiyan {
	return &Saiyan{
		Name: name,
		Power: power,
	}
}

// TODO
//func NewSaiyan1(name string, power int) Saiyan {
//	return Saiyan{
//		Name: name,
//		Power: power,
//	}
//}