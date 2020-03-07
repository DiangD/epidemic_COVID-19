
function getProvinceAndIdList() {
    $.ajax({
        type:'GET',
        url:'/getProvinceNameAndIdList',
        dataType:'JSON',
        success:function (data) {
            putData(data.body);
        },
        error:function (data) {
            alert(data.message)
        }
    })
}

function putData(map) {
    var provinceNameAndIdList = $("#provinceNameAndIdList");
    provinceNameAndIdList.empty();
    for (var key in map) {
        var str = '<li><a class="am-btn am-btn-link" style="color: #0e90d2" href="/province/'+map[key]+'">'+key+'</a></li>';
        provinceNameAndIdList.append(str);
    }
}
$("#province-list").click(function () {
    getProvinceAndIdList();
});


//echarts字体大小设置方法
setFontSize = function (size) {
    var windowWidth = document.body.clientWidth
    if (windowWidth > 1024 && windowWidth < 4000) {
        return size * windowWidth / 1920;
    } else if (windowWidth <= 800) {
        return size * windowWidth / 600;
    } else if (windowWidth < 1024) {
        return size * windowWidth / 800;
    } else if (windowWidth === 1024) {
        return size * windowWidth / 1366;
    } else if (windowWidth >= 4000) {
        return size * windowWidth / 1600;
    }
};
