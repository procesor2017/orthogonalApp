var i = 3;

//For test
var tabledata = [
 	{"0":"Mysql", "1":"Hibernate", "2":"REST"},
 	{"0":"Oracle", "1":"H2", "2":"RWI"}
 ];

//Build Tabulator
var table = new Tabulator("#example-table", {
    height:"311px",
    addRowPos:"bottom",
    data:tabledata,
    columns:[
        {title:"0", field:"0", width:200, editor:"input"},
        {title:"1", field:"1", width:200, editor:"input"},
        {title:"2", field:"2", width:200, editor:"input"}
    ],
});

//Build others table
var resTable = new Tabulator("#results-table", {});

//Add row on "Add Row" button click
document.getElementById("add-row").addEventListener("click", function(){
    table.addRow({});
});

//Add Column on "Add Column" button click
document.getElementById("add-col").addEventListener("click", function(){
    var name = i.toString();
    table.addColumn({title: name, field:name, width:200, editor:"input"});
    i++;
});

//Delete row on "Delete Col" button click
document.getElementById("del-col").addEventListener("click", function(){
    var a = i-1
    var name = a.toString();
    table.deleteColumn(name);
    i--;
});

//Clear table on "Empty the table" button click
document.getElementById("clear").addEventListener("click", function(){
    table.clearData()
});

//Reset table contents on "Reset the table" button click
document.getElementById("reset").addEventListener("click", function(){
    table.setData(tabledata);
});

//Clear table on "Empty the table" button click
document.getElementById("clear-res").addEventListener("click", function(){
  resTable.clearData()
});

//Reset table contents on "Reset the table" button click
document.getElementById("reset-res").addEventListener("click", function(){
  resTable.setData(tabledata);
});


// Send data
async function sendData() {
    const data = table.getData();
    const url = '/table/tryToFind';
    const fetchOptions = {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
        },
    body: JSON.stringify(data)
    };

    const res = await fetch(url, fetchOptions);
    const ret = await res.json();

    //Get data to table
    
    table.addRow({});
    document.getElementById("Response").value = ret.withValueTable[0].length;
    var cellNumber = 0;
    var cellNumber1 = 0;
    
    for(var r=0;r<ret.withValueTable.length;r++){
            resTable.addRow({id:r});
            if (r==0){
                for(var s=0; s<ret.withValueTable[0].length; s++){
                    resTable.addColumn({title:s.toString(), field:cellNumber.toString()});
                    cellNumber++;
                }
            }
    }
    resTable.setData(ret.withValueTable)
  
}
