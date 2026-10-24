const totalCents: number = 5240;
const member: boolean = true;
if (totalCents >= 10000) {
    console.log("Free gift");
} else if (totalCents >= 5000 && member) {
    console.log("Free delivery");
} else {
    console.log("Delivery: $4.99");
}