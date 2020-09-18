function getTableHeader() {
    return "<thead><tr><th scope=\"col\">Id</th><th scope=\"col\">Year</th><th scope=\"col\">Make</th><th scope=\"col\">Model</th><th scope=\"col\">Price</th></tr></thead><tbody>";
}

function getTableRow(car) {
    return `<tr><td scope="row">${car.id}</td><td scope="row">${car.year}</td><td>${car.make}</td><td>${car.model}</td><td>${car.price}</td></tr>`;
}

function fetchAllCars() {
    let url = "https://svendbentsballonshow.dk/ca1/api/car/all";
    fetch(url)
            .then(res => res.json()) //in flow1, just do it
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

function sortAllCars() {
    let url = "https://svendbentsballonshow.dk/ca1/api/car/all";
    fetch(url)
            .then(res => res.json()) //in flow1, just do it
            .then(data => {
                let carTable = document.getElementById("carAllTable");
                let result = "";
                data.sort();
                data.forEach((x) => {
                    result += getTableRow(x)
                });
                carTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}

document.getElementById("carsSortBtn").addEventListener("click", sortAllCars);