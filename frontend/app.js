function getAll(){
    fetch('http://localhost:8000/api/getAll',{
        method: 'GET', // 'GET', 'PUT', 'DELETE', etc.
        headers: new Headers({
            'Content-Type': 'application/json'}),
    })
    .then(function(response){
        return response.json();
    })
    .then(function (staffs){
        console.log(staffs)
        var htmls = staffs.map(function (staff){
            return `<li class="item">
                       <div class="id" id="id">${staff.id}</div>
                       <div class="name">${staff.name}</div>
                        <div class="birthDate">${staff.birthDate}</div>
                        <div class="sex">${staff.sex}</div>
       
                        <button class="delete" onclick="deleteStaff(${staff.id})"> delete</button>
                    </li>`;
        })
        var html = htmls.join('')
        document.getElementById('list-staff').innerHTML = html;
    })
}

function add(){

    const data = {
        "name":"minh",
        "birthDate":"2001-07-15",
        "sex":"male"
    };

    var name = document.getElementById("name").value;
    var birthDate = document.getElementById("birthDate").value;
    var sex = document.getElementById("sex").value;

    if (name!=null&&birthDate!=null&&sex!=null){
        var input = {
            "name" : name.toString(),
            "birthDate" : birthDate.toString(),
            "sex" : sex.toString()
        };

        fetch('http://localhost:8000/api/create', {
            method: 'POST', // or 'PUT'
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(input),
        })
            .then(response => response.json())
            .then(staffs => {
                console.log('Success:', staffs);
                var htmls = staffs.map(function (staff){
                    return `<li class="item">
                       <div class="id" id="id">${staff.id}</div>
                       <div class="name">${staff.name}</div>
                        <div class="birthDate">${staff.birthDate}</div>
                        <div class="sex">${staff.sex}</div>
                        <button class="delete" onclick="deleteStaff(staff.id)"> delete  </button>
                    </li>`;
                })
                var html = htmls.join('')
                console.log("a")
                document.getElementById('list-staff').innerHTML = html;

            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
    getAll();
}

function deleteStaff(id){
    console.log(id)
    fetch('http://localhost:8000/api/delete/'+id, {
        method: 'DELETE', // or 'PUT'
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({id:id}),
    })
        .then(response => response.json())
        .then(resutl=>console.log(resutl))
    document.getElementById('list-staff').innerHTML = "";
C
    console.log("a")
}
