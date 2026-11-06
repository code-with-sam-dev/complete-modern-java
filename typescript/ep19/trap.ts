const basket: string[] = ["Bread", "Milk", "Eggs"];
const index = basket.indexOf("Rice");
console.log(index);
basket.splice(index, 1);
console.log(basket);
