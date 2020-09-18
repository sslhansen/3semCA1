function getTableHeader() {
    return "<thead><tr><th scope=\"col\">Id</th><th scope=\"col\">Year</th><th scope=\"col\">Make</th><th scope=\"col\">Model</th><th scope=\"col\">Price</th></tr></thead><tbody>";
}

function getTableRow(car) {
    return `<tr><td scope="row">${car.id}</td><td scope="row">${car.year}</td><td>${car.make}</td><td>${car.model}</td><td>${car.price}</td></tr>`;
}

function fetchAllCars() {
    let url = "https://svendbentsballonshow.dk/ca1/api/car/all";
    fetch(url)
            .then(res => res.json())
            .then(data => {
                let carTable = document.getElementById("carAllTable");
                let result = "";
                data.forEach((x) => {
                    result += getTableRow(x)
                });
                carTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}

fetchAllCars()

function sortCarsByYear() {
    let url = "https://svendbentsballonshow.dk/ca1/api/car/all";
    fetch(url)
            .then(res => res.json())
            .then(data => {
                let carTable = document.getElementById("carAllTable");
                let result = "";
                data.sort((a, b) => (a.year > b.year) ? 1 : -1)
                data.forEach((x) => {
                    result += getTableRow(x)
                });
                carTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}

function sortCarsByMake() {
    let url = "https://svendbentsballonshow.dk/ca1/api/car/all";
    fetch(url)
            .then(res => res.json())
            .then(data => {
                let carTable = document.getElementById("carAllTable");
                let result = "";
                data.sort((a, b) => (a.make > b.make) ? 1 : -1)
                data.forEach((x) => {
                    result += getTableRow(x)
                });
                carTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}

function sortCarsByModel() {
    let url = "https://svendbentsballonshow.dk/ca1/api/car/all";
    fetch(url)
            .then(res => res.json())
            .then(data => {
                let carTable = document.getElementById("carAllTable");
                let result = "";
                data.sort((a, b) => (a.model > b.model) ? 1 : -1)
                data.forEach((x) => {
                    result += getTableRow(x)
                });
                carTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}


function sortCarsByPrice() {
    let url = "https://svendbentsballonshow.dk/ca1/api/car/all";
    fetch(url)
            .then(res => res.json())
            .then(data => {
                let carTable = document.getElementById("carAllTable");
                let result = "";
                data.sort((a, b) => (a.price > b.price) ? 1 : -1)
                data.forEach((x) => {
                    result += getTableRow(x)
                });
                carTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}


function filterCarsByPrice() {
    let url = "https://svendbentsballonshow.dk/ca1/api/car/all";
    fetch(url)
            .then(res => res.json())
            .then(data => {
                let carTable = document.getElementById("carAllTable");
                let result = "";
                let maxPrice = document.getElementById("maxPrice");
                data.filter(n => n.price < maxPrice);
                data.forEach((x) => {
                    result += getTableRow(x)
                });
                carTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}



document.getElementById("carsSortYearBtn").addEventListener("click", sortCarsByYear);
document.getElementById("carsSortMakeBtn").addEventListener("click", sortCarsByMake);
document.getElementById("carsSortModelBtn").addEventListener("click", sortCarsByModel);
document.getElementById("carsSortPriceBtn").addEventListener("click", sortCarsByPrice);
document.getElementById("filterPriceBtn").addEventListener("click", filterCarsByPrice);

