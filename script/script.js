 const API_URL = "http://localhost:8080/api/students";

    document.addEventListener("DOMContentLoaded", loadStudents);

    // Load All Students
    function loadStudents() {
        fetch(`${API_URL}/getstudent`)
            .then(res => res.json())
            .then(data => {
                let table = document.getElementById("studentTableBody");
                table.innerHTML = "";

                data.forEach(st => {
                    table.innerHTML += `
                        <tr>
                            <td>${st.id}</td>
                            <td>${st.name}</td>
                            <td>${st.email}</td>
                            <td>${st.age}</td>
                            <td>${st.course}</td>
                            <td>
                                
                                <button class="btn btn-warning btn-sm" onclick="editStudent(${st.id})">Edit</button>
                                <button class="btn btn-danger btn-sm" onclick="deleteStudent(${st.id})">Delete</button>
                            </td>
                        </tr>
                    `;
                });
            });
    }



    // Add Student
    function addStudent() {
        let name = document.getElementById("addName").value;
        let email = document.getElementById("addEmail").value;
        let age = document.getElementById("addAge").value;
        let course = document.getElementById("addCourse").value;

        if (!name || !email || !age || !course) {
            alert("Please fill all fields!");
            return;
        }

        fetch(`${API_URL}/addstudent`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name, email, age, course })
        })
        .then(res => res.json())
        .then(() => {
            alert("Student Added Successfully!");
            loadStudents();
        });
    }



    // Search Student by ID
    function searchStudent() {
        let id = document.getElementById("searchId").value;

        fetch(`${API_URL}/search?id=${id}`)
            .then(res => {
                if (!res.ok) throw new Error("Not Found");
                return res.json();
            })
            .then(st => {
                document.getElementById("searchResult").style.display = "block";
                document.getElementById("searchError").style.display = "none";

                document.getElementById("sId").innerText = st.id;
                document.getElementById("sName").innerText = st.name;
                document.getElementById("sEmail").innerText = st.email;
                document.getElementById("sAge").innerText = st.age;
                document.getElementById("sCourse").innerText = st.course;
            })
            .catch(() => {
                document.getElementById("searchResult").style.display = "none";
                document.getElementById("searchError").style.display = "block";
            });
    }



    // View Student
    /*function viewStudent(id) {
        fetch(`${API_URL}/${id}`)
            .then(res => res.json())
            .then(st => {
                alert(
                    `ID: ${st.id}\n` +
                    `Name: ${st.name}\n` +
                    `Email: ${st.email}\n` +
                    `Age: ${st.age}\n` +
                    `Course: ${st.course}`
                );
            });
    }*/



    // Edit Student
    function editStudent(id) {
        let name = prompt("Enter new name:");
        let email = prompt("Enter new email:");
        let age = prompt("Enter new age:");
        let course = prompt("Enter new course:");

        if (!name || !email || !age || !course) {
            alert("All fields required!");
            return;
        }

        fetch(`${API_URL}/updatestudent/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name, email, age, course })
        })
            .then(res => res.json())
            .then(() => {
                alert("Student updated!");
                loadStudents();
            });
    }



    // Delete Student
    function deleteStudent(id) {
        if (!confirm("Delete this student?")) return;

        fetch(`${API_URL}/deletestudent/${id}`, { method: "DELETE" })
            .then(() => {
                alert("Student deleted!");
                loadStudents();
            });
    }