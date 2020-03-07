$("#btn-province-currentConfirm").addClass("am-active");
$("#btn-table-confirmedIncr").addClass("am-active");
resizeAll();
var provinceEpidemic = echarts.init(document.getElementById('province-map-container'));
var provinceTable = echarts.init(document.getElementById('province-table-container'));
provinceEpidemic.hideLoading();

getEpidemicProvinceMap(provinceId, provinceShortName, "currentConfirmedCount", '当前现有确诊病例数，排除治愈、死亡');
getEpidemicProvinceTable('confirmedIncr');

function getEpidemicProvinceMap(provinceId, provinceShortName, type, title) {
    $.ajax({
        type: 'GET',
        url: '/province/' + provinceId + '/' + type,
        dataType: 'JSON',
        success: function (data) {
            var option = {
                backgroundColor: 'rgba(17,17,17,0)',
                title: {
                    text: title,
                    x: 'center',
                    textStyle: {
                        fontSize: setFontSize(20),
                        color: '#2a2e30'
                    },
                },
                tooltip: {
                    formatter: function (params, ticket, callback) {
                        return params.seriesName + '<br />' + params.name + '：' + params.value
                    }//数据格式化
                },
                visualMap: {
                    min: 0,
                    max: 10000,
                    pieces: [
                        {gte: 10000},            // (1500, Infinity]
                        {gte: 1000, lte: 9999},  // (310, 1000]
                        {gte: 100, lte: 999},   // (200, 300]
                        {gte: 10, lte: 99},
                        {gte: 1, lte: 9},
                        {lte: 0}
                    ],
                    textStyle: {
                        color: '#000'
                    },
                    align: 'auto',
                    type: 'piecewise',    //是否连续
                    left: 'left',
                    top: 'bottom',
                    inRange: {
                        color: ['#fff', '#e0953c', '#b83429', '#572529'],
                    },
                    show: true, //图注
                    showLabel: true
                },
                geo: {
                    map: provinceShortName,
                    roam: false,
                    zoom: 1.23,
                    label: {
                        normal: {
                            show: true,
                            fontSize: setFontSize(14),
                            color: 'rgba(42,46,48,0.7)'
                        }
                    },
                    itemStyle: {
                        normal: {
                            borderColor: 'rgba(0, 0, 0, 0.2)'
                        },
                        emphasis: {
                            areaColor: '#F3B329',
                            shadowOffsetX: 0,
                            shadowOffsetY: 0,
                            shadowBlur: 20,
                            borderWidth: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                },
                series: [
                    {
                        name: '确诊人数',
                        type: 'map',
                        geoIndex: 0,
                        data: data.body
                    }
                ]
            };
            provinceEpidemic.setOption(option);
        },
        error: function (data) {
            alert(data.message);
        }
    })
}

$("#btn-province-currentConfirm").click(function () {
    $("#btn-province-confirm").removeClass("am-active");
    $("#btn-province-currentConfirm").addClass("am-active");
    getEpidemicProvinceMap(provinceId, provinceShortName, "currentConfirmedCount", '当前现有确诊病例数，排除治愈、死亡');
});
$("#btn-province-confirm").click(function () {
    $("#btn-province-currentConfirm").removeClass("am-active");
    $("#btn-province-confirm").addClass("am-active");
    getEpidemicProvinceMap(provinceId, provinceShortName, "confirmedCount", '累计确诊病例数，不排除治愈、死亡');
});
getEpidemicProvinceTable('confirmedIncr');


function getEpidemicProvinceTable(type) {
    $.ajax({
        type: 'GET',
        url: '/province/table/' + provinceId + '/' + type,
        dataType: 'JSON',
        success: function (data) {
            var map = data.body;
            if (type === 'confirmedIncr') {
                var tableOptionConfirmedIncr = {
                    title: {
                        text: '新增确诊趋势',
                        textStyle: {
                            fontSize: setFontSize(20),
                            color: '#2a2e30'
                        },
                    },
                    //工具箱
                    //保存图片
                    toolbox: {
                        show: true,
                        feature: {
                            saveAsImage: {
                                show: true
                            }
                        }
                    },

                    tooltip: {
                        show: true,
                        trigger: 'axis'

                    },
                    //图例-每一条数据的名字叫销量
                    legend: {
                        data: ['新增确认']
                    },
                    grid: {show:'true',borderWidth:'0',height:"70%",width:"85%",x:"14%"},
                    //x轴
                    xAxis: {
                        name: '日期',
                        type: 'category',
                        axisLine: {
                            show: true
                        },
                        axisTick: {
                            show: false,
                            interval: 'auto',
                        },
                        nameLocation: 'start',
                        data: getKeys(map)
                    },
                    //y轴没有显式设置，根据值自动生成y轴
                    yAxis: {
                        name: '单位：例',
                        type: 'value',
                        axisLine: {
                            show: true
                        },
                        axisTick: {
                            show: false,
                            interval: '2',
                        },
                    },
                    itemStyle: {
                        color: '#183cc1'
                    },
                    lineStyle: {
                        color: '#183cc1'
                    },
                    //数据-data是最终要显示的数据
                    series: [{
                        name: '新增确认',
                        itemStyle: {
                            color: '#183cc1'
                        },
                        lineStyle: {
                            color: '#183cc1'
                        },
                        smooth: true,
                        type: 'line',
                        data: getValues(map)
                    }]
                };
                provinceTable.setOption(tableOptionConfirmedIncr, true);
            } else if (type === 'confirmedCount') {
                var tableOptionConfirmedCount = {
                    title: {
                        text: '累计确诊趋势',
                        textStyle: {
                            fontSize: setFontSize(20),
                            color: '#2a2e30'
                        },
                    },
                    //工具箱
                    //保存图片
                    toolbox: {
                        show: true,
                        feature: {
                            saveAsImage: {
                                show: true
                            }
                        }
                    },

                    tooltip: {
                        show: true,
                        trigger: 'axis'

                    },
                    //图例-每一条数据的名字叫销量
                    legend: {
                        data: ['累计确诊']
                    },
                    grid: {show:'true',borderWidth:'0',height:"70%",width:"85%",x:"14%"},
                    //x轴
                    xAxis: {
                        name: '日期',
                        type: 'category',
                        axisLine: {
                            show: true
                        },
                        axisTick: {
                            show: false,
                            interval: '2',
                        },
                        nameLocation: 'start',
                        data: getKeys(map)
                    },
                    //y轴没有显式设置，根据值自动生成y轴
                    yAxis: {
                        name: '单位：例',
                        type: 'value',
                        axisLine: {
                            show: true
                        },
                        axisTick: {
                            show: false,
                            interval: 'auto',
                        },
                    },
                    itemStyle: {
                        color: '#c10b02'
                    },
                    lineStyle: {
                        color: '#c10b02'
                    },
                    //数据-data是最终要显示的数据
                    series: [{
                        name: '累计确诊',
                        itemStyle: {
                            color: '#c10b02'
                        },
                        lineStyle: {
                            color: '#c10b02'
                        },
                        smooth: true,
                        type: 'line',
                        data: getValues(map)
                    }]
                };
                provinceTable.setOption(tableOptionConfirmedCount, true);
            } else if (type === 'curedAndDead') {
                var tableOptionCuredAndDead = {
                    title: {
                        text: '累计治愈/死亡趋势',
                        textStyle: {
                            fontSize: setFontSize(20),
                            color: '#2a2e30'
                        },
                    },
                    //工具箱
                    //保存图片
                    toolbox: {
                        show: true,
                        feature: {
                            saveAsImage: {
                                show: true
                            }
                        }
                    },

                    tooltip: {
                        show: true,
                        trigger: 'axis'

                    },
                    //图例-每一条数据的名字叫销量
                    legend: {
                        data: ['治愈', '死亡']
                    },
                    lineStyle: {
                        color: ['#20c134', '#000000']
                    },
                    itemStyle: {
                        color: ['#20c134', '#000000']
                    },
                    grid: {show:'true',borderWidth:'0',height:"70%",width:"85%",x:"14%"},
                    //x轴
                    xAxis: {
                        name: '日期',
                        type: 'category',
                        axisLine: {
                            show: true
                        },
                        axisTick: {
                            show: false,
                            interval: 'auto',
                        },
                        nameLocation: 'start',
                        data: getKeys(map)
                    },
                    //y轴没有显式设置，根据值自动生成y轴
                    yAxis: {
                        name: '单位：例',
                        type: 'value',
                        nameLocation: 'end',
                        axisLine: {
                            show: true
                        },
                        axisTick: {
                            show: false,
                            interval: '2',
                        },
                    },
                    //数据-data是最终要显示的数据
                    series: [{
                        name: '治愈',
                        itemStyle: {
                            color: '#20c134'
                        },
                        lineStyle: {
                            color: '#20c134'
                        },
                        smooth: true,
                        type: 'line',
                        data: getCuredCount(map)
                    }, {
                        name: '死亡',
                        itemStyle: {
                            color: '#000000'
                        },
                        lineStyle: {
                            color: '#000000'
                        },
                        smooth: true,
                        type: 'line',
                        data: getDeadCount(map)
                    }]
                };
                provinceTable.setOption(tableOptionCuredAndDead, true);
            }

        },
        error: function (data) {
            alert(data.message);
        }
    });
}

$("#btn-table-confirmedIncr").click(function () {
    getEpidemicProvinceTable('confirmedIncr');
    cleanAllSelect();
    $("#btn-table-confirmedIncr").addClass("am-active");
});

$("#btn-table-confirmedCount").click(function () {
    getEpidemicProvinceTable('confirmedCount');
    cleanAllSelect();
    $("#btn-table-confirmedCount").addClass("am-active");
});

$("#btn-table-curedDead").click(function () {
    getEpidemicProvinceTable('curedAndDead');
    cleanAllSelect();
    $("#btn-table-curedDead").addClass("am-active");
});

function getKeys(map) {
    var arr = [];
    for (var key in map) {
        arr.push(key);
    }
    return arr;
}

function getValues(map) {
    var arr = [];
    for (var key in map) {
        arr.push(map[key]);
    }
    return arr;
}

function getCuredCount(map) {
    var arr = [];
    for (var key in map) {
        arr.push(map[key][0]);
    }
    return arr;
}

function getDeadCount(map) {
    var arr = [];
    for (var key in map) {
        arr.push(map[key][1]);
    }
    return arr;
}


function resizeAll() {
    var tableContainer = document.getElementById('province-table-container');
    if (tableContainer.clientWidth > 700) {
        tableContainer.style.height = 560 + 'px';
    } else {
        tableContainer.style.height = tableContainer.clientWidth * 0.85 + 'px';
    }
    clearTimeout(this.timer);
    this.timer = setTimeout(() => {
        provinceTable.resize();
        provinceEpidemic.resize();
    }, 100);
}


window.addEventListener('resize', function () {
    resizeAll();

});

function cleanAllSelect() {
    $("#btn-table-confirmedIncr").removeClass("am-active");
    $("#btn-table-confirmedCount").removeClass("am-active");
    $("#btn-table-curedDead").removeClass("am-active");
}
