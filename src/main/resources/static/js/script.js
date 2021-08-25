// append row to the HTML table
function appendRow() {
    var tbl = document.getElementById('myTableBody'), // table reference
        row = tbl.insertRow(tbl.rows.length),      // append table row
        i;
    // insert table cells to the new row
    for (i = 0; i < tbl.rows[0].cells.length; i++) {
        createCell(row.insertCell(i));
    }
}
 
// create DIV element and append to the table cell
function createCell(cell) {
    var div = document.createElement('input'); // create DIV element
    cell.appendChild(div)
}

// append column to the HTML table
function appendColumn() {
    var tbl = document.getElementById('myTableBody'), // table reference
        i;
    var theadRow = document.getElementById("myTableTheadRow");
    var numberCell = theadRow.cells.length;
    var cel = theadRow.insertCell(numberCell);
    cel.innerHTML = String(numberCell);
    
    
    // open loop for each row and append cell
    for (i = 0; i < tbl.rows.length; i++) {

        createCell(tbl.rows[i].insertCell(tbl.rows[i].cells.length));
    }
    
}

// delete table rows with index greater then 0
function deleteRows() {
    var tbl = document.getElementById('myTableBody'), // table reference
        lastRow = tbl.rows.length - 1,             // set the last row index
        i;
    // delete rows with index greater then 0
    for (i = lastRow; i > 0; i--) {
        tbl.deleteRow(i);
    }
}
 
// delete table columns with index greater then 0
function deleteColumns() {
    var tbl = document.getElementById('myTableBody'), // table reference
        lastCol = tbl.rows[0].cells.length - 1,    // set the last column index
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
            dict[j] = tbody.rows[i].cells[j].childNodes[0].value;
        }
        console.log(dict)
        myRows.push(dict)
    }
    console.log("=== Final ===")
    console.log(myRows)
    document.getElementById("Response").value = myRows;



    const myJSON = JSON.stringify(myRows);

    document.getElementById("Response").value = myJSON;
    /*
    var obj = []

    for (i = 0; i < myRows.length; i++){
        var catchArr = []
        for (j = 0; j < myRows[i][0].length; j++){
            catchArr.push(myRows[i]);
            console.log("============= pokus o catch arr ====");
            console.log(catchArr[0][0][j]);
        }
    }
    
    const myJSON = JSON.stringify(obj);
    
    document.getElementById("Response").value = myJSON;*/
    
}
