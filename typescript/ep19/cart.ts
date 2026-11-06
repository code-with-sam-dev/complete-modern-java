const basket: string[] = [];
basket.push("Bread");
basket.push("Milk");
basket.push("Eggs");
console.log(basket);
console.log(basket.length);
const index = basket.indexOf("Milk");
if (index !== -1) {
    basket.splice(index, 1);
}
console.log(basket);
console.log(basket.includes("Milk"));
console.log(basket[5]);
