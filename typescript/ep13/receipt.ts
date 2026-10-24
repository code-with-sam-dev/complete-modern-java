function printLine(): void {
    console.log("----------");
}
function printCustomLine(symbol: string): void {
    console.log(symbol);
}
function lineTotal(quantity: number, priceCents: number): number {
    return quantity * priceCents;
}
printLine();
printCustomLine("==========");
const breadTotal: number = lineTotal(2, 150);
const milkTotal: number = lineTotal(1, 99);
console.log(breadTotal + milkTotal);