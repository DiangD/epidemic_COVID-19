$("#top-bar-abroad").addClass("am-active");

getCountryStatsByContinents('亚洲');



function putCountryStats(list) {
    var tableBody = $("#country-table-body");
    tableBody.empty();
    for (var i = 0; i < list.length; i++) {
        var str =`<tr>
                                <td>${list[i].provinceName}</td>
                                <td class="data-increase">${list[i].currentConfirmedCount}</td>
                                <td>${list[i].confirmedCount}</td>
                                <td>${list[i].curedCount}</td>
                                <td>${list[i].deadCount}</td>
                            </tr>`;
        tableBody.append(str);
    }
}


function getCountryStatsByContinents(continents) {
    $.ajax({
        type:'GET',
        url:'/country/'+continents,
        dataType:'JSON',
        success:function (data) {
            putCountryStats(data.body)
        },
        error:function (data) {
            alert(data.message);
        }
    });
}



$("#continents-select").change(function () {
    getCountryStatsByContinents($("#continents-select").val());
});
