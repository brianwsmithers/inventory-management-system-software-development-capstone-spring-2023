function queryTable(){
    //assign values from the HTML inputs and assign elements from HTML document
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchField");
    filter = input.value.toUpperCase();
    table = document.getElementById("productList");
    tr = table.getElementsByTagName("tr");

    //loop through rows in table to find cell with a matching value to the filter var
    for(i = 0; i < tr.length; i++){
        td = tr[i].getElementsByTagName("td")[0];
        if(td){
            txtValue = td.textContent || td.innerText;
            if(txtValue.toUpperCase().indexOf(filter) > -1){
                tr[i].style.display = ""; //shows 
            }
            else{
                tr[i].style.display = "none";
            }
        }
    }
}

function addRow(){
    //creates variables to store values from form to be added to a new row
    var table = document.getElementById("productList");
    var prodId = document.getElementById("productIdField").value;
    var prodDesc = document.getElementById("productDescField").value;
    var curStock = document.getElementById("currentStockField").value;
    var soQty = document.getElementById("soQuantityField").value;
    var poQty = document.getElementById("poQuantityField").value;

    //creates new row at last position of table
    var row = table.insertRow(-1);

    //creating new cells in the table entry
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);

    //inserts form values into row cells
    cell1.appendChild(document.createTextNode(prodId));
    cell2.appendChild(document.createTextNode(prodDesc));
    cell3.appendChild(document.createTextNode(curStock));
    cell4.appendChild(document.createTextNode(soQty));
    cell5.appendChild(document.createTextNode(poQty));
}

function removeRow(){
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("removalId");
    filter = input.value.toUpperCase();
    table = document.getElementById("productList");
    tr = table.getElementsByTagName("tr");

    for(i = 0; i < tr.length; i++){
        td = tr[i].getElementsByTagName("td")[0];
        if(td){
            txtValue = td.textContent || td.innerText;
            if(txtValue.toUpperCase().indexOf(filter) > -1){
                // table.deleteRow(i);
                tr[i].style.display = "none";
                // setTimeout(1000);
                // console.log("Row has been hidden.");
            }
            else{
                tr[i].style.display = "";
            }   
            
        }
    }
}