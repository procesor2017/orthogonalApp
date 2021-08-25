// append row to the HTML table
function appendRow() {
    var tbl = document.getElementById('myTableBody'), 
        row = tbl.insertRow(tbl.rows.length),     
        i;

    for (i = 0; i < tbl.rows[0].cells.length; i++) {
        createCell(row.insertCell(i));
    }
}
 
// create DIV element and append to the table cell
function createCell(cell) {
    var div = document.createElement('input'); 
    cell.appendChild(div)
}

// append column to the HTML table
function appendColumn() {
    var tbl = document.getElementById('myTableBody'), 
        i;
    var theadRow = document.getElementById("myTableTheadRow");
    var numberCell = theadRow.cells.length;
    var cel = theadRow.insertCell(numberCell);
    cel.innerHTML = String(numberCell);
    

    for (i = 0; i < tbl.rows.length; i++) {

        createCell(tbl.rows[i].insertCell(tbl.rows[i].cells.length));
    }
    
}

// delete table rows with index greater then 0
function deleteRows() {
    var tbl = document.getElementById('myTableBody'), 
        lastRow = tbl.rows.length - 1,             
        i;
    // delete rows with index greater then 0
    for (i = lastRow; i > 0; i--) {
        tbl.deleteRow(i);
    }
}
 
// delete table columns with index greater then 0
function deleteColumns() {
    var tbl = document.getElementById('myTableBody'), 
        lastCol = tbl.rows[0].cells.length - 1,    
        i, j;
    // delete cells with index greater then 0 (for each row)
    for (i = 0; i < tbl.rows.length; i++) {
        for (j = lastCol; j > 0; j--) {
            tbl.rows[i].deleteCell(j);
        }
    }
}

function sendData() {
    var myRows = [];
    var tbody = document.getElementById("myTableBody");
    
    for (i = 0; i < tbody.rows.length; i++) {
        var dict = {}
        for (j = 0; j < tbody.rows[0].cells.length; j++){
            if (tbody.rows[i].cells[j].childNodes[0].value != ""){
                dict[j] = tbody.rows[i].cells[j].childNodes[0].value;
            }
        }
        if (Object.keys(dict).length !== 0){
            myRows.push(dict);
        }
    }

    const myJSON = JSON.stringify(myRows);
    document.getElementById("Response").value = myJSON;


    
}
