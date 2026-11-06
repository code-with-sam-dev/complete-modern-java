const prices: number[] = [150, 99, 250];
let total = 0;
for (let i = 0; i < prices.length; i++) {
    total += prices[i];
}
console.log(total);
let sum = 0;
for (const price of prices) {
    sum += price;
}
console.log(sum);
