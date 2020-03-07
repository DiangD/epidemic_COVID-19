$("#top-bar-map").addClass("am-active");
$("#btn-currentConfirm").addClass("am-active");
// '当前现有确诊病例数，排除治愈、死亡'
var chinaEpidemic = echarts.init(document.getElementById('map-container'));
chinaEpidemic.hideLoading();
getEpidemicChinaMap("currentConfirmedCount", '当前现有确诊病例数，排除治愈、死亡');

function getEpidemicChinaMap(type, title) {
    $.ajax({
        type: 'GET',
        url: '/getEpidemicChinaMap/' + type,
        dataType: 'JSON',
        success: function (data) {
            var option = {
                backgroundColor: 'rgba(181,210,252,0.02)',
                title: {
                    text: title,
                    x: 'center',
                    textStyle: {
                        fontSize: setFontSize(18),
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
                    map: 'china',
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
            chinaEpidemic.setOption(option);
        },
        error: function (data) {
            alert(data.message);
        }
    });
}


$("#btn-currentConfirm").click(function () {
    $("#btn-confirm").removeClass("am-active");
    $("#btn-currentConfirm").addClass("am-active");
    getEpidemicChinaMap("currentConfirmedCount", '当前现有确诊病例数，排除治愈、死亡');
});


$("#btn-confirm").click(function () {
    $("#btn-currentConfirm").removeClass("am-active");
    $("#btn-confirm").addClass("am-active");
    getEpidemicChinaMap("confirmedCount", '累计确诊病例数，不排除治愈、死亡');
});
$(window).resize(function () {
    chinaEpidemic.resize();
});









