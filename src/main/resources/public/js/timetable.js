function renderMonth() {
    var days_of_month = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31];
    getTitleRow();
    days_of_month.forEach(getRow);
}

function getTitleRow(){
    const column_headings = ["Day", "Fajr", "Dhuhr", "Asr", "Maghrib", "Isha"];

    var list_item = document.createElement('li');
    list_item.className = "list-group-item";
    var div_row = document.createElement('div');
    div_row.className = "row";
    
    for (const title of column_headings){
	var heading_paragraph = document.createElement('h5');
    	heading_paragraph.innerHTML = title;
	heading_paragraph.setAttribute("style", "text-align:center;");
    	var title_column = addColumn(heading_paragraph);
        div_row.appendChild(title_column);
    }
    list_item.appendChild(div_row);
    var timetable_list_group = document.getElementById('list-group');
    timetable_list_group.appendChild(list_item);
}

function getRow(value, index, array) {
    var list_item = document.createElement('li');
    list_item.className = "list-group-item";
    var div_row = document.createElement('div');
    div_row.className = "row";
    var day_of_month_paragraph = document.createElement('p');
    day_of_month_paragraph.innerHTML = value;
    day_of_month_paragraph.setAttribute("style", "text-align:center;");
    var column_for_day_of_month = addColumn(day_of_month_paragraph);
    div_row.appendChild(column_for_day_of_month);
    const select_types = ["fajr", "dhuhr", "asr", "maghrib", "isha"];
    for (const select_type of select_types) {
	var prayer_time = getTimePicker(value, select_type);
    	var a_column = addColumn(prayer_time);
	div_row.appendChild(a_column);
    }
    list_item.appendChild(div_row);
    var timetable_list_group = document.getElementById('list-group');
    timetable_list_group.appendChild(list_item);
}

function addColumn(child_element) {
    var column_element = document.createElement('div');
    column_element.className = "col";
    column_element.appendChild(child_element);
    return column_element;
}

function getTimePicker(day_of_month, select_type){
    var time_picker = document.createElement('div');
    time_picker.className = "row";
    var hour_select_element = getHour(day_of_month, select_type);
    var hour_column = addColumn(hour_select_element);
    var minute_select_element = getMinute(day_of_month, select_type);
    var minute_column = addColumn(minute_select_element);
    time_picker.appendChild(hour_column);
    time_picker.appendChild(minute_column);
    return time_picker;
}

function getHour(day_of_month, select_type) {
    const hours = ["00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"];

    return getSelectElement(hours, day_of_month, select_type);
}

function getMinute(day_of_month, select_type) {
    const minutes = ["00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"];

    return getSelectElement(minutes, day_of_month, select_type);
}

function getSelectElement(arrayOfOptions, day_of_month, select_type) {
    var select_element = document.createElement('select');
    select_element.className = "form-select";
    select_element.setAttribute('id', select_type + '-select-' + day_of_month);

    for (const a_option of arrayOfOptions) {
        var option_element = document.createElement('option');
        option_element.innerHTML = a_option;
        option_element.value = a_option;
        select_element.appendChild(option_element);
    }
    return select_element;
}
