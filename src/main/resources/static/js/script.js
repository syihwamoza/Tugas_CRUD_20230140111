const api = "http://localhost:8080/ktp"


$(document).ready(function(){

loadData()

})


function loadData(){

$.ajax({

url: api,
method: "GET",

success: function(data){

let html=""

data.forEach(function(item){

html += `
<tr>

<td>${item.id}</td>
<td>${item.nomorKtp}</td>
<td>${item.namaLengkap}</td>
<td>${item.alamat}</td>
<td>${item.tanggalLahir}</td>
<td>${item.jenisKelamin}</td>

<td>

<button onclick="editData(${item.id},'${item.nomorKtp}','${item.namaLengkap}','${item.alamat}','${item.tanggalLahir}','${item.jenisKelamin}')">Edit</button>

<button onclick="hapusData(${item.id})">Hapus</button>

</td>

</tr>
`

})

$("#dataKtp").html(html)

}

})

}



function tambahData(){

let data={

nomorKtp:$("#nomorKtp").val(),
namaLengkap:$("#namaLengkap").val(),
alamat:$("#alamat").val(),
tanggalLahir:$("#tanggalLahir").val(),
jenisKelamin:$("#jenisKelamin").val()

}

$.ajax({

url:api,
method:"POST",
contentType:"application/json",
data:JSON.stringify(data),

success:function(){

alert("Data berhasil ditambahkan")

resetForm()

loadData()

}

})

}



function editData(id,ktp,nama,alamat,tgl,jk){

$("#id").val(id)
$("#nomorKtp").val(ktp)
$("#namaLengkap").val(nama)
$("#alamat").val(alamat)
$("#tanggalLahir").val(tgl)
$("#jenisKelamin").val(jk)

}



function updateData(){

let id=$("#id").val()

let data={

nomorKtp:$("#nomorKtp").val(),
namaLengkap:$("#namaLengkap").val(),
alamat:$("#alamat").val(),
tanggalLahir:$("#tanggalLahir").val(),
jenisKelamin:$("#jenisKelamin").val()

}

$.ajax({

url:api+"/"+id,
method:"PUT",
contentType:"application/json",
data:JSON.stringify(data),

success:function(){

alert("Data berhasil diupdate")

resetForm()

loadData()

}

})

}



function hapusData(id){

if(confirm("Yakin ingin menghapus data?")){

$.ajax({

url:api+"/"+id,
method:"DELETE",

success:function(){

alert("Data berhasil dihapus")

loadData()

}

})

}

}



function resetForm(){

$("#id").val("")
$("#nomorKtp").val("")
$("#namaLengkap").val("")
$("#alamat").val("")
$("#tanggalLahir").val("")
$("#jenisKelamin").val("")

}