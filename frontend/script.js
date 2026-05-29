async function addEmployee() {

    const employee = {

        name: document.getElementById("name").value,
        age: document.getElementById("age").value,
        salary: document.getElementById("salary").value
    };

    await fetch("http://localhost:8080/add", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(employee)
    });

    alert("Employee Added");
}

async function loadEmployees() {

    const response =
        await fetch("http://localhost:8080/employees");

    const data = await response.json();

    let output = "";

    data.forEach(emp => {
        output += `<p>${emp}</p>`;
    });

    document.getElementById("output").innerHTML = output;
}